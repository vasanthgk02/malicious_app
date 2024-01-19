package com.google.android.gms.location;

import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class GeofencingClient extends GoogleApi<NoOptions> {
    public GeofencingClient(Context context) {
        super(context, LocationServices.API, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }
}
