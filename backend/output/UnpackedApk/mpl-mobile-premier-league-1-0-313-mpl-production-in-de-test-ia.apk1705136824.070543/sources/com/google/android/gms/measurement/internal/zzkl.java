package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzkl implements Runnable {
    public final /* synthetic */ zzkm zza;

    public /* synthetic */ zzkl(zzkm zzkm) {
        this.zza = zzkm;
    }

    public final void run() {
        zzkm zzkm = this.zza;
        zzkn zzkn = zzkm.zzc;
        long j = zzkm.zza;
        long j2 = zzkm.zzb;
        zzkn.zza.zzg();
        zzkn.zza.zzs.zzaz().zzk.zza("Application going to the background");
        zzkn.zza.zzs.zzm().zzl.zza(true);
        Bundle bundle = new Bundle();
        if (!zzkn.zza.zzs.zzk.zzu()) {
            zzkn.zza.zzb.zzd.zzb();
            zzkn.zza.zzb.zzd(false, false, j2);
        }
        zzkn.zza.zzs.zzq().zzI("auto", "_ab", j, bundle);
    }
}
