package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdh extends zzdt {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzbz zzb;
    public final /* synthetic */ zzee zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdh(zzee zzee, Bundle bundle, zzbz zzbz) {
        // this.zzc = zzee;
        // this.zza = bundle;
        // this.zzb = zzbz;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzc.zzj;
        Preconditions.checkNotNull(zze);
        zze.performAction(this.zza, this.zzb, this.zzh);
    }

    public final void zzb() {
        this.zzb.zzd(null);
    }
}
