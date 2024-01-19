package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabp implements SignOutCallbacks {
    public final /* synthetic */ zabq zaa;

    public zabp(zabq zabq) {
        this.zaa = zabq;
    }

    public final void onSignOutComplete() {
        this.zaa.zaa.zat.post(new zabo(this));
    }
}
