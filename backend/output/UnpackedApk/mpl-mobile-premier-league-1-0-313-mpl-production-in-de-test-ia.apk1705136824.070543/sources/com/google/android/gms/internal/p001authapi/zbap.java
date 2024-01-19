package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbap  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final /* synthetic */ class zbap implements RemoteCall {
    public final /* synthetic */ zbay zba;

    public /* synthetic */ zbap(zbay zbay) {
        this.zba = zbay;
    }

    public final void accept(Object obj, Object obj2) {
        this.zba.zbb((zbaz) obj, (TaskCompletionSource) obj2);
    }
}
