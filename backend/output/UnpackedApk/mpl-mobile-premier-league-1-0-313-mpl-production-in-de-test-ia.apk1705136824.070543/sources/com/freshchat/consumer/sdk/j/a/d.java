package com.freshchat.consumer.sdk.j.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.StatFs;
import androidx.collection.LruCache;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.q;
import java.io.File;
import java.io.IOException;

public class d {
    public static final CompressFormat rO = CompressFormat.PNG;
    public static b rP;
    public static LruCache<String, Bitmap> rQ;
    public static a rR;
    public static final Object rS = new Object();
    public static boolean rT = true;
    public static d rU;

    public static class a {
        public int rW = 10485760;
        public int rX = 20971520;
        public File rY;
        public CompressFormat rZ = d.rO;
        public int sa = 90;
        public boolean sb = true;
        public boolean sc = true;
        public boolean sd = false;
        public boolean se = false;

        public a(Context context, String str) {
            this.rY = d.R(context, str);
        }

        public static int bh(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }

        public void a(Context context, float f2) {
            if (f2 < 0.05f || f2 > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
            }
            this.rW = Math.round(f2 * ((float) bh(context)) * 1024.0f * 1024.0f);
        }
    }

    public d(a aVar) {
        b(aVar);
    }

    public static File R(Context context, String str) {
        File file = new File(GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(context.getCacheDir().getPath()), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d a(a aVar) {
        d dVar;
        synchronized (d.class) {
            if (rU == null) {
                rU = new d(aVar);
            }
            dVar = rU;
        }
        return dVar;
    }

    @TargetApi(12)
    public static int b(Bitmap bitmap) {
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    private void b(a aVar) {
        rR = aVar;
        if (aVar.sb) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Memory cache created (size = ");
            outline73.append(rR.rW);
            outline73.append(")");
            ai.d("ImageCache", outline73.toString());
            rQ = new g(this, rR.rW);
        }
        if (aVar.se) {
            jX();
        }
    }

    public static String bJ(String str) {
        return aa.aA(str);
    }

    @TargetApi(9)
    public static long c(File file) {
        if (aw.eR()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:24|(2:34|35)|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r1 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r1 == null) goto L_0x006b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x006a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0070
            if (r6 != 0) goto L_0x0006
            goto L_0x0070
        L_0x0006:
            androidx.collection.LruCache<java.lang.String, android.graphics.Bitmap> r0 = rQ
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.get(r5)
            if (r0 != 0) goto L_0x0015
            androidx.collection.LruCache<java.lang.String, android.graphics.Bitmap> r0 = rQ
            r0.put(r5, r6)
        L_0x0015:
            java.lang.Object r0 = rS
            monitor-enter(r0)
            com.freshchat.consumer.sdk.j.a.b r1 = rP     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x006b
            java.lang.String r5 = bJ(r5)     // Catch:{ all -> 0x006d }
            r1 = 0
            com.freshchat.consumer.sdk.j.a.b r2 = rP     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            com.freshchat.consumer.sdk.j.a.b$c r2 = r2.bE(r5)     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            r3 = 0
            if (r2 != 0) goto L_0x0048
            com.freshchat.consumer.sdk.j.a.b r2 = rP     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            com.freshchat.consumer.sdk.j.a.b$a r5 = r2.bF(r5)     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            if (r5 == 0) goto L_0x004f
            java.io.OutputStream r1 = r5.x(r3)     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            com.freshchat.consumer.sdk.j.a.d$a r2 = rR     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            android.graphics.Bitmap$CompressFormat r2 = r2.rZ     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            com.freshchat.consumer.sdk.j.a.d$a r3 = rR     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            int r3 = r3.sa     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            r6.compress(r2, r3, r1)     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            r5.commit()     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            r1.close()     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            goto L_0x004f
        L_0x0048:
            java.io.InputStream r5 = r2.ad(r3)     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
            r5.close()     // Catch:{ IOException -> 0x005e, Exception -> 0x0057 }
        L_0x004f:
            if (r1 == 0) goto L_0x006b
        L_0x0051:
            r1.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006b
        L_0x0055:
            r5 = move-exception
            goto L_0x0065
        L_0x0057:
            r5 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r5)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x006b
            goto L_0x0051
        L_0x005e:
            r5 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r5)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x006b
            goto L_0x0051
        L_0x0065:
            if (r1 == 0) goto L_0x006a
            r1.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            throw r5     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            return
        L_0x006d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006d }
            throw r5
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.d.a(java.lang.String, android.graphics.Bitmap):void");
    }

    public Bitmap bH(String str) {
        LruCache<String, Bitmap> lruCache = rQ;
        if (lruCache != null) {
            Bitmap bitmap = (Bitmap) lruCache.get(str);
            if (bitmap != null) {
                ai.d("ImageCache", "Memory cache hit");
                return bitmap;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
        if (r4 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x003e, code lost:
        if (r4 != null) goto L_0x0033;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A[LOOP:0: B:2:0x0007->B:47:0x0007, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0045 A[SYNTHETIC, Splitter:B:37:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap bI(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = bJ(r4)
            java.lang.Object r0 = rS
            monitor-enter(r0)
        L_0x0007:
            boolean r1 = rT     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0011
            java.lang.Object r1 = rS     // Catch:{ InterruptedException -> 0x0007 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0007 }
            goto L_0x0007
        L_0x0011:
            com.freshchat.consumer.sdk.j.a.b r1 = rP     // Catch:{ all -> 0x004b }
            r2 = 0
            if (r1 == 0) goto L_0x0049
            com.freshchat.consumer.sdk.j.a.b r1 = rP     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            com.freshchat.consumer.sdk.j.a.b$c r4 = r1.bE(r4)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            if (r4 == 0) goto L_0x0030
            r1 = 0
            java.io.InputStream r4 = r4.ad(r1)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            if (r4 == 0) goto L_0x0031
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ IOException -> 0x002e }
            r4.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r1
        L_0x002e:
            r1 = move-exception
            goto L_0x003b
        L_0x0030:
            r4 = r2
        L_0x0031:
            if (r4 == 0) goto L_0x0049
        L_0x0033:
            r4.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0049
        L_0x0037:
            r1 = move-exception
            goto L_0x0043
        L_0x0039:
            r1 = move-exception
            r4 = r2
        L_0x003b:
            com.freshchat.consumer.sdk.j.q.a(r1)     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0049
            goto L_0x0033
        L_0x0041:
            r1 = move-exception
            r2 = r4
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            throw r1     // Catch:{ all -> 0x004b }
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r2
        L_0x004b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.d.bI(java.lang.String):android.graphics.Bitmap");
    }

    public void clearCache() {
        jY();
        synchronized (rS) {
            rT = true;
            if (rP != null && !rP.isClosed()) {
                try {
                    rP.delete();
                    ai.d("ImageCache", "Disk cache cleared");
                } catch (IOException e2) {
                    q.a(e2);
                }
                rP = null;
                jX();
            }
        }
    }

    public void close() {
        synchronized (rS) {
            if (rP != null) {
                try {
                    if (!rP.isClosed()) {
                        rP.close();
                        rP = null;
                        ai.d("ImageCache", "Disk cache closed");
                    }
                } catch (IOException e2) {
                    q.a(e2);
                }
            }
        }
    }

    public void flush() {
        synchronized (rS) {
            if (rP != null) {
                try {
                    rP.flush();
                    ai.d("ImageCache", "Disk cache flushed");
                } catch (IOException e2) {
                    q.a(e2);
                }
            }
        }
    }

    public void jX() {
        synchronized (rS) {
            if (rP == null || rP.isClosed()) {
                File file = rR.rY;
                if (rR.sc && file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (c(file) > ((long) rR.rX)) {
                        try {
                            rP = b.a(file, 1, 1, (long) rR.rX);
                            ai.d("ImageCache", "Disk cache initialized");
                        } catch (IOException e2) {
                            rR.rY = null;
                            q.a(e2);
                        }
                    }
                }
            }
            rT = false;
            rS.notifyAll();
        }
    }

    public void jY() {
        LruCache<String, Bitmap> lruCache = rQ;
        if (lruCache != null) {
            lruCache.evictAll();
            ai.d("ImageCache", "Memory cache cleared");
        }
    }
}
