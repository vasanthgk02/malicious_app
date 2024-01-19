package com.mpl.payment.linking;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/linking/PaymentMethodLinker;", "Lcom/mpl/payment/linking/Linker;", "linkingRouter", "Lcom/mpl/payment/linking/LinkingRouter;", "linkingHandlerResolver", "Lcom/mpl/payment/linking/LinkingHandlerResolver;", "listener", "Lcom/mpl/payment/linking/LinkingListener;", "(Lcom/mpl/payment/linking/LinkingRouter;Lcom/mpl/payment/linking/LinkingHandlerResolver;Lcom/mpl/payment/linking/LinkingListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLinkingHandlerResolver", "()Lcom/mpl/payment/linking/LinkingHandlerResolver;", "getLinkingRouter", "()Lcom/mpl/payment/linking/LinkingRouter;", "getListener", "()Lcom/mpl/payment/linking/LinkingListener;", "linkPaymentMethod", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaymentMethodLinker.kt */
public final class PaymentMethodLinker implements Linker {
    public final String TAG = "PaymentMethodLinker";
    public final LinkingHandlerResolver linkingHandlerResolver;
    public final LinkingRouter linkingRouter;
    public final LinkingListener listener;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LinkingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LinkingType linkingType = LinkingType.GOPAY;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            LinkingType linkingType2 = LinkingType.AMAZON;
            iArr2[1] = 2;
        }
    }

    public PaymentMethodLinker(LinkingRouter linkingRouter2, LinkingHandlerResolver linkingHandlerResolver2, LinkingListener linkingListener) {
        Intrinsics.checkNotNullParameter(linkingRouter2, "linkingRouter");
        Intrinsics.checkNotNullParameter(linkingHandlerResolver2, "linkingHandlerResolver");
        Intrinsics.checkNotNullParameter(linkingListener, "listener");
        this.linkingRouter = linkingRouter2;
        this.linkingHandlerResolver = linkingHandlerResolver2;
        this.listener = linkingListener;
    }

    public final LinkingHandlerResolver getLinkingHandlerResolver() {
        return this.linkingHandlerResolver;
    }

    public final LinkingRouter getLinkingRouter() {
        return this.linkingRouter;
    }

    public final LinkingListener getListener() {
        return this.listener;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public void linkPaymentMethod() {
        LinkingType linkingType = this.linkingRouter.getLinkingType();
        int ordinal = linkingType.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            Object resolveLinkingHandler = this.linkingHandlerResolver.resolveLinkingHandler(linkingType, this.listener);
            if (!(resolveLinkingHandler instanceof LinkingHandler)) {
                resolveLinkingHandler = null;
            }
            LinkingHandler linkingHandler = (LinkingHandler) resolveLinkingHandler;
            if (linkingHandler != null) {
                linkingHandler.performLinking();
                return;
            }
            throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " gopay resolved to wrong flow"));
        }
        throw new Exception(this.TAG + " can't handle linking type " + linkingType);
    }
}
