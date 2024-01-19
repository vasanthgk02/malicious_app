package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetails;", "", "accountId", "", "paymentOptionToken", "callbackUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getCallbackUrl", "setCallbackUrl", "(Ljava/lang/String;)V", "enableCallback", "", "getEnableCallback", "()Ljava/lang/Boolean;", "setEnableCallback", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPaymentOptionToken", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayDetails {
    @Json(name = "account_id")
    public final String accountId;
    @Json(name = "callback_url")
    public String callbackUrl;
    @Json(name = "enable_callback")
    public Boolean enableCallback;
    @Json(name = "payment_option_token")
    public final String paymentOptionToken;

    public GoPayDetails(String str, String str2, String str3) {
        this.accountId = str;
        this.paymentOptionToken = str2;
        this.callbackUrl = str3;
    }

    public /* synthetic */ GoPayDetails(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ GoPayDetails copy$default(GoPayDetails goPayDetails, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goPayDetails.accountId;
        }
        if ((i & 2) != 0) {
            str2 = goPayDetails.paymentOptionToken;
        }
        if ((i & 4) != 0) {
            str3 = goPayDetails.callbackUrl;
        }
        return goPayDetails.copy(str, str2, str3);
    }

    public final String component1() {
        return this.accountId;
    }

    public final String component2() {
        return this.paymentOptionToken;
    }

    public final String component3() {
        return this.callbackUrl;
    }

    public final GoPayDetails copy(String str, String str2, String str3) {
        return new GoPayDetails(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.callbackUrl, r3.callbackUrl) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails
            if (r0 == 0) goto L_0x0027
            com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails r3 = (com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails) r3
            java.lang.String r0 = r2.accountId
            java.lang.String r1 = r3.accountId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.paymentOptionToken
            java.lang.String r1 = r3.paymentOptionToken
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.callbackUrl
            java.lang.String r3 = r3.callbackUrl
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails.equals(java.lang.Object):boolean");
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    public final Boolean getEnableCallback() {
        return this.enableCallback;
    }

    public final String getPaymentOptionToken() {
        return this.paymentOptionToken;
    }

    public int hashCode() {
        String str = this.accountId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.paymentOptionToken;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.callbackUrl;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public final void setEnableCallback(Boolean bool) {
        this.enableCallback = bool;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GoPayDetails(accountId=");
        outline73.append(this.accountId);
        outline73.append(", paymentOptionToken=");
        outline73.append(this.paymentOptionToken);
        outline73.append(", callbackUrl=");
        return GeneratedOutlineSupport.outline62(outline73, this.callbackUrl, ")");
    }
}
