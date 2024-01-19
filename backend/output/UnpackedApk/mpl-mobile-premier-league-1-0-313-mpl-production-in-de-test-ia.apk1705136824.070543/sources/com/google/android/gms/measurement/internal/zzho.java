package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzho implements Runnable {
    public final /* synthetic */ zzin zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzho(zzin zzin, Bundle bundle, long j) {
        this.zza = zzin;
        this.zzb = bundle;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzac(this.zzb, this.zzc);
    }
}
