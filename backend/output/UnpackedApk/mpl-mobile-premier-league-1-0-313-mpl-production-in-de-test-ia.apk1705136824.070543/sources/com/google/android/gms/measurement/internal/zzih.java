package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzih implements Runnable {
    public final /* synthetic */ zzah zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzah zzf;
    public final /* synthetic */ zzin zzg;

    public zzih(zzin zzin, zzah zzah, long j, int i, long j2, boolean z, zzah zzah2) {
        this.zzg = zzin;
        this.zza = zzah;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
        this.zzf = zzah2;
    }

    public final void run() {
        this.zzg.zzX(this.zza);
        this.zzg.zzM(this.zzb, false);
        zzin.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzpp.zzc();
        if (this.zzg.zzs.zzk.zzs(null, zzel.zzaI)) {
            zzin.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
