package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbh extends zba {
    public final /* synthetic */ zbi zba;

    public zbh(zbi zbi) {
        this.zba = zbi;
    }

    public final void zbc(Status status) throws RemoteException {
        this.zba.setResult(status);
    }
}
