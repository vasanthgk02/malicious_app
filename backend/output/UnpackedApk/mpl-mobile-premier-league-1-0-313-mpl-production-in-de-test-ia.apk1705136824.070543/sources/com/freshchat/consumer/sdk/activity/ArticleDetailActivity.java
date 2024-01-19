package com.freshchat.consumer.sdk.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.Loader;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatWebViewListener;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.c.b;
import com.freshchat.consumer.sdk.b.j;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.e.f;
import com.freshchat.consumer.sdk.service.e.n.a;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.regex.Pattern;

public class ArticleDetailActivity extends b implements LoaderCallbacks<Article>, b {
    public static String l = "isArticleVoted";
    public static String s = "HL_ARTICLE_TITLE";
    public static final String t = GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_res/raw/normalize.css\"/><script src='file:///freshchat_assets/freshchat_hacks.js'></script><title>"), s, "</title></head>");
    public static final String u = GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("<!DOCTYPE html>\t<html>"), t, "<body onload='correctIframe()'> <bdi>");
    public static String z;
    public String A = "article_list";
    public boolean B = false;
    public WebViewClient C = new v(this);
    public OnClickListener D = new x(this);
    public OnClickListener E = new aa(this);
    public String categoryId;
    public String categoryName;
    public FaqOptions g = new FaqOptions();
    public Bundle h = null;
    public View i;
    public View j;
    public c k;
    public String[] lE;
    public RelativeLayout m;
    public View n;
    public View o;
    public View p;
    public View q;
    public j r;
    public String title;
    public String v;
    public boolean w;
    public boolean x = false;
    public boolean y;

    private String a(Article article) {
        String str;
        if (article == null) {
            return null;
        }
        this.categoryId = article.getCategoryId();
        StringBuilder sb = new StringBuilder();
        String replaceAll = article.getDescription().replaceAll("src=\"//", "src=\"http://").replaceAll("value=\"//", "value=\"http://");
        Pattern compile = Pattern.compile("<\\s*(img|iframe).*?src\\s*=[ '\"]+http[s]?:\\/\\/.*?>");
        if (al.aS(this) || !compile.matcher(replaceAll).find()) {
            str = "";
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("<div class='offline-article-message'>");
            outline73.append(getString(R.string.freshchat_faq_rich_media_content_cannot_be_displayed));
            outline73.append("</div>");
            str = outline73.toString();
        }
        this.title = article.getTitle();
        sb.append(u);
        sb.append("<div class=\"article-title\";><h3 >");
        GeneratedOutlineSupport.outline103(sb, this.title, "</h3></div>", str, "<div class=\"article-body\">");
        String outline63 = GeneratedOutlineSupport.outline63(sb, replaceAll, "</div>", "</bdi></body></html>");
        if (!as.isEmpty(this.categoryName)) {
            outline63 = outline63.replace(s, this.categoryName);
        }
        return outline63;
    }

    private void a(Intent intent) {
        if (!intent.hasExtra("article_id")) {
            Toast.makeText(this, R.string.freshchat_faq_failed_to_load, 0).show();
            finish();
        }
        long longExtra = intent.getLongExtra("article_id", -1);
        if (longExtra > 0) {
            this.v = Long.toString(longExtra);
        } else {
            Toast.makeText(this, R.string.freshchat_faq_failed_to_load, 0).show();
            finish();
        }
        if (intent.hasExtra("category_id")) {
            this.categoryId = intent.getStringExtra("category_id");
        }
        if (intent.hasExtra("category_name")) {
            this.categoryName = intent.getStringExtra("category_name");
        }
        if (intent.hasExtra("EVENT_LAUNCH_SOURCE")) {
            this.A = intent.getStringExtra("EVENT_LAUNCH_SOURCE");
        }
        if (intent.hasExtra("LAUNCHED_FROM_CONVERSATION")) {
            this.y = intent.getBooleanExtra("LAUNCHED_FROM_CONVERSATION", false);
        }
        this.lE = intent.getStringArrayExtra("INPUT_TAGS");
    }

    private void a(Bundle bundle) {
        this.w = bundle != null ? bundle.getBoolean(l) : false;
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        bg.a(getContext(), this.categoryId, this.categoryName, this.v, this.title, aVar == a.Upvote);
        new com.freshchat.consumer.sdk.service.d.b(getApplicationContext(), aVar == a.Upvote ? com.freshchat.consumer.sdk.service.d.b.a.faq_upvote_article : com.freshchat.consumer.sdk.service.d.b.a.faq_downvote_article).g("article_id", this.v).g("category_id", this.categoryId).g("article_name", this.title).dB();
    }

    private void b() {
        bg.a(getContext(), this.categoryId, this.categoryName, this.v, this.title, this.lE);
        if (!this.B) {
            new com.freshchat.consumer.sdk.service.d.b(getApplicationContext(), com.freshchat.consumer.sdk.service.d.b.a.faq_open_article).g("category_id", this.categoryId).g("category_name", this.categoryName).g("article_id", this.v).g("article_name", this.title).g(DefaultSettingsSpiCall.SOURCE_PARAM, this.A).dB();
            this.B = true;
        }
    }

    private void c() {
        this.p = findViewById(R.id.freshchat_upvote);
        this.q = findViewById(R.id.freshchat_downvote);
        this.n = findViewById(R.id.freshchat_voting_view);
        this.o = findViewById(R.id.freshchat_contact_us_group);
        this.m = (RelativeLayout) findViewById(R.id.freshchat_solution_article_root_layout);
        ((TextView) findViewById(R.id.freshchat_contact_us_btn)).setText(R.string.freshchat_faq_not_helpful_contact_us);
    }

    private void d() {
        Bundle bundle = new Bundle();
        bundle.putString("article_id", this.v);
        if (as.isEmpty(this.categoryName)) {
            bundle.putBoolean("EXTRA_FETCH_CATEGORY_INFO", true);
        }
        getSupportLoaderManager().initLoader(0, bundle, this);
    }

    private void e() {
        this.p.setOnClickListener(this.D);
        this.q.setOnClickListener(this.D);
        this.o.setOnClickListener(this.E);
    }

    private void f() {
        int i2;
        View view;
        if (!this.g.shouldShowContactUsOnFaqNotHelpful() || !this.w || !g().bj(this.v)) {
            view = this.o;
            i2 = 8;
        } else {
            this.o.bringToFront();
            view = this.o;
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public void l() {
        new com.freshchat.consumer.sdk.service.d.b(getApplicationContext(), com.freshchat.consumer.sdk.service.d.b.a.channels_launch).g(DefaultSettingsSpiCall.SOURCE_PARAM, "article_not_helpful").g("article_id", this.v).g("category_id", this.categoryId).dB();
    }

    private void m() {
        if (!this.w) {
            String str = z;
            if (str == null || !str.equals(this.v)) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_up);
                this.n.bringToFront();
                this.n.startAnimation(loadAnimation);
                this.n.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        if (!this.w) {
            this.n.startAnimation(AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_down));
            this.n.setVisibility(8);
        }
    }

    private void o() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void q() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }
    }

    /* access modifiers changed from: private */
    public v r() {
        return aa.a(getContext(), this.g);
    }

    private void s() {
        this.k.postDelayed(new ab(this), 500);
    }

    public void a(Context context, Intent intent) {
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<Article> loader, Article article) {
        String a2 = a(article);
        if (as.a(a2)) {
            if (loader instanceof com.freshchat.consumer.sdk.g.j) {
                Category dk = ((com.freshchat.consumer.sdk.g.j) loader).dk();
                if (dk != null) {
                    String title2 = dk.getTitle();
                    this.categoryName = title2;
                    a2 = a2.replace(s, title2);
                }
            }
            this.k.loadDataWithBaseURL(null, a2, RNCWebViewManager.HTML_MIME_TYPE, WebViewGamesContainer.ENCODING_NAME, null);
        }
        b();
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    public j g() {
        if (this.r == null) {
            this.r = new j(this);
        }
        return this.r;
    }

    public void h() {
        m();
    }

    public void i() {
        n();
    }

    public void j() {
        o();
        this.x = true;
        this.n.setVisibility(8);
    }

    public void k() {
        q();
        s();
        this.x = false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.x) {
            s();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Locale bb = ah.bb(this);
        a(bundle);
        Intent intent = getIntent();
        a(intent);
        Bundle extras = intent.getExtras();
        this.h = extras;
        this.g = u.d(extras);
        d();
        setContentView(R.layout.freshchat_activity_article_detail);
        C();
        e(!as.isEmpty(this.g.getFilteredViewTitle()) ? this.g.getFilteredViewTitle() : as.isEmpty(this.categoryName) ? getString(R.string.freshchat_activity_title_article_detail) : this.categoryName);
        c();
        com.freshchat.consumer.sdk.j.b.a(getApplicationContext(), f.a.NORMAL);
        e();
        this.w = g().P(this.v);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.addRule(10, -1);
        this.j = LayoutInflater.from(this).inflate(R.layout.freshchat_partial_article_progress, null);
        c cVar = new c(this);
        this.k = cVar;
        cVar.setWebViewClient(this.C);
        this.k.a((b) this, 85);
        this.m.addView(this.k.getLayout(), layoutParams2);
        this.m.addView(this.j, layoutParams);
        if (bundle != null) {
            this.k.restoreState(bundle);
        }
        this.i = this.k;
        Locale bb2 = ah.bb(this);
        if (bb != null && bb2 != null && as.p(bb.getLanguage(), bb2.getLanguage())) {
            FreshchatWebViewListener webviewListener = Freshchat.getInstance(this).getWebviewListener();
            if (webviewListener != null) {
                webviewListener.onLocaleChangedByWebView(new WeakReference(this));
            }
        }
    }

    public Loader<Article> onCreateLoader(int i2, Bundle bundle) {
        return new com.freshchat.consumer.sdk.g.j(getApplicationContext(), bundle.getString("article_id"), bundle.containsKey("EXTRA_FETCH_CATEGORY_INFO"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_article_detail_list, menu);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.k;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.k.az()) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.k.aA();
        return true;
    }

    public void onLoaderReset(Loader<Article> loader) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @TargetApi(11)
    public void onPause() {
        super.onPause();
        if (aw.fb() && aw.eS()) {
            this.k.onPause();
        } else if (aw.eM()) {
            this.k.aB();
        }
    }

    @TargetApi(11)
    public void onResume() {
        super.onResume();
        this.w = g().P(this.v);
        f();
        if (aw.fb() && aw.eS()) {
            this.k.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(l, this.w);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        if (aw.fc()) {
            this.k.onResume();
        }
    }

    public void onStop() {
        super.onStop();
        if (aw.fc()) {
            this.k.onPause();
        }
        this.k.stopLoading();
    }
}
