package com.mpl.payment.juspayhypersdk.refresh.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletReactPayload;", "", "walletId", "", "walletName", "clientAuthToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientAuthToken", "()Ljava/lang/String;", "getWalletId", "getWalletName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: JuspaySingleWalletReactPayload.kt */
public final class JuspaySingleWalletReactPayload {
    public final String clientAuthToken;
    public final String walletId;
    public final String walletName;

    public JuspaySingleWalletReactPayload(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "walletId", str2, "walletName", str3, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
        this.walletId = str;
        this.walletName = str2;
        this.clientAuthToken = str3;
    }

    public static /* synthetic */ JuspaySingleWalletReactPayload copy$default(JuspaySingleWalletReactPayload juspaySingleWalletReactPayload, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = juspaySingleWalletReactPayload.walletId;
        }
        if ((i & 2) != 0) {
            str2 = juspaySingleWalletReactPayload.walletName;
        }
        if ((i & 4) != 0) {
            str3 = juspaySingleWalletReactPayload.clientAuthToken;
        }
        return juspaySingleWalletReactPayload.copy(str, str2, str3);
    }

    public final String component1() {
        return this.walletId;
    }

    public final String component2() {
        return this.walletName;
    }

    public final String component3() {
        return this.clientAuthToken;
    }

    public final JuspaySingleWalletReactPayload copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "walletId");
        Intrinsics.checkNotNullParameter(str2, "walletName");
        Intrinsics.checkNotNullParameter(str3, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
        return new JuspaySingleWalletReactPayload(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.clientAuthToken, r3.clientAuthToken) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof com.mpl.payment.juspayhypersdk.refresh.model.JuspaySingleWalletReactPayload
            if (r0 == 0) goto L_0x0027
            com.mpl.payment.juspayhypersdk.refresh.model.JuspaySingleWalletReactPayload r3 = (com.mpl.payment.juspayhypersdk.refresh.model.JuspaySingleWalletReactPayload) r3
            java.lang.String r0 = r2.walletId
            java.lang.String r1 = r3.walletId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.walletName
            java.lang.String r1 = r3.walletName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.clientAuthToken
            java.lang.String r3 = r3.clientAuthToken
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.refresh.model.JuspaySingleWalletReactPayload.equals(java.lang.Object):boolean");
    }

    public final String getClientAuthToken() {
        return this.clientAuthToken;
    }

    public final String getWalletId() {
        return this.walletId;
    }

    public final String getWalletName() {
        return this.walletName;
    }

    public int hashCode() {
        String str = this.walletId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.walletName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clientAuthToken;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JuspaySingleWalletReactPayload(walletId=");
        outline73.append(this.walletId);
        outline73.append(", walletName=");
        outline73.append(this.walletName);
        outline73.append(", clientAuthToken=");
        return GeneratedOutlineSupport.outline62(outline73, this.clientAuthToken, ")");
    }
}
