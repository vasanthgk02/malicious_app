package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatWebViewListener;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.c.b;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.k.u;
import com.freshchat.consumer.sdk.service.Status;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.paynimo.android.payment.util.Constant;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class FAQDetailsActivity extends ah<u> implements b {
    public final WebViewClient C = new as(this);
    public final OnClickListener D = new ar(this);
    public final OnClickListener ac = new aq(this);
    public View n;
    public c pH;
    public boolean x = false;

    private void f(Bundle bundle) {
        if (((u) this.pe).i(bundle)) {
            Toast.makeText(getContext(), R.string.freshchat_faq_vote_successful, 1).show();
        }
    }

    private void hH() {
        a(((u) this.pe).jv());
    }

    private void hc() {
        a(false, this.ac);
        ((TextView) findViewById(R.id.freshchat_contact_us_btn)).setText(R.string.freshchat_faq_not_helpful_contact_us);
    }

    private void iE() {
        if (((u) this.pe).jB()) {
            m();
        }
    }

    /* access modifiers changed from: private */
    public void iF() {
        n();
        if (((u) this.pe).shouldShowContactUsOnFaqNotHelpful()) {
            hc();
        }
    }

    private void iG() {
        Toast.makeText(this, R.string.freshchat_faq_failed_to_load, 0).show();
        finish();
    }

    private void m() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_up);
        this.n.bringToFront();
        this.n.startAnimation(loadAnimation);
        i.b(this.n);
    }

    /* access modifiers changed from: private */
    public void n() {
        if (i.f(this.n)) {
            this.n.startAnimation(AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_down));
            i.c(this.n);
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

    private void s() {
        this.pH.postDelayed(new au(this), 500);
    }

    public void a(Context context, Intent intent) {
        if ("com.freshchat.consumer.sdk.actions.FAQFetched".equals(intent.getAction())) {
            a(((u) this.pe).g(intent.getExtras()));
            if (((u) this.pe).jC()) {
                hc();
            }
        } else if (Constant.INTENT_NETWORK_STATUS.equals(intent.getAction())) {
            a(((u) this.pe).jm());
        } else if ("com.freshchat.consumer.sdk.actions.FAQVoted".equals(intent.getAction())) {
            f(intent.getExtras());
        }
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    public String dA() {
        return ((u) this.pe).jw();
    }

    public void dh() {
        T uVar = new u(getContext());
        this.pe = uVar;
        if (((u) uVar).h(getIntent().getExtras())) {
            ((u) this.pe).j(getIntent());
        } else {
            iG();
        }
    }

    public void h() {
        iE();
    }

    public void hP() {
        String jx = ((u) this.pe).jx();
        if (as.isEmpty(jx)) {
            a(Status.ERROR);
            return;
        }
        this.pH.loadDataWithBaseURL(null, jx, RNCWebViewManager.HTML_MIME_TYPE, WebViewGamesContainer.ENCODING_NAME, null);
        i(this.pH);
    }

    public String hV() {
        return ((u) this.pe).hV();
    }

    public void i() {
        n();
    }

    public void ie() {
        hH();
    }

    /* renamed from: if  reason: not valid java name */
    public View m87if() {
        return this.pH;
    }

    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.FAQFetched", "com.freshchat.consumer.sdk.actions.FAQVoted"};
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
        setContentView(R.layout.freshchat_activity_faq_details);
        u();
        ((u) this.pe).jy();
        if (bundle != null) {
            this.pH.restoreState(bundle);
        }
        hH();
        Locale bb2 = ah.bb(this);
        if (bb != null && bb2 != null && as.p(bb.getLanguage(), bb2.getLanguage())) {
            FreshchatWebViewListener webviewListener = Freshchat.getInstance(this).getWebviewListener();
            if (webviewListener != null) {
                webviewListener.onLocaleChangedByWebView(new WeakReference(this));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.pH;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.pH.az()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.pH.aA();
        return true;
    }

    public void onPause() {
        super.onPause();
        if (aw.fb() && aw.eS()) {
            this.pH.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        if (aw.fb() && aw.eS()) {
            this.pH.onResume();
        }
    }

    public void onStart() {
        super.onStart();
        if (aw.fc()) {
            this.pH.onResume();
        }
    }

    public void onStop() {
        super.onStop();
        if (aw.fc()) {
            this.pH.onPause();
        }
        this.pH.stopLoading();
    }

    public void u() {
        super.u();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(10, -1);
        c cVar = new c(this);
        this.pH = cVar;
        cVar.setVisibility(8);
        this.pH.setWebViewClient(this.C);
        this.pH.a((b) this, 85);
        this.n = findViewById(R.id.freshchat_voting_view);
        View findViewById = findViewById(R.id.freshchat_upvote);
        View findViewById2 = findViewById(R.id.freshchat_downvote);
        findViewById.setOnClickListener(this.D);
        findViewById2.setOnClickListener(this.D);
        ((RelativeLayout) findViewById(R.id.freshchat_solution_article_root_layout)).addView(this.pH.getLayout(), layoutParams);
    }
}
