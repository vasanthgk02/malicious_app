package com.mpl.payment.common.cardinput;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/mpl/payment/common/cardinput/CardInputRoutingListener;", "", "onRoutingFailed", "", "error", "", "onRoutingSuccess", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "payloadJsonString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardInputRoutingListener.kt */
public interface CardInputRoutingListener {
    void onRoutingFailed(String str);

    void onRoutingSuccess(CardInputType cardInputType, String str);
}
