package com.braintreepayments.browserswitch;

import android.content.Context;
import android.net.Uri;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class BrowserSwitchPersistentStore {
    public static final BrowserSwitchPersistentStore INSTANCE = new BrowserSwitchPersistentStore();

    public BrowserSwitchRequest getActiveRequest(Context context) {
        String string = context.getApplicationContext().getSharedPreferences("com.braintreepayament.browserswitch.persistentstore", 0).getString("browserSwitch.request", null);
        if (string == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int i = jSONObject.getInt("requestCode");
            String string2 = jSONObject.getString("url");
            return new BrowserSwitchRequest(i, Uri.parse(string2), jSONObject.getString("state"), jSONObject.optJSONObject(LiveVideoBroadcaster.METADATA));
        } catch (JSONException e2) {
            e2.getMessage();
            Arrays.toString(e2.getStackTrace());
            return null;
        }
    }

    public void putActiveRequest(BrowserSwitchRequest browserSwitchRequest, Context context) {
        try {
            context.getApplicationContext().getSharedPreferences("com.braintreepayament.browserswitch.persistentstore", 0).edit().putString("browserSwitch.request", browserSwitchRequest.toJson()).apply();
        } catch (JSONException e2) {
            e2.getMessage();
            Arrays.toString(e2.getStackTrace());
        }
    }
}
