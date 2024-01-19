package com.mpl.androidapp.backgroundmanager;

import android.os.AsyncTask;

public class BackgroundTaskHandler {
    public static void execute(Runnable runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
    }

    public static void executeSerialOrder(Runnable runnable) {
        AsyncTask.SERIAL_EXECUTOR.execute(runnable);
    }
}
