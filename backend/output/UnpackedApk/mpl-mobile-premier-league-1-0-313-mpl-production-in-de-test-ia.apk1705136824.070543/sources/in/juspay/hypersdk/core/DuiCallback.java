package in.juspay.hypersdk.core;

public interface DuiCallback {
    void addJsToWebView(String str);

    InflateView getInflateView();

    DuiLogger getLogger();
}
