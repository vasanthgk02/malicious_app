package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.xiaomi.mipush.sdk.Constants;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.mystique.DUIWebViewClient;
import in.juspay.hypersdk.mystique.ErrorCallback;
import in.juspay.hypersdk.mystique.PropHandler;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class DynamicUI {
    public Activity activity;
    public final AndroidInterface androidInterface;
    public Context appContext;
    public final WebView browser;
    public FrameLayout container;
    public ErrorCallback errCallback;
    public HashMap<String, ViewGroup> fragments;
    public PropHandler handler;
    public final InflateView inflateView;
    public DuiLogger mLogger;
    public final Renderer renderer;
    public final Map<String, Object> screenMap;

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public DynamicUI(Context context, FrameLayout frameLayout, Bundle bundle, ErrorCallback errorCallback) {
        this(context, frameLayout, errorCallback);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public DynamicUI(Context context, FrameLayout frameLayout, ErrorCallback errorCallback) {
        this.mLogger = new DuiLogger() {
            public void d(String str, String str2) {
            }

            public void e(String str, String str2) {
            }

            public void i(String str, String str2) {
            }
        };
        this.errCallback = errorCallback;
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
        this.appContext = context.getApplicationContext();
        this.container = frameLayout;
        this.screenMap = new HashMap();
        this.fragments = new HashMap<>();
        this.browser = new WebView(this.appContext);
        setupWebView();
        FrameLayout frameLayout2 = this.container;
        if (frameLayout2 != null && frameLayout2.isHardwareAccelerated()) {
            this.container.setLayerType(2, null);
        }
        this.browser.getSettings().setJavaScriptEnabled(true);
        this.androidInterface = new AndroidInterface(this);
        this.renderer = new Renderer(this);
        this.inflateView = new InflateView(this);
        this.browser.addJavascriptInterface(this.androidInterface, "Android");
    }

    /* access modifiers changed from: private */
    public String getStringStackTrace(Object obj) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : ((Exception) obj).getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void loadData() {
        this.browser.loadDataWithBaseURL(null, Base.BASE_HTML_CONTENT, RNCWebViewManager.HTML_MIME_TYPE, WebViewGamesContainer.ENCODING_NAME, null);
    }

    /* access modifiers changed from: private */
    public void logError(String str) {
        this.mLogger.e("DynamicUI", str);
    }

    private void setupWebView() {
        WebChromeClient webChromeClient;
        WebView webView;
        if (this.appContext.getResources().getBoolean(R.bool.godel_debuggable)) {
            webView = this.browser;
            webChromeClient = new WebChromeClient();
        } else {
            webView = this.browser;
            webChromeClient = new WebChromeClient() {
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    return true;
                }
            };
        }
        webView.setWebChromeClient(webChromeClient);
        this.browser.setWebViewClient(new DUIWebViewClient());
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        this.browser.addJavascriptInterface(obj, str);
    }

    public void addJsToWebView(final String str) {
        boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
        AnonymousClass3 r1 = new Runnable() {
            public void run() {
                StringBuilder sb;
                ErrorCallback errorCallback;
                try {
                    if (DynamicUI.this.browser != null) {
                        DynamicUI.this.browser.evaluateJavascript(str, null);
                    } else {
                        DynamicUI.this.logError("browser null, call start first");
                    }
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    DynamicUI dynamicUI = DynamicUI.this;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("OutOfMemoryError :");
                    outline73.append(DynamicUI.this.getStringStackTrace(e));
                    dynamicUI.logError(outline73.toString());
                    errorCallback = DynamicUI.this.errCallback;
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(DynamicUI.this.getStringStackTrace(e));
                    errorCallback.onError("addJsToWebView", sb.toString());
                } catch (Exception e3) {
                    e = e3;
                    DynamicUI dynamicUI2 = DynamicUI.this;
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Exception :");
                    outline732.append(DynamicUI.this.getStringStackTrace(e));
                    dynamicUI2.logError(outline732.toString());
                    errorCallback = DynamicUI.this.errCallback;
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(DynamicUI.this.getStringStackTrace(e));
                    errorCallback.onError("addJsToWebView", sb.toString());
                }
            }
        };
        if (z) {
            r1.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r1);
        }
    }

    public String addToContainerList(ViewGroup viewGroup) {
        String uuid = UUID.randomUUID().toString();
        this.fragments.put(uuid, viewGroup);
        return uuid;
    }

    public void addToScreenMap(String str, Object obj) {
        this.screenMap.put(str, obj);
    }

    public void destroy() {
        WebView webView = this.browser;
        if (webView != null) {
            webView.loadDataWithBaseURL("http://juspay.in", "<html></html>", RNCWebViewManager.HTML_MIME_TYPE, WebViewGamesContainer.ENCODING_NAME, null);
            this.browser.stopLoading();
            this.browser.destroy();
            return;
        }
        logError("Browser is not present");
    }

    public void forceSaveState() {
        addJsToWebView("window.callUICallback(forceSaveState,'failure');");
    }

    public Activity getActivity() {
        return this.activity;
    }

    public AndroidInterface getAndroidInterface() {
        return this.androidInterface;
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public ViewGroup getContainer(String str) {
        return str == null ? this.container : this.fragments.get(str);
    }

    public ErrorCallback getErrorCallback() {
        return this.errCallback;
    }

    public PropHandler getHandler() {
        return this.handler;
    }

    public InflateView getInflateView() {
        return this.inflateView;
    }

    public DuiLogger getLogger() {
        return this.mLogger;
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public String getState() {
        return this.androidInterface.getState();
    }

    public Object getViewFromScreenName(String str) {
        if (this.screenMap.containsKey(str)) {
            return this.screenMap.get(str);
        }
        return null;
    }

    public void loadBaseHtml() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadData();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    DynamicUI.this.loadData();
                }
            });
        }
    }

    public void onActivityLifeCycleEvent(String str) {
        addJsToWebView("window.onActivityLifeCycleEvent('" + str + "')");
    }

    public void onBackPressed() {
        addJsToWebView("window.onBackpressed()");
    }

    public void removeFromContainerList(String str) {
        this.fragments.remove(str);
    }

    public void resetActivity() {
        this.activity = null;
        if (getInflateView() != null) {
            getInflateView().resetState();
        }
    }

    public void setActivity(Activity activity2) {
        if (this.activity != activity2) {
            this.fragments = new HashMap<>();
            if (getInflateView() != null) {
                getInflateView().resetState();
            }
        }
        this.activity = activity2;
        this.appContext = activity2.getApplicationContext();
    }

    public void setContainer(FrameLayout frameLayout) {
        this.container = frameLayout;
    }

    public void setErrorCallback(ErrorCallback errorCallback) {
        this.errCallback = errorCallback;
    }

    public void setHandler(PropHandler propHandler) {
        this.handler = propHandler;
    }

    public void setInitialVariables() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.PHONE_BRAND, String.valueOf(Build.BRAND));
            jSONObject.put("model", String.valueOf(Build.MODEL));
            jSONObject.put("os_version", String.valueOf(VERSION.RELEASE));
            jSONObject.put("locale", Locale.getDefault().getDisplayLanguage());
            jSONObject.put("app_name", String.valueOf(this.appContext.getApplicationInfo().loadLabel(this.appContext.getPackageManager())));
            jSONObject.put("apiLevel", VERSION.SDK_INT);
            DisplayMetrics displayMetrics = this.appContext.getResources().getDisplayMetrics();
            jSONObject.put("screen_height", String.valueOf(displayMetrics.heightPixels));
            jSONObject.put("screen_width", String.valueOf(displayMetrics.widthPixels));
            jSONObject.put("screen_ppi", String.valueOf(displayMetrics.xdpi));
            addJsToWebView("window.__DEVICE_DETAILS=" + jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public void setLogger(DuiLogger duiLogger) {
        this.mLogger = duiLogger;
    }

    public void setState(String str) {
        this.androidInterface.setState(str);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.browser.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.browser.setWebViewClient(webViewClient);
    }
}
