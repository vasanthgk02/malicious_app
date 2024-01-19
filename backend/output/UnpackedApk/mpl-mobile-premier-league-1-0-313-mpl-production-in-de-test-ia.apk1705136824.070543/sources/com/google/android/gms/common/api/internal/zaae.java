package com.google.android.gms.common.api.internal;

import android.os.Handler;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaae extends zap {
    public final ArraySet zad = new ArraySet(0);
    public final GoogleApiManager zae;

    @VisibleForTesting
    public zaae(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.zae = googleApiManager;
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
    }

    public final void onResume() {
        if (!this.zad.isEmpty()) {
            this.zae.zaC(this);
        }
    }

    public final void onStart() {
        this.zaa = true;
        if (!this.zad.isEmpty()) {
            this.zae.zaC(this);
        }
    }

    public final void onStop() {
        this.zaa = false;
        GoogleApiManager googleApiManager = this.zae;
        if (googleApiManager != null) {
            synchronized (GoogleApiManager.zac) {
                if (googleApiManager.zaq == this) {
                    googleApiManager.zaq = null;
                    googleApiManager.zar.clear();
                }
            }
            return;
        }
        throw null;
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        this.zae.zaz(connectionResult, i);
    }

    public final void zac() {
        Handler handler = this.zae.zat;
        handler.sendMessage(handler.obtainMessage(3));
    }
}
