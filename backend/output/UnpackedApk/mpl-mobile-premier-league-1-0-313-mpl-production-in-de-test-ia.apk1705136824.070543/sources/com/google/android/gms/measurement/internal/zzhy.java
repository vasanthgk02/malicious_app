package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhy implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzin zzd;

    public zzhy(zzin zzin, AtomicReference atomicReference, String str, String str2) {
        this.zzd = zzin;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        zzkb zzt = this.zzd.zzs.zzt();
        AtomicReference atomicReference = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        zzt.zzg();
        zzt.zza();
        zzjs zzjs = new zzjs(zzt, atomicReference, str, str2, zzt.zzO(false));
        zzt.zzR(zzjs);
    }
}
