package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzaq implements Notifier<LocationCallback> {
    public final /* synthetic */ LocationAvailability zza;

    public zzaq(zzar zzar, LocationAvailability locationAvailability) {
        this.zza = locationAvailability;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((LocationCallback) obj).onLocationAvailability(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
