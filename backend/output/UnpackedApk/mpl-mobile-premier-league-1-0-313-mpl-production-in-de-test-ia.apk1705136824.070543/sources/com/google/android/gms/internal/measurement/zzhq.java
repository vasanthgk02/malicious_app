package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhq implements zzif {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzhq(Context context) {
        this.zza = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:61|62) */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0118 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza() {
        /*
            r13 = this;
            android.content.Context r0 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzhy.zzc
            java.lang.String r1 = android.os.Build.TYPE
            java.lang.String r2 = android.os.Build.TAGS
            java.lang.String r3 = "eng"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0019
            java.lang.String r3 = "userdebug"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0019
            goto L_0x002a
        L_0x0019:
            java.lang.String r1 = "dev-keys"
            boolean r1 = r2.contains(r1)
            if (r1 != 0) goto L_0x0030
            java.lang.String r1 = "test-keys"
            boolean r1 = r2.contains(r1)
            if (r1 == 0) goto L_0x002a
            goto L_0x0030
        L_0x002a:
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()
            goto L_0x0127
        L_0x0030:
            boolean r1 = com.google.android.gms.internal.measurement.zzha.zza()
            if (r1 == 0) goto L_0x0040
            boolean r1 = r0.isDeviceProtectedStorage()
            if (r1 != 0) goto L_0x0040
            android.content.Context r0 = r0.createDeviceProtectedStorageContext()
        L_0x0040:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0128 }
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ RuntimeException -> 0x0065 }
            java.lang.String r4 = "phenotype_hermetic"
            java.io.File r0 = r0.getDir(r4, r2)     // Catch:{ RuntimeException -> 0x0065 }
            java.lang.String r4 = "overrides.txt"
            r3.<init>(r0, r4)     // Catch:{ RuntimeException -> 0x0065 }
            boolean r0 = r3.exists()     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x0060
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzd(r3)     // Catch:{ all -> 0x0128 }
            goto L_0x0069
        L_0x0060:
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()     // Catch:{ all -> 0x0128 }
            goto L_0x0069
        L_0x0065:
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()     // Catch:{ all -> 0x0128 }
        L_0x0069:
            boolean r3 = r0.zzb()     // Catch:{ all -> 0x0128 }
            if (r3 == 0) goto L_0x0120
            java.lang.Object r0 = r0.zza()     // Catch:{ all -> 0x0128 }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x0128 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0119 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0119 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0119 }
            r5.<init>(r0)     // Catch:{ IOException -> 0x0119 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0119 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0119 }
            r4 = 1
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x00fd }
            r5.<init>()     // Catch:{ all -> 0x00fd }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x00fd }
            r6.<init>()     // Catch:{ all -> 0x00fd }
        L_0x008f:
            java.lang.String r7 = r3.readLine()     // Catch:{ all -> 0x00fd }
            if (r7 == 0) goto L_0x00ed
            java.lang.String r8 = " "
            r9 = 3
            java.lang.String[] r7 = r7.split(r8, r9)     // Catch:{ all -> 0x00fd }
            int r8 = r7.length     // Catch:{ all -> 0x00fd }
            if (r8 == r9) goto L_0x00a0
            goto L_0x008f
        L_0x00a0:
            r8 = r7[r2]     // Catch:{ all -> 0x00fd }
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00fd }
            r9.<init>(r8)     // Catch:{ all -> 0x00fd }
            r8 = r7[r4]     // Catch:{ all -> 0x00fd }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00fd }
            r10.<init>(r8)     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = android.net.Uri.decode(r10)     // Catch:{ all -> 0x00fd }
            r10 = 2
            r11 = r7[r10]     // Catch:{ all -> 0x00fd }
            java.lang.Object r11 = r6.get(r11)     // Catch:{ all -> 0x00fd }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x00fd }
            if (r11 != 0) goto L_0x00d5
            r7 = r7[r10]     // Catch:{ all -> 0x00fd }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00fd }
            r10.<init>(r7)     // Catch:{ all -> 0x00fd }
            java.lang.String r11 = android.net.Uri.decode(r10)     // Catch:{ all -> 0x00fd }
            int r7 = r11.length()     // Catch:{ all -> 0x00fd }
            r12 = 1024(0x400, float:1.435E-42)
            if (r7 < r12) goto L_0x00d2
            if (r11 != r10) goto L_0x00d5
        L_0x00d2:
            r6.put(r10, r11)     // Catch:{ all -> 0x00fd }
        L_0x00d5:
            boolean r7 = r5.containsKey(r9)     // Catch:{ all -> 0x00fd }
            if (r7 != 0) goto L_0x00e3
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x00fd }
            r7.<init>()     // Catch:{ all -> 0x00fd }
            r5.put(r9, r7)     // Catch:{ all -> 0x00fd }
        L_0x00e3:
            java.lang.Object r7 = r5.get(r9)     // Catch:{ all -> 0x00fd }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x00fd }
            r7.put(r8, r11)     // Catch:{ all -> 0x00fd }
            goto L_0x008f
        L_0x00ed:
            r0.toString()     // Catch:{ all -> 0x00fd }
            com.google.android.gms.internal.measurement.zzhg r0 = new com.google.android.gms.internal.measurement.zzhg     // Catch:{ all -> 0x00fd }
            r0.<init>(r5)     // Catch:{ all -> 0x00fd }
            r3.close()     // Catch:{ IOException -> 0x0119 }
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzd(r0)     // Catch:{ all -> 0x0128 }
            goto L_0x0124
        L_0x00fd:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x0102 }
            goto L_0x0118
        L_0x0102:
            r3 = move-exception
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0118 }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            r5[r2] = r6     // Catch:{ Exception -> 0x0118 }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            java.lang.String r7 = "addSuppressed"
            java.lang.reflect.Method r5 = r6.getDeclaredMethod(r7, r5)     // Catch:{ Exception -> 0x0118 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0118 }
            r4[r2] = r3     // Catch:{ Exception -> 0x0118 }
            r5.invoke(r0, r4)     // Catch:{ Exception -> 0x0118 }
        L_0x0118:
            throw r0     // Catch:{ IOException -> 0x0119 }
        L_0x0119:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0128 }
            r2.<init>(r0)     // Catch:{ all -> 0x0128 }
            throw r2     // Catch:{ all -> 0x0128 }
        L_0x0120:
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()     // Catch:{ all -> 0x0128 }
        L_0x0124:
            android.os.StrictMode.setThreadPolicy(r1)
        L_0x0127:
            return r0
        L_0x0128:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhq.zza():java.lang.Object");
    }
}
