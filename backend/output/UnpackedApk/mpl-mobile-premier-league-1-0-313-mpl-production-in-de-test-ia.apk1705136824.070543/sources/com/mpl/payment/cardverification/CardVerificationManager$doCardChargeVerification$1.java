package com.mpl.payment.cardverification;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/mpl/payment/cardverification/CardVerificationManager$doCardChargeVerification$1", "Lcom/mpl/payment/cardverification/CardChargerListener;", "onCardCharged", "", "sessionId", "", "onError", "error", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardVerificationManager.kt */
public final class CardVerificationManager$doCardChargeVerification$1 implements CardChargerListener {
    public final /* synthetic */ String $token;
    public final /* synthetic */ CardVerificationManager this$0;

    public CardVerificationManager$doCardChargeVerification$1(CardVerificationManager cardVerificationManager, String str) {
        this.this$0 = cardVerificationManager;
        this.$token = str;
    }

    public void onCardCharged(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.this$0.sendVerificationNeededResult(str, this.$token);
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.this$0.sendFailedResult(str);
    }
}
