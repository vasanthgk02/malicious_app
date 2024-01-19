package in.juspay.hypersdk.ui;

import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import in.juspay.hypersdk.core.HyperFragment;

public class JuspayWebChromeClient extends WebChromeClient {
    public static int currentProgress;
    public HyperFragment browserFragment;

    public JuspayWebChromeClient() {
    }

    public JuspayWebChromeClient(HyperFragment hyperFragment) {
        this.browserFragment = hyperFragment;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (this.browserFragment.getDuiInterface() != null) {
            this.browserFragment.getDuiInterface().invokeFnInDUIWebview("onProgressChanged", String.valueOf(i));
        }
    }

    public void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j * 2);
    }
}
