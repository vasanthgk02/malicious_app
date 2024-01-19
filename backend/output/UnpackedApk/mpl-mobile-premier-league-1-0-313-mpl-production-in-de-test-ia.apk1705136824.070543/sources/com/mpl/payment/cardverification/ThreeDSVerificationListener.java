package com.mpl.payment.cardverification;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/mpl/payment/cardverification/ThreeDSVerificationListener;", "", "onError", "", "error", "", "onThreeDSSuccessFull", "resultJson", "onUserCanceled", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ThreeDSVerificationListener.kt */
public interface ThreeDSVerificationListener {
    void onError(String str);

    void onThreeDSSuccessFull(String str);

    void onUserCanceled();
}
