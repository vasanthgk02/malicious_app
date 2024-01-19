package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ae implements OnItemClickListener {
    public final /* synthetic */ ArticleListActivity ae;

    public ae(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ae.a(j);
    }
}
