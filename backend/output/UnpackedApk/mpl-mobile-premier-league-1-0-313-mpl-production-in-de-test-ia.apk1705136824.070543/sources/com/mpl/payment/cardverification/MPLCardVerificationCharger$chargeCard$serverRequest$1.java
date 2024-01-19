package com.mpl.payment.cardverification;

import android.os.Handler;
import android.os.Looper;
import com.mpl.network.modules.listeners.IResponseListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/mpl/payment/cardverification/MPLCardVerificationCharger$chargeCard$serverRequest$1", "Lcom/mpl/network/modules/listeners/IResponseListener;", "", "onResponseFail", "", "ex", "Ljava/lang/Exception;", "onResponseSuccess", "response", "progressResponse", "bytesRead", "", "contentLength", "done", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLCardVerificationCharger.kt */
public final class MPLCardVerificationCharger$chargeCard$serverRequest$1 extends IResponseListener<String> {
    public final /* synthetic */ CardChargerListener $cardChargerListener;
    public final /* synthetic */ MPLCardVerificationCharger this$0;

    public MPLCardVerificationCharger$chargeCard$serverRequest$1(MPLCardVerificationCharger mPLCardVerificationCharger, CardChargerListener cardChargerListener) {
        this.this$0 = mPLCardVerificationCharger;
        this.$cardChargerListener = cardChargerListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        if (r3 != null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponseFail(java.lang.Exception r3) {
        /*
            r2 = this;
            com.mpl.payment.cardverification.CardChargerListener r0 = r2.$cardChargerListener
            if (r3 == 0) goto L_0x000b
            java.lang.String r3 = r3.getMessage()
            if (r3 == 0) goto L_0x000b
            goto L_0x0022
        L_0x000b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.mpl.payment.cardverification.MPLCardVerificationCharger r1 = r2.this$0
            java.lang.String r1 = r1.getTAG()
            r3.append(r1)
            java.lang.String r1 = " card charging failed with no message in exception"
            r3.append(r1)
            java.lang.String r3 = r3.toString()
        L_0x0022:
            r0.onError(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.cardverification.MPLCardVerificationCharger$chargeCard$serverRequest$1.onResponseFail(java.lang.Exception):void");
    }

    public void progressResponse(long j, long j2, boolean z) {
    }

    public void onResponseSuccess(String str) {
        if (str != null) {
            new Handler(Looper.getMainLooper()).post(new MPLCardVerificationCharger$chargeCard$serverRequest$1$onResponseSuccess$runnable$1(this, str));
            return;
        }
        CardChargerListener cardChargerListener = this.$cardChargerListener;
        cardChargerListener.onError(this.this$0.getTAG() + " response from link endpoint was null");
    }
}
