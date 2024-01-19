package com.mpl.payment.braintree;

import androidx.appcompat.app.AppCompatActivity;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.mpl.payment.cardverification.ThreeDSHandler;
import com.mpl.payment.cardverification.ThreeDSVerificationListener;
import com.mpl.payment.routing.RoutingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/mpl/payment/braintree/BTThreeDSHandler;", "Lcom/mpl/payment/cardverification/ThreeDSHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "clientToken", "", "nonce", "amount", "cardType", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getAmount", "()Ljava/lang/String;", "braintreeCancelListener", "Lcom/braintreepayments/api/interfaces/BraintreeCancelListener;", "braintreeErrorListener", "Lcom/braintreepayments/api/interfaces/BraintreeErrorListener;", "braintreeFragment", "Lcom/braintreepayments/api/BraintreeFragment;", "getCardType", "getClientToken", "getNonce", "paymentMethodNonceCreatedListener", "Lcom/braintreepayments/api/interfaces/PaymentMethodNonceCreatedListener;", "threeDSVerificationListener", "Lcom/mpl/payment/cardverification/ThreeDSVerificationListener;", "doThreeDSVerification", "", "doThreeDSecureRequest", "removeListenersAndCleanup", "sendSuccess", "upgradedNonce", "enrolled", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: BTThreeDSHandler.kt */
public final class BTThreeDSHandler implements ThreeDSHandler {
    public final String TAG = "BTThreeDSHandler";
    public final AppCompatActivity activity;
    public final String amount;
    public final BraintreeCancelListener braintreeCancelListener = new BTThreeDSHandler$braintreeCancelListener$1(this);
    public final BraintreeErrorListener braintreeErrorListener = new BTThreeDSHandler$braintreeErrorListener$1(this);
    public BraintreeFragment braintreeFragment;
    public final String cardType;
    public final String clientToken;
    public final String nonce;
    public final PaymentMethodNonceCreatedListener paymentMethodNonceCreatedListener = new BTThreeDSHandler$paymentMethodNonceCreatedListener$1(this);
    public ThreeDSVerificationListener threeDSVerificationListener;

    public BTThreeDSHandler(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "clientToken");
        Intrinsics.checkNotNullParameter(str2, "nonce");
        Intrinsics.checkNotNullParameter(str3, "amount");
        Intrinsics.checkNotNullParameter(str4, RoutingConstants.MI_REACT_SAVED_CARD_TYPE);
        this.activity = appCompatActivity;
        this.clientToken = str;
        this.nonce = str2;
        this.amount = str3;
        this.cardType = str4;
    }

    private final void doThreeDSecureRequest() {
        ThreeDSecureRequest threeDSecureRequest = new ThreeDSecureRequest();
        threeDSecureRequest.mAmount = this.amount;
        threeDSecureRequest.mNonce = this.nonce;
        threeDSecureRequest.mVersionRequested = "2";
        k.performVerification(this.braintreeFragment, threeDSecureRequest, new BTThreeDSHandler$doThreeDSecureRequest$1(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
        r4.braintreeFragment = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005a */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0096 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:16:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void removeListenersAndCleanup() {
        /*
            r4 = this;
            com.braintreepayments.api.BraintreeFragment r0 = r4.braintreeFragment
            if (r0 == 0) goto L_0x009c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.List r0 = r0.getListeners()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0025
            java.lang.Object r1 = r0.next()
            com.braintreepayments.api.interfaces.BraintreeListener r1 = (com.braintreepayments.api.interfaces.BraintreeListener) r1
            com.braintreepayments.api.BraintreeFragment r2 = r4.braintreeFragment
            if (r2 == 0) goto L_0x0011
            r2.removeListener(r1)
            goto L_0x0011
        L_0x0025:
            com.braintreepayments.api.BraintreeFragment r0 = r4.braintreeFragment
            r1 = 0
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r0.getTag()
            goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            androidx.appcompat.app.AppCompatActivity r2 = r4.activity
            androidx.fragment.app.FragmentManager r2 = r2.getSupportFragmentManager()
            java.lang.String r3 = "activity.supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            if (r0 == 0) goto L_0x009c
            androidx.fragment.app.Fragment r0 = r2.findFragmentByTag(r0)
            if (r0 == 0) goto L_0x009c
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            r3 = 24
            if (r0 < r3) goto L_0x0082
            androidx.fragment.app.FragmentTransaction r0 = r2.beginTransaction()     // Catch:{ IllegalStateException -> 0x006e, NullPointerException -> 0x005a, all -> 0x0096 }
            com.braintreepayments.api.BraintreeFragment r3 = r4.braintreeFragment     // Catch:{ IllegalStateException -> 0x006e, NullPointerException -> 0x005a, all -> 0x0096 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ IllegalStateException -> 0x006e, NullPointerException -> 0x005a, all -> 0x0096 }
            androidx.fragment.app.FragmentTransaction r0 = r0.remove(r3)     // Catch:{ IllegalStateException -> 0x006e, NullPointerException -> 0x005a, all -> 0x0096 }
            r0.commitNowAllowingStateLoss()     // Catch:{ IllegalStateException -> 0x006e, NullPointerException -> 0x005a, all -> 0x0096 }
            goto L_0x009a
        L_0x005a:
            androidx.fragment.app.FragmentTransaction r0 = r2.beginTransaction()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            com.braintreepayments.api.BraintreeFragment r3 = r4.braintreeFragment     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            androidx.fragment.app.FragmentTransaction r0 = r0.remove(r3)     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            r0.commitAllowingStateLoss()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            r2.executePendingTransactions()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            goto L_0x009a
        L_0x006e:
            androidx.fragment.app.FragmentTransaction r0 = r2.beginTransaction()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            com.braintreepayments.api.BraintreeFragment r3 = r4.braintreeFragment     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            androidx.fragment.app.FragmentTransaction r0 = r0.remove(r3)     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            r0.commitAllowingStateLoss()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            r2.executePendingTransactions()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            goto L_0x009a
        L_0x0082:
            androidx.fragment.app.FragmentTransaction r0 = r2.beginTransaction()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            com.braintreepayments.api.BraintreeFragment r3 = r4.braintreeFragment     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            androidx.fragment.app.FragmentTransaction r0 = r0.remove(r3)     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            r0.commitAllowingStateLoss()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            r2.executePendingTransactions()     // Catch:{ IllegalStateException -> 0x009a, all -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r0 = move-exception
            r4.braintreeFragment = r1
            throw r0
        L_0x009a:
            r4.braintreeFragment = r1
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.braintree.BTThreeDSHandler.removeListenersAndCleanup():void");
    }

    /* access modifiers changed from: private */
    public final void sendSuccess(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("upgradedNonce", str);
        jSONObject.put("is3dsPossible", Intrinsics.areEqual(str2, "Y"));
        ThreeDSVerificationListener threeDSVerificationListener2 = this.threeDSVerificationListener;
        if (threeDSVerificationListener2 != null) {
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "successJson.toString()");
            threeDSVerificationListener2.onThreeDSSuccessFull(jSONObject2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r5 != null) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doThreeDSVerification(com.mpl.payment.cardverification.ThreeDSVerificationListener r5) {
        /*
            r4 = this;
            java.lang.String r0 = "threeDSVerificationListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r4.threeDSVerificationListener = r5
            com.mpl.payment.common.config.PaymentConfig r5 = com.mpl.payment.common.config.PaymentConfig.INSTANCE
            com.mpl.payment.common.config.PaymentConfigProvider r5 = r5.getPaymentConfigProvider()
            if (r5 == 0) goto L_0x0016
            java.util.List r5 = r5.getAllowedCardTypesForBraintree3ds()
            if (r5 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            kotlin.collections.EmptyList r5 = kotlin.collections.EmptyList.INSTANCE
        L_0x0018:
            r0 = 0
            java.util.Iterator r5 = r5.iterator()
        L_0x001d:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r4.cardType
            r3 = 1
            boolean r1 = kotlin.text.CharsKt__CharKt.equals(r1, r2, r3)
            if (r1 == 0) goto L_0x001d
            r0 = 1
            goto L_0x001d
        L_0x0034:
            if (r0 == 0) goto L_0x005d
            androidx.appcompat.app.AppCompatActivity r5 = r4.activity
            java.lang.String r0 = r4.clientToken
            com.braintreepayments.api.BraintreeFragment r5 = com.braintreepayments.api.BraintreeFragment.newInstance(r5, r0)
            r4.braintreeFragment = r5
            if (r5 == 0) goto L_0x0047
            com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener r0 = r4.paymentMethodNonceCreatedListener
            r5.addListener(r0)
        L_0x0047:
            com.braintreepayments.api.BraintreeFragment r5 = r4.braintreeFragment
            if (r5 == 0) goto L_0x0050
            com.braintreepayments.api.interfaces.BraintreeErrorListener r0 = r4.braintreeErrorListener
            r5.addListener(r0)
        L_0x0050:
            com.braintreepayments.api.BraintreeFragment r5 = r4.braintreeFragment
            if (r5 == 0) goto L_0x0059
            com.braintreepayments.api.interfaces.BraintreeCancelListener r0 = r4.braintreeCancelListener
            r5.addListener(r0)
        L_0x0059:
            r4.doThreeDSecureRequest()
            goto L_0x0064
        L_0x005d:
            java.lang.String r5 = r4.nonce
            java.lang.String r0 = "N"
            r4.sendSuccess(r5, r0)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.braintree.BTThreeDSHandler.doThreeDSVerification(com.mpl.payment.cardverification.ThreeDSVerificationListener):void");
    }

    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final String getNonce() {
        return this.nonce;
    }
}
