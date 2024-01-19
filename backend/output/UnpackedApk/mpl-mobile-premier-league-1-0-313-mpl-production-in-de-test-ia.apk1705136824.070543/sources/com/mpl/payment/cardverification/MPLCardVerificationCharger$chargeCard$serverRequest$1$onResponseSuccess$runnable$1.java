package com.mpl.payment.cardverification;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: MPLCardVerificationCharger.kt */
public final class MPLCardVerificationCharger$chargeCard$serverRequest$1$onResponseSuccess$runnable$1 implements Runnable {
    public final /* synthetic */ String $response;
    public final /* synthetic */ MPLCardVerificationCharger$chargeCard$serverRequest$1 this$0;

    public MPLCardVerificationCharger$chargeCard$serverRequest$1$onResponseSuccess$runnable$1(MPLCardVerificationCharger$chargeCard$serverRequest$1 mPLCardVerificationCharger$chargeCard$serverRequest$1, String str) {
        this.this$0 = mPLCardVerificationCharger$chargeCard$serverRequest$1;
        this.$response = str;
    }

    public final void run() {
        try {
            MPLCardVerificationCharger mPLCardVerificationCharger = this.this$0.this$0;
            String str = this.$response;
            Intrinsics.checkNotNull(str);
            mPLCardVerificationCharger.processResponse(str);
        } catch (Exception e2) {
            CardChargerListener cardChargerListener = this.this$0.$cardChargerListener;
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.this$0.getTAG());
            sb.append(' ');
            String message = e2.getMessage();
            if (message == null) {
                message = "Exception when processing card charge Response";
            }
            sb.append(message);
            cardChargerListener.onError(sb.toString());
        }
    }
}
