package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjg implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ zzkb zzc;

    public zzjg(zzkb zzkb, AtomicReference atomicReference, zzp zzp) {
        this.zzc = zzkb;
        this.zza = atomicReference;
        this.zzb = zzp;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                if (!this.zzc.zzs.zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
                    this.zzc.zzs.zzaz().zzi.zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzs.zzq().zzg.set(null);
                    this.zzc.zzs.zzm().zze.zzb(null);
                    this.zza.set(null);
                    this.zza.notify();
                    return;
                }
                zzkb zzkb = this.zzc;
                zzeo zzeo = zzkb.zzb;
                if (zzeo == null) {
                    zzkb.zzs.zzaz().zzd.zza("Failed to get app instance id");
                    this.zza.notify();
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzeo.zzd(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzs.zzq().zzg.set(str);
                    this.zzc.zzs.zzm().zze.zzb(str);
                }
                this.zzc.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e2) {
                try {
                    this.zzc.zzs.zzaz().zzd.zzb("Failed to get app instance id", e2);
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
