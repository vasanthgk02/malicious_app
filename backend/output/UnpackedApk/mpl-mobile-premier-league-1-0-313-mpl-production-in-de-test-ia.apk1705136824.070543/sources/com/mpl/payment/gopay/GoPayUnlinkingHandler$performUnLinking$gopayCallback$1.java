package com.mpl.payment.gopay;

import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutCallback;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError;
import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.paynimo.android.payment.util.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/mpl/payment/gopay/GoPayUnlinkingHandler$performUnLinking$gopayCallback$1", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutCallback;", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "onFailure", "", "error", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorResponse", "onResponse", "response", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayUnlinkingHandler.kt */
public final class GoPayUnlinkingHandler$performUnLinking$gopayCallback$1 implements GoPayCheckoutCallback<AccountResponse> {
    public final /* synthetic */ GoPayUnlinkingHandler this$0;

    public GoPayUnlinkingHandler$performUnLinking$gopayCallback$1(GoPayUnlinkingHandler goPayUnlinkingHandler) {
        this.this$0 = goPayUnlinkingHandler;
    }

    public void onFailure(GoPayCheckoutError goPayCheckoutError, AccountResponse accountResponse) {
        Intrinsics.checkNotNullParameter(goPayCheckoutError, "error");
        this.this$0.handleFailure(goPayCheckoutError, accountResponse);
    }

    public void onResponse(AccountResponse accountResponse) {
        Intrinsics.checkNotNullParameter(accountResponse, Constant.TAG_RESPONSE);
        this.this$0.handleResponse(accountResponse);
    }
}
