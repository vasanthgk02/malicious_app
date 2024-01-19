package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbh  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbh extends zbm {
    public final /* synthetic */ Credential zba;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zbh(zbl zbl, GoogleApiClient googleApiClient, Credential credential) {
        // this.zba = credential;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final void zba(Context context, zbt zbt) throws RemoteException {
        zbt.zbe(new zbk(this), new zbu(this.zba));
    }
}
