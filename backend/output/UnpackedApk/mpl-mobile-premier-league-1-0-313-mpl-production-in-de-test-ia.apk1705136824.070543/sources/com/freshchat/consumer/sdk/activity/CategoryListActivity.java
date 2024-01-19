package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ProgressBar;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.g.f;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.be;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.d.b;
import com.freshchat.consumer.sdk.service.d.b.a;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.net.ftp.FTPReply;

public class CategoryListActivity extends b {
    public String M;
    public View Q;
    public View S;
    public OnClickListener ac = new OnClickListener() {
        public void onClick(View view) {
            CategoryListActivity.this.r().aE();
            new b(CategoryListActivity.this.getApplicationContext(), a.channels_launch).g(DefaultSettingsSpiCall.SOURCE_PARAM, "contact_us").dB();
        }
    };
    public RecyclerView af;
    public com.freshchat.consumer.sdk.a.b<Category> ag;
    public List<Category> ah = new ArrayList();
    public boolean ai;
    public com.freshchat.consumer.sdk.a.b.a aj = new com.freshchat.consumer.sdk.a.b.a() {
        public void a(View view, int i) {
            Category category = (Category) CategoryListActivity.this.ah.get(i);
            CategoryListActivity.this.r().a(category.getId(), category.getTitle(), CategoryListActivity.this.lE);
        }
    };
    public LoaderCallbacks<List<Category>> ak = new LoaderCallbacks<List<Category>>() {
        /* renamed from: a */
        public void onLoadFinished(Loader<List<Category>> loader, List<Category> list) {
            if (!CategoryListActivity.this.ai || k.b((Collection<?>) list) != 0) {
                CategoryListActivity.this.ah.clear();
                CategoryListActivity.this.ah.addAll(list);
                CategoryListActivity.this.x();
                CategoryListActivity.this.B().setAdapter(CategoryListActivity.this.ag);
                return;
            }
            CategoryListActivity.this.finish();
            i.a(CategoryListActivity.this.getContext(), R.string.freshchat_faqs_reload_and_redirect);
            Freshchat.showFAQs(CategoryListActivity.this.getContext(), CategoryListActivity.this.g);
        }

        public Loader<List<Category>> onCreateLoader(int i, Bundle bundle) {
            return (bundle == null || !k.a(bundle.getStringArrayList("TAGS"))) ? new f(CategoryListActivity.this.getApplicationContext()) : new f(CategoryListActivity.this.getApplicationContext(), bundle.getStringArrayList("TAGS"));
        }

        public void onLoaderReset(Loader<List<Category>> loader) {
            CategoryListActivity.this.ah.clear();
            CategoryListActivity.this.ag.notifyDataSetChanged();
        }
    };
    public ProgressBar am;
    public FaqOptions g = new FaqOptions();
    public String[] lE;
    public LayoutManager mLayoutManager;

    /* access modifiers changed from: 0000 */
    public void A() {
        i.c(this.am);
    }

    public RecyclerView B() {
        if (this.af == null) {
            this.af = (RecyclerView) findViewById(R.id.freshchat_activity_category_list_recycler_view);
        }
        return this.af;
    }

    /* access modifiers changed from: 0000 */
    public void E() {
        Bundle bundle = new Bundle();
        if (this.ai) {
            bundle.putStringArrayList("TAGS", new ArrayList(this.g.getTags()));
        }
        getSupportLoaderManager().restartLoader(0, bundle, this.ak);
    }

    public void a(Context context, Intent intent) {
        if ("com.freshchat.consumer.sdk.actions.SolutionsUpdated".equals(intent.getAction())) {
            E();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Intent intent) {
        if (intent != null) {
            FaqOptions d2 = u.d(intent.getExtras());
            this.g = d2;
            this.M = as.a(d2.getFilteredViewTitle()) ? this.g.getFilteredViewTitle() : getString(R.string.freshchat_activity_title_category_list);
            if (k.a(this.g.getTags())) {
                this.ai = true;
            }
            this.lE = intent.getStringArrayExtra("INPUT_TAGS");
        }
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.SolutionsUpdated", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<String> e(List<Category> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (k.isEmpty(list)) {
            return arrayList;
        }
        for (Category id : list) {
            arrayList.add(id.getId());
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void eA() {
        A();
        i.c(B());
        i.b(getEmptyView());
    }

    /* access modifiers changed from: 0000 */
    public void ez() {
        z();
        i.c(B());
        i.c(getEmptyView());
        boolean aS = al.aS(getContext());
        boolean isEmpty = as.isEmpty(e.i(getApplicationContext()).br());
        if (!aS && isEmpty) {
            eA();
            i.a(getContext(), R.string.freshchat_error_message_not_connected_to_internet);
        }
        if (!isEmpty) {
            E();
        }
    }

    /* access modifiers changed from: 0000 */
    public void gD() {
        be.eC().gx().execute(new j(this));
    }

    /* access modifiers changed from: 0000 */
    public int getColumnCount() {
        return Math.round((float) (af.i(this, p.ar(this)) / (p.a(getApplicationContext(), getWindowManager()) ? 200 : FTPReply.FILE_STATUS_OK)));
    }

    /* access modifiers changed from: 0000 */
    public View getEmptyView() {
        if (this.Q == null) {
            this.Q = findViewById(R.id.empty);
        }
        return this.Q;
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1145950967, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_categories_list, menu);
        menu.findItem(R.id.freshchat_categories_menu_item_contact_us).setVisible(this.g.shouldShowContactUsOnFaqScreens() && this.g.shouldShowContactUsOnAppBar());
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.freshchat_categories_menu_item_search_solutions) {
            if (this.ai) {
                gD();
            } else {
                r().e(this.lE);
            }
            new b(getApplicationContext(), a.faq_search_launch).g(DefaultSettingsSpiCall.SOURCE_PARAM, "category_list").dB();
            return true;
        } else if (menuItem.getItemId() != R.id.freshchat_categories_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            r().aE();
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public v r() {
        return aa.a(getContext(), this.g);
    }

    /* access modifiers changed from: 0000 */
    public void u() {
        if (this.g.shouldShowContactUsOnFaqScreens()) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.freshchat_contact_us_stub);
            viewStub.setInflatedId(R.id.freshchat_contact_us_group);
            viewStub.setLayoutResource(R.layout.freshchat_partial_start_conversation_frame);
            this.am = (ProgressBar) findViewById(R.id.freshchat_activity_category_list_progressbar);
            if (!this.g.shouldShowContactUsOnAppBar()) {
                View inflate = viewStub.inflate();
                this.S = inflate;
                if (inflate != null) {
                    View findViewById = inflate.findViewById(R.id.freshchat_contact_us_btn);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(this.ac);
                    }
                }
            }
        }
        this.mLayoutManager = this.g.shouldShowFaqCategoriesAsGrid() ? new GridLayoutManager(this, getColumnCount()) : new LinearLayoutManager(this);
        B().setLayoutManager(this.mLayoutManager);
        this.ag = new com.freshchat.consumer.sdk.a.b<>(this, this.ah, this.g.shouldShowFaqCategoriesAsGrid(), this.aj);
        B().setAdapter(this.ag);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void x() {
        if (k.isEmpty(this.ah)) {
            eA();
        } else {
            A();
            i.b(B());
            i.c(getEmptyView());
        }
    }

    /* access modifiers changed from: 0000 */
    public void z() {
        i.b(this.am);
    }
}
