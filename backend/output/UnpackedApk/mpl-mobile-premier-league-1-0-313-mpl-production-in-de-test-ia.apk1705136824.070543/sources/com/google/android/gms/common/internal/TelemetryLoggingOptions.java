package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import java.util.Arrays;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class TelemetryLoggingOptions implements Optional {
    public static final TelemetryLoggingOptions zaa = new TelemetryLoggingOptions(null);
    public final String zab = null;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static class Builder {
    }

    public /* synthetic */ TelemetryLoggingOptions(String str) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelemetryLoggingOptions)) {
            return false;
        }
        return Objects.equal(this.zab, ((TelemetryLoggingOptions) obj).zab);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zab});
    }
}
