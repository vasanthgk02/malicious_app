package com.mpl.payment.braintree;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInRequest;
import com.braintreepayments.api.dropin.DropInResult;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.PayPalRequest;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.mpl.payment.routing.PaymentResultListener;
import com.mpl.payment.routing.RoutingConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

public class BraintreePayment {
    public static final String BT_PAYMENT_TYPE_CARD = "card";
    public static final String BT_PAYMENT_TYPE_PAYPAL = "paypal";
    public static final String TAG = "BraintreePayment";
    public String amount;
    public AuthTokenProvider authTokenProvider;
    public ArrayList<String> availablePaymentModes;
    public String billingAgreementDescription;
    public Activity callingActivity;
    public String clientToken;
    public String currencyCode;
    public String localeCode;
    public ArrayList<MHeader> mHeaders = new ArrayList<>();
    public String mplOrderId;
    public PaymentResultListener paymentResultListener;
    public int requestCode;
    public String shouldSavePaymentMethod;

    public static class BraintreePaymentBuilder {
        public String amount;
        public AuthTokenProvider authTokenProvider;
        public ArrayList<String> availablePaymentModes;
        public String billingAgreementDescription;
        public Activity callingActivity;
        public String clientToken;
        public String currencyCode;
        public String localeCode;
        public ArrayList<MHeader> mHeaders;
        public String mplOrderId;
        public PaymentResultListener paymentResultListener;
        public int requestCode;
        public String shouldSavePaymentMethod;

        public BraintreePayment createBraintreePayment() throws Exception {
            String str = this.clientToken;
            if (str == null || str.isEmpty()) {
                throw new Exception("BraintreePayment Client token cannot be null");
            } else if (this.callingActivity == null) {
                throw new Exception("BraintreePayment calling activity cannot be null");
            } else if (this.requestCode != 0) {
                String str2 = this.mplOrderId;
                if (str2 == null || str2.isEmpty()) {
                    throw new Exception("BraintreePayment mplOrderId can't be null");
                } else if (this.paymentResultListener != null) {
                    String str3 = this.shouldSavePaymentMethod;
                    if (str3 == null || str3.isEmpty()) {
                        throw new Exception("BraintreePayment shouldSavePaymentMethod can't be null");
                    }
                    String str4 = this.amount;
                    if (str4 == null || str4.isEmpty()) {
                        throw new Exception("BraintreePayment amount can't be null");
                    }
                    String str5 = this.localeCode;
                    if (str5 == null || str5.isEmpty()) {
                        throw new Exception("localeCode  can't be null or empty");
                    }
                    String str6 = this.currencyCode;
                    if (str6 == null || str6.isEmpty()) {
                        throw new Exception("currencyCode  can't be null or empty");
                    }
                    String str7 = this.billingAgreementDescription;
                    if (str7 == null || str7.isEmpty()) {
                        throw new Exception("billing agreement can't be null or empty");
                    }
                    ArrayList<String> arrayList = this.availablePaymentModes;
                    if (arrayList == null || arrayList.isEmpty()) {
                        throw new Exception("BraintreePayment availablePaymentModes arrayList can't be null or can't have 0 elements check fetchpaymentMethods");
                    }
                    ArrayList<MHeader> arrayList2 = this.mHeaders;
                    if (arrayList2 != null) {
                        AuthTokenProvider authTokenProvider2 = this.authTokenProvider;
                        if (authTokenProvider2 != null) {
                            BraintreePayment braintreePayment = new BraintreePayment(this.clientToken, this.callingActivity, this.requestCode, this.mplOrderId, this.paymentResultListener, this.shouldSavePaymentMethod, this.amount, this.availablePaymentModes, this.localeCode, this.currencyCode, this.billingAgreementDescription, arrayList2, authTokenProvider2);
                            return braintreePayment;
                        }
                        throw new Exception("authTokenProvider cant be null");
                    }
                    throw new Exception("BraintreePayment headers cant be null");
                } else {
                    throw new Exception("BraintreePayment paymentResultListener can't be null");
                }
            } else {
                throw new Exception("Braintree Client request code not set");
            }
        }

        public BraintreePaymentBuilder setAmount(String str) {
            this.amount = str;
            return this;
        }

        public BraintreePaymentBuilder setAuthTokenProvider(AuthTokenProvider authTokenProvider2) {
            this.authTokenProvider = authTokenProvider2;
            return this;
        }

        public BraintreePaymentBuilder setAvailablePaymentModes(ArrayList<String> arrayList) {
            this.availablePaymentModes = arrayList;
            return this;
        }

        public BraintreePaymentBuilder setBillingAgreementDescription(String str) {
            this.billingAgreementDescription = str;
            return this;
        }

        public BraintreePaymentBuilder setCallingActivity(Activity activity) {
            this.callingActivity = activity;
            return this;
        }

        public BraintreePaymentBuilder setClientToken(String str) {
            this.clientToken = str;
            return this;
        }

        public BraintreePaymentBuilder setCurrencyCode(String str) {
            this.currencyCode = str;
            return this;
        }

        public BraintreePaymentBuilder setLocaleCode(String str) {
            this.localeCode = str;
            return this;
        }

        public BraintreePaymentBuilder setMplOrderId(String str) {
            this.mplOrderId = str;
            return this;
        }

        public BraintreePaymentBuilder setPaymentResultListener(PaymentResultListener paymentResultListener2) {
            this.paymentResultListener = paymentResultListener2;
            return this;
        }

        public BraintreePaymentBuilder setRequestCode(int i) {
            this.requestCode = i;
            return this;
        }

        public BraintreePaymentBuilder setShouldSavePaymentMethod(String str) {
            this.shouldSavePaymentMethod = str;
            return this;
        }

        public BraintreePaymentBuilder setmHeaders(ArrayList<MHeader> arrayList) {
            this.mHeaders = arrayList;
            return this;
        }
    }

    public BraintreePayment(String str, Activity activity, int i, String str2, PaymentResultListener paymentResultListener2, String str3, String str4, ArrayList<String> arrayList, String str5, String str6, String str7, ArrayList<MHeader> arrayList2, AuthTokenProvider authTokenProvider2) {
        this.clientToken = str;
        this.callingActivity = activity;
        this.requestCode = i;
        this.mplOrderId = str2;
        this.paymentResultListener = paymentResultListener2;
        this.shouldSavePaymentMethod = str3;
        this.amount = str4;
        this.availablePaymentModes = arrayList;
        this.localeCode = str5;
        this.currencyCode = str6;
        this.billingAgreementDescription = str7;
        this.mHeaders = arrayList2;
        this.authTokenProvider = authTokenProvider2;
    }

    private boolean isPaymentModeAvailable(String str) {
        Iterator<String> it = this.availablePaymentModes.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void processExceptionWithFailure(Exception exc, String str) {
        String message = (exc == null || exc.getMessage() == null) ? "Error getting exception message" : exc.getMessage();
        processFailure("Exception in " + str + " Message is-->" + message);
    }

    private void processFailureAfterNonceSubmission(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
            jSONObject.put("orderId", this.mplOrderId);
            if (str == null || str.isEmpty()) {
                jSONObject.put("error", "Failed status in nonce submission");
            } else {
                jSONObject.put("reason", str);
            }
            jSONObject.put("paymentMode", str2);
            this.paymentResultListener.onPaymentFailed(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: private */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processNonceSubmissionResponse(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "payload"
            java.lang.String r1 = "code"
            java.lang.String r2 = "status"
            if (r9 == 0) goto L_0x00e0
            boolean r3 = r9.isEmpty()     // Catch:{ Exception -> 0x00e6 }
            if (r3 != 0) goto L_0x00e0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e6 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x00e6 }
            boolean r9 = r3.has(r2)     // Catch:{ Exception -> 0x00e6 }
            if (r9 == 0) goto L_0x00da
            org.json.JSONObject r9 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x00e6 }
            boolean r9 = r9.has(r1)     // Catch:{ Exception -> 0x00e6 }
            if (r9 == 0) goto L_0x00da
            org.json.JSONObject r9 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x00e6 }
            int r9 = r9.optInt(r1)     // Catch:{ Exception -> 0x00e6 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r9 != r1) goto L_0x00d4
            boolean r9 = r3.has(r0)     // Catch:{ Exception -> 0x00e6 }
            if (r9 == 0) goto L_0x00ce
            org.json.JSONObject r9 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x00e6 }
            boolean r0 = r9.has(r2)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = r9.optString(r2)     // Catch:{ Exception -> 0x00e6 }
            r1 = -1
            int r3 = r0.hashCode()     // Catch:{ Exception -> 0x00e6 }
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
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x0076
            r1 = 3
            goto L_0x0076
        L_0x005b:
            java.lang.String r3 = "UNDEFINED"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x0076
            r1 = 1
            goto L_0x0076
        L_0x0065:
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x0076
            r1 = 2
            goto L_0x0076
        L_0x006d:
            java.lang.String r3 = "INITIATED"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x0076
            r1 = 0
        L_0x0076:
            java.lang.String r0 = "paymentMode"
            java.lang.String r3 = "orderId"
            if (r1 == 0) goto L_0x00ac
            if (r1 == r7) goto L_0x00ac
            if (r1 == r6) goto L_0x0092
            if (r1 == r5) goto L_0x0088
            java.lang.String r9 = "Unknown status string in nonce submission"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x0088:
            java.lang.String r0 = "reason"
            java.lang.String r9 = r9.optString(r0)     // Catch:{ Exception -> 0x00e6 }
            r8.processFailureAfterNonceSubmission(r9, r10)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x0092:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e6 }
            r9.<init>()     // Catch:{ Exception -> 0x00e6 }
            r9.put(r2, r4)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r1 = r8.mplOrderId     // Catch:{ Exception -> 0x00e6 }
            r9.put(r3, r1)     // Catch:{ Exception -> 0x00e6 }
            r9.put(r0, r10)     // Catch:{ Exception -> 0x00e6 }
            com.mpl.payment.routing.PaymentResultListener r10 = r8.paymentResultListener     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00e6 }
            r10.onPaymentSuccessful(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x00ac:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e6 }
            r9.<init>()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r1 = "PENDING_POLLING"
            r9.put(r2, r1)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r1 = r8.mplOrderId     // Catch:{ Exception -> 0x00e6 }
            r9.put(r3, r1)     // Catch:{ Exception -> 0x00e6 }
            r9.put(r0, r10)     // Catch:{ Exception -> 0x00e6 }
            com.mpl.payment.routing.PaymentResultListener r10 = r8.paymentResultListener     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00e6 }
            r10.onPaymentSuccessful(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x00c8:
            java.lang.String r9 = "No status key found in nonce submission payload!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x00ce:
            java.lang.String r9 = "No payload key found in nonce submission response!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x00d4:
            java.lang.String r9 = "Nonce submission response does not have 200 status code!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x00da:
            java.lang.String r9 = "Check status json object in nonce submission response!"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x00e0:
            java.lang.String r9 = "non submission response is either null or empty"
            r8.processFailure(r9)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x00e6:
            r9 = move-exception
            java.lang.String r10 = "processNonceSubmissionResponse"
            r8.processExceptionWithFailure(r9, r10)
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.braintree.BraintreePayment.processNonceSubmissionResponse(java.lang.String, java.lang.String):void");
    }

    public void makeBraintreePaymentDropin() {
        DropInRequest dropInRequest = new DropInRequest();
        dropInRequest.mAuthorization = this.clientToken;
        dropInRequest.mGooglePaymentEnabled = false;
        dropInRequest.mVenmoEnabled = false;
        dropInRequest.mCollectDeviceData = true;
        dropInRequest.mVaultManagerEnabled = true;
        if (!isPaymentModeAvailable(RoutingConstants.PAYMENT_MODE_PAYPAL)) {
            dropInRequest.mPayPalEnabled = false;
        } else if (BaseParser.TRUE.equalsIgnoreCase(this.shouldSavePaymentMethod)) {
            PayPalRequest payPalRequest = new PayPalRequest();
            payPalRequest.mLocaleCode = this.localeCode;
            payPalRequest.mBillingAgreementDescription = this.billingAgreementDescription;
            dropInRequest.mPayPalRequest = payPalRequest;
        } else if (BaseParser.FALSE.equalsIgnoreCase(this.shouldSavePaymentMethod)) {
            PayPalRequest payPalRequest2 = new PayPalRequest(this.amount);
            payPalRequest2.mCurrencyCode = this.currencyCode;
            payPalRequest2.mIntent = "sale";
            dropInRequest.mPayPalRequest = payPalRequest2;
        } else {
            processFailure("shouldSavePaymentMethod can either be true or false");
            return;
        }
        if (!isPaymentModeAvailable("CARD")) {
            dropInRequest.mCardEnabled = false;
        } else if (BaseParser.TRUE.equalsIgnoreCase(this.shouldSavePaymentMethod)) {
            dropInRequest.mDefaultVaultValue = true;
        } else {
            dropInRequest.mDefaultVaultValue = false;
        }
        Activity activity = this.callingActivity;
        activity.startActivityForResult(new Intent(activity.getBaseContext(), DropInActivity.class).putExtra("com.braintreepayments.api.EXTRA_CHECKOUT_REQUEST", dropInRequest), this.requestCode);
    }

    public void processActivityResult(int i, int i2, Intent intent, String str) {
        String str2;
        String str3;
        String str4;
        if (i2 == -1) {
            DropInResult dropInResult = (DropInResult) intent.getParcelableExtra("com.braintreepayments.api.dropin.EXTRA_DROP_IN_RESULT");
            String str5 = dropInResult.mPaymentMethodNonce.mNonce;
            String str6 = dropInResult.mDeviceData;
            PaymentMethodType paymentMethodType = dropInResult.mPaymentMethodType;
            final String str7 = paymentMethodType != null ? paymentMethodType.name().toString() : Constants.DOWNLOAD_STATUS_UNKNOWN;
            if (str5 != null && !str5.isEmpty() && str6 != null && !str6.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BraintreeConstants.NS_MPL_ORDER_ID, this.mplOrderId);
                    jSONObject.put("plugin", "killbill-braintree");
                    jSONObject.put("nonce", str5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(BraintreeConstants.NS_DEVICE_DATA, str6);
                    jSONObject2.put(BraintreeConstants.NS_STORE_IN_VAULT, this.shouldSavePaymentMethod);
                    if (dropInResult.mPaymentMethodNonce instanceof CardNonce) {
                        CardNonce cardNonce = (CardNonce) dropInResult.mPaymentMethodNonce;
                        String str8 = "";
                        if (!(cardNonce.mBinData == null || cardNonce.mBinData.mCountryOfIssuance == null || cardNonce.mBinData.mCountryOfIssuance.isEmpty())) {
                            str8 = cardNonce.mBinData.mCountryOfIssuance;
                        }
                        jSONObject2.put(BraintreeConstants.NS_COUNTRY_OF_ISSUANCE, str8);
                    }
                    jSONObject.put(BraintreeConstants.NS_EXTRAINFO, jSONObject2);
                    MClient.executeAsync(new Builder().setUrl(str).setResponseListener(new IResponseListener<String>() {
                        public void onResponseFail(Exception exc) {
                            String message = (exc == null || TextUtils.isEmpty(exc.getMessage())) ? "Exception in onResponseFail" : exc.getMessage();
                            PaymentResultListener access$200 = BraintreePayment.this.paymentResultListener;
                            access$200.onMoneyInFailed("BraintreePayment failure --->" + message);
                        }

                        public void progressResponse(long j, long j2, boolean z) {
                        }

                        public void onResponseSuccess(final String str) {
                            if (BraintreePayment.this.callingActivity != null) {
                                BraintreePayment.this.callingActivity.runOnUiThread(new Runnable() {
                                    public void run() {
                                        AnonymousClass1 r0 = AnonymousClass1.this;
                                        BraintreePayment.this.processNonceSubmissionResponse(str, str7);
                                    }
                                });
                            } else {
                                BraintreePayment.this.paymentResultListener.onPaymentFailed(new Exception("Calling activity is null"));
                            }
                        }
                    }).setHeaders((ArrayList) this.mHeaders.clone()).addHeader(this.authTokenProvider.getAuthHeader()).setPostJsonObject(jSONObject.toString()).setRetryOnConnectionFailure(true).build());
                } catch (Exception e2) {
                    processExceptionWithFailure(e2, "processActivityResult");
                }
            }
        } else if (i2 == 0) {
            processUserCancellation("User canceled payment");
        } else {
            Exception exc = (Exception) intent.getSerializableExtra("com.braintreepayments.api.dropin.EXTRA_ERROR");
            if (exc != null) {
                StringBuilder sb = new StringBuilder(CMap.SPACE);
                if (GeneratedOutlineSupport.outline39(exc, GeneratedOutlineSupport.outline73("Message is---> ")) != null) {
                    str2 = exc.getMessage() + " <---> ";
                } else {
                    str2 = "message was null <--->";
                }
                sb.append(str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Localized Message is---> ");
                if (GeneratedOutlineSupport.outline38(exc, sb2) != null) {
                    str3 = exc.getLocalizedMessage() + " <---> ";
                } else {
                    str3 = "Localised message was null <--->";
                }
                sb.append(str3);
                if (("Exception To string is---> " + exc.toString()) != null) {
                    str4 = exc.toString() + " <---> ";
                } else {
                    str4 = "Exception to string was null <--->";
                }
                sb.append(str4);
                sb.append("Result code is: " + i2 + " <--------> ");
                sb.append("Request code is: " + i + "<-------->");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("sdk when creating nonce!");
                sb3.append(sb.toString());
                processExceptionWithFailure(exc, sb3.toString());
                return;
            }
            processExceptionWithFailure(exc, GeneratedOutlineSupport.outline41("sdk when creating nonce! exception was null Result code is: ", i2));
        }
    }

    public void processFailure(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
            jSONObject.put("orderId", this.mplOrderId);
            jSONObject.put("error", str);
            this.paymentResultListener.onPaymentFailed(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public void processUserCancellation(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", "USER_CANCELED");
            jSONObject.put("orderId", this.mplOrderId);
            jSONObject.put("error", str);
            this.paymentResultListener.onPaymentFailed(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }
}
