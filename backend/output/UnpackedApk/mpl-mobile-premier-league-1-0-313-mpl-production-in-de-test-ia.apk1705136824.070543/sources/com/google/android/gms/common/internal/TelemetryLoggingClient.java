package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", explanation = "Use canonical fakes instead.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public interface TelemetryLoggingClient extends HasApiKey<TelemetryLoggingOptions> {
    @KeepForSdk
    Task<Void> log(TelemetryData telemetryData);
}
