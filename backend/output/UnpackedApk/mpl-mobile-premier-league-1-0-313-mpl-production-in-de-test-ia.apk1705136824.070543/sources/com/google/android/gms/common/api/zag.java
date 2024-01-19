package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zag<R extends Result> extends BasePendingResult<R> {
    public final Result zae;

    public zag(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.zae = result;
    }

    public final R createFailedResult(Status status) {
        return this.zae;
    }
}
