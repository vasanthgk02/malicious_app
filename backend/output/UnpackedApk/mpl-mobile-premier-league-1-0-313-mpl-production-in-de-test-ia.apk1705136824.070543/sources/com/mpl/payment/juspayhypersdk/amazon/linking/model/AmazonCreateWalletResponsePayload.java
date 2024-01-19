package com.mpl.payment.juspayhypersdk.amazon.linking.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/amazon/linking/model/AmazonCreateWalletResponsePayload;", "", "action", "", "wallet", "token", "linked", "", "id", "currentBalance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getCurrentBalance", "getId", "getLinked", "()Z", "getToken", "getWallet", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AmazonCreateWalletResponsePayload.kt */
public final class AmazonCreateWalletResponsePayload {
    public final String action;
    public final String currentBalance;
    public final String id;
    public final boolean linked;
    public final String token;
    public final String wallet;

    public AmazonCreateWalletResponsePayload(String str, String str2, String str3, boolean z, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "action");
        this.action = str;
        this.wallet = str2;
        this.token = str3;
        this.linked = z;
        this.id = str4;
        this.currentBalance = str5;
    }

    public static /* synthetic */ AmazonCreateWalletResponsePayload copy$default(AmazonCreateWalletResponsePayload amazonCreateWalletResponsePayload, String str, String str2, String str3, boolean z, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = amazonCreateWalletResponsePayload.action;
        }
        if ((i & 2) != 0) {
            str2 = amazonCreateWalletResponsePayload.wallet;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = amazonCreateWalletResponsePayload.token;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            z = amazonCreateWalletResponsePayload.linked;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str4 = amazonCreateWalletResponsePayload.id;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = amazonCreateWalletResponsePayload.currentBalance;
        }
        return amazonCreateWalletResponsePayload.copy(str, str6, str7, z2, str8, str5);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.wallet;
    }

    public final String component3() {
        return this.token;
    }

    public final boolean component4() {
        return this.linked;
    }

    public final String component5() {
        return this.id;
    }

    public final String component6() {
        return this.currentBalance;
    }

    public final AmazonCreateWalletResponsePayload copy(String str, String str2, String str3, boolean z, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "action");
        AmazonCreateWalletResponsePayload amazonCreateWalletResponsePayload = new AmazonCreateWalletResponsePayload(str, str2, str3, z, str4, str5);
        return amazonCreateWalletResponsePayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.currentBalance, r3.currentBalance) != false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0043
            boolean r0 = r3 instanceof com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload
            if (r0 == 0) goto L_0x0041
            com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload r3 = (com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload) r3
            java.lang.String r0 = r2.action
            java.lang.String r1 = r3.action
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r2.wallet
            java.lang.String r1 = r3.wallet
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r2.token
            java.lang.String r1 = r3.token
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            boolean r0 = r2.linked
            boolean r1 = r3.linked
            if (r0 != r1) goto L_0x0041
            java.lang.String r0 = r2.id
            java.lang.String r1 = r3.id
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r2.currentBalance
            java.lang.String r3 = r3.currentBalance
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r3 = 0
            return r3
        L_0x0043:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.payment.juspayhypersdk.amazon.linking.model.AmazonCreateWalletResponsePayload.equals(java.lang.Object):boolean");
    }

    public final String getAction() {
        return this.action;
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

    public final String getWallet() {
        return this.wallet;
    }

    public int hashCode() {
        String str = this.action;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.wallet;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.token;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.linked;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str4 = this.id;
        int hashCode4 = (i2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.currentBalance;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AmazonCreateWalletResponsePayload(action=");
        outline73.append(this.action);
        outline73.append(", wallet=");
        outline73.append(this.wallet);
        outline73.append(", token=");
        outline73.append(this.token);
        outline73.append(", linked=");
        outline73.append(this.linked);
        outline73.append(", id=");
        outline73.append(this.id);
        outline73.append(", currentBalance=");
        return GeneratedOutlineSupport.outline62(outline73, this.currentBalance, ")");
    }
}
