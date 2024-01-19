package com.mpl.payment.razorpay;

import com.razorpay.PaymentData;

public interface RazorPayPaymentStatusListener {
    void onMoneyInError(int i, String str);

    void onRazorPayPaymentFailed(int i, String str, PaymentData paymentData, String str2);

    void onRazorPayPaymentSuccessful(String str, PaymentData paymentData, String str2);
}
