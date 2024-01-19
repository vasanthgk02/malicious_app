package in.juspay.hypersdk.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import in.juspay.hypersdk.core.Labels.System;
import java.util.HashMap;
import org.json.JSONObject;

public class MPINUtil {
    public static final String TAG = "MPINUtil";
    public static HashMap<String, MPINUtil> orchestrator;
    public final ComponentName component;
    public GodelServiceConnection connection;

    public MPINUtil(JuspayServices juspayServices, String str, String str2) {
        this.connection = new GodelServiceConnection(juspayServices);
        this.component = new ComponentName(str, str2);
    }

    private boolean bind(Context context) {
        Intent intent = new Intent();
        intent.setComponent(this.component);
        return context.bindService(intent, this.connection, 1);
    }

    public static void closeAllConnections(Context context) {
        HashMap<String, MPINUtil> hashMap = orchestrator;
        if (hashMap != null) {
            for (String closeConnection : hashMap.keySet()) {
                closeConnection(closeConnection, context);
            }
        }
        orchestrator = null;
    }

    public static void closeConnection(String str, Context context) {
        HashMap<String, MPINUtil> hashMap = orchestrator;
        if (hashMap != null && hashMap.containsKey(str)) {
            orchestrator.get(str).unbind(context);
            orchestrator.remove(str);
        }
    }

    public static void communicate(String str, String str2, int i, Bundle bundle, HyperFragment hyperFragment, String str3) {
        MPINUtil mPINUtil;
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            sdkTracker.trackAction("system", "info", System.MPIN_UTIL, "mpinutil_communicate", "Attempting to communicate to " + str + "/" + str2);
            if (orchestrator == null) {
                orchestrator = new HashMap<>();
            }
            if (orchestrator.containsKey(str)) {
                sdkTracker.trackAction("system", "info", System.MPIN_UTIL, "mpinutil_communicate", "Fetching existing instance from orchestrator");
                mPINUtil = orchestrator.get(str);
            } else {
                MPINUtil mPINUtil2 = new MPINUtil(juspayServices, str, str2);
                sdkTracker.trackAction("system", "info", System.MPIN_UTIL, "mpinutil_communicate", "Creating new MPINUtil instance in orchestrator");
                if (!mPINUtil2.bind(hyperFragment.getContext())) {
                    sdkTracker.trackAction("system", "info", System.MPIN_UTIL, "mpinutil_communicate", "Failed to bind to MPIN SDK. Reporting Bind Failure back to mApp");
                    reportBindFailure(i, hyperFragment, str3);
                    return;
                }
                orchestrator.put(str, mPINUtil2);
                mPINUtil = mPINUtil2;
            }
            sdkTracker.trackAction("system", "info", System.MPIN_UTIL, "mpinutil_communicate", "Requesting a connection with MPIN SDK");
            mPINUtil.connection.request(i, bundle, new GodelServiceResponseHandler(str3, hyperFragment));
        } catch (Exception e2) {
            SdkTracker sdkTracker2 = sdkTracker;
            sdkTracker2.trackAction("system", "info", System.MPIN_UTIL, "mpinutil_communicate", "Failed to bind to MPIN SDK. Reporting Bind Failure back to mApp");
            sdkTracker2.trackAndLogException(TAG, "action", "system", System.MPIN_UTIL, "Exception while trying to connect", e2);
            reportBindFailure(i, hyperFragment, str3);
        }
    }

    public static void reportBindFailure(int i, HyperFragment hyperFragment, String str) {
        if (hyperFragment != null && hyperFragment.getDuiInterface() != null && str != null) {
            JuspayServices juspayServices = hyperFragment.getJuspayServices();
            SdkTracker sdkTracker = juspayServices != null ? juspayServices.getSdkTracker() : null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", i);
                jSONObject.put("error", true);
                jSONObject.put("message", "BIND_FAILURE");
            } catch (Exception e2) {
                Exception exc = e2;
                if (sdkTracker != null) {
                    sdkTracker.trackAndLogException(TAG, "action", "system", System.MPIN_UTIL, "Exception while creating bind failure response", exc);
                }
            }
            hyperFragment.getDuiInterface().invokeCallbackInDUIWebview(str, jSONObject.toString());
        }
    }

    private void unbind(Context context) {
        GodelServiceConnection godelServiceConnection = this.connection;
        if (godelServiceConnection != null && godelServiceConnection.isBound) {
            try {
                context.unbindService(godelServiceConnection);
            } catch (Exception unused) {
            }
            this.connection = null;
        }
    }
}
