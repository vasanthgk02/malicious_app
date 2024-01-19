package com.mpl.payment.juspayhypersdk.customer.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/customer/model/CustomerDetailsPayload;", "", "payload", "Lcom/mpl/payment/juspayhypersdk/customer/model/Payload;", "(Lcom/mpl/payment/juspayhypersdk/customer/model/Payload;)V", "getPayload", "()Lcom/mpl/payment/juspayhypersdk/customer/model/Payload;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CustomerDetailsPayload.kt */
public final class CustomerDetailsPayload {
    public final Payload payload;

    public CustomerDetailsPayload(Payload payload2) {
        Intrinsics.checkNotNullParameter(payload2, "payload");
        this.payload = payload2;
    }

    public static /* synthetic */ CustomerDetailsPayload copy$default(CustomerDetailsPayload customerDetailsPayload, Payload payload2, int i, Object obj) {
        if ((i & 1) != 0) {
            payload2 = customerDetailsPayload.payload;
        }
        return customerDetailsPayload.copy(payload2);
    }

    public final Payload component1() {
        return this.payload;
    }

    public final CustomerDetailsPayload copy(Payload payload2) {
        Intrinsics.checkNotNullParameter(payload2, "payload");
        return new CustomerDetailsPayload(payload2);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof CustomerDetailsPayload) && Intrinsics.areEqual(this.payload, ((CustomerDetailsPayload) obj).payload));
    }

    public final Payload getPayload() {
        return this.payload;
    }

    public int hashCode() {
        Payload payload2 = this.payload;
        if (payload2 != null) {
            return payload2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CustomerDetailsPayload(payload=");
        outline73.append(this.payload);
        outline73.append(")");
        return outline73.toString();
    }
}
