package com.shield.android;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

public class ScreenshotChecker {

    /* renamed from: b  reason: collision with root package name */
    public static ContentObserver f1448b;

    /* renamed from: c  reason: collision with root package name */
    public static long f1449c = System.currentTimeMillis();

    /* renamed from: a  reason: collision with root package name */
    public final ShieldFingerprintUseCase f1450a;

    public class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Application f1451a;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public a(Handler handler, Application application) {
            // this.f1451a = application;
            super(handler);
        }

        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (uri != null) {
                try {
                    ScreenshotChecker screenshotChecker = ScreenshotChecker.this;
                    Application application = this.f1451a;
                    if (screenshotChecker != null) {
                        screenshotChecker.b(application, uri);
                        return;
                    }
                    throw null;
                } catch (Exception unused) {
                }
            }
        }
    }

    public ScreenshotChecker(ShieldFingerprintUseCase shieldFingerprintUseCase) {
        this.f1450a = shieldFingerprintUseCase;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(4:21|(1:23)(1:24)|25|(1:27))|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0092, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0081 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.app.Application r13, android.net.Uri r14) {
        /*
            r12 = this;
            java.lang.String r0 = "_display_name"
            java.lang.String r1 = "screenshot"
            r2 = 2
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0098 }
            r2 = 0
            r5[r2] = r0     // Catch:{ Exception -> 0x0098 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0098 }
            java.lang.String r10 = "relative_path"
            r11 = 29
            if (r9 < r11) goto L_0x0015
            r3 = 1
            r5[r3] = r10     // Catch:{ Exception -> 0x0098 }
        L_0x0015:
            android.content.ContentResolver r3 = r13.getContentResolver()     // Catch:{ Exception -> 0x0098 }
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r14
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0098 }
            if (r13 == 0) goto L_0x0093
            boolean r14 = r13.moveToFirst()     // Catch:{ all -> 0x007f }
            if (r14 == 0) goto L_0x0093
            if (r9 < r11) goto L_0x002f
            int r2 = r13.getColumnIndex(r10)     // Catch:{ all -> 0x007f }
        L_0x002f:
            int r14 = r13.getColumnIndex(r0)     // Catch:{ all -> 0x007f }
        L_0x0033:
            java.lang.String r0 = r13.getString(r14)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r3 = r13.getString(r2)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x0081 }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0081 }
            if (r0 != 0) goto L_0x004f
            java.lang.String r0 = r3.toLowerCase()     // Catch:{ Exception -> 0x0081 }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0081 }
            if (r0 == 0) goto L_0x0081
        L_0x004f:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0081 }
            r0.<init>()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r3 = "event_name"
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0081 }
            java.lang.ref.WeakReference<java.lang.String> r3 = com.shield.android.a.F     // Catch:{ Exception -> 0x0081 }
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0081 }
            goto L_0x0065
        L_0x0064:
            r3 = r1
        L_0x0065:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0081 }
            long r6 = f1449c     // Catch:{ Exception -> 0x0081 }
            long r4 = r4 - r6
            r6 = 1000(0x3e8, double:4.94E-321)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0081
            com.shield.android.ShieldFingerprintUseCase r4 = r12.f1450a     // Catch:{ Exception -> 0x0081 }
            r5 = 0
            r4.sendDeviceSignature(r3, r0, r5)     // Catch:{ Exception -> 0x0081 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0081 }
            f1449c = r3     // Catch:{ Exception -> 0x0081 }
            goto L_0x0081
        L_0x007f:
            r14 = move-exception
            goto L_0x0088
        L_0x0081:
            boolean r0 = r13.moveToNext()     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x0033
            goto L_0x0093
        L_0x0088:
            throw r14     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r0 = move-exception
            r13.close()     // Catch:{ all -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r13 = move-exception
            r14.addSuppressed(r13)     // Catch:{ Exception -> 0x0098 }
        L_0x0092:
            throw r0     // Catch:{ Exception -> 0x0098 }
        L_0x0093:
            if (r13 == 0) goto L_0x0098
            r13.close()     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.ScreenshotChecker.b(android.app.Application, android.net.Uri):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|11|12|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start(android.app.Application r6) {
        /*
            r5 = this;
            java.lang.String r0 = "android.permission.READ_EXTERNAL_STORAGE"
            int r0 = r6.checkCallingOrSelfPermission(r0)
            r1 = 1
            if (r0 != 0) goto L_0x000b
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 == 0) goto L_0x002b
            android.database.ContentObserver r0 = f1448b
            if (r0 != 0) goto L_0x002b
            android.content.ContentResolver r0 = r6.getContentResolver()     // Catch:{ Exception -> 0x002b }
            com.shield.android.ScreenshotChecker$a r2 = new com.shield.android.ScreenshotChecker$a     // Catch:{ Exception -> 0x002b }
            android.os.Handler r3 = new android.os.Handler     // Catch:{ Exception -> 0x002b }
            android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x002b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002b }
            r2.<init>(r3, r6)     // Catch:{ Exception -> 0x002b }
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0029 }
            r0.registerContentObserver(r6, r1, r2)     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            f1448b = r2     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shield.android.ScreenshotChecker.start(android.app.Application):void");
    }
}
