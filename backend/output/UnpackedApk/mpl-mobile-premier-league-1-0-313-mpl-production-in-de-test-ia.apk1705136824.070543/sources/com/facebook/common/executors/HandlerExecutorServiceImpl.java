package com.facebook.common.executors;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorServiceImpl extends AbstractExecutorService implements ScheduledExecutorService {
    public final Handler mHandler;

    public HandlerExecutorServiceImpl(Handler handler) {
        this.mHandler = handler;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    public abstract void execute(Runnable runnable);

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new ScheduledFutureImpl(this.mHandler, runnable, obj);
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(this.mHandler, runnable, null);
        this.mHandler.postDelayed(scheduledFutureImpl, timeUnit.toMillis(j));
        return scheduledFutureImpl;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public Future submit(Runnable runnable) {
        if (runnable != null) {
            ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(this.mHandler, runnable, null);
            execute(scheduledFutureImpl);
            return scheduledFutureImpl;
        }
        throw null;
    }

    public RunnableFuture newTaskFor(Callable callable) {
        return new ScheduledFutureImpl(this.mHandler, callable);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(this.mHandler, callable);
        this.mHandler.postDelayed(scheduledFutureImpl, timeUnit.toMillis(j));
        return scheduledFutureImpl;
    }

    public Future submit(Runnable runnable, Object obj) {
        if (runnable != null) {
            ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(this.mHandler, runnable, obj);
            execute(scheduledFutureImpl);
            return scheduledFutureImpl;
        }
        throw null;
    }

    public Future submit(Callable callable) {
        if (callable != null) {
            ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(this.mHandler, callable);
            execute(scheduledFutureImpl);
            return scheduledFutureImpl;
        }
        throw null;
    }
}
