package com.mpl.payment.razorpay;

import com.razorpay.PaymentData;

public interface RazorpaymentsListener {
    void onPaymentFail(int i, String str, PaymentData paymentData);

    void onSuccessfulPayment(String str, PaymentData paymentData);
}
