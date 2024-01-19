package com.mpl.payment.juspayhypersdk;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.PaymentUtils;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCaseResultListener;
import com.mpl.payment.utils.Constants;
import in.juspay.hypersdk.core.Labels.HyperSdk;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.services.HyperServices;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class HyperServiceWrapper {
    public static final String TAG = "HyperServiceWrapper";
    public static HyperServices hyperServicesInstance;
    public static boolean isInitWithCorrectCustomerId;
    public static HashMap<String, HyperServiceProcessPayloadListener> requestMap = new HashMap<>();

    public static void initialiseHyperSdk(FragmentActivity fragmentActivity, String str, String str2, String str3, InitFailedListener initFailedListener, FetchCustomerIdUseCase fetchCustomerIdUseCase) {
        if (hyperServicesInstance == null) {
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                initFailedListener.onInitFailed("init will fail because activity was null or was finishing");
                return;
            }
            hyperServicesInstance = new HyperServices(fragmentActivity);
        }
        if (!hyperServicesInstance.isInitialised()) {
            final FragmentActivity fragmentActivity2 = fragmentActivity;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final InitFailedListener initFailedListener2 = initFailedListener;
            AnonymousClass1 r1 = new FetchCustomerIdUseCaseResultListener() {
                public void onError(String str) {
                    HyperServiceWrapper.startInitiate(FragmentActivity.this, str4, str5, str6, initFailedListener2, UUID.randomUUID().toString());
                    HyperServiceWrapper.isInitWithCorrectCustomerId = false;
                }

                public void onSuccess(String str) {
                    HyperServiceWrapper.startInitiate(FragmentActivity.this, str4, str5, str6, initFailedListener2, str);
                    HyperServiceWrapper.isInitWithCorrectCustomerId = true;
                }
            };
            fetchCustomerIdUseCase.fetchCustomerId(r1);
        }
    }

    public static boolean isIsInitWithCorrectCustomerId() {
        return isInitWithCorrectCustomerId;
    }

    public static boolean onBackPressed() {
        HyperServices hyperServices = hyperServicesInstance;
        if (hyperServices != null) {
            return hyperServices.onBackPressed();
        }
        return false;
    }

    public static void prefetchAssets(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String uuid = UUID.randomUUID().toString();
        try {
            jSONObject2.put(PaymentConstants.CLIENT_ID_CAMEL, str);
            jSONObject.put("payload", jSONObject2);
            jSONObject.put("service", Constants.JUSPAY_SERVICE_NAME);
            jSONObject.put(HyperServices.REQUEST_ID, uuid);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HyperServices.preFetch(context, jSONObject);
    }

    public static void process(JSONObject jSONObject, HyperServiceProcessPayloadListener hyperServiceProcessPayloadListener, String str, FragmentActivity fragmentActivity, String str2, String str3, String str4, FetchCustomerIdUseCase fetchCustomerIdUseCase) {
        if (str == null) {
            hyperServiceProcessPayloadListener.onError("Requestid can't be null in process");
        } else if (!requestMap.containsKey(str)) {
            HyperServices hyperServices = hyperServicesInstance;
            if (hyperServices == null || !hyperServices.isInitialised()) {
                reInitSdk(jSONObject, hyperServiceProcessPayloadListener, str, fragmentActivity, str2, str3, str4, fetchCustomerIdUseCase);
            } else if (hyperServicesInstance.isInitialised()) {
                requestMap.put(str, hyperServiceProcessPayloadListener);
                try {
                    hyperServicesInstance.process(fragmentActivity, jSONObject);
                } catch (Exception e2) {
                    requestMap.remove(str);
                    hyperServiceProcessPayloadListener.onError(e2.getMessage() != null ? e2.getMessage() : "Exception during hyperservice process");
                }
            } else {
                reInitSdk(jSONObject, hyperServiceProcessPayloadListener, str, fragmentActivity, str2, str3, str4, fetchCustomerIdUseCase);
            }
        } else {
            hyperServiceProcessPayloadListener.onError("Requestid collision in process");
        }
    }

    public static void reInitSdk(JSONObject jSONObject, final HyperServiceProcessPayloadListener hyperServiceProcessPayloadListener, String str, FragmentActivity fragmentActivity, String str2, String str3, String str4, FetchCustomerIdUseCase fetchCustomerIdUseCase) {
        initialiseHyperSdk(fragmentActivity, str2, str3, str4, new InitFailedListener() {
            public void onInitFailed(String str) {
                HyperServiceProcessPayloadListener.this.onCleverTapEvent(JuspayHyperPaymentConstants.INIT_FAIL_CLEVERTAP_EVENT, GeneratedOutlineSupport.outline87("reason", str));
            }
        }, fetchCustomerIdUseCase);
        HashMap hashMap = new HashMap();
        hashMap.put("reason", "Failing transaction as init was not done");
        hyperServiceProcessPayloadListener.onCleverTapEvent(JuspayHyperPaymentConstants.INIT_FAIL_CLEVERTAP_EVENT, hashMap);
        hyperServiceProcessPayloadListener.onError("Failing transaction as init was not done");
    }

    public static void startInitiate(FragmentActivity fragmentActivity, String str, String str2, String str3, final InitFailedListener initFailedListener, String str4) {
        prefetchAssets(fragmentActivity.getApplicationContext(), str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", HyperSdk.INITIATE);
            jSONObject.put(PaymentConstants.MERCHANT_ID_CAMEL, str);
            jSONObject.put(PaymentConstants.CLIENT_ID_CAMEL, str2);
            jSONObject.put("customerId", str4);
            jSONObject.put(PaymentConstants.ENV, str3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HyperServices.REQUEST_ID, UUID.randomUUID().toString());
            jSONObject2.put("service", Constants.JUSPAY_SERVICE_NAME);
            jSONObject2.put("payload", jSONObject);
            hyperServicesInstance.initiate(jSONObject2, (HyperPaymentsCallback) new HyperPaymentsCallbackAdapter() {
                private String getErrorString(JSONObject jSONObject) {
                    return "Error in process_result___" + jSONObject.optString("errorCode", "No_error_code") + "___" + jSONObject.optString("errorMessage", "No_error_message");
                }

                public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
                    try {
                        String string = jSONObject.getString("event");
                        if (string.equals("initiate_result")) {
                            if (!jSONObject.getBoolean("error")) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("payload");
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString("status", "");
                                    if (PaymentUtils.isEmptyOrNull(optString) || !"success".equalsIgnoreCase(optString)) {
                                        InitFailedListener initFailedListener = InitFailedListener.this;
                                        if (("init status was not success it was->" + optString) == null) {
                                            optString = "null";
                                        }
                                        initFailedListener.onInitFailed(optString);
                                        return;
                                    }
                                    return;
                                }
                                InitFailedListener.this.onInitFailed("no payload in init_result, init probably failed");
                                return;
                            }
                            InitFailedListener.this.onInitFailed(getErrorString(jSONObject));
                        } else if (string.equals("process_result")) {
                            String optString2 = jSONObject.optString(HyperServices.REQUEST_ID);
                            if (!PaymentUtils.isEmptyOrNull(optString2) && HyperServiceWrapper.requestMap.containsKey(optString2)) {
                                HyperServiceProcessPayloadListener hyperServiceProcessPayloadListener = (HyperServiceProcessPayloadListener) HyperServiceWrapper.requestMap.get(optString2);
                                if (hyperServiceProcessPayloadListener != null) {
                                    boolean z = jSONObject.getBoolean("error");
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("payload");
                                    if (!z) {
                                        if (optJSONObject2 != null) {
                                            hyperServiceProcessPayloadListener.onPayloadExtracted(optJSONObject2);
                                        } else {
                                            hyperServiceProcessPayloadListener.onError("No payload found for request-->" + optString2);
                                        }
                                    } else if (optJSONObject2 != null) {
                                        hyperServiceProcessPayloadListener.onPayloadExtracted(optJSONObject2);
                                    } else {
                                        hyperServiceProcessPayloadListener.onError("Error and no payload" + getErrorString(jSONObject));
                                    }
                                }
                                HyperServiceWrapper.requestMap.remove(optString2);
                            }
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void terminateHyperSdk() {
        HyperServices hyperServices = hyperServicesInstance;
        if (hyperServices != null) {
            hyperServices.terminate();
            hyperServicesInstance = null;
        }
    }
}
