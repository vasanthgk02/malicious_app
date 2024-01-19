package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzeb extends zzdt {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzbz zzb;
    public final /* synthetic */ zzed zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzeb(zzed zzed, Activity activity, zzbz zzbz) {
        // this.zzc = zzed;
        // this.zza = activity;
        // this.zzb = zzbz;
        super(zzed.zza, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzc.zza.zzj;
        Preconditions.checkNotNull(zze);
        zze.onActivitySaveInstanceState(new ObjectWrapper(this.zza), this.zzb, this.zzi);
    }
}
