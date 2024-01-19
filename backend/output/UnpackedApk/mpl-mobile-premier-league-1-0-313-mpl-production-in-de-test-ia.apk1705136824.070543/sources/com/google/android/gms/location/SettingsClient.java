package com.google.android.gms.location;

import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class SettingsClient extends GoogleApi<NoOptions> {
    public SettingsClient(Context context) {
        super(context, LocationServices.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest locationSettingsRequest) {
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzbs(locationSettingsRequest);
        builder.zad = 2426;
        return doRead(builder.build());
    }
}
