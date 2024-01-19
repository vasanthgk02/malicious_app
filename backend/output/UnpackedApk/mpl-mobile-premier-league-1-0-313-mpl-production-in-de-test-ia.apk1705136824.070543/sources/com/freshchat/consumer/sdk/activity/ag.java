package com.freshchat.consumer.sdk.activity;

import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import java.util.Collection;

public class ag implements OnQueryTextListener {
    public final /* synthetic */ ArticleListActivity ae;

    public ag(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    public boolean onQueryTextChange(String str) {
        if (as.a(this.ae.K) && this.ae.K.length() != 1 && as.isEmpty(str)) {
            bg.a(this.ae.getContext(), this.ae.K, k.b((Collection<?>) this.ae.W), false);
        }
        if (this.ae.dH()) {
            this.ae.onUserInteraction();
        }
        this.ae.K = str;
        ArticleListActivity articleListActivity = this.ae;
        articleListActivity.d(articleListActivity.K);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        this.ae.d(str);
        return true;
    }
}
