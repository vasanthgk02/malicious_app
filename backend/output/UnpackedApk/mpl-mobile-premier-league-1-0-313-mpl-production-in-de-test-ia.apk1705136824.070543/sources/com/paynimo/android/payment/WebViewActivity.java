package com.paynimo.android.payment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.b.a;
import com.paynimo.android.payment.b.d;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.network.ConnectionDetector;
import com.paynimo.android.payment.util.Constant;
import com.paynimo.android.payment.util.ShowDialog;
import com.paynimo.android.payment.util.b;

public class WebViewActivity extends AppCompatActivity {
    public static final String HDFC_LOGIN_URL = "https://netbanking.hdfcbank.com/netbanking/merchant";
    public static final String HDFC_OTP_URL = "https://netbanking.hdfcbank.com/netbanking/epientry";
    public static final int PERMISSION_REQUEST_CODE = 11;
    public static boolean isNetworkRcvrRegistered;
    public final String TAG = WebViewActivity.class.getSimpleName();
    public String WEBSITE_URL = "";
    public Context activitycontxt = this;
    public String bankCode;
    public Checkout checkout;
    public IntentFilter filter = new IntentFilter(Constant.INTENT_NETWORK_STATUS);
    public boolean isOnDestroyCalled = false;
    public boolean isUrlLoaded = false;
    public BroadcastReceiver mNetworkStatusReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (ConnectionDetector.getConnectivityStatus(context)) {
                WebViewActivity.this.TAG;
                return;
            }
            WebViewActivity.this.TAG;
            ShowDialog.showAlertDialog(WebViewActivity.this.activitycontxt, WebViewActivity.this.getResources().getString(WebViewActivity.this.getResources().getIdentifier("paynimo_alert_dialog_connection_error_heading", NetworkingModule.REQUEST_BODY_KEY_STRING, WebViewActivity.this.getApplicationContext().getPackageName())), WebViewActivity.this.getResources().getString(WebViewActivity.this.getResources().getIdentifier("paynimo_connection_error", NetworkingModule.REQUEST_BODY_KEY_STRING, WebViewActivity.this.getApplicationContext().getPackageName())), Boolean.FALSE);
        }
    };
    public a mService;
    public d mServiceManager;
    public boolean pageLoaded = false;
    public CountDownTimer timer;
    public String url_load_type;
    public String url_params;
    public WebView webView;
    public WebView webView1;

    public class MyWebViewClient extends WebViewClient {
        public MyWebViewClient() {
        }

        private void startTimer() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            AnonymousClass1 r1 = new CountDownTimer(300000, 500) {
                public void onFinish() {
                }

                public void onTick(long j) {
                    if (WebViewActivity.this.webView.getUrl() != null && WebViewActivity.this.webView.getUrl().equalsIgnoreCase(WebViewActivity.HDFC_LOGIN_URL)) {
                        WebViewActivity.this.webView.evaluateJavascript("(function() { var element = (document.querySelector('frameset [name=\"bottom_frame\"]')) ? document.querySelector('frameset [name=\"bottom_frame\"]').contentDocument.querySelector('[name=\"fldCustId\"]') : ''; return element; })();", new ValueCallback<String>() {
                            public void onReceiveValue(String str) {
                                if (!str.equals("null") && !str.equals("undefined")) {
                                    WebViewActivity.this.webView.evaluateJavascript("var meta = document.createElement('meta');\nmeta.name = \"viewport\";\nmeta.content = \"width=device-width, initial-scale=1\";\ndocument.querySelector('head').appendChild(meta);var customCss = '/*For login page*/'+\n'[name=\"frmLogin\"] [src=\"/gif/header1_new1.jpg?v=1\"]{display:none;}'+\n'[name=\"frmLogin\"] [bordercolor=\"#ff7f50\"]{display: none}'+\n'[name=\"frmLogin\"] [width=\"770\"] {width: auto}'+\n'[name=\"frmLogin\"] [width=\"770\"] [width=\"228\"]{width:100%}'+\n'[name=\"frmLogin\"] .body_text, [name=\"frmLogin\"] .body_text2, [name=\"frmLogin\"] .vkb_btm_Table, [name=\"frmLogin\"] .formtable, [name=\"frmLogin\"] td.label{display:none;}'+\n'/*For authentication page*/'+\n'[name=\"frmMain\"] [usemap=\"#Map\"]{display:none;}'+\n'[name=\"frmMain\"] [bgcolor=\"blue\"]{background:none;}'+\n'[name=\"frmMain\"] .body_text, [name=\"frmMain\"] .body_text2, [name=\"frmMain\"] .vkb_btm_Table, [name=\"frmMain\"] .formtable, [name=\"frmMain\"] td.label{display:none;}'+\n'[name=\"frmMain\"] table, [name=\"frmMain\"] form{width:auto;margin: auto;}'+\n'form{width:auto !important;}'+\n'[name=\"frmMain\"] .phrase_box_table{margin: 0px}'+\n'/*OTP page*/'+\n'[name=\"frmPost\"] .body_content, [name=\"frmPost\"] .content{width:auto}'+\n'[name=\"frmPost\"] .content_area {margin-left:10px;margin-right:10px;}'+\n'[name=\"frmPost\"] table {width:auto}'+\n'input:visible {padding:10px}'+\n'form.width{width: auto;}',\n    head = document.querySelector('frameset [name=\"bottom_frame\"]').contentDocument.querySelector('head'),\n    style = document.createElement('style');\n\nhead.appendChild(style);\n\nstyle.type = 'text/css';\nif (style.styleSheet){\n  // This is required for IE8 and below.\n  style.styleSheet.cssText = customCss;\n} else {\n  style.appendChild(document.createTextNode(customCss));\n}", null);
                                    WebViewActivity.this.timer.cancel();
                                    WebViewActivity.this.timer = null;
                                }
                            }
                        });
                    }
                }
            };
            webViewActivity.timer = r1;
            WebViewActivity.this.timer.start();
        }

        public void onPageFinished(WebView webView, String str) {
            if (str.contains(WebViewActivity.HDFC_LOGIN_URL)) {
                WebViewActivity.this.webView.evaluateJavascript("var meta = document.createElement('meta');\nmeta.name = \"viewport\";\nmeta.content = \"width=device-width, initial-scale=1\";\ndocument.querySelector('head').appendChild(meta);var customCss = '/*For login page*/'+\n'[name=\"frmLogin\"] [src=\"/gif/header1_new1.jpg?v=1\"]{display:none;}'+\n'[name=\"frmLogin\"] [bordercolor=\"#ff7f50\"]{display: none}'+\n'[name=\"frmLogin\"] [width=\"770\"] {width: auto}'+\n'[name=\"frmLogin\"] [width=\"770\"] [width=\"228\"]{width:100%}'+\n'[name=\"frmLogin\"] .body_text, [name=\"frmLogin\"] .body_text2, [name=\"frmLogin\"] .vkb_btm_Table, [name=\"frmLogin\"] .formtable, [name=\"frmLogin\"] td.label{display:none;}'+\n'/*For authentication page*/'+\n'[name=\"frmMain\"] [usemap=\"#Map\"]{display:none;}'+\n'[name=\"frmMain\"] [bgcolor=\"blue\"]{background:none;}'+\n'[name=\"frmMain\"] .body_text, [name=\"frmMain\"] .body_text2, [name=\"frmMain\"] .vkb_btm_Table, [name=\"frmMain\"] .formtable, [name=\"frmMain\"] td.label{display:none;}'+\n'[name=\"frmMain\"] table, [name=\"frmMain\"] form{width:auto;margin: auto;}'+\n'form{width:auto !important;}'+\n'[name=\"frmMain\"] .phrase_box_table{margin: 0px}'+\n'/*OTP page*/'+\n'[name=\"frmPost\"] .body_content, [name=\"frmPost\"] .content{width:auto}'+\n'[name=\"frmPost\"] .content_area {margin-left:10px;margin-right:10px;}'+\n'[name=\"frmPost\"] table {width:auto}'+\n'input:visible {padding:10px}'+\n'form.width{width: auto;}',\n    head = document.querySelector('[name=\"bottom_frame\"]').contentDocument.querySelector('head'),\n    style = document.createElement('style');\n\nhead.appendChild(style);\n\nstyle.type = 'text/css';\nif (style.styleSheet){\n  // This is required for IE8 and below.\n  style.styleSheet.cssText = customCss;\n} else {\n  style.appendChild(document.createTextNode(customCss));\n}", null);
                startTimer();
            } else if (str.contains(WebViewActivity.HDFC_OTP_URL)) {
                WebViewActivity.this.webView.evaluateJavascript("var meta = document.createElement('meta');\nmeta.name = \"viewport\";\nmeta.content = \"width=device-width, initial-scale=1\";\ndocument.querySelector('head').appendChild(meta);var customCss = '/*For login page*/'+\n'[name=\"frmLogin\"] [src=\"/gif/header1_new1.jpg?v=1\"]{display:none;}'+\n'[name=\"frmLogin\"] [bordercolor=\"#ff7f50\"]{display: none}'+\n'[name=\"frmLogin\"] [width=\"770\"] {width: auto}'+\n'[name=\"frmLogin\"] [width=\"770\"] [width=\"228\"]{width:100%}'+\n'[name=\"frmLogin\"] .body_text, [name=\"frmLogin\"] .body_text2, [name=\"frmLogin\"] .vkb_btm_Table, [name=\"frmLogin\"] .formtable, [name=\"frmLogin\"] td.label{display:none;}'+\n'/*For authentication page*/'+\n'[name=\"frmMain\"] [usemap=\"#Map\"]{display:none;}'+\n'[name=\"frmMain\"] [bgcolor=\"blue\"]{background:none;}'+\n'[name=\"frmMain\"] .body_text, [name=\"frmMain\"] .body_text2, [name=\"frmMain\"] .vkb_btm_Table, [name=\"frmMain\"] .formtable, [name=\"frmMain\"] td.label{display:none;}'+\n'[name=\"frmMain\"] table, [name=\"frmMain\"] form{width:auto;margin: auto;}'+\n'form{width:auto !important;}'+\n'[name=\"frmMain\"] .phrase_box_table{margin: 0px}'+\n'/*OTP page*/'+\n'[name=\"frmPost\"] .body_content, [name=\"frmPost\"] .content{width:auto}'+\n'[name=\"frmPost\"] .content_area {margin-left:10px;margin-right:10px;}'+\n'[name=\"frmPost\"] table {width:auto}'+\n'input:visible {padding:10px}'+\n'form.width{width: auto;}',\n    head = document.querySelector('head'),\n    style = document.createElement('style');\n\nhead.appendChild(style);\n\nstyle.type = 'text/css';\nif (style.styleSheet){\n  // This is required for IE8 and below.\n  style.styleSheet.cssText = customCss;\n} else {\n  style.appendChild(document.createTextNode(customCss));\n}", null);
            }
            super.onPageFinished(webView, str);
            WebViewActivity.this.pageLoaded = true;
            WebViewActivity.this.webView.evaluateJavascript("var function1 = function() {var input = document.getElementsByTagName('input')[0];var rect=input.getBoundingClientRect();var left=rect.left-50;var top=rect.top-50;window.scrollTo(left, top);};", null);
            WebViewActivity.this.bankCode;
            WebViewActivity.this.hideProgressLoader();
            if (WebViewActivity.this.webView != null) {
                WebViewActivity.this.webView.setVisibility(0);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebViewActivity.this.pageLoaded = false;
            try {
                WebViewActivity.this.showProgressLoader();
                WebViewActivity.this.webView.setVisibility(8);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            int primaryError = sslError.getPrimaryError();
            String str = primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "The certificate is invalid." : "A generic error occurred." : "The date of the certificate is invalid." : "The certificate authority is not trusted." : "Hostname mismatch." : "The certificate has expired." : "The certificate is not yet valid.";
            Builder builder = new Builder(WebViewActivity.this, 16974374);
            builder.P.mMessage = str;
            AnonymousClass3 r3 = new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    sslErrorHandler.proceed();
                }
            };
            AlertParams alertParams = builder.P;
            alertParams.mPositiveButtonText = "Continue";
            alertParams.mPositiveButtonListener = r3;
            builder.setNegativeButton(17039360, (OnClickListener) new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    sslErrorHandler.cancel();
                }
            });
            builder.P.mIconId = 17301543;
            builder.show();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    public class WebAppInterface {
        public Context mContext;

        public WebAppInterface(Context context) {
            this.mContext = context;
        }

        @JavascriptInterface
        public void setTER(String str, String str2) {
            Intent intent = new Intent();
            intent.putExtra("msg", str);
            intent.putExtra("tpsl_mrct_cd", str2);
            WebViewActivity.this.setResult(-1, intent);
            WebViewActivity.this.finish();
        }
    }

    private void finishActivityForChangeInPaymentMode() {
        setResult(-3, new Intent());
        finish();
    }

    /* access modifiers changed from: private */
    public void hideProgressLoader() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
        if (findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())) != null) {
            findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(8);
        }
        if (findViewById(getResources().getIdentifier("paynimo_header", "id", getPackageName())) != null) {
            findViewById(getResources().getIdentifier("paynimo_header", "id", getPackageName())).setVisibility(0);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setVisibility(0);
        }
    }

    private void showBackPressedDialog() {
        final Dialog dialog = new Dialog(this.activitycontxt);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(getResources().getIdentifier("paynimo_dialog_two_button", "layout", getApplicationContext().getPackageName()));
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_text", "id", getApplicationContext().getPackageName()))).setText(getResources().getString(getResources().getIdentifier("paynimo_back_press_dialog_message", NetworkingModule.REQUEST_BODY_KEY_STRING, getApplicationContext().getPackageName())));
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonOK", "id", getApplicationContext().getPackageName()))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                b.callEventLogging("", "click", "button:Back", 0, "PASS", WebViewActivity.this.checkout, "", "", "", "", WebViewActivity.this.mServiceManager, WebViewActivity.this);
                WebViewActivity.this.transactionCancelled();
            }
        });
        ((Button) dialog.findViewById(getResources().getIdentifier("paynimo_custom_dialog_ButtonCancel", "id", getApplicationContext().getPackageName()))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* access modifiers changed from: private */
    public void showProgressLoader() {
        findViewById(getResources().getIdentifier("paynimo_header", "id", getPackageName())).setVisibility(8);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(0);
        this.webView1.loadUrl("file:///android_asset/paynimo_loader_gif.gif");
    }

    public void finish() {
        try {
            if (isNetworkRcvrRegistered) {
                unregisterReceiver(this.mNetworkStatusReceiver);
                isNetworkRcvrRegistered = false;
            }
        } catch (Exception unused) {
        }
        this.isUrlLoaded = false;
        super.finish();
    }

    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            showBackPressedDialog();
        } else {
            showBackPressedDialog();
        }
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setIcon(getResources().getIdentifier("ic_launcher", "drawable", getApplicationContext().getPackageName()));
            supportActionBar.setDisplayShowHomeEnabled(true);
            supportActionBar.hide();
        }
        setContentView(getResources().getIdentifier("paynimo_activity_webview", "layout", getApplicationContext().getPackageName()));
        this.webView = (WebView) findViewById(getResources().getIdentifier("paynimo_webview_webkit", "id", getApplicationContext().getPackageName()));
        this.webView1 = (WebView) findViewById(getResources().getIdentifier("paynimo_webview", "id", getApplicationContext().getPackageName()));
        Intent intent = getIntent();
        if (intent != null) {
            this.bankCode = intent.getExtras().getString("BankCode", null);
            this.WEBSITE_URL = intent.getExtras().getString("web_url");
            String string = intent.getExtras().getString("req_load_type");
            this.url_load_type = string;
            if (string.equalsIgnoreCase(Constant.WEBVIEW_TYPE_POSTURL)) {
                this.url_params = intent.getExtras().getString("req_load_type_param");
            }
            if (intent.getExtras().containsKey(Constant.ARGUMENT_DATA_CHECKOUT)) {
                this.checkout = (Checkout) intent.getExtras().get(Constant.ARGUMENT_DATA_CHECKOUT);
            }
        }
        a aVar = new a();
        this.mService = aVar;
        this.mServiceManager = new d(aVar);
        if (bundle != null) {
            this.webView.restoreState(bundle);
        }
        this.webView.getSettings().setMixedContentMode(0);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setUseWideViewPort(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        String str = this.bankCode;
        if (str == null || !str.equalsIgnoreCase(Constant.BANKCODE_BOM)) {
            this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        } else {
            this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        }
        this.webView.getSettings().setSupportMultipleWindows(true);
        this.webView.setWebViewClient(new MyWebViewClient());
        this.webView.setWebChromeClient(new WebChromeClient() {
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                WebView webView2 = new WebView(WebViewActivity.this);
                webView2.getSettings().setJavaScriptEnabled(true);
                webView2.getSettings().setLoadWithOverviewMode(true);
                webView2.setWebViewClient(new MyWebViewClient());
                webView.addView(webView2, -1, -1);
                ((WebViewTransport) message.obj).setWebView(webView2);
                message.sendToTarget();
                return true;
            }

            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                WebViewActivity webViewActivity = WebViewActivity.this;
                Builder builder = new Builder(webViewActivity, webViewActivity.getResources().getIdentifier("DialogStylePaynimo", "style", WebViewActivity.this.getPackageName()));
                builder.P.mMessage = str2;
                builder.setPositiveButton(17039370, (OnClickListener) new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                });
                builder.setNegativeButton(17039360, (OnClickListener) new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.cancel();
                    }
                });
                builder.create().show();
                return true;
            }

            public void onProgressChanged(WebView webView, int i) {
            }
        });
        this.webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        if (!this.isUrlLoaded) {
            if (this.url_load_type.equalsIgnoreCase(Constant.WEBVIEW_TYPE_POSTURL)) {
                this.webView.postUrl(this.WEBSITE_URL, this.url_params.getBytes());
            } else {
                this.webView.loadUrl(this.WEBSITE_URL);
            }
            this.isUrlLoaded = true;
        }
        findViewById(getResources().getIdentifier("paynimo_loader", "id", getPackageName())).setVisibility(0);
        findViewById(getResources().getIdentifier("paynimo_header", "id", getPackageName())).setVisibility(8);
        this.webView.setVisibility(8);
    }

    public void onDestroy() {
        try {
            if (isNetworkRcvrRegistered) {
                unregisterReceiver(this.mNetworkStatusReceiver);
                isNetworkRcvrRegistered = false;
            }
        } catch (Exception unused) {
        }
        this.isUrlLoaded = false;
        this.isOnDestroyCalled = true;
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (!isNetworkRcvrRegistered) {
            registerReceiver(this.mNetworkStatusReceiver, this.filter);
            isNetworkRcvrRegistered = true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            if (this.webView != null) {
                this.webView.saveState(bundle);
            }
        } catch (Exception unused) {
        }
    }

    public void onStop() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.timer = null;
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.removeAllViews();
        }
        super.onStop();
    }

    public void transactionCancelled() {
        setResult(0, new Intent());
        finish();
    }

    public void transactionError(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra(PaymentActivity.RETURN_ERROR_CODE, str);
        intent.putExtra("error_description", str2);
        setResult(-2, intent);
        finish();
    }
}
