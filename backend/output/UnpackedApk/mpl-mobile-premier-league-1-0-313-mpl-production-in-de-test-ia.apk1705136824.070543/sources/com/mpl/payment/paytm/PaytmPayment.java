package com.mpl.payment.paytm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.gson.Gson;
import com.mpl.MLog;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.payment.BasePayment;
import com.mpl.payment.paytm.ServerResponse.Payload.Fields;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGActivity;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import com.paytm.pgsdk.SaveReferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONObject;

public final class PaytmPayment extends BasePayment {
    public static final String TAG = "PaytmPayment";
    public String mCheckSum;
    public final Context mContext;
    public String mOrderId;
    public final PaytmPaymentTransactionCallback paymentTransactionCallback;
    public final PaymentTransactionCallbacks transactionCallbacks;

    public static final class Builder {
        public String mAmount;
        public Context mContext;
        public String mEmail;
        public ArrayList<MHeader> mHeaders;
        public String mNumber;
        public String mPaymentGatWay;
        public String mUrl;
        public PaymentTransactionCallbacks transactionCallbacks;

        public Builder addHeader(String str, String str2) {
            if (this.mHeaders == null) {
                this.mHeaders = new ArrayList<>();
            }
            this.mHeaders.add(new MHeader(str, str2));
            return this;
        }

        public PaytmPayment build() {
            if (TextUtils.isEmpty(this.mAmount)) {
                throw new NullPointerException("amount == null");
            } else if (TextUtils.isEmpty(this.mUrl)) {
                throw new NullPointerException("url == null");
            } else if (TextUtils.isEmpty(this.mNumber)) {
                throw new NullPointerException("number == null");
            } else if (this.transactionCallbacks == null) {
                throw new NullPointerException("callback == null");
            } else if (this.mContext != null) {
                return new PaytmPayment(this);
            } else {
                throw new NullPointerException("context == null");
            }
        }

        public Builder setAmount(String str) {
            this.mAmount = str;
            return this;
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setEmail(String str) {
            this.mEmail = str;
            return this;
        }

        public Builder setHeader(List<MHeader> list) {
            if (this.mHeaders == null) {
                this.mHeaders = new ArrayList<>();
            }
            this.mHeaders.addAll(list);
            return this;
        }

        public Builder setNumber(String str) {
            this.mNumber = str;
            return this;
        }

        public Builder setPaymentGatWay(String str) {
            this.mPaymentGatWay = str;
            return this;
        }

        public Builder setTransactionCallbacks(PaymentTransactionCallbacks paymentTransactionCallbacks) {
            this.transactionCallbacks = paymentTransactionCallbacks;
            return this;
        }

        public Builder setUrl(String str) {
            this.mUrl = str;
            return this;
        }
    }

    /* access modifiers changed from: private */
    public void callPaytmSdk(ServerResponse serverResponse) {
        PaytmPGService paytmPGService;
        if (serverResponse == null || serverResponse.getPayload() == null || serverResponse.getPayload().getFields() == null) {
            PaymentTransactionCallbacks paymentTransactionCallbacks = this.transactionCallbacks;
            if (paymentTransactionCallbacks != null) {
                paymentTransactionCallbacks.onPaymentFail(new NullPointerException("Server response is null"));
                return;
            }
            return;
        }
        Fields fields = serverResponse.getPayload().getFields();
        if (fields.isProduction()) {
            paytmPGService = PaytmPGService.getProductionService();
        } else {
            paytmPGService = PaytmPGService.getStagingService();
        }
        PayTmPaymentParams build = new com.mpl.payment.paytm.PayTmPaymentParams.Builder().mid(fields.getMid()).setOrderId(fields.getOrderId()).setCustId(fields.getCustomerId()).setTxnAmount(fields.getTxnAmount()).setChannelId(fields.getChannelId()).setIndustryTypeId(fields.getIndustryTypeId()).setWebsite(fields.getWebsite()).setChecksum(fields.getCheckSumHash()).setMobileNo(fields.getMobileNumber()).setCallbackUrl(fields.getCallbackUrl()).setEmail(fields.getEmail()).setPaymentModeOnly(fields.getPaymentModeOnly()).setCardType(fields.getCardType()).setBankCode(fields.getBankCode()).setPromoCampId(fields.getPromoCampId()).setTheme(fields.getTheme()).build();
        if (fields.getOrderId() != null) {
            this.mOrderId = fields.getOrderId();
        }
        if (fields.getCheckSumHash() != null) {
            this.mCheckSum = fields.getCheckSumHash();
        }
        PaytmOrder paytmOrder = new PaytmOrder(build.getParams());
        synchronized (paytmPGService) {
            paytmPGService.mOrder = paytmOrder;
        }
        Context context = this.mContext;
        PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = this.paymentTransactionCallback;
        synchronized (paytmPGService) {
            try {
                paytmPGService.enableLog(context);
                if (!TextAppearanceConfig.isNetworkAvailable(context)) {
                    paytmPGService.stopService();
                    paytmPaymentTransactionCallback.networkNotAvailable();
                } else if (paytmPGService.mOrder != null && (paytmPGService.mOrder.requestParamMap == null || paytmPGService.mOrder.requestParamMap.size() <= 0)) {
                    paytmPaymentTransactionCallback.onTransactionCancel("Invalid Params passed", null);
                    return;
                } else if (!paytmPGService.mbServiceRunning) {
                    Bundle bundle = new Bundle();
                    if (paytmPGService.mOrder != null) {
                        for (Entry next : paytmPGService.mOrder.requestParamMap.entrySet()) {
                            TextAppearanceConfig.debugLog(((String) next.getKey()) + " = " + ((String) next.getValue()));
                            bundle.putString((String) next.getKey(), (String) next.getValue());
                        }
                    }
                    TextAppearanceConfig.debugLog("Starting the Service...");
                    Intent intent = new Intent(context, PaytmPGActivity.class);
                    intent.putExtra("Parameters", bundle);
                    intent.putExtra("HIDE_HEADER", true);
                    intent.putExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", true);
                    paytmPGService.mbServiceRunning = true;
                    paytmPGService.mPaymentTransactionCallback = paytmPaymentTransactionCallback;
                    SaveReferences.getInstance().paytmPaymentTransactionCallback = paytmPaymentTransactionCallback;
                    ((Activity) context).startActivity(intent);
                    TextAppearanceConfig.debugLog("Service Started.");
                } else {
                    TextAppearanceConfig.debugLog("Service is already running.");
                }
            } catch (Exception e2) {
                paytmPGService.stopService();
                TextAppearanceConfig.printStackTrace(e2);
            }
        }
        return;
    }

    private String getAmount() {
        return this.mAmount;
    }

    private String getEmail() {
        return this.mEmail;
    }

    private String getNumber() {
        return this.mNumber;
    }

    private String getPaymentGatWay() {
        return this.mPaymentGatWay;
    }

    private String getUrl() {
        return this.mUrl;
    }

    public void initiatePayment() {
        PaytmPaymentPostForm paytmPaymentPostForm = new PaytmPaymentPostForm();
        paytmPaymentPostForm.setAmount(getAmount());
        paytmPaymentPostForm.setPaymentMethod(getPaymentGatWay());
        paytmPaymentPostForm.setNumber(getNumber());
        MClient.executeAsync(new com.mpl.network.modules.request.MOKHttpPostRequest.Builder().setUrl(getUrl()).setResponseListener(new IResponseListener<ServerResponse>() {
            public void onResponseFail(Exception exc) {
                PaytmPayment.this.transactionCallbacks.onPaymentFail(exc);
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(ServerResponse serverResponse) {
                PaytmPayment.this.callPaytmSdk(serverResponse);
            }
        }).setHeaders(this.mHeaders).setPostJsonObject(new Gson().toJson((Object) paytmPaymentPostForm)).build());
    }

    public PaytmPayment(Builder builder) {
        this.paymentTransactionCallback = new PaytmPaymentTransactionCallback() {
            public void clientAuthenticationFailed(String str) {
                PaytmPayment.this.transactionCallbacks.clientAuthenticationFailed(str);
            }

            public void networkNotAvailable() {
                PaytmPayment.this.transactionCallbacks.networkNotAvailable();
            }

            public void onBackPressedCancelTransaction() {
                PaytmPayment.this.transactionCallbacks.onBackPressedCancelTransaction();
            }

            public void onErrorLoadingWebPage(int i, String str, String str2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onErrorLoadingWebPage() called with: iniErrorCode = [");
                sb.append(i);
                sb.append("], inErrorMessage = [");
                sb.append(str);
                sb.append("], inFailingUrl = [");
                MLog.d(PaytmPayment.TAG, GeneratedOutlineSupport.outline62(sb, str2, CMapParser.MARK_END_OF_ARRAY));
                PaytmPayment.this.transactionCallbacks.onErrorLoadingWebPage(i, str, str2);
            }

            public void onTransactionCancel(String str, Bundle bundle) {
                MLog.d(PaytmPayment.TAG, "onTransactionCancel() called with: inErrorMessage = [" + str + "], inResponse = [" + bundle + CMapParser.MARK_END_OF_ARRAY);
                PaytmPayment.this.transactionCallbacks.onTransactionCancel(str, bundle);
            }

            public void onTransactionResponse(Bundle bundle) {
                PaytmPayment.this.transactionCallbacks.onTransactionResponse(bundle);
            }

            public void someUIErrorOccurred(String str) {
                PaytmPayment.this.transactionCallbacks.someUIErrorOccurred(str);
            }
        };
        this.transactionCallbacks = builder.transactionCallbacks;
        this.mContext = builder.mContext;
        this.mAmount = builder.mAmount;
        this.mNumber = builder.mNumber;
        this.mEmail = builder.mEmail;
        this.mUrl = builder.mUrl;
        this.mHeaders = builder.mHeaders;
        this.mPaymentGatWay = builder.mPaymentGatWay;
    }

    public void initiatePayment(String str) {
        PaytmPaymentPostForm paytmPaymentPostForm = new PaytmPaymentPostForm();
        paytmPaymentPostForm.setAmount(getAmount());
        paytmPaymentPostForm.setPaymentMethod(getPaymentGatWay());
        paytmPaymentPostForm.setNumber(getNumber());
        String json = new Gson().toJson((Object) paytmPaymentPostForm);
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject(json);
                    try {
                        JSONObject jSONObject3 = new JSONObject(str);
                        Iterator<String> keys = jSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject3.get(next));
                        }
                    } catch (Exception unused) {
                    }
                    jSONObject = jSONObject2;
                }
            } catch (Exception unused2) {
            }
        }
        com.mpl.network.modules.request.MOKHttpPostRequest.Builder headers = new com.mpl.network.modules.request.MOKHttpPostRequest.Builder().setUrl(getUrl()).setResponseListener(new IResponseListener<ServerResponse>() {
            public void onResponseFail(Exception exc) {
                PaytmPayment.this.transactionCallbacks.onPaymentFail(exc);
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(ServerResponse serverResponse) {
                PaytmPayment.this.callPaytmSdk(serverResponse);
            }
        }).setHeaders(this.mHeaders);
        if (!(jSONObject == null || jSONObject.length() == 0 || jSONObject.toString().equals("{}"))) {
            json = jSONObject.toString();
        }
        MClient.executeAsync(headers.setPostJsonObject(json).build());
    }
}
