package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;

/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.2 */
public final class zzf implements OnEventListener {
    public final /* synthetic */ zzg zza;

    public zzf(zzg zzg) {
        this.zza = zzg;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && !str.equals("crash") && (!zzc.zza.contains(str2))) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, bundle);
            this.zza.zza.onMessageTriggered(3, bundle2);
        }
    }
}
