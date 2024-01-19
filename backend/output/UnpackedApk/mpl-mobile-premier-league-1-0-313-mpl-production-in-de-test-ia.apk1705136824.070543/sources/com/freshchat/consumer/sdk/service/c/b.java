package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.service.e.j;
import com.freshchat.consumer.sdk.service.e.k;

public abstract class b<T1 extends j, T2 extends k> implements j<T1, T2> {
    public Context context;
    public e fK;

    public void a(e eVar) {
        this.fK = eVar;
    }

    public e dw() {
        return this.fK;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }
}
