package com.mpl.payment.refresh;

import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/mpl/payment/refresh/RefreshManager;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "refreshHandlerResolver", "Lcom/mpl/payment/refresh/RefreshHandlerResolver;", "refreshRouter", "Lcom/mpl/payment/refresh/RefreshRouter;", "(Lcom/squareup/moshi/Moshi;Lcom/mpl/payment/refresh/RefreshHandlerResolver;Lcom/mpl/payment/refresh/RefreshRouter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "listener", "Lcom/mpl/payment/refresh/RefreshResultListener;", "getListener", "()Lcom/mpl/payment/refresh/RefreshResultListener;", "setListener", "(Lcom/mpl/payment/refresh/RefreshResultListener;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getRefreshHandlerResolver", "()Lcom/mpl/payment/refresh/RefreshHandlerResolver;", "getRefreshRouter", "()Lcom/mpl/payment/refresh/RefreshRouter;", "refreshInstrument", "", "refreshResultListener", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: RefreshManager.kt */
public final class RefreshManager {
    public final String TAG = "RefreshManager";
    public RefreshResultListener listener;
    public final Moshi moshi;
    public final RefreshHandlerResolver refreshHandlerResolver;
    public final RefreshRouter refreshRouter;

    public RefreshManager(Moshi moshi2, RefreshHandlerResolver refreshHandlerResolver2, RefreshRouter refreshRouter2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(refreshHandlerResolver2, "refreshHandlerResolver");
        Intrinsics.checkNotNullParameter(refreshRouter2, "refreshRouter");
        this.moshi = moshi2;
        this.refreshHandlerResolver = refreshHandlerResolver2;
        this.refreshRouter = refreshRouter2;
    }

    public final RefreshResultListener getListener() {
        return this.listener;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final RefreshHandlerResolver getRefreshHandlerResolver() {
        return this.refreshHandlerResolver;
    }

    public final RefreshRouter getRefreshRouter() {
        return this.refreshRouter;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void refreshInstrument(RefreshResultListener refreshResultListener) {
        Intrinsics.checkNotNullParameter(refreshResultListener, "refreshResultListener");
        this.refreshHandlerResolver.getRefreshHandler(this.refreshRouter.getRefreshType()).refreshInstrument(refreshResultListener);
    }

    public final void setListener(RefreshResultListener refreshResultListener) {
        this.listener = refreshResultListener;
    }
}
