package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdj extends zzdt {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzbz zzb;
    public final /* synthetic */ zzee zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdj(zzee zzee, String str, zzbz zzbz) {
        // this.zzc = zzee;
        // this.zza = str;
        // this.zzb = zzbz;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzc.zzj;
        Preconditions.checkNotNull(zze);
        zze.getMaxUserProperties(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zzb.zzd(null);
    }
}
