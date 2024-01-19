package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbas  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final /* synthetic */ class zbas implements RemoteCall {
    public final /* synthetic */ zbay zba;
    public final /* synthetic */ GetSignInIntentRequest zbb;

    public /* synthetic */ zbas(zbay zbay, GetSignInIntentRequest getSignInIntentRequest) {
        this.zba = zbay;
        this.zbb = getSignInIntentRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbay zbay = this.zba;
        GetSignInIntentRequest getSignInIntentRequest = this.zbb;
        zbaw zbaw = new zbaw(zbay, (TaskCompletionSource) obj2);
        Preconditions.checkNotNull(getSignInIntentRequest);
        ((zbai) ((zbaz) obj).getService()).zbe(zbaw, getSignInIntentRequest);
    }
}
