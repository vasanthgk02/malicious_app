package in.juspay.hypersdk.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.HyperFragment;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.Labels.SDK;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentConstants.Category;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.ApiCall;
import in.juspay.hypersdk.core.PaymentUtils;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.services.FileProviderService;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class JuspayWebViewClient extends WebViewClient {
    public static final String LOG_TAG = JuspayWebViewClient.class.getName();
    public HyperFragment browserFragment;
    public WebViewClient delegate;
    public JuspayWebView juspayWebView;
    public String latestStartUrl;

    @Keep
    public JuspayWebViewClient() {
    }

    public JuspayWebViewClient(HyperFragment hyperFragment, JuspayWebView juspayWebView2) {
        this.browserFragment = hyperFragment;
        this.juspayWebView = juspayWebView2;
        if (hyperFragment.getJuspayCallback() instanceof HyperPaymentsCallback) {
            this.delegate = ((HyperPaymentsCallback) hyperFragment.getJuspayCallback()).createJuspaySafeWebViewClient();
        }
    }

    private void insertACS() {
        JuspayServices juspayServices = this.browserFragment.getJuspayServices();
        FileProviderService fileProviderService = juspayServices.getFileProviderService();
        PaymentSessionInfo paymentSessionInfo = this.browserFragment.getPaymentSessionInfo();
        if (!paymentSessionInfo.isGodelDisabled() && this.browserFragment.getConfig() != null) {
            if (this.browserFragment.getDuiInterface() != null) {
                this.browserFragment.getDuiInterface().setSessionAttribute("config", this.browserFragment.getConfig().toString());
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.juspayContext = {}; juspayContext['web_lab_rules'] = ");
            outline73.append(this.browserFragment.getConfig().getJSONObject("weblab").toString());
            String sb = outline73.toString();
            JuspayWebView juspayWebView2 = this.juspayWebView;
            if (juspayWebView2 != null) {
                juspayWebView2.addJsToWebView(sb);
            }
        }
        if (paymentSessionInfo.isGodelDisabled() || this.juspayWebView == null) {
            juspayServices.sdkDebug(LOG_TAG, "disabling_insertion_of_java_script_since_jb_is_disabled");
            return;
        }
        String readFromFile = fileProviderService.readFromFile(juspayServices.getContext(), PaymentConstants.ACS);
        this.juspayWebView.addJsToWebView(readFromFile);
        juspayServices.sdkDebug(LOG_TAG, "Tracking weblab rules in acs");
        this.juspayWebView.addJsToWebView("__juspay.trackWebLabRules();");
        if (paymentSessionInfo.getAcsJsHash() == null) {
            paymentSessionInfo.setAcsJsHash(EncryptionHelper.md5(readFromFile));
            juspayServices.getSdkTracker().trackAction("system", "info", System.JUSPAY_WEBVIEW_CLIENT, "hash_of_inserted_acs_min_script", paymentSessionInfo.getAcsJsHash());
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        super.onFormResubmission(webView, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        }
    }

    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(webView, str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        JuspayServices juspayServices = this.browserFragment.getJuspayServices();
        try {
            if (this.browserFragment.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str);
                jSONObject.put("title", webView.getTitle());
                if (this.browserFragment.getAcsInterface() != null) {
                    this.browserFragment.getAcsInterface().invoke("onPageFinished", jSONObject.toString());
                }
            }
            CookieSyncManager.getInstance().sync();
            insertACS();
        } catch (JSONException e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onPageFinished event", e2);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        JuspayServices juspayServices = this.browserFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        PaymentUtils.isRupaySupportedAdded = false;
        if (this.browserFragment.isDuiLoaded()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
            } catch (JSONException e2) {
                JSONException jSONException = e2;
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onPageStarted event", jSONException);
            }
            if (this.browserFragment.getAcsInterface() != null) {
                this.browserFragment.getAcsInterface().invoke("onPageStarted", jSONObject.toString());
            }
        }
        this.latestStartUrl = str;
        juspayServices.getSessionInfo().set("currentUrl", str);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
        try {
            List<String> allowedDeeplinkPackages = this.browserFragment.getAllowedDeeplinkPackages();
            if (allowedDeeplinkPackages.size() != 0) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                List<ResolveInfo> queryIntentActivities = this.browserFragment.requireActivity().getPackageManager().queryIntentActivities(intent, 65536);
                if (queryIntentActivities != null) {
                    String str2 = null;
                    for (ResolveInfo next : queryIntentActivities) {
                        JuspayLogger.d(LOG_TAG, next.activityInfo.packageName);
                        if (str2 == null && allowedDeeplinkPackages.contains(next.activityInfo.packageName)) {
                            str2 = next.activityInfo.packageName;
                        }
                    }
                    if (str2 != null || queryIntentActivities.size() <= 1) {
                        if (queryIntentActivities.size() != 0) {
                            if (allowedDeeplinkPackages.contains(queryIntentActivities.get(0).activityInfo.packageName)) {
                                intent.setPackage(str2);
                                this.browserFragment.startActivity(intent);
                                this.browserFragment.getJuspayServices().addJsToWebView("if (window.onDeepLinkUrlAppOpen != null) { window.onDeepLinkUrlAppOpen('{}'); }");
                                return;
                            }
                        }
                        return;
                    }
                    JuspayLogger.e(LOG_TAG, "Too many activities");
                }
            }
        } catch (Exception e3) {
            SdkTracker sdkTracker2 = sdkTracker;
            sdkTracker2.trackException(Category.GODEL, ApiCall.SDK, SDK.WEBVIEW_CLIENT, GeneratedOutlineSupport.outline50("Exception when trying to launch deeplink activity for ", str), e3);
        }
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        JuspayServices juspayServices = this.browserFragment.getJuspayServices();
        try {
            if (this.browserFragment.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", webView.getUrl());
                jSONObject.put("title", webView.getTitle());
                jSONObject.put("statusCode", i);
                if (this.browserFragment.getAcsInterface() != null) {
                    this.browserFragment.getAcsInterface().invoke("onReceivedError", jSONObject.toString());
                }
                insertACS();
            }
        } catch (JSONException e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onReceivedError event", e2);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i, str, str2);
        }
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        JuspayServices juspayServices = this.browserFragment.getJuspayServices();
        try {
            if (this.browserFragment.isDuiLoaded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", webView.getUrl());
                jSONObject.put("title", webView.getTitle());
                jSONObject.put("statusCode", webResourceError.getErrorCode());
                if (this.browserFragment.getAcsInterface() != null) {
                    this.browserFragment.getAcsInterface().invoke("onReceivedError", jSONObject.toString());
                }
                insertACS();
                CookieSyncManager.getInstance().sync();
            }
        } catch (JSONException e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.JUSPAY_WEBVIEW_CLIENT, "Exception while creating ACS onReceivedError event", e2);
        }
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @TargetApi(23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.delegate != null ? onRenderProcessGone(webView, renderProcessGoneDetail) : super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
        super.onScaleChanged(webView, f2, f3);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f2, f3);
        }
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        super.onTooManyRedirects(webView, message, message2);
        WebViewClient webViewClient = this.delegate;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        }
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse shouldInterceptRequest = PaymentUtils.shouldInterceptRequest(webView, webResourceRequest, this.browserFragment);
        WebViewClient webViewClient = this.delegate;
        return (webViewClient == null || shouldInterceptRequest != null) ? shouldInterceptRequest : webViewClient.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse shouldInterceptRequest = PaymentUtils.shouldInterceptRequest(webView, str, this.browserFragment);
        WebViewClient webViewClient = this.delegate;
        return (webViewClient == null || shouldInterceptRequest != null) ? shouldInterceptRequest : webViewClient.shouldInterceptRequest(webView, str);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.delegate;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest) : super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewClient webViewClient = this.delegate;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
    }
}
