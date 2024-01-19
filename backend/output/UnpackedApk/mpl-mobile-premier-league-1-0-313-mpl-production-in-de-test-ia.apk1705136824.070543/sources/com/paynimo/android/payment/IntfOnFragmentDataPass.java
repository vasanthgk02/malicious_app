package com.paynimo.android.payment;

import com.paynimo.android.payment.model.b;
import com.paynimo.android.payment.model.response.ResponsePayload;

public interface IntfOnFragmentDataPass {
    void cardDataFromFragment(b bVar);

    void sendResponseBackFromFragment(ResponsePayload responsePayload, int i, String str);
}
