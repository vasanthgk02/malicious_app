package com.midtrans.sdk.gopaycheckout.core.account;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetails;", "", "phoneNumber", "", "countryCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getPhoneNumber", "redirectUrl", "getRedirectUrl", "setRedirectUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayPartnerDetails {
    @Json(name = "country_code")
    public final String countryCode;
    @Json(name = "phone_number")
    public final String phoneNumber;
    @Json(name = "redirect_url")
    public String redirectUrl;

    public GoPayPartnerDetails(String str, String str2) {
        this.phoneNumber = str;
        this.countryCode = str2;
    }

    public static /* synthetic */ GoPayPartnerDetails copy$default(GoPayPartnerDetails goPayPartnerDetails, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goPayPartnerDetails.phoneNumber;
        }
        if ((i & 2) != 0) {
            str2 = goPayPartnerDetails.countryCode;
        }
        return goPayPartnerDetails.copy(str, str2);
    }

    public final String component1() {
        return this.phoneNumber;
    }

    public final String component2() {
        return this.countryCode;
    }

    public final GoPayPartnerDetails copy(String str, String str2) {
        return new GoPayPartnerDetails(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.countryCode, r3.countryCode) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails
            if (r0 == 0) goto L_0x001d
            com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails r3 = (com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails) r3
            java.lang.String r0 = r2.phoneNumber
            java.lang.String r1 = r3.phoneNumber
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.countryCode
            java.lang.String r3 = r3.countryCode
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
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails.equals(java.lang.Object):boolean");
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public int hashCode() {
        String str = this.phoneNumber;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.countryCode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GoPayPartnerDetails(phoneNumber=");
        outline73.append(this.phoneNumber);
        outline73.append(", countryCode=");
        return GeneratedOutlineSupport.outline62(outline73, this.countryCode, ")");
    }
}
