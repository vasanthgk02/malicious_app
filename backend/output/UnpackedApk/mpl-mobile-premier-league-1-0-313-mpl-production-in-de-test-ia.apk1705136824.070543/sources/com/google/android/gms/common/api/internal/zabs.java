package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabs {
    public final ApiKey zaa;
    public final Feature zab;

    public /* synthetic */ zabs(ApiKey apiKey, Feature feature) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabs = (zabs) obj;
            if (Objects.equal(this.zaa, zabs.zaa) && Objects.equal(this.zab, zabs.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa, this.zab});
    }

    public final String toString() {
        ToStringHelper toStringHelper = new ToStringHelper(this);
        toStringHelper.add("key", this.zaa);
        toStringHelper.add("feature", this.zab);
        return toStringHelper.toString();
    }
}
