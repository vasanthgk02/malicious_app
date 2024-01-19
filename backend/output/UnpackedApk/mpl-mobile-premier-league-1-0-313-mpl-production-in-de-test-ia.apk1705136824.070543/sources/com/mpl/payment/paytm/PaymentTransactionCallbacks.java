package com.mpl.payment.paytm;

import android.os.Bundle;

public interface PaymentTransactionCallbacks {
    void clientAuthenticationFailed(String str);

    void networkNotAvailable();

    void onBackPressedCancelTransaction();

    void onErrorLoadingWebPage(int i, String str, String str2);

    void onPaymentFail(Exception exc);

    void onTransactionCancel(String str, Bundle bundle);

    void onTransactionResponse(Bundle bundle);

    void someUIErrorOccurred(String str);
}
