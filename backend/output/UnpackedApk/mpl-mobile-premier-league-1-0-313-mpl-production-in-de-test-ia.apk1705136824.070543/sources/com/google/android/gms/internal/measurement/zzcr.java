package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzcr extends zzdt {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzee zzd;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcr(zzee zzee, Activity activity, String str, String str2) {
        // this.zzd = zzee;
        // this.zza = activity;
        // this.zzb = str;
        // this.zzc = str2;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        zzcc zze = this.zzd.zzj;
        Preconditions.checkNotNull(zze);
        zze.setCurrentScreen(new ObjectWrapper(this.zza), this.zzb, this.zzc, this.zzh);
    }
}
