package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.b.a;
import com.freshchat.consumer.sdk.a.q;
import com.freshchat.consumer.sdk.beans.FAQCategory;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.k.t;
import com.freshchat.consumer.sdk.service.Status;
import com.inca.security.Proxy.iIiIiIiIii;
import com.paynimo.android.payment.util.Constant;

public class FAQCategoriesActivity extends ah<t> {
    public OnClickListener ac = new am(this);
    public a aj = new al(this);
    public RecyclerView pj;
    public q<FAQCategory> pk;
    public e po = new an(this);

    public void U(int i) {
        super.U(i);
        if (((t) this.pe).shouldShowFaqCategoriesAsGrid()) {
            this.pj.setLayoutManager(iB());
            this.pk.notifyDataSetChanged();
        }
    }

    public void a(Context context, Intent intent) {
        Status jm;
        if ("com.freshchat.consumer.sdk.actions.FAQCategoriesFetched".equals(intent.getAction())) {
            jm = ((t) this.pe).g(intent.getExtras());
        } else if (Constant.INTENT_NETWORK_STATUS.equals(intent.getAction())) {
            jm = ((t) this.pe).jm();
        } else {
            return;
        }
        a(jm);
    }

    public void a(Status status) {
        if (status != null) {
            if (((t) this.pe).b(status)) {
                super.a(status);
            } else {
                this.pk.setStatus(status);
            }
        }
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    public String dA() {
        return ((t) this.pe).getTitle();
    }

    public void dh() {
        T tVar = new t(getContext());
        this.pe = tVar;
        ((t) tVar).j(getIntent());
    }

    public void hP() {
        this.pk.setStatus(Status.SUCCESS);
        i(this.pj);
    }

    public String hV() {
        return ((t) this.pe).ju();
    }

    /* access modifiers changed from: 0000 */
    public LayoutManager iA() {
        return ((t) this.pe).shouldShowFaqCategoriesAsGrid() ? iB() : new LinearLayoutManager(getContext());
    }

    /* access modifiers changed from: 0000 */
    public GridLayoutManager iB() {
        int a2 = ((t) this.pe).a(getWindowManager());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), a2);
        gridLayoutManager.mSpanSizeLookup = new ap(this, a2);
        return gridLayoutManager;
    }

    public void ie() {
        s(false);
    }

    /* renamed from: if  reason: not valid java name */
    public View m86if() {
        return this.pj;
    }

    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.FAQCategoriesFetched"};
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -810170711, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_faq, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_contact_us);
        boolean z = ((t) this.pe).shouldShowContactUsOnFaqScreens() && ((t) this.pe).shouldShowContactUsOnAppBar();
        if (findItem != null) {
            findItem.setVisible(z);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((t) this.pe).jg();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void s(boolean z) {
        a(((t) this.pe).B(z));
    }

    public void u() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.freshchat_activity_category_list_recycler_view);
        this.pj = recyclerView;
        recyclerView.setLayoutManager(iA());
        this.pj.addOnScrollListener(new ao(this));
        q qVar = new q(getContext(), ((t) this.pe).jt(), ((t) this.pe).shouldShowFaqCategoriesAsGrid(), this.aj, this.po);
        this.pk = qVar;
        this.pj.setAdapter(qVar);
        super.u();
        if (((t) this.pe).shouldShowContactUsOnFaqScreens()) {
            a(((t) this.pe).shouldShowContactUsOnAppBar(), this.ac);
        }
    }
}
