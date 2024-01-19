package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.react.modules.network.NetworkingModule;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

public class NotificationParams {
    public final Bundle data;

    public NotificationParams(Bundle bundle) {
        if (bundle != null) {
            this.data = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    public static boolean isNotification(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String userFriendlyKey(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        return "1".equals(string) || Boolean.parseBoolean(string);
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return Integer.valueOf(Integer.parseInt(string));
            } catch (NumberFormatException unused) {
                userFriendlyKey(str);
            }
        }
        return null;
    }

    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONArray(string);
            } catch (JSONException unused) {
                userFriendlyKey(str);
            }
        }
        return null;
    }

    public int[] getLightSettings() {
        JSONArray jSONArray = getJSONArray("gcm.n.light_settings");
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArray.length() == 3) {
                int parseColor = Color.parseColor(jSONArray.optString(0));
                if (parseColor != -16777216) {
                    iArr[0] = parseColor;
                    iArr[1] = jSONArray.optInt(1);
                    iArr[2] = jSONArray.optInt(2);
                    return iArr;
                }
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            "LightSettings is invalid: " + jSONArray + ". Skipping setting LightSettings";
            return null;
        } catch (IllegalArgumentException e2) {
            "LightSettings is invalid: " + jSONArray + ". " + e2.getMessage() + ". Skipping setting LightSettings";
            return null;
        }
    }

    public Uri getLink() {
        String string = getString("gcm.n.link_android");
        if (TextUtils.isEmpty(string)) {
            string = getString("gcm.n.link");
        }
        if (!TextUtils.isEmpty(string)) {
            return Uri.parse(string);
        }
        return null;
    }

    public Object[] getLocalizationArgsForKey(String str) {
        JSONArray jSONArray = getJSONArray(str + "_loc_args");
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public String getLocalizationResourceForKey(String str) {
        return getString(str + "_loc_key");
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return Long.valueOf(Long.parseLong(string));
            } catch (NumberFormatException unused) {
                userFriendlyKey(str);
            }
        }
        return null;
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String string = getString(str2);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String localizationResourceForKey = getLocalizationResourceForKey(str2);
        String str3 = null;
        if (!TextUtils.isEmpty(localizationResourceForKey)) {
            int identifier = resources.getIdentifier(localizationResourceForKey, NetworkingModule.REQUEST_BODY_KEY_STRING, str);
            if (identifier == 0) {
                userFriendlyKey(str2 + "_loc_key");
            } else {
                Object[] localizationArgsForKey = getLocalizationArgsForKey(str2);
                if (localizationArgsForKey == null) {
                    str3 = resources.getString(identifier);
                } else {
                    try {
                        str3 = resources.getString(identifier, localizationArgsForKey);
                    } catch (MissingFormatArgumentException unused) {
                        userFriendlyKey(str2);
                        Arrays.toString(localizationArgsForKey);
                    }
                }
            }
        }
        return str3;
    }

    public String getString(String str) {
        String str2;
        Bundle bundle = this.data;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            if (!str.startsWith("gcm.n.")) {
                str2 = str;
            } else {
                str2 = str.replace("gcm.n.", "gcm.notification.");
            }
            if (this.data.containsKey(str2)) {
                str = str2;
            }
        }
        return bundle.getString(str);
    }

    public long[] getVibrateTimings() {
        JSONArray jSONArray = getJSONArray("gcm.n.vibrate_timings");
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() > 1) {
                int length = jSONArray.length();
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = jSONArray.optLong(i);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            "User defined vibrateTimings is invalid: " + jSONArray + ". Skipping setting vibrateTimings.";
            return null;
        }
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = new Bundle(this.data);
        for (String str : this.data.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
