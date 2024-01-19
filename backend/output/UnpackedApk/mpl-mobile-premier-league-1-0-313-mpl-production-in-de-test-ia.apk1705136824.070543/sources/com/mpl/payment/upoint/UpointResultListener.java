package com.mpl.payment.upoint;

public interface UpointResultListener {
    void onUpointPaymentFailed(Exception exc);

    void onUpointPaymentSuccess(String str);
}
