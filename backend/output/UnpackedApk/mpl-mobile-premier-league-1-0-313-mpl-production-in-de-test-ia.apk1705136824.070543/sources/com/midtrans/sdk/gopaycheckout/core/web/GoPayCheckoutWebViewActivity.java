package com.midtrans.sdk.gopaycheckout.core.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.inca.security.Proxy.iIiIiIiIii;
import com.midtrans.sdk.gopaycheckout.R;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutProcessor;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0003J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/web/GoPayCheckoutWebViewActivity;", "Landroid/app/Activity;", "()V", "callbackUrl", "", "getCallbackUrl", "()Ljava/lang/String;", "callbackUrl$delegate", "Lkotlin/Lazy;", "url", "getUrl", "url$delegate", "checkCallbackUrl", "", "complete", "", "initToolbar", "initWebPage", "invokeCallback", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutWebViewActivity extends Activity {
    public static final String CALLBACK_URL = "com.midtrans.gopaycheckout.web.callback.url";
    public static final Companion Companion = new Companion(null);
    public static final String URL = "com.midtrans.gopaycheckout.web.url";
    public HashMap _$_findViewCache;
    public final Lazy callbackUrl$delegate = TweetUtils.lazy((Function0<? extends T>) new GoPayCheckoutWebViewActivity$callbackUrl$2<Object>(this));
    public final Lazy url$delegate = TweetUtils.lazy((Function0<? extends T>) new GoPayCheckoutWebViewActivity$url$2<Object>(this));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/web/GoPayCheckoutWebViewActivity$Companion;", "", "()V", "CALLBACK_URL", "", "URL", "intent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "url", "callbackUrl", "intent$gopay_checkout_release", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent intent$gopay_checkout_release(Activity activity, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(str, "url");
            Intrinsics.checkParameterIsNotNull(str2, "callbackUrl");
            Intent intent = new Intent(activity, GoPayCheckoutWebViewActivity.class);
            intent.putExtra(GoPayCheckoutWebViewActivity.URL, str);
            intent.putExtra(GoPayCheckoutWebViewActivity.CALLBACK_URL, str2);
            return intent;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: 0000 */
    public final boolean checkCallbackUrl(String str) {
        if (!CharsKt__CharKt.contains(str, getCallbackUrl(), true)) {
            return false;
        }
        complete();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final void complete() {
        invokeCallback();
        finish();
    }

    /* access modifiers changed from: 0000 */
    public final String getCallbackUrl() {
        return (String) this.callbackUrl$delegate.getValue();
    }

    /* access modifiers changed from: 0000 */
    public final String getUrl() {
        return (String) this.url$delegate.getValue();
    }

    /* access modifiers changed from: 0000 */
    public final void initToolbar() {
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setTitle(R.string.com_midtrans_gopaycheckout_webview_title);
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.com_midtrans_gopaycheckout_ic_close_back));
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationOnClickListener(new GoPayCheckoutWebViewActivity$initToolbar$1(this));
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void initWebPage() {
        if (getUrl().length() == 0) {
            invokeCallback();
            return;
        }
        WebView webView = (WebView) _$_findCachedViewById(R.id.webview);
        webView.setWebViewClient(new GoPayCheckoutWebViewClient(new GoPayCheckoutWebViewActivity$initWebPage$$inlined$apply$lambda$1(this)));
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "settings");
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, "settings");
        settings2.setDomStorageEnabled(true);
        WebSettings settings3 = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings3, "settings");
        settings3.setJavaScriptCanOpenWindowsAutomatically(false);
        ((WebView) _$_findCachedViewById(R.id.webview)).loadUrl(getUrl());
    }

    /* access modifiers changed from: 0000 */
    public final void invokeCallback() {
        GoPayCheckoutProcessor.Companion.getInstance().getCallback$gopay_checkout_release().onCompleted();
        GoPayCheckoutProcessor.Companion.getInstance().clearCallback$gopay_checkout_release();
    }

    public void onBackPressed() {
        if (((WebView) _$_findCachedViewById(R.id.webview)).canGoBack()) {
            ((WebView) _$_findCachedViewById(R.id.webview)).goBack();
            return;
        }
        invokeCallback();
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1520302691, bundle);
    }
}
