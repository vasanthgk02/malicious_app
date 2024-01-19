package com.mpl.payment.common.upi;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/mpl/payment/common/upi/UpiAppListener;", "", "onAppListReceived", "", "validUpiAppPackageList", "Ljava/util/ArrayList;", "", "onError", "error", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpiAppListener.kt */
public interface UpiAppListener {
    void onAppListReceived(ArrayList<String> arrayList);

    void onError(String str);
}
