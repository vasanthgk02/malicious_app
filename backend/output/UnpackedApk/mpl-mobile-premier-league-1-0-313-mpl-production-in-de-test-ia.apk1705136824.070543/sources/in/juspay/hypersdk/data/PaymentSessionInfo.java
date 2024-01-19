package in.juspay.hypersdk.data;

import android.content.Context;
import android.os.Bundle;
import com.mpl.payment.routing.RoutingConstants;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.HyperFragment;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.utils.IntegrationUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentSessionInfo {
    public static String LOG_TAG = "PaymentSessionInfo";
    public String acsJsHash;
    public boolean godelDisabled;
    public JuspayServices juspayServices;
    public JSONObject paymentDetails;
    public HyperFragment paymentFragment;
    public SdkTracker sdkTracker;
    public final JSONObject sessionDetails = new JSONObject();
    public SessionInfo sessionInfo;

    public PaymentSessionInfo(HyperFragment hyperFragment, JuspayServices juspayServices2) {
        this.paymentFragment = hyperFragment;
        this.juspayServices = juspayServices2;
        this.sessionInfo = juspayServices2.getSessionInfo();
        this.sdkTracker = juspayServices2.getSdkTracker();
    }

    public static String getGodelRemotesVersion(Context context) {
        return context.getString(R.string.godel_remotes_version);
    }

    private long getGodelTrackingDelay() {
        try {
            return ((this.paymentFragment.getConfig() == null || !this.paymentFragment.getConfig().has("weblab")) ? new JSONObject() : this.paymentFragment.getConfig().getJSONObject("weblab")).getLong("godelTrackerExitDelayMills");
        } catch (NullPointerException | JSONException unused) {
            this.juspayServices.sdkDebug(LOG_TAG, "Error reading godelTrackerExitDelayMills value from config");
            return 60000;
        }
    }

    private JSONObject trackExtraArguments(JSONObject jSONObject, Bundle bundle) {
        try {
            for (String str : bundle.keySet()) {
                if (str.startsWith("udf_")) {
                    jSONObject.put(str, bundle.getString(str));
                }
            }
            return jSONObject;
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.PAYMENT_SESSION_INFO, "Exception trying to track merchant arguments", e2);
            return jSONObject;
        }
    }

    public void addToSessionDetails(String str, String str2) {
        try {
            this.sessionDetails.put(str, str2);
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.PAYMENT_SESSION_INFO, "Exception when adding to sessionDetails", e2);
        }
    }

    public void createSessionDataMap() {
        try {
            this.sessionInfo.createSessionDataMap();
            if (this.sessionInfo != null) {
                JSONObject sessionData = this.sessionInfo.getSessionData();
                if (sessionData == null) {
                    sessionData = new JSONObject();
                }
                sessionData.put(PaymentConstants.GODEL_VERSION, IntegrationUtils.getGodelVersion(this.juspayServices.getContext()));
                sessionData.put(PaymentConstants.GODEL_BUILD_VERSION, IntegrationUtils.getGodelBuildVersion(this.juspayServices.getContext()));
                sessionData.put("godel_remotes_version", getGodelRemotesVersion(this.juspayServices.getContext()));
                sessionData.put("is_godel", !isGodelDisabled());
                this.sessionInfo.updateSessionData(sessionData);
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.PAYMENT_SESSION_INFO, "Exception while creatingSession Data Map", e2);
        }
    }

    public void extractPaymentDetails(Bundle bundle) {
        this.paymentDetails = getPaymentDetails(bundle);
    }

    public String getAcsJsHash() {
        return this.acsJsHash;
    }

    public JSONObject getPaymentDetails() {
        JSONObject jSONObject = this.paymentDetails;
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    public JSONObject getPaymentDetails(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", String.valueOf(bundle.get("amount")));
            jSONObject.put("bank", this.sessionInfo.get("bank", "UNKNOWN"));
            jSONObject.put("card_brand", bundle.get("card_brand"));
            jSONObject.put("card_token", String.valueOf(bundle.get(RoutingConstants.MI_REACT_CARD_TOKEN_BRAINTREE)));
            jSONObject.put("card_last_four_digits", String.valueOf(bundle.get("lastSixCardDigits")).substring(2));
            jSONObject.put("customer_email", String.valueOf(bundle.get("customer_email")));
            jSONObject.put("customer_phone_number", String.valueOf(bundle.get("customer_phone_number")));
            jSONObject.put(PaymentConstants.CLIENT_ID, String.valueOf(bundle.get(PaymentConstants.CLIENT_ID)));
            jSONObject.put(PaymentConstants.MERCHANT_ID, String.valueOf(bundle.get(PaymentConstants.MERCHANT_ID)));
            jSONObject.put("order_id", String.valueOf(bundle.get("order_id")));
            jSONObject.put(PaymentConstants.TRANSACTION_ID, String.valueOf(bundle.get(PaymentConstants.TRANSACTION_ID)));
            jSONObject.put(PaymentConstants.REMARKS, String.valueOf(bundle.get(PaymentConstants.REMARKS)));
            jSONObject.put(PaymentConstants.DESCRIPTION, String.valueOf(bundle.get("displayNote")));
            return trackExtraArguments(jSONObject, bundle);
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.PAYMENT_SESSION_INFO, "Exception while creating paymentDetails", e2);
            return new JSONObject();
        }
    }

    public JSONObject getSessionDetails() {
        return this.sessionDetails;
    }

    public String getSslWhiteListedDomainsRegex() {
        try {
            JSONObject bundleParams = this.sessionInfo.getBundleParams();
            return bundleParams.has("sslWhiteListedDomainsRegex") ? bundleParams.getString("sslWhiteListedDomainsRegex") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean isGodelDisabled() {
        boolean z = true;
        try {
            JSONObject jSONObject = (this.paymentFragment.getConfig() == null || !this.paymentFragment.getConfig().has("weblab")) ? new JSONObject() : this.paymentFragment.getConfig().getJSONObject("weblab");
            if ((!jSONObject.has(PaymentConstants.GODEL) || Integer.parseInt(String.valueOf(jSONObject.get(PaymentConstants.GODEL))) != 0) && !this.godelDisabled) {
                z = false;
            }
            return z;
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.PAYMENT_SESSION_INFO, "Exception while retrieving Godel value", e2);
            return true;
        }
    }

    public void setAcsJsHash(String str) {
        this.acsJsHash = str;
    }

    public void setGodelDisabled(String str) {
        this.godelDisabled = true;
        this.sdkTracker.trackAction("system", "info", System.PAYMENT_SESSION_INFO, "godel_switching_off", str);
    }

    public void setPaymentDetails(String str, String str2) {
        try {
            if (this.paymentDetails == null) {
                this.paymentDetails = new JSONObject();
            }
            this.paymentDetails.put(str, str2);
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.PAYMENT_SESSION_INFO, "Exception while trying to set payment details", e2);
        }
    }

    public void setPaymentDetails(JSONObject jSONObject) {
        this.paymentDetails = jSONObject;
    }
}
