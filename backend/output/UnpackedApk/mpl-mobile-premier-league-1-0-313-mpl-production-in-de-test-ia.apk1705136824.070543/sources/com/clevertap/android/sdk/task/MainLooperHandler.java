package com.clevertap.android.sdk.task;

import android.os.Handler;
import android.os.Looper;

public class MainLooperHandler extends Handler {
    public Runnable pendingRunnable = null;

    public MainLooperHandler() {
        super(Looper.getMainLooper());
    }
}
