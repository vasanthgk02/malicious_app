package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstrainedExecutorService extends AbstractExecutorService {
    public static final Class<?> TAG = ConstrainedExecutorService.class;
    public final Executor mExecutor;
    public volatile int mMaxConcurrency;
    public final AtomicInteger mMaxQueueSize;
    public final String mName;
    public final AtomicInteger mPendingWorkers;
    public final Worker mTaskRunner;
    public final BlockingQueue<Runnable> mWorkQueue;

    public class Worker implements Runnable {
        public Worker(AnonymousClass1 r2) {
        }

        public void run() {
            AtomicInteger atomicInteger;
            boolean isEmpty;
            try {
                Runnable runnable = (Runnable) ConstrainedExecutorService.this.mWorkQueue.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    FLog.v(ConstrainedExecutorService.TAG, (String) "%s: Worker has nothing to run", (Object) ConstrainedExecutorService.this.mName);
                }
                if (isEmpty) {
                    FLog.v(ConstrainedExecutorService.TAG, (String) "%s: worker finished; %d workers left", (Object) ConstrainedExecutorService.this.mName, (Object) Integer.valueOf(atomicInteger.decrementAndGet()));
                }
            } finally {
                int decrementAndGet = ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (!ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    ConstrainedExecutorService.this.startWorkerIfNeeded();
                } else {
                    FLog.v(ConstrainedExecutorService.TAG, (String) "%s: worker finished; %d workers left", (Object) ConstrainedExecutorService.this.mName, (Object) Integer.valueOf(decrementAndGet));
                }
            }
        }
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i > 0) {
            this.mName = str;
            this.mExecutor = executor;
            this.mMaxConcurrency = i;
            this.mWorkQueue = blockingQueue;
            this.mTaskRunner = new Worker(null);
            this.mPendingWorkers = new AtomicInteger(0);
            this.mMaxQueueSize = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.mWorkQueue.offer(runnable)) {
            int size = this.mWorkQueue.size();
            int i = this.mMaxQueueSize.get();
            if (size > i && this.mMaxQueueSize.compareAndSet(i, size)) {
                FLog.v(TAG, (String) "%s: max pending work in queue = %d", (Object) this.mName, (Object) Integer.valueOf(size));
            }
            startWorkerIfNeeded();
        } else {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
        }
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public final void startWorkerIfNeeded() {
        int i = this.mPendingWorkers.get();
        while (i < this.mMaxConcurrency) {
            int i2 = i + 1;
            if (this.mPendingWorkers.compareAndSet(i, i2)) {
                FLog.v(TAG, (String) "%s: starting worker %d of %d", (Object) this.mName, (Object) Integer.valueOf(i2), (Object) Integer.valueOf(this.mMaxConcurrency));
                this.mExecutor.execute(this.mTaskRunner);
                return;
            }
            FLog.v(TAG, (String) "%s: race in startWorkerIfNeeded; retrying", (Object) this.mName);
            i = this.mPendingWorkers.get();
        }
    }
}
