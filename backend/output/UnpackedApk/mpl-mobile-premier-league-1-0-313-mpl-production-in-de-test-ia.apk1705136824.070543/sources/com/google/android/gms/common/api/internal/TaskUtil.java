package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class TaskUtil {
    @KeepForSdk
    public static <ResultT> void setResultOrApiException(Status status, ResultT resultt, TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.zza.zzb(resultt);
            return;
        }
        taskCompletionSource.zza.zza(ApiExceptionUtil.fromStatus(status));
    }

    @KeepForSdk
    public static <ResultT> boolean trySetResultOrApiException(Status status, ResultT resultt, TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.isSuccess()) {
            return taskCompletionSource.zza.zze(resultt);
        }
        return taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(status));
    }
}
