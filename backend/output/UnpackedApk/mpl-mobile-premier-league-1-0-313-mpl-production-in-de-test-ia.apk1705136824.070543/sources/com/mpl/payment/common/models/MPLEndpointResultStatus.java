package com.mpl.payment.common.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.cardverification.models.Status;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/payment/common/models/MPLEndpointResultStatus;", "", "status", "Lcom/mpl/payment/cardverification/models/Status;", "(Lcom/mpl/payment/cardverification/models/Status;)V", "getStatus", "()Lcom/mpl/payment/cardverification/models/Status;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLEndpointResultStatus.kt */
public final class MPLEndpointResultStatus {
    public final Status status;

    public MPLEndpointResultStatus(Status status2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        this.status = status2;
    }

    public static /* synthetic */ MPLEndpointResultStatus copy$default(MPLEndpointResultStatus mPLEndpointResultStatus, Status status2, int i, Object obj) {
        if ((i & 1) != 0) {
            status2 = mPLEndpointResultStatus.status;
        }
        return mPLEndpointResultStatus.copy(status2);
    }

    public final Status component1() {
        return this.status;
    }

    public final MPLEndpointResultStatus copy(Status status2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        return new MPLEndpointResultStatus(status2);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof MPLEndpointResultStatus) && Intrinsics.areEqual(this.status, ((MPLEndpointResultStatus) obj).status));
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        Status status2 = this.status;
        if (status2 != null) {
            return status2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MPLEndpointResultStatus(status=");
        outline73.append(this.status);
        outline73.append(")");
        return outline73.toString();
    }
}
