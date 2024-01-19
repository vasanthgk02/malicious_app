package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzap implements Notifier<LocationCallback> {
    public final /* synthetic */ LocationResult zza;

    public zzap(zzar zzar, LocationResult locationResult) {
        this.zza = locationResult;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((LocationCallback) obj).onLocationResult(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
