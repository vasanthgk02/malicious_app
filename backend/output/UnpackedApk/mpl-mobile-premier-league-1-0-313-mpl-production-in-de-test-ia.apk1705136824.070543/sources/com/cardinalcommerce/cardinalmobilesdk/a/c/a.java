package com.cardinalcommerce.cardinalmobilesdk.a.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.cardinalmobilesdk.a.d.b;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class a extends AsyncTask<Void, Void, Void> {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public WebView f1864a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1865b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1866c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1867d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public final Context f1868e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f1869f;
    public final b g;

    public a(Context context, String str) {
        b a2 = b.a();
        this.g = a2;
        a2.a("CardinalProcessBin", "Bin profiling initialized", null);
        this.f1869f = new Handler(context.getMainLooper());
        this.f1865b = a(str);
        this.f1868e = context;
        this.f1869f.post(new Runnable() {
            @SuppressLint({"SetJavaScriptEnabled"})
            public void run() {
                a.this.f1864a = new WebView(a.this.f1868e);
                a.this.f1864a.getSettings().setJavaScriptEnabled(true);
                a.this.f1864a.getSettings().setDomStorageEnabled(true);
                a.this.f1864a.setWebViewClient(new WebViewClient() {
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        a.this.g.b(String.valueOf(10404), GeneratedOutlineSupport.outline41(str, i), null);
                    }

                    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        a.this.g.b(String.valueOf(10412), sslError.toString(), null);
                        sslErrorHandler.cancel();
                    }
                });
                a aVar = a.this;
                if (aVar.f1867d) {
                    byte[] bArr = aVar.f1866c;
                    if (bArr != null) {
                        aVar.f1864a.postUrl(aVar.f1865b, bArr);
                        return;
                    }
                }
                a aVar2 = a.this;
                aVar2.f1864a.loadUrl(aVar2.f1865b);
            }
        });
    }

    public final String a(String str) {
        try {
            URI uri = new URI(str);
            String str2 = "origin=" + URLEncoder.encode("CardinalMobileSdk_Android", "UTF-8");
            if (uri.getQuery() != null) {
                str2 = r9 + "&" + str2;
            }
            URI uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str2, uri.getFragment());
            return uri2.toString();
        } catch (UnsupportedEncodingException | URISyntaxException e2) {
            b bVar = this.g;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported Encoding Exception \n");
            outline73.append(e2.getLocalizedMessage());
            bVar.b("CardinalProcessBin", outline73.toString(), null);
            return "";
        }
    }

    public Object doInBackground(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        return null;
    }
}
