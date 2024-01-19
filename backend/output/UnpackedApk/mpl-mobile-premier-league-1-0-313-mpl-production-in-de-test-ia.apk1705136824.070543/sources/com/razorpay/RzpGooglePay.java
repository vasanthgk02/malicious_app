package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient;
import com.google.android.apps.nbu.paisa.inapp.client.api.Wallet;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class RzpGooglePay implements RzpPlugin {
    public static int LOAD_PAYMENT_DATA_REQUEST_CODE = 1;
    public JSONObject apiResponse;
    public PaymentsClient mPaymentClient;
    public RzpInternalCallback rzpInternalCallback;

    private void handleResultStatusCode(int i) {
        if (i == 405) {
            this.rzpInternalCallback.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "There is a problem with merchant's account."));
        } else if (i != 409) {
            this.rzpInternalCallback.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "An internal error has occurred."));
        } else {
            this.rzpInternalCallback.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "There is a problem with your Google Pay account."));
        }
    }

    private void processPaymentResponse(String str) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_VERIFY_PAYMENT_CALLED);
        if (verifyPaymentResponse(str)) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_VERIFY_PAYMENT_SUCCESS_CALLED);
            this.rzpInternalCallback.onPaymentSuccess(RzpPayloadUtil.makeExternalSDKPayload(this.apiResponse));
            return;
        }
        AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_VERIFY_PAYMENT_ERROR_CALLED);
        this.rzpInternalCallback.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "Payment was not successful."));
    }

    public static boolean verifyPaymentResponse(String str) {
        boolean z = false;
        try {
            String string = new JSONObject(str).getJSONObject("paymentMethodData").getJSONObject("tokenizationData").getString("token");
            if (string == null) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_VERIFY_PAYMENT_EXCEPTION);
                return false;
            }
            String string2 = new JSONObject(new JSONObject(string).getString("signedMessage")).getJSONObject("paymentMethodDetails").getString("status");
            if (string2 != null && string2.equals("SUCCESS")) {
                z = true;
            }
            return z;
        } catch (JSONException unused) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_VERIFY_PAYMENT_EXCEPTION);
            return false;
        }
    }

    public boolean doesHandlePayload(String str, JSONObject jSONObject, Activity activity) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(AnalyticsConstants.METHOD) && jSONObject.getString(AnalyticsConstants.METHOD).equalsIgnoreCase("upi") && jSONObject.getString("_[app]").equalsIgnoreCase(BaseConstants.GOOGLE_PAY_PKG)) {
                    return true;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public RzpPluginCompatibilityResponse isCompatible(String str, int i, String str2) {
        String str3;
        if (str.equalsIgnoreCase(BuildConfig.SDK_TYPE) && i > 27) {
            return new RzpPluginCompatibilityResponse(true, null);
        }
        if (str.equalsIgnoreCase(AnalyticsConstants.CHECKOUT) && i > 18) {
            return new RzpPluginCompatibilityResponse(true, null);
        }
        if (str.equalsIgnoreCase(BuildConfig.SDK_TYPE)) {
            str3 = "Razorpay's GooglePay plugin requires a min SDK Version 3.8.8 Please update.";
        } else {
            str3 = str.equalsIgnoreCase(AnalyticsConstants.CHECKOUT) ? "Razorpay's GooglePay plugin requires a min SDK Version 1.5.6 Please update." : "Incompatible Razorpay sdk version. Please update the base sdk";
        }
        return new RzpPluginCompatibilityResponse(false, str3);
    }

    public void isRegistered(Context context) {
        Task<Boolean> task;
        this.mPaymentClient = Wallet.paymentsClient;
        AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_CHECK_REGISTER_CALLED);
        try {
            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_PAYMENT_IS_REGISTERED_CALLED);
            task = this.mPaymentClient.isReadyToPay(context, ((JSONObject) Objects.requireNonNull(RzpPayloadUtil.getIsReadyToPayRequest())).toString());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            task = null;
        }
        ((Task) Objects.requireNonNull(task)).addOnCompleteListener(new OnCompleteListener<Boolean>() {
            public void onComplete(Task<Boolean> task) {
                BaseUtils.setCompatibleWithGooglePay(((Boolean) task.getResult()).booleanValue());
            }
        });
    }

    public void onActivityResult(String str, int i, int i2, Intent intent) {
        if (i != LOAD_PAYMENT_DATA_REQUEST_CODE) {
            return;
        }
        if (i2 == -1) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_PAYMENT_CALLBACK_SUCCESS);
            processPaymentResponse(intent.getStringExtra("paymentDataJson"));
        } else if (i2 == 0) {
            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_PAYMENT_CALLBACK_CANCELLED);
            this.rzpInternalCallback.onPaymentError(0, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "Payment canceled."));
        } else if (i2 == 1) {
            handleResultStatusCode(intent.getIntExtra("errorCode", 8));
        }
    }

    public void processPayment(String str, final JSONObject jSONObject, final Activity activity, final RzpInternalCallback rzpInternalCallback2) {
        try {
            this.rzpInternalCallback = rzpInternalCallback2;
            this.mPaymentClient = Wallet.paymentsClient;
            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_PROCESS_PAYMENT_CALLED);
            if (!jSONObject.has("url_data") || jSONObject.get("url_data") == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                Owl.post("https://api.razorpay.com/v1/payments/create/ajax", RzpPayloadUtil.makeApiPayload(jSONObject), hashMap, new Callback() {
                    public void run(ResponseObject responseObject) {
                        try {
                            RzpGooglePay.this.apiResponse = new JSONObject(responseObject.getResponseResult());
                            JSONObject jSONObject = new JSONObject(responseObject.getResponseResult());
                            if (responseObject.getResponseCode() >= 400) {
                                rzpInternalCallback2.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "An error occurred while fetching paymant details from API."));
                            }
                            if (jSONObject.has("error")) {
                                AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_PROCESS_PAYMENT_PAYLOAD_ERROR);
                                rzpInternalCallback2.onPaymentError(3, jSONObject.toString());
                                return;
                            }
                            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_PROCESS_PAYMENT_CALLED);
                            RzpGooglePay.this.mPaymentClient.loadPaymentData(activity, RzpPayloadUtil.getPaymentRequestData(responseObject.getResponseResult(), jSONObject), RzpGooglePay.LOAD_PAYMENT_DATA_REQUEST_CODE);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            rzpInternalCallback2.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "An internal error has occurred."));
                        }
                    }
                });
                return;
            }
            try {
                String obj = jSONObject.get("url_data").toString();
                try {
                    this.apiResponse = RzpPayloadUtil.getUpiData(obj);
                    this.mPaymentClient.loadPaymentData(activity, RzpPayloadUtil.getPaymentRequestData(obj, jSONObject), LOAD_PAYMENT_DATA_REQUEST_CODE);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    rzpInternalCallback2.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "An internal error has occurred."));
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                rzpInternalCallback2.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "An unknown error occurred."));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            rzpInternalCallback2.onPaymentError(5, RzpPayloadUtil.makeErrorPayload("BAD_REQUEST_ERROR", "An unknown error occurred."));
        }
    }

    public void isRegistered(Context context, final RzpPluginRegisterCallback rzpPluginRegisterCallback) {
        Task<Boolean> task;
        this.mPaymentClient = Wallet.paymentsClient;
        AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_CHECK_REGISTER_CALLED);
        try {
            AnalyticsUtil.trackEvent(AnalyticsEvent.GOOGLEPAY_PAYMENT_IS_REGISTERED_CALLED);
            task = this.mPaymentClient.isReadyToPay(context, ((JSONObject) Objects.requireNonNull(RzpPayloadUtil.getIsReadyToPayRequest())).toString());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            task = null;
        }
        ((Task) Objects.requireNonNull(task)).addOnCompleteListener(new OnCompleteListener<Boolean>() {
            public void onComplete(Task<Boolean> task) {
                boolean booleanValue = ((Boolean) task.getResult()).booleanValue();
                BaseUtils.setCompatibleWithGooglePay(booleanValue);
                rzpPluginRegisterCallback.onResponse(booleanValue);
            }
        });
    }
}
