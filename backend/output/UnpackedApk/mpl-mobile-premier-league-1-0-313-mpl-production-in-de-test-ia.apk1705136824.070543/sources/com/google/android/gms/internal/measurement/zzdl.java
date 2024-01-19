package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdl extends zzdt {
    public final /* synthetic */ zzbz zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzee zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdl(zzee zzee, zzbz zzbz, int i) {
        // this.zzc = zzee;
        // this.zza = zzbz;
        // this.zzb = i;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzc.zzj;
        Preconditions.checkNotNull(zze);
        zze.getTestFlag(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zza.zzd(null);
    }
}
