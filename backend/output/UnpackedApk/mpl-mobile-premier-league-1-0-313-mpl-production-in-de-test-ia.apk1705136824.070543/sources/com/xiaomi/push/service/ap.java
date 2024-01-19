package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.g;
import com.xiaomi.push.h;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ap {

    /* renamed from: a  reason: collision with root package name */
    public static long f4858a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4859a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f847a;

        public a(byte[] bArr, int i) {
            this.f847a = bArr;
            this.f4859a = i;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f4860a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f848a;

        public b(Bitmap bitmap, long j) {
            this.f848a = bitmap;
            this.f4860a = j;
        }
    }

    public static int a(Context context, InputStream inputStream) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 48.0f);
        int i = options.outWidth;
        if (i > round) {
            int i2 = options.outHeight;
            if (i2 > round) {
                return Math.min(i / round, i2 / round);
            }
        }
        return 1;
    }

    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a2;
        Uri parse = Uri.parse(str);
        InputStream inputStream3 = null;
        try {
            inputStream = context.getContentResolver().openInputStream(parse);
            try {
                a2 = a(context, inputStream);
                inputStream2 = context.getContentResolver().openInputStream(parse);
            } catch (IOException e2) {
                e = e2;
                inputStream2 = null;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                    h.a((Closeable) inputStream2);
                    h.a((Closeable) inputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream3 = inputStream2;
                    h.a((Closeable) inputStream3);
                    h.a((Closeable) inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                h.a((Closeable) inputStream3);
                h.a((Closeable) inputStream);
                throw th;
            }
            try {
                Options options = new Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                h.a((Closeable) inputStream2);
                h.a((Closeable) inputStream);
                return decodeStream;
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                h.a((Closeable) inputStream2);
                h.a((Closeable) inputStream);
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            inputStream2 = null;
            inputStream = null;
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
            h.a((Closeable) inputStream2);
            h.a((Closeable) inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            h.a((Closeable) inputStream3);
            h.a((Closeable) inputStream);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00db, code lost:
        if (r1 == null) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dd, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fa, code lost:
        if (r1 == null) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fd, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e3 */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0105  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x00e3=Splitter:B:55:0x00e3, B:48:0x00d5=Splitter:B:48:0x00d5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.push.service.ap.a a(java.lang.String r10, boolean r11) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x00e1, IOException -> 0x00d2, all -> 0x00cf }
            r1.<init>(r10)     // Catch:{ SocketTimeoutException -> 0x00e1, IOException -> 0x00d2, all -> 0x00cf }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ SocketTimeoutException -> 0x00e1, IOException -> 0x00d2, all -> 0x00cf }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ SocketTimeoutException -> 0x00e1, IOException -> 0x00d2, all -> 0x00cf }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ SocketTimeoutException -> 0x00e1, IOException -> 0x00d2, all -> 0x00cf }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ SocketTimeoutException -> 0x00e1, IOException -> 0x00d2, all -> 0x00cf }
            r2 = 8000(0x1f40, float:1.121E-41)
            r1.setConnectTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r2 = 20000(0x4e20, float:2.8026E-41)
            r1.setReadTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r2 = "User-agent"
            java.lang.String r3 = "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser"
            r1.setRequestProperty(r2, r3)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r1.connect()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            int r2 = r1.getContentLength()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r3 = 102400(0x19000, float:1.43493E-40)
            if (r11 == 0) goto L_0x0054
            if (r2 <= r3) goto L_0x0054
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r11.<init>()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r3 = "Bitmap size is too big, max size is 102400  contentLen size is "
            r11.append(r3)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r2 = " from url "
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r11.append(r10)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r11 = r11.toString()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            com.xiaomi.channel.commonutils.logger.b.a(r11)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            com.xiaomi.push.h.a(r0)
            r1.disconnect()
            return r0
        L_0x0054:
            int r2 = r1.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 == r4) goto L_0x007c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r11.<init>()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r3 = "Invalid Http Response Code "
            r11.append(r3)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r2 = " received"
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r11 = r11.toString()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            com.xiaomi.channel.commonutils.logger.b.a(r11)     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            com.xiaomi.push.h.a(r0)
            r1.disconnect()
            return r0
        L_0x007c:
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ SocketTimeoutException -> 0x00cd, IOException -> 0x00ca, all -> 0x00c8 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            r4.<init>()     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            if (r11 == 0) goto L_0x008b
            r11 = 102400(0x19000, float:1.43493E-40)
            goto L_0x008e
        L_0x008b:
            r11 = 2048000(0x1f4000, float:2.869859E-39)
        L_0x008e:
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r5]     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
        L_0x0092:
            if (r11 <= 0) goto L_0x00a2
            r7 = 0
            int r8 = r2.read(r6, r7, r5)     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            r9 = -1
            if (r8 != r9) goto L_0x009d
            goto L_0x00a2
        L_0x009d:
            int r11 = r11 - r8
            r4.write(r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            goto L_0x0092
        L_0x00a2:
            if (r11 > 0) goto L_0x00b5
            java.lang.String r11 = "length 102400 exhausted."
            com.xiaomi.channel.commonutils.logger.b.a(r11)     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            com.xiaomi.push.service.ap$a r11 = new com.xiaomi.push.service.ap$a     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            r11.<init>(r0, r3)     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            com.xiaomi.push.h.a(r2)
            r1.disconnect()
            return r11
        L_0x00b5:
            byte[] r11 = r4.toByteArray()     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            com.xiaomi.push.service.ap$a r3 = new com.xiaomi.push.service.ap$a     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            int r4 = r11.length     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            r3.<init>(r11, r4)     // Catch:{ SocketTimeoutException -> 0x00e3, IOException -> 0x00c6 }
            com.xiaomi.push.h.a(r2)
            r1.disconnect()
            return r3
        L_0x00c6:
            r10 = move-exception
            goto L_0x00d5
        L_0x00c8:
            r10 = move-exception
            goto L_0x0100
        L_0x00ca:
            r10 = move-exception
            r2 = r0
            goto L_0x00d5
        L_0x00cd:
            r2 = r0
            goto L_0x00e3
        L_0x00cf:
            r10 = move-exception
            r1 = r0
            goto L_0x0100
        L_0x00d2:
            r10 = move-exception
            r1 = r0
            r2 = r1
        L_0x00d5:
            com.xiaomi.channel.commonutils.logger.b.a(r10)     // Catch:{ all -> 0x00fe }
            com.xiaomi.push.h.a(r2)
            if (r1 == 0) goto L_0x00fd
        L_0x00dd:
            r1.disconnect()
            goto L_0x00fd
        L_0x00e1:
            r1 = r0
            r2 = r1
        L_0x00e3:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            r11.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r3 = "Connect timeout to "
            r11.append(r3)     // Catch:{ all -> 0x00fe }
            r11.append(r10)     // Catch:{ all -> 0x00fe }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x00fe }
            com.xiaomi.channel.commonutils.logger.b.d(r10)     // Catch:{ all -> 0x00fe }
            com.xiaomi.push.h.a(r2)
            if (r1 == 0) goto L_0x00fd
            goto L_0x00dd
        L_0x00fd:
            return r0
        L_0x00fe:
            r10 = move-exception
            r0 = r2
        L_0x0100:
            com.xiaomi.push.h.a(r0)
            if (r1 == 0) goto L_0x0108
            r1.disconnect()
        L_0x0108:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ap.a(java.lang.String, boolean):com.xiaomi.push.service.ap$a");
    }

    public static b a(Context context, String str, boolean z) {
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0);
        Bitmap b2 = b(context, str);
        if (b2 != null) {
            bVar.f848a = b2;
            return bVar;
        }
        try {
            a a2 = a(str, z);
            if (a2 == null) {
                h.a((Closeable) null);
                return bVar;
            }
            bVar.f4860a = (long) a2.f4859a;
            byte[] bArr = a2.f847a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, (InputStream) byteArrayInputStream2);
                        Options options = new Options();
                        options.inSampleSize = a3;
                        bVar.f848a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                            h.a((Closeable) byteArrayInputStream);
                            return bVar;
                        } catch (Throwable th) {
                            th = th;
                            h.a((Closeable) byteArrayInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream = byteArrayInputStream2;
                        h.a((Closeable) byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f848a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f847a, str);
            h.a((Closeable) byteArrayInputStream);
            return bVar;
        } catch (Exception e3) {
            e = e3;
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
            h.a((Closeable) byteArrayInputStream);
            return bVar;
        }
    }

    public static void a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getPath());
        File file = new File(GeneratedOutlineSupport.outline62(sb, File.separator, "mipush_icon"));
        if (file.exists()) {
            if (f4858a == 0) {
                f4858a = g.a(file);
            }
            if (f4858a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                            listFiles[i].delete();
                        }
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                }
                f4858a = 0;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, byte[] r7, java.lang.String r8) {
        /*
            if (r7 != 0) goto L_0x0008
            java.lang.String r6 = "cannot save small icon cause bitmap is null"
            com.xiaomi.channel.commonutils.logger.b.a(r6)
            return
        L_0x0008:
            a(r6)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = r6.getCacheDir()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            java.lang.String r3 = "mipush_icon"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r1, r2, r3)
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0031
            r0.mkdirs()
        L_0x0031:
            java.io.File r1 = new java.io.File
            java.lang.String r8 = com.xiaomi.push.ad.a(r8)
            r1.<init>(r0, r8)
            r8 = 0
            boolean r0 = r1.exists()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r0 != 0) goto L_0x0044
            r1.createNewFile()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
        L_0x0044:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x005e }
            r2.<init>(r0)     // Catch:{ Exception -> 0x005e }
            r2.write(r7)     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            r2.flush()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
            com.xiaomi.push.h.a(r2)
            goto L_0x006b
        L_0x0058:
            r6 = move-exception
            r8 = r2
            goto L_0x00a2
        L_0x005b:
            r7 = move-exception
            r8 = r2
            goto L_0x0065
        L_0x005e:
            r7 = move-exception
            goto L_0x0065
        L_0x0060:
            r6 = move-exception
            r0 = r8
            goto L_0x00a2
        L_0x0063:
            r7 = move-exception
            r0 = r8
        L_0x0065:
            com.xiaomi.channel.commonutils.logger.b.a(r7)     // Catch:{ all -> 0x009d }
            com.xiaomi.push.h.a(r8)
        L_0x006b:
            com.xiaomi.push.h.a(r0)
            long r7 = f4858a
            r4 = 0
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x009c
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.io.File r6 = r6.getCacheDir()
            java.lang.String r6 = r6.getPath()
            r8.append(r6)
            java.lang.String r6 = java.io.File.separator
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r8, r6, r3)
            r7.<init>(r6)
            long r6 = com.xiaomi.push.g.a(r7)
            long r0 = r1.length()
            long r0 = r0 + r6
            f4858a = r0
        L_0x009c:
            return
        L_0x009d:
            r6 = move-exception
            r7 = r8
            r8 = r0
            r0 = r8
            r8 = r7
        L_0x00a2:
            com.xiaomi.push.h.a(r8)
            com.xiaomi.push.h.a(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ap.a(android.content.Context, byte[], java.lang.String):void");
    }

    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r5v11, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap b(android.content.Context r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r4 = r4.getCacheDir()
            java.lang.String r4 = r4.getPath()
            r1.append(r4)
            java.lang.String r4 = java.io.File.separator
            java.lang.String r2 = "mipush_icon"
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r1, r4, r2)
            java.lang.String r5 = com.xiaomi.push.ad.a(r5)
            r0.<init>(r4, r5)
            boolean r4 = r0.exists()
            r5 = 0
            if (r4 != 0) goto L_0x0029
            return r5
        L_0x0029:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0049 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0049 }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r0.setLastModified(r1)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            com.xiaomi.push.h.a(r4)
            goto L_0x0053
        L_0x003d:
            r5 = move-exception
            goto L_0x0054
        L_0x003f:
            r0 = move-exception
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x004c
        L_0x0044:
            r4 = move-exception
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x0054
        L_0x0049:
            r4 = move-exception
            r0 = r4
            r4 = r5
        L_0x004c:
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x0044 }
            com.xiaomi.push.h.a(r5)
            r5 = r4
        L_0x0053:
            return r5
        L_0x0054:
            com.xiaomi.push.h.a(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ap.b(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }
}
