package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.internal.Objects;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class SignInOptions implements Optional {
    public static final SignInOptions zaa = new SignInOptions();
    public final boolean zab = false;
    public final boolean zac = false;
    public final String zad = null;
    public final boolean zae = false;
    public final String zaf = null;
    public final String zag = null;
    public final boolean zah = false;
    public final Long zai = null;
    public final Long zaj = null;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        boolean z = ((SignInOptions) obj).zab;
        return Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
