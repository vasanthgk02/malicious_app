package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.midtrans.sdk.gopaycheckout.core.BaseResponse;
import com.midtrans.sdk.gopaycheckout.core.PendingAction;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B§\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÉ\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0007HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006="}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "Lcom/midtrans/sdk/gopaycheckout/core/BaseResponse;", "statusCode", "", "statusMessage", "id", "validationMessages", "", "channelResponseCode", "channelResponseMessage", "orderId", "transactionId", "grossAmount", "currency", "paymentType", "transactionTime", "transactionStatus", "fraudStatus", "actions", "Lcom/midtrans/sdk/gopaycheckout/core/PendingAction;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getChannelResponseCode", "()Ljava/lang/String;", "getChannelResponseMessage", "getCurrency", "getFraudStatus", "getGrossAmount", "getId", "getOrderId", "getPaymentType", "getStatusCode", "getStatusMessage", "getTransactionId", "getTransactionStatus", "getTransactionTime", "getValidationMessages", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class TransactionResponse extends BaseResponse {
    @Json(name = "actions")
    public final List<PendingAction> actions;
    @Json(name = "channel_response_code")
    public final String channelResponseCode;
    @Json(name = "channel_response_message")
    public final String channelResponseMessage;
    @Json(name = "currency")
    public final String currency;
    @Json(name = "fraud_status")
    public final String fraudStatus;
    @Json(name = "gross_amount")
    public final String grossAmount;
    @Json(name = "id")
    public final String id;
    @Json(name = "order_id")
    public final String orderId;
    @Json(name = "payment_type")
    public final String paymentType;
    @Json(name = "status_code")
    public final String statusCode;
    @Json(name = "status_message")
    public final String statusMessage;
    @Json(name = "transaction_id")
    public final String transactionId;
    @Json(name = "transaction_status")
    public final String transactionStatus;
    @Json(name = "transaction_time")
    public final String transactionTime;
    @Json(name = "validation_messages")
    public final List<String> validationMessages;

    public TransactionResponse(String str, String str2, String str3, List<String> list, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List<PendingAction> list2) {
        super(str, str2, str3, list, str4, str5);
        this.statusCode = str;
        this.statusMessage = str2;
        this.id = str3;
        this.validationMessages = list;
        this.channelResponseCode = str4;
        this.channelResponseMessage = str5;
        this.orderId = str6;
        this.transactionId = str7;
        this.grossAmount = str8;
        this.currency = str9;
        this.paymentType = str10;
        this.transactionTime = str11;
        this.transactionStatus = str12;
        this.fraudStatus = str13;
        this.actions = list2;
    }

    public static /* synthetic */ TransactionResponse copy$default(TransactionResponse transactionResponse, String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List list2, int i, Object obj) {
        TransactionResponse transactionResponse2 = transactionResponse;
        int i2 = i;
        return transactionResponse.copy((i2 & 1) != 0 ? transactionResponse.getStatusCode() : str, (i2 & 2) != 0 ? transactionResponse.getStatusMessage() : str2, (i2 & 4) != 0 ? transactionResponse.getId() : str3, (i2 & 8) != 0 ? transactionResponse.getValidationMessages() : list, (i2 & 16) != 0 ? transactionResponse.getChannelResponseCode() : str4, (i2 & 32) != 0 ? transactionResponse.getChannelResponseMessage() : str5, (i2 & 64) != 0 ? transactionResponse2.orderId : str6, (i2 & 128) != 0 ? transactionResponse2.transactionId : str7, (i2 & 256) != 0 ? transactionResponse2.grossAmount : str8, (i2 & 512) != 0 ? transactionResponse2.currency : str9, (i2 & 1024) != 0 ? transactionResponse2.paymentType : str10, (i2 & 2048) != 0 ? transactionResponse2.transactionTime : str11, (i2 & 4096) != 0 ? transactionResponse2.transactionStatus : str12, (i2 & 8192) != 0 ? transactionResponse2.fraudStatus : str13, (i2 & 16384) != 0 ? transactionResponse2.actions : list2);
    }

    public final String component1() {
        return getStatusCode();
    }

    public final String component10() {
        return this.currency;
    }

    public final String component11() {
        return this.paymentType;
    }

    public final String component12() {
        return this.transactionTime;
    }

    public final String component13() {
        return this.transactionStatus;
    }

    public final String component14() {
        return this.fraudStatus;
    }

    public final List<PendingAction> component15() {
        return this.actions;
    }

    public final String component2() {
        return getStatusMessage();
    }

    public final String component3() {
        return getId();
    }

    public final List<String> component4() {
        return getValidationMessages();
    }

    public final String component5() {
        return getChannelResponseCode();
    }

    public final String component6() {
        return getChannelResponseMessage();
    }

    public final String component7() {
        return this.orderId;
    }

    public final String component8() {
        return this.transactionId;
    }

    public final String component9() {
        return this.grossAmount;
    }

    public final TransactionResponse copy(String str, String str2, String str3, List<String> list, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List<PendingAction> list2) {
        TransactionResponse transactionResponse = new TransactionResponse(str, str2, str3, list, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, list2);
        return transactionResponse;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.actions, r3.actions) != false) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x00b9
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse
            if (r0 == 0) goto L_0x00b7
            com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse r3 = (com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse) r3
            java.lang.String r0 = r2.getStatusCode()
            java.lang.String r1 = r3.getStatusCode()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.getStatusMessage()
            java.lang.String r1 = r3.getStatusMessage()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.getId()
            java.lang.String r1 = r3.getId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.util.List r0 = r2.getValidationMessages()
            java.util.List r1 = r3.getValidationMessages()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.getChannelResponseCode()
            java.lang.String r1 = r3.getChannelResponseCode()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.getChannelResponseMessage()
            java.lang.String r1 = r3.getChannelResponseMessage()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.orderId
            java.lang.String r1 = r3.orderId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.transactionId
            java.lang.String r1 = r3.transactionId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.grossAmount
            java.lang.String r1 = r3.grossAmount
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.currency
            java.lang.String r1 = r3.currency
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.paymentType
            java.lang.String r1 = r3.paymentType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.transactionTime
            java.lang.String r1 = r3.transactionTime
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.transactionStatus
            java.lang.String r1 = r3.transactionStatus
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.lang.String r0 = r2.fraudStatus
            java.lang.String r1 = r3.fraudStatus
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00b7
            java.util.List<com.midtrans.sdk.gopaycheckout.core.PendingAction> r0 = r2.actions
            java.util.List<com.midtrans.sdk.gopaycheckout.core.PendingAction> r3 = r3.actions
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            r3 = 0
            return r3
        L_0x00b9:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse.equals(java.lang.Object):boolean");
    }

    public final List<PendingAction> getActions() {
        return this.actions;
    }

    public String getChannelResponseCode() {
        return this.channelResponseCode;
    }

    public String getChannelResponseMessage() {
        return this.channelResponseMessage;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getFraudStatus() {
        return this.fraudStatus;
    }

    public final String getGrossAmount() {
        return this.grossAmount;
    }

    public String getId() {
        return this.id;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getTransactionStatus() {
        return this.transactionStatus;
    }

    public final String getTransactionTime() {
        return this.transactionTime;
    }

    public List<String> getValidationMessages() {
        return this.validationMessages;
    }

    public int hashCode() {
        String statusCode2 = getStatusCode();
        int i = 0;
        int hashCode = (statusCode2 != null ? statusCode2.hashCode() : 0) * 31;
        String statusMessage2 = getStatusMessage();
        int hashCode2 = (hashCode + (statusMessage2 != null ? statusMessage2.hashCode() : 0)) * 31;
        String id2 = getId();
        int hashCode3 = (hashCode2 + (id2 != null ? id2.hashCode() : 0)) * 31;
        List<String> validationMessages2 = getValidationMessages();
        int hashCode4 = (hashCode3 + (validationMessages2 != null ? validationMessages2.hashCode() : 0)) * 31;
        String channelResponseCode2 = getChannelResponseCode();
        int hashCode5 = (hashCode4 + (channelResponseCode2 != null ? channelResponseCode2.hashCode() : 0)) * 31;
        String channelResponseMessage2 = getChannelResponseMessage();
        int hashCode6 = (hashCode5 + (channelResponseMessage2 != null ? channelResponseMessage2.hashCode() : 0)) * 31;
        String str = this.orderId;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.transactionId;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.grossAmount;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.currency;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.paymentType;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.transactionTime;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.transactionStatus;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.fraudStatus;
        int hashCode14 = (hashCode13 + (str8 != null ? str8.hashCode() : 0)) * 31;
        List<PendingAction> list = this.actions;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("TransactionResponse(statusCode=");
        outline73.append(getStatusCode());
        outline73.append(", statusMessage=");
        outline73.append(getStatusMessage());
        outline73.append(", id=");
        outline73.append(getId());
        outline73.append(", validationMessages=");
        outline73.append(getValidationMessages());
        outline73.append(", channelResponseCode=");
        outline73.append(getChannelResponseCode());
        outline73.append(", channelResponseMessage=");
        outline73.append(getChannelResponseMessage());
        outline73.append(", orderId=");
        outline73.append(this.orderId);
        outline73.append(", transactionId=");
        outline73.append(this.transactionId);
        outline73.append(", grossAmount=");
        outline73.append(this.grossAmount);
        outline73.append(", currency=");
        outline73.append(this.currency);
        outline73.append(", paymentType=");
        outline73.append(this.paymentType);
        outline73.append(", transactionTime=");
        outline73.append(this.transactionTime);
        outline73.append(", transactionStatus=");
        outline73.append(this.transactionStatus);
        outline73.append(", fraudStatus=");
        outline73.append(this.fraudStatus);
        outline73.append(", actions=");
        return GeneratedOutlineSupport.outline64(outline73, this.actions, ")");
    }
}
