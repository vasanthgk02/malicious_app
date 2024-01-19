package com.mpl.payment.juspayhypersdk.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/models/UpiAppsJuspayPayload;", "", "action", "", "availableApps", "", "Lcom/mpl/payment/juspayhypersdk/models/UpiAppModel;", "(Ljava/lang/String;Ljava/util/List;)V", "getAction", "()Ljava/lang/String;", "getAvailableApps", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpiAppsJuspayPayload.kt */
public final class UpiAppsJuspayPayload {
    public final String action;
    public final List<UpiAppModel> availableApps;

    public UpiAppsJuspayPayload(String str, List<UpiAppModel> list) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(list, "availableApps");
        this.action = str;
        this.availableApps = list;
    }

    public static /* synthetic */ UpiAppsJuspayPayload copy$default(UpiAppsJuspayPayload upiAppsJuspayPayload, String str, List<UpiAppModel> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upiAppsJuspayPayload.action;
        }
        if ((i & 2) != 0) {
            list = upiAppsJuspayPayload.availableApps;
        }
        return upiAppsJuspayPayload.copy(str, list);
    }

    public final String component1() {
        return this.action;
    }

    public final List<UpiAppModel> component2() {
        return this.availableApps;
    }

    public final UpiAppsJuspayPayload copy(String str, List<UpiAppModel> list) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(list, "availableApps");
        return new UpiAppsJuspayPayload(str, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.availableApps, r3.availableApps) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.mpl.payment.juspayhypersdk.models.UpiAppsJuspayPayload
            if (r0 == 0) goto L_0x001d
            com.mpl.payment.juspayhypersdk.models.UpiAppsJuspayPayload r3 = (com.mpl.payment.juspayhypersdk.models.UpiAppsJuspayPayload) r3
            java.lang.String r0 = r2.action
            java.lang.String r1 = r3.action
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.util.List<com.mpl.payment.juspayhypersdk.models.UpiAppModel> r0 = r2.availableApps
            java.util.List<com.mpl.payment.juspayhypersdk.models.UpiAppModel> r3 = r3.availableApps
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.models.UpiAppsJuspayPayload.equals(java.lang.Object):boolean");
    }

    public final String getAction() {
        return this.action;
    }

    public final List<UpiAppModel> getAvailableApps() {
        return this.availableApps;
    }

    public int hashCode() {
        String str = this.action;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<UpiAppModel> list = this.availableApps;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UpiAppsJuspayPayload(action=");
        outline73.append(this.action);
        outline73.append(", availableApps=");
        return GeneratedOutlineSupport.outline64(outline73, this.availableApps, ")");
    }
}
