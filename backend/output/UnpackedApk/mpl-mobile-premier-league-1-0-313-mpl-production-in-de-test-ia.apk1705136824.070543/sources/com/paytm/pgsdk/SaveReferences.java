package com.paytm.pgsdk;

public class SaveReferences {
    public static SaveReferences keepCallbackReference;
    public boolean isProduction;
    public PaytmPaymentTransactionCallback paytmPaymentTransactionCallback;

    public static synchronized SaveReferences getInstance() {
        SaveReferences saveReferences;
        synchronized (SaveReferences.class) {
            try {
                if (keepCallbackReference == null) {
                    keepCallbackReference = new SaveReferences();
                }
                saveReferences = keepCallbackReference;
            }
        }
        return saveReferences;
    }
}
