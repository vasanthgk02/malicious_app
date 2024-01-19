package com.mpl.payment.cardverification.models;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/mpl/payment/cardverification/models/PaymentMethodInfo;", "", "token", "", "plugin", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlugin", "()Ljava/lang/String;", "getToken", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChargeCardPayload.kt */
public final class PaymentMethodInfo {
    public final String plugin;
    public final String token;

    public PaymentMethodInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "plugin");
        this.token = str;
        this.plugin = str2;
    }

    public final String getPlugin() {
        return this.plugin;
    }

    public final String getToken() {
        return this.token;
    }
}
