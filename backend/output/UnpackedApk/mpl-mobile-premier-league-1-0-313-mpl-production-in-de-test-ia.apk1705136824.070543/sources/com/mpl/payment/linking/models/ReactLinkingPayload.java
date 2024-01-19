package com.mpl.payment.linking.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/payment/linking/models/ReactLinkingPayload;", "", "paymentMode", "", "paymentMethodType", "(Ljava/lang/String;Ljava/lang/String;)V", "getPaymentMethodType", "()Ljava/lang/String;", "getPaymentMode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReactLinkingPayload.kt */
public final class ReactLinkingPayload {
    public final String paymentMethodType;
    public final String paymentMode;

    public ReactLinkingPayload(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "paymentMode");
        Intrinsics.checkNotNullParameter(str2, "paymentMethodType");
        this.paymentMode = str;
        this.paymentMethodType = str2;
    }

    public static /* synthetic */ ReactLinkingPayload copy$default(ReactLinkingPayload reactLinkingPayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reactLinkingPayload.paymentMode;
        }
        if ((i & 2) != 0) {
            str2 = reactLinkingPayload.paymentMethodType;
        }
        return reactLinkingPayload.copy(str, str2);
    }

    public final String component1() {
        return this.paymentMode;
    }

    public final String component2() {
        return this.paymentMethodType;
    }

    public final ReactLinkingPayload copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "paymentMode");
        Intrinsics.checkNotNullParameter(str2, "paymentMethodType");
        return new ReactLinkingPayload(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.paymentMethodType, r3.paymentMethodType) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.mpl.payment.linking.models.ReactLinkingPayload
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.linking.models.ReactLinkingPayload r3 = (com.mpl.payment.linking.models.ReactLinkingPayload) r3
            java.lang.String r0 = r2.paymentMode
            java.lang.String r1 = r3.paymentMode
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.paymentMethodType
            java.lang.String r3 = r3.paymentMethodType
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.linking.models.ReactLinkingPayload.equals(java.lang.Object):boolean");
    }

    public final String getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public int hashCode() {
        String str = this.paymentMode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.paymentMethodType;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ReactLinkingPayload(paymentMode=");
        outline73.append(this.paymentMode);
        outline73.append(", paymentMethodType=");
        return GeneratedOutlineSupport.outline62(outline73, this.paymentMethodType, ")");
    }
}
