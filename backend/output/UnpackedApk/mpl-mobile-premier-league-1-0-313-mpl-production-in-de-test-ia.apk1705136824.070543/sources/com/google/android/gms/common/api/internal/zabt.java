package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabt implements Runnable {
    public final /* synthetic */ ConnectionResult zaa;
    public final /* synthetic */ zabu zab;

    public zabt(zabu zabu, ConnectionResult connectionResult) {
        this.zab = zabu;
        this.zaa = connectionResult;
    }

    public final void run() {
        zabu zabu = this.zab;
        zabq zabq = (zabq) zabu.zaa.zap.get(zabu.zac);
        if (zabq != null) {
            if (this.zaa.isSuccess()) {
                zabu zabu2 = this.zab;
                zabu2.zaf = true;
                if (zabu2.zab.requiresSignIn()) {
                    zabu zabu3 = this.zab;
                    if (zabu3.zaf) {
                        IAccountAccessor iAccountAccessor = zabu3.zad;
                        if (iAccountAccessor != null) {
                            zabu3.zab.getRemoteService(iAccountAccessor, zabu3.zae);
                        }
                    }
                    return;
                }
                try {
                    zabu zabu4 = this.zab;
                    zabu4.zab.getRemoteService(null, zabu4.zab.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused) {
                    this.zab.zab.disconnect("Failed to get service from broker.");
                    zabq.zar(new ConnectionResult(10), null);
                }
            } else {
                zabq.zar(this.zaa, null);
            }
        }
    }
}
