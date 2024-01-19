package com.mpl.payment.gopay.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonClass;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/mpl/payment/gopay/models/GoPayTransactionReactPayload;", "", "amount", "", "merchantId", "accountId", "callBackUrl", "merchantServerUrl", "paymentOptionToken", "phoneNumber", "currency", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getAmount", "getCallBackUrl", "getCurrency", "getMerchantId", "getMerchantServerUrl", "getPaymentOptionToken", "getPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayTransactionReactPayload.kt */
public final class GoPayTransactionReactPayload {
    public final String accountId;
    public final String amount;
    public final String callBackUrl;
    public final String currency;
    public final String merchantId;
    public final String merchantServerUrl;
    public final String paymentOptionToken;
    public final String phoneNumber;

    public GoPayTransactionReactPayload(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "amount");
        Intrinsics.checkNotNullParameter(str2, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str3, "accountId");
        Intrinsics.checkNotNullParameter(str4, "callBackUrl");
        Intrinsics.checkNotNullParameter(str5, "merchantServerUrl");
        Intrinsics.checkNotNullParameter(str6, "paymentOptionToken");
        Intrinsics.checkNotNullParameter(str7, RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER);
        Intrinsics.checkNotNullParameter(str8, "currency");
        this.amount = str;
        this.merchantId = str2;
        this.accountId = str3;
        this.callBackUrl = str4;
        this.merchantServerUrl = str5;
        this.paymentOptionToken = str6;
        this.phoneNumber = str7;
        this.currency = str8;
    }

    public static /* synthetic */ GoPayTransactionReactPayload copy$default(GoPayTransactionReactPayload goPayTransactionReactPayload, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        GoPayTransactionReactPayload goPayTransactionReactPayload2 = goPayTransactionReactPayload;
        int i2 = i;
        return goPayTransactionReactPayload.copy((i2 & 1) != 0 ? goPayTransactionReactPayload2.amount : str, (i2 & 2) != 0 ? goPayTransactionReactPayload2.merchantId : str2, (i2 & 4) != 0 ? goPayTransactionReactPayload2.accountId : str3, (i2 & 8) != 0 ? goPayTransactionReactPayload2.callBackUrl : str4, (i2 & 16) != 0 ? goPayTransactionReactPayload2.merchantServerUrl : str5, (i2 & 32) != 0 ? goPayTransactionReactPayload2.paymentOptionToken : str6, (i2 & 64) != 0 ? goPayTransactionReactPayload2.phoneNumber : str7, (i2 & 128) != 0 ? goPayTransactionReactPayload2.currency : str8);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.merchantId;
    }

    public final String component3() {
        return this.accountId;
    }

    public final String component4() {
        return this.callBackUrl;
    }

    public final String component5() {
        return this.merchantServerUrl;
    }

    public final String component6() {
        return this.paymentOptionToken;
    }

    public final String component7() {
        return this.phoneNumber;
    }

    public final String component8() {
        return this.currency;
    }

    public final GoPayTransactionReactPayload copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "amount");
        Intrinsics.checkNotNullParameter(str2, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str3, "accountId");
        Intrinsics.checkNotNullParameter(str4, "callBackUrl");
        Intrinsics.checkNotNullParameter(str5, "merchantServerUrl");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "paymentOptionToken");
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str10, RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER);
        String str11 = str8;
        Intrinsics.checkNotNullParameter(str11, "currency");
        GoPayTransactionReactPayload goPayTransactionReactPayload = new GoPayTransactionReactPayload(str, str2, str3, str4, str5, str9, str10, str11);
        return goPayTransactionReactPayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.currency, r3.currency) != false) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x005b
            boolean r0 = r3 instanceof com.mpl.payment.gopay.models.GoPayTransactionReactPayload
            if (r0 == 0) goto L_0x0059
            com.mpl.payment.gopay.models.GoPayTransactionReactPayload r3 = (com.mpl.payment.gopay.models.GoPayTransactionReactPayload) r3
            java.lang.String r0 = r2.amount
            java.lang.String r1 = r3.amount
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r2.merchantId
            java.lang.String r1 = r3.merchantId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r2.accountId
            java.lang.String r1 = r3.accountId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r2.callBackUrl
            java.lang.String r1 = r3.callBackUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r2.merchantServerUrl
            java.lang.String r1 = r3.merchantServerUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r2.paymentOptionToken
            java.lang.String r1 = r3.paymentOptionToken
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r2.phoneNumber
            java.lang.String r1 = r3.phoneNumber
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r2.currency
            java.lang.String r3 = r3.currency
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r3 = 0
            return r3
        L_0x005b:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.gopay.models.GoPayTransactionReactPayload.equals(java.lang.Object):boolean");
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCallBackUrl() {
        return this.callBackUrl;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getMerchantServerUrl() {
        return this.merchantServerUrl;
    }

    public final String getPaymentOptionToken() {
        return this.paymentOptionToken;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        String str = this.amount;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.callBackUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.merchantServerUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.paymentOptionToken;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.phoneNumber;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.currency;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GoPayTransactionReactPayload(amount=");
        outline73.append(this.amount);
        outline73.append(", merchantId=");
        outline73.append(this.merchantId);
        outline73.append(", accountId=");
        outline73.append(this.accountId);
        outline73.append(", callBackUrl=");
        outline73.append(this.callBackUrl);
        outline73.append(", merchantServerUrl=");
        outline73.append(this.merchantServerUrl);
        outline73.append(", paymentOptionToken=");
        outline73.append(this.paymentOptionToken);
        outline73.append(", phoneNumber=");
        outline73.append(this.phoneNumber);
        outline73.append(", currency=");
        return GeneratedOutlineSupport.outline62(outline73, this.currency, ")");
    }
}
