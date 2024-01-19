package com.mpl.beautifier;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public final class BundleBeautifier implements MLogBeautifier {
    public static BundleBeautifier INSTANCE;

    public static BundleBeautifier getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BundleBeautifier();
        }
        return INSTANCE;
    }

    public String beautify(Object obj) {
        Bundle bundle = (Bundle) obj;
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException unused) {
                try {
                    jSONObject.put(str, "Failed to retrieve value");
                } catch (Exception unused2) {
                }
            }
        }
        return jSONObject.toString();
    }

    public Class getType() {
        return Bundle.class;
    }
}
