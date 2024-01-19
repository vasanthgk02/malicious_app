package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class DataHolderResult implements Result, Releasable {
    @KeepForSdk
    public Status getStatus() {
        return null;
    }

    @KeepForSdk
    public void release() {
    }
}
