package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhv implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzin zzb;

    public zzhv(zzin zzin, long j) {
        this.zzb = zzin;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzM(this.zza, true);
        this.zzb.zzs.zzt().zzu(new AtomicReference());
    }
}
