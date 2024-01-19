package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.notification.SMTNotificationConstants;
import in.juspay.hypersdk.core.Labels.Android;
import in.juspay.hypersdk.core.Labels.SDK;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.ApiCall;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SmsReceiver extends BroadcastReceiver implements ResultAwaitingDuiHook {
    public static final String LOG_TAG = SmsReceiver.class.getSimpleName();
    public static final int SMS_CONSENT_REQUEST = 11;
    public HyperFragment browserFragment;
    public String callbackId;
    public IntentFilter interFilter;
    public JuspayServices juspayServices;

    @Keep
    public SmsReceiver() {
    }

    public SmsReceiver(HyperFragment hyperFragment, String str) {
        this.callbackId = str;
        this.browserFragment = hyperFragment;
        this.juspayServices = hyperFragment.getJuspayServices();
    }

    /* access modifiers changed from: private */
    public void checkAndLaunchConsentDialog(SmsConsentHandler smsConsentHandler) {
        Intent consentIntent = smsConsentHandler.getConsentIntent();
        if (consentIntent != null) {
            this.browserFragment.startActivityForResult(consentIntent, 11);
            this.browserFragment.getDuiInterface().invokeFnInDUIWebview("onSMSConsentShown", "{ }");
        }
    }

    private void tryReceiveMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Object[] objArr = (Object[]) extras.get("pdus");
            int length = objArr != null ? objArr.length : 0;
            SmsMessage[] smsMessageArr = new SmsMessage[length];
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                smsMessageArr[i] = SmsMessage.createFromPdu(objArr != null ? objArr[i] : null);
                String upperCase = smsMessageArr[i].getOriginatingAddress().toUpperCase();
                String upperCase2 = smsMessageArr[i].getMessageBody().toUpperCase();
                String valueOf = String.valueOf(smsMessageArr[i].getTimestampMillis());
                JuspayServices juspayServices2 = this.juspayServices;
                String str = LOG_TAG;
                StringBuilder outline82 = GeneratedOutlineSupport.outline82("Message is from ", upperCase, " and body is ", upperCase2, " at ");
                outline82.append(valueOf);
                juspayServices2.sdkDebug(str, outline82.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("from", upperCase);
                jSONObject.put(SMTNotificationConstants.NOTIF_BODY_KEY, upperCase2);
                jSONObject.put("time", valueOf);
                jSONArray.put(jSONObject);
            }
            if (jSONArray.length() > 0 && this.browserFragment.getDuiInterface() != null) {
                this.browserFragment.getDuiInterface().invokeCallbackInDUIWebview(this.callbackId, jSONArray.toString());
            }
        }
    }

    public void attach(Activity activity) {
        IntentFilter intentFilter = this.interFilter;
        if (intentFilter == null) {
            final SmsConsentHandler smsConsentHandler = this.browserFragment.getSmsConsentHandler();
            if (smsConsentHandler == null) {
                this.juspayServices.getSdkTracker().trackAction("system", "error", System.INITIALISE_JUSPAY_WEBVIEW, "missing", SmsConsentHandler.LOG_TAG);
                return;
            } else {
                checkAndLaunchConsentDialog(smsConsentHandler);
                smsConsentHandler.setIntentReceivedCallback(new Runnable() {
                    public void run() {
                        SmsReceiver.this.checkAndLaunchConsentDialog(smsConsentHandler);
                    }
                });
            }
        } else {
            activity.registerReceiver(this, intentFilter);
        }
        JuspayServices juspayServices2 = this.juspayServices;
        String str = LOG_TAG;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Attaching the ");
        outline73.append(LOG_TAG);
        outline73.append(" on callback ");
        outline73.append(this.callbackId);
        juspayServices2.sdkDebug(str, outline73.toString());
    }

    public void detach(Activity activity) {
        try {
            if (this.interFilter == null) {
                SmsConsentHandler smsConsentHandler = this.browserFragment.getSmsConsentHandler();
                if (smsConsentHandler != null) {
                    smsConsentHandler.setIntentReceivedCallback(null);
                }
            } else {
                activity.unregisterReceiver(this);
            }
            JuspayServices juspayServices2 = this.juspayServices;
            String str = LOG_TAG;
            juspayServices2.sdkDebug(str, "Detaching the " + LOG_TAG);
        } catch (Exception unused) {
        }
    }

    public String execute(Activity activity, String str, JSONObject jSONObject, String str2) {
        try {
            return PaymentUtils.readSmsFromInbox(this.juspayServices, activity, jSONObject.getString("smsReadStartTime"));
        } catch (JSONException e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.BROADCAST_RECEIVER, "Exception while trying to read sms from Inbox: ", e2);
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public IntentFilter getIntentFilter() {
        return this.interFilter;
    }

    public String getMaskedMessage(String str) {
        return str.replaceAll("[0-9]", "X");
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        if (i != 11) {
            return false;
        }
        this.browserFragment.resetSmsConsentHandler();
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
            String str = LOG_TAG;
            JuspayLogger.d(str, "Received SMS text: " + stringExtra);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("from", "UNKNOWN_BANK");
                jSONObject.put(SMTNotificationConstants.NOTIF_BODY_KEY, stringExtra);
                jSONObject.put("time", String.valueOf(System.currentTimeMillis()));
                String jSONObject2 = jSONObject.toString();
                String str2 = LOG_TAG;
                JuspayLogger.d(str2, "Sending to callback " + this.callbackId);
                JuspayLogger.d(LOG_TAG, jSONObject2);
                if (this.browserFragment.getDuiInterface() != null) {
                    this.browserFragment.getDuiInterface().invokeCallbackInDUIWebview(this.callbackId, jSONObject2);
                    sdkTracker.trackAction("system", "debug", System.BROADCAST_RECEIVER, Android.ON_ACTIVITY_RESULT, "Response sent back to microapp");
                }
            } catch (JSONException e2) {
                SdkTracker sdkTracker2 = sdkTracker;
                sdkTracker2.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.AMAZON_UTILS, "JSON Exception", e2);
            }
        } else if (i2 == 0) {
            sdkTracker.trackAction("system", "debug", System.BROADCAST_RECEIVER, Android.ON_ACTIVITY_RESULT, "User denied SMS consent");
            String str3 = LOG_TAG;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Calling callback ");
            outline73.append(this.callbackId);
            outline73.append(" with message DENIED");
            JuspayLogger.d(str3, outline73.toString());
            if (this.browserFragment.getDuiInterface() != null) {
                this.browserFragment.getDuiInterface().invokeCallbackInDUIWebview(this.callbackId, "DENIED");
            }
        }
        return true;
    }

    public void onReceive(Context context, Intent intent) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
                tryReceiveMessage(intent);
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.BROADCAST_RECEIVER, "Failed to receive sms", e2);
        }
    }

    public void setIntentFilter(IntentFilter intentFilter) {
        this.interFilter = intentFilter;
    }
}
