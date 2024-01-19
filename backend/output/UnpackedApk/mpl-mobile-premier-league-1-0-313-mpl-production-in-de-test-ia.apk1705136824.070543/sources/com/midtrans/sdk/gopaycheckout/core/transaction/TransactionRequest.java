package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003Ja\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionRequest;", "", "paymentType", "", "gopay", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetails;", "transactionDetails", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "customerDetails", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/CustomerDetails;", "itemDetails", "", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/ItemDetail;", "metadata", "", "(Ljava/lang/String;Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetails;Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;Lcom/midtrans/sdk/gopaycheckout/core/transaction/CustomerDetails;Ljava/util/List;Ljava/util/Map;)V", "getCustomerDetails", "()Lcom/midtrans/sdk/gopaycheckout/core/transaction/CustomerDetails;", "getGopay", "()Lcom/midtrans/sdk/gopaycheckout/core/transaction/GoPayDetails;", "getItemDetails", "()Ljava/util/List;", "getMetadata", "()Ljava/util/Map;", "getPaymentType", "()Ljava/lang/String;", "getTransactionDetails", "()Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionDetails;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class TransactionRequest {
    @Json(name = "customer_details")
    public final CustomerDetails customerDetails;
    @Json(name = "gopay")
    public final GoPayDetails gopay;
    @Json(name = "item_details")
    public final List<ItemDetail> itemDetails;
    @Json(name = "metadata")
    public final Map<String, String> metadata;
    @Json(name = "payment_type")
    public final String paymentType;
    @Json(name = "transaction_details")
    public final TransactionDetails transactionDetails;

    public TransactionRequest(String str, GoPayDetails goPayDetails, TransactionDetails transactionDetails2, CustomerDetails customerDetails2, List<ItemDetail> list, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "paymentType");
        this.paymentType = str;
        this.gopay = goPayDetails;
        this.transactionDetails = transactionDetails2;
        this.customerDetails = customerDetails2;
        this.itemDetails = list;
        this.metadata = map;
    }

    public /* synthetic */ TransactionRequest(String str, GoPayDetails goPayDetails, TransactionDetails transactionDetails2, CustomerDetails customerDetails2, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "gopay" : str, goPayDetails, transactionDetails2, customerDetails2, list, map);
    }

    public static /* synthetic */ TransactionRequest copy$default(TransactionRequest transactionRequest, String str, GoPayDetails goPayDetails, TransactionDetails transactionDetails2, CustomerDetails customerDetails2, List<ItemDetail> list, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transactionRequest.paymentType;
        }
        if ((i & 2) != 0) {
            goPayDetails = transactionRequest.gopay;
        }
        GoPayDetails goPayDetails2 = goPayDetails;
        if ((i & 4) != 0) {
            transactionDetails2 = transactionRequest.transactionDetails;
        }
        TransactionDetails transactionDetails3 = transactionDetails2;
        if ((i & 8) != 0) {
            customerDetails2 = transactionRequest.customerDetails;
        }
        CustomerDetails customerDetails3 = customerDetails2;
        if ((i & 16) != 0) {
            list = transactionRequest.itemDetails;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            map = transactionRequest.metadata;
        }
        return transactionRequest.copy(str, goPayDetails2, transactionDetails3, customerDetails3, list2, map);
    }

    public final String component1() {
        return this.paymentType;
    }

    public final GoPayDetails component2() {
        return this.gopay;
    }

    public final TransactionDetails component3() {
        return this.transactionDetails;
    }

    public final CustomerDetails component4() {
        return this.customerDetails;
    }

    public final List<ItemDetail> component5() {
        return this.itemDetails;
    }

    public final Map<String, String> component6() {
        return this.metadata;
    }

    public final TransactionRequest copy(String str, GoPayDetails goPayDetails, TransactionDetails transactionDetails2, CustomerDetails customerDetails2, List<ItemDetail> list, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "paymentType");
        TransactionRequest transactionRequest = new TransactionRequest(str, goPayDetails, transactionDetails2, customerDetails2, list, map);
        return transactionRequest;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.metadata, r3.metadata) != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0047
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequest
            if (r0 == 0) goto L_0x0045
            com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequest r3 = (com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequest) r3
            java.lang.String r0 = r2.paymentType
            java.lang.String r1 = r3.paymentType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails r0 = r2.gopay
            com.midtrans.sdk.gopaycheckout.core.transaction.GoPayDetails r1 = r3.gopay
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails r0 = r2.transactionDetails
            com.midtrans.sdk.gopaycheckout.core.transaction.TransactionDetails r1 = r3.transactionDetails
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            com.midtrans.sdk.gopaycheckout.core.transaction.CustomerDetails r0 = r2.customerDetails
            com.midtrans.sdk.gopaycheckout.core.transaction.CustomerDetails r1 = r3.customerDetails
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            java.util.List<com.midtrans.sdk.gopaycheckout.core.transaction.ItemDetail> r0 = r2.itemDetails
            java.util.List<com.midtrans.sdk.gopaycheckout.core.transaction.ItemDetail> r1 = r3.itemDetails
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.metadata
            java.util.Map<java.lang.String, java.lang.String> r3 = r3.metadata
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r3 = 0
            return r3
        L_0x0047:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequest.equals(java.lang.Object):boolean");
    }

    public final CustomerDetails getCustomerDetails() {
        return this.customerDetails;
    }

    public final GoPayDetails getGopay() {
        return this.gopay;
    }

    public final List<ItemDetail> getItemDetails() {
        return this.itemDetails;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final TransactionDetails getTransactionDetails() {
        return this.transactionDetails;
    }

    public int hashCode() {
        String str = this.paymentType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        GoPayDetails goPayDetails = this.gopay;
        int hashCode2 = (hashCode + (goPayDetails != null ? goPayDetails.hashCode() : 0)) * 31;
        TransactionDetails transactionDetails2 = this.transactionDetails;
        int hashCode3 = (hashCode2 + (transactionDetails2 != null ? transactionDetails2.hashCode() : 0)) * 31;
        CustomerDetails customerDetails2 = this.customerDetails;
        int hashCode4 = (hashCode3 + (customerDetails2 != null ? customerDetails2.hashCode() : 0)) * 31;
        List<ItemDetail> list = this.itemDetails;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, String> map = this.metadata;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TransactionRequest(paymentType=");
        outline73.append(this.paymentType);
        outline73.append(", gopay=");
        outline73.append(this.gopay);
        outline73.append(", transactionDetails=");
        outline73.append(this.transactionDetails);
        outline73.append(", customerDetails=");
        outline73.append(this.customerDetails);
        outline73.append(", itemDetails=");
        outline73.append(this.itemDetails);
        outline73.append(", metadata=");
        outline73.append(this.metadata);
        outline73.append(")");
        return outline73.toString();
    }
}
