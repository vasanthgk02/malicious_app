package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class Executors {
    public static final Executor DIRECT_EXECUTOR = new Executor() {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };
    public static final Executor MAIN_THREAD_EXECUTOR = new Executor() {
        public final Handler handler = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    };

    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e2) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e2);
        }
    }
}
