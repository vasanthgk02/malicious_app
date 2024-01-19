package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.HasApiKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public interface SmsCodeAutofillClient extends HasApiKey<NoOptions> {

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
    public @interface PermissionState {
    }
}
