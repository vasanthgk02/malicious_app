package com.mpl.payment.common;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/mpl/payment/common/PaymentHandler;", "", "completePayment", "", "getTransactionParamsCreator", "Lcom/mpl/payment/common/TransactionParamsCreator;", "processPayment", "transactionParamsCreator", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaymentHandler.kt */
public interface PaymentHandler {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* compiled from: PaymentHandler.kt */
    public static final class DefaultImpls {
        public static void completePayment(PaymentHandler paymentHandler) {
        }
    }

    void completePayment();

    TransactionParamsCreator getTransactionParamsCreator();

    void processPayment(TransactionParamsCreator transactionParamsCreator);
}
