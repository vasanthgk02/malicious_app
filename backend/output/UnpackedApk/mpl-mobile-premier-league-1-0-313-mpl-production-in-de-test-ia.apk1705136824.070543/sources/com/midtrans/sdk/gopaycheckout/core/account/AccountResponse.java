package com.midtrans.sdk.gopaycheckout.core.account;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.midtrans.sdk.gopaycheckout.core.BaseResponse;
import com.midtrans.sdk.gopaycheckout.core.PendingAction;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00063"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "Lcom/midtrans/sdk/gopaycheckout/core/BaseResponse;", "statusCode", "", "statusMessage", "id", "validationMessages", "", "channelResponseCode", "channelResponseMessage", "paymentType", "accountId", "accountStatus", "actions", "Lcom/midtrans/sdk/gopaycheckout/core/PendingAction;", "metadata", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountMetadata;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/midtrans/sdk/gopaycheckout/core/account/AccountMetadata;)V", "getAccountId", "()Ljava/lang/String;", "getAccountStatus", "getActions", "()Ljava/util/List;", "getChannelResponseCode", "getChannelResponseMessage", "getId", "getMetadata", "()Lcom/midtrans/sdk/gopaycheckout/core/account/AccountMetadata;", "getPaymentType", "getStatusCode", "getStatusMessage", "getValidationMessages", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class AccountResponse extends BaseResponse {
    @Json(name = "account_id")
    public final String accountId;
    @Json(name = "account_status")
    public final String accountStatus;
    @Json(name = "actions")
    public final List<PendingAction> actions;
    @Json(name = "channel_response_code")
    public final String channelResponseCode;
    @Json(name = "channel_response_message")
    public final String channelResponseMessage;
    @Json(name = "id")
    public final String id;
    @Json(name = "metadata")
    public final AccountMetadata metadata;
    @Json(name = "payment_type")
    public final String paymentType;
    @Json(name = "status_code")
    public final String statusCode;
    @Json(name = "status_message")
    public final String statusMessage;
    @Json(name = "validation_messages")
    public final List<String> validationMessages;

    public AccountResponse(String str, String str2, String str3, List<String> list, String str4, String str5, String str6, String str7, String str8, List<PendingAction> list2, AccountMetadata accountMetadata) {
        super(str, str2, str3, list, str4, str5);
        this.statusCode = str;
        this.statusMessage = str2;
        this.id = str3;
        this.validationMessages = list;
        this.channelResponseCode = str4;
        this.channelResponseMessage = str5;
        this.paymentType = str6;
        this.accountId = str7;
        this.accountStatus = str8;
        this.actions = list2;
        this.metadata = accountMetadata;
    }

    public static /* synthetic */ AccountResponse copy$default(AccountResponse accountResponse, String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, List list2, AccountMetadata accountMetadata, int i, Object obj) {
        AccountResponse accountResponse2 = accountResponse;
        int i2 = i;
        return accountResponse.copy((i2 & 1) != 0 ? accountResponse.getStatusCode() : str, (i2 & 2) != 0 ? accountResponse.getStatusMessage() : str2, (i2 & 4) != 0 ? accountResponse.getId() : str3, (i2 & 8) != 0 ? accountResponse.getValidationMessages() : list, (i2 & 16) != 0 ? accountResponse.getChannelResponseCode() : str4, (i2 & 32) != 0 ? accountResponse.getChannelResponseMessage() : str5, (i2 & 64) != 0 ? accountResponse2.paymentType : str6, (i2 & 128) != 0 ? accountResponse2.accountId : str7, (i2 & 256) != 0 ? accountResponse2.accountStatus : str8, (i2 & 512) != 0 ? accountResponse2.actions : list2, (i2 & 1024) != 0 ? accountResponse2.metadata : accountMetadata);
    }

    public final String component1() {
        return getStatusCode();
    }

    public final List<PendingAction> component10() {
        return this.actions;
    }

    public final AccountMetadata component11() {
        return this.metadata;
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
        return this.paymentType;
    }

    public final String component8() {
        return this.accountId;
    }

    public final String component9() {
        return this.accountStatus;
    }

    public final AccountResponse copy(String str, String str2, String str3, List<String> list, String str4, String str5, String str6, String str7, String str8, List<PendingAction> list2, AccountMetadata accountMetadata) {
        AccountResponse accountResponse = new AccountResponse(str, str2, str3, list, str4, str5, str6, str7, str8, list2, accountMetadata);
        return accountResponse;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.metadata, r3.metadata) != false) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0091
            boolean r0 = r3 instanceof com.midtrans.sdk.gopaycheckout.core.account.AccountResponse
            if (r0 == 0) goto L_0x008f
            com.midtrans.sdk.gopaycheckout.core.account.AccountResponse r3 = (com.midtrans.sdk.gopaycheckout.core.account.AccountResponse) r3
            java.lang.String r0 = r2.getStatusCode()
            java.lang.String r1 = r3.getStatusCode()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r2.getStatusMessage()
            java.lang.String r1 = r3.getStatusMessage()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r2.getId()
            java.lang.String r1 = r3.getId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.util.List r0 = r2.getValidationMessages()
            java.util.List r1 = r3.getValidationMessages()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r2.getChannelResponseCode()
            java.lang.String r1 = r3.getChannelResponseCode()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r2.getChannelResponseMessage()
            java.lang.String r1 = r3.getChannelResponseMessage()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r2.paymentType
            java.lang.String r1 = r3.paymentType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r2.accountId
            java.lang.String r1 = r3.accountId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.lang.String r0 = r2.accountStatus
            java.lang.String r1 = r3.accountStatus
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            java.util.List<com.midtrans.sdk.gopaycheckout.core.PendingAction> r0 = r2.actions
            java.util.List<com.midtrans.sdk.gopaycheckout.core.PendingAction> r1 = r3.actions
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x008f
            com.midtrans.sdk.gopaycheckout.core.account.AccountMetadata r0 = r2.metadata
            com.midtrans.sdk.gopaycheckout.core.account.AccountMetadata r3 = r3.metadata
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r3 = 0
            return r3
        L_0x0091:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.midtrans.sdk.gopaycheckout.core.account.AccountResponse.equals(java.lang.Object):boolean");
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getAccountStatus() {
        return this.accountStatus;
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

    public String getId() {
        return this.id;
    }

    public final AccountMetadata getMetadata() {
        return this.metadata;
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
        String str = this.paymentType;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accountId;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountStatus;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<PendingAction> list = this.actions;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        AccountMetadata accountMetadata = this.metadata;
        if (accountMetadata != null) {
            i = accountMetadata.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AccountResponse(statusCode=");
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
        outline73.append(", paymentType=");
        outline73.append(this.paymentType);
        outline73.append(", accountId=");
        outline73.append(this.accountId);
        outline73.append(", accountStatus=");
        outline73.append(this.accountStatus);
        outline73.append(", actions=");
        outline73.append(this.actions);
        outline73.append(", metadata=");
        outline73.append(this.metadata);
        outline73.append(")");
        return outline73.toString();
    }
}
