package com.mpl.payment.refresh.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.refresh.RefreshRouter;
import com.mpl.payment.refresh.RefreshType;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u0014\u0010\u0007\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/mpl/payment/refresh/model/ReactParamRefreshRouter;", "Lcom/mpl/payment/refresh/RefreshRouter;", "reactJsonPayload", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Ljava/lang/String;Lcom/squareup/moshi/Moshi;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getReactJsonPayload", "getRefreshType", "Lcom/mpl/payment/refresh/RefreshType;", "getRefreshTypeForWallet", "paymentMode", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReactParamRefreshRouter.kt */
public final class ReactParamRefreshRouter implements RefreshRouter {
    public static final Companion Companion = new Companion(null);
    public static final String PMT_WALLET = "wallet";
    public static final String PM_AMAZON = "amazon";
    public final String TAG = "ReactParamRefreshRouter";
    public final Moshi moshi;
    public final String reactJsonPayload;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/payment/refresh/model/ReactParamRefreshRouter$Companion;", "", "()V", "PMT_WALLET", "", "PM_AMAZON", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReactParamRefreshRouter.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReactParamRefreshRouter(String str, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(str, "reactJsonPayload");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.reactJsonPayload = str;
        this.moshi = moshi2;
    }

    private final RefreshType getRefreshTypeForWallet(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (lowerCase.hashCode() == -1414265340 && lowerCase.equals(PM_AMAZON)) {
                return RefreshType.JUSPAY_SINGLE_WALLET;
            }
            throw new Exception(GeneratedOutlineSupport.outline50("TAG unknown PaymentMode ", str));
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getReactJsonPayload() {
        return this.reactJsonPayload;
    }

    public RefreshType getRefreshType() {
        JsonAdapter<RefreshRoutingPayload> adapter = this.moshi.adapter(RefreshRoutingPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(RefreshRoutingPayload::class.java)");
        RefreshRoutingPayload refreshRoutingPayload = (RefreshRoutingPayload) adapter.fromJson(this.reactJsonPayload);
        if (refreshRoutingPayload != null) {
            String paymentMethodType = refreshRoutingPayload.getPaymentMethodType();
            if (paymentMethodType != null) {
                String lowerCase = paymentMethodType.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (lowerCase.hashCode() == -795192327 && lowerCase.equals("wallet")) {
                    return getRefreshTypeForWallet(refreshRoutingPayload.getPaymentMode());
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("TAG unknown PaymentMethodType ");
                outline73.append(refreshRoutingPayload.getPaymentMethodType());
                throw new Exception(outline73.toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " null RefreshRoutingPayload"));
    }

    public final String getTAG() {
        return this.TAG;
    }
}
