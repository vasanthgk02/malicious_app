package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zbc;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbg extends zbl {
    public final /* synthetic */ Context zba;
    public final /* synthetic */ GoogleSignInOptions zbb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zbg(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        // this.zba = context;
        // this.zbb = googleSignInOptions;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new GoogleSignInResult(null, status);
    }

    public final void doExecute(AnyClient anyClient) throws RemoteException {
        zbs zbs = (zbs) ((zbe) anyClient).getService();
        zbf zbf = new zbf(this);
        GoogleSignInOptions googleSignInOptions = this.zbb;
        Parcel zba2 = zbs.zba();
        zbc.zbc(zba2, zbf);
        zbc.zbb(zba2, googleSignInOptions);
        zbs.zbb(101, zba2);
    }
}
