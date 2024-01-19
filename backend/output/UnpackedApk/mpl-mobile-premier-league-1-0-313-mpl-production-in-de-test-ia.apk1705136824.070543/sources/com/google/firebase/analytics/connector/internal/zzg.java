package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;

/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.2 */
public final class zzg {
    public final AnalyticsConnectorListener zza;
    public final AppMeasurementSdk zzb;
    public final zzf zzc;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurementSdk;
        zzf zzf = new zzf(this);
        this.zzc = zzf;
        this.zzb.zza.zzB(zzf);
    }
}
