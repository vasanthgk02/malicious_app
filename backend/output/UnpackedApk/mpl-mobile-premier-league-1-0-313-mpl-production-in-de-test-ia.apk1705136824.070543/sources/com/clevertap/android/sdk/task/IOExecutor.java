package com.clevertap.android.sdk.task;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class IOExecutor implements ExecutorService {
    public ExecutorService executorService;
    public final int numCores = Runtime.getRuntime().availableProcessors();

    public IOExecutor() {
        int i = this.numCores;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i * 2, i * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.executorService = threadPoolExecutor;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.executorService.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.executorService.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.executorService.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.executorService.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.executorService.isShutdown();
    }

    public boolean isTerminated() {
        return this.executorService.isTerminated();
    }

    public void shutdown() {
        this.executorService.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.executorService.shutdownNow();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.executorService.submit(callable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.executorService.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.executorService.invokeAny(collection, j, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.executorService.submit(runnable, t);
    }

    public Future<?> submit(Runnable runnable) {
        return this.executorService.submit(runnable);
    }
}
