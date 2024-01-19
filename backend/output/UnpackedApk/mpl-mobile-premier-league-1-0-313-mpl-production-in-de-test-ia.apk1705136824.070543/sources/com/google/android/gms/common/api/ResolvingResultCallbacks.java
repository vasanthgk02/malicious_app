package com.google.android.gms.common.api;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    @KeepForSdk
    public final void onFailure(Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(null, 0);
            } catch (SendIntentException unused) {
                onUnresolvableFailure(new Status(8, null));
            }
        } else {
            onUnresolvableFailure(status);
        }
    }

    public abstract void onUnresolvableFailure(Status status);
}
