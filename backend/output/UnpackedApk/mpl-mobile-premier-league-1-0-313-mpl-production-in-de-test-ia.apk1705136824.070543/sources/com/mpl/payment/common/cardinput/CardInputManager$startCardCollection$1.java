package com.mpl.payment.common.cardinput;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/mpl/payment/common/cardinput/CardInputManager$startCardCollection$1", "Lcom/mpl/payment/common/cardinput/CardInputRoutingListener;", "onRoutingFailed", "", "error", "", "onRoutingSuccess", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "routingPayloadJsonString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardInputManager.kt */
public final class CardInputManager$startCardCollection$1 implements CardInputRoutingListener {
    public final /* synthetic */ CardInputResultListener $cardInputResultListener;
    public final /* synthetic */ CardInputManager this$0;

    public CardInputManager$startCardCollection$1(CardInputManager cardInputManager, CardInputResultListener cardInputResultListener) {
        this.this$0 = cardInputManager;
        this.$cardInputResultListener = cardInputResultListener;
    }

    public void onRoutingFailed(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.$cardInputResultListener.onCardInputError(str);
    }

    public void onRoutingSuccess(CardInputType cardInputType, String str) {
        Intrinsics.checkNotNullParameter(cardInputType, "cardInputType");
        Intrinsics.checkNotNullParameter(str, "routingPayloadJsonString");
        this.this$0.collectCardInfo(this.$cardInputResultListener, cardInputType, str);
    }
}
