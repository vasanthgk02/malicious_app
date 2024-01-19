package com.mpl.payment.juspayhypersdk.refresh;

import androidx.fragment.app.FragmentActivity;
import com.mpl.payment.juspayhypersdk.model.RequestDetails;
import com.mpl.payment.juspayhypersdk.refresh.model.JuspaySingleWalletMplPayload;
import com.mpl.payment.juspayhypersdk.refresh.model.JuspaySingleWalletReactPayload;
import com.mpl.payment.juspayhypersdk.refresh.model.Payload;
import com.mpl.payment.juspayhypersdk.refresh.model.SingleWalletRefreshRequest;
import com.mpl.payment.juspayhypersdk.refresh.model.SingleWalletRefreshResponsePayload;
import com.mpl.payment.refresh.RefreshHandler;
import com.mpl.payment.refresh.RefreshResultListener;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/mpl/payment/juspayhypersdk/refresh/JuspaySingleWalletRefreshHandler;", "Lcom/mpl/payment/refresh/RefreshHandler;", "juspaySingleWalletReactPayload", "Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletReactPayload;", "juspaySingleWalletMplPayload", "Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletMplPayload;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletReactPayload;Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletMplPayload;Landroidx/fragment/app/FragmentActivity;Lcom/squareup/moshi/Moshi;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFragmentActivity", "()Landroidx/fragment/app/FragmentActivity;", "getJuspaySingleWalletMplPayload", "()Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletMplPayload;", "getJuspaySingleWalletReactPayload", "()Lcom/mpl/payment/juspayhypersdk/refresh/model/JuspaySingleWalletReactPayload;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getRequestDetails", "Lcom/mpl/payment/juspayhypersdk/model/RequestDetails;", "processResponsePayload", "", "payload", "Lorg/json/JSONObject;", "refreshInstrument", "refreshResultListener", "Lcom/mpl/payment/refresh/RefreshResultListener;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: JuspaySingleWalletRefreshHandler.kt */
public final class JuspaySingleWalletRefreshHandler implements RefreshHandler {
    public final String TAG = "SingleWalletRefreshHandler";
    public final FragmentActivity fragmentActivity;
    public final JuspaySingleWalletMplPayload juspaySingleWalletMplPayload;
    public final JuspaySingleWalletReactPayload juspaySingleWalletReactPayload;
    public final Moshi moshi;

    public JuspaySingleWalletRefreshHandler(JuspaySingleWalletReactPayload juspaySingleWalletReactPayload2, JuspaySingleWalletMplPayload juspaySingleWalletMplPayload2, FragmentActivity fragmentActivity2, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(juspaySingleWalletReactPayload2, "juspaySingleWalletReactPayload");
        Intrinsics.checkNotNullParameter(juspaySingleWalletMplPayload2, "juspaySingleWalletMplPayload");
        Intrinsics.checkNotNullParameter(fragmentActivity2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.juspaySingleWalletReactPayload = juspaySingleWalletReactPayload2;
        this.juspaySingleWalletMplPayload = juspaySingleWalletMplPayload2;
        this.fragmentActivity = fragmentActivity2;
        this.moshi = moshi2;
    }

    private final RequestDetails getRequestDetails() {
        Payload payload = new Payload(null, this.juspaySingleWalletReactPayload.getWalletId(), this.juspaySingleWalletReactPayload.getWalletName(), this.juspaySingleWalletReactPayload.getClientAuthToken(), false, 17, null);
        SingleWalletRefreshRequest singleWalletRefreshRequest = new SingleWalletRefreshRequest(null, null, payload, 3, null);
        JsonAdapter<SingleWalletRefreshRequest> adapter = this.moshi.adapter(SingleWalletRefreshRequest.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(SingleWall…freshRequest::class.java)");
        String json = adapter.toJson(singleWalletRefreshRequest);
        Intrinsics.checkNotNullExpressionValue(json, "refreshRequestAdapter.to…ngleWalletRefreshRequest)");
        return new RequestDetails(new JSONObject(json), singleWalletRefreshRequest.getRequestId());
    }

    /* access modifiers changed from: private */
    public final void processResponsePayload(JSONObject jSONObject) {
        if (jSONObject != null) {
            String jSONObject2 = jSONObject.toString();
        }
        Intrinsics.checkNotNullExpressionValue(this.moshi.adapter(SingleWalletRefreshResponsePayload.class), "moshi.adapter(SingleWall…ponsePayload::class.java)");
    }

    public final FragmentActivity getFragmentActivity() {
        return this.fragmentActivity;
    }

    public final JuspaySingleWalletMplPayload getJuspaySingleWalletMplPayload() {
        return this.juspaySingleWalletMplPayload;
    }

    public final JuspaySingleWalletReactPayload getJuspaySingleWalletReactPayload() {
        return this.juspaySingleWalletReactPayload;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public void refreshInstrument(RefreshResultListener refreshResultListener) {
        Intrinsics.checkNotNullParameter(refreshResultListener, "refreshResultListener");
        getRequestDetails();
        new JuspaySingleWalletRefreshHandler$refreshInstrument$hyperServiceProcessPayloadListener$1(this, refreshResultListener);
    }
}
