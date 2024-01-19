package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zziv implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zziu zzb;
    public final /* synthetic */ zziu zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzjb zze;

    public zziv(zzjb zzjb, Bundle bundle, zziu zziu, zziu zziu2, long j) {
        this.zze = zzjb;
        this.zza = bundle;
        this.zzb = zziu;
        this.zzc = zziu2;
        this.zzd = j;
    }

    public final void run() {
        zzjb zzjb = this.zze;
        Bundle bundle = this.zza;
        zziu zziu = this.zzb;
        zziu zziu2 = this.zzc;
        long j = this.zzd;
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        zzjb.zzB(zziu, zziu2, j, true, zzjb.zzs.zzv().zzy(null, "screen_view", bundle, null, false));
    }
}
