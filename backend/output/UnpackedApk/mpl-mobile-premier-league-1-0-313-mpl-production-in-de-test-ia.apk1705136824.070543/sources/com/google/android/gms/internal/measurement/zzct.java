package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzct extends zzdt {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzee zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzct(zzee zzee, Bundle bundle) {
        // this.zzb = zzee;
        // this.zza = bundle;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzb.zzj;
        Preconditions.checkNotNull(zze);
        zze.setConsent(this.zza, this.zzh);
    }
}
