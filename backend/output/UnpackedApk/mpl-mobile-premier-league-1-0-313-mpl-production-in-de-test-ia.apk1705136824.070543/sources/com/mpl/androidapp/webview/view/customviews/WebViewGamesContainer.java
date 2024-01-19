package com.mpl.androidapp.webview.view.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.core.widget.CompoundButtonCompat;
import com.mpl.androidapp.databinding.ContainerWebviewGamesBinding;
import com.mpl.androidapp.miniprofile.extensions.ViewExtKt;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jboss.netty.util.internal.jzlib.JZlib;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0017\u0018\u0000 /2\u00020\u0001:\u0002./B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\r\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0014J\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000eJ,\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010&\u001a\u00020\u0014J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001dJ\u000e\u0010+\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000eJ\b\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\u0014H\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/mpl/androidapp/webview/view/customviews/WebViewGamesContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/mpl/androidapp/databinding/ContainerWebviewGamesBinding;", "callback", "Lcom/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$Callback;", "loadingFinished", "", "redirect", "applySettingsForWebView", "Landroid/webkit/WebSettings;", "settings", "closeWebView", "", "destroyWebView", "gameCallBacks", "com/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$gameCallBacks$1", "()Lcom/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$gameCallBacks$1;", "handleNavigationUsingDevice", "handleNavigationUsingWebView", "loadWebViewFromUrl", "loadingUrl", "", "loaderVisibility", "isVisible", "publishCtEventForErrorTracking", "errorCode", "view", "Landroid/webkit/WebView;", "description", "failingUrl", "reloadWebView", "setCallback", "setDataForUI", "gameName", "gameIcon", "setLoaderVisibility", "webViewLoading", "webViewSetting", "Callback", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGamesContainer.kt */
public final class WebViewGamesContainer extends LinearLayout {
    public static final Companion Companion = new Companion(null);
    public static final boolean DISABLED = false;
    public static final boolean ENABLED = true;
    public static final String ENCODING_NAME = "utf-8";
    public static final String WEB_JAVASCRIPT_NAME = "mplAndroidView";
    public Map<Integer, View> _$_findViewCache;
    public ContainerWebviewGamesBinding binding;
    public Callback callback;
    public boolean loadingFinished;
    public boolean redirect;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0006H&J\u001c\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u001c\u001a\u00020\u0003H&¨\u0006\u001d"}, d2 = {"Lcom/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$Callback;", "", "closeWeb", "", "closeWebViewWithReason", "failReason", "", "failUrl", "ctEventForWebViewLoading", "timeTaken", "", "initiateShare", "gameName", "screenName", "shareMessage", "platform", "isWebViewLoading", "isLoading", "", "openDeepLink", "actionParams", "performAction", "action", "publishEventToCtForError", "message", "sendEvent", "eventName", "eventProps", "showNavigationToMplDialog", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGamesContainer.kt */
    public interface Callback {
        void closeWeb();

        void closeWebViewWithReason(String str, String str2);

        void ctEventForWebViewLoading(long j);

        void initiateShare(String str, String str2, String str3, String str4);

        void isWebViewLoading(boolean z);

        void openDeepLink(String str);

        void performAction(String str);

        void publishEventToCtForError(String str);

        void sendEvent(String str, String str2);

        void showNavigationToMplDialog();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$Companion;", "", "()V", "DISABLED", "", "ENABLED", "ENCODING_NAME", "", "WEB_JAVASCRIPT_NAME", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGamesContainer.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGamesContainer(Context context) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, null, 0, 6, null);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGamesContainer(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WebViewGamesContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final WebSettings applySettingsForWebView(WebSettings webSettings) {
        if (webSettings == null) {
            return null;
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(2);
        webSettings.setAppCacheEnabled(false);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setMixedContentMode(0);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setBuiltInZoomControls(true);
        setLayerType(2, null);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDefaultTextEncodingName(ENCODING_NAME);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);
        return webSettings;
    }

    private final WebViewGamesContainer$gameCallBacks$1 gameCallBacks() {
        return new WebViewGamesContainer$gameCallBacks$1(this);
    }

    private final void webViewLoading() {
        this.binding.webGamesLoaderView.setProgressType(true);
        this.binding.webGamesView.setWebViewClient(new WebViewGamesContainer$webViewLoading$1(this));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void closeWebView() {
        this.binding.webGamesView.destroy();
    }

    public final void destroyWebView() {
        CustomWebView customWebView = this.binding.webGamesView;
        customWebView.loadUrl(RNCWebViewManager.BLANK_URL);
        customWebView.clearHistory();
        customWebView.clearCache(true);
    }

    public final void handleNavigationUsingDevice() {
        CustomWebView customWebView = this.binding.webGamesView;
        if (customWebView.canGoBack()) {
            customWebView.goBack();
            return;
        }
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.showNavigationToMplDialog();
        }
    }

    public final void handleNavigationUsingWebView() {
        this.binding.webGamesView.evaluateJavascript("javascript: updateFromNative(\"back\")", null);
    }

    public final void loadWebViewFromUrl(String str) {
        if (str != null) {
            webViewSetting();
            webViewLoading();
            this.binding.webGamesView.loadUrl(str);
        }
    }

    public final void loaderVisibility(boolean z) {
        if (z) {
            this.binding.webGamesLoaderView.setVisibility(0);
            this.binding.webGamesView.setVisibility(8);
            return;
        }
        this.binding.webGamesLoaderView.setVisibility(8);
        this.binding.webGamesView.setVisibility(0);
    }

    public final void publishCtEventForErrorTracking(int i, WebView webView, String str, String str2) {
        String str3;
        switch (i) {
            case -15:
                str3 = "Too many requests during this load";
                break;
            case -14:
                str3 = "File not found";
                break;
            case -13:
                str3 = "Generic file error";
                break;
            case -12:
                str3 = "Check entered URL..";
                break;
            case -11:
                str3 = "Failed to perform SSL handshake";
                break;
            case -10:
                str3 = "unsupported scheme";
                break;
            case -9:
                str3 = "Too many redirects";
                break;
            case -8:
                str3 = "The server is taking too much time to communicate. Try again later.";
                break;
            case -7:
                str3 = "The server failed to communicate. Try again later.";
                break;
            case JZlib.Z_VERSION_ERROR /*-6*/:
                str3 = "Failed to connect to the server";
                break;
            case JZlib.Z_BUF_ERROR /*-5*/:
                str3 = "User authentication failed on proxy";
                break;
            case -4:
                str3 = "User authentication failed on server";
                break;
            case -3:
                str3 = "Unsupported authentication scheme (not basic or digest)";
                break;
            case -2:
                str3 = "Server or proxy hostname lookup failed";
                break;
            case -1:
                str3 = "Generic error";
                break;
            default:
                str3 = "";
                break;
        }
        if (str3.length() == 0) {
            str3 = Intrinsics.stringPlus("The server gave error with error code: -> ", Integer.valueOf(i));
        }
        if (!(str == null || str2 == null)) {
            String stringPlus = Intrinsics.stringPlus("Description: -> ", str);
            String stringPlus2 = Intrinsics.stringPlus("Failed Url: -> ", str2);
            str3 = str3 + 10 + stringPlus + 10 + stringPlus2;
        }
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.publishEventToCtForError(str3);
        }
    }

    public final void reloadWebView() {
        this.binding.webGamesView.reload();
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public final void setDataForUI(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "gameName");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_GAME_ICON);
        this.binding.webGamesLoaderView.setHeaderText(str);
        this.binding.webGamesLoaderView.setGameIcon(str2);
    }

    public final void setLoaderVisibility(boolean z) {
        ContainerWebviewGamesBinding containerWebviewGamesBinding = this.binding;
        if (z) {
            CustomWebView customWebView = containerWebviewGamesBinding.webGamesView;
            Intrinsics.checkNotNullExpressionValue(customWebView, "webGamesView");
            ViewExtKt.setVisibleOrGone(customWebView, true);
            return;
        }
        CustomWebView customWebView2 = containerWebviewGamesBinding.webGamesView;
        Intrinsics.checkNotNullExpressionValue(customWebView2, "webGamesView");
        ViewExtKt.setVisibleOrGone(customWebView2, true);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void webViewSetting() {
        CustomWebView customWebView = this.binding.webGamesView;
        customWebView.setBackgroundColor(0);
        customWebView.setLayerType(2, null);
        WebSettings settings = customWebView.getSettings();
        if (settings != null) {
            applySettingsForWebView(settings);
        }
        customWebView.addJavascriptInterface(gameCallBacks(), WEB_JAVASCRIPT_NAME);
        if (VERSION.SDK_INT >= 26) {
            customWebView.setRendererPriorityPolicy(2, true);
        }
        if (CompoundButtonCompat.isFeatureSupported("FORCE_DARK")) {
            CompoundButtonCompat.setForceDark(customWebView.getSettings(), 0);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGamesContainer(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        ContainerWebviewGamesBinding inflate = ContainerWebviewGamesBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…ontext), this, true\n    )");
        this.binding = inflate;
        this.loadingFinished = true;
        this._$_findViewCache = new LinkedHashMap();
    }
}
