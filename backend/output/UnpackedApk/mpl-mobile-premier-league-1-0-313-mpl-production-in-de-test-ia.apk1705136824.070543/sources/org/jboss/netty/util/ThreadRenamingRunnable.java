package org.jboss.netty.util;

import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class ThreadRenamingRunnable implements Runnable {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadRenamingRunnable.class);
    public static volatile ThreadNameDeterminer threadNameDeterminer = ThreadNameDeterminer.PROPOSED;
    public final String proposedThreadName;
    public final Runnable runnable;

    public ThreadRenamingRunnable(Runnable runnable2, String str) {
        if (runnable2 == null) {
            throw new NullPointerException("runnable");
        } else if (str != null) {
            this.runnable = runnable2;
            this.proposedThreadName = str;
        } else {
            throw new NullPointerException("proposedThreadName");
        }
    }

    private String getNewThreadName(String str) {
        String str2;
        try {
            str2 = getThreadNameDeterminer().determineThreadName(str, this.proposedThreadName);
        } catch (Throwable th) {
            logger.warn("Failed to determine the thread name", th);
            str2 = null;
        }
        return str2 == null ? str : str2;
    }

    public static ThreadNameDeterminer getThreadNameDeterminer() {
        return threadNameDeterminer;
    }

    public static void setThreadNameDeterminer(ThreadNameDeterminer threadNameDeterminer2) {
        if (threadNameDeterminer2 != null) {
            threadNameDeterminer = threadNameDeterminer2;
            return;
        }
        throw new NullPointerException("threadNameDeterminer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r1 = r0.getName()
            java.lang.String r2 = r5.getNewThreadName(r1)
            boolean r3 = r1.equals(r2)
            if (r3 != 0) goto L_0x001f
            r0.setName(r2)     // Catch:{ SecurityException -> 0x0017 }
            r2 = 1
            goto L_0x0020
        L_0x0017:
            r2 = move-exception
            org.jboss.netty.logging.InternalLogger r3 = logger
            java.lang.String r4 = "Failed to rename a thread due to security restriction."
            r3.debug(r4, r2)
        L_0x001f:
            r2 = 0
        L_0x0020:
            java.lang.Runnable r3 = r5.runnable     // Catch:{ all -> 0x002b }
            r3.run()     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x002a
            r0.setName(r1)
        L_0x002a:
            return
        L_0x002b:
            r3 = move-exception
            if (r2 == 0) goto L_0x0031
            r0.setName(r1)
        L_0x0031:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.ThreadRenamingRunnable.run():void");
    }
}
