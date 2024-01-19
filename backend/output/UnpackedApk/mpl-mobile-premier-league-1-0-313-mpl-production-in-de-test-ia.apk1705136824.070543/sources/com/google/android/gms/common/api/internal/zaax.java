package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaax implements zabf {
    @NotOnlyInitialized
    public final zabi zaa;

    public zaax(zabi zabi) {
        this.zaa = zabi;
    }

    public final ApiMethodImpl zaa(ApiMethodImpl apiMethodImpl) {
        this.zaa.zag.zaa.add(apiMethodImpl);
        return apiMethodImpl;
    }

    public final ApiMethodImpl zab(ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void zad() {
        for (Client disconnect : this.zaa.zaa.values()) {
            disconnect.disconnect();
        }
        this.zaa.zag.zad = Collections.emptySet();
    }

    public final void zae() {
        zabi zabi = this.zaa;
        zabi.zai.lock();
        try {
            zaaw zaaw = new zaaw(zabi, zabi.zac, zabi.zad, zabi.zal, zabi.zae, zabi.zai, zabi.zak);
            zabi.zan = zaaw;
            zabi.zan.zad();
            zabi.zaj.signalAll();
        } finally {
            zabi.zai.unlock();
        }
    }

    public final void zag(Bundle bundle) {
    }

    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
    }

    public final void zai(int i) {
    }

    public final boolean zaj() {
        return true;
    }
}
