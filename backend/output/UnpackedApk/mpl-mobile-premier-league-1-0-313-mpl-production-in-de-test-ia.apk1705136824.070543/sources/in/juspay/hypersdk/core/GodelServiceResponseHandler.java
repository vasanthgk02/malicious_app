package in.juspay.hypersdk.core;

import android.os.Handler;
import android.os.Message;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.utils.Utils;
import org.json.JSONObject;

public class GodelServiceResponseHandler extends Handler {
    public static final String TAG = "GodelServiceResponseHandler";
    public HyperFragment browserFragment;
    public String callBackFnName;

    public GodelServiceResponseHandler(String str, HyperFragment hyperFragment) {
        this.callBackFnName = str;
        this.browserFragment = hyperFragment;
    }

    public void handleMessage(Message message) {
        HyperFragment hyperFragment = this.browserFragment;
        if (!(hyperFragment == null || this.callBackFnName == null)) {
            JuspayServices juspayServices = hyperFragment.getJuspayServices();
            if (juspayServices != null) {
                SdkTracker sdkTracker = juspayServices.getSdkTracker();
                try {
                    JSONObject json = Utils.toJSON(message.getData());
                    json.put("code", message.what);
                    sdkTracker.trackAction("system", "info", System.GODEL_SERVICE_RESPONSE_HANDLER, "gsrh_handle_message", "Got response from the MPIN SDK: " + json.toString(2));
                    if (this.browserFragment.getDuiInterface() != null) {
                        sdkTracker.trackAction("system", "info", System.GODEL_SERVICE_RESPONSE_HANDLER, "gsrh_handle_message", "Sending response back to micro-app");
                        this.browserFragment.getDuiInterface().invokeCallbackInDUIWebview(this.callBackFnName, json.toString());
                    } else {
                        sdkTracker.trackAction("system", "error", System.MPIN_UTIL, "missing", "duiInterface");
                    }
                } catch (Exception e2) {
                    sdkTracker.trackAndLogException(TAG, "action", "system", System.MPIN_UTIL, "Exception while trying to handle message", e2);
                }
            }
        }
        this.browserFragment = null;
        this.callBackFnName = null;
    }
}
