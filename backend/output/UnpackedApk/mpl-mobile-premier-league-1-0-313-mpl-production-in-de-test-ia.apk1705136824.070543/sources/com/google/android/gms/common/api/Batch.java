package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class Batch extends BasePendingResult<BatchResult> {

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static final class Builder {
    }

    public void cancel() {
        super.cancel();
        throw null;
    }

    public final Result createFailedResult(Status status) {
        return new BatchResult(status, null);
    }
}
