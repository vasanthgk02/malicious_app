package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.NewThreadWorker;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {

    public static final class DisposeTask implements Disposable, Runnable {
        public final Runnable decoratedRun;
        public Thread runner;
        public final Worker w;

        public DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.w = worker;
        }

        public void dispose() {
            if (this.runner == Thread.currentThread()) {
                Worker worker = this.w;
                if (worker instanceof NewThreadWorker) {
                    NewThreadWorker newThreadWorker = (NewThreadWorker) worker;
                    if (!newThreadWorker.disposed) {
                        newThreadWorker.disposed = true;
                        newThreadWorker.executor.shutdown();
                        return;
                    }
                    return;
                }
            }
            this.w.dispose();
        }

        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }
    }

    public static abstract class Worker implements Disposable {
        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public Disposable schedule(Runnable runnable) {
            return schedule(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit);
    }

    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public abstract Worker createWorker();

    public Disposable scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        ObjectHelper.requireNonNull(runnable, "run is null");
        DisposeTask disposeTask = new DisposeTask(runnable, createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }
}
