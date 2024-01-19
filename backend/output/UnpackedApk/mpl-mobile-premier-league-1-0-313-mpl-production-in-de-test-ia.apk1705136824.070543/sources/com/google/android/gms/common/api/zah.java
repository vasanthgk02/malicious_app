package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zah<R extends Result> extends BasePendingResult<R> {
    public zah(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final R createFailedResult(Status status) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
