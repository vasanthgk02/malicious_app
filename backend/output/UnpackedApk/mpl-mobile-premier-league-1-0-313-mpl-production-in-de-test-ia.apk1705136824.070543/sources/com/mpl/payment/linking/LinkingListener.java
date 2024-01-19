package com.mpl.payment.linking;

import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/mpl/payment/linking/LinkingListener;", "", "onCleverTapEvent", "", "event", "", "eventProps", "Ljava/util/HashMap;", "onLinkingError", "error", "onLinkingFailed", "resultJsonString", "onLinkingSuccessful", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Linker.kt */
public interface LinkingListener {
    void onCleverTapEvent(String str, HashMap<String, Object> hashMap);

    void onLinkingError(String str);

    void onLinkingFailed(String str);

    void onLinkingSuccessful(String str);
}
