package com.mpl.androidapp.utils;

import com.mpl.network.modules.engine.MHeader;
import com.mpl.payment.common.AuthTokenProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/utils/MPLAuthTokenProvider;", "Lcom/mpl/payment/common/AuthTokenProvider;", "()V", "getAuthHeader", "Lcom/mpl/network/modules/engine/MHeader;", "getAuthToken", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MPLAuthTokenProvider.kt */
public final class MPLAuthTokenProvider implements AuthTokenProvider {
    public MHeader getAuthHeader() {
        return new MHeader("Authorization", Intrinsics.stringPlus("Bearer ", getAuthToken()));
    }

    public String getAuthToken() {
        String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
        return accessUserToken == null ? "" : accessUserToken;
    }
}
