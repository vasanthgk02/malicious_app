package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    public final BasePendingResult zaa;

    public OptionalPendingResultImpl(PendingResult pendingResult) {
        this.zaa = (BasePendingResult) pendingResult;
    }

    public final void addStatusListener(StatusListener statusListener) {
        this.zaa.addStatusListener(statusListener);
    }

    public final R await() {
        return this.zaa.await();
    }

    public final void cancel() {
        this.zaa.cancel();
    }

    public final boolean isCanceled() {
        return this.zaa.isCanceled();
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        this.zaa.setResultCallback(resultCallback);
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        return this.zaa.then(resultTransform);
    }

    public final R await(long j, TimeUnit timeUnit) {
        return this.zaa.await(j, timeUnit);
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        this.zaa.setResultCallback(resultCallback, j, timeUnit);
    }
}
