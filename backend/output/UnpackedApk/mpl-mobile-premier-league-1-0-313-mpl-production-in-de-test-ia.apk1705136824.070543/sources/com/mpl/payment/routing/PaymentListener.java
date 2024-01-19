package com.mpl.payment.routing;

public interface PaymentListener {
    void onMoneyInFail();

    void onPaymentFail(Object obj);

    void onPaymentSuccess(Object obj);
}
