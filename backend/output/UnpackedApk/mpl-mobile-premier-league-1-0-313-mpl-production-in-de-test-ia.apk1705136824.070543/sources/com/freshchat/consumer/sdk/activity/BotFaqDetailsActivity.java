package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.c.b;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.k.y;
import com.freshchat.consumer.sdk.service.Status;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.paynimo.android.payment.util.Constant;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Collection;
import java.util.List;

public class BotFaqDetailsActivity extends ah<y> implements b {
    public final WebViewClient C = new bi(this);
    public TextView iB;
    public TextView ji;
    public View n;
    public c pH;
    public boolean x = false;

    /* access modifiers changed from: private */
    public void a(CallbackButtonFragment callbackButtonFragment) {
        ((y) this.pe).c(callbackButtonFragment);
        i.a(getContext(), R.string.freshchat_bot_faq_feedback_success);
        finish();
    }

    private void hH() {
        a(((y) this.pe).jv());
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

    private void n() {
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
        this.pH.postDelayed(new bk(this), 500);
    }

    public void a(Context context, Intent intent) {
        Status jm;
        if ("com.freshchat.consumer.sdk.actions.BotFAQFetched".equals(intent.getAction())) {
            jm = ((y) this.pe).g(intent.getExtras());
        } else if (Constant.INTENT_NETWORK_STATUS.equals(intent.getAction())) {
            jm = ((y) this.pe).jm();
        } else {
            return;
        }
        a(jm);
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout"};
    }

    public String dA() {
        return ((y) this.pe).jw();
    }

    public void dh() {
        T yVar = new y(getContext());
        this.pe = yVar;
        if (((y) yVar).h(getIntent().getExtras())) {
            ((y) this.pe).j(getIntent());
        } else {
            iG();
        }
    }

    public void h() {
        m();
    }

    public void hP() {
        String jx = ((y) this.pe).jx();
        if (as.isEmpty(jx)) {
            a(Status.ERROR);
        } else {
            this.pH.loadDataWithBaseURL(null, jx, RNCWebViewManager.HTML_MIME_TYPE, WebViewGamesContainer.ENCODING_NAME, null);
            i(this.pH);
        }
        List<MessageFragment> callbacks = ((y) this.pe).getCallbacks();
        if (k.a(callbacks)) {
            CallbackButtonFragment callbackButtonFragment = (CallbackButtonFragment) callbacks.get(0);
            this.iB.setText(callbackButtonFragment.getLabel());
            this.iB.setOnClickListener(new bg(this, callbackButtonFragment));
            if (k.b((Collection<?>) callbacks) > 1) {
                CallbackButtonFragment callbackButtonFragment2 = (CallbackButtonFragment) callbacks.get(1);
                this.ji.setText(callbackButtonFragment2.getLabel());
                this.ji.setOnClickListener(new bh(this, callbackButtonFragment2));
                return;
            }
            i.c(this.ji);
        }
    }

    public String hV() {
        return ((y) this.pe).hV();
    }

    public void i() {
        n();
    }

    public void ie() {
        hH();
    }

    /* renamed from: if  reason: not valid java name */
    public View m85if() {
        return this.pH;
    }

    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.BotFAQFetched"};
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
        setContentView(R.layout.freshchat_activity_bot_faq_details);
        u();
        if (bundle != null) {
            this.pH.restoreState(bundle);
        }
        ((y) this.pe).kc();
        hH();
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
        this.iB = (TextView) findViewById(R.id.freshchat_downvote);
        this.ji = (TextView) findViewById(R.id.freshchat_upvote);
        ((RelativeLayout) findViewById(R.id.freshchat_bot_faq_root_layout)).addView(this.pH.getLayout(), layoutParams);
    }
}
