package com.freshchat.consumer.sdk.activity;

import com.freshchat.consumer.sdk.j.be;

public class j implements Runnable {
    public final /* synthetic */ CategoryListActivity al;

    public j(CategoryListActivity categoryListActivity) {
        this.al = categoryListActivity;
    }

    public void run() {
        CategoryListActivity categoryListActivity = this.al;
        be.eC().gF().execute(new k(this, categoryListActivity.e(categoryListActivity.ah)));
    }
}
