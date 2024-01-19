package com.mpl.androidapp.notification;

import android.os.Looper;
import android.os.Process;
import com.mpl.androidapp.utils.MLogger;

public class HomeTasksRunnable implements Runnable {
    public static final String TAG = "HomeTasksRunnable";

    public void run() {
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = "run: ";
        objArr[1] = Boolean.valueOf(Looper.myLooper() == Looper.getMainLooper());
        MLogger.d(TAG, objArr);
        Object[] objArr2 = new Object[2];
        objArr2[0] = "run: ";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        }
        objArr2[1] = Boolean.valueOf(z);
        MLogger.d(TAG, objArr2);
        Process.setThreadPriority(19);
    }
}
