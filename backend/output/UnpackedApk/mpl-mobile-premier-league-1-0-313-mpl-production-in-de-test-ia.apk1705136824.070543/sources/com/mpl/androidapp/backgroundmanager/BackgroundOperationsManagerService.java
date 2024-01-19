package com.mpl.androidapp.backgroundmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import androidx.core.app.NotificationCompat.Builder;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;

public class BackgroundOperationsManagerService extends Service {
    public static final String BACKGROUND_CHANNEL_ID = "notification_check";
    public static final int ID = 2340;
    public static final String TAG = "backgroundService";

    public static void createNotificationChannel(Context context) {
        if (VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(BACKGROUND_CHANNEL_ID, context.getString(R.string.notification_channel), 2);
            notificationChannel.setDescription(context.getString(R.string.notification_channel_desc));
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    /* access modifiers changed from: private */
    public void fakeStartForeground() {
        if (VERSION.SDK_INT >= 26) {
            startForeground(ID, new Builder((Context) this, (String) BACKGROUND_CHANNEL_ID).setContentTitle("").setContentText("").build());
        }
    }

    public static Notification getBackgroundNotification(Context context, String str) {
        return new Builder(context, (String) BACKGROUND_CHANNEL_ID).setSmallIcon((int) R.drawable.ic_stat_mpl).setOngoing(false).setChannelId(BACKGROUND_CHANNEL_ID).setContentTitle(str).build();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        MLogger.d("backgroundService", "onCreate: ");
        if (VERSION.SDK_INT >= 26) {
            MLogger.d("backgroundService", "onCreate: inside oreo");
            startForeground(ID, getBackgroundNotification(this, getString(R.string.background_checking)));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        MLogger.d("backgroundService", "onDestroy: ");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        long timeIntervalForCloseNotification = MSharedPreferencesUtils.getTimeIntervalForCloseNotification();
        MLogger.d("backgroundService", "onStartCommand: ", Long.valueOf(timeIntervalForCloseNotification));
        new Handler(new Callback() {
            public boolean handleMessage(Message message) {
                try {
                    MLogger.d("backgroundService", "onStartCommand:removing notification ");
                    if (VERSION.SDK_INT >= 26) {
                        BackgroundOperationsManagerService.this.fakeStartForeground();
                        BackgroundOperationsManagerService.this.stopForeground(true);
                    } else {
                        BackgroundOperationsManagerService.this.stopSelf();
                    }
                } catch (Exception unused) {
                }
                return false;
            }
        }).sendEmptyMessageDelayed(0, timeIntervalForCloseNotification);
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        MLogger.d("backgroundService", "onTaskRemoved: ");
    }
}
