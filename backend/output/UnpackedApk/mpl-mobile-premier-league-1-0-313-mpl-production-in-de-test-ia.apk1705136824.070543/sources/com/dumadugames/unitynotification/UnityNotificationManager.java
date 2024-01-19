package com.dumadugames.unitynotification;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import com.netcore.android.notification.SMTNotificationConstants;

public class UnityNotificationManager extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Class<?> cls;
        Context context2 = context;
        Intent intent2 = intent;
        NotificationManager notificationManager = (NotificationManager) context2.getSystemService("notification");
        String stringExtra = intent2.getStringExtra("ticker");
        String stringExtra2 = intent2.getStringExtra("title");
        String stringExtra3 = intent2.getStringExtra("message");
        String stringExtra4 = intent2.getStringExtra("s_icon");
        String stringExtra5 = intent2.getStringExtra("l_icon");
        int intExtra = intent2.getIntExtra("color", 0);
        String stringExtra6 = intent2.getStringExtra("activity");
        Boolean valueOf = Boolean.valueOf(intent2.getBooleanExtra(SMTNotificationConstants.NOTIF_SOUND_KEY, false));
        Boolean valueOf2 = Boolean.valueOf(intent2.getBooleanExtra("vibrate", false));
        Boolean valueOf3 = Boolean.valueOf(intent2.getBooleanExtra("lights", false));
        int intExtra2 = intent2.getIntExtra("id", 0);
        Resources resources = context.getResources();
        try {
            cls = Class.forName(stringExtra6);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            cls = null;
        }
        PendingIntent activity = PendingIntent.getActivity(context2, 0, new Intent(context2, cls), 0);
        Builder builder = new Builder(context2);
        NotificationManager notificationManager2 = notificationManager;
        builder.setContentIntent(activity).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(stringExtra2).setContentText(stringExtra3);
        builder.setColor(intExtra);
        if (stringExtra != null && stringExtra.length() > 0) {
            builder.setTicker(stringExtra);
        }
        if (stringExtra4 != null && stringExtra4.length() > 0) {
            builder.setSmallIcon(resources.getIdentifier(stringExtra4, "drawable", context.getPackageName()));
        }
        if (stringExtra5 != null && stringExtra5.length() > 0) {
            builder.setLargeIcon(BitmapFactory.decodeResource(resources, resources.getIdentifier(stringExtra5, "drawable", context.getPackageName())));
        }
        if (valueOf.booleanValue()) {
            builder.setSound(RingtoneManager.getDefaultUri(2));
        }
        if (valueOf2.booleanValue()) {
            builder.setVibrate(new long[]{1000, 1000});
        }
        if (valueOf3.booleanValue()) {
            builder.setLights(-16711936, 3000, 3000);
        }
        notificationManager2.notify(intExtra2, builder.build());
    }
}
