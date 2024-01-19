package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzig implements Runnable {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzin zzb;

    public zzig(zzin zzin, Boolean bool) {
        this.zzb = zzin;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzad(this.zza, true);
    }
}
