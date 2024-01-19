package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "", "orderId", "", "amount", "", "currency", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrency", "()Ljava/lang/String;", "getOrderId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "equals", "", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class TransactionDetails {
    @Json(name = "gross_amount")
    public final Long amount;
    @Json(name = "currency")
    public final String currency;
    @Json(name = "order_id")
    public final String orderId;

    public TransactionDetails(String str, Long l, String str2) {
        this.orderId = str;
        this.amount = l;
        this.currency = str2;
    }

    public /* synthetic */ TransactionDetails(String str, Long l, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, (i & 4) != 0 ? TransactionRequestKt.DEFAULT_CURRENCY : str2);
    }

    public static /* synthetic */ TransactionDetails copy$default(TransactionDetails transactionDetails, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transactionDetails.orderId;
        }
        if ((i & 2) != 0) {
            l = transactionDetails.amount;
        }
        if ((i & 4) != 0) {
            str2 = transactionDetails.currency;
        }
        return transactionDetails.copy(str, l, str2);
    }

    public final String component1() {
        return this.orderId;
    }

    public final Long component2() {
        return this.amount;
    }

    public final String component3() {
        return this.currency;
    }

    public final TransactionDetails copy(String str, Long l, String str2) {
        return new TransactionDetails(str, l, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.currency, r3.currency) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails
            if (r0 == 0) goto L_0x0027
            com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails r3 = (com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails) r3
            java.lang.String r0 = r2.orderId
            java.lang.String r1 = r3.orderId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.Long r0 = r2.amount
            java.lang.Long r1 = r3.amount
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.currency
            java.lang.String r3 = r3.currency
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
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails.equals(java.lang.Object):boolean");
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.amount;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.currency;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TransactionDetails(orderId=");
        outline73.append(this.orderId);
        outline73.append(", amount=");
        outline73.append(this.amount);
        outline73.append(", currency=");
        return GeneratedOutlineSupport.outline62(outline73, this.currency, ")");
    }
}
