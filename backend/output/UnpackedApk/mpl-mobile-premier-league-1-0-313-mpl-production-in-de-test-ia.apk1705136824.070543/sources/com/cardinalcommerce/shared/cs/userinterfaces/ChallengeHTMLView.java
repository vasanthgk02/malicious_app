package com.cardinalcommerce.shared.cs.userinterfaces;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.cardinalcommerce.cardinalmobilesdk.R$id;
import com.cardinalcommerce.cardinalmobilesdk.R$layout;
import com.cardinalcommerce.cardinalmobilesdk.a.c.d;
import com.cardinalcommerce.shared.cs.c.c;
import com.cardinalcommerce.shared.cs.e.a;
import com.cardinalcommerce.shared.cs.e.b;
import com.cardinalcommerce.shared.cs.f.m;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.c$a;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.h;
import com.cardinalcommerce.shared.cs.utils.i;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import com.reactnativecommunity.webview.RNCWebViewManager;
import in.juspay.hypersdk.core.InflateView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;

public class ChallengeHTMLView extends AppCompatActivity implements c {

    /* renamed from: a  reason: collision with root package name */
    public WebView f2175a;

    /* renamed from: b  reason: collision with root package name */
    public b f2176b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2177c = false;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f2178d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f2179e = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("finish_activity")) {
                m a2 = m.a(ChallengeHTMLView.this.getApplicationContext());
                com.cardinalcommerce.emvco.a.e.c cVar = a2.m;
                if (cVar != null) {
                    cVar.cancel(true);
                }
                d dVar = a2.n;
                if (dVar != null) {
                    dVar.cancel(true);
                }
                ChallengeHTMLView.this.finish();
            }
        }
    };

    public void a() {
        f();
        finish();
    }

    public final void a(a aVar) {
        runOnUiThread(new Runnable() {
            public void run() {
                ChallengeHTMLView.this.getWindow().setFlags(16, 16);
                ChallengeHTMLView.this.f2178d.setVisibility(0);
            }
        });
        m.a(getApplicationContext()).a(aVar, this, "05");
    }

    public void a(final b bVar) {
        runOnUiThread(new Runnable() {
            public void run() {
                ChallengeHTMLView.this.b(bVar);
                ChallengeHTMLView.this.f();
            }
        });
    }

    public final void b(b bVar) {
        String replaceAll = new String(Base64.decode(bVar.f2090f, 8), StandardCharsets.UTF_8).replaceAll("\"POST\"", "\"GET\"").replaceAll("\"post\"", "\"get\"").replaceAll("<input type=\"submit\"", "<input type=\"submit\" name=\"submit\"");
        if (!replaceAll.isEmpty()) {
            this.f2175a.loadDataWithBaseURL("HTTPS://EMV3DS/challenge", replaceAll, RNCWebViewManager.HTML_MIME_TYPE, "UTF-8", null);
        }
    }

    public final void f() {
        runOnUiThread(new Runnable() {
            public void run() {
                ChallengeHTMLView.this.getWindow().clearFlags(16);
                ChallengeHTMLView.this.f2178d.setVisibility(8);
            }
        });
    }

    public void onBackPressed() {
        f();
        com.cardinalcommerce.shared.cs.e.c cVar = new com.cardinalcommerce.shared.cs.e.c();
        cVar.f2091a = ThreeDSStrings.CHALLENGE_CANCEL_CHAR;
        a(new a(this.f2176b, cVar));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerReceiver(this.f2179e, new IntentFilter("finish_activity"));
        boolean z = ThreeDSStrings.IS_EXTERNAL_BUILD;
        getWindow().setFlags(8192, 8192);
        this.f2176b = (b) ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getSerializable("StepUpData");
        UiCustomization uiCustomization = (UiCustomization) getIntent().getExtras().getSerializable("UiCustomization");
        setContentView(R$layout.activity_html_ui_view);
        CCATextView cCATextView = (CCATextView) findViewById(R$id.toolbarButton);
        cCATextView.setCCAOnClickListener(new c$a() {
            public void onClick(View view) {
                ChallengeHTMLView.a(ChallengeHTMLView.this);
            }
        });
        this.f2178d = (ProgressBar) findViewById(R$id.pbHeaderProgress);
        WebView webView = (WebView) findViewById(R$id.webviewUi);
        this.f2175a = webView;
        webView.getSettings().setJavaScriptEnabled(false);
        this.f2175a.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!str.isEmpty()) {
                    ChallengeHTMLView.a(ChallengeHTMLView.this, Uri.parse(str));
                }
                return false;
            }
        });
        b(this.f2176b);
        i.a(cCATextView, uiCustomization, (Activity) this);
        i.a((Toolbar) findViewById(R$id.toolbar), uiCustomization, (Activity) this);
    }

    public void onDestroy() {
        unregisterReceiver(this.f2179e);
        super.onDestroy();
    }

    public void onPause() {
        this.f2177c = true;
        super.onPause();
    }

    public void onResume() {
        if (this.f2177c) {
            String str = this.f2176b.H;
            if (!str.equalsIgnoreCase("")) {
                String str2 = new String(Base64.decode(str, 8), StandardCharsets.UTF_8);
                if (!str2.isEmpty()) {
                    this.f2175a.loadDataWithBaseURL("HTTPS://EMV3DS/challenge/refresh", str2, RNCWebViewManager.HTML_MIME_TYPE, "UTF-8", null);
                }
            }
        }
        super.onResume();
    }

    public static void a(ChallengeHTMLView challengeHTMLView) {
        if (challengeHTMLView != null) {
            com.cardinalcommerce.shared.cs.e.c cVar = new com.cardinalcommerce.shared.cs.e.c();
            cVar.f2091a = ThreeDSStrings.CHALLENGE_CANCEL_CHAR;
            challengeHTMLView.a(new a(challengeHTMLView.f2176b, cVar));
            return;
        }
        throw null;
    }

    public static void a(ChallengeHTMLView challengeHTMLView, Uri uri) {
        if (challengeHTMLView != null) {
            new Handler(challengeHTMLView.getMainLooper()).post(new Runnable() {
                public void run() {
                    ChallengeHTMLView.this.f2175a.stopLoading();
                }
            });
            if (!uri.toString().contains("data:text/html")) {
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                StringBuilder sb = new StringBuilder();
                try {
                    for (String next : queryParameterNames) {
                        if (!sb.toString().isEmpty()) {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode(next, StandardCharsets.UTF_8.toString()));
                        sb.append(InflateView.SETTER_EQUALS);
                        sb.append(URLEncoder.encode(uri.getQueryParameter(next), StandardCharsets.UTF_8.toString()));
                    }
                    char[] a2 = h.a(sb.toString());
                    com.cardinalcommerce.shared.cs.e.c cVar = new com.cardinalcommerce.shared.cs.e.c();
                    cVar.f2093c = a2;
                    challengeHTMLView.a(new a(challengeHTMLView.f2176b, cVar));
                } catch (UnsupportedEncodingException unused) {
                    com.cardinalcommerce.shared.cs.e.c cVar2 = new com.cardinalcommerce.shared.cs.e.c();
                    cVar2.f2091a = ThreeDSStrings.CHALLENGE_CANCEL_ERROR;
                    challengeHTMLView.a(new a(challengeHTMLView.f2176b, cVar2));
                }
            }
        } else {
            throw null;
        }
    }
}
