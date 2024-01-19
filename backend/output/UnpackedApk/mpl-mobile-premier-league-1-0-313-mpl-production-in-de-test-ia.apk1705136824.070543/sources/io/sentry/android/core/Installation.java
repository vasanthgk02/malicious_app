package io.sentry.android.core;

import android.content.Context;
import java.io.File;
import java.nio.charset.Charset;

public final class Installation {
    public static final String INSTALLATION = "INSTALLATION";
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static String deviceId;

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

    public static synchronized String id(Context context) throws RuntimeException {
        synchronized (Installation.class) {
            if (deviceId == null) {
                File file = new File(context.getFilesDir(), INSTALLATION);
                try {
                    if (!file.exists()) {
                        String writeInstallationFile = writeInstallationFile(file);
                        deviceId = writeInstallationFile;
                        return writeInstallationFile;
                    }
                    deviceId = readInstallationFile(file);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            String str = deviceId;
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        $closeResource(r3, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readInstallationFile(java.io.File r3) throws java.io.IOException {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "r"
            r0.<init>(r3, r1)
            long r1 = r0.length()     // Catch:{ all -> 0x001d }
            int r3 = (int) r1     // Catch:{ all -> 0x001d }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x001d }
            r0.readFully(r3)     // Catch:{ all -> 0x001d }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x001d }
            java.nio.charset.Charset r2 = UTF_8     // Catch:{ all -> 0x001d }
            r1.<init>(r3, r2)     // Catch:{ all -> 0x001d }
            r3 = 0
            $closeResource(r3, r0)
            return r1
        L_0x001d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001f }
        L_0x001f:
            r1 = move-exception
            $closeResource(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.Installation.readInstallationFile(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        $closeResource(r2, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String writeInstallationFile(java.io.File r2) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r2)
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x001e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x001e }
            java.nio.charset.Charset r1 = UTF_8     // Catch:{ all -> 0x001e }
            byte[] r1 = r2.getBytes(r1)     // Catch:{ all -> 0x001e }
            r0.write(r1)     // Catch:{ all -> 0x001e }
            r0.flush()     // Catch:{ all -> 0x001e }
            r1 = 0
            $closeResource(r1, r0)
            return r2
        L_0x001e:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r1 = move-exception
            $closeResource(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.Installation.writeInstallationFile(java.io.File):java.lang.String");
    }
}
