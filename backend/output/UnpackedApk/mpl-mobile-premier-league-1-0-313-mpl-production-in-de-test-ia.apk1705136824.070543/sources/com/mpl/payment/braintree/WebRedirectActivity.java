package com.mpl.payment.braintree;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.mpl.payment.R;
import com.mpl.payment.routing.RoutingConstants;
import com.mpl.payment.utils.StringUtils;

public class WebRedirectActivity extends AppCompatActivity {
    public static final String TAG = "WebRedirectActivity";
    public static final String WEB_REDIRECT_ACTIVITY_EXTRA_HOST = "WEB_REDIRECT_ACTIVITY_EXTRA_HOST";
    public static final String WEB_REDIRECT_ACTIVITY_EXTRA_REDIRECT_PATH = "WEB_REDIRECT_ACTIVITY_EXTRA_REDIRECT_PATH";
    public static final String WEB_REDIRECT_ACTIVITY_EXTRA_URL = "WEB_REDIRECT_ACTIVITY_EXTRA_URL";
    public ImageView bckBtnId;
    public WebView webView;

    /* access modifiers changed from: private */
    public void closeScreen() {
        setResult(0, new Intent());
        finish();
    }

    /* access modifiers changed from: private */
    public void evaluateQueryParams(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter("nonce");
            String queryParameter2 = uri.getQueryParameter(RoutingConstants.MI_REACT_SAVED_CARD_TYPE);
            String queryParameter3 = uri.getQueryParameter("bin");
            String queryParameter4 = uri.getQueryParameter("lastFour");
            Intent intent = new Intent();
            intent.putExtra("nonce", queryParameter);
            intent.putExtra(RoutingConstants.MI_REACT_SAVED_CARD_TYPE, queryParameter2);
            intent.putExtra("bin", queryParameter3);
            intent.putExtra("lastFour", queryParameter4);
            setResult(-1, intent);
            finish();
        } catch (Exception unused) {
            setResult(2);
            finish();
        }
    }

    private void loadCardUiUrl(String str, final String str2, final String str3) {
        this.webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                String path = parse.getPath();
                if (str3.equalsIgnoreCase(authority) && str2.equalsIgnoreCase(path)) {
                    WebRedirectActivity.this.evaluateQueryParams(parse);
                }
            }
        });
        this.webView.loadUrl(str);
    }

    public void onBackPressed() {
        closeScreen();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_redirect);
        this.webView = (WebView) findViewById(R.id.redirect_web_view);
        this.bckBtnId = (ImageView) findViewById(R.id.bckBtnId);
        this.webView.getSettings().setJavaScriptEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(WEB_REDIRECT_ACTIVITY_EXTRA_HOST, "");
            String string2 = extras.getString(WEB_REDIRECT_ACTIVITY_EXTRA_URL, "");
            String string3 = extras.getString(WEB_REDIRECT_ACTIVITY_EXTRA_REDIRECT_PATH, "");
            if (!StringUtils.isNullOrEmpty(string2) && !StringUtils.isNullOrEmpty(string3)) {
                loadCardUiUrl(string2, string3, string);
            }
        }
        this.bckBtnId.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WebRedirectActivity.this.closeScreen();
            }
        });
    }
}
