package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbj extends zba {
    public final /* synthetic */ zbk zba;

    public zbj(zbk zbk) {
        this.zba = zbk;
    }

    public final void zbb(Status status) throws RemoteException {
        this.zba.setResult(status);
    }
}
