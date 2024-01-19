package io.sentry.config;

import io.sentry.ILogger;

public final class FilesystemPropertiesLoader implements PropertiesLoader {
    public final String filePath;
    public final ILogger logger;

    public FilesystemPropertiesLoader(String str, ILogger iLogger) {
        this.filePath = str;
        this.logger = iLogger;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Properties load() {
        /*
            r7 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0037 }
            java.lang.String r2 = r7.filePath     // Catch:{ IOException -> 0x0037 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0037 }
            boolean r2 = r1.isFile()     // Catch:{ IOException -> 0x0037 }
            if (r2 == 0) goto L_0x0036
            boolean r2 = r1.canRead()     // Catch:{ IOException -> 0x0037 }
            if (r2 == 0) goto L_0x0036
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0037 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0037 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0037 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0037 }
            java.util.Properties r1 = new java.util.Properties     // Catch:{ all -> 0x002a }
            r1.<init>()     // Catch:{ all -> 0x002a }
            r1.load(r2)     // Catch:{ all -> 0x002a }
            r2.close()     // Catch:{ IOException -> 0x0037 }
            return r1
        L_0x002a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002c }
        L_0x002c:
            r3 = move-exception
            r2.close()     // Catch:{ all -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch:{ IOException -> 0x0037 }
        L_0x0035:
            throw r3     // Catch:{ IOException -> 0x0037 }
        L_0x0036:
            return r0
        L_0x0037:
            r1 = move-exception
            io.sentry.ILogger r2 = r7.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            java.lang.String r6 = r7.filePath
            r4[r5] = r6
            java.lang.String r5 = "Failed to load Sentry configuration from file: %s"
            r2.log(r3, r1, r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.config.FilesystemPropertiesLoader.load():java.util.Properties");
    }
}
