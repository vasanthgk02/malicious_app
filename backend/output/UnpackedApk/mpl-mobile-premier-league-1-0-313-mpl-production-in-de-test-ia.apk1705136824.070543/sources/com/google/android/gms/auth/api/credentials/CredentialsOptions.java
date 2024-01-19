package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class CredentialsOptions extends AuthCredentialsOptions {

    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static final class Builder extends com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder {
        public CredentialsOptions build() {
            return new CredentialsOptions(this);
        }
    }

    static {
        new Builder().build();
    }

    public /* synthetic */ CredentialsOptions(Builder builder) {
        super(builder);
    }
}
