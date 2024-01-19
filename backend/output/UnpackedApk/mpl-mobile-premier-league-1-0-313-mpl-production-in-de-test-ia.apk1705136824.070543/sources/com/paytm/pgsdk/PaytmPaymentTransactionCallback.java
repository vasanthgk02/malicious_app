package com.paytm.pgsdk;

import android.os.Bundle;

public interface PaytmPaymentTransactionCallback {
    void networkNotAvailable();

    void onBackPressedCancelTransaction();

    void onErrorLoadingWebPage(int i, String str, String str2);

    void onTransactionCancel(String str, Bundle bundle);

    void onTransactionResponse(Bundle bundle);

    void someUIErrorOccurred(String str);
}
