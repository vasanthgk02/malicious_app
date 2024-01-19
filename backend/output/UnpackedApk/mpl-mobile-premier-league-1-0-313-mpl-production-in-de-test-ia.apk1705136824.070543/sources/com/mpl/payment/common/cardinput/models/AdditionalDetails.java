package com.mpl.payment.common.cardinput.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/payment/common/cardinput/models/AdditionalDetails;", "", "binNo", "", "last4", "(Ljava/lang/String;Ljava/lang/String;)V", "getBinNo", "()Ljava/lang/String;", "getLast4", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SavedCardsModel.kt */
public final class AdditionalDetails {
    public final String binNo;
    public final String last4;

    public AdditionalDetails(String str, String str2) {
        this.binNo = str;
        this.last4 = str2;
    }

    public static /* synthetic */ AdditionalDetails copy$default(AdditionalDetails additionalDetails, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = additionalDetails.binNo;
        }
        if ((i & 2) != 0) {
            str2 = additionalDetails.last4;
        }
        return additionalDetails.copy(str, str2);
    }

    public final String component1() {
        return this.binNo;
    }

    public final String component2() {
        return this.last4;
    }

    public final AdditionalDetails copy(String str, String str2) {
        return new AdditionalDetails(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.last4, r3.last4) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.mpl.payment.common.cardinput.models.AdditionalDetails
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.common.cardinput.models.AdditionalDetails r3 = (com.mpl.payment.common.cardinput.models.AdditionalDetails) r3
            java.lang.String r0 = r2.binNo
            java.lang.String r1 = r3.binNo
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.last4
            java.lang.String r3 = r3.last4
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.common.cardinput.models.AdditionalDetails.equals(java.lang.Object):boolean");
    }

    public final String getBinNo() {
        return this.binNo;
    }

    public final String getLast4() {
        return this.last4;
    }

    public int hashCode() {
        String str = this.binNo;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.last4;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AdditionalDetails(binNo=");
        outline73.append(this.binNo);
        outline73.append(", last4=");
        return GeneratedOutlineSupport.outline62(outline73, this.last4, ")");
    }
}
