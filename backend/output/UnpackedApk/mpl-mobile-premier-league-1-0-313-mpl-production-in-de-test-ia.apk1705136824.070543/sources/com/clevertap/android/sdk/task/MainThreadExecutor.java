package com.clevertap.android.sdk.task;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class MainThreadExecutor implements Executor {
    public Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.mainThreadHandler.post(runnable);
    }
}
