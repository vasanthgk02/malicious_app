package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzik implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzim zze;

    public zzik(zzim zzim, boolean z, Uri uri, String str, String str2) {
        this.zze = zzim;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8 A[SYNTHETIC, Splitter:B:31:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010d A[Catch:{ RuntimeException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0115 A[Catch:{ RuntimeException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0117 A[Catch:{ RuntimeException -> 0x019e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzim r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzin r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzin r6 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzlp r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzin r7 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzk     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzav     // Catch:{ RuntimeException -> 0x019e }
            r9 = 0
            boolean r7 = r7.zzs(r9, r8)     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzin r8 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r8 = r8.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzk     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzaw     // Catch:{ RuntimeException -> 0x019e }
            boolean r8 = r8.zzs(r9, r10)     // Catch:{ RuntimeException -> 0x019e }
            boolean r10 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x019e }
            java.lang.String r12 = "Activity created with data 'referrer' without required params"
            java.lang.String r13 = "utm_medium"
            java.lang.String r14 = "_cis"
            java.lang.String r15 = "utm_source"
            java.lang.String r11 = "utm_campaign"
            java.lang.String r9 = "gclid"
            if (r10 == 0) goto L_0x004c
        L_0x004a:
            r6 = 0
            goto L_0x00a4
        L_0x004c:
            boolean r10 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x019e }
            if (r10 != 0) goto L_0x008f
            boolean r10 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x019e }
            if (r10 != 0) goto L_0x008f
            boolean r10 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x019e }
            if (r10 != 0) goto L_0x008f
            boolean r10 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x019e }
            if (r10 != 0) goto L_0x008f
            if (r7 == 0) goto L_0x0076
            java.lang.String r10 = "utm_id"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x019e }
            if (r10 != 0) goto L_0x008f
            java.lang.String r10 = "dclid"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x019e }
            if (r10 != 0) goto L_0x008f
        L_0x0076:
            if (r8 == 0) goto L_0x0083
            java.lang.String r8 = "srsltid"
            boolean r8 = r5.contains(r8)     // Catch:{ RuntimeException -> 0x019e }
            if (r8 != 0) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r8 = 1
            goto L_0x008f
        L_0x0083:
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzk     // Catch:{ RuntimeException -> 0x019e }
            r6.zza(r12)     // Catch:{ RuntimeException -> 0x019e }
            goto L_0x004a
        L_0x008f:
            java.lang.String r10 = "https://google.com/search?"
            java.lang.String r10 = r10.concat(r5)     // Catch:{ RuntimeException -> 0x019e }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ RuntimeException -> 0x019e }
            android.os.Bundle r6 = r6.zzs(r10, r7, r8)     // Catch:{ RuntimeException -> 0x019e }
            if (r6 == 0) goto L_0x00a4
            java.lang.String r7 = "referrer"
            r6.putString(r14, r7)     // Catch:{ RuntimeException -> 0x019e }
        L_0x00a4:
            java.lang.String r7 = "_cmp"
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzlp r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzin r8 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r8 = r8.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzk     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzav     // Catch:{ RuntimeException -> 0x019e }
            r1 = 0
            boolean r8 = r8.zzs(r1, r10)     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzin r1 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzaw     // Catch:{ RuntimeException -> 0x019e }
            r16 = r12
            r12 = 0
            boolean r1 = r1.zzs(r12, r10)     // Catch:{ RuntimeException -> 0x019e }
            android.os.Bundle r0 = r0.zzs(r3, r8, r1)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 == 0) goto L_0x010f
            java.lang.String r1 = "intent"
            r0.putString(r14, r1)     // Catch:{ RuntimeException -> 0x019e }
            boolean r1 = r0.containsKey(r9)     // Catch:{ RuntimeException -> 0x019e }
            if (r1 != 0) goto L_0x0100
            if (r6 == 0) goto L_0x0100
            boolean r1 = r6.containsKey(r9)     // Catch:{ RuntimeException -> 0x019e }
            if (r1 == 0) goto L_0x0100
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ RuntimeException -> 0x019e }
            r3 = 0
            java.lang.String r8 = r6.getString(r9)     // Catch:{ RuntimeException -> 0x019e }
            r1[r3] = r8     // Catch:{ RuntimeException -> 0x019e }
            java.lang.String r3 = "_cer"
            java.lang.String r8 = "gclid=%s"
            java.lang.String r1 = java.lang.String.format(r8, r1)     // Catch:{ RuntimeException -> 0x019e }
            r0.putString(r3, r1)     // Catch:{ RuntimeException -> 0x019e }
        L_0x0100:
            com.google.android.gms.measurement.internal.zzin r1 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            r1.zzH(r4, r7, r0)     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzin r1 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzr r1 = r1.zzb     // Catch:{ RuntimeException -> 0x019e }
            r1.zza(r4, r0)     // Catch:{ RuntimeException -> 0x019e }
            goto L_0x010f
        L_0x010d:
            r16 = r12
        L_0x010f:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 == 0) goto L_0x0117
            goto L_0x018d
        L_0x0117:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzk     // Catch:{ RuntimeException -> 0x019e }
            java.lang.String r1 = "Activity created with referrer"
            r0.zzb(r1, r5)     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzek r1 = com.google.android.gms.measurement.internal.zzel.zzZ     // Catch:{ RuntimeException -> 0x019e }
            r3 = 0
            boolean r0 = r0.zzs(r3, r1)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 == 0) goto L_0x015a
            if (r6 == 0) goto L_0x0144
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            r0.zzH(r4, r7, r6)     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzb     // Catch:{ RuntimeException -> 0x019e }
            r0.zza(r4, r6)     // Catch:{ RuntimeException -> 0x019e }
            goto L_0x0153
        L_0x0144:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzk     // Catch:{ RuntimeException -> 0x019e }
            java.lang.String r1 = "Referrer does not contain valid parameters"
            r0.zzb(r1, r5)     // Catch:{ RuntimeException -> 0x019e }
        L_0x0153:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            r1 = 0
            r0.zzY(r1)     // Catch:{ RuntimeException -> 0x019e }
            return
        L_0x015a:
            boolean r0 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 == 0) goto L_0x018e
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 != 0) goto L_0x0182
            boolean r0 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 != 0) goto L_0x0182
            boolean r0 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 != 0) goto L_0x0182
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 != 0) goto L_0x0182
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 == 0) goto L_0x018e
        L_0x0182:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x019e }
            if (r0 != 0) goto L_0x018d
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            r0.zzY(r5)     // Catch:{ RuntimeException -> 0x019e }
        L_0x018d:
            return
        L_0x018e:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ RuntimeException -> 0x019e }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzk     // Catch:{ RuntimeException -> 0x019e }
            r1 = r16
            r0.zza(r1)     // Catch:{ RuntimeException -> 0x019e }
            return
        L_0x019e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzin r1 = r2.zza
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzik.run():void");
    }
}
