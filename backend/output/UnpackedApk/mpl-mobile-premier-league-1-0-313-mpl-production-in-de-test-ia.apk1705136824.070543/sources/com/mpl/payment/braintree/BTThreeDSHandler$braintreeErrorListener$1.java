package com.mpl.payment.braintree;

import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.mpl.payment.cardverification.ThreeDSVerificationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "kotlin.jvm.PlatformType", "onError"}, k = 3, mv = {1, 4, 2})
/* compiled from: BTThreeDSHandler.kt */
public final class BTThreeDSHandler$braintreeErrorListener$1 implements BraintreeErrorListener {
    public final /* synthetic */ BTThreeDSHandler this$0;

    public BTThreeDSHandler$braintreeErrorListener$1(BTThreeDSHandler bTThreeDSHandler) {
        this.this$0 = bTThreeDSHandler;
    }

    public final void onError(Exception exc) {
        StringBuilder sb = new StringBuilder("Error happened in Braintree custom payment");
        if (exc != null) {
            sb.append(" class name  " + exc + ".javaClass.name");
            sb.append(" message is  it.message");
            if (exc instanceof ErrorWithResponse) {
                sb.append(" errorResponse is  " + exc + ".errorResponse");
                sb.append(" error status code is: " + exc + ".statusCode");
            }
        }
        this.this$0.removeListenersAndCleanup();
        ThreeDSVerificationListener access$getThreeDSVerificationListener$p = this.this$0.threeDSVerificationListener;
        if (access$getThreeDSVerificationListener$p != null) {
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "errorMessageBuilder.toString()");
            access$getThreeDSVerificationListener$p.onError(sb2);
        }
    }
}
