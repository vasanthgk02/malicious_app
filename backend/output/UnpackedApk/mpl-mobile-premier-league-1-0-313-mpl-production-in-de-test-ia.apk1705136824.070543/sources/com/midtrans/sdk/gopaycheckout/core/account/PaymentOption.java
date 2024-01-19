package com.midtrans.sdk.gopaycheckout.core.account;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/PaymentOption;", "", "name", "", "active", "", "token", "balance", "Lcom/midtrans/sdk/gopaycheckout/core/account/Amount;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/midtrans/sdk/gopaycheckout/core/account/Amount;)V", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBalance", "()Lcom/midtrans/sdk/gopaycheckout/core/account/Amount;", "getName", "()Ljava/lang/String;", "getToken", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/midtrans/sdk/gopaycheckout/core/account/Amount;)Lcom/midtrans/sdk/gopaycheckout/core/account/PaymentOption;", "equals", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class PaymentOption {
    @Json(name = "active")
    public final Boolean active;
    @Json(name = "balance")
    public final Amount balance;
    @Json(name = "name")
    public final String name;
    @Json(name = "token")
    public final String token;

    public PaymentOption(String str, Boolean bool, String str2, Amount amount) {
        this.name = str;
        this.active = bool;
        this.token = str2;
        this.balance = amount;
    }

    public static /* synthetic */ PaymentOption copy$default(PaymentOption paymentOption, String str, Boolean bool, String str2, Amount amount, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentOption.name;
        }
        if ((i & 2) != 0) {
            bool = paymentOption.active;
        }
        if ((i & 4) != 0) {
            str2 = paymentOption.token;
        }
        if ((i & 8) != 0) {
            amount = paymentOption.balance;
        }
        return paymentOption.copy(str, bool, str2, amount);
    }

    public final String component1() {
        return this.name;
    }

    public final Boolean component2() {
        return this.active;
    }

    public final String component3() {
        return this.token;
    }

    public final Amount component4() {
        return this.balance;
    }

    public final PaymentOption copy(String str, Boolean bool, String str2, Amount amount) {
        return new PaymentOption(str, bool, str2, amount);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.balance, r3.balance) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.account.PaymentOption
            if (r0 == 0) goto L_0x0031
            com.midtrans.sdk.gopaycheckout.core.account.PaymentOption r3 = (com.midtrans.sdk.gopaycheckout.core.account.PaymentOption) r3
            java.lang.String r0 = r2.name
            java.lang.String r1 = r3.name
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.Boolean r0 = r2.active
            java.lang.Boolean r1 = r3.active
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.token
            java.lang.String r1 = r3.token
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            com.midtrans.sdk.gopaycheckout.core.account.Amount r0 = r2.balance
            com.midtrans.sdk.gopaycheckout.core.account.Amount r3 = r3.balance
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
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.account.PaymentOption.equals(java.lang.Object):boolean");
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final Amount getBalance() {
        return this.balance;
    }

    public final String getName() {
        return this.name;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.active;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Amount amount = this.balance;
        if (amount != null) {
            i = amount.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PaymentOption(name=");
        outline73.append(this.name);
        outline73.append(", active=");
        outline73.append(this.active);
        outline73.append(", token=");
        outline73.append(this.token);
        outline73.append(", balance=");
        outline73.append(this.balance);
        outline73.append(")");
        return outline73.toString();
    }
}
