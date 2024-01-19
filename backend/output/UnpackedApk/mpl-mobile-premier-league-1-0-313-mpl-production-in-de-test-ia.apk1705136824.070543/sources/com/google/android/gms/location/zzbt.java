package com.google.android.gms.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbt implements ResultHolder<LocationSettingsResult> {
    public final TaskCompletionSource<LocationSettingsResponse> zza;

    public zzbt(TaskCompletionSource<LocationSettingsResponse> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void setResult(Object obj) {
        LocationSettingsResult locationSettingsResult = (LocationSettingsResult) obj;
        Status status = locationSettingsResult.zza;
        if (status.isSuccess()) {
            TaskCompletionSource<LocationSettingsResponse> taskCompletionSource = this.zza;
            taskCompletionSource.zza.zzb(new LocationSettingsResponse(locationSettingsResult));
        } else if (status.hasResolution()) {
            TaskCompletionSource<LocationSettingsResponse> taskCompletionSource2 = this.zza;
            taskCompletionSource2.zza.zza(new ResolvableApiException(status));
        } else {
            TaskCompletionSource<LocationSettingsResponse> taskCompletionSource3 = this.zza;
            taskCompletionSource3.zza.zza(new ApiException(status));
        }
    }
}
