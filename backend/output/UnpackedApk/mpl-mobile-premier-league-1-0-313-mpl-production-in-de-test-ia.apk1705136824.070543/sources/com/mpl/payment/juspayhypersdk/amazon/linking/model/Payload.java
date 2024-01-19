package com.mpl.payment.juspayhypersdk.amazon.linking.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/Payload;", "", "action", "", "walletName", "clientAuthToken", "sdkWalletIdentifier", "showLoader", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAction", "()Ljava/lang/String;", "getClientAuthToken", "getSdkWalletIdentifier", "getShowLoader", "()Z", "getWalletName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AmazonCreateWalletRequest.kt */
public final class Payload {
    public final String action;
    public final String clientAuthToken;
    public final String sdkWalletIdentifier;
    public final boolean showLoader;
    public final String walletName;

    public Payload(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "walletName");
        Intrinsics.checkNotNullParameter(str3, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
        Intrinsics.checkNotNullParameter(str4, "sdkWalletIdentifier");
        this.action = str;
        this.walletName = str2;
        this.clientAuthToken = str3;
        this.sdkWalletIdentifier = str4;
        this.showLoader = z;
    }

    public static /* synthetic */ Payload copy$default(Payload payload, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payload.action;
        }
        if ((i & 2) != 0) {
            str2 = payload.walletName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = payload.clientAuthToken;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = payload.sdkWalletIdentifier;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = payload.showLoader;
        }
        return payload.copy(str, str5, str6, str7, z);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.walletName;
    }

    public final String component3() {
        return this.clientAuthToken;
    }

    public final String component4() {
        return this.sdkWalletIdentifier;
    }

    public final boolean component5() {
        return this.showLoader;
    }

    public final Payload copy(String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "walletName");
        Intrinsics.checkNotNullParameter(str3, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
        Intrinsics.checkNotNullParameter(str4, "sdkWalletIdentifier");
        Payload payload = new Payload(str, str2, str3, str4, z);
        return payload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r2.showLoader == r3.showLoader) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0039
            boolean r0 = r3 instanceof com.mpl.payment.juspayhypersdk.amazon.linking.model.Payload
            if (r0 == 0) goto L_0x0037
            com.mpl.payment.juspayhypersdk.amazon.linking.model.Payload r3 = (com.mpl.payment.juspayhypersdk.amazon.linking.model.Payload) r3
            java.lang.String r0 = r2.action
            java.lang.String r1 = r3.action
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r2.walletName
            java.lang.String r1 = r3.walletName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r2.clientAuthToken
            java.lang.String r1 = r3.clientAuthToken
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r2.sdkWalletIdentifier
            java.lang.String r1 = r3.sdkWalletIdentifier
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0037
            boolean r0 = r2.showLoader
            boolean r3 = r3.showLoader
            if (r0 != r3) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r3 = 0
            return r3
        L_0x0039:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.amazon.linking.model.Payload.equals(java.lang.Object):boolean");
    }

    public final String getAction() {
        return this.action;
    }

    public final String getClientAuthToken() {
        return this.clientAuthToken;
    }

    public final String getSdkWalletIdentifier() {
        return this.sdkWalletIdentifier;
    }

    public final boolean getShowLoader() {
        return this.showLoader;
    }

    public final String getWalletName() {
        return this.walletName;
    }

    public int hashCode() {
        String str = this.action;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.walletName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clientAuthToken;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.sdkWalletIdentifier;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.showLoader;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Payload(action=");
        outline73.append(this.action);
        outline73.append(", walletName=");
        outline73.append(this.walletName);
        outline73.append(", clientAuthToken=");
        outline73.append(this.clientAuthToken);
        outline73.append(", sdkWalletIdentifier=");
        outline73.append(this.sdkWalletIdentifier);
        outline73.append(", showLoader=");
        return GeneratedOutlineSupport.outline66(outline73, this.showLoader, ")");
    }

    public /* synthetic */ Payload(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "createWallet" : str, (i & 2) != 0 ? RoutingConstants.PAYMENT_MODE_AMAZONPAY : str2, str3, str4, (i & 16) != 0 ? false : z);
    }
}
