package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.safetynet.SafetyNet;

public abstract class zzf<R extends Result> extends ApiMethodImpl<R, zzx> {
    public zzf(GoogleApiClient googleApiClient) {
        super(SafetyNet.API, googleApiClient);
    }
}
