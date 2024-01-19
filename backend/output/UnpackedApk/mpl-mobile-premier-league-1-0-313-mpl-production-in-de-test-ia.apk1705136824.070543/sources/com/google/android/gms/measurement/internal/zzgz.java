package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpm;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgz implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzha zze;

    public zzgz(zzha zzha, String str, String str2, String str3, long j) {
        this.zze = zzha;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        zzpm.zzc();
        if (this.zze.zza.zzg().zzs(null, zzel.zzat)) {
            String str = this.zza;
            if (str == null) {
                this.zze.zza.zzQ(this.zzb, null);
                return;
            }
            this.zze.zza.zzQ(this.zzb, new zziu(this.zzc, str, this.zzd));
            return;
        }
        String str2 = this.zza;
        if (str2 == null) {
            this.zze.zza.zzn.zzs().zzy(this.zzb, null);
            return;
        }
        this.zze.zza.zzn.zzs().zzy(this.zzb, new zziu(this.zzc, str2, this.zzd));
    }
}
