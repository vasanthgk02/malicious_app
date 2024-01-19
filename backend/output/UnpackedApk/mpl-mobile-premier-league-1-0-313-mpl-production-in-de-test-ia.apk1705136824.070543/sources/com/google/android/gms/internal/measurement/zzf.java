package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzf {
    public final zzax zza;
    public final zzg zzb;
    public final zzg zzc;
    public final zzj zzd = new zzj();

    public zzf() {
        zzax zzax = new zzax();
        this.zza = zzax;
        zzg zzg = new zzg(null, zzax);
        this.zzc = zzg;
        this.zzb = zzg.zza();
        this.zzc.zzg("require", new zzw(this.zzd));
        this.zzd.zza("internal.platform", zze.zza);
        this.zzc.zzg("runtime.counter", new zzah(Double.valueOf(0.0d)));
    }

    public final zzap zza(zzg zzg, zzgx... zzgxArr) {
        zzap zzap = zzap.zzf;
        for (zzgx zza2 : zzgxArr) {
            zzap = zzi.zza(zza2);
            zzh.zzc(this.zzc);
            if ((zzap instanceof zzaq) || (zzap instanceof zzao)) {
                zzap = this.zza.zza(zzg, zzap);
            }
        }
        return zzap;
    }
}
