package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzky implements Runnable {
    public final /* synthetic */ zzlj zza;
    public final /* synthetic */ zzli zzb;

    public zzky(zzli zzli, zzlj zzlj) {
        this.zzb = zzli;
        this.zza = zzlj;
    }

    public final void run() {
        zzli zzli = this.zzb;
        zzli.zzaA().zzg();
        zzli.zzm = new zzfq(zzli);
        zzal zzal = new zzal(zzli);
        zzal.zzX();
        zzli.zze = zzal;
        zzaf zzg = zzli.zzg();
        zzfz zzfz = zzli.zzc;
        Preconditions.checkNotNull(zzfz);
        zzg.zzb = zzfz;
        zzkd zzkd = new zzkd(zzli);
        zzkd.zzX();
        zzli.zzk = zzkd;
        zzz zzz = new zzz(zzli);
        zzz.zzX();
        zzli.zzh = zzz;
        zzis zzis = new zzis(zzli);
        zzis.zzX();
        zzli.zzj = zzis;
        zzku zzku = new zzku(zzli);
        zzku.zzX();
        zzli.zzg = zzku;
        zzli.zzf = new zzfg(zzli);
        if (zzli.zzr != zzli.zzs) {
            zzli.zzaz().zzd.zzc("Not all upload components initialized", Integer.valueOf(zzli.zzr), Integer.valueOf(zzli.zzs));
        }
        zzli.zzo = true;
        zzli zzli2 = this.zzb;
        zzli2.zzaA().zzg();
        zzal zzal2 = zzli2.zze;
        zzli.zzak(zzal2);
        zzal2.zzz();
        if (zzli2.zzk.zzc.zza() == 0) {
            zzli2.zzk.zzc.zzb(zzli2.zzaw().currentTimeMillis());
        }
        zzli2.zzaf();
    }
}
