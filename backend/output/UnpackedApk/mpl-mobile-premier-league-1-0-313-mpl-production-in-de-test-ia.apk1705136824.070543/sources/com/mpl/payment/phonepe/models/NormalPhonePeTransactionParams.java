package com.mpl.payment.phonepe.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/payment/phonepe/models/NormalPhonePeTransactionParams;", "", "orderId", "", "responseType", "(Ljava/lang/String;Ljava/lang/String;)V", "getOrderId", "()Ljava/lang/String;", "getResponseType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: NormalPhonePeTransactionParams.kt */
public final class NormalPhonePeTransactionParams {
    public final String orderId;
    public final String responseType;

    public NormalPhonePeTransactionParams(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "responseType");
        this.orderId = str;
        this.responseType = str2;
    }

    public static /* synthetic */ NormalPhonePeTransactionParams copy$default(NormalPhonePeTransactionParams normalPhonePeTransactionParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = normalPhonePeTransactionParams.orderId;
        }
        if ((i & 2) != 0) {
            str2 = normalPhonePeTransactionParams.responseType;
        }
        return normalPhonePeTransactionParams.copy(str, str2);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.responseType;
    }

    public final NormalPhonePeTransactionParams copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "responseType");
        return new NormalPhonePeTransactionParams(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.responseType, r3.responseType) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams r3 = (com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams) r3
            java.lang.String r0 = r2.orderId
            java.lang.String r1 = r3.orderId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.responseType
            java.lang.String r3 = r3.responseType
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.models.NormalPhonePeTransactionParams.equals(java.lang.Object):boolean");
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.responseType;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NormalPhonePeTransactionParams(orderId=");
        outline73.append(this.orderId);
        outline73.append(", responseType=");
        return GeneratedOutlineSupport.outline62(outline73, this.responseType, ")");
    }
}
