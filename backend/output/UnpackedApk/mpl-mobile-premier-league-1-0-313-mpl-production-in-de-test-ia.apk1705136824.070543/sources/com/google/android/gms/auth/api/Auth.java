package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zbd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.p001authapi.zbl;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zbc, zba);
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zbd, zbb);
    public static final ClientKey zba = new ClientKey();
    public static final ClientKey zbb = new ClientKey();
    public static final AbstractClientBuilder zbc = new zba();
    public static final AbstractClientBuilder zbd = new zbb();

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
    public static class AuthCredentialsOptions implements Optional {
        public static final AuthCredentialsOptions zba = new AuthCredentialsOptions(new Builder());
        public final String zbb = null;
        public final boolean zbc;
        public final String zbd;

        @Deprecated
        /* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
        public static class Builder {
            public Boolean zba = Boolean.FALSE;
            public String zbb;

            public Builder() {
            }

            @ShowFirstParty
            public Builder(AuthCredentialsOptions authCredentialsOptions) {
                String str = authCredentialsOptions.zbb;
                this.zba = Boolean.valueOf(authCredentialsOptions.zbc);
                this.zbb = authCredentialsOptions.zbd;
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.zbc = builder.zba.booleanValue();
            this.zbd = builder.zbb;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthCredentialsOptions)) {
                return false;
            }
            AuthCredentialsOptions authCredentialsOptions = (AuthCredentialsOptions) obj;
            String str = authCredentialsOptions.zbb;
            return Objects.equal(null, null) && this.zbc == authCredentialsOptions.zbc && Objects.equal(this.zbd, authCredentialsOptions.zbd);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{null, Boolean.valueOf(this.zbc), this.zbd});
        }
    }

    static {
        Api<AuthProxyOptions> api = AuthProxy.API;
        ProxyApi proxyApi = AuthProxy.ProxyApi;
        new zbl();
        new zbd();
    }
}
