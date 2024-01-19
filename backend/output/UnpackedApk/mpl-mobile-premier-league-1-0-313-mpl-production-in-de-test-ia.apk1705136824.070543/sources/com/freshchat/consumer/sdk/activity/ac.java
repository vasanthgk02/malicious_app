package com.freshchat.consumer.sdk.activity;

import android.os.Bundle;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.Loader;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.g.b;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import java.util.Collection;
import java.util.List;

public class ac implements LoaderCallbacks<List<Article>> {
    public final /* synthetic */ ArticleListActivity ae;

    public ac(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> list) {
        if (this.ae.T && !((b) loader).gE()) {
            int b2 = k.b((Collection<?>) list);
            if (b2 == 0) {
                this.ae.finish();
                i.a(this.ae.getContext(), R.string.freshchat_faqs_reload_and_redirect);
                Freshchat.showFAQs(this.ae.getContext(), this.ae.g);
                return;
            } else if (b2 == 1 && list.get(0) != null) {
                this.ae.finish();
                this.ae.a(Long.parseLong(list.get(0).getId()));
                return;
            }
        }
        this.ae.W.clear();
        this.ae.W.addAll(list);
        this.ae.x();
        this.ae.bL();
    }

    public Loader<List<Article>> onCreateLoader(int i, Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("search_key") && as.a(bundle.getString("search_key"))) {
                String string = bundle.getString("search_key");
                this.ae.A = "article_search";
                if (bundle.containsKey("category_ids")) {
                    b bVar = new b(this.ae.getApplicationContext(), this.ae.X, null, bundle.getStringArrayList("category_ids"), string, true);
                    return bVar;
                } else if (!this.ae.T || !bundle.containsKey("FAQ_TAGS")) {
                    b bVar2 = new b(this.ae.getApplicationContext(), string, true, this.ae.X, true);
                    return bVar2;
                } else {
                    b bVar3 = new b(this.ae.getApplicationContext(), this.ae.X, bundle.getStringArrayList("FAQ_TAGS"), null, string, true);
                    return bVar3;
                }
            } else if (bundle.containsKey("category_ids")) {
                b bVar4 = new b(this.ae.getApplicationContext(), this.ae.X, null, bundle.getStringArrayList("category_ids"), "", false);
                return bVar4;
            } else if (bundle.containsKey("FAQ_TAGS")) {
                this.ae.z();
                this.ae.eM = bundle.getStringArrayList("FAQ_TAGS");
                b bVar5 = new b(this.ae.getApplicationContext(), this.ae.X, this.ae.eM, null, "", false);
                return bVar5;
            }
        }
        return new b(this.ae.getApplicationContext(), this.ae.X);
    }

    public void onLoaderReset(Loader<List<Article>> loader) {
        this.ae.W.clear();
        this.ae.L.notifyDataSetChanged();
    }
}
