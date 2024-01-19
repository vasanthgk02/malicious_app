package com.google.android.gms.measurement.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzhj;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public class AppMeasurementSdk {
    public final zzee zza;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
    public static final class ConditionalUserProperty {
    }

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
    public interface EventInterceptor extends zzhi {
    }

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
    public interface OnEventListener extends zzhj {
    }

    public AppMeasurementSdk(zzee zzee) {
        this.zza = zzee;
    }
}
