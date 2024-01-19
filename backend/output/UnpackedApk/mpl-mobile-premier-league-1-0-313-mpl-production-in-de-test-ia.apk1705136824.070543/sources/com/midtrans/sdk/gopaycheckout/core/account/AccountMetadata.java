package com.midtrans.sdk.gopaycheckout.core.account;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/AccountMetadata;", "", "paymentOptions", "", "Lcom/midtrans/sdk/gopaycheckout/core/account/PaymentOption;", "(Ljava/util/List;)V", "getPaymentOptions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class AccountMetadata {
    @Json(name = "payment_options")
    public final List<PaymentOption> paymentOptions;

    public AccountMetadata(List<PaymentOption> list) {
        this.paymentOptions = list;
    }

    public static /* synthetic */ AccountMetadata copy$default(AccountMetadata accountMetadata, List<PaymentOption> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = accountMetadata.paymentOptions;
        }
        return accountMetadata.copy(list);
    }

    public final List<PaymentOption> component1() {
        return this.paymentOptions;
    }

    public final AccountMetadata copy(List<PaymentOption> list) {
        return new AccountMetadata(list);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof AccountMetadata) && Intrinsics.areEqual(this.paymentOptions, ((AccountMetadata) obj).paymentOptions));
    }

    public final List<PaymentOption> getPaymentOptions() {
        return this.paymentOptions;
    }

    public int hashCode() {
        List<PaymentOption> list = this.paymentOptions;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline64(GeneratedOutlineSupport.outline73("AccountMetadata(paymentOptions="), this.paymentOptions, ")");
    }
}
