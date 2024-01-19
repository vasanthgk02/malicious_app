package com.mpl.payment.phonepe.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.braintree.BraintreeConstants;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/mpl/payment/phonepe/models/CompleteDepositPayload;", "", "paymentId", "", "plugin", "ticketType", "nonce", "extraInfo", "Lcom/mpl/payment/phonepe/models/PhonePeExtraInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mpl/payment/phonepe/models/PhonePeExtraInfo;)V", "getExtraInfo", "()Lcom/mpl/payment/phonepe/models/PhonePeExtraInfo;", "getNonce", "()Ljava/lang/String;", "getPaymentId", "getPlugin", "getTicketType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompleteDepositPayload.kt */
public final class CompleteDepositPayload {
    public final PhonePeExtraInfo extraInfo;
    public final String nonce;
    public final String paymentId;
    public final String plugin;
    public final String ticketType;

    public CompleteDepositPayload(String str, String str2, String str3, String str4, PhonePeExtraInfo phonePeExtraInfo) {
        Intrinsics.checkNotNullParameter(str, BraintreeConstants.NS_MPL_ORDER_ID);
        Intrinsics.checkNotNullParameter(str2, "plugin");
        Intrinsics.checkNotNullParameter(str3, "ticketType");
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(phonePeExtraInfo, BraintreeConstants.NS_EXTRAINFO);
        this.paymentId = str;
        this.plugin = str2;
        this.ticketType = str3;
        this.nonce = str4;
        this.extraInfo = phonePeExtraInfo;
    }

    public static /* synthetic */ CompleteDepositPayload copy$default(CompleteDepositPayload completeDepositPayload, String str, String str2, String str3, String str4, PhonePeExtraInfo phonePeExtraInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = completeDepositPayload.paymentId;
        }
        if ((i & 2) != 0) {
            str2 = completeDepositPayload.plugin;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = completeDepositPayload.ticketType;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = completeDepositPayload.nonce;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            phonePeExtraInfo = completeDepositPayload.extraInfo;
        }
        return completeDepositPayload.copy(str, str5, str6, str7, phonePeExtraInfo);
    }

    public final String component1() {
        return this.paymentId;
    }

    public final String component2() {
        return this.plugin;
    }

    public final String component3() {
        return this.ticketType;
    }

    public final String component4() {
        return this.nonce;
    }

    public final PhonePeExtraInfo component5() {
        return this.extraInfo;
    }

    public final CompleteDepositPayload copy(String str, String str2, String str3, String str4, PhonePeExtraInfo phonePeExtraInfo) {
        Intrinsics.checkNotNullParameter(str, BraintreeConstants.NS_MPL_ORDER_ID);
        Intrinsics.checkNotNullParameter(str2, "plugin");
        Intrinsics.checkNotNullParameter(str3, "ticketType");
        Intrinsics.checkNotNullParameter(str4, "nonce");
        Intrinsics.checkNotNullParameter(phonePeExtraInfo, BraintreeConstants.NS_EXTRAINFO);
        CompleteDepositPayload completeDepositPayload = new CompleteDepositPayload(str, str2, str3, str4, phonePeExtraInfo);
        return completeDepositPayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.extraInfo, r3.extraInfo) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof com.mpl.payment.phonepe.models.CompleteDepositPayload
            if (r0 == 0) goto L_0x003b
            com.mpl.payment.phonepe.models.CompleteDepositPayload r3 = (com.mpl.payment.phonepe.models.CompleteDepositPayload) r3
            java.lang.String r0 = r2.paymentId
            java.lang.String r1 = r3.paymentId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.plugin
            java.lang.String r1 = r3.plugin
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.ticketType
            java.lang.String r1 = r3.ticketType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.nonce
            java.lang.String r1 = r3.nonce
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            com.mpl.payment.phonepe.models.PhonePeExtraInfo r0 = r2.extraInfo
            com.mpl.payment.phonepe.models.PhonePeExtraInfo r3 = r3.extraInfo
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.phonepe.models.CompleteDepositPayload.equals(java.lang.Object):boolean");
    }

    public final PhonePeExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public final String getPlugin() {
        return this.plugin;
    }

    public final String getTicketType() {
        return this.ticketType;
    }

    public int hashCode() {
        String str = this.paymentId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.plugin;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ticketType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nonce;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        PhonePeExtraInfo phonePeExtraInfo = this.extraInfo;
        if (phonePeExtraInfo != null) {
            i = phonePeExtraInfo.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CompleteDepositPayload(paymentId=");
        outline73.append(this.paymentId);
        outline73.append(", plugin=");
        outline73.append(this.plugin);
        outline73.append(", ticketType=");
        outline73.append(this.ticketType);
        outline73.append(", nonce=");
        outline73.append(this.nonce);
        outline73.append(", extraInfo=");
        outline73.append(this.extraInfo);
        outline73.append(")");
        return outline73.toString();
    }

    public /* synthetic */ CompleteDepositPayload(String str, String str2, String str3, String str4, PhonePeExtraInfo phonePeExtraInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RoutingConstants.MI_PLUGIN_VALUE_PHONEPE : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, phonePeExtraInfo);
    }
}
