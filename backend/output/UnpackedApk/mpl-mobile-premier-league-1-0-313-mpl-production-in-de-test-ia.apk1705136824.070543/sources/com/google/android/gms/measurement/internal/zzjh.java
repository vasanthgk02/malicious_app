package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjh implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzcf zzb;
    public final /* synthetic */ zzkb zzc;

    public zzjh(zzkb zzkb, zzp zzp, zzcf zzcf) {
        this.zzc = zzkb;
        this.zza = zzp;
        this.zzb = zzcf;
    }

    public final void run() {
        zzgi zzgi;
        String str = null;
        try {
            if (!this.zzc.zzs.zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
                this.zzc.zzs.zzaz().zzi.zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzs.zzq().zzg.set(null);
                this.zzc.zzs.zzm().zze.zzb(null);
                zzgi = this.zzc.zzs;
            } else {
                zzkb zzkb = this.zzc;
                zzeo zzeo = zzkb.zzb;
                if (zzeo == null) {
                    zzkb.zzs.zzaz().zzd.zza("Failed to get app instance id");
                    zzgi = this.zzc.zzs;
                } else {
                    Preconditions.checkNotNull(this.zza);
                    str = zzeo.zzd(this.zza);
                    if (str != null) {
                        this.zzc.zzs.zzq().zzg.set(str);
                        this.zzc.zzs.zzm().zze.zzb(str);
                    }
                    this.zzc.zzQ();
                    zzgi = this.zzc.zzs;
                }
            }
        } catch (RemoteException e2) {
            this.zzc.zzs.zzaz().zzd.zzb("Failed to get app instance id", e2);
            zzgi = this.zzc.zzs;
        } catch (Throwable th) {
            this.zzc.zzs.zzv().zzV(this.zzb, null);
            throw th;
        }
        zzgi.zzv().zzV(this.zzb, str);
    }
}
