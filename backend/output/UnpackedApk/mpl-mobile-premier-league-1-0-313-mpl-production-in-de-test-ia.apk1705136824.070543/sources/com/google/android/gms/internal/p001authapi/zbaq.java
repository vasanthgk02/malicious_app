package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbaq  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final /* synthetic */ class zbaq implements RemoteCall {
    public final /* synthetic */ zbay zba;
    public final /* synthetic */ BeginSignInRequest zbb;

    public /* synthetic */ zbaq(zbay zbay, BeginSignInRequest beginSignInRequest) {
        this.zba = zbay;
        this.zbb = beginSignInRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbay zbay = this.zba;
        BeginSignInRequest beginSignInRequest = this.zbb;
        zbau zbau = new zbau(zbay, (TaskCompletionSource) obj2);
        Preconditions.checkNotNull(beginSignInRequest);
        ((zbai) ((zbaz) obj).getService()).zbc(zbau, beginSignInRequest);
    }
}
