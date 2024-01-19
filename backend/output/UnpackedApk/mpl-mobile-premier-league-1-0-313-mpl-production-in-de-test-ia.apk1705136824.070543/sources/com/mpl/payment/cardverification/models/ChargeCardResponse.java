package com.mpl.payment.cardverification.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/cardverification/models/ChargeCardResponse;", "", "status", "Lcom/mpl/payment/cardverification/models/Status;", "payload", "Lcom/mpl/payment/cardverification/models/Payload;", "(Lcom/mpl/payment/cardverification/models/Status;Lcom/mpl/payment/cardverification/models/Payload;)V", "getPayload", "()Lcom/mpl/payment/cardverification/models/Payload;", "getStatus", "()Lcom/mpl/payment/cardverification/models/Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChargeCardResponse.kt */
public final class ChargeCardResponse {
    public final Payload payload;
    public final Status status;

    public ChargeCardResponse(Status status2, Payload payload2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        this.status = status2;
        this.payload = payload2;
    }

    public static /* synthetic */ ChargeCardResponse copy$default(ChargeCardResponse chargeCardResponse, Status status2, Payload payload2, int i, Object obj) {
        if ((i & 1) != 0) {
            status2 = chargeCardResponse.status;
        }
        if ((i & 2) != 0) {
            payload2 = chargeCardResponse.payload;
        }
        return chargeCardResponse.copy(status2, payload2);
    }

    public final Status component1() {
        return this.status;
    }

    public final Payload component2() {
        return this.payload;
    }

    public final ChargeCardResponse copy(Status status2, Payload payload2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        return new ChargeCardResponse(status2, payload2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.payload, r3.payload) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.mpl.payment.cardverification.models.ChargeCardResponse
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.cardverification.models.ChargeCardResponse r3 = (com.mpl.payment.cardverification.models.ChargeCardResponse) r3
            com.mpl.payment.cardverification.models.Status r0 = r2.status
            com.mpl.payment.cardverification.models.Status r1 = r3.status
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.cardverification.models.Payload r0 = r2.payload
            com.mpl.payment.cardverification.models.Payload r3 = r3.payload
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.cardverification.models.ChargeCardResponse.equals(java.lang.Object):boolean");
    }

    public final Payload getPayload() {
        return this.payload;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        Status status2 = this.status;
        int i = 0;
        int hashCode = (status2 != null ? status2.hashCode() : 0) * 31;
        Payload payload2 = this.payload;
        if (payload2 != null) {
            i = payload2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ChargeCardResponse(status=");
        outline73.append(this.status);
        outline73.append(", payload=");
        outline73.append(this.payload);
        outline73.append(")");
        return outline73.toString();
    }
}
