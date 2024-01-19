package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.c.i;
import com.freshchat.consumer.sdk.j.as;

public class j extends d<Article> {
    public i eY;
    public boolean eZ = false;
    public Category fa;
    public String v = null;

    public j(Context context, String str, boolean z) {
        super(context);
        if (!as.isEmpty(str)) {
            this.v = str;
        }
        this.eZ = z;
        this.eY = new i(context);
    }

    /* renamed from: dj */
    public Article getData() {
        Article ab = as.a(this.v) ? this.eY.ab(this.v) : null;
        if (this.eZ && ab != null) {
            this.fa = this.eY.Y(ab.getCategoryId());
        }
        return ab;
    }

    public Category dk() {
        return this.fa;
    }

    public void onReset() {
        super.onReset();
        this.fa = null;
    }
}
