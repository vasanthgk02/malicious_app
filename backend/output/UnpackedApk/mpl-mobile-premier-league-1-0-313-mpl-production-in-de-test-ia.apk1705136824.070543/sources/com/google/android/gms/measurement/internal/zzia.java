package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzia implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzin zze;

    public zzia(zzin zzin, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.zze = zzin;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    public final void run() {
        zzkb zzt = this.zze.zzs.zzt();
        AtomicReference atomicReference = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        boolean z = this.zzd;
        zzt.zzg();
        zzt.zza();
        zzju zzju = new zzju(zzt, atomicReference, str, str2, zzt.zzO(false), z);
        zzt.zzR(zzju);
    }
}
