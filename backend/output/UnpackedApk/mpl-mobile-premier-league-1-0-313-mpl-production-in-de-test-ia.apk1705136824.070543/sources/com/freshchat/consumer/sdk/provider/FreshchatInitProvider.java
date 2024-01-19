package com.freshchat.consumer.sdk.provider;

import android.app.Application;
import com.freshchat.consumer.sdk.f.c;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.cd;

public class FreshchatInitProvider extends cd {
    public boolean onCreate() {
        if (getContext() != null) {
            ai.i("AppStateListener", " OnCreate FreshchatInitProvider");
            c.a((Application) getContext().getApplicationContext());
        }
        return true;
    }
}
