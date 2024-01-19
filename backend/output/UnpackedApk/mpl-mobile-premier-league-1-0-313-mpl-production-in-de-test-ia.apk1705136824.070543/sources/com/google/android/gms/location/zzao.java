package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.location.zzaa;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class zzao extends zzah {
    public final TaskCompletionSource<Void> zza;

    public zzao(TaskCompletionSource<Void> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(zzaa zzaa) {
        TaskUtil.setResultOrApiException(zzaa.getStatus(), null, this.zza);
    }

    public void zzc() {
    }
}
