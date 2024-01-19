package com.mpl.payment.common.config;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/mpl/payment/common/config/PaymentConfig;", "", "()V", "paymentConfigProvider", "Lcom/mpl/payment/common/config/PaymentConfigProvider;", "getPaymentConfigProvider", "()Lcom/mpl/payment/common/config/PaymentConfigProvider;", "setPaymentConfigProvider", "(Lcom/mpl/payment/common/config/PaymentConfigProvider;)V", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaymentConfig.kt */
public final class PaymentConfig {
    public static final PaymentConfig INSTANCE = new PaymentConfig();
    public static PaymentConfigProvider paymentConfigProvider;

    public final PaymentConfigProvider getPaymentConfigProvider() {
        return paymentConfigProvider;
    }

    public final void setPaymentConfigProvider(PaymentConfigProvider paymentConfigProvider2) {
        paymentConfigProvider = paymentConfigProvider2;
    }
}
