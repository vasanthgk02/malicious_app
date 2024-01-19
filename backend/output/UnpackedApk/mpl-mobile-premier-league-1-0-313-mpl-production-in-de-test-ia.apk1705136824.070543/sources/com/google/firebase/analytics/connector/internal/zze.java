package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.2 */
public final class zze {
    public final Set zza = new HashSet();
    public final AnalyticsConnectorListener zzb;
    public final AppMeasurementSdk zzc;
    public final zzd zzd;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzd zzd2 = new zzd(this);
        this.zzd = zzd2;
        this.zzc.zza.zzB(zzd2);
    }
}
