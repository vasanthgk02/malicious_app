package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzcw extends zzdt {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzee zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcw(zzee zzee, long j) {
        // this.zzb = zzee;
        // this.zza = j;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzb.zzj;
        Preconditions.checkNotNull(zze);
        zze.setSessionTimeoutDuration(this.zza);
    }
}
