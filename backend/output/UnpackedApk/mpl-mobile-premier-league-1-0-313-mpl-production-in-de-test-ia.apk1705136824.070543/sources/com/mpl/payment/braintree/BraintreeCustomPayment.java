package com.mpl.payment.braintree;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.DataCollector$1;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.interfaces.ThreeDSecureLookupListener;
import com.braintreepayments.api.models.PayPalRequest;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.ThreeDSecureAdditionalInformation;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.models.ThreeDSecurePostalAddress;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.common.config.PaymentConfig;
import com.mpl.payment.common.config.PaymentConfigProvider;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.mpl.payment.routing.PaymentResultListener;
import com.mpl.payment.utils.StringUtils;
import java.util.ArrayList;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

public class BraintreeCustomPayment {
    public static final String BT_PAYMENT_TYPE_CARD = "card";
    public static final String BT_PAYMENT_TYPE_PAYPAL = "paypal";
    public static final String TAG = "BraintreeCustomPayment";
    public String amount;
    public AuthTokenProvider authTokenProvider;
    public String billingAgreementDescription;
    public BraintreeCancelListener braintreeCancelListener = new BraintreeCancelListener() {
        public void onCancel(int i) {
            BraintreeCustomPayment.this.processUserCancellation("User cancelled the transaction!");
        }
    };
    public BraintreeErrorListener braintreeErrorListener = new BraintreeErrorListener() {
        public void onError(Exception exc) {
            StringBuilder sb = new StringBuilder("Error happened in Braintree custom payment");
            if (exc != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73(" class name");
                outline73.append(exc.getClass().getName());
                sb.append(outline73.toString());
                if (exc.getMessage() != null) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73(" message is: ");
                    outline732.append(exc.getMessage());
                    sb.append(outline732.toString());
                }
                if (exc instanceof ErrorWithResponse) {
                    ErrorWithResponse errorWithResponse = (ErrorWithResponse) exc;
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73(" errorResponse is ");
                    outline733.append(errorWithResponse.mOriginalResponse);
                    sb.append(outline733.toString());
                    sb.append(" error status code is: " + errorWithResponse.mStatusCode);
                } else if (exc instanceof UnexpectedException) {
                    UnexpectedException unexpectedException = (UnexpectedException) exc;
                }
            }
            BraintreeCustomPayment.this.processFailure(sb.toString());
        }
    };
    public AppCompatActivity callingActivity;
    public String cardType;
    public String clientToken;
    public String currencyCode;
    public String deviceData;
    public String is3DsOn;
    public String isSavedPaymentMethod;
    public String localeCode;
    public BraintreeFragment mBraintreeFragment;
    public ArrayList<MHeader> mHeaders = new ArrayList<>();
    public String mplOrderId;
    public String nonceSubmissionUrl;
    public final PaymentMethodNonceCreatedListener paymentMethodNonceCreatedListener = new PaymentMethodNonceCreatedListener() {
        public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
            BraintreeCustomPayment.this.doNonceSubmission(BraintreeConstants.NS_TOKEN_TYPE_NONCE, paymentMethodNonce.mNonce);
        }
    };
    public String paymentMethodToken;
    public String paymentModeFromReact;
    public PaymentResultListener paymentResultListener;
    public String paymentType;
    public String savedCardNonce;
    public String shouldSavePaymentMethod;
    public String verifiedCardNonce;

    public static class BraintreeCustomPaymentBuilder {
        public String amount;
        public AuthTokenProvider authTokenProvider;
        public String billingAgreementDescription;
        public AppCompatActivity callingActivity;
        public String cardType;
        public String clientToken;
        public String currencyCode;
        public String is3DsOn;
        public String isSavedPaymentMethod;
        public String localeCode;
        public ArrayList<MHeader> mHeaders;
        public String mplOrderId;
        public String nonceSubmissionUrl;
        public String paymentMethodToken;
        public String paymentModeFromReact;
        public PaymentResultListener paymentResultListener;
        public String paymentType;
        public String savedCardNonce;
        public String shouldSavePaymentMethod;
        public String verifiedCardNonce;

        public BraintreeCustomPayment createBraintreePayment() throws Exception {
            if (!StringUtils.isNullOrEmpty(this.nonceSubmissionUrl)) {
                String str = this.clientToken;
                if (str == null || str.isEmpty()) {
                    throw new Exception("BraintreeCustomPayment Client token cannot be null");
                } else if (this.callingActivity != null) {
                    String str2 = this.mplOrderId;
                    if (str2 == null || str2.isEmpty()) {
                        throw new Exception("BraintreePayment mplOrderId can't be null");
                    } else if (this.paymentResultListener != null) {
                        String str3 = this.amount;
                        if (str3 == null || str3.isEmpty()) {
                            throw new Exception("BraintreeCustomPayment amount can't be null");
                        } else if (this.paymentType != null) {
                            String str4 = this.localeCode;
                            if (str4 == null || str4.isEmpty()) {
                                throw new Exception("localeCode  can't be null or empty");
                            }
                            String str5 = this.currencyCode;
                            if (str5 == null || str5.isEmpty()) {
                                throw new Exception("currencyCode  can't be null or empty");
                            }
                            String str6 = this.billingAgreementDescription;
                            if (str6 == null || str6.isEmpty()) {
                                throw new Exception("billing agreement can't be null or empty");
                            } else if (this.mHeaders == null) {
                                throw new Exception("BraintreeCustomPayment headers cant be null");
                            } else if (this.authTokenProvider == null) {
                                throw new Exception("authTokenProvider cant be null");
                            } else if (!StringUtils.isNullOrEmpty(this.paymentModeFromReact)) {
                                if (this.paymentType.equalsIgnoreCase("card")) {
                                    if (BaseParser.FALSE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
                                        if (StringUtils.isNullOrEmpty(this.verifiedCardNonce)) {
                                            throw new Exception("VerifiedCardNonce can't be null or empty when paying new cards");
                                        } else if (StringUtils.isNullOrEmpty(this.shouldSavePaymentMethod)) {
                                            throw new Exception("shouldSavePaymentMethod can't be null or empty when paying new cards");
                                        }
                                    } else if (!BaseParser.TRUE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
                                        throw new Exception("isSavedPaymentMethod should either be true or false");
                                    } else if (!BaseParser.FALSE.equalsIgnoreCase(this.is3DsOn) && !BaseParser.TRUE.equalsIgnoreCase(this.is3DsOn)) {
                                        throw new Exception("is3DsOn needs to be either true or false");
                                    } else if (BaseParser.TRUE.equalsIgnoreCase(this.is3DsOn)) {
                                        String str7 = this.savedCardNonce;
                                        if (str7 == null || str7.isEmpty()) {
                                            throw new Exception("savedCardNonce can't be null or empty when 3ds is on");
                                        }
                                        String str8 = this.cardType;
                                        if (str8 == null || str8.isEmpty()) {
                                            throw new Exception("CardType can't be null or empty when 3ds is on");
                                        }
                                    } else {
                                        String str9 = this.paymentMethodToken;
                                        if (str9 == null || str9.isEmpty()) {
                                            throw new Exception("paymentMethodToken can't be null or empty when 3ds is off");
                                        }
                                    }
                                }
                                if (this.paymentType.equalsIgnoreCase("paypal")) {
                                    if (BaseParser.FALSE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
                                        if (StringUtils.isNullOrEmpty(this.shouldSavePaymentMethod) || (!BaseParser.TRUE.equalsIgnoreCase(this.shouldSavePaymentMethod) && !BaseParser.FALSE.equalsIgnoreCase(this.shouldSavePaymentMethod))) {
                                            throw new Exception("shouldSavePayment type can either has to be true or false");
                                        }
                                    } else if (!BaseParser.TRUE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
                                        throw new Exception("isSavedPaymentMethod should either be true or false");
                                    } else if (StringUtils.isNullOrEmpty(this.paymentMethodToken)) {
                                        throw new Exception("BraintreePayment paymentMethod token can't be null or empty");
                                    }
                                }
                                BraintreeCustomPayment braintreeCustomPayment = new BraintreeCustomPayment(this.clientToken, this.callingActivity, this.mplOrderId, this.paymentResultListener, this.shouldSavePaymentMethod, this.amount, this.paymentType, this.isSavedPaymentMethod, this.paymentMethodToken, this.nonceSubmissionUrl, this.savedCardNonce, this.localeCode, this.currencyCode, this.billingAgreementDescription, this.mHeaders, this.is3DsOn, this.paymentModeFromReact, this.authTokenProvider, this.verifiedCardNonce, this.cardType);
                                return braintreeCustomPayment;
                            } else {
                                throw new Exception("BraintreeCustomPayment paymentModeFromReact can't be null or empty");
                            }
                        } else {
                            throw new Exception("BraintreeCustomPayment paymentType can't be null");
                        }
                    } else {
                        throw new Exception("BraintreeCustomPayment paymentResultListener can't be null");
                    }
                } else {
                    throw new Exception("BraintreeCustomPayment calling activity cannot be null and has to be an instance of AppCompatActivity");
                }
            } else {
                throw new Exception("nonceSubmissionUrl can't be null or empty!");
            }
        }

        public BraintreeCustomPaymentBuilder setAmount(String str) {
            this.amount = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setAuthTokenProvider(AuthTokenProvider authTokenProvider2) {
            this.authTokenProvider = authTokenProvider2;
            return this;
        }

        public BraintreeCustomPaymentBuilder setBillingAgreementDescription(String str) {
            this.billingAgreementDescription = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setCallingActivity(Activity activity) {
            if (activity instanceof AppCompatActivity) {
                this.callingActivity = (AppCompatActivity) activity;
            } else {
                this.callingActivity = null;
            }
            return this;
        }

        public BraintreeCustomPaymentBuilder setCardType(String str) {
            this.cardType = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setClientToken(String str) {
            this.clientToken = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setCurrencyCode(String str) {
            this.currencyCode = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setIs3DsOn(String str) {
            this.is3DsOn = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setLocaleCode(String str) {
            this.localeCode = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setMplOrderId(String str) {
            this.mplOrderId = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setNonceSubmissionUrl(String str) {
            this.nonceSubmissionUrl = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setPaymentMethodToken(String str) {
            this.paymentMethodToken = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setPaymentModeFromReact(String str) {
            this.paymentModeFromReact = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setPaymentResultListener(PaymentResultListener paymentResultListener2) {
            this.paymentResultListener = paymentResultListener2;
            return this;
        }

        public BraintreeCustomPaymentBuilder setPaymentType(String str) {
            this.paymentType = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setSavedCardNonce(String str) {
            this.savedCardNonce = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setShouldSavePaymentMethod(String str) {
            this.shouldSavePaymentMethod = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setVerifiedCardNonce(String str) {
            this.verifiedCardNonce = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setiSSavedPaymentMethod(String str) {
            this.isSavedPaymentMethod = str;
            return this;
        }

        public BraintreeCustomPaymentBuilder setmHeaders(ArrayList<MHeader> arrayList) {
            this.mHeaders = arrayList;
            return this;
        }
    }

    public BraintreeCustomPayment(String str, AppCompatActivity appCompatActivity, String str2, PaymentResultListener paymentResultListener2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<MHeader> arrayList, String str13, String str14, AuthTokenProvider authTokenProvider2, String str15, String str16) {
        this.clientToken = str;
        this.callingActivity = appCompatActivity;
        this.mplOrderId = str2;
        this.paymentResultListener = paymentResultListener2;
        this.shouldSavePaymentMethod = str3;
        this.amount = str4;
        this.paymentType = str5;
        this.isSavedPaymentMethod = str6;
        this.paymentMethodToken = str7;
        this.nonceSubmissionUrl = str8;
        this.localeCode = str10;
        this.currencyCode = str11;
        this.billingAgreementDescription = str12;
        this.savedCardNonce = str9;
        this.mHeaders = arrayList;
        this.is3DsOn = str13;
        this.paymentModeFromReact = str14;
        this.authTokenProvider = authTokenProvider2;
        this.verifiedCardNonce = str15;
        this.cardType = str16;
    }

    /* access modifiers changed from: private */
    public void doNonceSubmission(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            String str3 = this.deviceData;
            if (str3 != null && !str3.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BraintreeConstants.NS_MPL_ORDER_ID, this.mplOrderId);
                    jSONObject.put("plugin", "killbill-braintree");
                    jSONObject.put("nonce", str2);
                    jSONObject.put(BraintreeConstants.NS_TOKEN_TYPE, str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(BraintreeConstants.NS_DEVICE_DATA, this.deviceData);
                    if (this.shouldSavePaymentMethod != null) {
                        jSONObject2.put(BraintreeConstants.NS_STORE_IN_VAULT, this.shouldSavePaymentMethod);
                    }
                    jSONObject.put(BraintreeConstants.NS_EXTRAINFO, jSONObject2);
                    MClient.executeAsync(new Builder().setUrl(this.nonceSubmissionUrl).setResponseListener(new IResponseListener<String>() {
                        public void onResponseFail(Exception exc) {
                            BraintreeCustomPayment braintreeCustomPayment = BraintreeCustomPayment.this;
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Nonce submission call failed");
                            outline73.append(exc.getMessage());
                            braintreeCustomPayment.processFailure(outline73.toString());
                        }

                        public void progressResponse(long j, long j2, boolean z) {
                        }

                        public void onResponseSuccess(final String str) {
                            if (BraintreeCustomPayment.this.callingActivity != null) {
                                BraintreeCustomPayment.this.callingActivity.runOnUiThread(new Runnable() {
                                    public void run() {
                                        BraintreeCustomPayment.this.processNonceSubmissionResponse(str);
                                    }
                                });
                            } else {
                                BraintreeCustomPayment.this.processFailure("calling activity is null");
                            }
                        }
                    }).setHeaders((ArrayList) this.mHeaders.clone()).addHeader(this.authTokenProvider.getAuthHeader()).setPostJsonObject(jSONObject.toString()).setRetryOnConnectionFailure(true).build());
                    return;
                } catch (Exception e2) {
                    processExceptionWithFailure(e2, "processActivityResult");
                    return;
                }
            }
        }
        processFailure("Issue with nonce or deviceData!");
    }

    private void doThreeDSecureRequest(String str) {
        ThreeDSecurePostalAddress threeDSecurePostalAddress = new ThreeDSecurePostalAddress();
        ThreeDSecureAdditionalInformation threeDSecureAdditionalInformation = new ThreeDSecureAdditionalInformation();
        threeDSecureAdditionalInformation.mShippingAddress = threeDSecurePostalAddress;
        ThreeDSecureRequest threeDSecureRequest = new ThreeDSecureRequest();
        threeDSecureRequest.mAmount = this.amount;
        threeDSecureRequest.mNonce = str;
        threeDSecureRequest.mVersionRequested = "2";
        threeDSecureRequest.mAdditionalInformation = threeDSecureAdditionalInformation;
        k.performVerification(this.mBraintreeFragment, threeDSecureRequest, new ThreeDSecureLookupListener() {
            public void onLookupComplete(ThreeDSecureRequest threeDSecureRequest, ThreeDSecureLookup threeDSecureLookup) {
                k.continuePerformVerification(BraintreeCustomPayment.this.mBraintreeFragment, threeDSecureRequest, threeDSecureLookup);
            }
        });
    }

    private boolean is3dsAllowed(String str) {
        PaymentConfigProvider paymentConfigProvider = PaymentConfig.INSTANCE.getPaymentConfigProvider();
        boolean z = false;
        if (paymentConfigProvider != null) {
            for (String equalsIgnoreCase : paymentConfigProvider.getAllowedCardTypesForBraintree3ds()) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void makeBraintreePayment() {
        if ("card".equalsIgnoreCase(this.paymentType)) {
            if (BaseParser.FALSE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
                doNonceSubmission(BraintreeConstants.NS_TOKEN_TYPE_NONCE, this.verifiedCardNonce);
            } else if (!BaseParser.TRUE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
            } else {
                if (!BaseParser.TRUE.equalsIgnoreCase(this.is3DsOn)) {
                    doNonceSubmission(BraintreeConstants.NS_TOKEN_TYPE_PAYMENT_METHOD_TOKEN, this.paymentMethodToken);
                } else if (is3dsAllowed(this.cardType)) {
                    doThreeDSecureRequest(this.savedCardNonce);
                } else {
                    doNonceSubmission(BraintreeConstants.NS_TOKEN_TYPE_NONCE, this.savedCardNonce);
                }
            }
        } else if (!"paypal".equalsIgnoreCase(this.paymentType)) {
            processFailure("check payment type in BraintreePayment");
        } else if (BaseParser.FALSE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
            if (BaseParser.FALSE.equalsIgnoreCase(this.shouldSavePaymentMethod)) {
                PayPalRequest payPalRequest = new PayPalRequest(this.amount);
                payPalRequest.mCurrencyCode = this.currencyCode;
                payPalRequest.mIntent = "authorize";
                k.requestOneTimePayment(this.mBraintreeFragment, payPalRequest);
            } else if (BaseParser.TRUE.equalsIgnoreCase(this.shouldSavePaymentMethod)) {
                PayPalRequest payPalRequest2 = new PayPalRequest();
                payPalRequest2.mLocaleCode = this.localeCode;
                payPalRequest2.mBillingAgreementDescription = this.billingAgreementDescription;
                k.requestBillingAgreement(this.mBraintreeFragment, payPalRequest2);
            }
        } else if (BaseParser.TRUE.equalsIgnoreCase(this.isSavedPaymentMethod)) {
            doNonceSubmission(BraintreeConstants.NS_TOKEN_TYPE_PAYMENT_METHOD_TOKEN, this.paymentMethodToken);
        }
    }

    private void processExceptionWithFailure(Exception exc, String str) {
        processFailure("Exception in " + str);
    }

    private void processFailureAfterNonceSubmission(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
            jSONObject.put("orderId", this.mplOrderId);
            if (str == null || str.isEmpty()) {
                jSONObject.put("error", "Failed status in nonce submission");
            } else {
                jSONObject.put("reason", str);
            }
            jSONObject.put("paymentMode", this.paymentModeFromReact);
            this.paymentResultListener.onPaymentFailed(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: private */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processNonceSubmissionResponse(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "payload"
            java.lang.String r1 = "code"
            java.lang.String r2 = "status"
            if (r9 == 0) goto L_0x00eb
            boolean r3 = r9.isEmpty()     // Catch:{ Exception -> 0x00f1 }
            if (r3 != 0) goto L_0x00eb
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x00f1 }
            boolean r9 = r3.has(r2)     // Catch:{ Exception -> 0x00f1 }
            if (r9 == 0) goto L_0x00e5
            org.json.JSONObject r9 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x00f1 }
            boolean r9 = r9.has(r1)     // Catch:{ Exception -> 0x00f1 }
            if (r9 == 0) goto L_0x00e5
            org.json.JSONObject r9 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x00f1 }
            int r9 = r9.optInt(r1)     // Catch:{ Exception -> 0x00f1 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r9 != r1) goto L_0x00df
            boolean r9 = r3.has(r0)     // Catch:{ Exception -> 0x00f1 }
            if (r9 == 0) goto L_0x00d9
            org.json.JSONObject r9 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x00f1 }
            boolean r0 = r9.has(r2)     // Catch:{ Exception -> 0x00f1 }
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = r9.optString(r2)     // Catch:{ Exception -> 0x00f1 }
            r1 = -1
            int r3 = r0.hashCode()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r4 = "SUCCESS"
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -1757359925: goto L_0x006d;
                case -1149187101: goto L_0x0065;
                case 1748463920: goto L_0x005b;
                case 2066319421: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x0076
        L_0x0051:
            java.lang.String r3 = "FAILED"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00f1 }
            if (r0 == 0) goto L_0x0076
            r1 = 3
            goto L_0x0076
        L_0x005b:
            java.lang.String r3 = "UNDEFINED"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00f1 }
            if (r0 == 0) goto L_0x0076
            r1 = 1
            goto L_0x0076
        L_0x0065:
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x00f1 }
            if (r0 == 0) goto L_0x0076
            r1 = 2
            goto L_0x0076
        L_0x006d:
            java.lang.String r3 = "INITIATED"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00f1 }
            if (r0 == 0) goto L_0x0076
            r1 = 0
        L_0x0076:
            java.lang.String r0 = "paymentMode"
            java.lang.String r3 = "orderId"
            if (r1 == 0) goto L_0x00b2
            if (r1 == r7) goto L_0x00b2
            if (r1 == r6) goto L_0x0093
            if (r1 == r5) goto L_0x0089
            java.lang.String r9 = "Unknown status string in nonce submission"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x0089:
            java.lang.String r0 = "reason"
            java.lang.String r9 = r9.optString(r0)     // Catch:{ Exception -> 0x00f1 }
            r8.processFailureAfterNonceSubmission(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x0093:
            r8.removeListenersAndCleanup()     // Catch:{ Exception -> 0x00f1 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            r9.<init>()     // Catch:{ Exception -> 0x00f1 }
            r9.put(r2, r4)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r1 = r8.mplOrderId     // Catch:{ Exception -> 0x00f1 }
            r9.put(r3, r1)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r1 = r8.paymentModeFromReact     // Catch:{ Exception -> 0x00f1 }
            r9.put(r0, r1)     // Catch:{ Exception -> 0x00f1 }
            com.mpl.payment.routing.PaymentResultListener r0 = r8.paymentResultListener     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00f1 }
            r0.onPaymentSuccessful(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x00b2:
            r8.removeListenersAndCleanup()     // Catch:{ Exception -> 0x00f1 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            r9.<init>()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r1 = "PENDING_POLLING"
            r9.put(r2, r1)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r1 = r8.mplOrderId     // Catch:{ Exception -> 0x00f1 }
            r9.put(r3, r1)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r1 = r8.paymentModeFromReact     // Catch:{ Exception -> 0x00f1 }
            r9.put(r0, r1)     // Catch:{ Exception -> 0x00f1 }
            com.mpl.payment.routing.PaymentResultListener r0 = r8.paymentResultListener     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00f1 }
            r0.onPaymentSuccessful(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x00d3:
            java.lang.String r9 = "No status key found in nonce submission payload!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x00d9:
            java.lang.String r9 = "No payload key found in nonce submission response!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x00df:
            java.lang.String r9 = "Nonce submission response does not have 200 status code!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x00e5:
            java.lang.String r9 = "Check status json object in nonce submission response!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x00eb:
            java.lang.String r9 = "non submission response is either null or empty"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00f7
        L_0x00f1:
            r9 = move-exception
            java.lang.String r0 = "processNonceSubmissionResponse"
            r8.processExceptionWithFailure(r9, r0)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.braintree.BraintreeCustomPayment.processNonceSubmissionResponse(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        r4.mBraintreeFragment = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:12:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeListenersAndCleanup() {
        /*
            r4 = this;
            com.braintreepayments.api.BraintreeFragment r0 = r4.mBraintreeFragment
            if (r0 == 0) goto L_0x0073
            java.util.List r0 = r0.getListeners()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()
            com.braintreepayments.api.interfaces.BraintreeListener r1 = (com.braintreepayments.api.interfaces.BraintreeListener) r1
            com.braintreepayments.api.BraintreeFragment r2 = r4.mBraintreeFragment
            r2.removeListener(r1)
            goto L_0x000e
        L_0x0020:
            com.braintreepayments.api.BraintreeFragment r0 = r4.mBraintreeFragment
            java.lang.String r0 = r0.getTag()
            androidx.appcompat.app.AppCompatActivity r1 = r4.callingActivity
            androidx.fragment.app.FragmentManager r1 = r1.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0073
            if (r1 == 0) goto L_0x0073
            androidx.fragment.app.Fragment r0 = r1.findFragmentByTag(r0)
            if (r0 == 0) goto L_0x0073
            r0 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            r3 = 24
            if (r2 < r3) goto L_0x005c
            androidx.fragment.app.FragmentTransaction r2 = r1.beginTransaction()     // Catch:{ IllegalStateException | NullPointerException -> 0x004b, all -> 0x006d }
            com.braintreepayments.api.BraintreeFragment r3 = r4.mBraintreeFragment     // Catch:{ IllegalStateException | NullPointerException -> 0x004b, all -> 0x006d }
            androidx.fragment.app.FragmentTransaction r2 = r2.remove(r3)     // Catch:{ IllegalStateException | NullPointerException -> 0x004b, all -> 0x006d }
            r2.commitNowAllowingStateLoss()     // Catch:{ IllegalStateException | NullPointerException -> 0x004b, all -> 0x006d }
            goto L_0x0071
        L_0x004b:
            androidx.fragment.app.FragmentTransaction r2 = r1.beginTransaction()     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            com.braintreepayments.api.BraintreeFragment r3 = r4.mBraintreeFragment     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            androidx.fragment.app.FragmentTransaction r2 = r2.remove(r3)     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            r2.commitAllowingStateLoss()     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            r1.executePendingTransactions()     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            goto L_0x0071
        L_0x005c:
            androidx.fragment.app.FragmentTransaction r2 = r1.beginTransaction()     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            com.braintreepayments.api.BraintreeFragment r3 = r4.mBraintreeFragment     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            androidx.fragment.app.FragmentTransaction r2 = r2.remove(r3)     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            r2.commitAllowingStateLoss()     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            r1.executePendingTransactions()     // Catch:{ IllegalStateException -> 0x0071, all -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r1 = move-exception
            r4.mBraintreeFragment = r0
            throw r1
        L_0x0071:
            r4.mBraintreeFragment = r0
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.braintree.BraintreeCustomPayment.removeListenersAndCleanup():void");
    }

    public void initBraintreePayment() {
        try {
            BraintreeFragment newInstance = BraintreeFragment.newInstance(this.callingActivity, this.clientToken);
            this.mBraintreeFragment = newInstance;
            newInstance.addListener(this.paymentMethodNonceCreatedListener);
            this.mBraintreeFragment.addListener(this.braintreeErrorListener);
            this.mBraintreeFragment.addListener(this.braintreeCancelListener);
            System.currentTimeMillis();
            BraintreeFragment braintreeFragment = this.mBraintreeFragment;
            DataCollector$1 dataCollector$1 = new DataCollector$1(braintreeFragment, null, new BraintreeResponseListener<String>() {
                public void onResponse(String str) {
                    System.currentTimeMillis();
                    BraintreeCustomPayment braintreeCustomPayment = BraintreeCustomPayment.this;
                    braintreeCustomPayment.deviceData = str;
                    braintreeCustomPayment.makeBraintreePayment();
                }
            });
            braintreeFragment.fetchConfiguration();
            braintreeFragment.postOrQueueCallback(new QueuedCallback(dataCollector$1) {
                public void run() {
                    r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
                }

                public boolean shouldRun() {
                    BraintreeFragment braintreeFragment = BraintreeFragment.this;
                    return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
                }
            });
        } catch (InvalidArgumentException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Argument Exception in initBraintreePayment");
            sb.append(e2);
            processFailure((sb.toString() == null || e2.getMessage() == null) ? "" : e2.getMessage());
        }
    }

    public void processFailure(String str) {
        removeListenersAndCleanup();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
            jSONObject.put("orderId", this.mplOrderId);
            jSONObject.put("error", str);
            jSONObject.put("paymentMode", this.paymentModeFromReact);
            this.paymentResultListener.onPaymentFailed(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public void processUserCancellation(String str) {
        removeListenersAndCleanup();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", "USER_CANCELED");
            jSONObject.put("orderId", this.mplOrderId);
            jSONObject.put("error", str);
            jSONObject.put("paymentMode", this.paymentModeFromReact);
            this.paymentResultListener.onPaymentFailed(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
