package io.sentry.transport;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class QueuedThreadPoolExecutor extends ThreadPoolExecutor {
    public final ILogger logger;
    public final int maxQueueSize;
    public final ReusableCountLatch unfinishedTasksCount = new ReusableCountLatch();

    public static final class CancelledFuture<T> implements Future<T> {
        public CancelledFuture() {
        }

        public boolean cancel(boolean z) {
            return true;
        }

        public T get() {
            throw new CancellationException();
        }

        public boolean isCancelled() {
            return true;
        }

        public boolean isDone() {
            return true;
        }

        public T get(long j, TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }

    public QueuedThreadPoolExecutor(int i, int i2, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ILogger iLogger) {
        super(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        this.maxQueueSize = i2;
        this.logger = iLogger;
    }

    private boolean isSchedulingAllowed() {
        return this.unfinishedTasksCount.getCount() < this.maxQueueSize;
    }

    public void afterExecute(Runnable runnable, Throwable th) {
        try {
            super.afterExecute(runnable, th);
        } finally {
            this.unfinishedTasksCount.decrement();
        }
    }

    public Future<?> submit(Runnable runnable) {
        if (isSchedulingAllowed()) {
            this.unfinishedTasksCount.increment();
            return super.submit(runnable);
        }
        this.logger.log(SentryLevel.WARNING, (String) "Submit cancelled", new Object[0]);
        return new CancelledFuture();
    }

    public void waitTillIdle(long j) {
        try {
            this.unfinishedTasksCount.waitTillZero(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            this.logger.log(SentryLevel.ERROR, (String) "Failed to wait till idle", (Throwable) e2);
            Thread.currentThread().interrupt();
        }
    }
}
