package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgk implements Runnable {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ zzha zzc;

    public zzgk(zzha zzha, zzab zzab, zzp zzp) {
        this.zzc = zzha;
        this.zza = zzab;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzN(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzT(this.zza, this.zzb);
        }
    }
}
