package com.mpl.payment.common.config;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/mpl/payment/common/config/PaymentConfigProvider;", "", "getAllowedCardTypesForBraintree3ds", "", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaymentConfigProvider.kt */
public interface PaymentConfigProvider {
    List<String> getAllowedCardTypesForBraintree3ds();
}
