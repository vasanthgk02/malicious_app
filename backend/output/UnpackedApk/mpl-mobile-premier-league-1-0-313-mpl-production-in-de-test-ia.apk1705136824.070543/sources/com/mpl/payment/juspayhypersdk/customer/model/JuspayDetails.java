package com.mpl.payment.juspayhypersdk.customer.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/customer/model/JuspayDetails;", "", "customerId", "", "(Ljava/lang/String;)V", "getCustomerId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CustomerDetailsPayload.kt */
public final class JuspayDetails {
    public final String customerId;

    public JuspayDetails(String str) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        this.customerId = str;
    }

    public static /* synthetic */ JuspayDetails copy$default(JuspayDetails juspayDetails, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = juspayDetails.customerId;
        }
        return juspayDetails.copy(str);
    }

    public final String component1() {
        return this.customerId;
    }

    public final JuspayDetails copy(String str) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        return new JuspayDetails(str);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof JuspayDetails) && Intrinsics.areEqual(this.customerId, ((JuspayDetails) obj).customerId));
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public int hashCode() {
        String str = this.customerId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("JuspayDetails(customerId="), this.customerId, ")");
    }
}
