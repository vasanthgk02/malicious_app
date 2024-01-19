package com.mpl.payment.refresh;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mpl/payment/refresh/RefreshHandlerResolver;", "", "getRefreshHandler", "Lcom/mpl/payment/refresh/RefreshHandler;", "refreshType", "Lcom/mpl/payment/refresh/RefreshType;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: RefreshHandlerResolver.kt */
public interface RefreshHandlerResolver {
    RefreshHandler getRefreshHandler(RefreshType refreshType);
}
