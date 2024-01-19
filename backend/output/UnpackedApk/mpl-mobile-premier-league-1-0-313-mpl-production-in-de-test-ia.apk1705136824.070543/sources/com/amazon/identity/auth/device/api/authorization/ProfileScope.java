package com.amazon.identity.auth.device.api.authorization;

import com.mpl.androidapp.utils.Constant;

public final class ProfileScope {
    public static Scope postalCode() {
        return ScopeFactory.scopeNamed("postal_code");
    }

    public static Scope profile() {
        return ScopeFactory.scopeNamed(Constant.PROFILE);
    }

    public static Scope userId() {
        return ScopeFactory.scopeNamed("profile:user_id");
    }
}
