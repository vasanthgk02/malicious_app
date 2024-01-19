package com.mpl.payment.juspayhypersdk.refresh;

import com.mpl.payment.juspayhypersdk.HyperServiceProcessPayloadListener;
import com.mpl.payment.refresh.RefreshResultListener;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/mpl/payment/juspayhypersdk/refresh/JuspaySingleWalletRefreshHandler$refreshInstrument$hyperServiceProcessPayloadListener$1", "Lcom/mpl/payment/juspayhypersdk/HyperServiceProcessPayloadListener;", "onCleverTapEvent", "", "event", "", "eventProps", "Ljava/util/HashMap;", "", "onError", "message", "onPayloadExtracted", "payload", "Lorg/json/JSONObject;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: JuspaySingleWalletRefreshHandler.kt */
public final class JuspaySingleWalletRefreshHandler$refreshInstrument$hyperServiceProcessPayloadListener$1 implements HyperServiceProcessPayloadListener {
    public final /* synthetic */ RefreshResultListener $refreshResultListener;
    public final /* synthetic */ JuspaySingleWalletRefreshHandler this$0;

    public JuspaySingleWalletRefreshHandler$refreshInstrument$hyperServiceProcessPayloadListener$1(JuspaySingleWalletRefreshHandler juspaySingleWalletRefreshHandler, RefreshResultListener refreshResultListener) {
        this.this$0 = juspaySingleWalletRefreshHandler;
        this.$refreshResultListener = refreshResultListener;
    }

    public void onCleverTapEvent(String str, HashMap<String, Object> hashMap) {
    }

    public void onError(String str) {
        RefreshResultListener refreshResultListener = this.$refreshResultListener;
        if (str == null) {
            str = this.this$0.getTAG() + " onError called with null string";
        }
        refreshResultListener.onFailure(str);
    }

    public void onPayloadExtracted(JSONObject jSONObject) {
        try {
            this.this$0.processResponsePayload(jSONObject);
        } catch (Exception e2) {
            RefreshResultListener refreshResultListener = this.$refreshResultListener;
            String message = e2.getMessage();
            if (message == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.this$0.getTAG());
                sb.append(" Exception in processResponsePayload payload was -> ");
                sb.append(jSONObject != null ? jSONObject.toString() : null);
                message = sb.toString();
            }
            refreshResultListener.onFailure(message);
        }
    }
}
