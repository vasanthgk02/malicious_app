package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzd extends zze {
    public final Map zza = new ArrayMap();
    public final Map zzb = new ArrayMap();
    public long zzc;

    public zzd(zzgi zzgi) {
        super(zzgi);
    }

    public final void zzd(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzs.zzaz().zzd.zza("Ad unit id must be a non-empty string");
        } else {
            this.zzs.zzaA().zzp(new zza(this, str, j));
        }
    }

    public final void zze(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzs.zzaz().zzd.zza("Ad unit id must be a non-empty string");
        } else {
            this.zzs.zzaA().zzp(new zzb(this, str, j));
        }
    }

    public final void zzf(long j) {
        zziu zzj = this.zzs.zzs().zzj(false);
        for (String str : this.zza.keySet()) {
            zzi(str, j - ((Long) this.zza.get(str)).longValue(), zzj);
        }
        if (!this.zza.isEmpty()) {
            zzh(j - this.zzc, zzj);
        }
        zzj(j);
    }

    public final void zzh(long j, zziu zziu) {
        if (zziu == null) {
            this.zzs.zzaz().zzl.zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            this.zzs.zzaz().zzl.zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzlp.zzK(zziu, bundle, true);
            this.zzs.zzq().zzH("am", "_xa", bundle);
        }
    }

    public final void zzi(String str, long j, zziu zziu) {
        if (zziu == null) {
            this.zzs.zzaz().zzl.zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            this.zzs.zzaz().zzl.zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzlp.zzK(zziu, bundle, true);
            this.zzs.zzq().zzH("am", "_xu", bundle);
        }
    }

    public final void zzj(long j) {
        for (String put : this.zza.keySet()) {
            this.zza.put(put, Long.valueOf(j));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j;
        }
    }
}
