package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    public final Feature zza;

    @KeepForSdk
    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.zza));
    }
}
