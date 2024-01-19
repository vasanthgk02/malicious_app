package com.mpl.payment.gopay;

import android.content.Context;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutClient;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError;
import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.mpl.payment.gopay.models.GoPayUnlinkingPayload;
import com.mpl.payment.unlinking.UnlinkingHandler;
import com.mpl.payment.unlinking.UnlinkingListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\nH\u0002R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/mpl/payment/gopay/GoPayUnlinkingHandler;", "Lcom/mpl/payment/unlinking/UnlinkingHandler;", "context", "Landroid/content/Context;", "gopayUnlinkingPayload", "Lcom/mpl/payment/gopay/models/GoPayUnlinkingPayload;", "listener", "Lcom/mpl/payment/unlinking/UnlinkingListener;", "(Landroid/content/Context;Lcom/mpl/payment/gopay/models/GoPayUnlinkingPayload;Lcom/mpl/payment/unlinking/UnlinkingListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getGopayUnlinkingPayload", "()Lcom/mpl/payment/gopay/models/GoPayUnlinkingPayload;", "getListener", "()Lcom/mpl/payment/unlinking/UnlinkingListener;", "setListener", "(Lcom/mpl/payment/unlinking/UnlinkingListener;)V", "getGoPayClient", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient;", "handleFailure", "", "error", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorResponse", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "handleResponse", "response", "performUnLinking", "sendUnlinkingResponse", "status", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayUnlinkingHandler.kt */
public final class GoPayUnlinkingHandler implements UnlinkingHandler {
    public static final String AS_DISABLED = "DISABLED";
    public static final Companion Companion = new Companion(null);
    public final String TAG = "GoPayUnlinkingHandler";
    public final Context context;
    public final GoPayUnlinkingPayload gopayUnlinkingPayload;
    public UnlinkingListener listener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/payment/gopay/GoPayUnlinkingHandler$Companion;", "", "()V", "AS_DISABLED", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoPayUnlinkingHandler.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GoPayUnlinkingHandler(Context context2, GoPayUnlinkingPayload goPayUnlinkingPayload, UnlinkingListener unlinkingListener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(goPayUnlinkingPayload, "gopayUnlinkingPayload");
        Intrinsics.checkNotNullParameter(unlinkingListener, "listener");
        this.context = context2;
        this.gopayUnlinkingPayload = goPayUnlinkingPayload;
        this.listener = unlinkingListener;
    }

    private final GoPayCheckoutClient getGoPayClient() {
        GoPayCheckoutClient goPayCheckoutClient = new GoPayCheckoutClient(this.context, this.gopayUnlinkingPayload.getMerchantId(), this.gopayUnlinkingPayload.getCallBackUrl(), this.gopayUnlinkingPayload.getMerchantServerUrl(), false);
        return goPayCheckoutClient;
    }

    /* access modifiers changed from: private */
    public final void handleFailure(GoPayCheckoutError goPayCheckoutError, AccountResponse accountResponse) {
        this.listener.onUnlinkingError(GoPayUtils.Companion.getErrorMessage(goPayCheckoutError, accountResponse));
    }

    /* access modifiers changed from: private */
    public final void handleResponse(AccountResponse accountResponse) {
        String accountStatus = accountResponse.getAccountStatus();
        if (accountStatus == null) {
            UnlinkingListener unlinkingListener = this.listener;
            unlinkingListener.onUnlinkingError(this.TAG + " account status was null when linking.");
        } else if (accountStatus.hashCode() == 1053567612 && accountStatus.equals("DISABLED")) {
            sendUnlinkingResponse("SUCCESS");
        } else {
            sendUnlinkingResponse(GopayLinkingHandler.STATUS_FAIL);
        }
    }

    private final void sendUnlinkingResponse(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", str);
        UnlinkingListener unlinkingListener = this.listener;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "successJson.toString()");
        unlinkingListener.onUnlinkingSuccessful(jSONObject2);
    }

    public final Context getContext() {
        return this.context;
    }

    public final GoPayUnlinkingPayload getGopayUnlinkingPayload() {
        return this.gopayUnlinkingPayload;
    }

    public final UnlinkingListener getListener() {
        return this.listener;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public void performUnLinking() {
        GoPayCheckoutClient.disableAccount$default(getGoPayClient(), this.gopayUnlinkingPayload.getAccountId(), new GoPayUnlinkingHandler$performUnLinking$gopayCallback$1(this), null, 4, null);
    }

    public final void setListener(UnlinkingListener unlinkingListener) {
        Intrinsics.checkNotNullParameter(unlinkingListener, "<set-?>");
        this.listener = unlinkingListener;
    }
}
