package com.mpl.payment.juspayhypersdk;

import com.mpl.payment.common.upi.UpiAppListener;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* compiled from: JusPayUpiApptListProvider.kt */
public final /* synthetic */ class JusPayUpiAppListProvider$getValidUpiApps$1 extends MutablePropertyReference0Impl {
    public JusPayUpiAppListProvider$getValidUpiApps$1(JusPayUpiAppListProvider jusPayUpiAppListProvider) {
        super(jusPayUpiAppListProvider, JusPayUpiAppListProvider.class, "upiAppListener", "getUpiAppListener()Lcom/mpl/payment/common/upi/UpiAppListener;", 0);
    }

    public Object get() {
        return ((JusPayUpiAppListProvider) this.receiver).getUpiAppListener();
    }

    public void set(Object obj) {
        ((JusPayUpiAppListProvider) this.receiver).setUpiAppListener((UpiAppListener) obj);
    }
}
