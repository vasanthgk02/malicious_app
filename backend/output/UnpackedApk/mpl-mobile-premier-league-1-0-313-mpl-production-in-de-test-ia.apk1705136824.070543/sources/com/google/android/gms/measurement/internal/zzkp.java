package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzol;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkp {
    @VisibleForTesting
    public long zza;
    @VisibleForTesting
    public long zzb;
    public final /* synthetic */ zzkr zzc;
    public final zzao zzd = new zzko(this, this.zzc.zzs);

    public zzkp(zzkr zzkr) {
        this.zzc = zzkr;
        long elapsedRealtime = zzkr.zzs.zzr.elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        this.zzc.zzg();
        this.zzc.zza();
        zzol.zzc();
        if (!this.zzc.zzs.zzk.zzs(null, zzel.zzae)) {
            this.zzc.zzs.zzm().zzj.zzb(this.zzc.zzs.zzr.currentTimeMillis());
        } else if (this.zzc.zzs.zzJ()) {
            this.zzc.zzs.zzm().zzj.zzb(this.zzc.zzs.zzr.currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            this.zzc.zzs.zzaz().zzl.zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzlp.zzK(this.zzc.zzs.zzs().zzj(!this.zzc.zzs.zzk.zzu()), bundle, true);
            if (!z2) {
                this.zzc.zzs.zzq().zzH("auto", "_e", bundle);
            }
            this.zza = j;
            this.zzd.zzb();
            this.zzd.zzd(3600000);
            return true;
        }
        this.zzc.zzs.zzaz().zzl.zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
