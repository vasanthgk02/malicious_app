package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zad;
import com.google.android.gms.signin.zae;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zact extends zac implements ConnectionCallbacks, OnConnectionFailedListener {
    public static final AbstractClientBuilder zaa = zad.zac;
    public final Context zab;
    public final Handler zac;
    public final AbstractClientBuilder zad;
    public final Set zae;
    public final ClientSettings zaf;
    public zae zag;
    public zacs zah;

    public zact(Context context, Handler handler, ClientSettings clientSettings) {
        AbstractClientBuilder abstractClientBuilder = zaa;
        this.zab = context;
        this.zac = handler;
        Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.zaf = clientSettings;
        this.zae = clientSettings.zab;
        this.zad = abstractClientBuilder;
    }

    public static void zad(zact zact, zak zak) {
        ConnectionResult connectionResult = zak.zab;
        if (connectionResult.isSuccess()) {
            zav zav = zak.zac;
            Preconditions.checkNotNull(zav);
            ConnectionResult connectionResult2 = zav.zac;
            if (!connectionResult2.isSuccess()) {
                String valueOf = String.valueOf(connectionResult2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                zact.zah.zae(connectionResult2);
                zact.zag.disconnect();
                return;
            }
            zact.zah.zaf(zav.zab(), zact.zae);
        } else {
            zact.zah.zae(connectionResult);
        }
        zact.zag.disconnect();
    }

    public final void onConnected(Bundle bundle) {
        this.zag.zad(this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zah.zae(connectionResult);
    }

    public final void onConnectionSuspended(int i) {
        this.zag.disconnect();
    }

    public final void zab(zak zak) {
        this.zac.post(new zacr(this, zak));
    }
}
