package com.mpl.payment.juspayhypersdk.amazon.linking.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.routing.RoutingConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonWalletLinkingPayload;", "", "clientAuthToken", "", "merchantId", "clientId", "environment", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientAuthToken", "()Ljava/lang/String;", "getClientId", "getEnvironment", "getMerchantId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AmazonWalletLinkingPayload.kt */
public final class AmazonWalletLinkingPayload {
    public final String clientAuthToken;
    public final String clientId;
    public final String environment;
    public final String merchantId;

    public AmazonWalletLinkingPayload(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
        Intrinsics.checkNotNullParameter(str2, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str3, PaymentConstants.CLIENT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str4, PaymentConstants.ENV);
        this.clientAuthToken = str;
        this.merchantId = str2;
        this.clientId = str3;
        this.environment = str4;
    }

    public static /* synthetic */ AmazonWalletLinkingPayload copy$default(AmazonWalletLinkingPayload amazonWalletLinkingPayload, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = amazonWalletLinkingPayload.clientAuthToken;
        }
        if ((i & 2) != 0) {
            str2 = amazonWalletLinkingPayload.merchantId;
        }
        if ((i & 4) != 0) {
            str3 = amazonWalletLinkingPayload.clientId;
        }
        if ((i & 8) != 0) {
            str4 = amazonWalletLinkingPayload.environment;
        }
        return amazonWalletLinkingPayload.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.clientAuthToken;
    }

    public final String component2() {
        return this.merchantId;
    }

    public final String component3() {
        return this.clientId;
    }

    public final String component4() {
        return this.environment;
    }

    public final AmazonWalletLinkingPayload copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
        Intrinsics.checkNotNullParameter(str2, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str3, PaymentConstants.CLIENT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str4, PaymentConstants.ENV);
        return new AmazonWalletLinkingPayload(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.environment, r3.environment) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletLinkingPayload
            if (r0 == 0) goto L_0x0031
            com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletLinkingPayload r3 = (com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletLinkingPayload) r3
            java.lang.String r0 = r2.clientAuthToken
            java.lang.String r1 = r3.clientAuthToken
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.merchantId
            java.lang.String r1 = r3.merchantId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.clientId
            java.lang.String r1 = r3.clientId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.environment
            java.lang.String r3 = r3.environment
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonWalletLinkingPayload.equals(java.lang.Object):boolean");
    }

    public final String getClientAuthToken() {
        return this.clientAuthToken;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getEnvironment() {
        return this.environment;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public int hashCode() {
        String str = this.clientAuthToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clientId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.environment;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AmazonWalletLinkingPayload(clientAuthToken=");
        outline73.append(this.clientAuthToken);
        outline73.append(", merchantId=");
        outline73.append(this.merchantId);
        outline73.append(", clientId=");
        outline73.append(this.clientId);
        outline73.append(", environment=");
        return GeneratedOutlineSupport.outline62(outline73, this.environment, ")");
    }
}
