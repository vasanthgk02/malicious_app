package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;

/* renamed from: cn  reason: default package */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2832a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2833b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2834c;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[Catch:{ IOException -> 0x0047, NameNotFoundException -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cn(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.f2833b = r5
            r3.f2832a = r4
            java.lang.String r5 = "Unable to get api key asset document: "
            java.lang.String r0 = "cn"
            r1 = 0
            if (r4 == 0) goto L_0x005a
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = r3.f2833b     // Catch:{ all -> 0x0034 }
            android.content.res.Resources r4 = r4.getResourcesForApplication(r2)     // Catch:{ all -> 0x0034 }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "api_key.txt"
            java.io.InputStream r4 = r4.open(r2)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Attempting to parse API Key from assets directory"
            defpackage.cp.c(r0, r2)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = a(r4)     // Catch:{ all -> 0x0032 }
            if (r4 == 0) goto L_0x0030
            r4.close()     // Catch:{ IOException -> 0x0047, NameNotFoundException -> 0x003d }
        L_0x0030:
            r1 = r2
            goto L_0x005a
        L_0x0032:
            r2 = move-exception
            goto L_0x0037
        L_0x0034:
            r4 = move-exception
            r2 = r4
            r4 = r1
        L_0x0037:
            if (r4 == 0) goto L_0x003c
            r4.close()     // Catch:{ IOException -> 0x0047, NameNotFoundException -> 0x003d }
        L_0x003c:
            throw r2     // Catch:{ IOException -> 0x0047, NameNotFoundException -> 0x003d }
        L_0x003d:
            r4 = move-exception
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r4 = r4.getMessage()
            goto L_0x0050
        L_0x0047:
            r4 = move-exception
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r4 = r4.getMessage()
        L_0x0050:
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            defpackage.cp.c(r0, r4)
        L_0x005a:
            r3.f2834c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cn.<init>(android.content.Context, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d A[SYNTHETIC, Splitter:B:36:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a6 A[SYNTHETIC, Splitter:B:41:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c2 A[SYNTHETIC, Splitter:B:48:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00db A[SYNTHETIC, Splitter:B:53:0x00db] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.InputStream r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Unable to close BufferedReader: "
            java.lang.String r1 = "Unable to close InputStreamReader: "
            java.lang.String r2 = "cn"
            r3 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x006d, all -> 0x0069 }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r9, r5)     // Catch:{ IOException -> 0x006d, all -> 0x0069 }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0066, all -> 0x0060 }
            r9.<init>(r4)     // Catch:{ IOException -> 0x0066, all -> 0x0060 }
            java.lang.String r3 = r9.readLine()     // Catch:{ IOException -> 0x005b, all -> 0x0057 }
            if (r3 == 0) goto L_0x0026
            java.lang.String r5 = "﻿"
            boolean r5 = r3.startsWith(r5)     // Catch:{ IOException -> 0x005b, all -> 0x0057 }
            if (r5 == 0) goto L_0x0026
            r5 = 1
            java.lang.String r3 = r3.substring(r5)     // Catch:{ IOException -> 0x005b, all -> 0x0057 }
        L_0x0026:
            r4.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x003d
        L_0x002a:
            r4 = move-exception
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r4 = r4.getMessage()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            defpackage.cp.d(r2, r1)
        L_0x003d:
            r9.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x00be
        L_0x0042:
            r9 = move-exception
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            defpackage.cp.d(r2, r9)
            goto L_0x00be
        L_0x0057:
            r3 = move-exception
            r8 = r4
            r4 = r3
            goto L_0x0064
        L_0x005b:
            r5 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x0073
        L_0x0060:
            r9 = move-exception
            r8 = r4
            r4 = r9
            r9 = r3
        L_0x0064:
            r3 = r8
            goto L_0x00c0
        L_0x0066:
            r9 = move-exception
            r5 = r9
            goto L_0x0070
        L_0x0069:
            r9 = move-exception
            r4 = r9
            r9 = r3
            goto L_0x00c0
        L_0x006d:
            r9 = move-exception
            r5 = r9
            r4 = r3
        L_0x0070:
            r9 = r3
            r3 = r4
            r4 = r9
        L_0x0073:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r6.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r7 = "Unable read from asset: "
            r6.append(r7)     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x00bf }
            r6.append(r5)     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x00bf }
            defpackage.cp.c(r2, r5)     // Catch:{ all -> 0x00bf }
            if (r3 == 0) goto L_0x00a4
            r3.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x00a4
        L_0x0091:
            r3 = move-exception
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r3 = r3.getMessage()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            defpackage.cp.d(r2, r1)
        L_0x00a4:
            if (r9 == 0) goto L_0x00bd
            r9.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00bd
        L_0x00aa:
            r9 = move-exception
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            defpackage.cp.d(r2, r9)
        L_0x00bd:
            r3 = r4
        L_0x00be:
            return r3
        L_0x00bf:
            r4 = move-exception
        L_0x00c0:
            if (r3 == 0) goto L_0x00d9
            r3.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00d9
        L_0x00c6:
            r3 = move-exception
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r3 = r3.getMessage()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            defpackage.cp.d(r2, r1)
        L_0x00d9:
            if (r9 == 0) goto L_0x00f2
            r9.close()     // Catch:{ IOException -> 0x00df }
            goto L_0x00f2
        L_0x00df:
            r9 = move-exception
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            defpackage.cp.d(r2, r9)
        L_0x00f2:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cn.a(java.io.InputStream):java.lang.String");
    }

    public final String a(String str) {
        if (this.f2832a != null) {
            cp.c("cn", "Attempting to parse API Key from meta data in Android manifest");
            try {
                ApplicationInfo applicationInfo = this.f2832a.getPackageManager().getApplicationInfo(this.f2833b, 128);
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getString(str);
                }
            } catch (NameNotFoundException e2) {
                e2.getMessage();
            }
        }
        return null;
    }
}
