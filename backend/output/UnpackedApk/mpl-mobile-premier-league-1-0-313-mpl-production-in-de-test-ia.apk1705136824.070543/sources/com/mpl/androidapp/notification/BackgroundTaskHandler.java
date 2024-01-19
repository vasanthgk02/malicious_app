package com.mpl.androidapp.notification;

import android.os.Handler;
import android.os.HandlerThread;

public class BackgroundTaskHandler extends HandlerThread {
    public static final String TAG = BackgroundTaskHandler.class.getName();
    public Handler handler;

    public BackgroundTaskHandler() {
        super(TAG);
    }

    public void postTask(Runnable runnable) {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.post(runnable);
        }
    }

    public void prepareLooper() {
        this.handler = new Handler(getLooper());
    }
}
