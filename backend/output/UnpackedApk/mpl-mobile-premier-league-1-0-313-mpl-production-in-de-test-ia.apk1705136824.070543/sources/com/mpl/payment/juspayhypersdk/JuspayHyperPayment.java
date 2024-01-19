package com.mpl.payment.juspayhypersdk;

import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.payment.routing.PaymentResultListener;
import com.mpl.payment.routing.RoutingConstants;
import com.mpl.payment.utils.Constants;
import com.paynimo.android.payment.PaymentActivity;
import in.juspay.services.HyperServices;
import java.util.HashMap;
import java.util.UUID;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JuspayHyperPayment {
    public static final String TAG = "JuspayHyperPayments";
    public String amazonSellerId;
    public String cardExpMonth;
    public String cardExpYear;
    public String cardNumber;
    public String cardSecurityCode;
    public String cardToken;
    public String clientAuthToken;
    public String clientId;
    public FragmentActivity currentFragmentActivity;
    public String directWalletToken;
    public JSONArray endUrls;
    public String environment;
    public FetchCustomerIdUseCase fetchCustomerIdUseCase;
    public String merachantId;
    public JSONObject moneyInPayload;
    public String orderId;
    public String paymentMethodType;
    public String paymentMode;
    public PaymentResultListener paymentResultListener;
    public JSONObject reactJson;
    public boolean saveToLocker;
    public String savedPaymentType;
    public String upiAppPackageName;

    public JuspayHyperPayment(JSONObject jSONObject, JSONObject jSONObject2, PaymentResultListener paymentResultListener2, String str, String str2, String str3, JSONArray jSONArray, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, String str11, String str12, FragmentActivity fragmentActivity, String str13, String str14, String str15, String str16) {
        this.reactJson = jSONObject;
        this.moneyInPayload = jSONObject2;
        this.paymentResultListener = paymentResultListener2;
        this.paymentMode = str;
        this.paymentMethodType = str2;
        this.orderId = str3;
        this.endUrls = jSONArray;
        this.clientAuthToken = str4;
        this.cardNumber = str5;
        this.cardExpMonth = str6;
        this.cardExpYear = str7;
        this.cardSecurityCode = str8;
        this.cardToken = str9;
        this.saveToLocker = z;
        this.savedPaymentType = str10;
        this.directWalletToken = str11;
        this.amazonSellerId = str12;
        this.currentFragmentActivity = fragmentActivity;
        this.merachantId = str13;
        this.clientId = str14;
        this.environment = str15;
        this.upiAppPackageName = str16;
    }

    public void processPayment() {
        AnonymousClass1 r17;
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            String uuid = UUID.randomUUID().toString();
            jSONObject.put(HyperServices.REQUEST_ID, uuid);
            jSONObject.put("service", Constants.JUSPAY_SERVICE_NAME);
            AnonymousClass1 r4 = new HyperServiceProcessPayloadListener() {
                public void onCleverTapEvent(String str, HashMap<String, Object> hashMap) {
                    JuspayHyperPayment.this.paymentResultListener.onCleverTapEvent(str, hashMap);
                }

                public void onError(String str) {
                    JuspayHyperPayment.this.paymentResultListener.onMoneyInFailed(str);
                }

                public void onPayloadExtracted(JSONObject jSONObject) {
                    try {
                        if (!jSONObject.has("status")) {
                            jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
                        }
                        if (!jSONObject.has("orderId")) {
                            jSONObject.put("orderId", JuspayHyperPayment.this.orderId);
                        }
                        jSONObject.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_JUSPAY);
                    } catch (JSONException unused) {
                    }
                    JuspayHyperPayment.this.paymentResultListener.onPaymentSuccessful(jSONObject.toString());
                }
            };
            JSONObject jSONObject2 = new JSONObject();
            if (this.paymentMethodType.equals("cards")) {
                if (this.savedPaymentType.equalsIgnoreCase(BaseParser.FALSE)) {
                    jSONObject2.put("action", "cardTxn");
                    jSONObject2.put("orderId", this.orderId);
                    jSONObject2.put("endUrls", this.endUrls);
                    jSONObject2.put("paymentMethod", this.paymentMode);
                    jSONObject2.put("cardNumber", this.cardNumber);
                    jSONObject2.put("cardExpMonth", this.cardExpMonth);
                    jSONObject2.put("cardExpYear", this.cardExpYear);
                    jSONObject2.put("cardSecurityCode", this.cardSecurityCode);
                    jSONObject2.put("saveToLocker", this.saveToLocker);
                    jSONObject2.put(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, this.clientAuthToken);
                    jSONObject.put("payload", jSONObject2);
                } else if (this.savedPaymentType.equalsIgnoreCase(BaseParser.TRUE)) {
                    jSONObject2.put("action", "cardTxn");
                    jSONObject2.put("orderId", this.orderId);
                    jSONObject2.put("endUrls", this.endUrls);
                    jSONObject2.put("paymentMethod", this.paymentMode);
                    jSONObject2.put(RoutingConstants.MI_REACT_CARD_TOKEN_BRAINTREE, this.cardToken);
                    jSONObject2.put("cardSecurityCode", this.cardSecurityCode);
                    jSONObject2.put(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, this.clientAuthToken);
                    jSONObject.put("payload", jSONObject2);
                } else {
                    this.paymentResultListener.onMoneyInFailed("savedPaymenttype can either be true or false");
                    return;
                }
            } else if ("netbanking".equalsIgnoreCase(this.paymentMethodType)) {
                jSONObject2.put("action", "nbTxn");
                jSONObject2.put("orderId", this.orderId);
                jSONObject2.put("paymentMethod", this.paymentMode);
                jSONObject2.put("endUrls", this.endUrls);
                jSONObject2.put(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, this.clientAuthToken);
                jSONObject.put("payload", jSONObject2);
            } else if ("upi".equalsIgnoreCase(this.paymentMethodType)) {
                jSONObject2.put("action", "upiTxn");
                jSONObject2.put("orderId", this.orderId);
                jSONObject2.put("upiSdkPresent", true);
                jSONObject2.put("showLoader", false);
                jSONObject2.put("displayNote", this.orderId);
                jSONObject2.put(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, this.clientAuthToken);
                if (this.upiAppPackageName != null) {
                    jSONObject2.put("payWithApp", this.upiAppPackageName);
                }
                jSONObject.put("payload", jSONObject2);
                MLog.d(TAG, "processPayment: Playload Prepared---> " + jSONObject.toString());
            } else {
                str = uuid;
                if ("wallet".equalsIgnoreCase(this.paymentMethodType)) {
                    r17 = r4;
                    if ("PAYTM".equalsIgnoreCase(this.paymentMode)) {
                        jSONObject2.put("action", "walletTxn");
                        jSONObject2.put("orderId", this.orderId);
                        jSONObject2.put("paymentMethod", this.paymentMode);
                        jSONObject2.put("directWalletToken", this.directWalletToken);
                        jSONObject2.put("endUrls", this.endUrls);
                        jSONObject2.put(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, this.clientAuthToken);
                        jSONObject.put("payload", jSONObject2);
                    } else if (RoutingConstants.PAYMENT_MODE_AMAZONPAY.equalsIgnoreCase(this.paymentMode)) {
                        jSONObject2.put("action", "walletTxn");
                        jSONObject2.put("orderId", this.orderId);
                        jSONObject2.put(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, this.clientAuthToken);
                        jSONObject2.put("paymentMethod", RoutingConstants.PAYMENT_MODE_AMAZONPAY);
                        if (!BaseParser.TRUE.equalsIgnoreCase(this.savedPaymentType) || !HyperServiceWrapper.isIsInitWithCorrectCustomerId()) {
                            jSONObject2.put("endUrls", this.endUrls);
                            jSONObject2.put("paymentMethodType", PaymentActivity.PAYMENT_METHOD_WALLETS);
                            jSONObject2.put("sdkPresent", "ANDROID_AMAZONPAY_NONTOKENIZED");
                            jSONObject2.put("shouldLink", false);
                            jSONObject2.put("sdkWalletIdentifier", this.amazonSellerId);
                            jSONObject.put("payload", jSONObject2);
                        } else {
                            jSONObject2.put("sdkPresent", "ANDROID_AMAZONPAY_TOKENIZED");
                            jSONObject2.put("directWalletToken", this.directWalletToken);
                            jSONObject.put("payload", jSONObject2);
                        }
                    } else if ("PHONEPE".equalsIgnoreCase(this.paymentMode)) {
                        jSONObject2.put("action", "walletTxn");
                        jSONObject2.put("orderId", this.orderId);
                        jSONObject2.put("endUrls", this.endUrls);
                        jSONObject2.put("paymentMethod", "PHONEPE");
                        jSONObject2.put("sdkPresent", "ANDROID_PHONEPE");
                        jSONObject.put("payload", jSONObject2);
                    } else {
                        this.paymentResultListener.onMoneyInFailed("Wallet not found in JuspayHyperPayment");
                        return;
                    }
                } else {
                    r17 = r4;
                    if (RoutingConstants.PAYMENT_METHOD_TYPE_BNPL.equalsIgnoreCase(this.paymentMethodType)) {
                        if (RoutingConstants.PAYMENT_MODE_TYPE_LAZYPAY.equalsIgnoreCase(this.paymentMode)) {
                            jSONObject2.put("action", "walletTxn");
                            jSONObject2.put("orderId", this.orderId);
                            jSONObject2.put("paymentMethod", this.paymentMode);
                            jSONObject2.put("directWalletToken", this.directWalletToken);
                            jSONObject2.put("endUrls", this.endUrls);
                            jSONObject2.put(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN, this.clientAuthToken);
                            jSONObject.put("payload", jSONObject2);
                        } else {
                            this.paymentResultListener.onMoneyInFailed("BNPL payment mode not found in JuspayHyperPayment");
                            return;
                        }
                    }
                }
                HyperServiceWrapper.process(jSONObject, r17, str, this.currentFragmentActivity, this.merachantId, this.clientId, this.environment, this.fetchCustomerIdUseCase);
            }
            r17 = r4;
            str = uuid;
            HyperServiceWrapper.process(jSONObject, r17, str, this.currentFragmentActivity, this.merachantId, this.clientId, this.environment, this.fetchCustomerIdUseCase);
        } catch (Exception e2) {
            String str2 = "Exception in juspay processPayments---->";
            if (e2.getMessage() != null) {
                str2 = GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73(str2));
            }
            this.paymentResultListener.onMoneyInFailed(str2);
        }
    }
}
