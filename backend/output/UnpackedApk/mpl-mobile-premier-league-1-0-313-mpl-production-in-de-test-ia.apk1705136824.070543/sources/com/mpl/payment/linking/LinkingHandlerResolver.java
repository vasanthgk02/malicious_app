package com.mpl.payment.linking;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/mpl/payment/linking/LinkingHandlerResolver;", "", "resolveLinkingHandler", "linkingType", "Lcom/mpl/payment/linking/LinkingType;", "linkingListener", "Lcom/mpl/payment/linking/LinkingListener;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: LinkingHandlerResolver.kt */
public interface LinkingHandlerResolver {
    Object resolveLinkingHandler(LinkingType linkingType, LinkingListener linkingListener);
}
