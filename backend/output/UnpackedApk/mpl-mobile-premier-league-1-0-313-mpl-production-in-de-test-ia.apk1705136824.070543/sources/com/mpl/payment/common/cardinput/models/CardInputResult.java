package com.mpl.payment.common.cardinput.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.common.cardinput.CardInputType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/mpl/payment/common/cardinput/models/CardInputResult;", "", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "tokenizationResultJsonString", "", "routingPayloadJsonString", "nonUpgradedCardToken", "paymentMode", "(Lcom/mpl/payment/common/cardinput/CardInputType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardInputType", "()Lcom/mpl/payment/common/cardinput/CardInputType;", "getNonUpgradedCardToken", "()Ljava/lang/String;", "getPaymentMode", "getRoutingPayloadJsonString", "getTokenizationResultJsonString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardInputResult.kt */
public final class CardInputResult {
    public final CardInputType cardInputType;
    public final String nonUpgradedCardToken;
    public final String paymentMode;
    public final String routingPayloadJsonString;
    public final String tokenizationResultJsonString;

    public CardInputResult(CardInputType cardInputType2, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(cardInputType2, "cardInputType");
        Intrinsics.checkNotNullParameter(str, "tokenizationResultJsonString");
        Intrinsics.checkNotNullParameter(str2, "routingPayloadJsonString");
        Intrinsics.checkNotNullParameter(str3, "nonUpgradedCardToken");
        Intrinsics.checkNotNullParameter(str4, "paymentMode");
        this.cardInputType = cardInputType2;
        this.tokenizationResultJsonString = str;
        this.routingPayloadJsonString = str2;
        this.nonUpgradedCardToken = str3;
        this.paymentMode = str4;
    }

    public static /* synthetic */ CardInputResult copy$default(CardInputResult cardInputResult, CardInputType cardInputType2, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            cardInputType2 = cardInputResult.cardInputType;
        }
        if ((i & 2) != 0) {
            str = cardInputResult.tokenizationResultJsonString;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = cardInputResult.routingPayloadJsonString;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = cardInputResult.nonUpgradedCardToken;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = cardInputResult.paymentMode;
        }
        return cardInputResult.copy(cardInputType2, str5, str6, str7, str4);
    }

    public final CardInputType component1() {
        return this.cardInputType;
    }

    public final String component2() {
        return this.tokenizationResultJsonString;
    }

    public final String component3() {
        return this.routingPayloadJsonString;
    }

    public final String component4() {
        return this.nonUpgradedCardToken;
    }

    public final String component5() {
        return this.paymentMode;
    }

    public final CardInputResult copy(CardInputType cardInputType2, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(cardInputType2, "cardInputType");
        Intrinsics.checkNotNullParameter(str, "tokenizationResultJsonString");
        Intrinsics.checkNotNullParameter(str2, "routingPayloadJsonString");
        Intrinsics.checkNotNullParameter(str3, "nonUpgradedCardToken");
        Intrinsics.checkNotNullParameter(str4, "paymentMode");
        CardInputResult cardInputResult = new CardInputResult(cardInputType2, str, str2, str3, str4);
        return cardInputResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.paymentMode, r3.paymentMode) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof com.mpl.payment.common.cardinput.models.CardInputResult
            if (r0 == 0) goto L_0x003b
            com.mpl.payment.common.cardinput.models.CardInputResult r3 = (com.mpl.payment.common.cardinput.models.CardInputResult) r3
            com.mpl.payment.common.cardinput.CardInputType r0 = r2.cardInputType
            com.mpl.payment.common.cardinput.CardInputType r1 = r3.cardInputType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.tokenizationResultJsonString
            java.lang.String r1 = r3.tokenizationResultJsonString
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.routingPayloadJsonString
            java.lang.String r1 = r3.routingPayloadJsonString
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.nonUpgradedCardToken
            java.lang.String r1 = r3.nonUpgradedCardToken
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.paymentMode
            java.lang.String r3 = r3.paymentMode
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            return r3
        L_0x003d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.common.cardinput.models.CardInputResult.equals(java.lang.Object):boolean");
    }

    public final CardInputType getCardInputType() {
        return this.cardInputType;
    }

    public final String getNonUpgradedCardToken() {
        return this.nonUpgradedCardToken;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getRoutingPayloadJsonString() {
        return this.routingPayloadJsonString;
    }

    public final String getTokenizationResultJsonString() {
        return this.tokenizationResultJsonString;
    }

    public int hashCode() {
        CardInputType cardInputType2 = this.cardInputType;
        int i = 0;
        int hashCode = (cardInputType2 != null ? cardInputType2.hashCode() : 0) * 31;
        String str = this.tokenizationResultJsonString;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.routingPayloadJsonString;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nonUpgradedCardToken;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.paymentMode;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CardInputResult(cardInputType=");
        outline73.append(this.cardInputType);
        outline73.append(", tokenizationResultJsonString=");
        outline73.append(this.tokenizationResultJsonString);
        outline73.append(", routingPayloadJsonString=");
        outline73.append(this.routingPayloadJsonString);
        outline73.append(", nonUpgradedCardToken=");
        outline73.append(this.nonUpgradedCardToken);
        outline73.append(", paymentMode=");
        return GeneratedOutlineSupport.outline62(outline73, this.paymentMode, ")");
    }
}
