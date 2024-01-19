package in.juspay.hypersdk.mystique;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DUIWebViewClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
