package com.braintreepayments.browserswitch;

import android.net.Uri;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import org.json.JSONException;
import org.json.JSONObject;

public class BrowserSwitchRequest {
    public JSONObject metadata;
    public final int requestCode;
    public String state;
    public Uri uri;

    public BrowserSwitchRequest(int i, Uri uri2, String str, JSONObject jSONObject) {
        this.uri = uri2;
        this.state = str;
        this.requestCode = i;
        this.metadata = jSONObject;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestCode", this.requestCode);
        jSONObject.put("url", this.uri.toString());
        jSONObject.put("state", this.state);
        JSONObject jSONObject2 = this.metadata;
        if (jSONObject2 != null) {
            jSONObject.put(LiveVideoBroadcaster.METADATA, jSONObject2);
        }
        return jSONObject.toString();
    }
}
