package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.s;
import com.freshchat.consumer.sdk.a.s.b;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.w;
import com.freshchat.consumer.sdk.service.Status;
import com.inca.security.Proxy.iIiIiIiIii;
import com.paynimo.android.payment.util.Constant;

public class FAQSearchActivity extends ah<w> {
    public final OnClickListener ac = new bf(this);
    public final OnQueryTextListener ad = new bd(this);
    public RecyclerView pT;
    public e po = new bb(this);
    public final OnActionExpandListener qK = new be(this);
    public s ql;
    public final b qm = new ba(this);
    public View qo;
    public TextView qp;
    public boolean rE = false;

    public void A(boolean z) {
        String hV = z ? hV() : getString(R.string.freshchat_minimum_search_criteria);
        h(this.qo);
        this.qp.setText(hV);
    }

    public void V(int i) {
        try {
            if (k.a(((w) this.pe).iV())) {
                Intent ac2 = ((w) this.pe).ac(i);
                if (ac2 != null) {
                    startActivity(ac2);
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public void a(Context context, Intent intent) {
        Status jm;
        if ("com.freshchat.consumer.sdk.actions.FAQSearchResultFetched".equals(intent.getAction())) {
            jm = ((w) this.pe).g(intent.getExtras());
        } else if (Constant.INTENT_NETWORK_STATUS.equals(intent.getAction())) {
            jm = ((w) this.pe).jm();
        } else {
            return;
        }
        a(jm);
    }

    public void a(Status status) {
        if (status != null) {
            if (((w) this.pe).b(status)) {
                super.a(status);
            } else {
                this.ql.setStatus(status);
            }
        }
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    public void bv(String str) {
        if (this.rE) {
            A(true);
            return;
        }
        i.c(this.qo);
        super.bv(str);
    }

    /* access modifiers changed from: 0000 */
    public void bw(String str) {
        if (!((w) this.pe).bB(str)) {
            if (((w) this.pe).bA(str)) {
                ((w) this.pe).jJ();
                this.pT.setAdapter(this.ql);
                a(((w) this.pe).jH());
                i.c(this.qo);
            } else {
                A(false);
            }
        }
    }

    public String dA() {
        return "";
    }

    public void dh() {
        T wVar = new w(getContext());
        this.pe = wVar;
        ((w) wVar).j(getIntent());
    }

    public void hP() {
        i.c(this.qo);
        this.ql.setStatus(Status.SUCCESS);
        i(this.pT);
    }

    public String hV() {
        return getString(R.string.freshchat_no_articles_found);
    }

    public void ie() {
        s(false);
    }

    /* renamed from: if  reason: not valid java name */
    public View m89if() {
        return this.pT;
    }

    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.FAQSearchResultFetched"};
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 4211494, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_articles_list, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_contact_us);
        MenuItem findItem2 = menu.findItem(R.id.freshchat_menu_item_search_solutions);
        SearchView searchView = (SearchView) findItem2.getActionView();
        searchView.setOnQueryTextListener(this.ad);
        searchView.setQueryHint(getString(R.string.freshchat_faq_search_query_hint));
        searchView.setOnQueryTextFocusChangeListener(new bc(this));
        findItem2.setOnActionExpandListener(this.qK);
        findItem2.expandActionView();
        i.a(searchView, getSupportActionBar());
        boolean z = ((w) this.pe).shouldShowContactUsOnFaqScreens() && ((w) this.pe).shouldShowContactUsOnAppBar();
        if (findItem != null) {
            findItem.setVisible(z);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_categories_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((w) this.pe).jg();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void s(boolean z) {
        a(((w) this.pe).B(z));
    }

    public void u() {
        super.u();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_faq_recycler_view);
        this.pT = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        s sVar = new s(((w) this.pe).iV(), this.qm, this.po);
        this.ql = sVar;
        this.pT.setAdapter(sVar);
        this.pT.addOnScrollListener(new az(this));
        this.qo = findViewById(R.id.search_description_view);
        this.qp = (TextView) findViewById(R.id.search_description);
        if (((w) this.pe).shouldShowContactUsOnFaqScreens()) {
            a(((w) this.pe).shouldShowContactUsOnAppBar(), this.ac);
        }
        A(false);
    }
}
