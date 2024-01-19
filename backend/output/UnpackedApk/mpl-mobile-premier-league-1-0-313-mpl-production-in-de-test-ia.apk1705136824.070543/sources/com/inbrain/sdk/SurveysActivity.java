package com.inbrain.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.inbrain.sdk.callback.InBrainCallback;
import com.inbrain.sdk.model.Configuration;
import com.paynimo.android.payment.util.Constant;
import java.io.IOException;
import java.util.HashMap;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public class SurveysActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f1790a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f1791b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f1792c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f1793d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f1794e;

    /* renamed from: f  reason: collision with root package name */
    public String f1795f;
    public boolean g;
    public String h;
    public String i;
    public boolean j;
    public String k;
    public HashMap<String, String> l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public final Handler s = new Handler();
    public AlertDialog t;
    public AlertDialog u;
    public boolean v;
    public a w;
    public boolean x;

    public class a extends BroadcastReceiver {
        public a(byte b2) {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getExtras() != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getState() == State.CONNECTED) {
                    SurveysActivity surveysActivity = SurveysActivity.this;
                    if (surveysActivity.x) {
                        surveysActivity.x = false;
                        SurveysActivity.c(surveysActivity);
                    }
                } else if (intent.getExtras().getBoolean("noConnectivity", false)) {
                    SurveysActivity.this.x = true;
                }
            }
        }
    }

    public class b {
        public b(byte b2) {
        }

        @JavascriptInterface
        public final void dismissWebView() {
            SurveysActivity surveysActivity = SurveysActivity.this;
            surveysActivity.v = true;
            surveysActivity.finish();
        }

        @JavascriptInterface
        public final void nativeSurveyClosed() {
            SurveysActivity surveysActivity = SurveysActivity.this;
            surveysActivity.v = true;
            surveysActivity.finish();
        }

        @JavascriptInterface
        public final void surveyClosed() {
            SurveysActivity surveysActivity = SurveysActivity.this;
            surveysActivity.r = false;
            surveysActivity.runOnUiThread(new Runnable(false) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f1799a;

                {
                    this.f1799a = r2;
                }

                public final void run() {
                    if (this.f1799a) {
                        SurveysActivity.this.runOnUiThread(new Runnable() {

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ boolean f1801a = true;

                            public final void run() {
                                int i = 8;
                                SurveysActivity.this.f1793d.setVisibility(this.f1801a ? 0 : 8);
                                TextView textView = SurveysActivity.this.f1794e;
                                if (this.f1801a) {
                                    i = 0;
                                }
                                textView.setVisibility(i);
                            }
                        });
                    }
                    SurveysActivity.this.f1794e.setVisibility(this.f1799a ? 8 : 0);
                }
            });
            SurveysActivity.this.b(true);
        }

        @JavascriptInterface
        public final void surveyOpened() {
            SurveysActivity surveysActivity = SurveysActivity.this;
            surveysActivity.r = true;
            surveysActivity.runOnUiThread(new Runnable(true) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f1799a;

                {
                    this.f1799a = r2;
                }

                public final void run() {
                    if (this.f1799a) {
                        SurveysActivity.this.runOnUiThread(new Runnable() {

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ boolean f1801a = true;

                            public final void run() {
                                int i = 8;
                                SurveysActivity.this.f1793d.setVisibility(this.f1801a ? 0 : 8);
                                TextView textView = SurveysActivity.this.f1794e;
                                if (this.f1801a) {
                                    i = 0;
                                }
                                textView.setVisibility(i);
                            }
                        });
                    }
                    SurveysActivity.this.f1794e.setVisibility(this.f1799a ? 8 : 0);
                }
            });
        }
    }

    public static /* synthetic */ boolean a(SurveysActivity surveysActivity, WebView webView) {
        String extra = webView.getHitTestResult().getExtra();
        if (TextUtils.isEmpty(extra)) {
            return false;
        }
        if (surveysActivity.f1792c == null) {
            WebView webView2 = new WebView(surveysActivity);
            surveysActivity.f1792c = webView2;
            surveysActivity.a(webView2);
            surveysActivity.f1792c.setWebViewClient(new WebViewClient());
            surveysActivity.f1790a.addView(surveysActivity.f1792c);
        }
        surveysActivity.f1792c.loadUrl(extra);
        return true;
    }

    public static Intent b(Context context, boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, HashMap<String, String> hashMap, String str6, String str7, int i2, int i3, int i4, int i5, boolean z3, boolean z4) {
        Context context2 = context;
        Intent intent = new Intent(context, SurveysActivity.class);
        boolean z5 = z;
        intent.putExtra("15213412", z);
        String str8 = str;
        intent.putExtra("368234109", str);
        String str9 = str2;
        intent.putExtra("6388991", str2);
        boolean z6 = z2;
        intent.putExtra("71263886", z2);
        String str10 = str3;
        intent.putExtra("64548792", str3);
        HashMap<String, String> hashMap2 = hashMap;
        intent.putExtra("15895132", hashMap);
        String str11 = str4;
        intent.putExtra("29678234", str4);
        String str12 = str5;
        intent.putExtra("97497286", str5);
        String str13 = str7;
        intent.putExtra("64587132", str7);
        int i6 = i2;
        intent.putExtra("67584922", i2);
        int i7 = i3;
        intent.putExtra("13645898", i3);
        intent.putExtra("12343214", i4);
        intent.putExtra("89732498", i5);
        intent.putExtra("46782388", z3);
        intent.putExtra("81237412", z4);
        if (!TextUtils.isEmpty(str6)) {
            String str14 = str6;
            intent.putExtra("51211232", str6);
        }
        return intent;
    }

    public static void b(WebView webView) {
        webView.setWebViewClient(null);
        webView.clearView();
        webView.freeMemory();
        webView.removeAllViews();
        webView.destroy();
    }

    public static /* synthetic */ void c(SurveysActivity surveysActivity) {
        try {
            Configuration configuration = new Configuration(surveysActivity.h, surveysActivity.i, surveysActivity.m, surveysActivity.n, surveysActivity.o, surveysActivity.p, surveysActivity.k, surveysActivity.l, surveysActivity.q);
            surveysActivity.f1791b.loadUrl(String.format("javascript:setConfiguration(%s);", new Object[]{configuration.toJson()}));
        } catch (IOException unused) {
            surveysActivity.b();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a(WebView webView) {
        webView.setLongClickable(false);
        webView.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setWebChromeClient(new WebChromeClient() {
            public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                return SurveysActivity.a(SurveysActivity.this, webView);
            }
        });
    }

    public final void b() {
        this.f1791b.setVisibility(4);
        AlertDialog alertDialog = this.t;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.t = new Builder(this).setTitle(R$string.error_inbrain_unavailable_title).setMessage(getString(R$string.error_inbrain_unavailable_message)).setPositiveButton(R$string.quit, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SurveysActivity.this.finish();
                }
            }).setCancelable(false).show();
        }
    }

    public final void b(boolean z) {
        if (!this.j) {
            if (z) {
                this.s.postDelayed(new Runnable() {
                    public final void run() {
                        InBrain.getInstance().getRewards();
                    }
                }, MqttAsyncClient.DISCONNECT_TIMEOUT);
            } else {
                InBrain.getInstance().getRewards();
            }
        }
    }

    public final void c(boolean z) {
        WebView webView = this.f1792c;
        if (webView != null) {
            this.f1790a.removeView(webView);
            b(this.f1792c);
            this.f1792c = null;
        } else if (!this.r) {
            finish();
        } else if (!z) {
            AlertDialog alertDialog = this.u;
            if (alertDialog == null || !alertDialog.isShowing()) {
                this.u = new Builder(this).setTitle(R$string.dont_abandon_the_survey_title).setMessage(getString(R$string.dont_abandon_the_survey_message)).setPositiveButton(R$string.abort_survey, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SurveysActivity surveysActivity = SurveysActivity.this;
                        surveysActivity.r = false;
                        surveysActivity.runOnUiThread(new Runnable(false) {

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ boolean f1799a;

                            {
                                this.f1799a = r2;
                            }

                            public final void run() {
                                if (this.f1799a) {
                                    SurveysActivity.this.runOnUiThread(new Runnable() {

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ boolean f1801a = true;

                                        public final void run() {
                                            int i = 8;
                                            SurveysActivity.this.f1793d.setVisibility(this.f1801a ? 0 : 8);
                                            TextView textView = SurveysActivity.this.f1794e;
                                            if (this.f1801a) {
                                                i = 0;
                                            }
                                            textView.setVisibility(i);
                                        }
                                    });
                                }
                                SurveysActivity.this.f1794e.setVisibility(this.f1799a ? 8 : 0);
                            }
                        });
                        Object[] objArr = new Object[1];
                        objArr[0] = surveysActivity.g ? "https://inbrainwebview-qa.azureedge.net" : "https://www.surveyb.in";
                        surveysActivity.f1791b.loadUrl(String.format("%s/feedback", objArr));
                    }
                }).setNegativeButton(R$string.cancel, null).show();
            }
        }
    }

    public void onBackPressed() {
        c(true);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void onCreate(Bundle bundle) {
        setTheme(R$style.InBrainTheme);
        super.onCreate(bundle);
        getWindow().requestFeature(8);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        setContentView(R$layout.activity_surveys);
        this.f1793d = (ImageView) findViewById(R$id.back_image);
        this.f1794e = (TextView) findViewById(R$id.toolbar_title_text);
        getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R$color.background)));
        Intent intent = getIntent();
        this.g = intent.getBooleanExtra("15213412", false);
        this.h = intent.getStringExtra("368234109");
        this.i = intent.getStringExtra("6388991");
        this.j = intent.getBooleanExtra("71263886", false);
        this.k = intent.getStringExtra("64548792");
        this.l = (HashMap) intent.getSerializableExtra("15895132");
        this.m = intent.getStringExtra("29678234");
        this.n = intent.getStringExtra("97497286");
        this.o = intent.getStringExtra("56238743");
        if (intent.hasExtra("56238744")) {
            this.p = intent.getStringExtra("56238744");
        }
        Object[] objArr = new Object[1];
        objArr[0] = this.g ? "https://inbrainwebview-qa.azureedge.net" : "https://www.surveyb.in";
        this.f1795f = String.format("%s/configuration", objArr);
        if (intent.hasExtra("51211232")) {
            this.q = intent.getStringExtra("51211232");
        }
        if (intent.hasExtra("64587132")) {
            this.f1794e.setText(intent.getStringExtra("64587132"));
        }
        if (intent.hasExtra("67584922")) {
            findViewById(R$id.toolbar).setBackgroundColor(intent.getIntExtra("67584922", 0));
        }
        if (intent.hasExtra("13645898")) {
            this.f1793d.setColorFilter(intent.getIntExtra("13645898", getResources().getColor(R$color.main_text)));
        }
        if (intent.hasExtra("12343214")) {
            this.f1794e.setTextColor(intent.getIntExtra("12343214", getResources().getColor(R$color.main_text)));
        }
        if (intent.hasExtra("89732498")) {
            getWindow().setStatusBarColor(intent.getIntExtra("89732498", getResources().getColor(R$color.main_text)));
        }
        if (intent.hasExtra("46782388") && intent.getBooleanExtra("46782388", false)) {
            findViewById(R$id.toolbar).setElevation(getResources().getDimension(R$dimen.elevation));
        }
        if (VERSION.SDK_INT >= 23 && intent.hasExtra("81237412") && !intent.getBooleanExtra("81237412", false)) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192);
        }
        this.f1790a = (ViewGroup) findViewById(R$id.web_views_container);
        this.f1791b = (WebView) findViewById(R$id.web_view);
        this.w = new a(0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constant.INTENT_NETWORK_STATUS);
        registerReceiver(this.w, intentFilter);
        this.f1793d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SurveysActivity.this.c(false);
            }
        });
        a(this.f1791b);
        this.f1791b.setWebViewClient(new WebViewClient() {
            public final void onPageFinished(WebView webView, String str) {
                if (webView.getProgress() >= 100 && str.equals(SurveysActivity.this.f1795f) && str.equals(SurveysActivity.this.f1795f)) {
                    SurveysActivity.c(SurveysActivity.this);
                }
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                SurveysActivity.this.b();
            }

            @TargetApi(23)
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    SurveysActivity.this.b();
                }
            }
        });
        this.f1791b.addJavascriptInterface(new b(0), "androidInterface");
        this.f1791b.clearHistory();
        this.f1791b.loadUrl(this.f1795f);
        b(false);
    }

    public void onDestroy() {
        unregisterReceiver(this.w);
        b(true);
        WebView webView = this.f1792c;
        if (webView != null) {
            b(webView);
        }
        this.f1791b.removeJavascriptInterface("androidInterface");
        b(this.f1791b);
        super.onDestroy();
        InBrain instance = InBrain.getInstance();
        boolean z = this.v;
        if (!instance.f1722a.isEmpty()) {
            for (InBrainCallback next : instance.f1722a) {
                instance.f1723b.post(z ? new Runnable(instance, next) {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InBrainCallback f1789a;

                    {
                        this.f1789a = r2;
                    }

                    public final void run() {
                        this.f1789a.surveysClosedFromPage();
                    }
                } : new Runnable(instance, next) {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ InBrainCallback f1728a;

                    {
                        this.f1728a = r2;
                    }

                    public final void run() {
                        this.f1728a.surveysClosed();
                    }
                });
            }
        }
    }
}
