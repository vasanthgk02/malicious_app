package com.mpl.payment.braintree;

import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.ThreeDSecureInfo;
import com.mpl.payment.cardverification.ThreeDSVerificationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/braintreepayments/api/models/PaymentMethodNonce;", "kotlin.jvm.PlatformType", "onPaymentMethodNonceCreated"}, k = 3, mv = {1, 4, 2})
/* compiled from: BTThreeDSHandler.kt */
public final class BTThreeDSHandler$paymentMethodNonceCreatedListener$1 implements PaymentMethodNonceCreatedListener {
    public final /* synthetic */ BTThreeDSHandler this$0;

    public BTThreeDSHandler$paymentMethodNonceCreatedListener$1(BTThreeDSHandler bTThreeDSHandler) {
        this.this$0 = bTThreeDSHandler;
    }

    public final void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
        if (paymentMethodNonce instanceof CardNonce) {
            CardNonce cardNonce = (CardNonce) paymentMethodNonce;
            ThreeDSecureInfo threeDSecureInfo = cardNonce.mThreeDSecureInfo;
            Intrinsics.checkNotNullExpressionValue(threeDSecureInfo, "it.threeDSecureInfo");
            String str = threeDSecureInfo.mEnrolled;
            Intrinsics.checkNotNullExpressionValue(str, "it.threeDSecureInfo.enrolled");
            String str2 = cardNonce.mNonce;
            if (str2 != null) {
                this.this$0.removeListenersAndCleanup();
                this.this$0.sendSuccess(str2, str);
                return;
            }
            ThreeDSVerificationListener access$getThreeDSVerificationListener$p = this.this$0.threeDSVerificationListener;
            if (access$getThreeDSVerificationListener$p != null) {
                access$getThreeDSVerificationListener$p.onError(this.this$0.TAG + " upgraded nonce was null");
                return;
            }
            return;
        }
        ThreeDSVerificationListener access$getThreeDSVerificationListener$p2 = this.this$0.threeDSVerificationListener;
        if (access$getThreeDSVerificationListener$p2 != null) {
            access$getThreeDSVerificationListener$p2.onError(this.this$0.TAG + " nonce was not a cardnonce");
        }
    }
}
