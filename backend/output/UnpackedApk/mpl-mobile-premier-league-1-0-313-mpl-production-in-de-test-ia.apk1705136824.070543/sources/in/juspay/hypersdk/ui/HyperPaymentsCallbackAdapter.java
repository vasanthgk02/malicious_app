package in.juspay.hypersdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import in.juspay.hypersdk.core.JuspayCallback;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import org.json.JSONObject;

public abstract class HyperPaymentsCallbackAdapter implements JuspayCallback, HyperPaymentsCallback {
    public static <T extends HyperPaymentsCallback & JuspayCallback> HyperPaymentsCallbackAdapter createDelegate(final T t) {
        return new HyperPaymentsCallbackAdapter() {
            public WebViewClient createJuspaySafeWebViewClient() {
                return HyperPaymentsCallback.this.createJuspaySafeWebViewClient();
            }

            public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
                return HyperPaymentsCallback.this.getMerchantView(viewGroup, merchantViewType);
            }

            public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
                HyperPaymentsCallback.this.onEvent(jSONObject, juspayResponseHandler);
            }

            public void onResult(int i, int i2, Intent intent) {
                ((JuspayCallback) HyperPaymentsCallback.this).onResult(i, i2, intent);
            }

            public void onStartWaitingDialogCreated(View view) {
                HyperPaymentsCallback.this.onStartWaitingDialogCreated(view);
            }
        };
    }

    public static HyperPaymentsCallbackAdapter createHyperDelegate(final HyperPaymentsCallback hyperPaymentsCallback) {
        return new HyperPaymentsCallbackAdapter() {
            public WebViewClient createJuspaySafeWebViewClient() {
                return HyperPaymentsCallback.this.createJuspaySafeWebViewClient();
            }

            public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
                return HyperPaymentsCallback.this.getMerchantView(viewGroup, merchantViewType);
            }

            public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
                HyperPaymentsCallback.this.onEvent(jSONObject, juspayResponseHandler);
            }

            public void onStartWaitingDialogCreated(View view) {
                HyperPaymentsCallback.this.onStartWaitingDialogCreated(view);
            }
        };
    }

    public static HyperPaymentsCallbackAdapter createJuspayDelegate(final JuspayCallback juspayCallback) {
        return new HyperPaymentsCallbackAdapter() {
            public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
            }

            public void onResult(int i, int i2, Intent intent) {
                JuspayCallback.this.onResult(i, i2, intent);
            }
        };
    }

    @Deprecated
    public static HyperPaymentsCallbackAdapter createJuspayPaymentsDelegate(final JuspayPaymentsCallback juspayPaymentsCallback) {
        return new HyperPaymentsCallbackAdapter() {
            public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
                return JuspayPaymentsCallback.this.getMerchantView(viewGroup, merchantViewType);
            }

            public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
                JuspayPaymentsCallback.this.onEvent(jSONObject.toString(), juspayResponseHandler);
            }

            public void onResult(int i, int i2, Intent intent) {
                JuspayPaymentsCallback.this.onResult(i, i2, intent);
            }

            public void onStartWaitingDialogCreated(View view) {
                JuspayPaymentsCallback.this.onStartWaitingDialogCreated(view);
            }
        };
    }

    public WebViewClient createJuspaySafeWebViewClient() {
        return null;
    }

    public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
        return null;
    }

    public void onResult(int i, int i2, Intent intent) {
    }

    public void onStartWaitingDialogCreated(View view) {
    }
}
