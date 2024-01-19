package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdw extends zzdt {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzed zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdw(zzed zzed, Bundle bundle, Activity activity) {
        // this.zzc = zzed;
        // this.zza = bundle;
        // this.zzb = activity;
        super(zzed.zza, true);
    }

    public final void zza() throws RemoteException {
        Bundle bundle;
        if (this.zza != null) {
            bundle = new Bundle();
            if (this.zza.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.zza.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        zzcc zze = this.zzc.zza.zzj;
        Preconditions.checkNotNull(zze);
        zze.onActivityCreated(new ObjectWrapper(this.zzb), bundle, this.zzi);
    }
}
