package com.mpl.payment.juspayhypersdk.customer.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/customer/model/Payload;", "", "partnerCustomerDetailList", "", "Lcom/mpl/payment/juspayhypersdk/customer/model/JuspayDetails;", "(Ljava/util/List;)V", "getPartnerCustomerDetailList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CustomerDetailsPayload.kt */
public final class Payload {
    public final List<JuspayDetails> partnerCustomerDetailList;

    public Payload(List<JuspayDetails> list) {
        Intrinsics.checkNotNullParameter(list, "partnerCustomerDetailList");
        this.partnerCustomerDetailList = list;
    }

    public static /* synthetic */ Payload copy$default(Payload payload, List<JuspayDetails> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = payload.partnerCustomerDetailList;
        }
        return payload.copy(list);
    }

    public final List<JuspayDetails> component1() {
        return this.partnerCustomerDetailList;
    }

    public final Payload copy(List<JuspayDetails> list) {
        Intrinsics.checkNotNullParameter(list, "partnerCustomerDetailList");
        return new Payload(list);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Payload) && Intrinsics.areEqual(this.partnerCustomerDetailList, ((Payload) obj).partnerCustomerDetailList));
    }

    public final List<JuspayDetails> getPartnerCustomerDetailList() {
        return this.partnerCustomerDetailList;
    }

    public int hashCode() {
        List<JuspayDetails> list = this.partnerCustomerDetailList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline64(GeneratedOutlineSupport.outline73("Payload(partnerCustomerDetailList="), this.partnerCustomerDetailList, ")");
    }
}
