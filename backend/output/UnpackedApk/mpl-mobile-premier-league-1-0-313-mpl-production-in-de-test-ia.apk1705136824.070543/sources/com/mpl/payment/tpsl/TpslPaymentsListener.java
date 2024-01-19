package com.mpl.payment.tpsl;

public interface TpslPaymentsListener {
    void onTpslPaymentFailed(String str);

    void onTpslPaymentSuccess();

    void onTpslSaveCardPaymentSuccessful(String str, String str2);

    void onTpslTransactionPending();
}
