package com.mpl.payment.gopay;

import android.app.Activity;
import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutClient;
import com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails;
import com.mpl.payment.common.PaymentProcessor;
import com.mpl.payment.gopay.models.GoPayTransactionParams;
import com.mpl.payment.routing.PaymentResultListener;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/mpl/payment/gopay/GoPayPaymentProcessor;", "Lcom/mpl/payment/common/PaymentProcessor;", "goPayTransactionParams", "Lcom/mpl/payment/gopay/models/GoPayTransactionParams;", "activity", "Landroid/app/Activity;", "(Lcom/mpl/payment/gopay/models/GoPayTransactionParams;Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "getGoPayTransactionParams", "()Lcom/mpl/payment/gopay/models/GoPayTransactionParams;", "listener", "Lcom/mpl/payment/routing/PaymentResultListener;", "getListener", "()Lcom/mpl/payment/routing/PaymentResultListener;", "setListener", "(Lcom/mpl/payment/routing/PaymentResultListener;)V", "addListener", "", "paymentResultListener", "getGoPayClient", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient;", "getTransactionDetails", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "processPayment", "sendFailed", "error", "sendPending", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayPaymentProcessor.kt */
public final class GoPayPaymentProcessor implements PaymentProcessor {
    public static final Companion Companion = new Companion(null);
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_SETTLEMENT = "SETTLEMENT";
    public final String TAG = "GoPayPaymentProcessor";
    public final Activity activity;
    public final GoPayTransactionParams goPayTransactionParams;
    public PaymentResultListener listener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/payment/gopay/GoPayPaymentProcessor$Companion;", "", "()V", "STATUS_PENDING", "", "STATUS_SETTLEMENT", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoPayPaymentProcessor.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GoPayPaymentProcessor(GoPayTransactionParams goPayTransactionParams2, Activity activity2) {
        Intrinsics.checkNotNullParameter(goPayTransactionParams2, "goPayTransactionParams");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.goPayTransactionParams = goPayTransactionParams2;
        this.activity = activity2;
    }

    private final GoPayCheckoutClient getGoPayClient() {
        Context baseContext = this.activity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "activity.baseContext");
        GoPayCheckoutClient goPayCheckoutClient = new GoPayCheckoutClient(baseContext, this.goPayTransactionParams.getMerchantId(), this.goPayTransactionParams.getCallBackUrl(), this.goPayTransactionParams.getMerchantServerUrl(), false);
        return goPayCheckoutClient;
    }

    private final TransactionDetails getTransactionDetails() {
        return new TransactionDetails(this.goPayTransactionParams.getOrderId(), Long.valueOf(this.goPayTransactionParams.getAmount()), this.goPayTransactionParams.getCurrency());
    }

    /* access modifiers changed from: private */
    public final void sendFailed(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", GopayLinkingHandler.STATUS_FAIL);
        jSONObject.put("orderId", this.goPayTransactionParams.getOrderId());
        jSONObject.put("error", str);
        PaymentResultListener paymentResultListener = this.listener;
        if (paymentResultListener != null) {
            paymentResultListener.onPaymentFailed(jSONObject.toString());
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final void sendPending() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "PENDING_POLLING");
        jSONObject.put("orderId", this.goPayTransactionParams.getOrderId());
        PaymentResultListener paymentResultListener = this.listener;
        if (paymentResultListener != null) {
            paymentResultListener.onPaymentSuccessful(jSONObject.toString());
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            throw null;
        }
    }

    public void addListener(PaymentResultListener paymentResultListener) {
        Intrinsics.checkNotNullParameter(paymentResultListener, "paymentResultListener");
        this.listener = paymentResultListener;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final GoPayTransactionParams getGoPayTransactionParams() {
        return this.goPayTransactionParams;
    }

    public final PaymentResultListener getListener() {
        PaymentResultListener paymentResultListener = this.listener;
        if (paymentResultListener != null) {
            return paymentResultListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listener");
        throw null;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public void processPayment() {
        if (this.listener != null) {
            GoPayCheckoutClient goPayClient = getGoPayClient();
            GoPayDetails goPayDetails = new GoPayDetails(this.goPayTransactionParams.getAccountId(), this.goPayTransactionParams.getPaymentOptionToken(), null, 4, null);
            GoPayCheckoutClient.createTransaction$default(goPayClient, this.activity, goPayDetails, getTransactionDetails(), this.goPayTransactionParams.getPhoneNumber(), EmptyList.INSTANCE, new GoPayPaymentProcessor$processPayment$goPayCallback$1(this), null, 64, null);
            return;
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " listener not attached Can't process payment"));
    }

    public final void setListener(PaymentResultListener paymentResultListener) {
        Intrinsics.checkNotNullParameter(paymentResultListener, "<set-?>");
        this.listener = paymentResultListener;
    }
}
