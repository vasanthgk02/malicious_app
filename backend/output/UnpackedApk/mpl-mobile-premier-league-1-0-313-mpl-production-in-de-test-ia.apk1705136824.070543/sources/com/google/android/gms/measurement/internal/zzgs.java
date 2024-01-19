package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgs implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzha zzb;

    public zzgs(zzha zzha, zzp zzp) {
        this.zzb = zzha;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzA();
        zzli zzli = this.zzb.zza;
        zzp zzp = this.zza;
        zzli.zzaA().zzg();
        zzli.zzB();
        Preconditions.checkNotEmpty(zzp.zza);
        zzah zzb2 = zzah.zzb(zzp.zzv);
        zzah zzh = zzli.zzh(zzp.zza);
        zzli.zzaz().zzl.zzc("Setting consent, package, consent", zzp.zza, zzb2);
        zzli.zzU(zzp.zza, zzb2);
        if (zzb2.zzk(zzh)) {
            zzli.zzP(zzp);
        }
    }
}
