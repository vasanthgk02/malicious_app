package com.freshchat.consumer.sdk.j;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.freshchat.consumer.sdk.receiver.FreshchatReceiver;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.s;
import java.util.concurrent.atomic.AtomicBoolean;

public class e {
    public static AtomicBoolean ho = new AtomicBoolean(false);

    public static void Y(Context context) {
        if (!ho.get()) {
            try {
                d.c(context, new s(), new a() {
                    public void a(k kVar) {
                        if (kVar != null && kVar.isSuccess()) {
                            e.ho.set(true);
                        }
                    }
                });
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static PendingIntent Z(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent(context, FreshchatReceiver.class), 335544320);
    }

    public static void aa(Context context) {
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(Z(context));
        ho.set(false);
    }
}
