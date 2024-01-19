package com.mpl.payment.cardverification.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/mpl/payment/cardverification/models/Payload;", "", "success", "", "data", "Lcom/mpl/payment/cardverification/models/Data;", "(Ljava/lang/Boolean;Lcom/mpl/payment/cardverification/models/Data;)V", "getData", "()Lcom/mpl/payment/cardverification/models/Data;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lcom/mpl/payment/cardverification/models/Data;)Lcom/mpl/payment/cardverification/models/Payload;", "equals", "other", "hashCode", "", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChargeCardResponse.kt */
public final class Payload {
    public final Data data;
    public final Boolean success;

    public Payload(Boolean bool, Data data2) {
        this.success = bool;
        this.data = data2;
    }

    public static /* synthetic */ Payload copy$default(Payload payload, Boolean bool, Data data2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = payload.success;
        }
        if ((i & 2) != 0) {
            data2 = payload.data;
        }
        return payload.copy(bool, data2);
    }

    public final Boolean component1() {
        return this.success;
    }

    public final Data component2() {
        return this.data;
    }

    public final Payload copy(Boolean bool, Data data2) {
        return new Payload(bool, data2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.data, r3.data) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.mpl.payment.cardverification.models.Payload
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.cardverification.models.Payload r3 = (com.mpl.payment.cardverification.models.Payload) r3
            java.lang.Boolean r0 = r2.success
            java.lang.Boolean r1 = r3.success
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.cardverification.models.Data r0 = r2.data
            com.mpl.payment.cardverification.models.Data r3 = r3.data
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.cardverification.models.Payload.equals(java.lang.Object):boolean");
    }

    public final Data getData() {
        return this.data;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        Boolean bool = this.success;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Data data2 = this.data;
        if (data2 != null) {
            i = data2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Payload(success=");
        outline73.append(this.success);
        outline73.append(", data=");
        outline73.append(this.data);
        outline73.append(")");
        return outline73.toString();
    }
}
