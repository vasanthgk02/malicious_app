package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaao extends zaav {
    public final /* synthetic */ zaaw zaa;
    public final Map zac;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zaao(zaaw zaaw, Map map) {
        // this.zaa = zaaw;
        super(zaaw);
        this.zac = map;
    }

    public final void zaa() {
        zal zal = new zal(this.zaa.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Client client : this.zac.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zaal) this.zac.get(client)).zac) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = -1;
        int i2 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i2 < size) {
                i = zal.zab(this.zaa.zac, (Client) arrayList.get(i2));
                i2++;
                if (i != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i2 < size2) {
                i = zal.zab(this.zaa.zac, (Client) arrayList2.get(i2));
                i2++;
                if (i == 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i, null);
            zaaw zaaw = this.zaa;
            zabi zabi = zaaw.zaa;
            zabi.zam.sendMessage(zabi.zam.obtainMessage(1, new zaam(this, zaaw, connectionResult)));
            return;
        }
        zaaw zaaw2 = this.zaa;
        if (zaaw2.zam) {
            zae zae = zaaw2.zak;
            if (zae != null) {
                zae.zab();
            }
        }
        for (Client client2 : this.zac.keySet()) {
            ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) this.zac.get(client2);
            if (!client2.requiresGooglePlayServices() || zal.zab(this.zaa.zac, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaaw zaaw3 = this.zaa;
                zabi zabi2 = zaaw3.zaa;
                zabi2.zam.sendMessage(zabi2.zam.obtainMessage(1, new zaan(zaaw3, connectionProgressReportCallbacks)));
            }
        }
    }
}
