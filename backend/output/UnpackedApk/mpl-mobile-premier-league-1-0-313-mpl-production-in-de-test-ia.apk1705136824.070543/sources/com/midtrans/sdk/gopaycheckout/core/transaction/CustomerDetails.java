package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/CustomerDetails;", "", "phone", "", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class CustomerDetails {
    @Json(name = "phone")
    public final String phone;

    public CustomerDetails(String str) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        this.phone = str;
    }

    public static /* synthetic */ CustomerDetails copy$default(CustomerDetails customerDetails, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customerDetails.phone;
        }
        return customerDetails.copy(str);
    }

    public final String component1() {
        return this.phone;
    }

    public final CustomerDetails copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        return new CustomerDetails(str);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof CustomerDetails) && Intrinsics.areEqual(this.phone, ((CustomerDetails) obj).phone));
    }

    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        String str = this.phone;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("CustomerDetails(phone="), this.phone, ")");
    }
}
