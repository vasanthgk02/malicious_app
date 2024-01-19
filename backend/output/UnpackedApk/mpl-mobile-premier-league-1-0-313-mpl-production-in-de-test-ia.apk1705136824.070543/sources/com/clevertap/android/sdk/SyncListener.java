package com.clevertap.android.sdk;

import org.json.JSONObject;

@Deprecated
public interface SyncListener {
    void profileDataUpdated(JSONObject jSONObject);

    void profileDidInitialize(String str);
}
