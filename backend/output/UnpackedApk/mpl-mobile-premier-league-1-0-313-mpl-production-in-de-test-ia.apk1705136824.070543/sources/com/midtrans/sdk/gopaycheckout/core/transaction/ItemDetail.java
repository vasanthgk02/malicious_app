package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/ItemDetail;", "", "id", "", "name", "price", "", "quantity", "", "category", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getId", "getName", "getPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getQuantity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lcom/midtrans/sdk/gopaycheckout/core/transaction/ItemDetail;", "equals", "", "other", "hashCode", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class ItemDetail {
    @Json(name = "category")
    public final String category;
    @Json(name = "id")
    public final String id;
    @Json(name = "name")
    public final String name;
    @Json(name = "price")
    public final Long price;
    @Json(name = "quantity")
    public final Integer quantity;

    public ItemDetail(String str, String str2, Long l, Integer num, String str3) {
        this.id = str;
        this.name = str2;
        this.price = l;
        this.quantity = num;
        this.category = str3;
    }

    public static /* synthetic */ ItemDetail copy$default(ItemDetail itemDetail, String str, String str2, Long l, Integer num, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemDetail.id;
        }
        if ((i & 2) != 0) {
            str2 = itemDetail.name;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            l = itemDetail.price;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            num = itemDetail.quantity;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            str3 = itemDetail.category;
        }
        return itemDetail.copy(str, str4, l2, num2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Long component3() {
        return this.price;
    }

    public final Integer component4() {
        return this.quantity;
    }

    public final String component5() {
        return this.category;
    }

    public final ItemDetail copy(String str, String str2, Long l, Integer num, String str3) {
        ItemDetail itemDetail = new ItemDetail(str, str2, l, num, str3);
        return itemDetail;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.category, r3.category) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.transaction.ItemDetail
            if (r0 == 0) goto L_0x003b
            com.midtrans.sdk.gopaycheckout.core.transaction.ItemDetail r3 = (com.midtrans.sdk.gopaycheckout.core.transaction.ItemDetail) r3
            java.lang.String r0 = r2.id
            java.lang.String r1 = r3.id
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.name
            java.lang.String r1 = r3.name
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.Long r0 = r2.price
            java.lang.Long r1 = r3.price
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.Integer r0 = r2.quantity
            java.lang.Integer r1 = r3.quantity
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.category
            java.lang.String r3 = r3.category
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            return r3
        L_0x003d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.transaction.ItemDetail.equals(java.lang.Object):boolean");
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.price;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.quantity;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.category;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ItemDetail(id=");
        outline73.append(this.id);
        outline73.append(", name=");
        outline73.append(this.name);
        outline73.append(", price=");
        outline73.append(this.price);
        outline73.append(", quantity=");
        outline73.append(this.quantity);
        outline73.append(", category=");
        return GeneratedOutlineSupport.outline62(outline73, this.category, ")");
    }
}
