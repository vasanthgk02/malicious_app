package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.c.i;
import com.freshchat.consumer.sdk.j.k;
import java.util.List;

public class f extends c<Category> {
    public final Context context;
    public i eL;
    public List<String> tags;

    public f(Context context2) {
        super(context2);
        this.context = context2;
        this.eL = new i(context2);
    }

    public f(Context context2, List<String> list) {
        this(context2);
        if (k.a(list)) {
            this.tags = list;
        }
    }

    public List<Category> dd() {
        return k.a(this.tags) ? this.eL.l(this.tags) : this.eL.cJ();
    }

    public void onForceLoad() {
        super.onForceLoad();
    }

    public void onReset() {
        super.onReset();
    }

    public void onStartLoading() {
        super.onStartLoading();
    }
}
