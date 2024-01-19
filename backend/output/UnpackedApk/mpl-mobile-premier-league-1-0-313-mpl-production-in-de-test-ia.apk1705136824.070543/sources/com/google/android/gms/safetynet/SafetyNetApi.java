package com.google.android.gms.safetynet;

import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;

@KeepForSdkWithMembers
public interface SafetyNetApi {

    public static class AttestationResponse extends Response<zza> {
    }

    public static class HarmfulAppsResponse extends Response<zzb> {
    }

    public static class RecaptchaTokenResponse extends Response<RecaptchaTokenResult> {
    }

    @Deprecated
    public interface RecaptchaTokenResult extends Result {
    }

    @KeepForSdkWithMembers
    public static class SafeBrowsingResponse extends Response<SafeBrowsingResult> {
    }

    @KeepForSdkWithMembers
    @Deprecated
    public interface SafeBrowsingResult extends Result {
    }

    public static class VerifyAppsUserResponse extends Response<zzc> {
    }

    @Deprecated
    public interface zza extends Result {
        String getJwsResult();
    }

    @Deprecated
    public interface zzb extends Result {
    }

    @Deprecated
    public interface zzc extends Result {
        boolean isVerifyAppsEnabled();
    }
}
