package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzfl {
    @VisibleForTesting
    public final String zza;
    public final /* synthetic */ zzfn zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;

    public /* synthetic */ zzfl(zzfn zzfn, long j) {
        this.zzb = zzfn;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j > 0);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }

    public final void zzd() {
        this.zzb.zzg();
        long currentTimeMillis = this.zzb.zzs.zzr.currentTimeMillis();
        Editor edit = this.zzb.zza().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }
}
