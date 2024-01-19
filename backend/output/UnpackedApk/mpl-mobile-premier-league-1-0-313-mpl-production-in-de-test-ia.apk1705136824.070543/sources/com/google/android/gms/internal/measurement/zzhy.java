package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public abstract class zzhy {
    public static final /* synthetic */ int zzc = 0;
    public static final Object zzd = new Object();
    public static volatile zzhw zze;
    public static volatile boolean zzf;
    public static final AtomicReference zzg = new AtomicReference();
    public static final zzia zzh = new zzia(zzhp.zza, null);
    public static final AtomicInteger zzi = new AtomicInteger();
    public final zzhv zza;
    public final String zzb;
    public final Object zzj;
    public volatile int zzk = -1;
    public volatile Object zzl;
    public final boolean zzm;

    public /* synthetic */ zzhy(zzhv zzhv, String str, Object obj, boolean z, zzhx zzhx) {
        if (zzhv.zzb != null) {
            this.zza = zzhv;
            this.zzb = str;
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
            synchronized (zzd) {
                if (zze == null) {
                    synchronized (zzd) {
                        zzhw zzhw = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzhw == null || zzhw.zza() != context) {
                            zzhe.zze();
                            zzhz.zzc();
                            zzhm.zze();
                            zze = new zzhb(context, zzij.zza(new zzhq(context)));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    public abstract Object zza(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb() {
        /*
            r6 = this;
            boolean r0 = r6.zzm
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = r6.zzb
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
            if (r1 >= r0) goto L_0x0111
            monitor-enter(r6)
            int r1 = r6.zzk     // Catch:{ all -> 0x010e }
            if (r1 >= r0) goto L_0x010c
            com.google.android.gms.internal.measurement.zzhw r1 = zze     // Catch:{ all -> 0x010e }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x0106
            com.google.android.gms.internal.measurement.zzhv r2 = r6.zza     // Catch:{ all -> 0x010e }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x010e }
            boolean r2 = r2.zzg     // Catch:{ all -> 0x010e }
            r3 = 0
            if (r2 != 0) goto L_0x0062
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhm r2 = com.google.android.gms.internal.measurement.zzhm.zza(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r4 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x0062
            java.util.regex.Pattern r4 = com.google.android.gms.internal.measurement.zzgz.zzc     // Catch:{ all -> 0x010e }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{ all -> 0x010e }
            boolean r2 = r2.matches()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x0062
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x00aa
            java.lang.String r2 = "Bypass reading Phenotype values for flag: "
            java.lang.String r4 = r6.zzc()     // Catch:{ all -> 0x010e }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x010e }
            r2.concat(r4)     // Catch:{ all -> 0x010e }
            goto L_0x00aa
        L_0x0062:
            com.google.android.gms.internal.measurement.zzhv r2 = r6.zza     // Catch:{ all -> 0x010e }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x008d
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhv r4 = r6.zza     // Catch:{ all -> 0x010e }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x010e }
            boolean r2 = com.google.android.gms.internal.measurement.zzhn.zza(r2, r4)     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x008b
            com.google.android.gms.internal.measurement.zzhv r2 = r6.zza     // Catch:{ all -> 0x010e }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x010e }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x010e }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhv r4 = r6.zza     // Catch:{ all -> 0x010e }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhe r2 = com.google.android.gms.internal.measurement.zzhe.zza(r2, r4)     // Catch:{ all -> 0x010e }
            goto L_0x0099
        L_0x008b:
            r2 = r3
            goto L_0x0099
        L_0x008d:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhv r4 = r6.zza     // Catch:{ all -> 0x010e }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhz r2 = com.google.android.gms.internal.measurement.zzhz.zza(r2, r3)     // Catch:{ all -> 0x010e }
        L_0x0099:
            if (r2 == 0) goto L_0x00aa
            java.lang.String r4 = r6.zzc()     // Catch:{ all -> 0x010e }
            java.lang.Object r2 = r2.zzb(r4)     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x00aa
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x010e }
            goto L_0x00ab
        L_0x00aa:
            r2 = r3
        L_0x00ab:
            if (r2 == 0) goto L_0x00ae
            goto L_0x00d6
        L_0x00ae:
            com.google.android.gms.internal.measurement.zzhv r2 = r6.zza     // Catch:{ all -> 0x010e }
            boolean r2 = r2.zze     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x00d1
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhm r2 = com.google.android.gms.internal.measurement.zzhm.zza(r2)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhv r4 = r6.zza     // Catch:{ all -> 0x010e }
            boolean r4 = r4.zze     // Catch:{ all -> 0x010e }
            if (r4 == 0) goto L_0x00c4
            r4 = r3
            goto L_0x00c6
        L_0x00c4:
            java.lang.String r4 = r6.zzb     // Catch:{ all -> 0x010e }
        L_0x00c6:
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x00d1
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x010e }
            goto L_0x00d2
        L_0x00d1:
            r2 = r3
        L_0x00d2:
            if (r2 != 0) goto L_0x00d6
            java.lang.Object r2 = r6.zzj     // Catch:{ all -> 0x010e }
        L_0x00d6:
            com.google.android.gms.internal.measurement.zzif r1 = r1.zzb()     // Catch:{ all -> 0x010e }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzid r1 = (com.google.android.gms.internal.measurement.zzid) r1     // Catch:{ all -> 0x010e }
            boolean r4 = r1.zzb()     // Catch:{ all -> 0x010e }
            if (r4 == 0) goto L_0x0101
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhg r1 = (com.google.android.gms.internal.measurement.zzhg) r1     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.measurement.zzhv r2 = r6.zza     // Catch:{ all -> 0x010e }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x010e }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r6.zzb     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x010e }
            if (r1 != 0) goto L_0x00fd
            java.lang.Object r2 = r6.zzj     // Catch:{ all -> 0x010e }
            goto L_0x0101
        L_0x00fd:
            java.lang.Object r2 = r6.zza(r1)     // Catch:{ all -> 0x010e }
        L_0x0101:
            r6.zzl = r2     // Catch:{ all -> 0x010e }
            r6.zzk = r0     // Catch:{ all -> 0x010e }
            goto L_0x010c
        L_0x0106:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r0.<init>(r2)     // Catch:{ all -> 0x010e }
            throw r0     // Catch:{ all -> 0x010e }
        L_0x010c:
            monitor-exit(r6)     // Catch:{ all -> 0x010e }
            goto L_0x0111
        L_0x010e:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x010e }
            throw r0
        L_0x0111:
            java.lang.Object r0 = r6.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhy.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zza.zzd;
        return this.zzb;
    }
}
