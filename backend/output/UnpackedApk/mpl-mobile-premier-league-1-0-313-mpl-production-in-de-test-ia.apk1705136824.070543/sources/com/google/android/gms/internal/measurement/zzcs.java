package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzcs extends zzdt {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzee zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcs(zzee zzee, Boolean bool) {
        // this.zzb = zzee;
        // this.zza = bool;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        if (this.zza != null) {
            zzcc zze = this.zzb.zzj;
            Preconditions.checkNotNull(zze);
            zze.setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
            return;
        }
        zzcc zze2 = this.zzb.zzj;
        Preconditions.checkNotNull(zze2);
        zze2.clearMeasurementEnabled(this.zzh);
    }
}
