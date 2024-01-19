package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzgh implements Runnable {
    public final /* synthetic */ zzhl zza;
    public final /* synthetic */ zzgi zzb;

    public zzgh(zzgi zzgi, zzhl zzhl) {
        this.zzb = zzgi;
        this.zza = zzhl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x028c, code lost:
        if (android.text.TextUtils.isEmpty(r1.zzl) == false) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x03df, code lost:
        if (android.text.TextUtils.isEmpty(r1.zzl) == false) goto L_0x03e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.zzgi r0 = r12.zzb
            com.google.android.gms.measurement.internal.zzhl r1 = r12.zza
            com.google.android.gms.measurement.internal.zzgf r2 = r0.zzaA()
            r2.zzg()
            com.google.android.gms.measurement.internal.zzaf r2 = r0.zzk
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzj
            com.google.android.gms.measurement.internal.zzap r2 = new com.google.android.gms.measurement.internal.zzap
            r2.<init>(r0)
            r2.zzv()
            r0.zzz = r2
            com.google.android.gms.measurement.internal.zzep r2 = new com.google.android.gms.measurement.internal.zzep
            long r3 = r1.zzf
            r2.<init>(r0, r3)
            r2.zzb()
            r0.zzA = r2
            com.google.android.gms.measurement.internal.zzer r1 = new com.google.android.gms.measurement.internal.zzer
            r1.<init>(r0)
            r1.zzb()
            r0.zzx = r1
            com.google.android.gms.measurement.internal.zzkb r1 = new com.google.android.gms.measurement.internal.zzkb
            r1.<init>(r0)
            r1.zzb()
            r0.zzy = r1
            com.google.android.gms.measurement.internal.zzlp r1 = r0.zzp
            r1.zzw()
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzl
            r1.zzw()
            com.google.android.gms.measurement.internal.zzep r1 = r0.zzA
            boolean r3 = r1.zza
            if (r3 != 0) goto L_0x0451
            r1.zzd()
            com.google.android.gms.measurement.internal.zzgi r3 = r1.zzs
            java.util.concurrent.atomic.AtomicInteger r3 = r3.zzH
            r3.incrementAndGet()
            r3 = 1
            r1.zza = r3
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzj
            com.google.android.gms.measurement.internal.zzaf r4 = r0.zzk
            r4.zzh()
            r4 = 61000(0xee48, double:3.0138E-319)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "App measurement initialized, version"
            r1.zzb(r5, r4)
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzj
            java.lang.String r4 = "To enable debug logging run: adb shell setprop log.tag.FA VERBOSE"
            r1.zza(r4)
            java.lang.String r1 = r2.zzl()
            java.lang.String r2 = r0.zzf
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzlp r2 = r0.zzv()
            boolean r2 = r2.zzae(r1)
            if (r2 == 0) goto L_0x009c
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzj
            java.lang.String r2 = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none."
            r1.zza(r2)
            goto L_0x00af
        L_0x009c:
            com.google.android.gms.measurement.internal.zzey r2 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzj
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r4 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app "
            java.lang.String r1 = r4.concat(r1)
            r2.zza(r1)
        L_0x00af:
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzk
            java.lang.String r2 = "Debug-level message logging enabled"
            r1.zza(r2)
            int r1 = r0.zzG
            java.util.concurrent.atomic.AtomicInteger r2 = r0.zzH
            int r2 = r2.get()
            if (r1 == r2) goto L_0x00df
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            int r2 = r0.zzG
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.util.concurrent.atomic.AtomicInteger r4 = r0.zzH
            int r4 = r4.get()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Not all components initialized"
            r1.zzc(r5, r2, r4)
        L_0x00df:
            r0.zzB = r3
            com.google.android.gms.measurement.internal.zzgi r0 = r12.zzb
            com.google.android.gms.measurement.internal.zzhl r1 = r12.zza
            com.google.android.gms.internal.measurement.zzcl r1 = r1.zzg
            com.google.android.gms.measurement.internal.zzgf r2 = r0.zzaA()
            r2.zzg()
            com.google.android.gms.measurement.internal.zzfn r2 = r0.zzm()
            com.google.android.gms.measurement.internal.zzah r2 = r2.zzc()
            com.google.android.gms.measurement.internal.zzfn r4 = r0.zzm()
            com.google.android.gms.measurement.internal.zzgi r5 = r4.zzs
            r4.zzg()
            android.content.SharedPreferences r4 = r4.zza()
            r5 = 100
            java.lang.String r6 = "consent_source"
            int r4 = r4.getInt(r6, r5)
            com.google.android.gms.measurement.internal.zzaf r6 = r0.zzk
            com.google.android.gms.measurement.internal.zzgi r7 = r6.zzs
            java.lang.String r7 = "google_analytics_default_allow_ad_storage"
            java.lang.Boolean r6 = r6.zzk(r7)
            com.google.android.gms.measurement.internal.zzaf r7 = r0.zzk
            com.google.android.gms.measurement.internal.zzgi r8 = r7.zzs
            java.lang.String r8 = "google_analytics_default_allow_analytics_storage"
            java.lang.Boolean r7 = r7.zzk(r8)
            r8 = 0
            r9 = 30
            r10 = -10
            if (r6 != 0) goto L_0x0128
            if (r7 == 0) goto L_0x013a
        L_0x0128:
            com.google.android.gms.measurement.internal.zzfn r11 = r0.zzm()
            boolean r11 = r11.zzl(r10)
            if (r11 == 0) goto L_0x013a
            com.google.android.gms.measurement.internal.zzah r1 = new com.google.android.gms.measurement.internal.zzah
            r1.<init>(r6, r7)
            r5 = -10
            goto L_0x0194
        L_0x013a:
            com.google.android.gms.measurement.internal.zzep r6 = r0.zzh()
            java.lang.String r6 = r6.zzm()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0164
            if (r4 == 0) goto L_0x0158
            if (r4 == r9) goto L_0x0158
            r6 = 10
            if (r4 == r6) goto L_0x0158
            if (r4 == r9) goto L_0x0158
            if (r4 == r9) goto L_0x0158
            r6 = 40
            if (r4 != r6) goto L_0x0164
        L_0x0158:
            com.google.android.gms.measurement.internal.zzin r1 = r0.zzq()
            com.google.android.gms.measurement.internal.zzah r4 = com.google.android.gms.measurement.internal.zzah.zza
            long r6 = r0.zzc
            r1.zzT(r4, r10, r6)
            goto L_0x0193
        L_0x0164:
            com.google.android.gms.measurement.internal.zzep r4 = r0.zzh()
            java.lang.String r4 = r4.zzm()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0193
            if (r1 == 0) goto L_0x0193
            android.os.Bundle r4 = r1.zzg
            if (r4 == 0) goto L_0x0193
            com.google.android.gms.measurement.internal.zzfn r4 = r0.zzm()
            boolean r4 = r4.zzl(r9)
            if (r4 == 0) goto L_0x0193
            android.os.Bundle r1 = r1.zzg
            com.google.android.gms.measurement.internal.zzah r1 = com.google.android.gms.measurement.internal.zzah.zza(r1)
            com.google.android.gms.measurement.internal.zzah r4 = com.google.android.gms.measurement.internal.zzah.zza
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0193
            r5 = 30
            goto L_0x0194
        L_0x0193:
            r1 = r8
        L_0x0194:
            if (r1 == 0) goto L_0x01a0
            com.google.android.gms.measurement.internal.zzin r2 = r0.zzq()
            long r6 = r0.zzc
            r2.zzT(r1, r5, r6)
            r2 = r1
        L_0x01a0:
            com.google.android.gms.measurement.internal.zzin r1 = r0.zzq()
            r1.zzX(r2)
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzc
            long r1 = r1.zza()
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x01d3
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl
            long r4 = r0.zzc
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "Persisting first open"
            r1.zzb(r4, r2)
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzc
            long r4 = r0.zzc
            r1.zzb(r4)
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzin r1 = r0.zzq()
            com.google.android.gms.measurement.internal.zzr r1 = r1.zzb
            boolean r2 = r1.zzd()
            if (r2 == 0) goto L_0x01f0
            boolean r2 = r1.zze()
            if (r2 == 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zza
            com.google.android.gms.measurement.internal.zzfn r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzp
            r1.zzb(r8)
        L_0x01f0:
            boolean r1 = r0.zzM()
            if (r1 != 0) goto L_0x0271
            boolean r1 = r0.zzJ()
            if (r1 == 0) goto L_0x0447
            com.google.android.gms.measurement.internal.zzlp r1 = r0.zzv()
            java.lang.String r2 = "android.permission.INTERNET"
            boolean r1 = r1.zzad(r2)
            if (r1 != 0) goto L_0x0213
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.String r2 = "App is missing INTERNET permission"
            r1.zza(r2)
        L_0x0213:
            com.google.android.gms.measurement.internal.zzlp r1 = r0.zzv()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r1.zzad(r2)
            if (r1 != 0) goto L_0x022a
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.String r2 = "App is missing ACCESS_NETWORK_STATE permission"
            r1.zza(r2)
        L_0x022a:
            android.content.Context r1 = r0.zze
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)
            boolean r1 = r1.isCallerInstantApp()
            if (r1 != 0) goto L_0x0264
            com.google.android.gms.measurement.internal.zzaf r1 = r0.zzk
            boolean r1 = r1.zzx()
            if (r1 != 0) goto L_0x0264
            android.content.Context r1 = r0.zze
            boolean r1 = com.google.android.gms.measurement.internal.zzlp.zzaj(r1)
            if (r1 != 0) goto L_0x0251
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.String r2 = "AppMeasurementReceiver not registered/enabled"
            r1.zza(r2)
        L_0x0251:
            android.content.Context r1 = r0.zze
            boolean r1 = com.google.android.gms.measurement.internal.zzlp.zzak(r1)
            if (r1 != 0) goto L_0x0264
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.String r2 = "AppMeasurementService not registered/enabled"
            r1.zza(r2)
        L_0x0264:
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.String r2 = "Uploading is not possible. App measurement disabled"
            r1.zza(r2)
            goto L_0x0447
        L_0x0271:
            com.google.android.gms.measurement.internal.zzep r1 = r0.zzh()
            java.lang.String r1 = r1.zzm()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x028e
            com.google.android.gms.measurement.internal.zzep r1 = r0.zzh()
            r1.zza()
            java.lang.String r1 = r1.zzl
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0354
        L_0x028e:
            com.google.android.gms.measurement.internal.zzlp r1 = r0.zzv()
            com.google.android.gms.measurement.internal.zzep r2 = r0.zzh()
            java.lang.String r2 = r2.zzm()
            com.google.android.gms.measurement.internal.zzfn r4 = r0.zzm()
            r4.zzg()
            android.content.SharedPreferences r4 = r4.zza()
            java.lang.String r5 = "gmp_app_id"
            java.lang.String r4 = r4.getString(r5, r8)
            com.google.android.gms.measurement.internal.zzep r6 = r0.zzh()
            r6.zza()
            java.lang.String r6 = r6.zzl
            com.google.android.gms.measurement.internal.zzfn r7 = r0.zzm()
            r7.zzg()
            android.content.SharedPreferences r7 = r7.zza()
            java.lang.String r9 = "admob_app_id"
            java.lang.String r7 = r7.getString(r9, r8)
            boolean r1 = r1.zzan(r2, r4, r6, r7)
            if (r1 == 0) goto L_0x0319
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzj
            java.lang.String r2 = "Rechecking which service to use due to a GMP App Id change"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            r1.zzg()
            java.lang.Boolean r2 = r1.zzd()
            android.content.SharedPreferences r4 = r1.zza()
            android.content.SharedPreferences$Editor r4 = r4.edit()
            r4.clear()
            r4.apply()
            if (r2 == 0) goto L_0x02f4
            r1.zzh(r2)
        L_0x02f4:
            com.google.android.gms.measurement.internal.zzer r1 = r0.zzi()
            r1.zzj()
            com.google.android.gms.measurement.internal.zzkb r1 = r0.zzy
            r1.zzs()
            com.google.android.gms.measurement.internal.zzkb r1 = r0.zzy
            r1.zzr()
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzc
            long r6 = r0.zzc
            r1.zzb(r6)
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zze
            r1.zzb(r8)
        L_0x0319:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzep r2 = r0.zzh()
            java.lang.String r2 = r2.zzm()
            r1.zzg()
            android.content.SharedPreferences r1 = r1.zza()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r5, r2)
            r1.apply()
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzep r2 = r0.zzh()
            r2.zza()
            java.lang.String r2 = r2.zzl
            r1.zzg()
            android.content.SharedPreferences r1 = r1.zza()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r9, r2)
            r1.apply()
        L_0x0354:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzah r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzag r2 = com.google.android.gms.measurement.internal.zzag.ANALYTICS_STORAGE
            boolean r1 = r1.zzi(r2)
            if (r1 != 0) goto L_0x036d
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zze
            r1.zzb(r8)
        L_0x036d:
            com.google.android.gms.measurement.internal.zzin r1 = r0.zzq()
            com.google.android.gms.measurement.internal.zzfn r2 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zze
            java.lang.String r2 = r2.zza()
            java.util.concurrent.atomic.AtomicReference r1 = r1.zzg
            r1.set(r2)
            com.google.android.gms.internal.measurement.zzoc.zzc()
            com.google.android.gms.measurement.internal.zzaf r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzek r2 = com.google.android.gms.measurement.internal.zzel.zzad
            boolean r1 = r1.zzs(r8, r2)
            if (r1 == 0) goto L_0x03c4
            com.google.android.gms.measurement.internal.zzlp r1 = r0.zzv()
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs     // Catch:{ ClassNotFoundException -> 0x039f }
            android.content.Context r1 = r1.zze     // Catch:{ ClassNotFoundException -> 0x039f }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x039f }
            java.lang.String r2 = "com.google.firebase.remoteconfig.FirebaseRemoteConfig"
            r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x039f }
            goto L_0x03c4
        L_0x039f:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzo
            java.lang.String r1 = r1.zza()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x03c4
            com.google.android.gms.measurement.internal.zzey r1 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzg
            java.lang.String r2 = "Remote config removed with active feature rollouts"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzo
            r1.zzb(r8)
        L_0x03c4:
            com.google.android.gms.measurement.internal.zzep r1 = r0.zzh()
            java.lang.String r1 = r1.zzm()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x03e1
            com.google.android.gms.measurement.internal.zzep r1 = r0.zzh()
            r1.zza()
            java.lang.String r1 = r1.zzl
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0447
        L_0x03e1:
            boolean r1 = r0.zzJ()
            com.google.android.gms.measurement.internal.zzfn r2 = r0.zzm()
            android.content.SharedPreferences r2 = r2.zzt
            r4 = 0
            if (r2 != 0) goto L_0x03f0
            r2 = 0
            goto L_0x03f6
        L_0x03f0:
            java.lang.String r5 = "deferred_analytics_collection"
            boolean r2 = r2.contains(r5)
        L_0x03f6:
            if (r2 != 0) goto L_0x0409
            com.google.android.gms.measurement.internal.zzaf r2 = r0.zzk
            boolean r2 = r2.zzv()
            if (r2 != 0) goto L_0x0409
            com.google.android.gms.measurement.internal.zzfn r2 = r0.zzm()
            r5 = r1 ^ 1
            r2.zzi(r5)
        L_0x0409:
            if (r1 == 0) goto L_0x0412
            com.google.android.gms.measurement.internal.zzin r1 = r0.zzq()
            r1.zzz()
        L_0x0412:
            com.google.android.gms.measurement.internal.zzkr r1 = r0.zzu()
            com.google.android.gms.measurement.internal.zzkq r1 = r1.zza
            r1.zza()
            com.google.android.gms.measurement.internal.zzkb r1 = r0.zzt()
            java.util.concurrent.atomic.AtomicReference r2 = new java.util.concurrent.atomic.AtomicReference
            r2.<init>()
            r1.zzu(r2)
            com.google.android.gms.measurement.internal.zzkb r1 = r0.zzt()
            com.google.android.gms.measurement.internal.zzfn r2 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfi r2 = r2.zzr
            android.os.Bundle r2 = r2.zza()
            r1.zzg()
            r1.zza()
            com.google.android.gms.measurement.internal.zzp r4 = r1.zzO(r4)
            com.google.android.gms.measurement.internal.zzjk r5 = new com.google.android.gms.measurement.internal.zzjk
            r5.<init>(r1, r4, r2)
            r1.zzR(r5)
        L_0x0447:
            com.google.android.gms.measurement.internal.zzfn r0 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfh r0 = r0.zzi
            r0.zza(r3)
            return
        L_0x0451:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Can't initialize twice"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgh.run():void");
    }
}
