package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabu implements ConnectionProgressReportCallbacks, zacs {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Client zab;
    public final ApiKey zac;
    public IAccountAccessor zad = null;
    public Set zae = null;
    public boolean zaf = false;

    public zabu(GoogleApiManager googleApiManager, Client client, ApiKey apiKey) {
        this.zaa = googleApiManager;
        this.zab = client;
        this.zac = apiKey;
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.zaa.zat.post(new zabt(this, connectionResult));
    }

    public final void zae(ConnectionResult connectionResult) {
        zabq zabq = (zabq) this.zaa.zap.get(this.zac);
        if (zabq != null) {
            Preconditions.checkHandlerThread(zabq.zaa.zat);
            Client client = zabq.zac;
            String name = client.getClass().getName();
            String valueOf = String.valueOf(connectionResult);
            client.disconnect("onSignInFailed for " + name + " with " + valueOf);
            zabq.zar(connectionResult, null);
        }
    }

    public final void zaf(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
            return;
        }
        this.zad = iAccountAccessor;
        this.zae = set;
        if (this.zaf) {
            this.zab.getRemoteService(iAccountAccessor, set);
        }
    }
}
