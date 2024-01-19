package com.mpl.payment.linking;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.payment.linking.models.ReactLinkingPayload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0014\u0010\u0007\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/mpl/payment/linking/ReactParamLinkingRouter;", "Lcom/mpl/payment/linking/LinkingRouter;", "moshi", "Lcom/squareup/moshi/Moshi;", "reactPayloadString", "", "(Lcom/squareup/moshi/Moshi;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getReactPayloadString", "getLinkingType", "Lcom/mpl/payment/linking/LinkingType;", "getLinkingTypeForWallet", "paymentMode", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReactParamLinkingRouter.kt */
public final class ReactParamLinkingRouter implements LinkingRouter {
    public static final Companion Companion = new Companion(null);
    public static final String PMT_WALLET = "wallet";
    public static final String PM_AMAZON = "amazonpay";
    public static final String PM_GOPAY = "gopay";
    public final String TAG = "ReactParamLinkingRouter";
    public final Moshi moshi;
    public final String reactPayloadString;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/payment/linking/ReactParamLinkingRouter$Companion;", "", "()V", "PMT_WALLET", "", "PM_AMAZON", "PM_GOPAY", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReactParamLinkingRouter.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ReactParamLinkingRouter(Moshi moshi2, String str) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(str, "reactPayloadString");
        this.moshi = moshi2;
        this.reactPayloadString = str;
    }

    private final LinkingType getLinkingTypeForWallet(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            int hashCode = lowerCase.hashCode();
            if (hashCode != 98540224) {
                if (hashCode == 1250540580 && lowerCase.equals(PM_AMAZON)) {
                    return LinkingType.AMAZON;
                }
            } else if (lowerCase.equals("gopay")) {
                return LinkingType.GOPAY;
            }
            throw new Exception(this.TAG + " paymentMode " + str + " not supported");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public LinkingType getLinkingType() {
        JsonAdapter<ReactLinkingPayload> adapter = this.moshi.adapter(ReactLinkingPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(ReactLinkingPayload::class.java)");
        ReactLinkingPayload reactLinkingPayload = (ReactLinkingPayload) adapter.fromJson(this.reactPayloadString);
        if (reactLinkingPayload != null) {
            String paymentMethodType = reactLinkingPayload.getPaymentMethodType();
            if (paymentMethodType.hashCode() == -795192327 && paymentMethodType.equals("wallet")) {
                return getLinkingTypeForWallet(reactLinkingPayload.getPaymentMode());
            }
            throw new Exception(this.TAG + " paymentMethodType " + reactLinkingPayload.getPaymentMethodType() + " not supported");
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " parsed react json should not be null"));
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
}
