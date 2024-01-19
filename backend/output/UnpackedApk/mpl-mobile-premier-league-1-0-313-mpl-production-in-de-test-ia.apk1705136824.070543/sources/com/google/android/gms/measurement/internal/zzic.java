package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzic implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzin zzb;

    public zzic(zzin zzin, AtomicReference atomicReference) {
        this.zzb = zzin;
        this.zza = atomicReference;
    }

    public final void run() {
        String str;
        synchronized (this.zza) {
            try {
                AtomicReference atomicReference = this.zza;
                zzaf zzaf = this.zzb.zzs.zzk;
                String zzl = this.zzb.zzs.zzh().zzl();
                zzek zzek = zzel.zzK;
                if (zzaf != null) {
                    if (zzl == null) {
                        str = (String) zzek.zza(null);
                    } else {
                        str = (String) zzek.zza(zzaf.zzb.zza(zzl, zzek.zzb));
                    }
                    atomicReference.set(str);
                    this.zza.notify();
                } else {
                    throw null;
                }
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
