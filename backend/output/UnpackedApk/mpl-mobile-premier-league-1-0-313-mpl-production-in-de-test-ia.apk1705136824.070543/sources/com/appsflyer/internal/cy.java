package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

public final class cy extends cz {
    public cy(Runnable runnable) {
        super("huawei", runnable);
    }

    public final void AFInAppEventParameterName(Context context) {
        values(context, new aw<Map<String, Object>>(context, "com.huawei.appmarket.commondata", "FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212", "3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F") {
            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f8, code lost:
                if (r2 != null) goto L_0x010e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x010c, code lost:
                if (r2 == null) goto L_0x0111;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x010e, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0111, code lost:
                r11.values.valueOf();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x011a, code lost:
                return r11.values.AFInAppEventType;
             */
            /* renamed from: valueOf */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.Object> AFInAppEventType() {
                /*
                    r11 = this;
                    java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
                    java.lang.String r1 = "response"
                    android.content.Context r2 = r11.AFInAppEventParameterName
                    android.content.pm.PackageManager r2 = r2.getPackageManager()
                    java.lang.String r3 = r11.AFKeystoreWrapper
                    r4 = 128(0x80, float:1.8E-43)
                    android.content.pm.ProviderInfo r2 = r2.resolveContentProvider(r3, r4)
                    java.lang.String r2 = r2.packageName
                    com.appsflyer.internal.cy r3 = com.appsflyer.internal.cy.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType
                    android.content.Context r4 = r11.AFInAppEventParameterName
                    long r4 = com.appsflyer.internal.z.values(r4, r2)
                    java.lang.Long r4 = java.lang.Long.valueOf(r4)
                    java.lang.String r5 = "api_ver"
                    r3.put(r5, r4)
                    com.appsflyer.internal.cy r3 = com.appsflyer.internal.cy.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType
                    android.content.Context r4 = r11.AFInAppEventParameterName
                    java.lang.String r2 = com.appsflyer.internal.z.AFKeystoreWrapper(r4, r2)
                    java.lang.String r4 = "api_ver_name"
                    r3.put(r4, r2)
                    r2 = 0
                    android.content.Context r3 = r11.AFInAppEventParameterName     // Catch:{ Exception -> 0x00fd }
                    android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ Exception -> 0x00fd }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = "content://"
                    r3.<init>(r5)     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = r11.AFKeystoreWrapper     // Catch:{ Exception -> 0x00fd }
                    r3.append(r5)     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = "/item/5"
                    r3.append(r5)     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00fd }
                    android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00fd }
                    r6 = 0
                    r7 = 0
                    r3 = 1
                    java.lang.String[] r8 = new java.lang.String[r3]     // Catch:{ Exception -> 0x00fd }
                    android.content.Context r9 = r11.AFInAppEventParameterName     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r9 = r9.getPackageName()     // Catch:{ Exception -> 0x00fd }
                    r10 = 0
                    r8[r10] = r9     // Catch:{ Exception -> 0x00fd }
                    r9 = 0
                    android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00fd }
                    if (r2 == 0) goto L_0x00ef
                    boolean r4 = r2.moveToFirst()     // Catch:{ Exception -> 0x00fd }
                    if (r4 == 0) goto L_0x00e7
                    com.appsflyer.internal.cy r4 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = "OK"
                    r4.put(r1, r5)     // Catch:{ Exception -> 0x00fd }
                    com.appsflyer.internal.cy r4 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = "referrer"
                    java.lang.String r6 = r2.getString(r10)     // Catch:{ Exception -> 0x00fd }
                    r4.put(r5, r6)     // Catch:{ Exception -> 0x00fd }
                    com.appsflyer.internal.cy r4 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = "click_ts"
                    long r6 = r2.getLong(r3)     // Catch:{ Exception -> 0x00fd }
                    java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00fd }
                    r4.put(r5, r3)     // Catch:{ Exception -> 0x00fd }
                    com.appsflyer.internal.cy r3 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r4 = "install_end_ts"
                    r5 = 2
                    long r5 = r2.getLong(r5)     // Catch:{ Exception -> 0x00fd }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00fd }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00fd }
                    int r3 = r2.getColumnCount()     // Catch:{ Exception -> 0x00fd }
                    r4 = 3
                    if (r3 <= r4) goto L_0x00f8
                    com.appsflyer.internal.cy r3 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = "install_begin_ts"
                    long r6 = r2.getLong(r4)     // Catch:{ Exception -> 0x00fd }
                    java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00fd }
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x00fd }
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x00fd }
                    r3.<init>()     // Catch:{ Exception -> 0x00fd }
                    r4 = 4
                    java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00fd }
                    if (r4 == 0) goto L_0x00d3
                    java.lang.String r5 = "track_id"
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x00fd }
                L_0x00d3:
                    java.lang.String r4 = "referrer_ex"
                    r5 = 5
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x00fd }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00fd }
                    com.appsflyer.internal.cy r4 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r5 = "huawei_custom"
                    r4.put(r5, r3)     // Catch:{ Exception -> 0x00fd }
                    goto L_0x00f8
                L_0x00e7:
                    com.appsflyer.internal.cy r3 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    r3.put(r1, r0)     // Catch:{ Exception -> 0x00fd }
                    goto L_0x00f8
                L_0x00ef:
                    com.appsflyer.internal.cy r3 = com.appsflyer.internal.cy.this     // Catch:{ Exception -> 0x00fd }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00fd }
                    java.lang.String r4 = "SERVICE_UNAVAILABLE"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x00fd }
                L_0x00f8:
                    if (r2 == 0) goto L_0x0111
                    goto L_0x010e
                L_0x00fb:
                    r0 = move-exception
                    goto L_0x011b
                L_0x00fd:
                    r3 = move-exception
                    com.appsflyer.internal.cy r4 = com.appsflyer.internal.cy.this     // Catch:{ all -> 0x00fb }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ all -> 0x00fb }
                    r4.put(r1, r0)     // Catch:{ all -> 0x00fb }
                    java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x00fb }
                    com.appsflyer.AFLogger.valueOf(r0, r3)     // Catch:{ all -> 0x00fb }
                    if (r2 == 0) goto L_0x0111
                L_0x010e:
                    r2.close()
                L_0x0111:
                    com.appsflyer.internal.cy r0 = com.appsflyer.internal.cy.this
                    r0.valueOf()
                    com.appsflyer.internal.cy r0 = com.appsflyer.internal.cy.this
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFInAppEventType
                    return r0
                L_0x011b:
                    if (r2 == 0) goto L_0x0120
                    r2.close()
                L_0x0120:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.cy.AnonymousClass5.AFInAppEventType():java.util.Map");
            }
        });
    }
}
