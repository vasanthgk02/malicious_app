package com.mpl.payment.gopay.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonClass;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/mpl/payment/gopay/models/GopayTransacrionReactPayload;", "", "amount", "", "savedPaymentDetails", "Lcom/mpl/payment/gopay/models/SavedPaymentDetail;", "merchantId", "callBackUrl", "merchantServerUrl", "currency", "mobNumber", "(Ljava/lang/String;Lcom/mpl/payment/gopay/models/SavedPaymentDetail;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getCallBackUrl", "getCurrency", "getMerchantId", "getMerchantServerUrl", "getMobNumber", "getSavedPaymentDetails", "()Lcom/mpl/payment/gopay/models/SavedPaymentDetail;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GopayTransacrionReactPayload.kt */
public final class GopayTransacrionReactPayload {
    public final String amount;
    public final String callBackUrl;
    public final String currency;
    public final String merchantId;
    public final String merchantServerUrl;
    public final String mobNumber;
    public final SavedPaymentDetail savedPaymentDetails;

    public GopayTransacrionReactPayload(String str, SavedPaymentDetail savedPaymentDetail, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "amount");
        Intrinsics.checkNotNullParameter(savedPaymentDetail, "savedPaymentDetails");
        Intrinsics.checkNotNullParameter(str2, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str3, "callBackUrl");
        Intrinsics.checkNotNullParameter(str4, "merchantServerUrl");
        Intrinsics.checkNotNullParameter(str5, "currency");
        Intrinsics.checkNotNullParameter(str6, RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT);
        this.amount = str;
        this.savedPaymentDetails = savedPaymentDetail;
        this.merchantId = str2;
        this.callBackUrl = str3;
        this.merchantServerUrl = str4;
        this.currency = str5;
        this.mobNumber = str6;
    }

    public static /* synthetic */ GopayTransacrionReactPayload copy$default(GopayTransacrionReactPayload gopayTransacrionReactPayload, String str, SavedPaymentDetail savedPaymentDetail, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gopayTransacrionReactPayload.amount;
        }
        if ((i & 2) != 0) {
            savedPaymentDetail = gopayTransacrionReactPayload.savedPaymentDetails;
        }
        SavedPaymentDetail savedPaymentDetail2 = savedPaymentDetail;
        if ((i & 4) != 0) {
            str2 = gopayTransacrionReactPayload.merchantId;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = gopayTransacrionReactPayload.callBackUrl;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = gopayTransacrionReactPayload.merchantServerUrl;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = gopayTransacrionReactPayload.currency;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = gopayTransacrionReactPayload.mobNumber;
        }
        return gopayTransacrionReactPayload.copy(str, savedPaymentDetail2, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.amount;
    }

    public final SavedPaymentDetail component2() {
        return this.savedPaymentDetails;
    }

    public final String component3() {
        return this.merchantId;
    }

    public final String component4() {
        return this.callBackUrl;
    }

    public final String component5() {
        return this.merchantServerUrl;
    }

    public final String component6() {
        return this.currency;
    }

    public final String component7() {
        return this.mobNumber;
    }

    public final GopayTransacrionReactPayload copy(String str, SavedPaymentDetail savedPaymentDetail, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "amount");
        Intrinsics.checkNotNullParameter(savedPaymentDetail, "savedPaymentDetails");
        Intrinsics.checkNotNullParameter(str2, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str3, "callBackUrl");
        Intrinsics.checkNotNullParameter(str4, "merchantServerUrl");
        Intrinsics.checkNotNullParameter(str5, "currency");
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str7, RoutingConstants.MI_REACT_MOBILENO_DIRECT_CREDIT);
        GopayTransacrionReactPayload gopayTransacrionReactPayload = new GopayTransacrionReactPayload(str, savedPaymentDetail, str2, str3, str4, str5, str7);
        return gopayTransacrionReactPayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.mobNumber, r3.mobNumber) != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0051
            boolean r0 = r3 instanceof com.mpl.payment.gopay.models.GopayTransacrionReactPayload
            if (r0 == 0) goto L_0x004f
            com.mpl.payment.gopay.models.GopayTransacrionReactPayload r3 = (com.mpl.payment.gopay.models.GopayTransacrionReactPayload) r3
            java.lang.String r0 = r2.amount
            java.lang.String r1 = r3.amount
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            com.mpl.payment.gopay.models.SavedPaymentDetail r0 = r2.savedPaymentDetails
            com.mpl.payment.gopay.models.SavedPaymentDetail r1 = r3.savedPaymentDetails
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r2.merchantId
            java.lang.String r1 = r3.merchantId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r2.callBackUrl
            java.lang.String r1 = r3.callBackUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r2.merchantServerUrl
            java.lang.String r1 = r3.merchantServerUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r2.currency
            java.lang.String r1 = r3.currency
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = r2.mobNumber
            java.lang.String r3 = r3.mobNumber
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r3 = 0
            return r3
        L_0x0051:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.gopay.models.GopayTransacrionReactPayload.equals(java.lang.Object):boolean");
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

    public final String getMobNumber() {
        return this.mobNumber;
    }

    public final SavedPaymentDetail getSavedPaymentDetails() {
        return this.savedPaymentDetails;
    }

    public int hashCode() {
        String str = this.amount;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        SavedPaymentDetail savedPaymentDetail = this.savedPaymentDetails;
        int hashCode2 = (hashCode + (savedPaymentDetail != null ? savedPaymentDetail.hashCode() : 0)) * 31;
        String str2 = this.merchantId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.callBackUrl;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.merchantServerUrl;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.currency;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mobNumber;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GopayTransacrionReactPayload(amount=");
        outline73.append(this.amount);
        outline73.append(", savedPaymentDetails=");
        outline73.append(this.savedPaymentDetails);
        outline73.append(", merchantId=");
        outline73.append(this.merchantId);
        outline73.append(", callBackUrl=");
        outline73.append(this.callBackUrl);
        outline73.append(", merchantServerUrl=");
        outline73.append(this.merchantServerUrl);
        outline73.append(", currency=");
        outline73.append(this.currency);
        outline73.append(", mobNumber=");
        return GeneratedOutlineSupport.outline62(outline73, this.mobNumber, ")");
    }
}
