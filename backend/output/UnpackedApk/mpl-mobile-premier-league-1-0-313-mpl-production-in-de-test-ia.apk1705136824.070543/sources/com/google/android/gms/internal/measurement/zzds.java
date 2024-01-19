package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzds extends zzdt {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzee zze;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzds(zzee zzee, String str, String str2, Object obj, boolean z) {
        // this.zze = zzee;
        // this.zza = str;
        // this.zzb = str2;
        // this.zzc = obj;
        // this.zzd = z;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze2 = this.zze.zzj;
        Preconditions.checkNotNull(zze2);
        zze2.setUserProperty(this.zza, this.zzb, new ObjectWrapper(this.zzc), this.zzd, this.zzh);
    }
}
