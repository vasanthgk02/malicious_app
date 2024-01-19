package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zap implements StatusListener {
    public final /* synthetic */ PendingResult zaa;
    public final /* synthetic */ TaskCompletionSource zab;
    public final /* synthetic */ ResultConverter zac;

    public zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, zas zas) {
        this.zaa = pendingResult;
        this.zab = taskCompletionSource;
        this.zac = resultConverter;
    }

    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            Result await = this.zaa.await(0, TimeUnit.MILLISECONDS);
            TaskCompletionSource taskCompletionSource = this.zab;
            taskCompletionSource.zza.zzb(this.zac.convert(await));
            return;
        }
        TaskCompletionSource taskCompletionSource2 = this.zab;
        taskCompletionSource2.zza.zza(ApiExceptionUtil.fromStatus(status));
    }
}
