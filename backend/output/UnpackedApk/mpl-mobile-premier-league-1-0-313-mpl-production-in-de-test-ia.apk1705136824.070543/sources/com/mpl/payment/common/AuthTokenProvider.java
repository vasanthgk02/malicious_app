package com.mpl.payment.common;

import com.mpl.network.modules.engine.MHeader;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mpl/payment/common/AuthTokenProvider;", "", "getAuthHeader", "Lcom/mpl/network/modules/engine/MHeader;", "getAuthToken", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: AuthTokenProvider.kt */
public interface AuthTokenProvider {
    MHeader getAuthHeader();

    String getAuthToken();
}
