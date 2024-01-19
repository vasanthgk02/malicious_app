package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class HashAccumulator {
    public int zab = 1;

    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        this.zab = (31 * this.zab) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public final HashAccumulator zaa(boolean z) {
        this.zab = (31 * this.zab) + (z ? 1 : 0);
        return this;
    }
}
