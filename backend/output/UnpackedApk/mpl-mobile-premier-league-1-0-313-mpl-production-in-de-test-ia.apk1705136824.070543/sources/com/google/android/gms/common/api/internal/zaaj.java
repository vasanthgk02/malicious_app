package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaaj implements zabf {
    public final zabi zaa;
    public boolean zab = false;

    public zaaj(zabi zabi) {
        this.zaa = zabi;
    }

    public final ApiMethodImpl zaa(ApiMethodImpl apiMethodImpl) {
        zab(apiMethodImpl);
        return apiMethodImpl;
    }

    public final ApiMethodImpl zab(ApiMethodImpl apiMethodImpl) {
        try {
            zadc zadc = this.zaa.zag.zai;
            zadc.zab.add(apiMethodImpl);
            apiMethodImpl.zan(zadc.zac);
            zabe zabe = this.zaa.zag;
            Client client = (Client) zabe.zac.get(apiMethodImpl.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zaa.zab.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.run(client);
            } else {
                apiMethodImpl.setFailedResult(new Status(17, null));
            }
        } catch (DeadObjectException unused) {
            zabi zabi = this.zaa;
            zabi.zam.sendMessage(zabi.zam.obtainMessage(1, new zaah(this, this)));
        }
        return apiMethodImpl;
    }

    public final void zad() {
    }

    public final void zae() {
        if (this.zab) {
            this.zab = false;
            zabi zabi = this.zaa;
            zabi.zam.sendMessage(zabi.zam.obtainMessage(1, new zaai(this, this)));
        }
    }

    public final void zag(Bundle bundle) {
    }

    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
    }

    public final void zai(int i) {
        this.zaa.zak(null);
        this.zaa.zah.zac(i, this.zab);
    }

    public final boolean zaj() {
        if (this.zab) {
            return false;
        }
        Set<zada> set = this.zaa.zag.zah;
        if (set == null || set.isEmpty()) {
            this.zaa.zak(null);
            return true;
        }
        this.zab = true;
        for (zada zada : set) {
            zada.zac = null;
        }
        return false;
    }
}
