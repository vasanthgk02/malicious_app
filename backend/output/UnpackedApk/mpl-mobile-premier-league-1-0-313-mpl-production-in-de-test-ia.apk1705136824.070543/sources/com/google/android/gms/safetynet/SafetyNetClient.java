package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

public class SafetyNetClient extends GoogleApi<NoOptions> {
    public SafetyNetClient(Context context) {
        super(context, SafetyNet.API, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }
}
