package com.mpl.androidapp.notification;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.mpl.androidapp.utils.MLogger;

public class HomeScreenBackgroundHandlerThread extends HandlerThread {
    public static final String TAG = "HomeScreenBancgroundHan";
    public Handler handler;
    public String mName;

    public HomeScreenBackgroundHandlerThread(String str) {
        this(str, 19);
        MLogger.d(TAG, "HomeScreenBancgroundHandlerThread: ", str);
    }

    public void createHandlerForThread() {
        this.handler = new Handler(getLooper());
    }

    public void onLooperPrepared() {
        super.onLooperPrepared();
        MLogger.d(TAG, "onLooperPrepared: ");
    }

    public void run() {
        super.run();
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = "run: ";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        MLogger.d(TAG, objArr);
    }

    public void startTask(Runnable runnable) {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(runnable, 500);
        }
        Object[] objArr = new Object[3];
        objArr[0] = "startTask: ";
        objArr[1] = "Is Main Thread 2";
        objArr[2] = Boolean.valueOf(Looper.myLooper() == Looper.getMainLooper());
        MLogger.d(TAG, objArr);
        MLogger.d(TAG, "startTask: ", "getState", runnable.toString());
    }

    public HomeScreenBackgroundHandlerThread() {
        this(TAG, 19);
        MLogger.d(TAG, "HomeScreenBackgroundHandlerThread: ");
    }

    public HomeScreenBackgroundHandlerThread(String str, int i) {
        super(str, i);
        this.mName = str;
        MLogger.d(TAG, "HomeScreenBancgroundHandlerThread: ", str, Integer.valueOf(i));
    }
}
