package lib.android.paypal.com.magnessdk.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import lib.android.paypal.com.magnessdk.b.a;
import lib.android.paypal.com.magnessdk.f;

public final class c {
    public static String a(File file) {
        Class<c> cls = c.class;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile2.length())];
                randomAccessFile2.readFully(bArr);
                String str = new String(bArr, "UTF-8");
                f.a(cls, (Closeable) randomAccessFile2);
                return str;
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = randomAccessFile2;
                try {
                    a.a(cls, 3, (Throwable) e);
                    f.a(cls, (Closeable) randomAccessFile);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    f.a(cls, (Closeable) randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                f.a(cls, (Closeable) randomAccessFile2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            a.a(cls, 3, (Throwable) e);
            f.a(cls, (Closeable) randomAccessFile);
            return "";
        }
    }

    public static boolean a(File file, String str) {
        Class<c> cls = c.class;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes("UTF-8"));
                f.a(cls, (Closeable) fileOutputStream2);
                return true;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    a.a(cls, 3, (Throwable) e);
                    f.a(cls, (Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    f.a(cls, (Closeable) fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                f.a(cls, (Closeable) fileOutputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            a.a(cls, 3, (Throwable) e);
            f.a(cls, (Closeable) fileOutputStream);
            return false;
        }
    }

    public static boolean a(String[] strArr, String str) {
        File file;
        if (!(strArr == null || str == null)) {
            boolean z = !str.isEmpty();
            for (String str2 : strArr) {
                if (z) {
                    file = new File(str2, str);
                } else {
                    file = new File(str2);
                }
                if (file.exists()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.io.File r5) {
        /*
            java.lang.Class<lib.android.paypal.com.magnessdk.a.c> r0 = lib.android.paypal.com.magnessdk.a.c.class
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
        L_0x0012:
            java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x001c }
            if (r5 == 0) goto L_0x002b
            r1.append(r5)     // Catch:{ IOException -> 0x001c }
            goto L_0x0012
        L_0x001c:
            r5 = move-exception
            goto L_0x0022
        L_0x001e:
            r5 = move-exception
            goto L_0x0040
        L_0x0020:
            r5 = move-exception
            r3 = r2
        L_0x0022:
            r4 = -403(0xfffffffffffffe6d, float:NaN)
            r1.append(r4)     // Catch:{ all -> 0x003e }
            r4 = 3
            lib.android.paypal.com.magnessdk.b.a.a(r0, r4, r5)     // Catch:{ all -> 0x003e }
        L_0x002b:
            lib.android.paypal.com.magnessdk.f.a(r0, r3)
            java.lang.String r5 = r1.toString()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            java.lang.String r2 = r1.toString()
        L_0x003d:
            return r2
        L_0x003e:
            r5 = move-exception
            r2 = r3
        L_0x0040:
            lib.android.paypal.com.magnessdk.f.a(r0, r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.a.c.b(java.io.File):java.lang.String");
    }

    public static boolean c(File file) {
        Class<c> cls = c.class;
        try {
            if (file.exists()) {
                a.a(cls, 0, (String) "deleting CachedConfigDataFromDisk");
                return file.delete();
            }
        } catch (Exception e2) {
            a.a(cls, 3, (Throwable) e2);
        }
        return false;
    }
}
