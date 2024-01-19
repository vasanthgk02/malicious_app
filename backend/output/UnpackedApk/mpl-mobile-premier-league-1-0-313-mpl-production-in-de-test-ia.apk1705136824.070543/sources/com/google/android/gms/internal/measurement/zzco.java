package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzco extends zzdt {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzee zzd;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzco(zzee zzee, String str, String str2, Bundle bundle) {
        // this.zzd = zzee;
        // this.zza = str;
        // this.zzb = str2;
        // this.zzc = bundle;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzd.zzj;
        Preconditions.checkNotNull(zze);
        zze.clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
    }
}
