package com.mpl.payment.braintree;

import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.interfaces.ThreeDSecureLookupListener;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/mpl/payment/braintree/BTThreeDSHandler$doThreeDSecureRequest$1", "Lcom/braintreepayments/api/interfaces/ThreeDSecureLookupListener;", "onLookupComplete", "", "request", "Lcom/braintreepayments/api/models/ThreeDSecureRequest;", "lookup", "Lcom/braintreepayments/api/models/ThreeDSecureLookup;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: BTThreeDSHandler.kt */
public final class BTThreeDSHandler$doThreeDSecureRequest$1 implements ThreeDSecureLookupListener {
    public final /* synthetic */ BTThreeDSHandler this$0;

    public BTThreeDSHandler$doThreeDSecureRequest$1(BTThreeDSHandler bTThreeDSHandler) {
        this.this$0 = bTThreeDSHandler;
    }

    public void onLookupComplete(ThreeDSecureRequest threeDSecureRequest, ThreeDSecureLookup threeDSecureLookup) {
        k.continuePerformVerification(this.this$0.braintreeFragment, threeDSecureRequest, threeDSecureLookup);
    }
}
