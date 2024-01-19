package com.mpl.payment.phonepe;

import com.mpl.payment.common.EndpointResultListener;
import com.mpl.payment.phonepe.models.DeeplinkPhonePeTransactionParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/mpl/payment/phonepe/PhonePePaymentHandler$completePayment$2$completeDepositEndpoint$1", "Lcom/mpl/payment/common/EndpointResultListener;", "onFail", "", "failReason", "", "onSuccess", "successPayload", "Lorg/json/JSONObject;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePePaymentHandler.kt */
public final class PhonePePaymentHandler$completePayment$$inlined$let$lambda$1 implements EndpointResultListener {
    public final /* synthetic */ String $completeDepositPayloadString$inlined;
    public final /* synthetic */ DeeplinkPhonePeTransactionParams $it;
    public final /* synthetic */ PhonePePaymentHandler this$0;

    public PhonePePaymentHandler$completePayment$$inlined$let$lambda$1(DeeplinkPhonePeTransactionParams deeplinkPhonePeTransactionParams, PhonePePaymentHandler phonePePaymentHandler, String str) {
        this.$it = deeplinkPhonePeTransactionParams;
        this.this$0 = phonePePaymentHandler;
        this.$completeDepositPayloadString$inlined = str;
    }

    public void onFail(final String str) {
        Intrinsics.checkNotNullParameter(str, "failReason");
        this.this$0.getActivity().runOnUiThread(new Runnable(this) {
            public final /* synthetic */ PhonePePaymentHandler$completePayment$$inlined$let$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.this$0.getPaymentResultListener().onMoneyInFailed(str);
            }
        });
    }

    public void onSuccess(final JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "successPayload");
        this.this$0.getActivity().runOnUiThread(new Runnable(this) {
            public final /* synthetic */ PhonePePaymentHandler$completePayment$$inlined$let$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                PhonePePaymentHandler$completePayment$$inlined$let$lambda$1 phonePePaymentHandler$completePayment$$inlined$let$lambda$1 = this.this$0;
                phonePePaymentHandler$completePayment$$inlined$let$lambda$1.this$0.processCompleteDepositPayload(jSONObject, phonePePaymentHandler$completePayment$$inlined$let$lambda$1.$it.getOrderId());
            }
        });
    }
}
