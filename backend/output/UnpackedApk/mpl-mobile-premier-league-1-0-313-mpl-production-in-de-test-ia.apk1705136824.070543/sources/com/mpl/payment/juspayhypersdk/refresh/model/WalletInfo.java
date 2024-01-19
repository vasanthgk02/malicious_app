package com.mpl.payment.juspayhypersdk.refresh.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/refresh/model/WalletInfo;", "", "token", "", "linked", "", "id", "currentBalance", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getCurrentBalance", "()Ljava/lang/String;", "getId", "getLinked", "()Z", "getToken", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SingleWalletRefreshResponsePayload.kt */
public final class WalletInfo {
    public final String currentBalance;
    public final String id;
    public final boolean linked;
    public final String token;

    public WalletInfo(String str, boolean z, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "token", str2, "id", str3, "currentBalance");
        this.token = str;
        this.linked = z;
        this.id = str2;
        this.currentBalance = str3;
    }

    public static /* synthetic */ WalletInfo copy$default(WalletInfo walletInfo, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = walletInfo.token;
        }
        if ((i & 2) != 0) {
            z = walletInfo.linked;
        }
        if ((i & 4) != 0) {
            str2 = walletInfo.id;
        }
        if ((i & 8) != 0) {
            str3 = walletInfo.currentBalance;
        }
        return walletInfo.copy(str, z, str2, str3);
    }

    public final String component1() {
        return this.token;
    }

    public final boolean component2() {
        return this.linked;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.currentBalance;
    }

    public final WalletInfo copy(String str, boolean z, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "currentBalance");
        return new WalletInfo(str, z, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.currentBalance, r3.currentBalance) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x002f
            boolean r0 = r3 instanceof com.mpl.payment.juspayhypersdk.refresh.model.WalletInfo
            if (r0 == 0) goto L_0x002d
            com.mpl.payment.juspayhypersdk.refresh.model.WalletInfo r3 = (com.mpl.payment.juspayhypersdk.refresh.model.WalletInfo) r3
            java.lang.String r0 = r2.token
            java.lang.String r1 = r3.token
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x002d
            boolean r0 = r2.linked
            boolean r1 = r3.linked
            if (r0 != r1) goto L_0x002d
            java.lang.String r0 = r2.id
            java.lang.String r1 = r3.id
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r2.currentBalance
            java.lang.String r3 = r3.currentBalance
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r3 = 0
            return r3
        L_0x002f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.refresh.model.WalletInfo.equals(java.lang.Object):boolean");
    }

    public final String getCurrentBalance() {
        return this.currentBalance;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getLinked() {
        return this.linked;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.linked;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        String str2 = this.id;
        int hashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.currentBalance;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("WalletInfo(token=");
        outline73.append(this.token);
        outline73.append(", linked=");
        outline73.append(this.linked);
        outline73.append(", id=");
        outline73.append(this.id);
        outline73.append(", currentBalance=");
        return GeneratedOutlineSupport.outline62(outline73, this.currentBalance, ")");
    }
}
