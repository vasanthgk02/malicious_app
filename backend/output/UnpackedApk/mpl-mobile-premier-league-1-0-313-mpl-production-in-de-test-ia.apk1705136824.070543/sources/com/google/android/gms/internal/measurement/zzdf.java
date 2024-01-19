package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdf extends zzdt {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzbz zzd;
    public final /* synthetic */ zzee zze;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdf(zzee zzee, String str, String str2, boolean z, zzbz zzbz) {
        // this.zze = zzee;
        // this.zza = str;
        // this.zzb = str2;
        // this.zzc = z;
        // this.zzd = zzbz;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze2 = this.zze.zzj;
        Preconditions.checkNotNull(zze2);
        zze2.getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zzd.zzd(null);
    }
}
