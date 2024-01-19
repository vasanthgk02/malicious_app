package com.mpl.payment.unlinking;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.unlinking.models.ReactUnlinkingPayload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016R\u0014\u0010\u0007\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/mpl/payment/unlinking/ReactParamUnlinkingRouter;", "Lcom/mpl/payment/unlinking/UnlinkingRouter;", "reactPayloadString", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Ljava/lang/String;Lcom/squareup/moshi/Moshi;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getReactPayloadString", "getUnLinkingTypeForWallet", "Lcom/mpl/payment/unlinking/UnlinkingType;", "paymentMode", "getUnlinkingType", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReactParamUnlinkingRouter.kt */
public final class ReactParamUnlinkingRouter implements UnlinkingRouter {
    public static final Companion Companion = new Companion(null);
    public static final String PMT_WALLET = "wallet";
    public static final String PM_GOPAY = "gopay";
    public final String TAG = "ReactParamUnlinkingRouter";
    public final Moshi moshi;
    public final String reactPayloadString;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mpl/payment/unlinking/ReactParamUnlinkingRouter$Companion;", "", "()V", "PMT_WALLET", "", "PM_GOPAY", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReactParamUnlinkingRouter.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReactParamUnlinkingRouter(String str, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(str, "reactPayloadString");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.reactPayloadString = str;
        this.moshi = moshi2;
    }

    private final UnlinkingType getUnLinkingTypeForWallet(String str) {
        if (str.hashCode() == 98540224 && str.equals("gopay")) {
            return UnlinkingType.GOPAY;
        }
        throw new Exception(this.TAG + " paymentMode " + str + " not supported");
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getReactPayloadString() {
        return this.reactPayloadString;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public UnlinkingType getUnlinkingType() {
        JsonAdapter<ReactUnlinkingPayload> adapter = this.moshi.adapter(ReactUnlinkingPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ReactUnlinkingPayload::class.java)");
        ReactUnlinkingPayload reactUnlinkingPayload = (ReactUnlinkingPayload) adapter.fromJson(this.reactPayloadString);
        if (reactUnlinkingPayload != null) {
            Intrinsics.checkNotNullExpressionValue(reactUnlinkingPayload, "unlinkingPayloadAdapter.…json should not be null\")");
            String paymentMethodType = reactUnlinkingPayload.getPaymentMethodType();
            if (paymentMethodType.hashCode() == -795192327 && paymentMethodType.equals("wallet")) {
                return getUnLinkingTypeForWallet(reactUnlinkingPayload.getPaymentMode());
            }
            throw new Exception(this.TAG + " paymentMethodType " + reactUnlinkingPayload.getPaymentMethodType() + " not supported");
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " parsed react json should not be null"));
    }
}
