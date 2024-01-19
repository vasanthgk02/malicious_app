package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbg  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbg extends zbm {
    public final /* synthetic */ CredentialRequest zba;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zbg(zbl zbl, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        // this.zba = credentialRequest;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zbe(status, null);
    }

    public final void zba(Context context, zbt zbt) throws RemoteException {
        zbt.zbd(new zbf(this), this.zba);
    }
}
