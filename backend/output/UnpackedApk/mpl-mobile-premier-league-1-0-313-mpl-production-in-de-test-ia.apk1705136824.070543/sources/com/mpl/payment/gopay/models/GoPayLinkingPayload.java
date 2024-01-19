package com.mpl.payment.gopay.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/mpl/payment/gopay/models/GoPayLinkingPayload;", "", "merchantId", "", "callBackUrl", "merchantServerUrl", "phoneNoToLink", "countryCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallBackUrl", "()Ljava/lang/String;", "getCountryCode", "getMerchantId", "getMerchantServerUrl", "getPhoneNoToLink", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayLinkingPayload.kt */
public final class GoPayLinkingPayload {
    public final String callBackUrl;
    public final String countryCode;
    public final String merchantId;
    public final String merchantServerUrl;
    public final String phoneNoToLink;

    public GoPayLinkingPayload(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str2, "callBackUrl");
        Intrinsics.checkNotNullParameter(str3, "merchantServerUrl");
        Intrinsics.checkNotNullParameter(str4, "phoneNoToLink");
        Intrinsics.checkNotNullParameter(str5, "countryCode");
        this.merchantId = str;
        this.callBackUrl = str2;
        this.merchantServerUrl = str3;
        this.phoneNoToLink = str4;
        this.countryCode = str5;
    }

    public static /* synthetic */ GoPayLinkingPayload copy$default(GoPayLinkingPayload goPayLinkingPayload, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goPayLinkingPayload.merchantId;
        }
        if ((i & 2) != 0) {
            str2 = goPayLinkingPayload.callBackUrl;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = goPayLinkingPayload.merchantServerUrl;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = goPayLinkingPayload.phoneNoToLink;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = goPayLinkingPayload.countryCode;
        }
        return goPayLinkingPayload.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.merchantId;
    }

    public final String component2() {
        return this.callBackUrl;
    }

    public final String component3() {
        return this.merchantServerUrl;
    }

    public final String component4() {
        return this.phoneNoToLink;
    }

    public final String component5() {
        return this.countryCode;
    }

    public final GoPayLinkingPayload copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str2, "callBackUrl");
        Intrinsics.checkNotNullParameter(str3, "merchantServerUrl");
        Intrinsics.checkNotNullParameter(str4, "phoneNoToLink");
        Intrinsics.checkNotNullParameter(str5, "countryCode");
        GoPayLinkingPayload goPayLinkingPayload = new GoPayLinkingPayload(str, str2, str3, str4, str5);
        return goPayLinkingPayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.countryCode, r3.countryCode) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof com.mpl.payment.gopay.models.GoPayLinkingPayload
            if (r0 == 0) goto L_0x003b
            com.mpl.payment.gopay.models.GoPayLinkingPayload r3 = (com.mpl.payment.gopay.models.GoPayLinkingPayload) r3
            java.lang.String r0 = r2.merchantId
            java.lang.String r1 = r3.merchantId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.callBackUrl
            java.lang.String r1 = r3.callBackUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.merchantServerUrl
            java.lang.String r1 = r3.merchantServerUrl
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.phoneNoToLink
            java.lang.String r1 = r3.phoneNoToLink
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.countryCode
            java.lang.String r3 = r3.countryCode
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.gopay.models.GoPayLinkingPayload.equals(java.lang.Object):boolean");
    }

    public final String getCallBackUrl() {
        return this.callBackUrl;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getMerchantServerUrl() {
        return this.merchantServerUrl;
    }

    public final String getPhoneNoToLink() {
        return this.phoneNoToLink;
    }

    public int hashCode() {
        String str = this.merchantId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.callBackUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.merchantServerUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.phoneNoToLink;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.countryCode;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GoPayLinkingPayload(merchantId=");
        outline73.append(this.merchantId);
        outline73.append(", callBackUrl=");
        outline73.append(this.callBackUrl);
        outline73.append(", merchantServerUrl=");
        outline73.append(this.merchantServerUrl);
        outline73.append(", phoneNoToLink=");
        outline73.append(this.phoneNoToLink);
        outline73.append(", countryCode=");
        return GeneratedOutlineSupport.outline62(outline73, this.countryCode, ")");
    }
}
