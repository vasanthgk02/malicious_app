package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zbc;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbi extends zbl {
    public zbi(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final void doExecute(AnyClient anyClient) throws RemoteException {
        zbe zbe = (zbe) anyClient;
        zbs zbs = (zbs) zbe.getService();
        zbh zbh = new zbh(this);
        GoogleSignInOptions googleSignInOptions = zbe.zba;
        Parcel zba = zbs.zba();
        zbc.zbc(zba, zbh);
        zbc.zbb(zba, googleSignInOptions);
        zbs.zbb(102, zba);
    }
}
