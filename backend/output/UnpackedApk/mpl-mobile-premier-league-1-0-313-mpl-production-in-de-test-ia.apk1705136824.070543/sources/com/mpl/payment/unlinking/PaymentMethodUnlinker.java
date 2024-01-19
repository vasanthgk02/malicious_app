package com.mpl.payment.unlinking;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/mpl/payment/unlinking/PaymentMethodUnlinker;", "Lcom/mpl/payment/unlinking/Unlinker;", "unlinkingRouter", "Lcom/mpl/payment/unlinking/UnlinkingRouter;", "unlinkingFlowResolver", "Lcom/mpl/payment/unlinking/UnLinkingFlowResolver;", "listener", "Lcom/mpl/payment/unlinking/UnlinkingListener;", "(Lcom/mpl/payment/unlinking/UnlinkingRouter;Lcom/mpl/payment/unlinking/UnLinkingFlowResolver;Lcom/mpl/payment/unlinking/UnlinkingListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getListener", "()Lcom/mpl/payment/unlinking/UnlinkingListener;", "setListener", "(Lcom/mpl/payment/unlinking/UnlinkingListener;)V", "getUnlinkingFlowResolver", "()Lcom/mpl/payment/unlinking/UnLinkingFlowResolver;", "getUnlinkingRouter", "()Lcom/mpl/payment/unlinking/UnlinkingRouter;", "unlinkPaymentMethod", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PaymentMethodUnlinker.kt */
public final class PaymentMethodUnlinker implements Unlinker {
    public final String TAG = "PaymentMethodUnlinker";
    public UnlinkingListener listener;
    public final UnLinkingFlowResolver unlinkingFlowResolver;
    public final UnlinkingRouter unlinkingRouter;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnlinkingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            UnlinkingType unlinkingType = UnlinkingType.GOPAY;
            iArr[0] = 1;
        }
    }

    public PaymentMethodUnlinker(UnlinkingRouter unlinkingRouter2, UnLinkingFlowResolver unLinkingFlowResolver, UnlinkingListener unlinkingListener) {
        Intrinsics.checkNotNullParameter(unlinkingRouter2, "unlinkingRouter");
        Intrinsics.checkNotNullParameter(unLinkingFlowResolver, "unlinkingFlowResolver");
        Intrinsics.checkNotNullParameter(unlinkingListener, "listener");
        this.unlinkingRouter = unlinkingRouter2;
        this.unlinkingFlowResolver = unLinkingFlowResolver;
        this.listener = unlinkingListener;
    }

    public final UnlinkingListener getListener() {
        return this.listener;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final UnLinkingFlowResolver getUnlinkingFlowResolver() {
        return this.unlinkingFlowResolver;
    }

    public final UnlinkingRouter getUnlinkingRouter() {
        return this.unlinkingRouter;
    }

    public final void setListener(UnlinkingListener unlinkingListener) {
        Intrinsics.checkNotNullParameter(unlinkingListener, "<set-?>");
        this.listener = unlinkingListener;
    }

    public void unlinkPaymentMethod() {
        UnlinkingType unlinkingType = this.unlinkingRouter.getUnlinkingType();
        if (unlinkingType.ordinal() == 0) {
            Object resolveLinkingHandler = this.unlinkingFlowResolver.resolveLinkingHandler(unlinkingType, this.listener);
            if (!(resolveLinkingHandler instanceof UnlinkingHandler)) {
                resolveLinkingHandler = null;
            }
            UnlinkingHandler unlinkingHandler = (UnlinkingHandler) resolveLinkingHandler;
            if (unlinkingHandler != null) {
                unlinkingHandler.performUnLinking();
                return;
            }
            throw new Exception("$ TAG gopay unlinking has incorrect flow");
        }
        throw new Exception(this.TAG + " can't handle unlinking type " + unlinkingType);
    }
}
