package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaat implements ConnectionCallbacks, OnConnectionFailedListener {
    public final /* synthetic */ zaaw zaa;

    public /* synthetic */ zaat(zaaw zaaw) {
        this.zaa = zaaw;
    }

    public final void onConnected(Bundle bundle) {
        ClientSettings clientSettings = this.zaa.zar;
        Preconditions.checkNotNull(clientSettings);
        ClientSettings clientSettings2 = clientSettings;
        zae zae = this.zaa.zak;
        Preconditions.checkNotNull(zae);
        zae.zad(new zaar(this.zaa));
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaa.zab.lock();
        try {
            if (this.zaa.zal && !connectionResult.hasResolution()) {
                this.zaa.zaA();
                this.zaa.zaF();
            } else {
                this.zaa.zaD(connectionResult);
            }
        } finally {
            this.zaa.zab.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
