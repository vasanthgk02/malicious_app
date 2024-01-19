package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbs extends zzbj {
    public zzbs(zzbt zzbt, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final void zza(Context context, zzbh zzbh) throws RemoteException {
        zzbh.zzd(new zzbr(this));
    }
}
