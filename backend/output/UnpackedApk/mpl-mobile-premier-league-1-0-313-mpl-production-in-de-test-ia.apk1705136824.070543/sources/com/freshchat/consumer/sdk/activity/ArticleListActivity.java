package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.core.view.MenuItemCompat$1;
import androidx.core.view.MenuItemCompat$OnActionExpandListener;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.FaqOptions.FilterType;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.a;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.d.b;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArticleListActivity extends b {
    public String A = "article_list";
    public boolean J = false;
    public String K = "";
    public a L;
    public String M = "";
    public ContentLoadingProgressBar N;
    public SearchView O;
    public ListView P;
    public View Q;
    public Menu R;
    public View S;
    public boolean T = false;
    public boolean U = false;
    public boolean V;
    public List<Article> W = new ArrayList();
    public List<Article> X = new ArrayList();
    public ArrayList<String> Y;
    public LoaderCallbacks<List<Article>> Z = new ac(this);
    public MenuItemCompat$OnActionExpandListener aa = new ad(this);
    public OnItemClickListener ab = new ae(this);
    public OnClickListener ac = new af(this);
    public OnQueryTextListener ad = new ag(this);
    public String categoryId = "";
    public String categoryName = "";
    public List<String> eM;
    public FaqOptions g = new FaqOptions();
    public Bundle h = null;
    public String[] lE;

    /* access modifiers changed from: 0000 */
    public void A() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.N;
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.post(new Runnable() {
                public final void run() {
                    ContentLoadingProgressBar.this.hideOnUiThread();
                }
            });
        }
    }

    public void a(long j) {
        if (as.a(this.K)) {
            bg.a(getContext(), this.K, k.b((Collection<?>) this.W), true);
        }
        Intent intent = new Intent(this, ArticleDetailActivity.class);
        Bundle bundle = this.h;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("article_id", j);
        intent.putExtra("category_name", this.categoryName);
        intent.putExtra("EVENT_LAUNCH_SOURCE", this.A);
        intent.putExtra("INPUT_TAGS", this.lE);
        startActivity(intent);
    }

    public void a(Context context, Intent intent) {
        if ("com.freshchat.consumer.sdk.actions.SolutionsUpdated".equalsIgnoreCase(intent.getAction())) {
            w();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Intent intent) {
        if (intent != null) {
            this.g = u.d(intent.getExtras());
            if (intent.hasExtra("force_search_open")) {
                this.V = true;
            }
            if (intent.hasExtra("category_name")) {
                this.categoryName = intent.getStringExtra("category_name");
            }
            if (intent.hasExtra("category_ids")) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("category_ids");
                this.Y = stringArrayListExtra;
                if (k.b((Collection<?>) stringArrayListExtra) == 1) {
                    this.categoryId = this.Y.get(0);
                }
            }
            this.M = (this.g.getFilterType() != FilterType.ARTICLE || !as.a(this.g.getFilteredViewTitle())) ? as.a(this.categoryName) ? this.categoryName : getString(R.string.freshchat_activity_title_article_list) : this.g.getFilteredViewTitle();
            if (k.a(this.g.getTags())) {
                this.T = true;
            }
        }
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.SolutionsUpdated", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    /* access modifiers changed from: 0000 */
    public void aJ() {
        Menu menu = this.R;
        if (menu != null) {
            MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_contact_us);
            if (findItem != null) {
                findItem.setVisible(!this.J && this.g.shouldShowContactUsOnFaqScreens() && this.g.shouldShowContactUsOnAppBar());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void bL() {
        getListView().setAdapter(this.L);
        getListView().setOnItemClickListener(this.ab);
    }

    /* access modifiers changed from: 0000 */
    public void d(String str) {
        if (this.J) {
            getSupportLoaderManager().restartLoader(111, GeneratedOutlineSupport.outline14("search_key", str), this.Z);
        }
    }

    /* access modifiers changed from: 0000 */
    public View getEmptyView() {
        if (this.Q == null) {
            this.Q = findViewById(R.id.empty);
        }
        return this.Q;
    }

    /* access modifiers changed from: 0000 */
    public ListView getListView() {
        if (this.P == null) {
            this.P = (ListView) findViewById(R.id.list);
        }
        return this.P;
    }

    public void onBackPressed() {
        if (this.V) {
            finish();
            return;
        }
        if (this.J) {
            Menu menu = this.R;
            if (menu != null) {
                MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_search_solutions);
                if (findItem != null) {
                    findItem.collapseActionView();
                    return;
                }
                return;
            }
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 226284722, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_articles_list, menu);
        this.R = menu;
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_search_solutions);
        SearchView searchView = (SearchView) findItem.getActionView();
        this.O = searchView;
        searchView.setOnQueryTextListener(this.ad);
        this.O.setQueryHint(getString(R.string.freshchat_faq_search_query_hint));
        findItem.setOnActionExpandListener(new MenuItemCompat$1(this.aa));
        i.a(this.O, getSupportActionBar());
        if (this.V) {
            findItem.expandActionView();
        }
        aJ();
        return true;
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, -1158380280, new Object[0]);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        }
        r().aE();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public v r() {
        return aa.a(getContext(), this.g);
    }

    public void supportInvalidateOptionsMenu() {
        this.U = true;
        super.invalidateOptionsMenu();
    }

    /* access modifiers changed from: 0000 */
    public void u() {
        this.N = (ContentLoadingProgressBar) findViewById(R.id.freshchat_article_list_cl_progressbar);
        y();
    }

    /* access modifiers changed from: 0000 */
    public void v() {
        new b(getApplicationContext(), b.a.faq_open_category).g("category_id", this.categoryId).g("category_name", this.categoryName).dB();
    }

    /* access modifiers changed from: 0000 */
    public void w() {
        ArrayList<String> arrayList;
        String str;
        Bundle bundle = new Bundle();
        if (k.a(this.Y)) {
            arrayList = this.Y;
            str = "category_ids";
        } else {
            if (k.a(this.g.getTags()) && this.g.getFilterType() == FilterType.ARTICLE) {
                arrayList = new ArrayList<>(this.g.getTags());
                str = "FAQ_TAGS";
            }
            getSupportLoaderManager().restartLoader(111, bundle, this.Z);
        }
        bundle.putStringArrayList(str, arrayList);
        getSupportLoaderManager().restartLoader(111, bundle, this.Z);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void x() {
        A();
        if (k.isEmpty(this.W)) {
            i.c(getListView());
            i.b(getEmptyView());
        } else {
            i.b(getListView());
            i.c(getEmptyView());
        }
    }

    /* access modifiers changed from: 0000 */
    public void y() {
        View findViewById = findViewById(R.id.freshchat_contact_us_group);
        this.S = findViewById;
        if (findViewById != null) {
            if (this.J && this.g.shouldShowContactUsOnFaqNotHelpful()) {
                this.S.setVisibility(0);
                this.S.setOnClickListener(this.ac);
            } else if (!this.g.shouldShowContactUsOnFaqScreens() || this.g.shouldShowContactUsOnAppBar()) {
                this.S.setVisibility(8);
            } else {
                this.S.setVisibility(0);
                this.S.setOnClickListener(this.ac);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void z() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.N;
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.post(new Runnable() {
                public final void run() {
                    ContentLoadingProgressBar.this.showOnUiThread();
                }
            });
        }
    }
}
