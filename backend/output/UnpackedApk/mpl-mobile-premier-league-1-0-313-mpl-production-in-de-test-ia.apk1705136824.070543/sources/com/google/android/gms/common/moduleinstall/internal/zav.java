package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback.Stub;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zav extends Stub {
    public final /* synthetic */ TaskCompletionSource zaa;

    public zav(TaskCompletionSource taskCompletionSource) {
        this.zaa = taskCompletionSource;
    }

    public final void onResult(Status status) {
        TaskUtil.trySetResultOrApiException(status, Boolean.TRUE, this.zaa);
    }
}
