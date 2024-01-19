package com.mpl.payment.cardverification.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/mpl/payment/cardverification/models/CardVerificationReactPayload;", "", "amount", "", "paymentMode", "paymentMethodType", "is3DSOn", "", "isCardVerificationOn", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getAmount", "()Ljava/lang/String;", "()Z", "getPaymentMethodType", "getPaymentMode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardVerificationReactPayload.kt */
public final class CardVerificationReactPayload {
    public final String amount;
    public final boolean is3DSOn;
    public final boolean isCardVerificationOn;
    public final String paymentMethodType;
    public final String paymentMode;

    public CardVerificationReactPayload(String str, String str2, String str3, boolean z, boolean z2) {
        GeneratedOutlineSupport.outline97(str, "amount", str2, "paymentMode", str3, "paymentMethodType");
        this.amount = str;
        this.paymentMode = str2;
        this.paymentMethodType = str3;
        this.is3DSOn = z;
        this.isCardVerificationOn = z2;
    }

    public static /* synthetic */ CardVerificationReactPayload copy$default(CardVerificationReactPayload cardVerificationReactPayload, String str, String str2, String str3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardVerificationReactPayload.amount;
        }
        if ((i & 2) != 0) {
            str2 = cardVerificationReactPayload.paymentMode;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = cardVerificationReactPayload.paymentMethodType;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = cardVerificationReactPayload.is3DSOn;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = cardVerificationReactPayload.isCardVerificationOn;
        }
        return cardVerificationReactPayload.copy(str, str4, str5, z3, z2);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.paymentMode;
    }

    public final String component3() {
        return this.paymentMethodType;
    }

    public final boolean component4() {
        return this.is3DSOn;
    }

    public final boolean component5() {
        return this.isCardVerificationOn;
    }

    public final CardVerificationReactPayload copy(String str, String str2, String str3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "amount");
        Intrinsics.checkNotNullParameter(str2, "paymentMode");
        Intrinsics.checkNotNullParameter(str3, "paymentMethodType");
        CardVerificationReactPayload cardVerificationReactPayload = new CardVerificationReactPayload(str, str2, str3, z, z2);
        return cardVerificationReactPayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r2.isCardVerificationOn == r3.isCardVerificationOn) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0035
            boolean r0 = r3 instanceof com.mpl.payment.cardverification.models.CardVerificationReactPayload
            if (r0 == 0) goto L_0x0033
            com.mpl.payment.cardverification.models.CardVerificationReactPayload r3 = (com.mpl.payment.cardverification.models.CardVerificationReactPayload) r3
            java.lang.String r0 = r2.amount
            java.lang.String r1 = r3.amount
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r2.paymentMode
            java.lang.String r1 = r3.paymentMode
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r2.paymentMethodType
            java.lang.String r1 = r3.paymentMethodType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0033
            boolean r0 = r2.is3DSOn
            boolean r1 = r3.is3DSOn
            if (r0 != r1) goto L_0x0033
            boolean r0 = r2.isCardVerificationOn
            boolean r3 = r3.isCardVerificationOn
            if (r0 != r3) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = 0
            return r3
        L_0x0035:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.cardverification.models.CardVerificationReactPayload.equals(java.lang.Object):boolean");
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPaymentMethodType() {
        return this.paymentMethodType;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public int hashCode() {
        String str = this.amount;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.paymentMode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.paymentMethodType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.is3DSOn;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = (i2 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isCardVerificationOn;
        if (!z2) {
            i3 = z2;
        }
        return i4 + i3;
    }

    public final boolean is3DSOn() {
        return this.is3DSOn;
    }

    public final boolean isCardVerificationOn() {
        return this.isCardVerificationOn;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CardVerificationReactPayload(amount=");
        outline73.append(this.amount);
        outline73.append(", paymentMode=");
        outline73.append(this.paymentMode);
        outline73.append(", paymentMethodType=");
        outline73.append(this.paymentMethodType);
        outline73.append(", is3DSOn=");
        outline73.append(this.is3DSOn);
        outline73.append(", isCardVerificationOn=");
        return GeneratedOutlineSupport.outline66(outline73, this.isCardVerificationOn, ")");
    }
}
