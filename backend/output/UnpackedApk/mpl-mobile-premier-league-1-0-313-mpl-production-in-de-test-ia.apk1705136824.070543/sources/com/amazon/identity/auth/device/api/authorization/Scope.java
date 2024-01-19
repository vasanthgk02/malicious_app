package com.amazon.identity.auth.device.api.authorization;

import org.json.JSONObject;

public interface Scope {
    String getName();

    JSONObject getScopeData();
}
