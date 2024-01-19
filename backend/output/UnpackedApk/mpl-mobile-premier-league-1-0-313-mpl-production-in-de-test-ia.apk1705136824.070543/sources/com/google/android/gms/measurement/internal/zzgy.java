package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgy implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzha zzb;

    public zzgy(zzha zzha, zzp zzp) {
        this.zzb = zzha;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzK(this.zza);
    }
}
