package com.clevertap.android.sdk.response;

import android.content.Context;
import org.json.JSONObject;

public abstract class CleverTapResponse {
    public void processResponse(JSONObject jSONObject, String str, Context context) {
    }
}
