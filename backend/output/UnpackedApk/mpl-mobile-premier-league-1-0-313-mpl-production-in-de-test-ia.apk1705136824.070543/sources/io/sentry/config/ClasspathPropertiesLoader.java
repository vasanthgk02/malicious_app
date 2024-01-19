package io.sentry.config;

import io.sentry.ILogger;

public final class ClasspathPropertiesLoader implements PropertiesLoader {
    public final ClassLoader classLoader;
    public final String fileName;
    public final ILogger logger;

    public static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public ClasspathPropertiesLoader(String str, ClassLoader classLoader2, ILogger iLogger) {
        this.fileName = str;
        this.classLoader = classLoader2;
        this.logger = iLogger;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        $closeResource(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0028, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        $closeResource(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002c, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Properties load() {
        /*
            r7 = this;
            r0 = 0
            java.lang.ClassLoader r1 = r7.classLoader     // Catch:{ IOException -> 0x0033 }
            java.lang.String r2 = r7.fileName     // Catch:{ IOException -> 0x0033 }
            java.io.InputStream r1 = r1.getResourceAsStream(r2)     // Catch:{ IOException -> 0x0033 }
            if (r1 == 0) goto L_0x002d
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0026 }
            r2.<init>(r1)     // Catch:{ all -> 0x0026 }
            java.util.Properties r3 = new java.util.Properties     // Catch:{ all -> 0x001f }
            r3.<init>()     // Catch:{ all -> 0x001f }
            r3.load(r2)     // Catch:{ all -> 0x001f }
            $closeResource(r0, r2)     // Catch:{ all -> 0x0026 }
            $closeResource(r0, r1)     // Catch:{ IOException -> 0x0033 }
            return r3
        L_0x001f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r4 = move-exception
            $closeResource(r3, r2)     // Catch:{ all -> 0x0026 }
            throw r4     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r3 = move-exception
            $closeResource(r2, r1)     // Catch:{ IOException -> 0x0033 }
            throw r3     // Catch:{ IOException -> 0x0033 }
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            $closeResource(r0, r1)     // Catch:{ IOException -> 0x0033 }
        L_0x0032:
            return r0
        L_0x0033:
            r1 = move-exception
            io.sentry.ILogger r2 = r7.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            java.lang.String r6 = r7.fileName
            r4[r5] = r6
            java.lang.String r5 = "Failed to load Sentry configuration from classpath resource: %s"
            r2.log(r3, r1, r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.config.ClasspathPropertiesLoader.load():java.util.Properties");
    }

    public ClasspathPropertiesLoader(ILogger iLogger) {
        this("sentry.properties", ClasspathPropertiesLoader.class.getClassLoader(), iLogger);
    }
}
