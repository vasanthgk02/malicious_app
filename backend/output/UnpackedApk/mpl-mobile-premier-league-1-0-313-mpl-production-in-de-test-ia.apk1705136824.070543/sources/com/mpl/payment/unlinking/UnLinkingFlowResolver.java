package com.mpl.payment.unlinking;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/mpl/payment/unlinking/UnLinkingFlowResolver;", "", "resolveLinkingHandler", "unlinkingType", "Lcom/mpl/payment/unlinking/UnlinkingType;", "unlinkingListener", "Lcom/mpl/payment/unlinking/UnlinkingListener;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: UnLinkingFlowResolver.kt */
public interface UnLinkingFlowResolver {
    Object resolveLinkingHandler(UnlinkingType unlinkingType, UnlinkingListener unlinkingListener);
}
