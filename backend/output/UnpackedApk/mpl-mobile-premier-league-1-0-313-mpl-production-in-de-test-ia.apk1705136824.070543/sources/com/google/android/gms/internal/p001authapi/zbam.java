package com.google.android.gms.internal.p001authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbam  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbam extends zbae {
    public final /* synthetic */ TaskCompletionSource zba;

    public zbam(zbao zbao, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, SaveAccountLinkingTokenResult saveAccountLinkingTokenResult) throws RemoteException {
        if (status.isSuccess()) {
            this.zba.zza.zzb(saveAccountLinkingTokenResult);
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zba;
        taskCompletionSource.zza.zza(ApiExceptionUtil.fromStatus(status));
    }
}
