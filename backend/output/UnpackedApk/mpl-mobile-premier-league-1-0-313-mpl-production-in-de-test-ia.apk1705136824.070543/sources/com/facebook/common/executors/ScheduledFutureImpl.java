package com.facebook.common.executors;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScheduledFutureImpl<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    public final FutureTask<V> mListenableFuture;

    public ScheduledFutureImpl(Handler handler, Callable<V> callable) {
        this.mListenableFuture = new FutureTask<>(callable);
    }

    public boolean cancel(boolean z) {
        return this.mListenableFuture.cancel(z);
    }

    public int compareTo(Object obj) {
        Delayed delayed = (Delayed) obj;
        throw new UnsupportedOperationException();
    }

    public V get() throws InterruptedException, ExecutionException {
        return this.mListenableFuture.get();
    }

    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public boolean isCancelled() {
        return this.mListenableFuture.isCancelled();
    }

    public boolean isDone() {
        return this.mListenableFuture.isDone();
    }

    public void run() {
        this.mListenableFuture.run();
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mListenableFuture.get(j, timeUnit);
    }

    public ScheduledFutureImpl(Handler handler, Runnable runnable, V v) {
        this.mListenableFuture = new FutureTask<>(runnable, v);
    }
}
