package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.CancellationException;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zacc extends zap {
    public final void onDestroy() {
        new CancellationException("Host activity was destroyed before Google Play services could be made available.");
        throw null;
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        String str = connectionResult.zzd;
        if (str == null) {
            str = "Error connecting to Google Play services";
        }
        Status status = new Status(1, connectionResult.zzb, str, connectionResult.zzc, connectionResult);
        new ApiException(status);
        throw null;
    }

    public final void zac() {
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        if (lifecycleActivity == null) {
            new ApiException(new Status(8, null));
            throw null;
        } else if (this.zac.isGooglePlayServicesAvailable(lifecycleActivity, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0) {
            throw null;
        } else {
            throw null;
        }
    }
}
