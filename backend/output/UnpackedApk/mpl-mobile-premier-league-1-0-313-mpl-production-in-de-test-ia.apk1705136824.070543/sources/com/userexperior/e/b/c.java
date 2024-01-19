package com.userexperior.e.b;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.picasso.Utils;
import com.userexperior.e.b;
import com.userexperior.e.z;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import sfs2x.client.entities.invitation.InvitationReply;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, d> f3949a;

    /* renamed from: b  reason: collision with root package name */
    public long f3950b;

    /* renamed from: c  reason: collision with root package name */
    public final File f3951c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3952d;

    public c(File file) {
        this.f3949a = new LinkedHashMap(16, 0.75f, true);
        this.f3950b = 0;
        this.f3951c = file;
        this.f3952d = Utils.MIN_DISK_CACHE_SIZE;
    }

    public c(File file, byte b2) {
        this(file);
    }

    public static int a(InputStream inputStream) throws IOException {
        return (e(inputStream) << 24) | (e(inputStream) << 0) | 0 | (e(inputStream) << 8) | (e(inputStream) << 16);
    }

    public static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & InvitationReply.EXPIRED);
        outputStream.write((i >> 8) & InvitationReply.EXPIRED);
        outputStream.write((i >> 16) & InvitationReply.EXPIRED);
        outputStream.write((i >> 24) & InvitationReply.EXPIRED);
    }

    public static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    public static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void a(String str, d dVar) {
        if (!this.f3949a.containsKey(str)) {
            this.f3950b += dVar.f3953a;
        } else {
            this.f3950b = (dVar.f3953a - this.f3949a.get(str).f3953a) + this.f3950b;
        }
        this.f3949a.put(str, dVar);
    }

    public static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    public static long b(InputStream inputStream) throws IOException {
        return ((((long) e(inputStream)) & 255) << 0) | 0 | ((((long) e(inputStream)) & 255) << 8) | ((((long) e(inputStream)) & 255) << 16) | ((((long) e(inputStream)) & 255) << 24) | ((((long) e(inputStream)) & 255) << 32) | ((((long) e(inputStream)) & 255) << 40) | ((((long) e(inputStream)) & 255) << 48) | ((255 & ((long) e(inputStream))) << 56);
    }

    private synchronized void b(String str) {
        boolean delete = d(str).delete();
        d dVar = this.f3949a.get(str);
        if (dVar != null) {
            this.f3950b -= dVar.f3953a;
            this.f3949a.remove(str);
        }
        if (!delete) {
            z.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    public static String c(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    public static String c(String str) {
        int length = str.length() / 2;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(String.valueOf(str.substring(0, length).hashCode()));
        outline73.append(String.valueOf(str.substring(length).hashCode()));
        return outline73.toString();
    }

    private File d(String str) {
        return new File(this.f3951c, c(str));
    }

    public static Map<String, String> d(InputStream inputStream) throws IOException {
        int a2 = a(inputStream);
        Map<String, String> emptyMap = a2 == 0 ? Collections.emptyMap() : new HashMap<>(a2);
        for (int i = 0; i < a2; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    public static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A[SYNTHETIC, Splitter:B:31:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f A[SYNTHETIC, Splitter:B:44:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00aa A[SYNTHETIC, Splitter:B:53:0x00aa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.userexperior.e.c a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.Map<java.lang.String, com.userexperior.e.b.d> r0 = r11.f3949a     // Catch:{ all -> 0x00b1 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x00b1 }
            com.userexperior.e.b.d r0 = (com.userexperior.e.b.d) r0     // Catch:{ all -> 0x00b1 }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r11)
            return r1
        L_0x000e:
            java.io.File r2 = r11.d(r12)     // Catch:{ all -> 0x00b1 }
            r3 = 1
            r4 = 2
            r5 = 0
            com.userexperior.e.b.e r6 = new com.userexperior.e.b.e     // Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
            r8.<init>(r2)     // Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
            r6.<init>(r7, r5)     // Catch:{ IOException -> 0x0085, NegativeArraySizeException -> 0x0063, all -> 0x0060 }
            com.userexperior.e.b.d.a(r6)     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            long r7 = r2.length()     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            int r9 = r6.f3959a     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            long r9 = (long) r9     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            long r7 = r7 - r9
            int r8 = (int) r7     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            byte[] r7 = a(r6, r8)     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            com.userexperior.e.c r8 = new com.userexperior.e.c     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.<init>()     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.f3973a = r7     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            java.lang.String r7 = r0.f3955c     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.f3974b = r7     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            long r9 = r0.f3956d     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.f3975c = r9     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            long r9 = r0.f3957e     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.f3976d = r9     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            long r9 = r0.f3958f     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.f3977e = r9     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            long r9 = r0.g     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.f3978f = r9     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.h     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r8.g = r0     // Catch:{ IOException -> 0x005e, NegativeArraySizeException -> 0x005c }
            r6.close()     // Catch:{ IOException -> 0x005a }
            monitor-exit(r11)
            return r8
        L_0x005a:
            monitor-exit(r11)
            return r1
        L_0x005c:
            r0 = move-exception
            goto L_0x0065
        L_0x005e:
            r0 = move-exception
            goto L_0x0087
        L_0x0060:
            r12 = move-exception
            r6 = r1
            goto L_0x00a8
        L_0x0063:
            r0 = move-exception
            r6 = r1
        L_0x0065:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x00a7 }
            r4[r5] = r2     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a7 }
            r4[r3] = r0     // Catch:{ all -> 0x00a7 }
            com.userexperior.e.z.b(r7, r4)     // Catch:{ all -> 0x00a7 }
            r11.b(r12)     // Catch:{ all -> 0x00a7 }
            if (r6 == 0) goto L_0x0083
            r6.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0083
        L_0x0081:
            monitor-exit(r11)
            return r1
        L_0x0083:
            monitor-exit(r11)
            return r1
        L_0x0085:
            r0 = move-exception
            r6 = r1
        L_0x0087:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x00a7 }
            r4[r5] = r2     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a7 }
            r4[r3] = r0     // Catch:{ all -> 0x00a7 }
            com.userexperior.e.z.b(r7, r4)     // Catch:{ all -> 0x00a7 }
            r11.b(r12)     // Catch:{ all -> 0x00a7 }
            if (r6 == 0) goto L_0x00a5
            r6.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a5
        L_0x00a3:
            monitor-exit(r11)
            return r1
        L_0x00a5:
            monitor-exit(r11)
            return r1
        L_0x00a7:
            r12 = move-exception
        L_0x00a8:
            if (r6 == 0) goto L_0x00b0
            r6.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b0
        L_0x00ae:
            monitor-exit(r11)
            return r1
        L_0x00b0:
            throw r12     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.b.c.a(java.lang.String):com.userexperior.e.c");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:25|26|(2:35|36)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b A[SYNTHETIC, Splitter:B:32:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0067 A[SYNTHETIC, Splitter:B:40:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.File r0 = r8.f3951c     // Catch:{ all -> 0x006f }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x006f }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r8.f3951c     // Catch:{ all -> 0x006f }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006f }
            java.io.File r3 = r8.f3951c     // Catch:{ all -> 0x006f }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006f }
            r2[r1] = r3     // Catch:{ all -> 0x006f }
            com.userexperior.e.z.c(r0, r2)     // Catch:{ all -> 0x006f }
        L_0x0022:
            monitor-exit(r8)
            return
        L_0x0024:
            java.io.File r0 = r8.f3951c     // Catch:{ all -> 0x006f }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r8)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x006f }
        L_0x002f:
            if (r1 >= r2) goto L_0x006d
            r3 = r0[r1]     // Catch:{ all -> 0x006f }
            r4 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0058 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0058 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0058 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0058 }
            com.userexperior.e.b.d r4 = com.userexperior.e.b.d.a(r5)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            long r6 = r3.length()     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r4.f3953a = r6     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.lang.String r6 = r4.f3954b     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r8.a(r6, r4)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r5.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006a
        L_0x0051:
            r0 = move-exception
            r4 = r5
            goto L_0x005f
        L_0x0054:
            r4 = r5
            goto L_0x0059
        L_0x0056:
            r0 = move-exception
            goto L_0x005f
        L_0x0058:
        L_0x0059:
            if (r3 == 0) goto L_0x0065
            r3.delete()     // Catch:{ all -> 0x0056 }
            goto L_0x0065
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r4.close()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            throw r0     // Catch:{ all -> 0x006f }
        L_0x0065:
            if (r4 == 0) goto L_0x006a
            r4.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x006d:
            monitor-exit(r8)
            return
        L_0x006f:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.b.c.a():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:33|34|(1:36)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fd, code lost:
        if (r3.delete() == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ff, code lost:
        com.userexperior.e.z.b("Could not clean up file %s", r3.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010f, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00f9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r20, com.userexperior.e.c r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            monitor-enter(r19)
            byte[] r3 = r2.f3973a     // Catch:{ all -> 0x0110 }
            int r3 = r3.length     // Catch:{ all -> 0x0110 }
            long r4 = r1.f3950b     // Catch:{ all -> 0x0110 }
            long r6 = (long) r3     // Catch:{ all -> 0x0110 }
            long r4 = r4 + r6
            int r3 = r1.f3952d     // Catch:{ all -> 0x0110 }
            long r8 = (long) r3     // Catch:{ all -> 0x0110 }
            r10 = 0
            int r11 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r11 < 0) goto L_0x00bb
            boolean r4 = com.userexperior.e.z.f4034b     // Catch:{ all -> 0x0110 }
            if (r4 == 0) goto L_0x0021
            java.lang.String r4 = "Pruning old cache entries."
            java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x0110 }
            com.userexperior.e.z.a(r4, r5)     // Catch:{ all -> 0x0110 }
        L_0x0021:
            long r4 = r1.f3950b     // Catch:{ all -> 0x0110 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0110 }
            java.util.Map<java.lang.String, com.userexperior.e.b.d> r11 = r1.f3949a     // Catch:{ all -> 0x0110 }
            java.util.Set r11 = r11.entrySet()     // Catch:{ all -> 0x0110 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0110 }
            r12 = 0
        L_0x0032:
            boolean r13 = r11.hasNext()     // Catch:{ all -> 0x0110 }
            r14 = 2
            if (r13 == 0) goto L_0x0090
            java.lang.Object r13 = r11.next()     // Catch:{ all -> 0x0110 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ all -> 0x0110 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ all -> 0x0110 }
            com.userexperior.e.b.d r13 = (com.userexperior.e.b.d) r13     // Catch:{ all -> 0x0110 }
            java.lang.String r15 = r13.f3954b     // Catch:{ all -> 0x0110 }
            java.io.File r15 = r1.d(r15)     // Catch:{ all -> 0x0110 }
            boolean r15 = r15.delete()     // Catch:{ all -> 0x0110 }
            r16 = r4
            if (r15 == 0) goto L_0x005d
            long r3 = r1.f3950b     // Catch:{ all -> 0x0110 }
            r18 = r11
            long r10 = r13.f3953a     // Catch:{ all -> 0x0110 }
            long r3 = r3 - r10
            r1.f3950b = r3     // Catch:{ all -> 0x0110 }
            goto L_0x0074
        L_0x005d:
            r18 = r11
            java.lang.String r3 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r4 = new java.lang.Object[r14]     // Catch:{ all -> 0x0110 }
            java.lang.String r10 = r13.f3954b     // Catch:{ all -> 0x0110 }
            r5 = 0
            r4[r5] = r10     // Catch:{ all -> 0x0110 }
            java.lang.String r10 = r13.f3954b     // Catch:{ all -> 0x0110 }
            java.lang.String r10 = c(r10)     // Catch:{ all -> 0x0110 }
            r11 = 1
            r4[r11] = r10     // Catch:{ all -> 0x0110 }
            com.userexperior.e.z.b(r3, r4)     // Catch:{ all -> 0x0110 }
        L_0x0074:
            r18.remove()     // Catch:{ all -> 0x0110 }
            int r12 = r12 + 1
            long r3 = r1.f3950b     // Catch:{ all -> 0x0110 }
            long r3 = r3 + r6
            float r3 = (float) r3     // Catch:{ all -> 0x0110 }
            int r4 = r1.f3952d     // Catch:{ all -> 0x0110 }
            float r4 = (float) r4     // Catch:{ all -> 0x0110 }
            r10 = 1063675494(0x3f666666, float:0.9)
            float r4 = r4 * r10
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            r4 = r16
            r11 = r18
            r10 = 0
            goto L_0x0032
        L_0x0090:
            r16 = r4
        L_0x0092:
            boolean r3 = com.userexperior.e.z.f4034b     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x00bb
            java.lang.String r3 = "pruned %d files, %d bytes, %d ms"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0110 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0110 }
            r5 = 0
            r4[r5] = r6     // Catch:{ all -> 0x0110 }
            long r6 = r1.f3950b     // Catch:{ all -> 0x0110 }
            long r6 = r6 - r16
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0110 }
            r7 = 1
            r4[r7] = r6     // Catch:{ all -> 0x0110 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0110 }
            long r6 = r6 - r8
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0110 }
            r4[r14] = r6     // Catch:{ all -> 0x0110 }
            com.userexperior.e.z.a(r3, r4)     // Catch:{ all -> 0x0110 }
        L_0x00bb:
            java.io.File r3 = r19.d(r20)     // Catch:{ all -> 0x0110 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00f9 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00f9 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x00f9 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x00f9 }
            com.userexperior.e.b.d r6 = new com.userexperior.e.b.d     // Catch:{ IOException -> 0x00f9 }
            r6.<init>(r0, r2)     // Catch:{ IOException -> 0x00f9 }
            boolean r7 = r6.a(r4)     // Catch:{ IOException -> 0x00f9 }
            if (r7 == 0) goto L_0x00e1
            byte[] r2 = r2.f3973a     // Catch:{ IOException -> 0x00f9 }
            r4.write(r2)     // Catch:{ IOException -> 0x00f9 }
            r4.close()     // Catch:{ IOException -> 0x00f9 }
            r1.a(r0, r6)     // Catch:{ IOException -> 0x00f9 }
            monitor-exit(r19)
            return
        L_0x00e1:
            r4.close()     // Catch:{ IOException -> 0x00f9 }
            java.lang.String r0 = "Failed to write header for %s"
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00f9 }
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x00f9 }
            r5 = 0
            r4[r5] = r2     // Catch:{ IOException -> 0x00f9 }
            com.userexperior.e.z.b(r0, r4)     // Catch:{ IOException -> 0x00f9 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00f9 }
            r0.<init>()     // Catch:{ IOException -> 0x00f9 }
            throw r0     // Catch:{ IOException -> 0x00f9 }
        L_0x00f9:
            boolean r0 = r3.delete()     // Catch:{ all -> 0x0110 }
            if (r0 != 0) goto L_0x010e
            java.lang.String r0 = "Could not clean up file %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0110 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0110 }
            com.userexperior.e.z.b(r0, r2)     // Catch:{ all -> 0x0110 }
        L_0x010e:
            monitor-exit(r19)
            return
        L_0x0110:
            r0 = move-exception
            monitor-exit(r19)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.b.c.a(java.lang.String, com.userexperior.e.c):void");
    }
}
