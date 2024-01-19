package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjm implements Runnable {
    public final /* synthetic */ zzav zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzcf zzc;
    public final /* synthetic */ zzkb zzd;

    public zzjm(zzkb zzkb, zzav zzav, String str, zzcf zzcf) {
        this.zzd = zzkb;
        this.zza = zzav;
        this.zzb = str;
        this.zzc = zzcf;
    }

    public final void run() {
        zzgi zzgi;
        byte[] bArr = null;
        try {
            zzkb zzkb = this.zzd;
            zzeo zzeo = zzkb.zzb;
            if (zzeo == null) {
                zzkb.zzs.zzaz().zzd.zza("Discarding data. Failed to send event to service to bundle");
                zzgi = this.zzd.zzs;
            } else {
                bArr = zzeo.zzu(this.zza, this.zzb);
                this.zzd.zzQ();
                zzgi = this.zzd.zzs;
            }
        } catch (RemoteException e2) {
            this.zzd.zzs.zzaz().zzd.zzb("Failed to send event to the service to bundle", e2);
            zzgi = this.zzd.zzs;
        } catch (Throwable th) {
            this.zzd.zzs.zzv().zzS(this.zzc, bArr);
            throw th;
        }
        zzgi.zzv().zzS(this.zzc, bArr);
    }
}
