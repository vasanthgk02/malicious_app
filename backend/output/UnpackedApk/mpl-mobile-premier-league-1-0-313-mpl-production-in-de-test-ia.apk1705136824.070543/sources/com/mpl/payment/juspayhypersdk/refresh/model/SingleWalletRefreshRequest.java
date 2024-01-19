package com.mpl.payment.juspayhypersdk.refresh.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.utils.Constants;
import com.squareup.moshi.JsonClass;
import in.juspay.services.HyperServices;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/refresh/model/SingleWalletRefreshRequest;", "", "requestId", "", "service", "payload", "Lcom/mpl/payment/juspayhypersdk/refresh/model/Payload;", "(Ljava/lang/String;Ljava/lang/String;Lcom/mpl/payment/juspayhypersdk/refresh/model/Payload;)V", "getPayload", "()Lcom/mpl/payment/juspayhypersdk/refresh/model/Payload;", "getRequestId", "()Ljava/lang/String;", "getService", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SingleWalletRefreshRequest.kt */
public final class SingleWalletRefreshRequest {
    public final Payload payload;
    public final String requestId;
    public final String service;

    public SingleWalletRefreshRequest(String str, String str2, Payload payload2) {
        Intrinsics.checkNotNullParameter(str, HyperServices.REQUEST_ID);
        Intrinsics.checkNotNullParameter(str2, "service");
        Intrinsics.checkNotNullParameter(payload2, "payload");
        this.requestId = str;
        this.service = str2;
        this.payload = payload2;
    }

    public static /* synthetic */ SingleWalletRefreshRequest copy$default(SingleWalletRefreshRequest singleWalletRefreshRequest, String str, String str2, Payload payload2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = singleWalletRefreshRequest.requestId;
        }
        if ((i & 2) != 0) {
            str2 = singleWalletRefreshRequest.service;
        }
        if ((i & 4) != 0) {
            payload2 = singleWalletRefreshRequest.payload;
        }
        return singleWalletRefreshRequest.copy(str, str2, payload2);
    }

    public final String component1() {
        return this.requestId;
    }

    public final String component2() {
        return this.service;
    }

    public final Payload component3() {
        return this.payload;
    }

    public final SingleWalletRefreshRequest copy(String str, String str2, Payload payload2) {
        Intrinsics.checkNotNullParameter(str, HyperServices.REQUEST_ID);
        Intrinsics.checkNotNullParameter(str2, "service");
        Intrinsics.checkNotNullParameter(payload2, "payload");
        return new SingleWalletRefreshRequest(str, str2, payload2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.payload, r3.payload) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof com.mpl.payment.juspayhypersdk.refresh.model.SingleWalletRefreshRequest
            if (r0 == 0) goto L_0x0027
            com.mpl.payment.juspayhypersdk.refresh.model.SingleWalletRefreshRequest r3 = (com.mpl.payment.juspayhypersdk.refresh.model.SingleWalletRefreshRequest) r3
            java.lang.String r0 = r2.requestId
            java.lang.String r1 = r3.requestId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.service
            java.lang.String r1 = r3.service
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            com.mpl.payment.juspayhypersdk.refresh.model.Payload r0 = r2.payload
            com.mpl.payment.juspayhypersdk.refresh.model.Payload r3 = r3.payload
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.refresh.model.SingleWalletRefreshRequest.equals(java.lang.Object):boolean");
    }

    public final Payload getPayload() {
        return this.payload;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getService() {
        return this.service;
    }

    public int hashCode() {
        String str = this.requestId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.service;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Payload payload2 = this.payload;
        if (payload2 != null) {
            i = payload2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SingleWalletRefreshRequest(requestId=");
        outline73.append(this.requestId);
        outline73.append(", service=");
        outline73.append(this.service);
        outline73.append(", payload=");
        outline73.append(this.payload);
        outline73.append(")");
        return outline73.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public /* synthetic */ SingleWalletRefreshRequest(String str, String str2, Payload payload2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        // if ((i & 1) != 0) {
            // str = UUID.randomUUID().toString();
            // Intrinsics.checkNotNullExpressionValue(str, "UUID.randomUUID().toString()");
        // }
        this(str, (i & 2) != 0 ? Constants.JUSPAY_SERVICE_NAME : str2, payload2);
    }
}
