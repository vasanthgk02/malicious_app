package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ab.a;

public abstract class d implements b {
    public final ab cS = new ab(new a());
    public final Context context;
    public final a ft;

    public d(Context context2, a aVar) {
        this.context = context2;
        this.ft = aVar;
    }

    public ab ch() {
        return this.cS;
    }

    public a dt() {
        return this.ft;
    }

    public Context getContext() {
        return this.context;
    }
}
