package com.paypal.android.sdk.onetouch.core.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class OAuth2Recipe extends Recipe<OAuth2Recipe> {
    public final Map<String, ConfigEndpoint> mEndpoints = new HashMap();
    public final Collection<String> mScope = new HashSet();

    public Recipe getThis() {
        return this;
    }
}
