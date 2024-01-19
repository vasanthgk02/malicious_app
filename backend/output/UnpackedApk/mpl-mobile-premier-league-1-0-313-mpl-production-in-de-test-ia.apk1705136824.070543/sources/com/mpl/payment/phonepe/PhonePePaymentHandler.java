package com.mpl.payment.phonepe;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.common.CompleteDepositEndPoint;
import com.mpl.payment.common.PaymentHandler;
import com.mpl.payment.common.TransactionParamsCreator;
import com.mpl.payment.gopay.GopayLinkingHandler;
import com.mpl.payment.phonepe.models.CompleteDepositPayload;
import com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams;
import com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams;
import com.mpl.payment.phonepe.models.PhonePeExtraInfo;
import com.mpl.payment.routing.PaymentResultListener;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 82\u00020\u0001:\u00018BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011J\b\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020)2\u0006\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020\tH\u0002J\u0010\u00102\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020.H\u0016R\u0014\u0010\u0012\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0014¨\u00069"}, d2 = {"Lcom/mpl/payment/phonepe/PhonePePaymentHandler;", "Lcom/mpl/payment/common/PaymentHandler;", "paymentResultListener", "Lcom/mpl/payment/routing/PaymentResultListener;", "activity", "Landroid/app/Activity;", "moshi", "Lcom/squareup/moshi/Moshi;", "phonePeMoneyInPayloadString", "", "phonePeReactPayloadString", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "authTokenProvider", "Lcom/mpl/payment/common/AuthTokenProvider;", "phonePeVersionCode", "(Lcom/mpl/payment/routing/PaymentResultListener;Landroid/app/Activity;Lcom/squareup/moshi/Moshi;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/mpl/payment/common/AuthTokenProvider;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "getAuthTokenProvider", "()Lcom/mpl/payment/common/AuthTokenProvider;", "deeplinkPhonePeTransactionParams", "Lcom/mpl/payment/phonepe/models/DeeplinkPhonePeTransactionParams;", "getDeeplinkPhonePeTransactionParams", "()Lcom/mpl/payment/phonepe/models/DeeplinkPhonePeTransactionParams;", "setDeeplinkPhonePeTransactionParams", "(Lcom/mpl/payment/phonepe/models/DeeplinkPhonePeTransactionParams;)V", "getHeaders", "()Ljava/util/List;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getPaymentResultListener", "()Lcom/mpl/payment/routing/PaymentResultListener;", "getPhonePeMoneyInPayloadString", "getPhonePeReactPayloadString", "getPhonePeVersionCode", "completePayment", "", "getReactResponseString", "status", "orderId", "getTransactionParamsCreator", "Lcom/mpl/payment/common/TransactionParamsCreator;", "processCompleteDepositPayload", "completeDepositResultPayload", "Lorg/json/JSONObject;", "processDeeplinkTransaction", "processNormalTransaction", "normalPhonePeTransactionParams", "Lcom/mpl/payment/phonepe/models/NormalPhonePeTransactionParams;", "processPayment", "phonePeTransactionTransactionParamsCreator", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePePaymentHandler.kt */
public final class PhonePePaymentHandler implements PaymentHandler {
    public static final String COMPLETE_DEPOSIT_FAIL = "FAILED";
    public static final String COMPLETE_DEPOSIT_PENDING = "PENDING";
    public static final String COMPLETE_DEPOSIT_SUCCESS = "SUCCESS";
    public static final Companion Companion = new Companion(null);
    public static final String TRANSACTION_FAIL = "FAILED";
    public static final String TRANSACTION_PENDING = "PENDING";
    public static final String TRANSACTION_SUCCESS = "SUCCESS";
    public final String TAG = "PhonePePayment";
    public final Activity activity;
    public final AuthTokenProvider authTokenProvider;
    public DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams;
    public final List<MHeader> headers;
    public final Moshi moshi;
    public final PaymentResultListener paymentResultListener;
    public final String phonePeMoneyInPayloadString;
    public final String phonePeReactPayloadString;
    public final String phonePeVersionCode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mpl/payment/phonepe/PhonePePaymentHandler$Companion;", "", "()V", "COMPLETE_DEPOSIT_FAIL", "", "COMPLETE_DEPOSIT_PENDING", "COMPLETE_DEPOSIT_SUCCESS", "TRANSACTION_FAIL", "TRANSACTION_PENDING", "TRANSACTION_SUCCESS", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhonePePaymentHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PhonePePaymentHandler(PaymentResultListener paymentResultListener2, Activity activity2, Moshi moshi2, String str, String str2, List<MHeader> list, AuthTokenProvider authTokenProvider2, String str3) {
        Intrinsics.checkNotNullParameter(paymentResultListener2, "paymentResultListener");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(str, "phonePeMoneyInPayloadString");
        Intrinsics.checkNotNullParameter(str2, "phonePeReactPayloadString");
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        Intrinsics.checkNotNullParameter(authTokenProvider2, "authTokenProvider");
        Intrinsics.checkNotNullParameter(str3, "phonePeVersionCode");
        this.paymentResultListener = paymentResultListener2;
        this.activity = activity2;
        this.moshi = moshi2;
        this.phonePeMoneyInPayloadString = str;
        this.phonePeReactPayloadString = str2;
        this.headers = list;
        this.authTokenProvider = authTokenProvider2;
        this.phonePeVersionCode = str3;
    }

    private final String getReactResponseString(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", str);
        jSONObject.put("orderId", str2);
        jSONObject.put("mplPlugin", RoutingConstants.MI_PLUGIN_VALUE_PHONEPE);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "reactResponse.toString()");
        return jSONObject2;
    }

    /* access modifiers changed from: private */
    public final void processCompleteDepositPayload(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("status", "");
        Intrinsics.checkNotNullExpressionValue(optString, "status");
        if (optString.length() > 0) {
            int hashCode = optString.hashCode();
            if (hashCode != -1149187101) {
                if (hashCode != 35394935) {
                    if (hashCode == 2066319421 && optString.equals("FAILED")) {
                        this.paymentResultListener.onPaymentSuccessful(getReactResponseString(GopayLinkingHandler.STATUS_FAIL, str));
                        return;
                    }
                } else if (optString.equals("PENDING")) {
                    this.paymentResultListener.onPaymentSuccessful(getReactResponseString("PENDING", str));
                    return;
                }
            } else if (optString.equals("SUCCESS")) {
                this.paymentResultListener.onPaymentSuccessful(getReactResponseString("SUCCESS", str));
                return;
            }
            PaymentResultListener paymentResultListener2 = this.paymentResultListener;
            paymentResultListener2.onMoneyInFailed("Unknown status in complete deposit-->" + optString);
        }
    }

    private final void processDeeplinkTransaction(DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams2) {
        this.deeplinkPhonePeTransactionParams = deeplinkPhonePeTransactionParams2;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(deeplinkPhonePeTransactionParams2.getDeeplink()));
        PackageManager packageManager = this.activity.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "activity.packageManager");
        if (intent.resolveActivity(packageManager) != null) {
            this.activity.startActivityForResult(intent, deeplinkPhonePeTransactionParams2.getPhonePeRequestcode());
            return;
        }
        PaymentResultListener paymentResultListener2 = this.paymentResultListener;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Deeplink Could not be resolved-> ");
        outline73.append(deeplinkPhonePeTransactionParams2.getDeeplink());
        paymentResultListener2.onMoneyInFailed(outline73.toString());
    }

    private final void processNormalTransaction(NormalPhonePeTransactionParams normalPhonePeTransactionParams) {
        String responseType = normalPhonePeTransactionParams.getResponseType();
        int hashCode = responseType.hashCode();
        if (hashCode != -1149187101) {
            if (hashCode != 35394935) {
                if (hashCode == 2066319421 && responseType.equals("FAILED")) {
                    this.paymentResultListener.onPaymentSuccessful(getReactResponseString(GopayLinkingHandler.STATUS_FAIL, normalPhonePeTransactionParams.getOrderId()));
                    return;
                }
            } else if (responseType.equals("PENDING")) {
                this.paymentResultListener.onPaymentSuccessful(getReactResponseString("PENDING", normalPhonePeTransactionParams.getOrderId()));
                return;
            }
        } else if (responseType.equals("SUCCESS")) {
            this.paymentResultListener.onPaymentSuccessful(getReactResponseString("SUCCESS", normalPhonePeTransactionParams.getOrderId()));
            return;
        }
        this.paymentResultListener.onMoneyInFailed("Normal responseType has to be SUCCESS or FAILED");
    }

    public void completePayment() {
        JsonAdapter<CompleteDepositPayload> adapter = this.moshi.adapter(CompleteDepositPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CompleteDepositPayload::class.java)");
        DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams2 = this.deeplinkPhonePeTransactionParams;
        if (deeplinkPhonePeTransactionParams2 == null) {
            this.paymentResultListener.onMoneyInFailed("Deeplink params is null can't complete deposit");
            return;
        }
        Intrinsics.checkNotNull(deeplinkPhonePeTransactionParams2);
        CompleteDepositPayload completeDepositPayload = new CompleteDepositPayload(deeplinkPhonePeTransactionParams2.getOrderId(), null, null, null, new PhonePeExtraInfo(deeplinkPhonePeTransactionParams2.getUserAuthToken(), deeplinkPhonePeTransactionParams2.getDeviceId(), deeplinkPhonePeTransactionParams2.getPhonePeVersion()), 14, null);
        try {
            String json = adapter.toJson(completeDepositPayload);
            DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams3 = this.deeplinkPhonePeTransactionParams;
            Intrinsics.checkNotNull(deeplinkPhonePeTransactionParams3);
            String completeDepositUrl = deeplinkPhonePeTransactionParams3.getCompleteDepositUrl();
            PhonePePaymentHandler$completePayment$$inlined$let$lambda$1 phonePePaymentHandler$completePayment$$inlined$let$lambda$1 = new PhonePePaymentHandler$completePayment$$inlined$let$lambda$1(deeplinkPhonePeTransactionParams3, this, json);
            List<MHeader> headers2 = deeplinkPhonePeTransactionParams3.getHeaders();
            AuthTokenProvider authTokenProvider2 = this.authTokenProvider;
            Intrinsics.checkNotNullExpressionValue(json, "completeDepositPayloadString");
            CompleteDepositEndPoint completeDepositEndPoint = new CompleteDepositEndPoint(completeDepositUrl, phonePePaymentHandler$completePayment$$inlined$let$lambda$1, headers2, authTokenProvider2, json);
            completeDepositEndPoint.completeDeposit();
        } catch (Exception e2) {
            Exception exc = e2;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception when creating complete deposit payload ");
            String message = exc.getMessage();
            if (message == null) {
                message = "";
            }
            outline73.append(message);
            this.paymentResultListener.onMoneyInFailed(outline73.toString());
        }
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public final DeeplinkPhonePeTransactionParams getDeeplinkPhonePeTransactionParams() {
        return this.deeplinkPhonePeTransactionParams;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final PaymentResultListener getPaymentResultListener() {
        return this.paymentResultListener;
    }

    public final String getPhonePeMoneyInPayloadString() {
        return this.phonePeMoneyInPayloadString;
    }

    public final String getPhonePeReactPayloadString() {
        return this.phonePeReactPayloadString;
    }

    public final String getPhonePeVersionCode() {
        return this.phonePeVersionCode;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public TransactionParamsCreator getTransactionParamsCreator() {
        PhonePeTransactionParamsCreator phonePeTransactionParamsCreator = new PhonePeTransactionParamsCreator(this.phonePeMoneyInPayloadString, this.phonePeReactPayloadString, this.headers, this.activity, this.phonePeVersionCode, this.moshi);
        return phonePeTransactionParamsCreator;
    }

    public void processPayment(TransactionParamsCreator transactionParamsCreator) {
        Intrinsics.checkNotNullParameter(transactionParamsCreator, "phonePeTransactionTransactionParamsCreator");
        try {
            Object transactionParams = transactionParamsCreator.getTransactionParams();
            if (transactionParams instanceof NormalPhonePeTransactionParams) {
                processNormalTransaction((NormalPhonePeTransactionParams) transactionParams);
            } else if (transactionParams instanceof DeeplinkPhonePeTransactionParams) {
                processDeeplinkTransaction((DeeplinkPhonePeTransactionParams) transactionParams);
            } else {
                this.paymentResultListener.onMoneyInFailed("Unknown transaction params");
            }
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception During getting TransactionParams-> ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            outline73.append(message);
            this.paymentResultListener.onMoneyInFailed(outline73.toString());
        }
    }

    public final void setDeeplinkPhonePeTransactionParams(DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams2) {
        this.deeplinkPhonePeTransactionParams = deeplinkPhonePeTransactionParams2;
    }
}
