package in.juspay.hypersdk.ui;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import org.json.JSONObject;

@Keep
public interface HyperPaymentsCallback {
    WebViewClient createJuspaySafeWebViewClient();

    View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType);

    void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler);

    void onStartWaitingDialogCreated(View view);
}
