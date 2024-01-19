package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbf  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbf extends zbd {
    public final /* synthetic */ zbg zba;

    public zbf(zbg zbg) {
        this.zba = zbg;
    }

    public final void zbb(Status status, Credential credential) {
        this.zba.setResult(new zbe(status, credential));
    }

    public final void zbc(Status status) {
        this.zba.setResult(new zbe(status, null));
    }
}
