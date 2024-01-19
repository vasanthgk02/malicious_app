package com.paytm.pgsdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.material.resources.TextAppearanceConfig;
import com.mpl.payment.paytm.PaytmRequestConstants;
import java.util.Iterator;
import org.json.JSONObject;

@TargetApi(21)
public class PaytmWebView extends WebView {
    public final PaytmPGActivity mContext;
    public volatile boolean mbMerchantCallbackURLLoaded;

    public class PaytmJavaScriptInterface {
        public PaytmJavaScriptInterface(AnonymousClass1 r2) {
        }

        @JavascriptInterface
        public synchronized void processResponse(String str) {
            try {
                TextAppearanceConfig.debugLog("Merchant Response is " + str);
                Bundle access$600 = PaytmWebView.access$600(PaytmWebView.this, str);
                String str2 = PaytmPGService.getService().mOrder.requestParamMap.get(PaytmRequestConstants.PARAMS_CALLBACK_URL);
                if (!TextUtils.isEmpty(str2)) {
                    if (!PaytmWebView.this.mbMerchantCallbackURLLoaded) {
                        TextAppearanceConfig.debugLog("Merchant Specific URL is present, So posting all parameters to Merchant specific URL");
                        PaytmWebView.this.postUrl(str2, TextAppearanceConfig.getURLEncodedStringFromBundle(access$600).getBytes());
                    }
                }
                TextAppearanceConfig.debugLog("Returning the response back to Merchant Application");
                returnResponse(access$600);
            } catch (Exception e2) {
                TextAppearanceConfig.printStackTrace(e2);
            }
            return;
        }

        public final synchronized void returnResponse(final Bundle bundle) {
            try {
                ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            ((Activity) PaytmWebView.this.getContext()).finish();
                            PaytmPGService.getService().getmPaymentTransactionCallback().onTransactionResponse(bundle);
                        } catch (Exception e2) {
                            TextAppearanceConfig.printStackTrace(e2);
                        }
                    }
                });
            } catch (Exception e2) {
                TextAppearanceConfig.printStackTrace(e2);
            }
            return;
        }
    }

    public class PaytmWebViewClient extends WebViewClient {
        public PaytmWebViewClient(AnonymousClass1 r2) {
        }

        public synchronized void onPageFinished(WebView webView, String str) {
            Intent intent;
            PaytmPGActivity paytmPGActivity;
            super.onPageFinished(webView, str);
            if (PaytmPGService.getService() == null || PaytmPGService.getService().mOrder == null) {
                TextAppearanceConfig.debugLog("Transaction cancelled before loading web view completely.");
                return;
            }
            try {
                TextAppearanceConfig.debugLog("Page finished loading " + str);
                PaytmWebView.access$300(PaytmWebView.this);
                if (str.equalsIgnoreCase(PaytmPGService.getService().mOrder.requestParamMap.get(PaytmRequestConstants.PARAMS_CALLBACK_URL).toString())) {
                    TextAppearanceConfig.debugLog("Merchant specific Callback Url is finished loading. Extract data now. ");
                    PaytmWebView.this.mbMerchantCallbackURLLoaded = true;
                    PaytmWebView.this.loadUrl("javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);");
                } else if (str.endsWith("/CAS/Response")) {
                    TextAppearanceConfig.debugLog("CAS Callback Url is finished loading. Extract data now. ");
                    PaytmWebView.this.loadUrl("javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);");
                }
                if (PaytmPGService.getService().mOrder.requestParamMap.get("postnotificationurl") != null) {
                    intent = new Intent(PaytmWebView.this.mContext, IntentServicePostNotification.class);
                    intent.putExtra("url", PaytmPGService.getService().mOrder.requestParamMap.get("postnotificationurl"));
                    paytmPGActivity = PaytmWebView.this.mContext;
                    paytmPGActivity.startService(intent);
                }
            } catch (Exception e2) {
                try {
                    TextAppearanceConfig.printStackTrace(e2);
                    if (PaytmPGService.getService().mOrder.requestParamMap.get("postnotificationurl") != null) {
                        intent = new Intent(PaytmWebView.this.mContext, IntentServicePostNotification.class);
                        intent.putExtra("url", PaytmPGService.getService().mOrder.requestParamMap.get("postnotificationurl"));
                        paytmPGActivity = PaytmWebView.this.mContext;
                    }
                } catch (Throwable th) {
                    if (PaytmPGService.getService().mOrder.requestParamMap.get("postnotificationurl") != null) {
                        Intent intent2 = new Intent(PaytmWebView.this.mContext, IntentServicePostNotification.class);
                        intent2.putExtra("url", PaytmPGService.getService().mOrder.requestParamMap.get("postnotificationurl"));
                        PaytmWebView.this.mContext.startService(intent2);
                    }
                    throw th;
                }
            }
        }

        public synchronized void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            TextAppearanceConfig.debugLog("Page started loading " + str);
            PaytmWebView paytmWebView = PaytmWebView.this;
            synchronized (paytmWebView) {
                try {
                    ((Activity) paytmWebView.getContext()).runOnUiThread(new Runnable() {
                        public void run() {
                            PaytmWebView.this.mContext.mProgress.setVisibility(0);
                            TextAppearanceConfig.debugLog("Progress dialog started");
                        }
                    });
                } catch (Exception e2) {
                    TextAppearanceConfig.printStackTrace(e2);
                }
            }
            return;
        }

        public synchronized void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            TextAppearanceConfig.debugLog("Error occured while loading url " + str2);
            TextAppearanceConfig.debugLog("Error code is " + i + "Description is " + str);
            if (i == -6) {
                ((Activity) PaytmWebView.this.getContext()).finish();
                PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                if (paytmPaymentTransactionCallback != null) {
                    paytmPaymentTransactionCallback.onErrorLoadingWebPage(i, str, str2);
                }
            }
        }

        public synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            TextAppearanceConfig.debugLog("SSL Error occured " + sslError.toString());
            TextAppearanceConfig.debugLog("SSL Handler is " + sslErrorHandler);
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    public PaytmWebView(Context context) {
        super(context);
        this.mContext = (PaytmPGActivity) context;
        setWebViewClient(new PaytmWebViewClient(null));
        setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                TextAppearanceConfig.debugLog("JavaScript Alert " + str);
                return super.onJsAlert(webView, str, str2, jsResult);
            }
        });
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        addJavascriptInterface(new PaytmJavaScriptInterface(null), "HTMLOUT");
    }

    public static void access$300(PaytmWebView paytmWebView) {
        synchronized (paytmWebView) {
            try {
                ((Activity) paytmWebView.getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        PaytmWebView.this.mContext.mProgress.setVisibility(8);
                        TextAppearanceConfig.debugLog("Progress dialog ended");
                    }
                });
            } catch (Exception e2) {
                TextAppearanceConfig.printStackTrace(e2);
            }
        }
        return;
    }

    public static Bundle access$600(PaytmWebView paytmWebView, String str) {
        Bundle bundle;
        synchronized (paytmWebView) {
            TextAppearanceConfig.debugLog("Parsing the Merchant Response");
            bundle = new Bundle();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject.getString(next);
                        TextAppearanceConfig.debugLog(next + " = " + string);
                        bundle.putString(next, string);
                    }
                }
            } catch (Exception e2) {
                TextAppearanceConfig.debugLog("Error while parsing the Merchant Response");
                TextAppearanceConfig.printStackTrace(e2);
            }
        }
        return bundle;
    }
}
