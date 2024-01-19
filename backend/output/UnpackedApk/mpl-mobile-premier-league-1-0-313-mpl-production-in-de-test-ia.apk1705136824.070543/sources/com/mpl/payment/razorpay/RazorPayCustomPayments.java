package com.mpl.payment.razorpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest.Builder;
import com.mpl.payment.paytm.PaytmPaymentPostForm;
import com.mpl.payment.routing.RoutingConstants;
import com.razorpay.AnalyticsConstants;
import com.razorpay.BaseConstants;
import com.razorpay.BaseRazorpay.PaymentMethodsCallback;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import com.razorpay.Razorpay;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class RazorPayCustomPayments {
    public static final String TAG = "RzpCustomPayment";
    public static final String TRANSACTION_TYPE_GPAY_HALFPAGEUPI = "gpayUpiHsTxn";
    public static final String TRANSACTION_TYPE_NETBANKING = "nbTxn";
    public boolean isLogEnabled;
    public Activity mActivity;
    public String mAmount;
    public String mAmountFromReact;
    public Context mContext;
    public String mCurrency;
    public String mEmail;
    public ArrayList<MHeader> mHeaders;
    public String mNumber;
    public String mOrderId;
    public String mRzpKey;
    public String mUrl;
    public WebView mWebView;
    public String mplOrderId;
    public String mtransactionType;
    public String paymentGateway;
    public PaymentResultWithDataListener paymentResultWithDataListener;
    public RazorPayPaymentStatusListener razorPayPaymentStatusListener;
    public Razorpay razorpay;
    public String selectedBank;

    public static class RazorPayCustomPaymentBuilder {
        public RazorPayCustomPayments razorPayCustomPayments = new RazorPayCustomPayments();

        public static RazorPayCustomPaymentBuilder buildRazorPayCustomPayment() {
            return new RazorPayCustomPaymentBuilder();
        }

        public RazorPayCustomPaymentBuilder addHeader(String str, String str2) {
            if (this.razorPayCustomPayments.mHeaders == null) {
                this.razorPayCustomPayments.mHeaders = new ArrayList();
            }
            this.razorPayCustomPayments.mHeaders.add(new MHeader(str, str2));
            return this;
        }

        public RazorPayCustomPayments build() throws Exception {
            if (this.razorPayCustomPayments.mNumber == null) {
                throw new Exception("Number from react cant be null");
            } else if (this.razorPayCustomPayments.mUrl == null) {
                throw new Exception("mUrl is null");
            } else if (this.razorPayCustomPayments.razorPayPaymentStatusListener == null) {
                throw new Exception("razorpay moneyin status listener is null");
            } else if (this.razorPayCustomPayments.mWebView == null) {
                throw new Exception("webview is null");
            } else if (this.razorPayCustomPayments.razorPayPaymentStatusListener == null) {
                throw new Exception("razorpay moneyin status listener is null");
            } else if (this.razorPayCustomPayments.mActivity == null) {
                throw new Exception("Activity is null");
            } else if (this.razorPayCustomPayments.mAmountFromReact == null) {
                throw new Exception("Amount is null");
            } else if (this.razorPayCustomPayments.mtransactionType == null) {
                throw new Exception("Transaction type can't be null");
            } else if (this.razorPayCustomPayments.paymentGateway == null || TextUtils.isEmpty(this.razorPayCustomPayments.paymentGateway)) {
                throw new Exception("PaymentMethod is null");
            } else if (!this.razorPayCustomPayments.getTransactionType().equals("nbTxn") || !TextUtils.isEmpty(this.razorPayCustomPayments.selectedBank)) {
                return this.razorPayCustomPayments;
            } else {
                throw new Exception("Selected bank should not empty when doing a netbanking transaction");
            }
        }

        public RazorPayCustomPaymentBuilder isLogEnabled(boolean z) {
            this.razorPayCustomPayments.isLogEnabled = z;
            return this;
        }

        public RazorPayCustomPaymentBuilder setActivity(Activity activity) {
            this.razorPayCustomPayments.mActivity = activity;
            return this;
        }

        public RazorPayCustomPaymentBuilder setAmountFromReact(String str) {
            this.razorPayCustomPayments.mAmountFromReact = str;
            return this;
        }

        public RazorPayCustomPaymentBuilder setBank(String str) {
            this.razorPayCustomPayments.selectedBank = str;
            return this;
        }

        public RazorPayCustomPaymentBuilder setCurrency(String str) {
            this.razorPayCustomPayments.mCurrency = str;
            return this;
        }

        public RazorPayCustomPaymentBuilder setNumber(String str) {
            this.razorPayCustomPayments.mNumber = str;
            return this;
        }

        public RazorPayCustomPaymentBuilder setPaymentGateway(String str) {
            this.razorPayCustomPayments.paymentGateway = str;
            return this;
        }

        public RazorPayCustomPaymentBuilder setRazorPayMoneyInStatusListener(RazorPayPaymentStatusListener razorPayPaymentStatusListener) {
            this.razorPayCustomPayments.razorPayPaymentStatusListener = razorPayPaymentStatusListener;
            return this;
        }

        public RazorPayCustomPaymentBuilder setTransactionType(String str) {
            this.razorPayCustomPayments.mtransactionType = str;
            return this;
        }

        public RazorPayCustomPaymentBuilder setUrl(String str) {
            this.razorPayCustomPayments.mUrl = str;
            return this;
        }

        public RazorPayCustomPaymentBuilder setWebview(WebView webView) {
            this.razorPayCustomPayments.mWebView = webView;
            return this;
        }

        public RazorPayCustomPaymentBuilder setpaymentResultWithDataListener(PaymentResultWithDataListener paymentResultWithDataListener) {
            this.razorPayCustomPayments.paymentResultWithDataListener = paymentResultWithDataListener;
            return this;
        }
    }

    /* access modifiers changed from: private */
    public void startPayment(JSONObject jSONObject) {
        if (this.mtransactionType.equalsIgnoreCase("gpayUpiHsTxn")) {
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        RazorPayCustomPayments.this.razorpay = new Razorpay(RazorPayCustomPayments.this.mActivity, RazorPayCustomPayments.this.mRzpKey);
                        RazorPayCustomPayments.this.razorpay.setWebView(RazorPayCustomPayments.this.mWebView);
                        RazorPayCustomPayments.this.razorpay.getPaymentMethods(new PaymentMethodsCallback() {
                            public void onError(String str) {
                            }

                            public void onPaymentMethodsReceived(String str) {
                                try {
                                    new JSONObject(str);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        });
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("amount", RazorPayCustomPayments.this.mAmount);
                            jSONObject.put("order_id", RazorPayCustomPayments.this.mOrderId);
                            jSONObject.put("email", RazorPayCustomPayments.this.mEmail);
                            jSONObject.put(AnalyticsConstants.CONTACT, RazorPayCustomPayments.this.getNumber());
                            jSONObject.put(AnalyticsConstants.METHOD, "upi");
                            jSONObject.put("_[flow]", AnalyticsConstants.INTENT);
                            jSONObject.put(AnalyticsConstants.UPI_APP_PACKAGE_NAME, BaseConstants.GOOGLE_PAY_PKG);
                            jSONObject.put("currency", RazorPayCustomPayments.this.mCurrency);
                            RazorPayCustomPayments.this.razorpay.submit(jSONObject, (PaymentResultWithDataListener) new PaymentResultWithDataListener() {
                                public void onPaymentError(int i, String str, PaymentData paymentData) {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onRazorPayPaymentFailed(i, str, paymentData, RazorPayCustomPayments.this.mplOrderId);
                                }

                                public void onPaymentSuccess(String str, PaymentData paymentData) {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onRazorPayPaymentSuccessful(str, paymentData, RazorPayCustomPayments.this.mplOrderId);
                                }
                            });
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
        if (this.mtransactionType.equalsIgnoreCase("nbTxn")) {
            Activity activity2 = this.mActivity;
            if (activity2 != null) {
                activity2.runOnUiThread(new Runnable() {
                    public void run() {
                        RazorPayCustomPayments.this.razorpay = new Razorpay(RazorPayCustomPayments.this.mActivity, RazorPayCustomPayments.this.mRzpKey);
                        RazorPayCustomPayments.this.razorpay.setWebView(RazorPayCustomPayments.this.mWebView);
                        RazorPayCustomPayments.this.razorpay.getPaymentMethods(new PaymentMethodsCallback() {
                            public void onError(String str) {
                            }

                            public void onPaymentMethodsReceived(String str) {
                                try {
                                    new JSONObject(str);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        });
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("amount", RazorPayCustomPayments.this.mAmount);
                            jSONObject.put("order_id", RazorPayCustomPayments.this.mOrderId);
                            jSONObject.put("email", RazorPayCustomPayments.this.mEmail);
                            jSONObject.put(AnalyticsConstants.CONTACT, RazorPayCustomPayments.this.getNumber());
                            jSONObject.put(AnalyticsConstants.METHOD, "netbanking");
                            jSONObject.put("bank", RazorPayCustomPayments.this.selectedBank);
                            jSONObject.put("currency", RazorPayCustomPayments.this.mCurrency);
                            if (RazorPayCustomPayments.this.mWebView.getVisibility() != 0) {
                                RazorPayCustomPayments.this.mWebView.setVisibility(0);
                            }
                            RazorPayCustomPayments.this.razorpay.submit(jSONObject, (PaymentResultWithDataListener) new PaymentResultWithDataListener() {
                                public void onPaymentError(int i, String str, PaymentData paymentData) {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onRazorPayPaymentFailed(i, str, paymentData, RazorPayCustomPayments.this.mplOrderId);
                                }

                                public void onPaymentSuccess(String str, PaymentData paymentData) {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onRazorPayPaymentSuccessful(str, paymentData, RazorPayCustomPayments.this.mplOrderId);
                                }
                            });
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
    }

    public String getAmountFromReact() {
        return this.mAmountFromReact;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public String getPaymentGateway() {
        return this.paymentGateway;
    }

    public PaymentResultWithDataListener getPaymentResultWithDataListener() {
        return this.paymentResultWithDataListener;
    }

    public String getTransactionType() {
        return this.mtransactionType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void initiatePayment() {
        initiatePayment("");
    }

    public void submitOnActivityResultsToRazorpay(int i, int i2, Intent intent) {
        Razorpay razorpay2 = this.razorpay;
        if (razorpay2 != null) {
            razorpay2.onActivityResult(i, i2, intent);
        }
    }

    public void submitOnBackPressed() {
        Razorpay razorpay2 = this.razorpay;
        if (razorpay2 != null) {
            razorpay2.onBackPressed();
        }
    }

    public RazorPayCustomPayments() {
        this.mHeaders = new ArrayList<>();
    }

    public void initiatePayment(String str) {
        JSONObject jSONObject;
        PaytmPaymentPostForm paytmPaymentPostForm = new PaytmPaymentPostForm();
        paytmPaymentPostForm.setAmount(getAmountFromReact());
        paytmPaymentPostForm.setPaymentMethod(getPaymentGateway());
        paytmPaymentPostForm.setNumber(getNumber());
        String json = new Gson().toJson((Object) paytmPaymentPostForm);
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(json);
            if (str != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject3 = new JSONObject(str);
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.put(next, jSONObject3.get(next));
                        }
                    }
                } catch (Exception unused) {
                    jSONObject2 = jSONObject;
                    jSONObject = jSONObject2;
                    Builder headers = new Builder().setUrl(getUrl()).setResponseListener(new IResponseListener<String>() {
                        public void onResponseFail(Exception exc) {
                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, exc.getMessage());
                        }

                        public void progressResponse(long j, long j2, boolean z) {
                        }

                        public void onResponseSuccess(String str) {
                            if (str != null) {
                                try {
                                    if (!TextUtils.isEmpty(str)) {
                                        JSONObject jSONObject = new JSONObject(str);
                                        JSONObject optJSONObject = jSONObject.optJSONObject("status");
                                        if (optJSONObject == null) {
                                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                            return;
                                        } else if (optJSONObject.optInt("code") != 200) {
                                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                            return;
                                        } else if (jSONObject.optJSONObject("payload") != null) {
                                            JSONObject optJSONObject2 = jSONObject.optJSONObject("payload");
                                            if (optJSONObject2 != null) {
                                                RazorPayCustomPayments.this.mOrderId = optJSONObject2.optString(RoutingConstants.KILLBILL_RAZORPAY_RZP_ORDER_ID, "");
                                                RazorPayCustomPayments.this.mRzpKey = optJSONObject2.optString(PaymentConstants.CLIENT_ID_CAMEL, "");
                                                if (optJSONObject2.has(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER)) {
                                                    RazorPayCustomPayments.this.mNumber = optJSONObject2.optString(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, "");
                                                }
                                                if (optJSONObject2.has("email")) {
                                                    RazorPayCustomPayments.this.mEmail = optJSONObject2.optString("email", "");
                                                }
                                                if (optJSONObject2.has("amount")) {
                                                    RazorPayCustomPayments.this.mAmount = optJSONObject2.optString("amount", "");
                                                }
                                                if (optJSONObject2.has("orderId")) {
                                                    RazorPayCustomPayments.this.mplOrderId = optJSONObject2.optString("orderId", "");
                                                }
                                                if (RazorPayCustomPayments.this.mOrderId == null || RazorPayCustomPayments.this.mRzpKey == null || RazorPayCustomPayments.this.mAmount == null || RazorPayCustomPayments.this.mplOrderId == null) {
                                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "razorpayorderId, clientId, amount, orderID can't be null");
                                                    return;
                                                }
                                                if (!TextUtils.isEmpty(RazorPayCustomPayments.this.mOrderId) && !TextUtils.isEmpty(RazorPayCustomPayments.this.mRzpKey) && !TextUtils.isEmpty(RazorPayCustomPayments.this.mAmount)) {
                                                    if (!TextUtils.isEmpty(RazorPayCustomPayments.this.mplOrderId)) {
                                                        RazorPayCustomPayments.this.startPayment(jSONObject.optJSONObject("payload"));
                                                        return;
                                                    }
                                                }
                                                RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "razorpayorderId, clientId, orderID amount can't be empty");
                                                return;
                                            }
                                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                            return;
                                        } else {
                                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                            return;
                                        }
                                    }
                                } catch (Exception e2) {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, e2.getMessage());
                                    return;
                                }
                            }
                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "Post response is null");
                        }
                    }).setHeaders(this.mHeaders);
                    json = jSONObject.toString();
                    MClient.executeAsync(headers.setPostJsonObject(json).build());
                }
            }
        } catch (Exception unused2) {
            jSONObject = jSONObject2;
            Builder headers2 = new Builder().setUrl(getUrl()).setResponseListener(new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, exc.getMessage());
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    if (str != null) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                JSONObject jSONObject = new JSONObject(str);
                                JSONObject optJSONObject = jSONObject.optJSONObject("status");
                                if (optJSONObject == null) {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                    return;
                                } else if (optJSONObject.optInt("code") != 200) {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                    return;
                                } else if (jSONObject.optJSONObject("payload") != null) {
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("payload");
                                    if (optJSONObject2 != null) {
                                        RazorPayCustomPayments.this.mOrderId = optJSONObject2.optString(RoutingConstants.KILLBILL_RAZORPAY_RZP_ORDER_ID, "");
                                        RazorPayCustomPayments.this.mRzpKey = optJSONObject2.optString(PaymentConstants.CLIENT_ID_CAMEL, "");
                                        if (optJSONObject2.has(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER)) {
                                            RazorPayCustomPayments.this.mNumber = optJSONObject2.optString(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, "");
                                        }
                                        if (optJSONObject2.has("email")) {
                                            RazorPayCustomPayments.this.mEmail = optJSONObject2.optString("email", "");
                                        }
                                        if (optJSONObject2.has("amount")) {
                                            RazorPayCustomPayments.this.mAmount = optJSONObject2.optString("amount", "");
                                        }
                                        if (optJSONObject2.has("orderId")) {
                                            RazorPayCustomPayments.this.mplOrderId = optJSONObject2.optString("orderId", "");
                                        }
                                        if (RazorPayCustomPayments.this.mOrderId == null || RazorPayCustomPayments.this.mRzpKey == null || RazorPayCustomPayments.this.mAmount == null || RazorPayCustomPayments.this.mplOrderId == null) {
                                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "razorpayorderId, clientId, amount, orderID can't be null");
                                            return;
                                        }
                                        if (!TextUtils.isEmpty(RazorPayCustomPayments.this.mOrderId) && !TextUtils.isEmpty(RazorPayCustomPayments.this.mRzpKey) && !TextUtils.isEmpty(RazorPayCustomPayments.this.mAmount)) {
                                            if (!TextUtils.isEmpty(RazorPayCustomPayments.this.mplOrderId)) {
                                                RazorPayCustomPayments.this.startPayment(jSONObject.optJSONObject("payload"));
                                                return;
                                            }
                                        }
                                        RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "razorpayorderId, clientId, orderID amount can't be empty");
                                        return;
                                    }
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                    return;
                                } else {
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                    return;
                                }
                            }
                        } catch (Exception e2) {
                            RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, e2.getMessage());
                            return;
                        }
                    }
                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "Post response is null");
                }
            }).setHeaders(this.mHeaders);
            json = jSONObject.toString();
            MClient.executeAsync(headers2.setPostJsonObject(json).build());
        }
        Builder headers22 = new Builder().setUrl(getUrl()).setResponseListener(new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, exc.getMessage());
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                if (str != null) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            JSONObject optJSONObject = jSONObject.optJSONObject("status");
                            if (optJSONObject == null) {
                                RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                return;
                            } else if (optJSONObject.optInt("code") != 200) {
                                RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                return;
                            } else if (jSONObject.optJSONObject("payload") != null) {
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("payload");
                                if (optJSONObject2 != null) {
                                    RazorPayCustomPayments.this.mOrderId = optJSONObject2.optString(RoutingConstants.KILLBILL_RAZORPAY_RZP_ORDER_ID, "");
                                    RazorPayCustomPayments.this.mRzpKey = optJSONObject2.optString(PaymentConstants.CLIENT_ID_CAMEL, "");
                                    if (optJSONObject2.has(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER)) {
                                        RazorPayCustomPayments.this.mNumber = optJSONObject2.optString(RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER, "");
                                    }
                                    if (optJSONObject2.has("email")) {
                                        RazorPayCustomPayments.this.mEmail = optJSONObject2.optString("email", "");
                                    }
                                    if (optJSONObject2.has("amount")) {
                                        RazorPayCustomPayments.this.mAmount = optJSONObject2.optString("amount", "");
                                    }
                                    if (optJSONObject2.has("orderId")) {
                                        RazorPayCustomPayments.this.mplOrderId = optJSONObject2.optString("orderId", "");
                                    }
                                    if (RazorPayCustomPayments.this.mOrderId == null || RazorPayCustomPayments.this.mRzpKey == null || RazorPayCustomPayments.this.mAmount == null || RazorPayCustomPayments.this.mplOrderId == null) {
                                        RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "razorpayorderId, clientId, amount, orderID can't be null");
                                        return;
                                    }
                                    if (!TextUtils.isEmpty(RazorPayCustomPayments.this.mOrderId) && !TextUtils.isEmpty(RazorPayCustomPayments.this.mRzpKey) && !TextUtils.isEmpty(RazorPayCustomPayments.this.mAmount)) {
                                        if (!TextUtils.isEmpty(RazorPayCustomPayments.this.mplOrderId)) {
                                            RazorPayCustomPayments.this.startPayment(jSONObject.optJSONObject("payload"));
                                            return;
                                        }
                                    }
                                    RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "razorpayorderId, clientId, orderID amount can't be empty");
                                    return;
                                }
                                RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                return;
                            } else {
                                RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, str);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, e2.getMessage());
                        return;
                    }
                }
                RazorPayCustomPayments.this.razorPayPaymentStatusListener.onMoneyInError(1000, "Post response is null");
            }
        }).setHeaders(this.mHeaders);
        if (!(jSONObject == null || jSONObject.length() == 0 || jSONObject.toString().equals("{}"))) {
            json = jSONObject.toString();
        }
        MClient.executeAsync(headers22.setPostJsonObject(json).build());
    }
}
