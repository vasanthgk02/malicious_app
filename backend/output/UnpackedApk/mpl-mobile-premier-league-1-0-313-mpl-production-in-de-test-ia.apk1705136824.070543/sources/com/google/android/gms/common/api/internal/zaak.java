package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaak implements Runnable {
    public final /* synthetic */ zaaw zaa;

    public zaak(zaaw zaaw) {
        this.zaa = zaaw;
    }

    public final void run() {
        zaaw zaaw = this.zaa;
        GoogleApiAvailabilityLight googleApiAvailabilityLight = zaaw.zad;
        Context context = zaaw.zac;
        if (googleApiAvailabilityLight != null) {
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            return;
        }
        throw null;
    }
}
