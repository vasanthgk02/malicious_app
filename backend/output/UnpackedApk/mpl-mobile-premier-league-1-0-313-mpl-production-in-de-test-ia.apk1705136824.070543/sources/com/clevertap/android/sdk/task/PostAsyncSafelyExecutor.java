package com.clevertap.android.sdk.task;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class PostAsyncSafelyExecutor implements ExecutorService {
    public long EXECUTOR_THREAD_ID = 0;
    public ExecutorService executor = Executors.newSingleThreadExecutor();

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.executor.awaitTermination(j, timeUnit);
    }

    public void execute(final Runnable runnable) {
        if (runnable != null) {
            if (Thread.currentThread().getId() == this.EXECUTOR_THREAD_ID) {
                runnable.run();
            } else {
                this.executor.execute(new Runnable() {
                    public void run() {
                        PostAsyncSafelyExecutor.this.EXECUTOR_THREAD_ID = Thread.currentThread().getId();
                        runnable.run();
                    }
                });
            }
        } else {
            throw new NullPointerException("PostAsyncSafelyExecutor#execute: task can't ne null");
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAll: This method is not supported");
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAny: This method is not supported");
    }

    public boolean isShutdown() {
        return this.executor.isShutdown();
    }

    public boolean isTerminated() {
        return this.executor.isTerminated();
    }

    public void shutdown() {
        this.executor.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.executor.shutdownNow();
    }

    public <T> Future<T> submit(final Callable<T> callable) {
        if (callable != null) {
            if (!(Thread.currentThread().getId() == this.EXECUTOR_THREAD_ID)) {
                return this.executor.submit(new Callable<T>() {
                    public T call() throws Exception {
                        PostAsyncSafelyExecutor.this.EXECUTOR_THREAD_ID = Thread.currentThread().getId();
                        return callable.call();
                    }
                });
            }
            try {
                callable.call();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAll: This method is not supported");
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAny: This method is not supported");
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable != null) {
            FutureTask futureTask = new FutureTask(runnable, t);
            execute(futureTask);
            return futureTask;
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
    }

    public Future<?> submit(Runnable runnable) {
        if (runnable != null) {
            FutureTask futureTask = new FutureTask(runnable, null);
            execute(futureTask);
            return futureTask;
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
    }
}
