package com.mpl.payment.cardverification;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/mpl/payment/cardverification/CardVerificationManager$doThreeDS$1", "Lcom/mpl/payment/cardverification/ThreeDSVerificationListener;", "onError", "", "error", "", "onThreeDSSuccessFull", "threeDSResultJsonString", "onUserCanceled", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardVerificationManager.kt */
public final class CardVerificationManager$doThreeDS$1 implements ThreeDSVerificationListener {
    public final /* synthetic */ boolean $isCardVerificationOn;
    public final /* synthetic */ CardVerificationManager this$0;

    public CardVerificationManager$doThreeDS$1(CardVerificationManager cardVerificationManager, boolean z) {
        this.this$0 = cardVerificationManager;
        this.$isCardVerificationOn = z;
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.this$0.sendFailedResult(str);
    }

    public void onThreeDSSuccessFull(String str) {
        Intrinsics.checkNotNullParameter(str, "threeDSResultJsonString");
        this.this$0.processThreeDSSuccess(this.$isCardVerificationOn, str);
    }

    public void onUserCanceled() {
        this.this$0.sendUserCanceledResult();
    }
}
