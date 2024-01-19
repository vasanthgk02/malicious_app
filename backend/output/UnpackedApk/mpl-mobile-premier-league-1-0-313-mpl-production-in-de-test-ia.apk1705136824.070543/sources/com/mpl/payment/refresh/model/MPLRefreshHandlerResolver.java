package com.mpl.payment.refresh.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.refresh.RefreshHandler;
import com.mpl.payment.refresh.RefreshHandlerResolver;
import com.mpl.payment.refresh.RefreshType;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0007\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/mpl/payment/refresh/model/MPLRefreshHandlerResolver;", "Lcom/mpl/payment/refresh/RefreshHandlerResolver;", "moshi", "Lcom/squareup/moshi/Moshi;", "reactPayload", "", "(Lcom/squareup/moshi/Moshi;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getReactPayload", "getRefreshHandler", "Lcom/mpl/payment/refresh/RefreshHandler;", "refreshType", "Lcom/mpl/payment/refresh/RefreshType;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MPLRefreshHandlerResolver.kt */
public final class MPLRefreshHandlerResolver implements RefreshHandlerResolver {
    public final String TAG = "MPLRefreshHandlerResolver";
    public final Moshi moshi;
    public final String reactPayload;

    public MPLRefreshHandlerResolver(Moshi moshi2, String str) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(str, "reactPayload");
        this.moshi = moshi2;
        this.reactPayload = str;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getReactPayload() {
        return this.reactPayload;
    }

    public RefreshHandler getRefreshHandler(RefreshType refreshType) {
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " refresh type not handled"));
    }

    public final String getTAG() {
        return this.TAG;
    }
}
