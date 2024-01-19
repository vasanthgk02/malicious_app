package com.mpl.payment.juspayhypersdk;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/mpl/payment/juspayhypersdk/JusPayUpiAppListProvider$getValidUpiApps$2", "Lcom/mpl/payment/juspayhypersdk/HyperServiceProcessPayloadListener;", "onCleverTapEvent", "", "event", "", "eventProps", "Ljava/util/HashMap;", "", "onError", "message", "onPayloadExtracted", "payload", "Lorg/json/JSONObject;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: JusPayUpiApptListProvider.kt */
public final class JusPayUpiAppListProvider$getValidUpiApps$2 implements HyperServiceProcessPayloadListener {
    public final /* synthetic */ JusPayUpiAppListProvider this$0;

    public JusPayUpiAppListProvider$getValidUpiApps$2(JusPayUpiAppListProvider jusPayUpiAppListProvider) {
        this.this$0 = jusPayUpiAppListProvider;
    }

    public void onCleverTapEvent(String str, HashMap<String, Object> hashMap) {
        if (str != null && hashMap != null) {
            this.this$0.mplInstrumentationListener.onClevertapEvent(str, hashMap);
        }
    }

    public void onError(String str) {
        if (str == null) {
            str = "JusPayUpiAppListProvider onError called from HyperService with null error";
        }
        this.this$0.getUpiAppListener().onError(str);
    }

    public void onPayloadExtracted(JSONObject jSONObject) {
        try {
            this.this$0.getUpiAppListener().onAppListReceived(this.this$0.extractPackageList(this.this$0.getPayloadAsString(jSONObject)));
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception occured in JusPayUpiAppListProvider ");
            String message = e2.getMessage();
            if (message == null) {
                message = "Cannot determine message";
            }
            outline73.append(message);
            this.this$0.getUpiAppListener().onError(outline73.toString());
        }
    }
}
