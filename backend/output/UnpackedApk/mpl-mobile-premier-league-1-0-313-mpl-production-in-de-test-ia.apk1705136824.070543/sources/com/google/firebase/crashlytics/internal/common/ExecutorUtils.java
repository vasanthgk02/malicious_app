package com.google.firebase.crashlytics.internal.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {
    public static final long DEFAULT_TERMINATION_TIMEOUT = 2;

    public static void addDelayedShutdownHook(String str, ExecutorService executorService) {
        addDelayedShutdownHook(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static ExecutorService buildSingleThreadExecutorService(String str) {
        ExecutorService newSingleThreadExecutor = newSingleThreadExecutor(getNamedThreadFactory(str), new DiscardPolicy());
        addDelayedShutdownHook(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static ThreadFactory getNamedThreadFactory(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable() {
                    public void onRun() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public static void addDelayedShutdownHook(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        AnonymousClass2 r2 = new BackgroundPriorityRunnable() {
            public void onRun() {
                try {
                    Logger logger = Logger.getLogger();
                    logger.d("Executing shutdown hook for " + str2);
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        Logger logger2 = Logger.getLogger();
                        logger2.d(str2 + " did not shut down in the allocated time. Requesting immediate shutdown.");
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    Logger.getLogger().d(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        };
        runtime.addShutdownHook(new Thread(r2, GeneratedOutlineSupport.outline50("Crashlytics Shutdown Hook for ", str)));
    }
}
