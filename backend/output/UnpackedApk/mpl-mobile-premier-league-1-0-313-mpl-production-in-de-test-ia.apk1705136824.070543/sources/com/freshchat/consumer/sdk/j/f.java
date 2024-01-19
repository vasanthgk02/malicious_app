package com.freshchat.consumer.sdk.j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class f implements Executor {
    public final Handler handler = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.handler.post(runnable);
    }
}
