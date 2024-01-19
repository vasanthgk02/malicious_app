package com.mpl.payment.gopay.models;

import com.squareup.moshi.JsonClass;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/mpl/payment/gopay/models/GoPayUnlinkingPayload;", "", "merchantId", "", "callBackUrl", "merchantServerUrl", "accountId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getCallBackUrl", "getMerchantId", "getMerchantServerUrl", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayUnlinkingPayload.kt */
public final class GoPayUnlinkingPayload {
    public final String accountId;
    public final String callBackUrl;
    public final String merchantId;
    public final String merchantServerUrl;

    public GoPayUnlinkingPayload(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str2, "callBackUrl");
        Intrinsics.checkNotNullParameter(str3, "merchantServerUrl");
        Intrinsics.checkNotNullParameter(str4, "accountId");
        this.merchantId = str;
        this.callBackUrl = str2;
        this.merchantServerUrl = str3;
        this.accountId = str4;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getCallBackUrl() {
        return this.callBackUrl;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getMerchantServerUrl() {
        return this.merchantServerUrl;
    }
}
