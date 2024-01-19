package com.mpl.payment.routing;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOkHttpGetRequest;
import com.mpl.network.modules.request.RequestPriority;
import com.mpl.payment.braintree.BraintreeConstants;
import com.mpl.payment.braintree.BraintreePayment;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.gopay.GoPayPaymentProcessor;
import com.mpl.payment.gopay.GoPayTransactionParamsCreator;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.mpl.payment.gopay.models.GoPayTransactionParams;
import com.mpl.payment.juspayhypersdk.JuspayHyperPaymentsBuilder;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.payment.phonepe.PhonePePayment;
import com.mpl.payment.razorpay.RazorPayGpayUpiActivity;
import com.mpl.payment.razorpay.RazorpayConstants;
import com.mpl.payment.tpsl.TpslPayments;
import com.mpl.payment.tpsl.TpslPayments.TpslPaymentsBuilder;
import com.mpl.payment.tpsl.TpslPaymentsListener;
import com.mpl.payment.upoint.UpointPayment;
import com.mpl.payment.upoint.UpointPaymentBuilder;
import com.mpl.payment.upoint.UpointResultListener;
import com.mpl.payment.utils.StringUtils;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import java.util.ArrayList;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentRouter {
    public static final String TAG = "PaymentRouter";
    public Activity activity;
    public AuthTokenProvider authTokenProvider;
    public int brainTreeRequestCode;
    public String braintreeNonceSubmitUrl;
    public FetchCustomerIdUseCase fetchCustomerIdUseCase;
    public boolean isCashApp = true;
    public boolean isSandboxMoneyInEnabled = false;
    public BraintreePayment mBraintreePayment;
    public ArrayList<MHeader> mHeaders = new ArrayList<>();
    public String mMobileNumber = "";
    public String mMplTransactionId;
    public TpslPayments mTpslPayments;
    public Moshi moshi = new Builder().build();
    public PaymentResultListener paymentResultListener;
    public PhonePePayment phonePePayment;
    public int phonePeRequestCode;
    public int razorpayRequestCode;
    public String tpslRTSUrl;
    public int tpslRequestCode;

    /* renamed from: com.mpl.payment.routing.PaymentRouter$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0032 */
        static {
            /*
                com.mpl.payment.routing.PaymentRouter$PaymentFlow[] r0 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow = r0
                r1 = 1
                com.mpl.payment.routing.PaymentRouter$PaymentFlow r2 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.PHONEPE_DIRECT_DEBIT     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.mpl.payment.routing.PaymentRouter$PaymentFlow r3 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.PAYTM_WALLET_JUSPAY     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mpl.payment.routing.PaymentRouter$PaymentFlow r3 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.AMAZON_TOKENIZE_WALLET_JUSPAY     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.mpl.payment.routing.PaymentRouter$PaymentFlow r3 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.LAZYPAY_WALLET_JUSPAY     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow     // Catch:{ NoSuchFieldError -> 0x002b }
                com.mpl.payment.routing.PaymentRouter$PaymentFlow r3 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.CARDS_JUSPAY     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.mpl.payment.routing.PaymentRouter$PaymentFlow r3 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.CARDS_TPSL     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r1 = $SwitchMap$com$mpl$payment$routing$PaymentRouter$PaymentFlow     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.mpl.payment.routing.PaymentRouter$PaymentFlow r2 = com.mpl.payment.routing.PaymentRouter.PaymentFlow.GOPAY_WALLET     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 7
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.routing.PaymentRouter.AnonymousClass6.<clinit>():void");
        }
    }

    public enum PaymentFlow {
        PHONEPE_DIRECT_DEBIT,
        PAYTM_WALLET_JUSPAY,
        AMAZON_TOKENIZE_WALLET_JUSPAY,
        LAZYPAY_WALLET_JUSPAY,
        CARDS_JUSPAY,
        CARDS_TPSL,
        GOPAY_WALLET,
        UNDEFINED
    }

    public static class PaymentRouterBuilder {
        public PaymentRouter paymentRouter = new PaymentRouter();

        public PaymentRouterBuilder addHeader(MHeader mHeader) {
            if (this.paymentRouter.mHeaders == null) {
                this.paymentRouter.mHeaders = new ArrayList();
            }
            this.paymentRouter.mHeaders.add(mHeader);
            return this;
        }

        public PaymentRouter build() throws Exception {
            if (this.paymentRouter.activity == null) {
                throw new Exception("Activity cant be null!");
            } else if (this.paymentRouter.razorpayRequestCode == 0) {
                throw new Exception("razorpay request code not set!");
            } else if (this.paymentRouter.tpslRequestCode == 0) {
                throw new Exception("tpsl request code not set!");
            } else if (this.paymentRouter.brainTreeRequestCode == 0) {
                throw new Exception("BrainTree request code not set!");
            } else if (this.paymentRouter.paymentResultListener == null) {
                throw new Exception("paymentResultListener cant be null!");
            } else if (this.paymentRouter.authTokenProvider == null) {
                throw new Exception("authtokenprovider cant be null!");
            } else if (this.paymentRouter.fetchCustomerIdUseCase != null) {
                return this.paymentRouter;
            } else {
                throw new Exception("fetchCustomerIdUseCase cant be null!");
            }
        }

        public PaymentRouterBuilder isCashApp(Boolean bool) {
            this.paymentRouter.isCashApp = bool.booleanValue();
            return this;
        }

        public PaymentRouterBuilder setActivity(Activity activity) {
            this.paymentRouter.activity = activity;
            return this;
        }

        public PaymentRouterBuilder setAuthTokenProvider(AuthTokenProvider authTokenProvider) {
            this.paymentRouter.authTokenProvider = authTokenProvider;
            return this;
        }

        public PaymentRouterBuilder setBraintreeRequestCode(int i) {
            this.paymentRouter.brainTreeRequestCode = i;
            return this;
        }

        public PaymentRouterBuilder setFetchCustomerIdUseCase(FetchCustomerIdUseCase fetchCustomerIdUseCase) {
            this.paymentRouter.fetchCustomerIdUseCase = fetchCustomerIdUseCase;
            return this;
        }

        public PaymentRouterBuilder setHeaders(ArrayList<MHeader> arrayList) {
            if (this.paymentRouter.mHeaders == null) {
                this.paymentRouter.mHeaders = new ArrayList();
            }
            this.paymentRouter.mHeaders.addAll(arrayList);
            return this;
        }

        public PaymentRouterBuilder setPaymentResultListener(PaymentResultListener paymentResultListener) {
            this.paymentRouter.paymentResultListener = paymentResultListener;
            return this;
        }

        public PaymentRouterBuilder setRazorpayRequestCode(int i) {
            this.paymentRouter.razorpayRequestCode = i;
            return this;
        }

        public PaymentRouterBuilder setTpslRequestCode(int i) {
            this.paymentRouter.tpslRequestCode = i;
            return this;
        }

        public PaymentRouterBuilder addHeader(String str, String str2) {
            if (this.paymentRouter.mHeaders == null) {
                this.paymentRouter.mHeaders = new ArrayList();
            }
            this.paymentRouter.mHeaders.add(new MHeader(str, str2));
            return this;
        }
    }

    private void callMoneyInV2(String str, final JSONObject jSONObject, JSONObject jSONObject2) {
        MClient.executeAsync(new MOKHttpPostRequest.Builder().setUrl(str).setResponseListener(new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                PaymentRouter.this.paymentResultListener.onMoneyInFailed((exc == null || TextUtils.isEmpty(exc.getMessage())) ? "Exception in onResponseFail" : exc.getMessage());
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                if (str != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            JSONObject optJSONObject = jSONObject.optJSONObject("status");
                            if (optJSONObject != null) {
                                if (optJSONObject.optInt("code") == 200 && jSONObject.optJSONObject("payload") != null) {
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("payload");
                                    String optString = optJSONObject2.optString("plugin", "");
                                    final JSONObject optJSONObject3 = optJSONObject2.optJSONObject(RoutingConstants.MI_RESPONSE_MONEY_IN_PAYLOAD);
                                    if (TextUtils.isEmpty(optString) || optJSONObject3 == null || TextUtils.isEmpty(optJSONObject3.toString())) {
                                        PaymentResultListener access$000 = PaymentRouter.this.paymentResultListener;
                                        access$000.onMoneyInFailed(" plugin key not found" + str);
                                        return;
                                    } else if (PaymentRouter.this.activity == null || PaymentRouter.this.activity.isFinishing()) {
                                        PaymentRouter.this.paymentResultListener.onMoneyInFailed("Activity was finishing");
                                        return;
                                    } else {
                                        char c2 = 65535;
                                        switch (optString.hashCode()) {
                                            case -2027095838:
                                                if (optString.equals(RoutingConstants.MI_PLUGIN_VALUE_PHONEPE)) {
                                                    c2 = 5;
                                                    break;
                                                }
                                                break;
                                            case -1435499128:
                                                if (optString.equals(RoutingConstants.MI_PLUGIN_VALUE_JUSPAY)) {
                                                    c2 = 1;
                                                    break;
                                                }
                                                break;
                                            case -1125321565:
                                                if (optString.equals(RoutingConstants.MI_PLUGIN_VALUE_UPOINT)) {
                                                    c2 = 3;
                                                    break;
                                                }
                                                break;
                                            case -142802174:
                                                if (optString.equals(RoutingConstants.MI_PLUGIN_VALUE_RAZORPAY)) {
                                                    c2 = 2;
                                                    break;
                                                }
                                                break;
                                            case 566396477:
                                                if (optString.equals(RoutingConstants.MI_PLUGIN_VALUE_TPSL)) {
                                                    c2 = 0;
                                                    break;
                                                }
                                                break;
                                            case 1692482604:
                                                if (optString.equals("killbill-braintree")) {
                                                    c2 = 4;
                                                    break;
                                                }
                                                break;
                                        }
                                        if (c2 == 0) {
                                            PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                                    PaymentRouter.this.processTPSL(optJSONObject3, jSONObject);
                                                }
                                            });
                                            return;
                                        } else if (c2 == 1) {
                                            PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                                    PaymentRouter.this.makeJuspayPayment(optJSONObject3, jSONObject);
                                                }
                                            });
                                            return;
                                        } else if (c2 != 2) {
                                            if (c2 != 3) {
                                                if (c2 != 4) {
                                                    if (c2 != 5) {
                                                        PaymentRouter.this.paymentResultListener.onMoneyInFailed("unknown plugin value in Money in response");
                                                        return;
                                                    } else if (PaymentRouter.this.activity != null) {
                                                        PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                                                            public void run() {
                                                                AnonymousClass2 r0 = AnonymousClass2.this;
                                                                PaymentRouter.this.processPhonePePayment(optJSONObject3, jSONObject);
                                                            }
                                                        });
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (PaymentRouter.this.activity != null) {
                                                    PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                                                        public void run() {
                                                            AnonymousClass2 r0 = AnonymousClass2.this;
                                                            PaymentRouter.this.processBrainTreePayment(optJSONObject3, jSONObject);
                                                        }
                                                    });
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (PaymentRouter.this.activity != null) {
                                                PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                                                    public void run() {
                                                        AnonymousClass2 r0 = AnonymousClass2.this;
                                                        PaymentRouter.this.makeUpointPayment(optJSONObject3, jSONObject);
                                                    }
                                                });
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (PaymentRouter.this.activity != null) {
                                            PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                                    PaymentRouter.this.makeRazorpayPayment(optJSONObject3, jSONObject);
                                                }
                                            });
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                            if (optJSONObject == null || optJSONObject.optInt("code") != 5000) {
                                PaymentResultListener access$0002 = PaymentRouter.this.paymentResultListener;
                                access$0002.onMoneyInFailed("status key issue " + str);
                                return;
                            }
                            PaymentRouter.this.paymentResultListener.onMoneyInVpnDetected(str);
                            return;
                        }
                    } catch (Exception e2) {
                        PaymentRouter.this.paymentResultListener.onMoneyInFailed(!TextUtils.isEmpty(e2.getMessage()) ? e2.getMessage() : "Exception in onResponseFail");
                        return;
                    }
                }
                PaymentRouter.this.paymentResultListener.onMoneyInFailed("post response is null or empty");
            }
        }).setHeaders((ArrayList) this.mHeaders.clone()).addHeader(this.authTokenProvider.getAuthHeader()).setPostJsonObject(jSONObject2.toString()).build());
    }

    private void callSaveDepositDetails(String str, final JSONObject jSONObject, JSONObject jSONObject2) {
        MClient.executeAsync(new MOKHttpPostRequest.Builder().setUrl(str).setHeaders((ArrayList) this.mHeaders.clone()).addHeader(this.authTokenProvider.getAuthHeader()).setPostJsonObject(jSONObject2.toString()).setResponseListener(new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                PaymentRouter.this.paymentResultListener.onMoneyInFailed(StringUtils.getMessageFromException(exc, "exception in callSaveDepositDetails"));
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                if (str != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            JSONObject optJSONObject = jSONObject.optJSONObject("status");
                            if (optJSONObject == null || optJSONObject.optInt("code") != 200 || jSONObject.optJSONObject("payload") == null) {
                                PaymentRouter.this.paymentResultListener.onMoneyInFailed("check callSaveDepositDetails response");
                            }
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("payload");
                            String optString = optJSONObject2.optString("plugin", "");
                            final JSONObject optJSONObject3 = optJSONObject2.optJSONObject(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
                            if (optJSONObject3 == null) {
                                PaymentRouter.this.paymentResultListener.onMoneyInFailed("additional details missing");
                                return;
                            }
                            char c2 = 65535;
                            if (optString.hashCode() == 566070395) {
                                if (optString.equals(RoutingConstants.MI_PLUGIN_VALUE_IRIS)) {
                                    c2 = 0;
                                }
                            }
                            if (c2 != 0) {
                                PaymentRouter.this.paymentResultListener.onMoneyInFailed("unknown plugin");
                            } else if (PaymentRouter.this.activity != null) {
                                PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                                    public void run() {
                                        AnonymousClass1 r0 = AnonymousClass1.this;
                                        PaymentRouter.this.processGoPayPayment(jSONObject, optJSONObject3);
                                    }
                                });
                            }
                        }
                    } catch (Exception e2) {
                        PaymentRouter.this.paymentResultListener.onMoneyInFailed(StringUtils.getMessageFromException(e2, "exception in callSaveDepositDetails"));
                    }
                }
                PaymentRouter.this.paymentResultListener.onMoneyInFailed("post response was null or empty");
            }
        }).build());
    }

    private ArrayList<String> getArrayListFromSecondayPaymentModeArray(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(jSONArray.getString(i));
                i++;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return arrayList;
    }

    private PaymentFlow getPaymentFlow(String str, String str2, String str3, String str4) {
        if ("PHONEPE".equalsIgnoreCase(str) && RoutingConstants.PAYMENT_METHOD_TYPE_DIRECT_WALLET.equalsIgnoreCase(str2) && BaseParser.TRUE.equalsIgnoreCase(str3)) {
            return PaymentFlow.PHONEPE_DIRECT_DEBIT;
        }
        if ("wallet".equalsIgnoreCase(str2) && RoutingConstants.PAYMENT_MODE_GOPAY.equalsIgnoreCase(str) && BaseParser.TRUE.equalsIgnoreCase(str3)) {
            return PaymentFlow.GOPAY_WALLET;
        }
        if ("PAYTM".equalsIgnoreCase(str) && "wallet".equalsIgnoreCase(str2) && RoutingConstants.MI_PLUGIN_VALUE_JUSPAY.equalsIgnoreCase(str4)) {
            return PaymentFlow.PAYTM_WALLET_JUSPAY;
        }
        if (RoutingConstants.PAYMENT_MODE_AMAZONPAY.equalsIgnoreCase(str) && "wallet".equalsIgnoreCase(str2) && RoutingConstants.MI_PLUGIN_VALUE_JUSPAY.equalsIgnoreCase(str4)) {
            return PaymentFlow.AMAZON_TOKENIZE_WALLET_JUSPAY;
        }
        if (RoutingConstants.PAYMENT_MODE_TYPE_LAZYPAY.equalsIgnoreCase(str) && RoutingConstants.PAYMENT_METHOD_TYPE_BNPL.equalsIgnoreCase(str2) && RoutingConstants.MI_PLUGIN_VALUE_JUSPAY.equalsIgnoreCase(str4)) {
            return PaymentFlow.LAZYPAY_WALLET_JUSPAY;
        }
        if ("cards".equalsIgnoreCase(str2) && RoutingConstants.MI_PLUGIN_VALUE_JUSPAY.equalsIgnoreCase(str4)) {
            return PaymentFlow.CARDS_JUSPAY;
        }
        if (!"cards".equalsIgnoreCase(str2) || !RoutingConstants.MI_PLUGIN_VALUE_TPSL.equalsIgnoreCase(str4)) {
            return PaymentFlow.UNDEFINED;
        }
        return PaymentFlow.CARDS_TPSL;
    }

    private String getPhonePeVersionCode() throws Exception {
        return GeneratedOutlineSupport.outline57(new StringBuilder(), this.activity.getPackageManager().getPackageInfo(this.isSandboxMoneyInEnabled ? "com.phonepe.app.preprod" : "com.phonepe.app", 1).versionCode, "");
    }

    /* access modifiers changed from: private */
    public void makeJuspayPayment(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            new JuspayHyperPaymentsBuilder().setMoneyInPayload(jSONObject).setReactJson(jSONObject2).setPaymentResultListener(this.paymentResultListener).setCurrentActivity(this.activity).setFetchCustomerIdUseCase(this.fetchCustomerIdUseCase).createJuspayHyperPayments().processPayment();
        } catch (Exception e2) {
            String str = "Exception when creating juspayHyperPayments";
            if (e2.getMessage() != null) {
                str = GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73(str));
            }
            this.paymentResultListener.onMoneyInFailed(str);
        }
    }

    /* access modifiers changed from: private */
    public void makeRazorpayPayment(JSONObject jSONObject, JSONObject jSONObject2) {
        Intent intent;
        String optString = jSONObject2.optString("paymentMethodType", "");
        String optString2 = jSONObject2.optString("paymentMode", "");
        jSONObject2.optString("savedPaymentType", "");
        if (!"upi".equals(optString) || !RoutingConstants.PAYMENT_MODE_TYPE_GPAY_UPI.equals(optString2)) {
            intent = null;
        } else {
            intent = new Intent(this.activity, RazorPayGpayUpiActivity.class);
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_TRANSACTION_TYPE, "gpayUpiHsTxn");
        }
        if (intent != null) {
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_RZP_KEY, jSONObject.optString(RoutingConstants.KILLBILL_RAZORPAY_API_KEY));
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_ACTIVITY_AMOUNT_FRM_MI, jSONObject.optString("amount"));
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_RZP_ORDER_ID, jSONObject.optString(RoutingConstants.KILLBILL_RAZORPAY_RZP_ORDER_ID));
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_EMAIL, jSONObject.optString("email"));
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_NUMBER, jSONObject.optString(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER));
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_CURRENCY, jSONObject.optString("currency"));
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_MPL_ID, jSONObject.optString("orderId"));
            intent.putExtra(RazorpayConstants.BUNDLE_RP_WV_IS_V2_PAYMENT, true);
            this.activity.startActivityForResult(intent, this.razorpayRequestCode);
            return;
        }
        PaymentResultListener paymentResultListener2 = this.paymentResultListener;
        paymentResultListener2.onMoneyInFailed("in makeRazorpayPayment, check paymentMethodType or paymentMode from react\npaymentMethodType is: " + optString + "\n paymentMode is: " + optString2);
    }

    private void makeTpslPayment(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            String optString = jSONObject2.optString("paymentMethodType", "");
            String optString2 = jSONObject2.optString("savedPaymentType", "");
            TpslPaymentsBuilder tpslPaymentsListener = new TpslPaymentsBuilder().setActivity(this.activity).setTpslRequescode(this.tpslRequestCode).setMerchantIdentifier(jSONObject.optString(RoutingConstants.KILLBILL_TPSL_MERCHANT_IDENTIFIER, "")).setTransactionIdentifier(jSONObject.optString(RoutingConstants.KILLBILL_TPSL_TRANSACTION_REFERENCE_ID, "")).setTransactionReference(jSONObject.optString(RoutingConstants.KILLBILL_TPSL_TRANSACTION_REFERENCE_ID, "")).setTransactionCurrency(jSONObject.optString(RoutingConstants.KILLBILL_TPSL_TRANSACTION_CURRENCY, "")).setTransactionAmount(truncateToTwoPrecisions(jSONObject.optString("amount", ""))).setTransactionDateTime(jSONObject.optString(RoutingConstants.KILLBILL_TPSL_MERCHANT_DATETIME, "")).setConsumerIdentifier(jSONObject.optString("userId", "")).setConsumerEmailID(jSONObject.optString(RoutingConstants.KILLBILL_TPSL_CONSUMER_EMAIL, "")).setConsumerMobileNumber(jSONObject.optString("mobileNumber", "")).setConsumerAccountNo("").setProductID(jSONObject.optString(RoutingConstants.KILLBILL_TPSL_PRODUCT_ID, "")).setProductAmount(jSONObject.optString("amount", "")).setPaymentMethodTypeFromReact(optString).setSavedPaymentTypeFromReact(optString2).setPaymentMethodToken(jSONObject.optString("code", "")).setTpslPaymentsListener(new TpslPaymentsListener() {
                public void onTpslPaymentFailed(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
                        jSONObject.put("orderId", PaymentRouter.this.mMplTransactionId);
                        jSONObject.put("error", str);
                        jSONObject.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_TPSL);
                        PaymentRouter.this.paymentResultListener.onPaymentFailed(jSONObject.toString());
                    } catch (Exception unused) {
                    }
                }

                public void onTpslPaymentSuccess() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", "SUCCESS");
                        jSONObject.put("orderId", PaymentRouter.this.mMplTransactionId);
                        jSONObject.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_TPSL);
                        PaymentRouter.this.paymentResultListener.onPaymentSuccessful(jSONObject.toString());
                        PaymentRouter.this.sendtpslOrderIdToBackend(PaymentRouter.this.mMplTransactionId);
                    } catch (JSONException unused) {
                    }
                }

                public void onTpslSaveCardPaymentSuccessful(String str, String str2) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", "SUCCESS");
                        jSONObject.put("orderId", PaymentRouter.this.mMplTransactionId);
                        jSONObject.put("instrumentAliasName", str);
                        jSONObject.put(RoutingConstants.MI_REACT_CARD_TOKEN, str2);
                        jSONObject.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_TPSL);
                        PaymentRouter.this.paymentResultListener.onPaymentSuccessful(jSONObject.toString());
                        PaymentRouter.this.sendtpslOrderIdToBackend(PaymentRouter.this.mMplTransactionId);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                public void onTpslTransactionPending() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("status", "PENDING");
                        jSONObject.put("orderId", PaymentRouter.this.mMplTransactionId);
                        jSONObject.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_TPSL);
                        PaymentRouter.this.paymentResultListener.onPaymentFailed(jSONObject.toString());
                        PaymentRouter.this.sendtpslOrderIdToBackend(PaymentRouter.this.mMplTransactionId);
                    } catch (JSONException unused) {
                    }
                }
            });
            if ("cards".equals(optString)) {
                if (BaseParser.FALSE.equalsIgnoreCase(optString2)) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject(RoutingConstants.MI_REACT_NEW_CARD_DETAILS);
                    if (optJSONObject != null) {
                        tpslPaymentsListener = tpslPaymentsListener.setCardNumber(optJSONObject.optString(RoutingConstants.MI_REACT_CARD_NO, "")).setCardMonth(optJSONObject.optString(RoutingConstants.MI_REACT_CARD_MONTH, "")).setCardYear(optJSONObject.optString(RoutingConstants.MI_REACT_CARD_YEAR_LONG, "")).setCardHolderName(optJSONObject.optString(RoutingConstants.MI_REACT_CARD_HOLDER, "")).setCardCvv(optJSONObject.optString(RoutingConstants.MI_REACT_CARD_CVV, "")).setShouldSaveCard(optJSONObject.optString(RoutingConstants.MI_REACT_CARD_SHOULD_SAVE, ""));
                    } else {
                        this.paymentResultListener.onMoneyInFailed("new card details from react is missing");
                    }
                } else if (BaseParser.TRUE.equalsIgnoreCase(optString2)) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("savedPaymentDetails");
                    tpslPaymentsListener = tpslPaymentsListener.setCardInstrumentationToken(jSONObject3.optString(RoutingConstants.MI_REACT_CARD_TOKEN, "")).setCardCvv(jSONObject3.optString(RoutingConstants.MI_REACT_CARD_CVV));
                }
            }
            TpslPayments build = tpslPaymentsListener.build();
            this.mTpslPayments = build;
            build.doTpslPayment();
        } catch (Exception e2) {
            this.paymentResultListener.onMoneyInFailed(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void makeUpointPayment(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            String optString = jSONObject2.optString(RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT, "");
            new UpointPaymentBuilder().setPaymentType(UpointPayment.PAYMENT_TYPE_TELKOMSEL).setClientKey(jSONObject.optString(RoutingConstants.KILLBILL_UPOINT_CLIENT_KEY, "")).setPhoneNumber(optString).setToken(jSONObject.optString("token", "")).setUpointResultListener(new UpointResultListener() {
                public void onUpointPaymentFailed(final Exception exc) {
                    if (PaymentRouter.this.activity != null) {
                        PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                            public void run() {
                                PaymentRouter.this.paymentResultListener.onPaymentFailed(exc);
                            }
                        });
                    }
                }

                public void onUpointPaymentSuccess(final String str) {
                    if (PaymentRouter.this.activity != null) {
                        PaymentRouter.this.activity.runOnUiThread(new Runnable() {
                            public void run() {
                                PaymentRouter.this.paymentResultListener.onPaymentSuccessful(str);
                            }
                        });
                    }
                }
            }).build().doUpointPayment();
        } catch (Exception e2) {
            this.paymentResultListener.onMoneyInFailed(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("something went wrong in makeUpointPayment-->")));
        }
    }

    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r17v1, types: [com.mpl.payment.braintree.BraintreeCustomPayment] */
    /* JADX WARNING: type inference failed for: r17v2, types: [com.mpl.payment.braintree.BraintreeCustomPayment] */
    /* JADX WARNING: type inference failed for: r17v3, types: [com.mpl.payment.braintree.BraintreeCustomPayment] */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r0v19, types: [com.mpl.payment.braintree.BraintreeCustomPayment] */
    /* JADX WARNING: type inference failed for: r0v22, types: [com.mpl.payment.braintree.BraintreeCustomPayment] */
    /* JADX WARNING: type inference failed for: r17v5, types: [com.mpl.payment.braintree.BraintreeCustomPayment] */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r3v9, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r17v7, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: type inference failed for: r17v9 */
    /* JADX WARNING: type inference failed for: r17v10 */
    /* JADX WARNING: type inference failed for: r0v34 */
    /* JADX WARNING: type inference failed for: r0v35 */
    /* JADX WARNING: type inference failed for: r17v11 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r17v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.util.ArrayList<java.lang.String>, com.mpl.payment.braintree.BraintreeCustomPayment]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], com.mpl.payment.braintree.BraintreeCustomPayment, ?[OBJECT, ARRAY]]
      mth insns count: 243
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02c3 A[Catch:{ Exception -> 0x02df }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02c7 A[Catch:{ Exception -> 0x02df }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processBrainTreePayment(org.json.JSONObject r22, org.json.JSONObject r23) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r23
            java.lang.String r3 = "newCardDetails"
            java.lang.String r4 = "is3DSOn"
            java.lang.String r5 = "isCardVerificationDone"
            java.lang.String r6 = "secondaryPaymentModes"
            java.lang.String r7 = "orderId"
            java.lang.String r8 = ""
            java.lang.String r9 = "true"
            boolean r10 = r0.has(r7)     // Catch:{ Exception -> 0x02df }
            if (r10 == 0) goto L_0x02d7
            java.lang.String r10 = r0.optString(r7)     // Catch:{ Exception -> 0x02df }
            boolean r10 = r10.isEmpty()     // Catch:{ Exception -> 0x02df }
            if (r10 == 0) goto L_0x0026
            goto L_0x02d7
        L_0x0026:
            java.lang.String r7 = r0.optString(r7)     // Catch:{ Exception -> 0x02df }
            r1.mMplTransactionId = r7     // Catch:{ Exception -> 0x02df }
            java.lang.String r7 = "paymentMethodType"
            java.lang.String r7 = r2.optString(r7)     // Catch:{ Exception -> 0x02df }
            java.lang.String r10 = "paymentMode"
            java.lang.String r10 = r2.optString(r10)     // Catch:{ Exception -> 0x02df }
            java.lang.String r11 = "braintree"
            boolean r11 = r11.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x02df }
            java.lang.String r12 = "billingAgreementDescription"
            java.lang.String r13 = "currencyCode"
            java.lang.String r14 = "localeCode"
            java.lang.String r15 = "amount"
            r16 = r4
            java.lang.String r4 = "token"
            r17 = 0
            if (r11 == 0) goto L_0x00da
            java.lang.String r11 = "BRAINTREE"
            boolean r11 = r11.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x02df }
            if (r11 == 0) goto L_0x00da
            boolean r3 = r2.has(r6)     // Catch:{ Exception -> 0x02df }
            if (r3 == 0) goto L_0x006e
            org.json.JSONArray r3 = r2.optJSONArray(r6)     // Catch:{ Exception -> 0x02df }
            java.util.ArrayList r17 = r1.getArrayListFromSecondayPaymentModeArray(r3)     // Catch:{ Exception -> 0x02df }
            if (r17 != 0) goto L_0x006e
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "Json exception when parsing in secondary payment mode array"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x006e:
            r3 = r17
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r5 = new com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder     // Catch:{ Exception -> 0x02df }
            r5.<init>()     // Catch:{ Exception -> 0x02df }
            java.lang.String r4 = r0.optString(r4)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r4 = r5.setClientToken(r4)     // Catch:{ Exception -> 0x02df }
            android.app.Activity r5 = r1.activity     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r4 = r4.setCallingActivity(r5)     // Catch:{ Exception -> 0x02df }
            int r5 = r1.brainTreeRequestCode     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r4 = r4.setRequestCode(r5)     // Catch:{ Exception -> 0x02df }
            java.lang.String r5 = r1.mMplTransactionId     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r4 = r4.setMplOrderId(r5)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.routing.PaymentResultListener r5 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r4 = r4.setPaymentResultListener(r5)     // Catch:{ Exception -> 0x02df }
            java.lang.String r5 = "enabledSavePaymentMode"
            java.lang.String r2 = r2.optString(r5)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r2 = r4.setShouldSavePaymentMethod(r2)     // Catch:{ Exception -> 0x02df }
            java.lang.String r4 = r0.optString(r15)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r2 = r2.setAmount(r4)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r2 = r2.setAvailablePaymentModes(r3)     // Catch:{ Exception -> 0x02df }
            java.lang.String r3 = r0.optString(r14)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r2 = r2.setLocaleCode(r3)     // Catch:{ Exception -> 0x02df }
            java.lang.String r3 = r0.optString(r13)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r2 = r2.setCurrencyCode(r3)     // Catch:{ Exception -> 0x02df }
            java.lang.String r0 = r0.optString(r12)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r0 = r2.setBillingAgreementDescription(r0)     // Catch:{ Exception -> 0x02df }
            java.util.ArrayList<com.mpl.network.modules.engine.MHeader> r2 = r1.mHeaders     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r0 = r0.setmHeaders(r2)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.common.AuthTokenProvider r2 = r1.authTokenProvider     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment$BraintreePaymentBuilder r0 = r0.setAuthTokenProvider(r2)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreePayment r0 = r0.createBraintreePayment()     // Catch:{ Exception -> 0x02df }
            r1.mBraintreePayment = r0     // Catch:{ Exception -> 0x02df }
            r0.makeBraintreePaymentDropin()     // Catch:{ Exception -> 0x02df }
            goto L_0x02f5
        L_0x00da:
            java.lang.String r6 = "savedPaymentType"
            java.lang.String r6 = r2.optString(r6, r8)     // Catch:{ Exception -> 0x02df }
            boolean r11 = com.mpl.payment.utils.StringUtils.isNullOrEmpty(r6)     // Catch:{ Exception -> 0x02df }
            if (r11 != 0) goto L_0x02cf
            boolean r11 = r9.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02df }
            r18 = r8
            java.lang.String r8 = "false"
            if (r11 != 0) goto L_0x00f8
            boolean r11 = r8.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02df }
            if (r11 != 0) goto L_0x00f8
            goto L_0x02cf
        L_0x00f8:
            boolean r11 = com.mpl.payment.utils.StringUtils.isNullOrEmpty(r7)     // Catch:{ Exception -> 0x02df }
            if (r11 == 0) goto L_0x0106
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "paymentMethodType cant be null or empty"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x0106:
            java.lang.String r11 = "cards"
            boolean r11 = r7.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x02df }
            r19 = r9
            java.lang.String r9 = "paypal"
            r20 = r9
            java.lang.String r9 = "card"
            if (r11 == 0) goto L_0x0118
            r7 = r9
            goto L_0x013b
        L_0x0118:
            java.lang.String r11 = "wallet"
            boolean r7 = r7.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x02df }
            if (r7 == 0) goto L_0x0139
            boolean r7 = com.mpl.payment.utils.StringUtils.isNullOrEmpty(r10)     // Catch:{ Exception -> 0x02df }
            if (r7 == 0) goto L_0x012e
            com.mpl.payment.routing.PaymentResultListener r7 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r11 = "paymentMode cant be null or empty"
            r7.onMoneyInFailed(r11)     // Catch:{ Exception -> 0x02df }
            goto L_0x0139
        L_0x012e:
            java.lang.String r7 = "PAYPAL"
            boolean r7 = r10.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x02df }
            if (r7 == 0) goto L_0x0139
            r7 = r20
            goto L_0x013b
        L_0x0139:
            r7 = r17
        L_0x013b:
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r11 = new com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder     // Catch:{ Exception -> 0x02df }
            r11.<init>()     // Catch:{ Exception -> 0x02df }
            java.lang.String r4 = r0.optString(r4)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r11.setClientToken(r4)     // Catch:{ Exception -> 0x02df }
            android.app.Activity r11 = r1.activity     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setCallingActivity(r11)     // Catch:{ Exception -> 0x02df }
            java.lang.String r11 = r1.mMplTransactionId     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setMplOrderId(r11)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.routing.PaymentResultListener r11 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setPaymentResultListener(r11)     // Catch:{ Exception -> 0x02df }
            java.lang.String r11 = r0.optString(r14)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setLocaleCode(r11)     // Catch:{ Exception -> 0x02df }
            java.lang.String r11 = r0.optString(r13)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setCurrencyCode(r11)     // Catch:{ Exception -> 0x02df }
            java.lang.String r11 = r0.optString(r12)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setBillingAgreementDescription(r11)     // Catch:{ Exception -> 0x02df }
            java.util.ArrayList<com.mpl.network.modules.engine.MHeader> r11 = r1.mHeaders     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setmHeaders(r11)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.common.AuthTokenProvider r11 = r1.authTokenProvider     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r4 = r4.setAuthTokenProvider(r11)     // Catch:{ Exception -> 0x02df }
            java.lang.String r0 = r0.optString(r15)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r4.setAmount(r0)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setiSSavedPaymentMethod(r6)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setPaymentType(r7)     // Catch:{ Exception -> 0x02df }
            java.lang.String r4 = r1.braintreeNonceSubmitUrl     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setNonceSubmissionUrl(r4)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setPaymentModeFromReact(r10)     // Catch:{ Exception -> 0x02df }
            java.lang.String r4 = "savedPaymentDetails is missing or not a jsonObject"
            java.lang.String r10 = "savedPaymentDetails"
            if (r7 == 0) goto L_0x0276
            boolean r11 = r9.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x02df }
            if (r11 == 0) goto L_0x0276
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setPaymentType(r9)     // Catch:{ Exception -> 0x02df }
            boolean r7 = r8.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02df }
            java.lang.String r9 = "nonce"
            if (r7 == 0) goto L_0x0206
            boolean r4 = r2.has(r5)     // Catch:{ Exception -> 0x02df }
            if (r4 == 0) goto L_0x01fe
            boolean r4 = r2.optBoolean(r5)     // Catch:{ Exception -> 0x02df }
            if (r4 == 0) goto L_0x01fe
            java.lang.String r4 = "cardVerificationDetails"
            org.json.JSONObject r4 = r2.optJSONObject(r4)     // Catch:{ Exception -> 0x02df }
            java.lang.String r4 = r4.optString(r9)     // Catch:{ Exception -> 0x02df }
            boolean r5 = com.mpl.payment.utils.StringUtils.isNullOrEmpty(r4)     // Catch:{ Exception -> 0x02df }
            if (r5 != 0) goto L_0x01f6
            r0.setVerifiedCardNonce(r4)     // Catch:{ Exception -> 0x02df }
            boolean r4 = r2.has(r3)     // Catch:{ Exception -> 0x02df }
            if (r4 == 0) goto L_0x01ee
            org.json.JSONObject r2 = r2.optJSONObject(r3)     // Catch:{ Exception -> 0x02df }
            java.lang.String r3 = "shouldSaveCard"
            boolean r2 = r2.getBoolean(r3)     // Catch:{ Exception -> 0x02df }
            if (r2 == 0) goto L_0x01e4
            r9 = r19
            goto L_0x01e5
        L_0x01e4:
            r9 = r8
        L_0x01e5:
            r0.setShouldSavePaymentMethod(r9)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment r17 = r0.createBraintreePayment()     // Catch:{ Exception -> 0x02df }
            goto L_0x02c1
        L_0x01ee:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "newCardDetails missing from react object"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x01f6:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "check nonce in cardVerificationDetails"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x01fe:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "check isCardVerificationDone"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x0206:
            r3 = r19
            boolean r5 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02df }
            if (r5 == 0) goto L_0x02c1
            r5 = r16
            java.lang.String r6 = r2.optString(r5)     // Catch:{ Exception -> 0x02df }
            r0.setIs3DsOn(r6)     // Catch:{ Exception -> 0x02df }
            org.json.JSONObject r6 = r2.optJSONObject(r10)     // Catch:{ Exception -> 0x02df }
            if (r6 == 0) goto L_0x0270
            java.lang.String r4 = "additionalDetails"
            org.json.JSONObject r4 = r6.optJSONObject(r4)     // Catch:{ Exception -> 0x02df }
            if (r4 == 0) goto L_0x02c1
            java.lang.String r2 = r2.optString(r5)     // Catch:{ Exception -> 0x02df }
            boolean r5 = r8.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x02df }
            if (r5 != 0) goto L_0x023e
            boolean r5 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x02df }
            if (r5 != 0) goto L_0x023e
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "is3DsOn needs to be either true or false"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            goto L_0x02c1
        L_0x023e:
            boolean r2 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x02df }
            if (r2 == 0) goto L_0x025d
            r5 = r18
            java.lang.String r2 = r4.optString(r9, r5)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setSavedCardNonce(r2)     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "cardType"
            java.lang.String r2 = r4.optString(r2, r5)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setCardType(r2)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment r0 = r0.createBraintreePayment()     // Catch:{ Exception -> 0x02df }
            goto L_0x026d
        L_0x025d:
            r5 = r18
            java.lang.String r2 = "cardToken"
            java.lang.String r2 = r4.optString(r2, r5)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setPaymentMethodToken(r2)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment r0 = r0.createBraintreePayment()     // Catch:{ Exception -> 0x02df }
        L_0x026d:
            r17 = r0
            goto L_0x02c1
        L_0x0270:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            r0.onMoneyInFailed(r4)     // Catch:{ Exception -> 0x02df }
            goto L_0x02c1
        L_0x0276:
            r5 = r18
            r3 = r19
            if (r7 == 0) goto L_0x02ba
            r9 = r20
            boolean r7 = r9.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x02df }
            if (r7 == 0) goto L_0x02ba
            boolean r7 = r8.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02df }
            if (r7 == 0) goto L_0x0299
            java.lang.String r3 = "shouldSaveInstrument"
            java.lang.String r2 = r2.optString(r3)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setShouldSavePaymentMethod(r2)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment r17 = r0.createBraintreePayment()     // Catch:{ Exception -> 0x02df }
            goto L_0x02c1
        L_0x0299:
            boolean r3 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02df }
            if (r3 == 0) goto L_0x02c1
            org.json.JSONObject r2 = r2.optJSONObject(r10)     // Catch:{ Exception -> 0x02df }
            if (r2 == 0) goto L_0x02b4
            java.lang.String r3 = "instrumentToken"
            java.lang.String r2 = r2.optString(r3, r5)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment$BraintreeCustomPaymentBuilder r0 = r0.setPaymentMethodToken(r2)     // Catch:{ Exception -> 0x02df }
            com.mpl.payment.braintree.BraintreeCustomPayment r17 = r0.createBraintreePayment()     // Catch:{ Exception -> 0x02df }
            goto L_0x02c1
        L_0x02b4:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            r0.onMoneyInFailed(r4)     // Catch:{ Exception -> 0x02df }
            goto L_0x02c1
        L_0x02ba:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "Got unknow brainTreePayment appears to be incorrect!"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
        L_0x02c1:
            if (r17 == 0) goto L_0x02c7
            r17.initBraintreePayment()     // Catch:{ Exception -> 0x02df }
            goto L_0x02f5
        L_0x02c7:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "braintreePayment not intitialized"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x02cf:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "savedPaymentType from react cant be null or empty"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x02d7:
            com.mpl.payment.routing.PaymentResultListener r0 = r1.paymentResultListener     // Catch:{ Exception -> 0x02df }
            java.lang.String r2 = "MPL order id not received in MIV2 response"
            r0.onMoneyInFailed(r2)     // Catch:{ Exception -> 0x02df }
            return
        L_0x02df:
            r0 = move-exception
            java.lang.String r2 = "Exception in processBraintreePayment "
            com.mpl.payment.routing.PaymentResultListener r3 = r1.paymentResultListener
            java.lang.String r4 = r0.getMessage()
            if (r4 == 0) goto L_0x02f2
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline39(r0, r2)
        L_0x02f2:
            r3.onMoneyInFailed(r2)
        L_0x02f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.routing.PaymentRouter.processBrainTreePayment(org.json.JSONObject, org.json.JSONObject):void");
    }

    /* access modifiers changed from: private */
    public void processGoPayPayment(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            String optString = jSONObject2.optString("orderId", "");
            if (!optString.isEmpty()) {
                Object transactionParams = new GoPayTransactionParamsCreator(jSONObject.toString(), this.moshi, optString).getTransactionParams();
                if (transactionParams instanceof GoPayTransactionParams) {
                    GoPayPaymentProcessor goPayPaymentProcessor = new GoPayPaymentProcessor((GoPayTransactionParams) transactionParams, this.activity);
                    goPayPaymentProcessor.addListener(this.paymentResultListener);
                    goPayPaymentProcessor.processPayment();
                    return;
                }
                this.paymentResultListener.onMoneyInFailed("Wrong transaction param creator");
                return;
            }
            PaymentResultListener paymentResultListener2 = this.paymentResultListener;
            paymentResultListener2.onMoneyInFailed("Order Id was empty" + jSONObject.toString());
        } catch (Exception e2) {
            this.paymentResultListener.onMoneyInFailed(StringUtils.getMessageFromException(e2, "Exception when doing gopayPayment"));
        }
    }

    /* access modifiers changed from: private */
    public void processTPSL(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mMplTransactionId = jSONObject.optString(RoutingConstants.KILLBILL_TPSL_TRANSACTION_REFERENCE_ID, "");
        makeTpslPayment(jSONObject, jSONObject2);
    }

    private JSONObject putFieldsFromAdditionalDetails(JSONObject jSONObject, JSONObject jSONObject2, String str) throws Exception {
        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
        PaymentFlow paymentFlow = getPaymentFlow(jSONObject2.optString("paymentMode", ""), jSONObject2.optString("paymentMethodType", ""), jSONObject2.optString("savedPaymentType", ""), str);
        JSONObject optJSONObject = jSONObject2.optJSONObject("savedPaymentDetails").optJSONObject(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
        if (optJSONObject != null) {
            switch (paymentFlow.ordinal()) {
                case 0:
                    String optString = optJSONObject.optString("userAuthToken", "");
                    String optString2 = optJSONObject.optString(Constant.HEADER_ANDROID_DEVICE_ID, "");
                    String phonePeVersionCode = getPhonePeVersionCode();
                    if (!optString.isEmpty() && !optString2.isEmpty()) {
                        jSONObject3.put("userAuthToken", optString);
                        jSONObject3.put(Constant.HEADER_ANDROID_DEVICE_ID, optString2);
                        jSONObject3.put("phonePeVersion", phonePeVersionCode);
                        break;
                    } else {
                        throw new Exception("Check additionalDetails from react userAuthToken,deviceId");
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    String optString3 = optJSONObject.optString("id", "");
                    if (!optString3.isEmpty()) {
                        jSONObject3.put("id", optString3);
                        break;
                    } else {
                        throw new Exception("id can't be empty in additional details");
                    }
                case 4:
                    String optString4 = optJSONObject.optString(RoutingConstants.MI_REACT_CARD_TOKEN_BRAINTREE, "");
                    String optString5 = optJSONObject.optString("cardReference", "");
                    String optString6 = optJSONObject.optString("cardFingerprint", "");
                    if (!optString4.isEmpty() && !optString6.isEmpty() && !optString5.isEmpty()) {
                        jSONObject3.put(RoutingConstants.MI_REACT_CARD_TOKEN_BRAINTREE, optString4);
                        jSONObject3.put("cardReference", optString5);
                        jSONObject3.put("cardFingerprint", optString5);
                        break;
                    } else {
                        throw new Exception("check cardToken, cardReference, cardFingerprint in additional detail");
                    }
                case 5:
                    String optString7 = optJSONObject.optString(RoutingConstants.MI_REACT_CARD_TOKEN_BRAINTREE, "");
                    if (!optString7.isEmpty()) {
                        jSONObject3.put(RoutingConstants.MI_REACT_CARD_TOKEN_BRAINTREE, optString7);
                        break;
                    } else {
                        throw new Exception("check cardToken in additionalDetail");
                    }
                case 6:
                    String optString8 = optJSONObject.optString("accountId");
                    String optString9 = optJSONObject.optString("paymentOptionToken");
                    String optString10 = optJSONObject.optString("callBackUrl", "mplgaming://gopaypayment");
                    if (!optString8.isEmpty() && !optString9.isEmpty()) {
                        jSONObject3.put("accountId", optString8);
                        jSONObject3.put("paymentOptionToken", optString9);
                        jSONObject3.put("callbackUrl", optString10);
                        break;
                    } else {
                        throw new Exception("Check additionalDetails from react accountId,paymentOptionToken");
                    }
                    break;
            }
            return jSONObject3;
        }
        throw new Exception("additional details can't be null");
    }

    /* access modifiers changed from: private */
    public void sendtpslOrderIdToBackend(String str) {
        String str2 = this.tpslRTSUrl;
        if (str2 != null && !str2.isEmpty()) {
            MClient.executeAsync(new MOkHttpGetRequest.Builder().setUrl(this.tpslRTSUrl).setHeaders((ArrayList) this.mHeaders.clone()).addHeader(this.authTokenProvider.getAuthHeader()).setRequestPriority(RequestPriority.HIGH).setRetryOnConnectionFailure(true).addQueryParam(BraintreeConstants.NS_MPL_ORDER_ID, str).setResponseListener(new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    exc.getMessage();
                }

                public void onResponseSuccess(String str) {
                }

                public void progressResponse(long j, long j2, boolean z) {
                }
            }).build());
        }
    }

    public static ArrayList<String> toStringArrayList(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(String.valueOf(jSONArray.opt(i)));
        }
        return arrayList;
    }

    private String truncateToTwoPrecisions(String str) {
        if (!str.contains(".")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("\\.");
        if (split.length <= 0) {
            return str;
        }
        sb.append(split[0]);
        sb.append(".");
        if (split.length < 2 || split[1].length() < 3) {
            return str;
        }
        sb.append(split[1].substring(0, 2));
        return sb.toString();
    }

    public void addHeader(String str, String str2) {
        if (this.mHeaders == null) {
            this.mHeaders = new ArrayList<>();
        }
        this.mHeaders.add(new MHeader(str, str2));
    }

    public void onActivityResultForwarder(int i, int i2, Intent intent) {
        if (i == this.tpslRequestCode) {
            TpslPayments tpslPayments = this.mTpslPayments;
            if (tpslPayments != null) {
                tpslPayments.onActivityResult(i, i2, intent);
                return;
            }
        }
        if (i != this.brainTreeRequestCode || this.mBraintreePayment == null) {
            if (i == this.phonePeRequestCode) {
                PhonePePayment phonePePayment2 = this.phonePePayment;
                if (phonePePayment2 != null) {
                    phonePePayment2.onActivityResultForwarder();
                }
            }
        } else if (!this.braintreeNonceSubmitUrl.isEmpty()) {
            this.mBraintreePayment.processActivityResult(i, i2, intent, this.braintreeNonceSubmitUrl);
        } else {
            this.mBraintreePayment.processFailure("braintreeNonceSubmitUrl not received from react!");
        }
    }

    public void processPayment(String str) {
        String str2;
        String str3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.isSandboxMoneyInEnabled = jSONObject.optBoolean("isSanboxMoneyInEnabled", false);
            this.tpslRTSUrl = jSONObject.optString("tpsl_realtime_status_url", "");
            this.braintreeNonceSubmitUrl = jSONObject.optString("complete_deposit_url", "");
            boolean optBoolean = jSONObject.optBoolean("isLoggingEnabled", false);
            int optInt = jSONObject.optInt("phonePeDirectRequestCode", 0);
            this.phonePeRequestCode = optInt;
            if (optInt == 0) {
                this.paymentResultListener.onMoneyInFailed("phonePeDirectRequestCode missing in reactjson");
                return;
            }
            MLog.setIsLogEnabled(optBoolean);
            this.mMobileNumber = jSONObject.optString("mobileNumber", "");
            String optString = jSONObject.optString("url", "");
            String optString2 = jSONObject.optString("amount", "");
            String optString3 = jSONObject.optString("paymentMode", "");
            String optString4 = jSONObject.optString("paymentMethodType", "");
            String str4 = "mobileNumber";
            String optString5 = jSONObject.optString("savedPaymentType", "");
            if (!TextUtils.isEmpty(optString5)) {
                JSONObject jSONObject2 = null;
                String str5 = "cardVerificationDetails";
                String str6 = "isCardVerificationDone";
                if (BaseParser.TRUE.equals(optString5)) {
                    str2 = "savedPaymentType";
                    str3 = jSONObject.getJSONObject("savedPaymentDetails").optString("plugin", "");
                    if (StringUtils.isNullOrEmpty(str3)) {
                        this.paymentResultListener.onMoneyInFailed("Plugin can't be null or empty when savedPaymentType is true");
                        return;
                    }
                } else {
                    str2 = "savedPaymentType";
                    str3 = null;
                }
                if (jSONObject.has(RoutingConstants.MI_REACT_COUPON)) {
                    jSONObject2 = jSONObject.optJSONObject(RoutingConstants.MI_REACT_COUPON);
                }
                JSONObject jSONObject3 = jSONObject2;
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    if (!TextUtils.isEmpty(optString5)) {
                        String str7 = optString;
                        PaymentFlow paymentFlow = getPaymentFlow(optString3, optString4, optString5, str3);
                        String str8 = "";
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("amount", optString2);
                        jSONObject4.put("paymentMode", optString3);
                        jSONObject4.put("paymentMethodType", optString4);
                        if (paymentFlow == PaymentFlow.GOPAY_WALLET) {
                            jSONObject4.put(RoutingConstants.MI_REQUEST_PAYMENT_FLOW, "GOPAY_TOKENIZATION");
                        } else if (this.isCashApp) {
                            jSONObject4.put(RoutingConstants.MI_REQUEST_PAYMENT_FLOW, "JP_2_1_6");
                        } else {
                            jSONObject4.put(RoutingConstants.MI_REQUEST_PAYMENT_FLOW, "PS_JP_2_1_6");
                        }
                        if (BaseParser.TRUE.equalsIgnoreCase(optString5)) {
                            jSONObject4.put(str2, optString5);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("plugin", str3);
                            jSONObject4.put("savedPaymentDetails", putFieldsFromAdditionalDetails(jSONObject5, jSONObject, str3));
                        } else {
                            String str9 = str2;
                            String str10 = str6;
                            if (jSONObject.has(str10) && jSONObject.optBoolean(str10)) {
                                String str11 = str5;
                                if (jSONObject.has(str11)) {
                                    String optString6 = jSONObject.optJSONObject(str11).optString("plugin");
                                    jSONObject4.put(str9, BaseParser.TRUE);
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("plugin", optString6);
                                    jSONObject4.put("savedPaymentDetails", jSONObject6);
                                } else {
                                    this.paymentResultListener.onMoneyInFailed("No cardVerificationDetails was found in reactPayload");
                                    return;
                                }
                            }
                        }
                        if (jSONObject3 != null) {
                            jSONObject4.put(RoutingConstants.MI_REQUEST_OFFER_DETAILS, jSONObject3);
                        }
                        if (optString4.equalsIgnoreCase(RoutingConstants.PAYMENT_METHOD_TYPE_REMOTE_CREDIT) || paymentFlow == PaymentFlow.GOPAY_WALLET) {
                            jSONObject4.put(str4, jSONObject.optString(RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT, str8));
                        }
                        if (paymentFlow == PaymentFlow.GOPAY_WALLET) {
                            callSaveDepositDetails(str7, jSONObject, jSONObject4);
                        } else {
                            callMoneyInV2(str7, jSONObject, jSONObject4);
                        }
                        return;
                    }
                }
                this.paymentResultListener.onMoneyInFailed("Check data from react");
                return;
            }
            this.paymentResultListener.onMoneyInFailed("savedPaymentType is required.");
        } catch (Exception e2) {
            this.paymentResultListener.onMoneyInFailed(!TextUtils.isEmpty(e2.getMessage()) ? e2.getMessage() : "Exception in onProcessPayment");
        }
    }

    public void processPhonePePayment(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            PhonePePayment build = new PhonePePayment.Builder().withMoneyInPaload(jSONObject.toString()).withReactPayload(jSONObject2.toString()).withPaymentResultListener(this.paymentResultListener).withMoshiInstance(this.moshi).withActivity(this.activity).withHeaders(this.mHeaders).withPhonePeVersionCode(getPhonePeVersionCode()).withAuthTokenProvider(this.authTokenProvider).build();
            this.phonePePayment = build;
            build.doPhonePePayment();
        } catch (Exception e2) {
            String str = "";
            if (!(("Exception during creation of phone pe payment-->" + e2) == null || e2.getMessage() == null)) {
                str = e2.getMessage();
            }
            this.paymentResultListener.onMoneyInFailed(str);
        }
    }
}
