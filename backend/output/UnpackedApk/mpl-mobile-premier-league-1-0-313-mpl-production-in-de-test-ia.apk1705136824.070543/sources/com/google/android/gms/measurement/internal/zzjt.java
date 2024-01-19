package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjt implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzp zzc;
    public final /* synthetic */ zzcf zzd;
    public final /* synthetic */ zzkb zze;

    public zzjt(zzkb zzkb, String str, String str2, zzp zzp, zzcf zzcf) {
        this.zze = zzkb;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzp;
        this.zzd = zzcf;
    }

    public final void run() {
        zzgi zzgi;
        ArrayList arrayList = new ArrayList();
        try {
            zzkb zzkb = this.zze;
            zzeo zzeo = zzkb.zzb;
            if (zzeo == null) {
                zzkb.zzs.zzaz().zzd.zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzgi = this.zze.zzs;
            } else {
                Preconditions.checkNotNull(this.zzc);
                arrayList = zzlp.zzH(zzeo.zzf(this.zza, this.zzb, this.zzc));
                this.zze.zzQ();
                zzgi = this.zze.zzs;
            }
        } catch (RemoteException e2) {
            this.zze.zzs.zzaz().zzd.zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e2);
            zzgi = this.zze.zzs;
        } catch (Throwable th) {
            this.zze.zzs.zzv().zzQ(this.zzd, arrayList);
            throw th;
        }
        zzgi.zzv().zzQ(this.zzd, arrayList);
    }
}
