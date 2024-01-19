package com.mpl.payment.cardverification.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/mpl/payment/cardverification/models/ChargeCardPayload;", "", "paymentMethod", "", "paymentMethodInfo", "Lcom/mpl/payment/cardverification/models/PaymentMethodInfo;", "paymentType", "linkStage", "(Ljava/lang/String;Lcom/mpl/payment/cardverification/models/PaymentMethodInfo;Ljava/lang/String;Ljava/lang/String;)V", "getLinkStage", "()Ljava/lang/String;", "getPaymentMethod", "getPaymentMethodInfo", "()Lcom/mpl/payment/cardverification/models/PaymentMethodInfo;", "getPaymentType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChargeCardPayload.kt */
public final class ChargeCardPayload {
    public final String linkStage;
    public final String paymentMethod;
    public final PaymentMethodInfo paymentMethodInfo;
    public final String paymentType;

    public ChargeCardPayload(String str, PaymentMethodInfo paymentMethodInfo2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "paymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodInfo2, "paymentMethodInfo");
        Intrinsics.checkNotNullParameter(str2, "paymentType");
        Intrinsics.checkNotNullParameter(str3, "linkStage");
        this.paymentMethod = str;
        this.paymentMethodInfo = paymentMethodInfo2;
        this.paymentType = str2;
        this.linkStage = str3;
    }

    public static /* synthetic */ ChargeCardPayload copy$default(ChargeCardPayload chargeCardPayload, String str, PaymentMethodInfo paymentMethodInfo2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chargeCardPayload.paymentMethod;
        }
        if ((i & 2) != 0) {
            paymentMethodInfo2 = chargeCardPayload.paymentMethodInfo;
        }
        if ((i & 4) != 0) {
            str2 = chargeCardPayload.paymentType;
        }
        if ((i & 8) != 0) {
            str3 = chargeCardPayload.linkStage;
        }
        return chargeCardPayload.copy(str, paymentMethodInfo2, str2, str3);
    }

    public final String component1() {
        return this.paymentMethod;
    }

    public final PaymentMethodInfo component2() {
        return this.paymentMethodInfo;
    }

    public final String component3() {
        return this.paymentType;
    }

    public final String component4() {
        return this.linkStage;
    }

    public final ChargeCardPayload copy(String str, PaymentMethodInfo paymentMethodInfo2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "paymentMethod");
        Intrinsics.checkNotNullParameter(paymentMethodInfo2, "paymentMethodInfo");
        Intrinsics.checkNotNullParameter(str2, "paymentType");
        Intrinsics.checkNotNullParameter(str3, "linkStage");
        return new ChargeCardPayload(str, paymentMethodInfo2, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.linkStage, r3.linkStage) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof com.mpl.payment.cardverification.models.ChargeCardPayload
            if (r0 == 0) goto L_0x0031
            com.mpl.payment.cardverification.models.ChargeCardPayload r3 = (com.mpl.payment.cardverification.models.ChargeCardPayload) r3
            java.lang.String r0 = r2.paymentMethod
            java.lang.String r1 = r3.paymentMethod
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            com.mpl.payment.cardverification.models.PaymentMethodInfo r0 = r2.paymentMethodInfo
            com.mpl.payment.cardverification.models.PaymentMethodInfo r1 = r3.paymentMethodInfo
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.paymentType
            java.lang.String r1 = r3.paymentType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.linkStage
            java.lang.String r3 = r3.linkStage
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.cardverification.models.ChargeCardPayload.equals(java.lang.Object):boolean");
    }

    public final String getLinkStage() {
        return this.linkStage;
    }

    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    public final PaymentMethodInfo getPaymentMethodInfo() {
        return this.paymentMethodInfo;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public int hashCode() {
        String str = this.paymentMethod;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        PaymentMethodInfo paymentMethodInfo2 = this.paymentMethodInfo;
        int hashCode2 = (hashCode + (paymentMethodInfo2 != null ? paymentMethodInfo2.hashCode() : 0)) * 31;
        String str2 = this.paymentType;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.linkStage;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ChargeCardPayload(paymentMethod=");
        outline73.append(this.paymentMethod);
        outline73.append(", paymentMethodInfo=");
        outline73.append(this.paymentMethodInfo);
        outline73.append(", paymentType=");
        outline73.append(this.paymentType);
        outline73.append(", linkStage=");
        return GeneratedOutlineSupport.outline62(outline73, this.linkStage, ")");
    }

    public /* synthetic */ ChargeCardPayload(String str, PaymentMethodInfo paymentMethodInfo2, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "CARD" : str, paymentMethodInfo2, (i & 4) != 0 ? "Deposit" : str2, (i & 8) != 0 ? "INITIATE" : str3);
    }
}
