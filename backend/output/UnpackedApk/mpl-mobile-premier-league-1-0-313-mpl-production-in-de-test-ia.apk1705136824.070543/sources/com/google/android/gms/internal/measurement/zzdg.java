package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdg extends zzdt {
    public final /* synthetic */ String zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzee zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdg(zzee zzee, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        // this.zzc = zzee;
        // this.zza = str;
        // this.zzb = obj;
        super(zzee, false);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzc.zzj;
        Preconditions.checkNotNull(zze);
        zze.logHealthData(5, this.zza, new ObjectWrapper(this.zzb), new ObjectWrapper(null), new ObjectWrapper(null));
    }
}
