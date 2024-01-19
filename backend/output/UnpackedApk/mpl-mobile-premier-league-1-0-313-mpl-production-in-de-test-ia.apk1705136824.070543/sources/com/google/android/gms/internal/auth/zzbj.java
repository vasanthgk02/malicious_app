package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzbj extends ApiMethodImpl<SpatulaHeaderResult, zzbe> {
    public zzbj(GoogleApiClient googleApiClient) {
        super(AuthProxy.API, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new zzbv(status);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzbe zzbe = (zzbe) anyClient;
        zza(zzbe.getContext(), (zzbh) zzbe.getService());
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    public abstract void zza(Context context, zzbh zzbh) throws RemoteException;
}
