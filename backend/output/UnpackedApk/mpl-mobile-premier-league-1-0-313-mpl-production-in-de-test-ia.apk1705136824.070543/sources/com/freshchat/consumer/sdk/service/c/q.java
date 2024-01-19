package com.freshchat.consumer.sdk.service.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.e;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.s;
import java.util.Random;

public class q extends b<s, k> {
    private long dx() {
        return (long) ((new Random().nextInt(9) + 1) * 60 * 1000);
    }

    /* renamed from: a */
    public k b(s sVar) {
        ai.d("FRESHCHAT", "StartBackgroundAlarmRequestHandler::handleRequest() called");
        Context context = getContext();
        if (!c.s(context)) {
            return new h(false);
        }
        PendingIntent Z = e.Z(context);
        long currentTimeMillis = System.currentTimeMillis() + dx();
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, currentTimeMillis, 3600000, Z);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("StartBackgroundAlarmRequestHandler::Starting alarm from ");
        outline73.append(n.i(context, currentTimeMillis));
        outline73.append(", with an interval of ");
        outline73.append(3600000);
        outline73.append(" ms");
        ai.d("FRESHCHAT", outline73.toString());
        return new h(true);
    }
}
