package com.mpl.payment.cardverification;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/mpl/payment/cardverification/CardChargerListener;", "", "onCardCharged", "", "sessionId", "", "onError", "error", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardChargerListener.kt */
public interface CardChargerListener {
    void onCardCharged(String str);

    void onError(String str);
}
