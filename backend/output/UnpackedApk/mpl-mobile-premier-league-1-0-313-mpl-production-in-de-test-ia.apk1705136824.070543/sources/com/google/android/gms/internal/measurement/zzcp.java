package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzcp extends zzdt {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbz zzc;
    public final /* synthetic */ zzee zzd;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcp(zzee zzee, String str, String str2, zzbz zzbz) {
        // this.zzd = zzee;
        // this.zza = str;
        // this.zzb = str2;
        // this.zzc = zzbz;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzd.zzj;
        Preconditions.checkNotNull(zze);
        zze.getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    public final void zzb() {
        this.zzc.zzd(null);
    }
}
