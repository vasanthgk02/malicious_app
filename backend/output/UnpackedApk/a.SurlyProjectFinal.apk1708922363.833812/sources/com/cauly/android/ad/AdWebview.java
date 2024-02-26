package com.cauly.android.ad;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.androidsdk.impl.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdWebview extends Dialog {
    RelativeLayout Total_layout = new RelativeLayout(this.mContext);
    WebView adWebView;
    ImageButton close_btn;
    RelativeLayout close_layout;
    LayoutParams close_params;
    Context mContext;
    ProgressDialog mProgress;
    LayoutParams webViewparams;

    class CaulyWebViewClient extends WebViewClient {
        CaulyWebViewClient() {
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (AdWebview.this.mProgress == null) {
                AdWebview.this.mProgress = new ProgressDialog(AdWebview.this.getContext());
                AdWebview.this.mProgress = ProgressDialog.show(AdWebview.this.getContext(), Constants.QA_SERVER_URL, "광고를 불러오는 중입니다.\n잠시만 기다려주세요.", true, true);
            }
        }

        public void onPageFinished(WebView view, String url) {
            if (AdWebview.this.mProgress != null && AdWebview.this.mProgress.isShowing()) {
                AdWebview.this.mProgress.dismiss();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Matcher youtubeMatcher = Pattern.compile("^(https?:\\/\\/)((\\w+\\.)?(youtube.com)|(youtu.be))").matcher(url);
            Matcher caulyBrowserMatcher = Pattern.compile("cauly_sdk_param=open_browser").matcher(url);
            if (youtubeMatcher.find() || caulyBrowserMatcher.find()) {
                return AdWebview.this.openBrowser(url);
            }
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                return AdWebview.this.openBrowser(url);
            }
            view.loadUrl(url);
            return true;
        }
    }

    AdWebview(Context context) {
        super(context);
        this.mContext = context;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.Total_layout.setLayoutParams(new LayoutParams(-1, -1));
        this.Total_layout.setBackgroundColor(0);
        this.adWebView = new WebView(this.mContext);
        this.adWebView.setBackgroundColor(0);
        this.adWebView.getSettings().setJavaScriptEnabled(true);
        this.adWebView.getSettings().setDefaultZoom(ZoomDensity.FAR);
        this.adWebView.getSettings().setLoadWithOverviewMode(true);
        this.adWebView.getSettings().setUseWideViewPort(true);
        this.adWebView.setVerticalScrollBarEnabled(true);
        this.adWebView.setHorizontalScrollBarEnabled(true);
        this.adWebView.getSettings().setBuiltInZoomControls(true);
        this.adWebView.getSettings().setPluginsEnabled(true);
        this.adWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                AdWebview.this.openBrowser(url);
            }
        });
        this.webViewparams = new LayoutParams(-1, -1);
        this.adWebView.setLayoutParams(this.webViewparams);
        this.close_layout = new RelativeLayout(getContext());
        this.close_params = new LayoutParams(-1, -2);
        this.close_layout.setLayoutParams(this.close_params);
        this.close_layout.setGravity(5);
        this.close_btn = new ImageButton(getContext());
        try {
            Bitmap bitmapOrg = BitmapFactory.decodeStream(getContext().getAssets().open("pop_btn_x.png"));
            this.close_btn.setBackgroundDrawable(new BitmapDrawable(Bitmap.createScaledBitmap(bitmapOrg, (int) (((double) bitmapOrg.getWidth()) * 1.5d), (int) (((double) bitmapOrg.getHeight()) * 1.5d), true)));
            this.close_btn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    AdWebview.this.adWebView.destroyDrawingCache();
                    AdWebview.this.adWebView.destroy();
                    AdWebview.this.dismiss();
                }
            });
            this.Total_layout.addView(this.adWebView);
            this.close_layout.addView(this.close_btn);
            this.Total_layout.addView(this.close_layout);
            setContentView(this.Total_layout);
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    public boolean openBrowser(String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.putExtra("com.android.browser.application_id", getContext().getApplicationContext().getPackageName());
        try {
            getContext().getApplicationContext().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setAdData(AdData adData, AdCommon adCommon) {
        this.adWebView.loadUrl(adData.getLink());
        this.adWebView.setWebViewClient(new CaulyWebViewClient());
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.adWebView.canGoBack()) {
            return super.onKeyDown(keyCode, event);
        }
        this.adWebView.goBack();
        return false;
    }
}
