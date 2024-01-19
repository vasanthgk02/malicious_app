package com.freshchat.consumer.sdk.k;

import android.content.Context;

public abstract class a {
    public Context context;

    public a(Context context2) {
        if (context2 != null) {
            this.context = context2.getApplicationContext();
        }
    }

    public Context getContext() {
        return this.context;
    }
}
