package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler extends Scheduler {
    public static final RxThreadFactory EVICTOR_THREAD_FACTORY;
    public static final long KEEP_ALIVE_TIME = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
    public static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    public static final CachedWorkerPool NONE;
    public static final ThreadWorker SHUTDOWN_THREAD_WORKER;
    public static final RxThreadFactory WORKER_THREAD_FACTORY;
    public final AtomicReference<CachedWorkerPool> pool = new AtomicReference<>(NONE);
    public final ThreadFactory threadFactory = WORKER_THREAD_FACTORY;

    public static final class CachedWorkerPool implements Runnable {
        public final CompositeDisposable allWorkers;
        public final ScheduledExecutorService evictorService;
        public final Future<?> evictorTask;
        public final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        public final long keepAliveTime;
        public final ThreadFactory threadFactory;

        public CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory2) {
            Future<?> future;
            this.keepAliveTime = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeDisposable();
            this.threadFactory = threadFactory2;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.EVICTOR_THREAD_FACTORY);
                long j2 = this.keepAliveTime;
                future = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                future = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = future;
        }

        public void run() {
            if (!this.expiringWorkerQueue.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator<ThreadWorker> it = this.expiringWorkerQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker next = it.next();
                    if (next.expirationTime > nanoTime) {
                        return;
                    }
                    if (this.expiringWorkerQueue.remove(next) && this.allWorkers.delete(next)) {
                        next.dispose();
                    }
                }
            }
        }
    }

    public static final class EventLoopWorker extends Worker {
        public final AtomicBoolean once = new AtomicBoolean();
        public final CachedWorkerPool pool;
        public final CompositeDisposable tasks;
        public final ThreadWorker threadWorker;

        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            ThreadWorker threadWorker2;
            ThreadWorker threadWorker3;
            this.pool = cachedWorkerPool;
            this.tasks = new CompositeDisposable();
            if (cachedWorkerPool.allWorkers.disposed) {
                threadWorker2 = IoScheduler.SHUTDOWN_THREAD_WORKER;
            } else {
                while (true) {
                    if (cachedWorkerPool.expiringWorkerQueue.isEmpty()) {
                        threadWorker3 = new ThreadWorker(cachedWorkerPool.threadFactory);
                        cachedWorkerPool.allWorkers.add(threadWorker3);
                        break;
                    }
                    threadWorker3 = cachedWorkerPool.expiringWorkerQueue.poll();
                    if (threadWorker3 != null) {
                        break;
                    }
                }
                threadWorker2 = threadWorker3;
            }
            this.threadWorker = threadWorker2;
        }

        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                CachedWorkerPool cachedWorkerPool = this.pool;
                ThreadWorker threadWorker2 = this.threadWorker;
                if (cachedWorkerPool != null) {
                    threadWorker2.expirationTime = System.nanoTime() + cachedWorkerPool.keepAliveTime;
                    cachedWorkerPool.expiringWorkerQueue.offer(threadWorker2);
                    return;
                }
                throw null;
            }
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.tasks.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.threadWorker.scheduleActual(runnable, j, timeUnit, this.tasks);
        }
    }

    public static final class ThreadWorker extends NewThreadWorker {
        public long expirationTime = 0;

        public ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        SHUTDOWN_THREAD_WORKER = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        WORKER_THREAD_FACTORY = new RxThreadFactory("RxCachedThreadScheduler", max);
        EVICTOR_THREAD_FACTORY = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, null, WORKER_THREAD_FACTORY);
        NONE = cachedWorkerPool;
        cachedWorkerPool.allWorkers.dispose();
        Future<?> future = cachedWorkerPool.evictorTask;
        if (future != null) {
            future.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = cachedWorkerPool.evictorService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public IoScheduler() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, this.threadFactory);
        if (!this.pool.compareAndSet(NONE, cachedWorkerPool)) {
            cachedWorkerPool.allWorkers.dispose();
            Future<?> future = cachedWorkerPool.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = cachedWorkerPool.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }
}
