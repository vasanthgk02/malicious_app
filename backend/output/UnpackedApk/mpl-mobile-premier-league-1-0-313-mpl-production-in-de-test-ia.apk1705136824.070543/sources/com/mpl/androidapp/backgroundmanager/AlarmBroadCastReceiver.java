package com.mpl.androidapp.backgroundmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;
import com.mpl.androidapp.utils.MLogger;

public class AlarmBroadCastReceiver extends BroadcastReceiver {
    public static final String TAG = "backgroundService";

    public void onReceive(Context context, Intent intent) {
        MLogger.d("backgroundService", "onReceive: ");
        Intent intent2 = new Intent(context, BackgroundOperationsManagerService.class);
        if (VERSION.SDK_INT >= 26) {
            BackgroundOperationsManagerService.createNotificationChannel(context);
            ContextCompat.startForegroundService(context, intent2);
            return;
        }
        context.startService(intent2);
    }
}
