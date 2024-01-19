package com.mpl.payment.common.cardinput;

import com.mpl.payment.common.cardinput.models.CardInputResult;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/mpl/payment/common/cardinput/CardInputResultListener;", "", "onCardInputError", "", "error", "", "onCardInputFailed", "failJson", "onCardInputSuccessFull", "cardInputResult", "Lcom/mpl/payment/common/cardinput/models/CardInputResult;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardInputResultListener.kt */
public interface CardInputResultListener {
    void onCardInputError(String str);

    void onCardInputFailed(String str);

    void onCardInputSuccessFull(CardInputResult cardInputResult);
}
