package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzcv extends zzdt {
    public final /* synthetic */ zzee zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcv(zzee zzee) {
        // this.zza = zzee;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zza.zzj;
        Preconditions.checkNotNull(zze);
        zze.resetAnalyticsData(this.zzh);
    }
}
