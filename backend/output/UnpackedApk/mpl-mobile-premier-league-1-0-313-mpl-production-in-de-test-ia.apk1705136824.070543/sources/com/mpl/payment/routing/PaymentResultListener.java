package com.mpl.payment.routing;

import java.util.HashMap;

public interface PaymentResultListener {
    void onCleverTapEvent(String str, HashMap<String, Object> hashMap);

    void onMoneyInFailed(String str);

    void onMoneyInVpnDetected(String str);

    void onPaymentFailed(Exception exc);

    void onPaymentFailed(String str);

    void onPaymentSuccessful(String str);
}
