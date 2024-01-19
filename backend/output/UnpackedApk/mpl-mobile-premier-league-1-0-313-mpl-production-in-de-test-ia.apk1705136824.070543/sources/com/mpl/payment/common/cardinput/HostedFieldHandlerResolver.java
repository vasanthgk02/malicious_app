package com.mpl.payment.common.cardinput;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/mpl/payment/common/cardinput/HostedFieldHandlerResolver;", "", "getHostedFieldHandler", "Lcom/mpl/payment/common/cardinput/HostedFieldHandler;", "cardInputType", "Lcom/mpl/payment/common/cardinput/CardInputType;", "payload", "", "reactPayload", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: HostedFieldHandlerResolver.kt */
public interface HostedFieldHandlerResolver {
    HostedFieldHandler getHostedFieldHandler(CardInputType cardInputType, String str, String str2);
}
