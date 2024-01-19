package com.mpl.payment.braintree;

import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.mpl.payment.cardverification.ThreeDSVerificationListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "onCancel"}, k = 3, mv = {1, 4, 2})
/* compiled from: BTThreeDSHandler.kt */
public final class BTThreeDSHandler$braintreeCancelListener$1 implements BraintreeCancelListener {
    public final /* synthetic */ BTThreeDSHandler this$0;

    public BTThreeDSHandler$braintreeCancelListener$1(BTThreeDSHandler bTThreeDSHandler) {
        this.this$0 = bTThreeDSHandler;
    }

    public final void onCancel(int i) {
        this.this$0.removeListenersAndCleanup();
        ThreeDSVerificationListener access$getThreeDSVerificationListener$p = this.this$0.threeDSVerificationListener;
        if (access$getThreeDSVerificationListener$p != null) {
            access$getThreeDSVerificationListener$p.onUserCanceled();
        }
    }
}
