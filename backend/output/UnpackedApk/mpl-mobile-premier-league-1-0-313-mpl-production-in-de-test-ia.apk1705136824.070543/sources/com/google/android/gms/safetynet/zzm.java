package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.safetynet.zze;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzm extends zze {
    public final /* synthetic */ TaskCompletionSource zzv;

    public zzm(TaskCompletionSource taskCompletionSource) {
        this.zzv = taskCompletionSource;
    }

    public final void zza(Status status) {
        TaskUtil.setResultOrApiException(status, null, this.zzv);
    }
}
