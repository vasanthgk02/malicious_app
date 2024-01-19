package com.google.android.gms.internal.auth;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzcz<T> {
    public static final Object zza = new Object();
    public static final /* synthetic */ int zzd = 0;
    public static volatile zzcy zze;
    public static volatile boolean zzf;
    public static final AtomicReference<Collection<zzcz<?>>> zzg = new AtomicReference<>();
    public static final zzdb zzh = new zzdb(zzcr.zza, null);
    public static final AtomicInteger zzi = new AtomicInteger();
    public final zzcx zzb;
    public final String zzc;
    public final T zzj;
    public volatile int zzk = -1;
    public volatile T zzl;
    public final boolean zzm;

    public /* synthetic */ zzcz(zzcx zzcx, String str, Object obj, boolean z, zzct zzct) {
        if (zzcx.zzb != null) {
            this.zzb = zzcx;
            this.zzc = str;
            this.zzj = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(Context context) {
        if (zze == null) {
            synchronized (zza) {
                if (zze == null) {
                    synchronized (zza) {
                        zzcy zzcy = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzcy == null || zzcy.zza() != context) {
                            zzcg.zzd();
                            zzda.zzc();
                            zzcn.zze();
                            zze = new zzcd(context, zzdk.zza(new zzcs(context)));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    public abstract T zza(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzb() {
        /*
            r6 = this;
            boolean r0 = r6.zzm
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = r6.zzc
            if (r0 == 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "flagName must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r6.zzk
            if (r1 >= r0) goto L_0x0118
            monitor-enter(r6)
            int r1 = r6.zzk     // Catch:{ all -> 0x0115 }
            if (r1 >= r0) goto L_0x0113
            com.google.android.gms.internal.auth.zzcy r1 = zze     // Catch:{ all -> 0x0115 }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x010d
            com.google.android.gms.internal.auth.zzcx r2 = r6.zzb     // Catch:{ all -> 0x0115 }
            boolean r2 = r2.zzf     // Catch:{ all -> 0x0115 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcn r2 = com.google.android.gms.internal.auth.zzcn.zza(r2)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.String r2 = r2.zzb(r3)     // Catch:{ all -> 0x0115 }
            r3 = 0
            if (r2 == 0) goto L_0x006b
            java.util.regex.Pattern r4 = com.google.android.gms.internal.auth.zzcb.zzc     // Catch:{ all -> 0x0115 }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{ all -> 0x0115 }
            boolean r2 = r2.matches()     // Catch:{ all -> 0x0115 }
            if (r2 == 0) goto L_0x006b
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x0115 }
            if (r2 == 0) goto L_0x0069
            java.lang.String r2 = "Bypass reading Phenotype values for flag: "
            java.lang.String r4 = r6.zzc()     // Catch:{ all -> 0x0115 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0115 }
            int r5 = r4.length()     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x0064
            r2.concat(r4)     // Catch:{ all -> 0x0115 }
            goto L_0x0069
        L_0x0064:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0115 }
            r4.<init>(r2)     // Catch:{ all -> 0x0115 }
        L_0x0069:
            r2 = r3
            goto L_0x00b2
        L_0x006b:
            com.google.android.gms.internal.auth.zzcx r2 = r6.zzb     // Catch:{ all -> 0x0115 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x0115 }
            if (r2 == 0) goto L_0x0096
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcx r4 = r6.zzb     // Catch:{ all -> 0x0115 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0115 }
            boolean r2 = com.google.android.gms.internal.auth.zzcp.zza(r2, r4)     // Catch:{ all -> 0x0115 }
            if (r2 == 0) goto L_0x0094
            com.google.android.gms.internal.auth.zzcx r2 = r6.zzb     // Catch:{ all -> 0x0115 }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x0115 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0115 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcx r4 = r6.zzb     // Catch:{ all -> 0x0115 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcg r2 = com.google.android.gms.internal.auth.zzcg.zza(r2, r4)     // Catch:{ all -> 0x0115 }
            goto L_0x00a2
        L_0x0094:
            r2 = r3
            goto L_0x00a2
        L_0x0096:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcx r4 = r6.zzb     // Catch:{ all -> 0x0115 }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzda r2 = com.google.android.gms.internal.auth.zzda.zza(r2, r3)     // Catch:{ all -> 0x0115 }
        L_0x00a2:
            if (r2 == 0) goto L_0x0069
            java.lang.String r4 = r6.zzc()     // Catch:{ all -> 0x0115 }
            java.lang.Object r2 = r2.zzb(r4)     // Catch:{ all -> 0x0115 }
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x0115 }
        L_0x00b2:
            if (r2 == 0) goto L_0x00b5
            goto L_0x00dd
        L_0x00b5:
            com.google.android.gms.internal.auth.zzcx r2 = r6.zzb     // Catch:{ all -> 0x0115 }
            boolean r2 = r2.zze     // Catch:{ all -> 0x0115 }
            if (r2 != 0) goto L_0x00d8
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcn r2 = com.google.android.gms.internal.auth.zzcn.zza(r2)     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcx r4 = r6.zzb     // Catch:{ all -> 0x0115 }
            boolean r4 = r4.zze     // Catch:{ all -> 0x0115 }
            if (r4 == 0) goto L_0x00cb
            r4 = r3
            goto L_0x00cd
        L_0x00cb:
            java.lang.String r4 = r6.zzc     // Catch:{ all -> 0x0115 }
        L_0x00cd:
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x0115 }
            if (r2 == 0) goto L_0x00d8
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x0115 }
            goto L_0x00d9
        L_0x00d8:
            r2 = r3
        L_0x00d9:
            if (r2 != 0) goto L_0x00dd
            T r2 = r6.zzj     // Catch:{ all -> 0x0115 }
        L_0x00dd:
            com.google.android.gms.internal.auth.zzdg r1 = r1.zzb()     // Catch:{ all -> 0x0115 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzde r1 = (com.google.android.gms.internal.auth.zzde) r1     // Catch:{ all -> 0x0115 }
            boolean r4 = r1.zzb()     // Catch:{ all -> 0x0115 }
            if (r4 == 0) goto L_0x0108
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzco r1 = (com.google.android.gms.internal.auth.zzco) r1     // Catch:{ all -> 0x0115 }
            com.google.android.gms.internal.auth.zzcx r2 = r6.zzb     // Catch:{ all -> 0x0115 }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x0115 }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r6.zzc     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x0115 }
            if (r1 != 0) goto L_0x0104
            T r2 = r6.zzj     // Catch:{ all -> 0x0115 }
            goto L_0x0108
        L_0x0104:
            java.lang.Object r2 = r6.zza(r1)     // Catch:{ all -> 0x0115 }
        L_0x0108:
            r6.zzl = r2     // Catch:{ all -> 0x0115 }
            r6.zzk = r0     // Catch:{ all -> 0x0115 }
            goto L_0x0113
        L_0x010d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0115 }
            r0.<init>(r2)     // Catch:{ all -> 0x0115 }
            throw r0     // Catch:{ all -> 0x0115 }
        L_0x0113:
            monitor-exit(r6)     // Catch:{ all -> 0x0115 }
            goto L_0x0118
        L_0x0115:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0115 }
            throw r0
        L_0x0118:
            T r0 = r6.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcz.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }
}
