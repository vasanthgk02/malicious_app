package io.sentry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class SentryExecutorService implements ISentryExecutorService {
    public final ExecutorService executorService;

    public SentryExecutorService(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3.executorService.shutdownNow();
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(long r4) {
        /*
            r3 = this;
            java.util.concurrent.ExecutorService r0 = r3.executorService
            monitor-enter(r0)
            java.util.concurrent.ExecutorService r1 = r3.executorService     // Catch:{ all -> 0x002e }
            boolean r1 = r1.isShutdown()     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x002c
            java.util.concurrent.ExecutorService r1 = r3.executorService     // Catch:{ all -> 0x002e }
            r1.shutdown()     // Catch:{ all -> 0x002e }
            java.util.concurrent.ExecutorService r1 = r3.executorService     // Catch:{ InterruptedException -> 0x0020 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0020 }
            boolean r4 = r1.awaitTermination(r4, r2)     // Catch:{ InterruptedException -> 0x0020 }
            if (r4 != 0) goto L_0x002c
            java.util.concurrent.ExecutorService r4 = r3.executorService     // Catch:{ InterruptedException -> 0x0020 }
            r4.shutdownNow()     // Catch:{ InterruptedException -> 0x0020 }
            goto L_0x002c
        L_0x0020:
            java.util.concurrent.ExecutorService r4 = r3.executorService     // Catch:{ all -> 0x002e }
            r4.shutdownNow()     // Catch:{ all -> 0x002e }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002e }
            r4.interrupt()     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return
        L_0x002e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryExecutorService.close(long):void");
    }

    public Future<?> submit(Runnable runnable) {
        return this.executorService.submit(runnable);
    }

    public SentryExecutorService() {
        this(Executors.newSingleThreadExecutor());
    }
}
