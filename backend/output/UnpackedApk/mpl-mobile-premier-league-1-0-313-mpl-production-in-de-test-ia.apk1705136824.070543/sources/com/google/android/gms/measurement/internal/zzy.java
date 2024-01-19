package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzes;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzy extends zzx {
    public final /* synthetic */ zzz zza;
    public final zzes zzh;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzy(zzz zzz, String str, int i, zzes zzes) {
        // this.zza = zzz;
        super(str, i);
        this.zzh = zzes;
    }

    public final int zza() {
        return this.zzh.zza();
    }

    public final boolean zzb() {
        return false;
    }

    public final boolean zzc() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v18, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r7v24 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.Long r12, java.lang.Long r13, com.google.android.gms.internal.measurement.zzgl r14, boolean r15) {
        /*
            r11 = this;
            com.google.android.gms.internal.measurement.zzoi.zzc()
            com.google.android.gms.measurement.internal.zzz r0 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            java.lang.String r1 = r11.zzb
            com.google.android.gms.measurement.internal.zzek r2 = com.google.android.gms.measurement.internal.zzel.zzV
            boolean r0 = r0.zzs(r1, r2)
            com.google.android.gms.internal.measurement.zzes r1 = r11.zzh
            boolean r1 = r1.zzg()
            com.google.android.gms.internal.measurement.zzes r2 = r11.zzh
            boolean r2 = r2.zzh()
            com.google.android.gms.internal.measurement.zzes r3 = r11.zzh
            boolean r3 = r3.zzi()
            r4 = 1
            r5 = 0
            if (r1 != 0) goto L_0x002e
            if (r2 != 0) goto L_0x002e
            if (r3 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r1 = 0
            goto L_0x002f
        L_0x002e:
            r1 = 1
        L_0x002f:
            r2 = 0
            if (r15 == 0) goto L_0x005c
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzz r12 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r12 = r12.zzs
            com.google.android.gms.measurement.internal.zzey r12 = r12.zzaz()
            com.google.android.gms.measurement.internal.zzew r12 = r12.zzl
            int r13 = r11.zzc
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            com.google.android.gms.internal.measurement.zzes r14 = r11.zzh
            boolean r14 = r14.zzj()
            if (r14 == 0) goto L_0x0056
            com.google.android.gms.internal.measurement.zzes r14 = r11.zzh
            int r14 = r14.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
        L_0x0056:
            java.lang.String r14 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r12.zzc(r14, r13, r2)
            return r4
        L_0x005c:
            com.google.android.gms.internal.measurement.zzes r6 = r11.zzh
            com.google.android.gms.internal.measurement.zzel r6 = r6.zzb()
            boolean r7 = r6.zzg()
            boolean r8 = r14.zzr()
            if (r8 == 0) goto L_0x00a3
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzz r6 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzg
            com.google.android.gms.measurement.internal.zzz r7 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzq
            java.lang.String r8 = r14.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.zzb(r8, r7)
            goto L_0x018c
        L_0x0091:
            long r8 = r14.zzb()
            com.google.android.gms.internal.measurement.zzeq r2 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzh(r8, r2)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzj(r2, r7)
            goto L_0x018c
        L_0x00a3:
            boolean r8 = r14.zzq()
            if (r8 == 0) goto L_0x00e9
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x00ce
            com.google.android.gms.measurement.internal.zzz r6 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzg
            com.google.android.gms.measurement.internal.zzz r7 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzq
            java.lang.String r8 = r14.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.zzb(r8, r7)
            goto L_0x018c
        L_0x00ce:
            double r8 = r14.zza()
            com.google.android.gms.internal.measurement.zzeq r6 = r6.zzc()
            java.math.BigDecimal r10 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x00e3 }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x00e3 }
            double r8 = java.lang.Math.ulp(r8)     // Catch:{ NumberFormatException -> 0x00e3 }
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zze(r10, r6, r8)     // Catch:{ NumberFormatException -> 0x00e3 }
        L_0x00e3:
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzj(r2, r7)
            goto L_0x018c
        L_0x00e9:
            boolean r8 = r14.zzt()
            if (r8 == 0) goto L_0x016f
            boolean r8 = r6.zzk()
            if (r8 != 0) goto L_0x0156
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzz r6 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzg
            com.google.android.gms.measurement.internal.zzz r7 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzq
            java.lang.String r8 = r14.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.zzb(r8, r7)
            goto L_0x018c
        L_0x0119:
            java.lang.String r8 = r14.zzg()
            boolean r8 = com.google.android.gms.measurement.internal.zzlk.zzx(r8)
            if (r8 == 0) goto L_0x0134
            java.lang.String r2 = r14.zzg()
            com.google.android.gms.internal.measurement.zzeq r6 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzi(r2, r6)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzj(r2, r7)
            goto L_0x018c
        L_0x0134:
            com.google.android.gms.measurement.internal.zzz r6 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzg
            com.google.android.gms.measurement.internal.zzz r7 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzq
            java.lang.String r8 = r14.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = r14.zzg()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.zzc(r9, r7, r8)
            goto L_0x018c
        L_0x0156:
            java.lang.String r2 = r14.zzg()
            com.google.android.gms.internal.measurement.zzex r6 = r6.zzd()
            com.google.android.gms.measurement.internal.zzz r8 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r8 = r8.zzs
            com.google.android.gms.measurement.internal.zzey r8 = r8.zzaz()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzf(r2, r6, r8)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.zzx.zzj(r2, r7)
            goto L_0x018c
        L_0x016f:
            com.google.android.gms.measurement.internal.zzz r6 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzg
            com.google.android.gms.measurement.internal.zzz r7 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzq
            java.lang.String r8 = r14.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.zzb(r8, r7)
        L_0x018c:
            com.google.android.gms.measurement.internal.zzz r6 = r11.zza
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzl
            if (r2 != 0) goto L_0x019b
            java.lang.String r7 = "null"
            goto L_0x019c
        L_0x019b:
            r7 = r2
        L_0x019c:
            java.lang.String r8 = "Property filter result"
            r6.zzb(r8, r7)
            if (r2 != 0) goto L_0x01a4
            return r5
        L_0x01a4:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r11.zzd = r5
            if (r3 == 0) goto L_0x01b2
            boolean r3 = r2.booleanValue()
            if (r3 == 0) goto L_0x01b1
            goto L_0x01b2
        L_0x01b1:
            return r4
        L_0x01b2:
            if (r15 == 0) goto L_0x01bc
            com.google.android.gms.internal.measurement.zzes r15 = r11.zzh
            boolean r15 = r15.zzg()
            if (r15 == 0) goto L_0x01be
        L_0x01bc:
            r11.zze = r2
        L_0x01be:
            boolean r15 = r2.booleanValue()
            if (r15 == 0) goto L_0x0203
            if (r1 == 0) goto L_0x0203
            boolean r15 = r14.zzs()
            if (r15 == 0) goto L_0x0203
            long r14 = r14.zzc()
            if (r12 == 0) goto L_0x01d6
            long r14 = r12.longValue()
        L_0x01d6:
            if (r0 == 0) goto L_0x01ee
            com.google.android.gms.internal.measurement.zzes r12 = r11.zzh
            boolean r12 = r12.zzg()
            if (r12 == 0) goto L_0x01ee
            com.google.android.gms.internal.measurement.zzes r12 = r11.zzh
            boolean r12 = r12.zzh()
            if (r12 != 0) goto L_0x01ee
            if (r13 == 0) goto L_0x01ee
            long r14 = r13.longValue()
        L_0x01ee:
            com.google.android.gms.internal.measurement.zzes r12 = r11.zzh
            boolean r12 = r12.zzh()
            if (r12 == 0) goto L_0x01fd
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            r11.zzg = r12
            goto L_0x0203
        L_0x01fd:
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            r11.zzf = r12
        L_0x0203:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzd(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzgl, boolean):boolean");
    }
}
