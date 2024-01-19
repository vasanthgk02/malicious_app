package com.mpl.payment.gopay;

import com.mpl.payment.routing.PaymentResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: GoPayPaymentProcessor.kt */
public final /* synthetic */ class GoPayPaymentProcessor$processPayment$1 extends MutablePropertyReference0Impl {
    public GoPayPaymentProcessor$processPayment$1(GoPayPaymentProcessor goPayPaymentProcessor) {
        super(goPayPaymentProcessor, GoPayPaymentProcessor.class, "listener", "getListener()Lcom/mpl/payment/routing/PaymentResultListener;", 0);
    }

    public Object get() {
        return ((GoPayPaymentProcessor) this.receiver).getListener();
    }

    public void set(Object obj) {
        ((GoPayPaymentProcessor) this.receiver).setListener((PaymentResultListener) obj);
    }
}
