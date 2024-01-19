package com.appsflyer.internal;

import android.net.TrafficStats;
import com.appsflyer.AFLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class k {
    public static k values;
    public Executor AFInAppEventParameterName;
    public final ThreadFactory AFInAppEventType = new ThreadFactory() {
        public final Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() {
                public final void run() {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                    runnable.run();
                }
            });
        }
    };
    public ScheduledExecutorService AFKeystoreWrapper;
    public ScheduledExecutorService valueOf;

    public static void valueOf(ExecutorService executorService) {
        try {
            AFLogger.AFKeystoreWrapper("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.AFKeystoreWrapper("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.AFKeystoreWrapper("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.AFKeystoreWrapper("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.AFKeystoreWrapper("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th;
        }
    }

    public final Executor AFInAppEventType() {
        Executor executor = this.AFInAppEventParameterName;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.AFInAppEventParameterName).isTerminated() || ((ThreadPoolExecutor) this.AFInAppEventParameterName).isTerminating()))) {
            this.AFInAppEventParameterName = Executors.newFixedThreadPool(2, this.AFInAppEventType);
        }
        return this.AFInAppEventParameterName;
    }

    public final ScheduledThreadPoolExecutor AFKeystoreWrapper() {
        ScheduledExecutorService scheduledExecutorService = this.AFKeystoreWrapper;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.AFKeystoreWrapper.isTerminated()) {
            this.AFKeystoreWrapper = Executors.newScheduledThreadPool(2, this.AFInAppEventType);
        }
        return (ScheduledThreadPoolExecutor) this.AFKeystoreWrapper;
    }
}
