package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzea extends zzdt {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzed zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzea(zzed zzed, Activity activity) {
        // this.zzb = zzed;
        // this.zza = activity;
        super(zzed.zza, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzb.zza.zzj;
        Preconditions.checkNotNull(zze);
        zze.onActivityStopped(new ObjectWrapper(this.zza), this.zzi);
    }
}
