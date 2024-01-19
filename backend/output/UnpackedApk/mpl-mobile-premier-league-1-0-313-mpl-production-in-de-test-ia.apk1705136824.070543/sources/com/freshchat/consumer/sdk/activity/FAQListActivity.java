package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.s;
import com.freshchat.consumer.sdk.a.s.b;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.v;
import com.freshchat.consumer.sdk.service.Status;
import com.inca.security.Proxy.iIiIiIiIii;
import com.paynimo.android.payment.util.Constant;

public class FAQListActivity extends ah<v> {
    public final OnClickListener ac = new aw(this);
    public RecyclerView pT;
    public e po = new ay(this);
    public s ql;
    public final b qm = new ax(this);

    public void V(int i) {
        try {
            if (k.a(((v) this.pe).iV())) {
                FAQ faq = ((v) this.pe).iV().get(i);
                startActivity(((v) this.pe).y(faq.getId(), faq.getTitle()));
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public void a(Context context, Intent intent) {
        Status jm;
        if ("com.freshchat.consumer.sdk.actions.FAQListFetched".equals(intent.getAction())) {
            jm = ((v) this.pe).g(intent.getExtras());
        } else if (Constant.INTENT_NETWORK_STATUS.equals(intent.getAction())) {
            jm = ((v) this.pe).jm();
        } else {
            return;
        }
        a(jm);
    }

    public void a(Status status) {
        if (status != null) {
            if (((v) this.pe).b(status)) {
                super.a(status);
            } else {
                this.ql.setStatus(status);
            }
        }
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    public String dA() {
        return ((v) this.pe).jE();
    }

    public void dh() {
        T vVar = new v(getContext());
        this.pe = vVar;
        ((v) vVar).j(getIntent());
    }

    public void hP() {
        this.ql.setStatus(Status.SUCCESS);
        i(this.pT);
    }

    public String hV() {
        return ((v) this.pe).jF();
    }

    public void ie() {
        s(false);
    }

    /* renamed from: if  reason: not valid java name */
    public View m88if() {
        return this.pT;
    }

    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.FAQListFetched"};
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1812847350, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_faq, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_contact_us);
        boolean z = ((v) this.pe).shouldShowContactUsOnFaqScreens() && ((v) this.pe).shouldShowContactUsOnAppBar();
        if (findItem != null) {
            findItem.setVisible(z);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((v) this.pe).jg();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void s(boolean z) {
        a(((v) this.pe).B(z));
    }

    public void u() {
        super.u();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        this.pT = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.pT.addOnScrollListener(new av(this));
        s sVar = new s(((v) this.pe).iV(), this.qm, this.po);
        this.ql = sVar;
        this.pT.setAdapter(sVar);
        if (((v) this.pe).shouldShowContactUsOnFaqScreens()) {
            a(((v) this.pe).shouldShowContactUsOnAppBar(), this.ac);
        }
    }
}
