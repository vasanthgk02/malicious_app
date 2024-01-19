package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

/* renamed from: com.google.android.gms.internal.auth-api.zbm  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public abstract class zbm extends ApiMethodImpl {
    public zbm(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zbo zbo = (zbo) anyClient;
        zba(zbo.getContext(), (zbt) zbo.getService());
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    public abstract void zba(Context context, zbt zbt) throws DeadObjectException, RemoteException;
}
