package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzju implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzp zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzkb zzf;

    public zzju(zzkb zzkb, AtomicReference atomicReference, String str, String str2, zzp zzp, boolean z) {
        this.zzf = zzkb;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzp;
        this.zze = z;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                zzkb zzkb = this.zzf;
                zzeo zzeo = zzkb.zzb;
                if (zzeo == null) {
                    zzkb.zzs.zzaz().zzd.zzd("(legacy) Failed to get user properties; not connected to service", null, this.zzb, this.zzc);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    Preconditions.checkNotNull(this.zzd);
                    this.zza.set(zzeo.zzh(this.zzb, this.zzc, this.zze, this.zzd));
                } else {
                    this.zza.set(zzeo.zzi(null, this.zzb, this.zzc, this.zze));
                }
                this.zzf.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e2) {
                try {
                    this.zzf.zzs.zzaz().zzd.zzd("(legacy) Failed to get user properties; remote exception", null, this.zzb, e2);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
