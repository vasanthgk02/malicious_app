package com.freshchat.consumer.sdk.activity;

import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat$OnActionExpandListener;
import com.freshchat.consumer.sdk.service.d.b;
import com.freshchat.consumer.sdk.service.d.b.a;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import org.apache.fontbox.cmap.CMap;

public class ad implements MenuItemCompat$OnActionExpandListener {
    public final /* synthetic */ ArticleListActivity ae;

    public ad(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        this.ae.J = false;
        this.ae.U = true;
        if (this.ae.V) {
            this.ae.e(CMap.SPACE);
            this.ae.finish();
        }
        this.ae.w();
        this.ae.y();
        this.ae.aJ();
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        this.ae.J = true;
        if (this.ae.U && (menuItem.getActionView() instanceof SearchView)) {
            this.ae.O = (SearchView) menuItem.getActionView();
            this.ae.O.setQuery(CMap.SPACE, true);
            this.ae.O.performClick();
        }
        this.ae.bL();
        this.ae.y();
        this.ae.aJ();
        new b(this.ae.getApplicationContext(), a.faq_search_launch).g(DefaultSettingsSpiCall.SOURCE_PARAM, "article_list").dB();
        return true;
    }
}
