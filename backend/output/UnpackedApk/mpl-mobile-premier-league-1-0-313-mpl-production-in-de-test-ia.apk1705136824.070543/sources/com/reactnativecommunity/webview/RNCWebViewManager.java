package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.mpl.androidapp.react.RNConstant;
import com.mpl.androidapp.utils.Constant;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.notification.SMTNotificationConstants;
import com.razorpay.AnalyticsConstants;
import com.reactnativecommunity.webview.RNCWebViewManager.RNCWebChromeClient;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "RNCWebView")
public class RNCWebViewManager extends SimpleViewManager<WebView> {
    public static final String BLANK_URL = "about:blank";
    public static final int COMMAND_CLEAR_CACHE = 1001;
    public static final int COMMAND_CLEAR_FORM_DATA = 1000;
    public static final int COMMAND_CLEAR_HISTORY = 1002;
    public static final int COMMAND_FOCUS = 8;
    public static final int COMMAND_GO_BACK = 1;
    public static final int COMMAND_GO_FORWARD = 2;
    public static final int COMMAND_INJECT_JAVASCRIPT = 6;
    public static final int COMMAND_LOAD_URL = 7;
    public static final int COMMAND_POST_MESSAGE = 5;
    public static final int COMMAND_RELOAD = 3;
    public static final int COMMAND_STOP_LOADING = 4;
    public static final String HTML_ENCODING = "UTF-8";
    public static final String HTML_MIME_TYPE = "text/html";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";
    public static final String REACT_CLASS = "RNCWebView";
    public static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;
    public static final String TAG = "RNCWebViewManager";
    public boolean mAllowsFullscreenVideo;
    public String mUserAgent;
    public String mUserAgentWithApplicationName;
    public RNCWebChromeClient mWebChromeClient;
    public WebViewConfig mWebViewConfig;

    public static class RNCWebChromeClient extends WebChromeClient implements LifecycleEventListener {
        public static final LayoutParams FULLSCREEN_LAYOUT_PARAMS = new LayoutParams(-1, -1, 17);
        public Callback geolocationPermissionCallback;
        public String geolocationPermissionOrigin;
        public List<String> grantedPermissions;
        public CustomViewCallback mCustomViewCallback;
        public ReactContext mReactContext;
        public View mVideoView;
        public View mWebView;
        public List<String> pendingPermissions = new ArrayList();
        public PermissionRequest permissionRequest;
        public boolean permissionsRequestShown = false;
        public ProgressChangedFilter progressChangedFilter = null;
        @TargetApi(21)
        public PermissionListener webviewPermissionsListener = new PermissionListener() {
            public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                return RNCWebChromeClient.this.lambda$new$0$RNCWebViewManager$RNCWebChromeClient(i, strArr, iArr);
            }
        };

        public RNCWebChromeClient(ReactContext reactContext, WebView webView) {
            this.mReactContext = reactContext;
            this.mWebView = webView;
        }

        public /* synthetic */ boolean lambda$new$0$RNCWebViewManager$RNCWebChromeClient(int i, String[] strArr, int[] iArr) {
            this.permissionsRequestShown = false;
            boolean z = false;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                boolean z2 = iArr[i2] == 0;
                if (str.equals(SMTConfigConstants.LOCATION_PERMISSION_MF_KEY)) {
                    Callback callback = this.geolocationPermissionCallback;
                    if (callback != null) {
                        String str2 = this.geolocationPermissionOrigin;
                        if (str2 != null) {
                            if (z2) {
                                callback.invoke(str2, true, false);
                            } else {
                                callback.invoke(str2, false, false);
                            }
                            this.geolocationPermissionCallback = null;
                            this.geolocationPermissionOrigin = null;
                        }
                    }
                }
                if (str.equals("android.permission.RECORD_AUDIO")) {
                    if (z2) {
                        List<String> list = this.grantedPermissions;
                        if (list != null) {
                            list.add("android.webkit.resource.AUDIO_CAPTURE");
                        }
                    }
                    z = true;
                }
                if (str.equals("android.permission.CAMERA")) {
                    if (z2) {
                        List<String> list2 = this.grantedPermissions;
                        if (list2 != null) {
                            list2.add("android.webkit.resource.VIDEO_CAPTURE");
                        }
                    }
                    z = true;
                }
                if (str.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                    if (z2) {
                        List<String> list3 = this.grantedPermissions;
                        if (list3 != null) {
                            list3.add("android.webkit.resource.PROTECTED_MEDIA_ID");
                        }
                    }
                    z = true;
                }
            }
            if (z) {
                PermissionRequest permissionRequest2 = this.permissionRequest;
                if (permissionRequest2 != null) {
                    List<String> list4 = this.grantedPermissions;
                    if (list4 != null) {
                        permissionRequest2.grant((String[]) list4.toArray(new String[0]));
                        this.permissionRequest = null;
                        this.grantedPermissions = null;
                    }
                }
            }
            if (this.pendingPermissions.isEmpty()) {
                return true;
            }
            requestPermissions(this.pendingPermissions);
            return false;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            ((WebViewTransport) message.obj).setWebView(new WebView(webView.getContext()));
            message.sendToTarget();
            return true;
        }

        public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
            if (ContextCompat.checkSelfPermission(this.mReactContext, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) != 0) {
                this.geolocationPermissionCallback = callback;
                this.geolocationPermissionOrigin = str;
                requestPermissions(Collections.singletonList(SMTConfigConstants.LOCATION_PERMISSION_MF_KEY));
                return;
            }
            callback.invoke(str, true, false);
        }

        public void onHostDestroy() {
        }

        public void onHostPause() {
        }

        public void onHostResume() {
            View view = this.mVideoView;
            if (view != null && view.getSystemUiVisibility() != 7942) {
                this.mVideoView.setSystemUiVisibility(7942);
            }
        }

        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest2) {
            this.grantedPermissions = new ArrayList();
            ArrayList arrayList = new ArrayList();
            String[] resources = permissionRequest2.getResources();
            int length = resources.length;
            int i = 0;
            while (true) {
                String str = null;
                if (i >= length) {
                    break;
                }
                String str2 = resources[i];
                if (str2.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                    str = "android.permission.RECORD_AUDIO";
                } else if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    str = "android.permission.CAMERA";
                } else if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                    str = "android.webkit.resource.PROTECTED_MEDIA_ID";
                }
                if (str != null) {
                    if (ContextCompat.checkSelfPermission(this.mReactContext, str) == 0) {
                        this.grantedPermissions.add(str2);
                    } else {
                        arrayList.add(str);
                    }
                }
                i++;
            }
            if (arrayList.isEmpty()) {
                permissionRequest2.grant((String[]) this.grantedPermissions.toArray(new String[0]));
                this.grantedPermissions = null;
                return;
            }
            this.permissionRequest = permissionRequest2;
            requestPermissions(arrayList);
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            String url = webView.getUrl();
            if (!this.progressChangedFilter.waitingForCommandLoadUrl) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("target", (double) webView.getId());
                createMap.putString("title", webView.getTitle());
                createMap.putString("url", url);
                createMap.putBoolean("canGoBack", webView.canGoBack());
                createMap.putBoolean("canGoForward", webView.canGoForward());
                createMap.putDouble("progress", (double) (((float) i) / 100.0f));
                ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingProgressEvent(webView.getId(), createMap));
            }
        }

        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            boolean z = true;
            if (fileChooserParams.getMode() != 1) {
                z = false;
            }
            return RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, acceptTypes, z);
        }

        public final synchronized void requestPermissions(List<String> list) {
            if (this.permissionsRequestShown) {
                this.pendingPermissions.addAll(list);
                return;
            }
            Activity currentActivity = this.mReactContext.getCurrentActivity();
            if (currentActivity == null) {
                throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
            } else if (currentActivity instanceof PermissionAwareActivity) {
                this.permissionsRequestShown = true;
                ((PermissionAwareActivity) currentActivity).requestPermissions((String[]) list.toArray(new String[0]), 3, this.webviewPermissionsListener);
                this.pendingPermissions.clear();
            } else {
                throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
            }
        }
    }

    public static class RNCWebView extends WebView implements LifecycleEventListener {
        public boolean hasScrollEvent = false;
        public String injectedJS;
        public String injectedJSBeforeContentLoaded;
        public CatalystInstance mCatalystInstance;
        public OnScrollDispatchHelper mOnScrollDispatchHelper;
        public RNCWebViewClient mRNCWebViewClient;
        public WebChromeClient mWebChromeClient;
        public boolean messagingEnabled = false;
        public String messagingModuleName;
        public ProgressChangedFilter progressChangedFilter;
        public boolean sendContentSizeChangeEvents = false;

        public static class ProgressChangedFilter {
            public boolean waitingForCommandLoadUrl = false;
        }

        public class RNCWebViewBridge {
            public RNCWebView mContext;

            public RNCWebViewBridge(RNCWebView rNCWebView) {
                this.mContext = rNCWebView;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                RNCWebView rNCWebView = this.mContext;
                ReactContext reactContext = (ReactContext) rNCWebView.getContext();
                if (rNCWebView.mRNCWebViewClient != null) {
                    rNCWebView.post(new Runnable(rNCWebView, str, rNCWebView) {
                        public final /* synthetic */ RNCWebView val$mContext;
                        public final /* synthetic */ String val$message;
                        public final /* synthetic */ WebView val$webView;

                        {
                            this.val$webView = r2;
                            this.val$message = r3;
                            this.val$mContext = r4;
                        }

                        public void run() {
                            RNCWebViewClient rNCWebViewClient = RNCWebView.this.mRNCWebViewClient;
                            if (rNCWebViewClient != null) {
                                WebView webView = this.val$webView;
                                WritableMap createWebViewEvent = rNCWebViewClient.createWebViewEvent(webView, webView.getUrl());
                                createWebViewEvent.putString("data", this.val$message);
                                RNCWebView rNCWebView = RNCWebView.this;
                                if (rNCWebView.mCatalystInstance != null) {
                                    this.val$mContext.sendDirectMessage("onMessage", createWebViewEvent);
                                } else {
                                    WebView webView2 = this.val$webView;
                                    rNCWebView.dispatchEvent(webView2, new TopMessageEvent(webView2.getId(), createWebViewEvent));
                                }
                            }
                        }
                    });
                    return;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putString("data", str);
                if (rNCWebView.mCatalystInstance != null) {
                    rNCWebView.sendDirectMessage("onMessage", createMap);
                } else {
                    rNCWebView.dispatchEvent(rNCWebView, new TopMessageEvent(rNCWebView.getId(), createMap));
                }
            }
        }

        public RNCWebView(ThemedReactContext themedReactContext) {
            super(themedReactContext);
            ReactContext reactContext = (ReactContext) getContext();
            if (reactContext != null) {
                this.mCatalystInstance = reactContext.getCatalystInstance();
            }
            this.progressChangedFilter = new ProgressChangedFilter();
        }

        public void destroy() {
            WebChromeClient webChromeClient = this.mWebChromeClient;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            }
            super.destroy();
        }

        public void dispatchEvent(WebView webView, Event event) {
            ((UIManagerModule) ((ReactContext) webView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(event);
        }

        public RNCWebViewClient getRNCWebViewClient() {
            return this.mRNCWebViewClient;
        }

        public void onHostDestroy() {
            setWebViewClient(null);
            destroy();
        }

        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.hasScrollEvent) {
                if (this.mOnScrollDispatchHelper == null) {
                    this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
                }
                if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
                    int id = getId();
                    ScrollEventType scrollEventType = ScrollEventType.SCROLL;
                    OnScrollDispatchHelper onScrollDispatchHelper = this.mOnScrollDispatchHelper;
                    dispatchEvent(this, ScrollEvent.obtain(id, scrollEventType, i, i2, onScrollDispatchHelper.mXFlingVelocity, onScrollDispatchHelper.mYFlingVelocity, computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
                }
            }
        }

        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.sendContentSizeChangeEvents) {
                dispatchEvent(this, new ContentSizeChangeEvent(getId(), i, i2));
            }
        }

        public void sendDirectMessage(String str, WritableMap writableMap) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putMap("nativeEvent", writableMap);
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            writableNativeArray.pushMap(writableNativeMap);
            this.mCatalystInstance.callFunction(this.messagingModuleName, str, writableNativeArray);
        }

        public void setHasScrollEvent(boolean z) {
            this.hasScrollEvent = z;
        }

        public void setIgnoreErrFailedForThisURL(String str) {
            this.mRNCWebViewClient.ignoreErrFailedForThisURL = str;
        }

        public void setInjectedJavaScript(String str) {
            this.injectedJS = str;
        }

        public void setInjectedJavaScriptBeforeContentLoaded(String str) {
            this.injectedJSBeforeContentLoaded = str;
        }

        public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(boolean z) {
        }

        public void setInjectedJavaScriptForMainFrameOnly(boolean z) {
        }

        @SuppressLint({"AddJavascriptInterface"})
        public void setMessagingEnabled(boolean z) {
            if (this.messagingEnabled != z) {
                this.messagingEnabled = z;
                if (z) {
                    addJavascriptInterface(new RNCWebViewBridge(this), RNCWebViewManager.JAVASCRIPT_INTERFACE);
                } else {
                    removeJavascriptInterface(RNCWebViewManager.JAVASCRIPT_INTERFACE);
                }
            }
        }

        public void setMessagingModuleName(String str) {
            this.messagingModuleName = str;
        }

        public void setSendContentSizeChangeEvents(boolean z) {
            this.sendContentSizeChangeEvents = z;
        }

        public void setWebChromeClient(WebChromeClient webChromeClient) {
            this.mWebChromeClient = webChromeClient;
            super.setWebChromeClient(webChromeClient);
            if (webChromeClient instanceof RNCWebChromeClient) {
                ((RNCWebChromeClient) webChromeClient).progressChangedFilter = this.progressChangedFilter;
            }
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            if (webViewClient instanceof RNCWebViewClient) {
                RNCWebViewClient rNCWebViewClient = (RNCWebViewClient) webViewClient;
                this.mRNCWebViewClient = rNCWebViewClient;
                rNCWebViewClient.progressChangedFilter = this.progressChangedFilter;
            }
        }
    }

    public static class RNCWebViewClient extends WebViewClient {
        public String ignoreErrFailedForThisURL = null;
        public boolean mLastLoadFailed = false;
        public ProgressChangedFilter progressChangedFilter = null;

        public WritableMap createWebViewEvent(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("target", (double) webView.getId());
            createMap.putString("url", str);
            createMap.putBoolean("loading", !this.mLastLoadFailed && webView.getProgress() != 100);
            createMap.putString("title", webView.getTitle());
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            return createMap;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.mLastLoadFailed) {
                RNCWebView rNCWebView = (RNCWebView) webView;
                if (rNCWebView.getSettings().getJavaScriptEnabled()) {
                    String str2 = rNCWebView.injectedJS;
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("(function() {\n");
                        outline73.append(rNCWebView.injectedJS);
                        outline73.append(";\n})();");
                        rNCWebView.evaluateJavascript(outline73.toString(), null);
                    }
                }
                rNCWebView.dispatchEvent(webView, new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str)));
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.mLastLoadFailed = false;
            RNCWebView rNCWebView = (RNCWebView) webView;
            if (rNCWebView.getSettings().getJavaScriptEnabled()) {
                String str2 = rNCWebView.injectedJSBeforeContentLoaded;
                if (str2 != null && !TextUtils.isEmpty(str2)) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("(function() {\n");
                    outline73.append(rNCWebView.injectedJSBeforeContentLoaded);
                    outline73.append(";\n})();");
                    rNCWebView.evaluateJavascript(outline73.toString(), null);
                }
            }
            rNCWebView.dispatchEvent(webView, new TopLoadingStartEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3 = this.ignoreErrFailedForThisURL;
            if (str3 == null || !str2.equals(str3) || i != -1 || !str.equals("net::ERR_FAILED")) {
                super.onReceivedError(webView, i, str, str2);
                this.mLastLoadFailed = true;
                ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str2)));
                WritableMap createWebViewEvent = createWebViewEvent(webView, str2);
                createWebViewEvent.putDouble("code", (double) i);
                createWebViewEvent.putString("description", str);
                ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingErrorEvent(webView.getId(), createWebViewEvent));
                return;
            }
            this.ignoreErrFailedForThisURL = null;
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                WritableMap createWebViewEvent = createWebViewEvent(webView, webResourceRequest.getUrl().toString());
                createWebViewEvent.putInt("statusCode", webResourceResponse.getStatusCode());
                createWebViewEvent.putString("description", webResourceResponse.getReasonPhrase());
                ((RNCWebView) webView).dispatchEvent(webView, new TopHttpErrorEvent(webView.getId(), createWebViewEvent));
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String url = webView.getUrl();
            String url2 = sslError.getUrl();
            sslErrorHandler.cancel();
            if (url.equalsIgnoreCase(url2)) {
                int primaryError = sslError.getPrimaryError();
                onReceivedError(webView, primaryError, GeneratedOutlineSupport.outline50("SSL error: ", primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "Unknown SSL Error" : "A generic error occurred" : "The date of the certificate is invalid" : "The certificate authority is not trusted" : "Hostname mismatch" : "The certificate has expired" : "The certificate is not yet valid"), url2);
            }
        }

        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (VERSION.SDK_INT < 26) {
                return false;
            }
            super.onRenderProcessGone(webView, renderProcessGoneDetail);
            boolean didCrash = renderProcessGoneDetail.didCrash();
            if (webView == null) {
                return true;
            }
            WritableMap createWebViewEvent = createWebViewEvent(webView, webView.getUrl());
            createWebViewEvent.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
            ((RNCWebView) webView).dispatchEvent(webView, new TopRenderProcessGoneEvent(webView.getId(), createWebViewEvent));
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
            if (r5.get() != com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x008a, code lost:
            com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock.removeLock(java.lang.Integer.valueOf(r1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r11, java.lang.String r12) {
            /*
                r10 = this;
                r0 = r11
                com.reactnativecommunity.webview.RNCWebViewManager$RNCWebView r0 = (com.reactnativecommunity.webview.RNCWebViewManager.RNCWebView) r0
                android.content.Context r1 = r11.getContext()
                com.facebook.react.bridge.ReactContext r1 = (com.facebook.react.bridge.ReactContext) r1
                com.facebook.react.bridge.JavaScriptContextHolder r1 = r1.getJavaScriptContextHolder()
                long r1 = r1.get()
                r3 = 0
                r4 = 1
                r5 = 0
                int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r7 != 0) goto L_0x001b
                r1 = 1
                goto L_0x001c
            L_0x001b:
                r1 = 0
            L_0x001c:
                if (r1 != 0) goto L_0x00ac
                com.facebook.react.bridge.CatalystInstance r1 = r0.mCatalystInstance
                if (r1 == 0) goto L_0x00ac
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r1 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock
                monitor-enter(r1)
                int r2 = r1.nextLockIdentifier     // Catch:{ all -> 0x00a9 }
                int r5 = r2 + 1
                r1.nextLockIdentifier = r5     // Catch:{ all -> 0x00a9 }
                java.util.concurrent.atomic.AtomicReference r5 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ all -> 0x00a9 }
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r6 = com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.UNDECIDED     // Catch:{ all -> 0x00a9 }
                r5.<init>(r6)     // Catch:{ all -> 0x00a9 }
                java.util.HashMap<java.lang.Integer, java.util.concurrent.atomic.AtomicReference<com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState>> r6 = r1.shouldOverrideLocks     // Catch:{ all -> 0x00a9 }
                java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00a9 }
                r6.put(r7, r5)     // Catch:{ all -> 0x00a9 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00a9 }
                monitor-exit(r1)
                int r1 = r2.intValue()
                com.facebook.react.bridge.WritableMap r11 = r10.createWebViewEvent(r11, r12)
                java.lang.String r12 = "lockIdentifier"
                r11.putInt(r12, r1)
                java.lang.String r12 = "onShouldStartLoadWithRequest"
                r0.sendDirectMessage(r12, r11)
                monitor-enter(r5)     // Catch:{ InterruptedException -> 0x0097 }
                long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0094 }
            L_0x0057:
                java.lang.Object r0 = r5.get()     // Catch:{ all -> 0x0094 }
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r2 = com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.UNDECIDED     // Catch:{ all -> 0x0094 }
                if (r0 != r2) goto L_0x0080
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0094 }
                long r6 = r6 - r11
                r8 = 250(0xfa, double:1.235E-321)
                int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x007c
                java.lang.String r11 = "RNCWebViewManager"
                java.lang.String r12 = "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading."
                com.facebook.common.logging.FLog.w(r11, r12)     // Catch:{ all -> 0x0094 }
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r11 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock     // Catch:{ all -> 0x0094 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0094 }
                r11.removeLock(r12)     // Catch:{ all -> 0x0094 }
                monitor-exit(r5)     // Catch:{ all -> 0x0094 }
                return r3
            L_0x007c:
                r5.wait(r8)     // Catch:{ all -> 0x0094 }
                goto L_0x0057
            L_0x0080:
                monitor-exit(r5)     // Catch:{ all -> 0x0094 }
                java.lang.Object r11 = r5.get()
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r12 = com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE
                if (r11 != r12) goto L_0x008a
                r3 = 1
            L_0x008a:
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r11 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                r11.removeLock(r12)
                return r3
            L_0x0094:
                r11 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0094 }
                throw r11     // Catch:{ InterruptedException -> 0x0097 }
            L_0x0097:
                r11 = move-exception
                java.lang.String r12 = "RNCWebViewManager"
                java.lang.String r0 = "shouldOverrideUrlLoading was interrupted while waiting for result."
                com.facebook.common.logging.FLog.e(r12, r0, r11)
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r11 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                r11.removeLock(r12)
                return r3
            L_0x00a9:
                r11 = move-exception
                monitor-exit(r1)
                throw r11
            L_0x00ac:
                java.lang.String r0 = "RNCWebViewManager"
                java.lang.String r1 = "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load."
                com.facebook.common.logging.FLog.w(r0, r1)
                com.reactnativecommunity.webview.RNCWebViewManager$RNCWebView$ProgressChangedFilter r0 = r10.progressChangedFilter
                r0.waitingForCommandLoadUrl = r4
                r0 = r11
                com.reactnativecommunity.webview.RNCWebViewManager$RNCWebView r0 = (com.reactnativecommunity.webview.RNCWebViewManager.RNCWebView) r0
                com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent r1 = new com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent
                int r2 = r11.getId()
                com.facebook.react.bridge.WritableMap r12 = r10.createWebViewEvent(r11, r12)
                r1.<init>(r2, r12)
                r0.dispatchEvent(r11, r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.RNCWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }
    }

    public RNCWebViewManager() {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = new WebViewConfig(this) {
            public void configWebView(WebView webView) {
            }
        };
    }

    public static RNCWebViewModule getModule(ReactContext reactContext) {
        return (RNCWebViewModule) reactContext.getNativeModule(RNCWebViewModule.class);
    }

    public RNCWebView createRNCWebViewInstance(ThemedReactContext themedReactContext) {
        return new RNCWebView(themedReactContext);
    }

    public Map<String, Integer> getCommandsMap() {
        MapBuilder$Builder builder = ImageOriginUtils.builder();
        builder.put("goBack", Integer.valueOf(1));
        builder.put("goForward", Integer.valueOf(2));
        builder.put("reload", Integer.valueOf(3));
        builder.put("stopLoading", Integer.valueOf(4));
        builder.put("postMessage", Integer.valueOf(5));
        builder.put("injectJavaScript", Integer.valueOf(6));
        builder.put(RNConstant.EXTRA_WEB_LOAD_URL, Integer.valueOf(7));
        builder.put("requestFocus", Integer.valueOf(8));
        builder.put("clearFormData", Integer.valueOf(1000));
        builder.put("clearCache", Integer.valueOf(1001));
        builder.put("clearHistory", Integer.valueOf(1002));
        return builder.build();
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.put("topLoadingProgress", ImageOriginUtils.of("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put("topShouldStartLoadWithRequest", ImageOriginUtils.of("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), ImageOriginUtils.of("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put("topHttpError", ImageOriginUtils.of("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put("topRenderProcessGone", ImageOriginUtils.of("registrationName", "onRenderProcessGone"));
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return "RNCWebView";
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(WebView webView, Boolean bool) {
        webView.getSettings().setAllowFileAccess(bool != null && bool.booleanValue());
    }

    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowFileAccessFromFileURLs(z);
    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(WebView webView, Boolean bool) {
        this.mAllowsFullscreenVideo = bool != null && bool.booleanValue();
        setupWebChromeClient((ReactContext) webView.getContext(), webView);
    }

    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(WebView webView, String str) {
        if (str != null) {
            this.mUserAgentWithApplicationName = GeneratedOutlineSupport.outline52(WebSettings.getDefaultUserAgent(webView.getContext()), CMap.SPACE, str);
        } else {
            this.mUserAgentWithApplicationName = null;
        }
        setUserAgentString(webView);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(WebView webView, boolean z) {
        if (z) {
            Context context = webView.getContext();
            if (context != null) {
                webView.getSettings().setAppCachePath(context.getCacheDir().getAbsolutePath());
                webView.getSettings().setCacheMode(-1);
                webView.getSettings().setAppCacheEnabled(true);
                return;
            }
            return;
        }
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setAppCacheEnabled(false);
    }

    @com.facebook.react.uimanager.annotations.ReactProp(name = "cacheMode")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCacheMode(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = r7.hashCode()
            r1 = 3
            r2 = -1
            r3 = 2
            r4 = 1
            switch(r0) {
                case -2059164003: goto L_0x002a;
                case -1215135800: goto L_0x0020;
                case -873877826: goto L_0x0016;
                case 1548620642: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "LOAD_CACHE_ONLY"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 0
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "LOAD_CACHE_ELSE_NETWORK"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "LOAD_DEFAULT"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "LOAD_NO_CACHE"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 2
            goto L_0x0035
        L_0x0034:
            r7 = -1
        L_0x0035:
            if (r7 == 0) goto L_0x004a
            if (r7 == r4) goto L_0x0045
            if (r7 == r3) goto L_0x0040
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            goto L_0x004e
        L_0x0040:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            goto L_0x004e
        L_0x0045:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            goto L_0x004e
        L_0x004a:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
        L_0x004e:
            android.webkit.WebSettings r6 = r6.getSettings()
            int r7 = r7.intValue()
            r6.setCacheMode(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.setCacheMode(android.webkit.WebView, java.lang.String):void");
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(WebView webView, boolean z) {
        webView.getSettings().setDomStorageEnabled(z);
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(WebView webView, Boolean bool) {
        webView.getSettings().setGeolocationEnabled(bool != null && bool.booleanValue());
    }

    @ReactProp(name = "androidHardwareAccelerationDisabled")
    public void setHardwareAccelerationDisabled(WebView webView, boolean z) {
        if (z) {
            webView.setLayerType(1, null);
        }
    }

    @ReactProp(name = "incognito")
    public void setIncognito(WebView webView, boolean z) {
        if (z) {
            CookieManager.getInstance().removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            webView.getSettings().setAppCacheEnabled(false);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScript(str);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScriptBeforeContentLoaded(str);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(WebView webView, boolean z) {
        ((RNCWebView) webView).setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(z);
    }

    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(WebView webView, boolean z) {
        ((RNCWebView) webView).setInjectedJavaScriptForMainFrameOnly(z);
    }

    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptEnabled(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "androidLayerType")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLayerType(android.webkit.WebView r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 116909544(0x6f7e5e8, float:9.324889E-35)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 1319330215(0x4ea361a7, float:1.370543E9)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "software"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 1
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "hardware"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = 0
            goto L_0x0026
        L_0x0025:
            r6 = -1
        L_0x0026:
            if (r6 == 0) goto L_0x002d
            if (r6 == r3) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            r2 = 1
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r6 = 0
            r5.setLayerType(r2, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.setLayerType(android.webkit.WebView, java.lang.String):void");
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    @TargetApi(17)
    public void setMediaPlaybackRequiresUserAction(WebView webView, boolean z) {
        webView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(WebView webView, boolean z) {
        ((RNCWebView) webView).setMessagingEnabled(z);
    }

    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(WebView webView, String str) {
        ((RNCWebView) webView).setMessagingModuleName(str);
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(WebView webView, String str) {
        if (str == null || "never".equals(str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if ("always".equals(str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if ("compatibility".equals(str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    @ReactProp(name = "onContentSizeChange")
    public void setOnContentSizeChange(WebView webView, boolean z) {
        ((RNCWebView) webView).setSendContentSizeChangeEvents(z);
    }

    @ReactProp(name = "onScroll")
    public void setOnScroll(WebView webView, boolean z) {
        ((RNCWebView) webView).setHasScrollEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "overScrollMode")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOverScrollMode(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = r7.hashCode()
            r1 = -1414557169(0xffffffffabaf920f, float:-1.2475037E-12)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x002b
            r1 = 104712844(0x63dca8c, float:3.5695757E-35)
            if (r0 == r1) goto L_0x0021
            r1 = 951530617(0x38b73479, float:8.735894E-5)
            if (r0 == r1) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "content"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 1
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "never"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "always"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 2
            goto L_0x0036
        L_0x0035:
            r7 = -1
        L_0x0036:
            if (r7 == 0) goto L_0x0044
            if (r7 == r4) goto L_0x003f
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            goto L_0x0048
        L_0x003f:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            goto L_0x0048
        L_0x0044:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
        L_0x0048:
            int r7 = r7.intValue()
            r6.setOverScrollMode(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.setOverScrollMode(android.webkit.WebView, java.lang.String):void");
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(WebView webView, boolean z) {
        webView.getSettings().setSaveFormData(!z);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(WebView webView, boolean z) {
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(WebView webView, boolean z) {
        webView.setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(WebView webView, boolean z) {
        webView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "source")
    public void setSource(WebView webView, ReadableMap readableMap) {
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                webView.loadDataWithBaseURL(readableMap.hasKey(Constant.BASE_URL) ? readableMap.getString(Constant.BASE_URL) : "", readableMap.getString("html"), HTML_MIME_TYPE, "UTF-8", null);
                return;
            } else if (readableMap.hasKey("uri")) {
                String string = readableMap.getString("uri");
                String url = webView.getUrl();
                if (url != null && url.equals(string)) {
                    return;
                }
                if (!readableMap.hasKey(AnalyticsConstants.METHOD) || !readableMap.getString(AnalyticsConstants.METHOD).equalsIgnoreCase(HTTP_METHOD_POST)) {
                    HashMap hashMap = new HashMap();
                    if (readableMap.hasKey(Constant.HEADER)) {
                        ReadableMap map = readableMap.getMap(Constant.HEADER);
                        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            String nextKey = keySetIterator.nextKey();
                            if (!NetworkingModule.USER_AGENT_HEADER_NAME.equals(nextKey.toLowerCase(Locale.ENGLISH))) {
                                hashMap.put(nextKey, map.getString(nextKey));
                            } else if (webView.getSettings() != null) {
                                webView.getSettings().setUserAgentString(map.getString(nextKey));
                            }
                        }
                    }
                    webView.loadUrl(string, hashMap);
                    return;
                }
                byte[] bArr = null;
                if (readableMap.hasKey(SMTNotificationConstants.NOTIF_BODY_KEY)) {
                    String string2 = readableMap.getString(SMTNotificationConstants.NOTIF_BODY_KEY);
                    try {
                        bArr = string2.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        bArr = string2.getBytes();
                    }
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                webView.postUrl(string, bArr);
                return;
            }
        }
        webView.loadUrl(BLANK_URL);
    }

    @ReactProp(name = "setSupportMultipleWindows")
    public void setSupportMultipleWindows(WebView webView, boolean z) {
        webView.getSettings().setSupportMultipleWindows(z);
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(WebView webView, int i) {
        webView.getSettings().setTextZoom(i);
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(WebView webView, boolean z) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
    }

    @ReactProp(name = "urlPrefixesForDefaultIntent")
    public void setUrlPrefixesForDefaultIntent(WebView webView, ReadableArray readableArray) {
        RNCWebViewClient rNCWebViewClient = ((RNCWebView) webView).getRNCWebViewClient();
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(WebView webView, String str) {
        if (str != null) {
            this.mUserAgent = str;
        } else {
            this.mUserAgent = null;
        }
        setUserAgentString(webView);
    }

    public void setUserAgentString(WebView webView) {
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    public void setupWebChromeClient(ReactContext reactContext, WebView webView) {
        if (this.mAllowsFullscreenVideo) {
            final int requestedOrientation = reactContext.getCurrentActivity().getRequestedOrientation();
            AnonymousClass3 r1 = new RNCWebChromeClient(this, reactContext, webView) {
                public Bitmap getDefaultVideoPoster() {
                    return Bitmap.createBitmap(50, 50, Config.ARGB_8888);
                }

                public void onHideCustomView() {
                    if (this.mVideoView != null) {
                        ViewGroup viewGroup = (ViewGroup) this.mReactContext.getCurrentActivity().findViewById(16908290);
                        if (viewGroup.getRootView() != this.mWebView.getRootView()) {
                            this.mWebView.getRootView().setVisibility(0);
                        } else {
                            this.mWebView.setVisibility(0);
                        }
                        this.mReactContext.getCurrentActivity().getWindow().clearFlags(512);
                        viewGroup.removeView(this.mVideoView);
                        this.mCustomViewCallback.onCustomViewHidden();
                        this.mVideoView = null;
                        this.mCustomViewCallback = null;
                        this.mReactContext.getCurrentActivity().setRequestedOrientation(requestedOrientation);
                        this.mReactContext.removeLifecycleEventListener(this);
                    }
                }

                public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                    if (this.mVideoView != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    this.mVideoView = view;
                    this.mCustomViewCallback = customViewCallback;
                    this.mReactContext.getCurrentActivity().setRequestedOrientation(-1);
                    this.mVideoView.setSystemUiVisibility(7942);
                    this.mReactContext.getCurrentActivity().getWindow().setFlags(512, 512);
                    this.mVideoView.setBackgroundColor(-16777216);
                    ViewGroup viewGroup = (ViewGroup) this.mReactContext.getCurrentActivity().findViewById(16908290);
                    viewGroup.addView(this.mVideoView, RNCWebChromeClient.FULLSCREEN_LAYOUT_PARAMS);
                    if (viewGroup.getRootView() != this.mWebView.getRootView()) {
                        this.mWebView.getRootView().setVisibility(8);
                    } else {
                        this.mWebView.setVisibility(8);
                    }
                    this.mReactContext.addLifecycleEventListener(this);
                }
            };
            this.mWebChromeClient = r1;
            webView.setWebChromeClient(r1);
            return;
        }
        RNCWebChromeClient rNCWebChromeClient = this.mWebChromeClient;
        if (rNCWebChromeClient != null) {
            rNCWebChromeClient.onHideCustomView();
        }
        AnonymousClass4 r0 = new RNCWebChromeClient(this, reactContext, webView) {
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(50, 50, Config.ARGB_8888);
            }
        };
        this.mWebChromeClient = r0;
        webView.setWebChromeClient(r0);
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, WebView webView) {
        webView.setWebViewClient(new RNCWebViewClient());
    }

    @TargetApi(21)
    public WebView createViewInstance(final ThemedReactContext themedReactContext) {
        final RNCWebView createRNCWebViewInstance = createRNCWebViewInstance(themedReactContext);
        setupWebChromeClient(themedReactContext, createRNCWebViewInstance);
        themedReactContext.addLifecycleEventListener(createRNCWebViewInstance);
        this.mWebViewConfig.configWebView(createRNCWebViewInstance);
        WebSettings settings = createRNCWebViewInstance.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        setAllowUniversalAccessFromFileURLs(createRNCWebViewInstance, false);
        setMixedContentMode(createRNCWebViewInstance, "never");
        createRNCWebViewInstance.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        createRNCWebViewInstance.setDownloadListener(new DownloadListener(this) {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                createRNCWebViewInstance.setIgnoreErrFailedForThisURL(str);
                RNCWebViewModule module = RNCWebViewManager.getModule(themedReactContext);
                Request request = new Request(Uri.parse(str));
                String guessFileName = URLUtil.guessFileName(str, str3, str4);
                String outline50 = GeneratedOutlineSupport.outline50("Downloading ", guessFileName);
                try {
                    new URL(str);
                    request.addRequestHeader(Names.COOKIE, CookieManager.getInstance().getCookie(r0.getProtocol() + "://" + r0.getHost()));
                } catch (MalformedURLException e2) {
                    PrintStream printStream = System.out;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error getting cookie for DownloadManager: ");
                    outline73.append(e2.toString());
                    printStream.println(outline73.toString());
                    e2.printStackTrace();
                }
                request.addRequestHeader("User-Agent", str2);
                request.setTitle(guessFileName);
                request.setDescription(outline50);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
                module.setDownloadRequest(request);
                if (module.grantFileDownloaderPermissions()) {
                    module.downloadFile();
                }
            }
        });
        return createRNCWebViewInstance;
    }

    public void onDropViewInstance(WebView webView) {
        super.onDropViewInstance(webView);
        RNCWebView rNCWebView = (RNCWebView) webView;
        ((ThemedReactContext) webView.getContext()).removeLifecycleEventListener(rNCWebView);
        rNCWebView.setWebViewClient(null);
        rNCWebView.destroy();
        this.mWebChromeClient = null;
    }

    public void receiveCommand(WebView webView, int i, ReadableArray readableArray) {
        boolean z = false;
        switch (i) {
            case 1:
                webView.goBack();
                return;
            case 2:
                webView.goForward();
                return;
            case 3:
                webView.reload();
                return;
            case 4:
                webView.stopLoading();
                return;
            case 5:
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", readableArray.getString(0));
                    ((RNCWebView) webView).evaluateJavascript("(function () {var event;var data = " + jSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();", null);
                    return;
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            case 6:
                ((RNCWebView) webView).evaluateJavascript(readableArray.getString(0), null);
                return;
            case 7:
                if (readableArray != null) {
                    ((RNCWebView) webView).progressChangedFilter.waitingForCommandLoadUrl = false;
                    webView.loadUrl(readableArray.getString(0));
                    return;
                }
                throw new RuntimeException("Arguments for loading an url are null!");
            case 8:
                webView.requestFocus();
                return;
            default:
                switch (i) {
                    case 1000:
                        webView.clearFormData();
                        return;
                    case 1001:
                        if (readableArray != null && readableArray.getBoolean(0)) {
                            z = true;
                        }
                        webView.clearCache(z);
                        return;
                    case 1002:
                        webView.clearHistory();
                        return;
                    default:
                        return;
                }
        }
    }

    public RNCWebViewManager(WebViewConfig webViewConfig) {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = webViewConfig;
    }
}
