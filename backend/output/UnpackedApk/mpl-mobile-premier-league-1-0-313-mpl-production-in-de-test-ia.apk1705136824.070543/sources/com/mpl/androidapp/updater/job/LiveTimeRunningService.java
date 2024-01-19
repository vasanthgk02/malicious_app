package com.mpl.androidapp.updater.job;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LiveTimeRunningService extends Service {
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}
