package in.juspay.hypersdk.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import in.juspay.hypersdk.core.JuspayCallback;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.data.JuspayResponseHandler;

@Deprecated
@Keep
public interface JuspayPaymentsCallback extends JuspayCallback {
    View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType);

    void onEvent(String str, JuspayResponseHandler juspayResponseHandler);

    void onStartWaitingDialogCreated(View view);
}
