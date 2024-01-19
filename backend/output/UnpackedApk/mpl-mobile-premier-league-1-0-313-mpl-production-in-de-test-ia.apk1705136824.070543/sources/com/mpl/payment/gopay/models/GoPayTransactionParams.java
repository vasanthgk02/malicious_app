package com.mpl.payment.gopay.models;

import com.mpl.payment.routing.RoutingConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/mpl/payment/gopay/models/GoPayTransactionParams;", "", "merchantId", "", "callBackUrl", "merchantServerUrl", "accountId", "paymentOptionToken", "amount", "", "phoneNumber", "currency", "orderId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getAmount", "()J", "getCallBackUrl", "getCurrency", "getMerchantId", "getMerchantServerUrl", "getOrderId", "getPaymentOptionToken", "getPhoneNumber", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayTransactionParams.kt */
public final class GoPayTransactionParams {
    public final String accountId;
    public final long amount;
    public final String callBackUrl;
    public final String currency;
    public final String merchantId;
    public final String merchantServerUrl;
    public final String orderId;
    public final String paymentOptionToken;
    public final String phoneNumber;

    public GoPayTransactionParams(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, PaymentConstants.MERCHANT_ID_CAMEL);
        Intrinsics.checkNotNullParameter(str2, "callBackUrl");
        Intrinsics.checkNotNullParameter(str3, "merchantServerUrl");
        Intrinsics.checkNotNullParameter(str4, "accountId");
        Intrinsics.checkNotNullParameter(str5, "paymentOptionToken");
        Intrinsics.checkNotNullParameter(str6, RoutingConstants.KILLBILL_RAZORPAY_MO_NUMBER);
        Intrinsics.checkNotNullParameter(str7, "currency");
        Intrinsics.checkNotNullParameter(str8, "orderId");
        this.merchantId = str;
        this.callBackUrl = str2;
        this.merchantServerUrl = str3;
        this.accountId = str4;
        this.paymentOptionToken = str5;
        this.amount = j;
        this.phoneNumber = str6;
        this.currency = str7;
        this.orderId = str8;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final String getCallBackUrl() {
        return this.callBackUrl;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getMerchantServerUrl() {
        return this.merchantServerUrl;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPaymentOptionToken() {
        return this.paymentOptionToken;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }
}
