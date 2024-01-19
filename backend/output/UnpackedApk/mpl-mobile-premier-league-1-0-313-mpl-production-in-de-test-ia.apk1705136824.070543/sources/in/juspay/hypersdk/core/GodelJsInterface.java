package in.juspay.hypersdk.core;

import android.webkit.JavascriptInterface;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class GodelJsInterface {
    public static final String LOG_TAG = "GodelJsInterface";
    public final HyperFragment fragment;

    public GodelJsInterface(HyperFragment hyperFragment) {
        this.fragment = hyperFragment;
    }

    @JavascriptInterface
    public void sendMessage(String str) {
        if (this.fragment.getJuspayCallback() != null && (this.fragment.getJuspayCallback() instanceof HyperPaymentsCallback)) {
            HyperPaymentsCallback hyperPaymentsCallback = (HyperPaymentsCallback) this.fragment.getJuspayCallback();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "godel_merchant_message");
                jSONObject.put("payload", str);
            } catch (JSONException e2) {
                this.fragment.getJuspayServices().getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "exception on godelJsInterface", e2);
            }
            hyperPaymentsCallback.onEvent(jSONObject, null);
        }
    }
}
