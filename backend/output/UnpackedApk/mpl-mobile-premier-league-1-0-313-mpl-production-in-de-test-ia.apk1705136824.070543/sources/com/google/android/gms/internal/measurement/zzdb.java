package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdb extends zzdt {
    public final /* synthetic */ zzbz zza;
    public final /* synthetic */ zzee zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdb(zzee zzee, zzbz zzbz) {
        // this.zzb = zzee;
        // this.zza = zzbz;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzb.zzj;
        Preconditions.checkNotNull(zze);
        zze.getCachedAppInstanceId(this.zza);
    }

    public final void zzb() {
        this.zza.zzd(null);
    }
}