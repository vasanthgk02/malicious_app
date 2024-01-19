package org.jboss.netty.util.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ExecutorUtil {
    public static boolean isShutdown(Executor executor) {
        return (executor instanceof ExecutorService) && ((ExecutorService) executor).isShutdown();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[ExcHandler: NullPointerException (unused java.lang.NullPointerException), SYNTHETIC, Splitter:B:13:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void terminate(java.util.concurrent.Executor... r7) {
        /*
            int r0 = r7.length
            java.util.concurrent.Executor[] r1 = new java.util.concurrent.Executor[r0]
            r2 = 0
            r3 = 0
        L_0x0005:
            int r4 = r7.length
            if (r3 >= r4) goto L_0x0021
            r4 = r7[r3]
            if (r4 == 0) goto L_0x0013
            r4 = r7[r3]
            r1[r3] = r4
            int r3 = r3 + 1
            goto L_0x0005
        L_0x0013:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "executors["
            java.lang.String r1 = "]"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline42(r0, r3, r1)
            r7.<init>(r0)
            throw r7
        L_0x0021:
            r7 = 0
        L_0x0022:
            if (r2 >= r0) goto L_0x0044
            r3 = r1[r2]
            boolean r4 = r3 instanceof java.util.concurrent.ExecutorService
            if (r4 != 0) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            java.util.concurrent.ExecutorService r3 = (java.util.concurrent.ExecutorService) r3
        L_0x002d:
            r3.shutdownNow()     // Catch:{ SecurityException -> 0x0031, NullPointerException -> 0x0034 }
            goto L_0x0034
        L_0x0031:
            r3.shutdown()     // Catch:{ SecurityException -> 0x0041, NullPointerException -> 0x0034 }
        L_0x0034:
            r4 = 100
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x003f }
            boolean r4 = r3.awaitTermination(r4, r6)     // Catch:{ InterruptedException -> 0x003f }
            if (r4 == 0) goto L_0x002d
            goto L_0x0041
        L_0x003f:
            r7 = 1
            goto L_0x002d
        L_0x0041:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0044:
            if (r7 == 0) goto L_0x004d
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            r7.interrupt()
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.ExecutorUtil.terminate(java.util.concurrent.Executor[]):void");
    }
}
