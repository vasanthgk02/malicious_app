package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener;

/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.2 */
public final class zzd implements OnEventListener {
    public final /* synthetic */ zze zza;

    public zzd(zze zze) {
        this.zza = zze;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzc.zzc(str2));
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
