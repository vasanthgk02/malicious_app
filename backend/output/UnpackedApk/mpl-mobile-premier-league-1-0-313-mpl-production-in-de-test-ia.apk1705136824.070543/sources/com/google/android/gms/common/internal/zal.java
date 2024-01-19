package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zal {
    public final SparseIntArray zaa;
    public GoogleApiAvailabilityLight zab;

    public zal() {
        this(GoogleApiAvailability.zab);
    }

    public final int zab(Context context, Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i2 = this.zaa.get(minApkVersion, -1);
        if (i2 == -1) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.zaa.size()) {
                    i = -1;
                    break;
                }
                int keyAt = this.zaa.keyAt(i3);
                if (keyAt > minApkVersion && this.zaa.get(keyAt) == 0) {
                    break;
                }
                i3++;
            }
            i2 = i == -1 ? this.zab.isGooglePlayServicesAvailable(context, minApkVersion) : i;
            this.zaa.put(minApkVersion, i2);
        }
        return i2;
    }

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}