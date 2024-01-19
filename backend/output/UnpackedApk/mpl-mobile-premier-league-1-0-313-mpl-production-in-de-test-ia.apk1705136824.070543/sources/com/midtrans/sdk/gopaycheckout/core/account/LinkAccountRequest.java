package com.midtrans.sdk.gopaycheckout.core.account;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/LinkAccountRequest;", "", "gopayPartner", "Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetails;", "paymentType", "", "metadata", "", "(Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetails;Ljava/lang/String;Ljava/util/Map;)V", "getGopayPartner", "()Lcom/midtrans/sdk/gopaycheckout/core/account/GoPayPartnerDetails;", "getMetadata", "()Ljava/util/Map;", "getPaymentType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class LinkAccountRequest {
    @Json(name = "gopay_partner")
    public final GoPayPartnerDetails gopayPartner;
    @Json(name = "metadata")
    public final Map<String, String> metadata;
    @Json(name = "payment_type")
    public final String paymentType;

    public LinkAccountRequest(GoPayPartnerDetails goPayPartnerDetails, String str, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "paymentType");
        this.gopayPartner = goPayPartnerDetails;
        this.paymentType = str;
        this.metadata = map;
    }

    public /* synthetic */ LinkAccountRequest(GoPayPartnerDetails goPayPartnerDetails, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(goPayPartnerDetails, (i & 2) != 0 ? "gopay" : str, map);
    }

    public static /* synthetic */ LinkAccountRequest copy$default(LinkAccountRequest linkAccountRequest, GoPayPartnerDetails goPayPartnerDetails, String str, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            goPayPartnerDetails = linkAccountRequest.gopayPartner;
        }
        if ((i & 2) != 0) {
            str = linkAccountRequest.paymentType;
        }
        if ((i & 4) != 0) {
            map = linkAccountRequest.metadata;
        }
        return linkAccountRequest.copy(goPayPartnerDetails, str, map);
    }

    public final GoPayPartnerDetails component1() {
        return this.gopayPartner;
    }

    public final String component2() {
        return this.paymentType;
    }

    public final Map<String, String> component3() {
        return this.metadata;
    }

    public final LinkAccountRequest copy(GoPayPartnerDetails goPayPartnerDetails, String str, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "paymentType");
        return new LinkAccountRequest(goPayPartnerDetails, str, map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.metadata, r3.metadata) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.account.LinkAccountRequest
            if (r0 == 0) goto L_0x0027
            com.midtrans.sdk.gopaycheckout.core.account.LinkAccountRequest r3 = (com.midtrans.sdk.gopaycheckout.core.account.LinkAccountRequest) r3
            com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails r0 = r2.gopayPartner
            com.midtrans.sdk.gopaycheckout.core.account.GoPayPartnerDetails r1 = r3.gopayPartner
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.paymentType
            java.lang.String r1 = r3.paymentType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.metadata
            java.util.Map<java.lang.String, java.lang.String> r3 = r3.metadata
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
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.account.LinkAccountRequest.equals(java.lang.Object):boolean");
    }

    public final GoPayPartnerDetails getGopayPartner() {
        return this.gopayPartner;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public int hashCode() {
        GoPayPartnerDetails goPayPartnerDetails = this.gopayPartner;
        int i = 0;
        int hashCode = (goPayPartnerDetails != null ? goPayPartnerDetails.hashCode() : 0) * 31;
        String str = this.paymentType;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.metadata;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LinkAccountRequest(gopayPartner=");
        outline73.append(this.gopayPartner);
        outline73.append(", paymentType=");
        outline73.append(this.paymentType);
        outline73.append(", metadata=");
        outline73.append(this.metadata);
        outline73.append(")");
        return outline73.toString();
    }
}
