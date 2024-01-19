package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaj implements OnConnectionFailedListener {
    public final int zaa;
    public final GoogleApiClient zab;
    public final OnConnectionFailedListener zac;
    public final /* synthetic */ zak zad;

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        "beginFailureResolution for ".concat(String.valueOf(connectionResult));
        this.zad.zah(connectionResult, this.zaa);
    }
}
