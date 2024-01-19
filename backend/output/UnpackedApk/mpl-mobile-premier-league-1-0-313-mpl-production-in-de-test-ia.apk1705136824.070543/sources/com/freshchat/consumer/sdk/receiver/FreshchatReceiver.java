package com.freshchat.consumer.sdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.j.ag;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.g;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.s;

public class FreshchatReceiver extends BroadcastReceiver {
    private boolean a(Intent intent, String str) {
        return intent != null && as.a(str) && str.equals(intent.getAction());
    }

    private void c(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            ai.w("FRESHCHAT_WARNING", "Extras cannot be null in FreshchatReceiver::onReceive().");
            return;
        }
        String b2 = ag.b(intent, "FRESHCHAT_DEEPLINK");
        if (as.a(b2)) {
            a.p(context, b2);
        } else {
            ai.w("FRESHCHAT_WARNING", c.INVALID_NOTIFICATION_CLICK_ACTION_MISSING_DEEPLINK.toString().replace("{{action_str}}", "com.freshchat.consumer.sdk.actions.NotificationClicked"));
        }
    }

    private boolean f(Intent intent) {
        if (aw.eT()) {
            return a(intent, "android.intent.action.MY_PACKAGE_REPLACED");
        }
        return false;
    }

    private boolean g(Intent intent) {
        return a(intent, "android.intent.action.LOCALE_CHANGED");
    }

    private boolean h(Intent intent) {
        return a(intent, "android.intent.action.BOOT_COMPLETED");
    }

    private boolean i(Intent intent) {
        return intent != null && intent.hasExtra("android.intent.extra.ALARM_COUNT");
    }

    private void p(Context context) {
        ah.bN(context);
    }

    private void q(Context context) {
        if (g.ag(context.getApplicationContext())) {
            b.u(context);
        }
    }

    public void onReceive(Context context, Intent intent) {
        ag.a("FRESHCHAT", intent);
        try {
            if (h(intent)) {
                d.b(context.getApplicationContext(), new s());
            } else if (i(intent)) {
                if (al.aS(context.getApplicationContext())) {
                    com.freshchat.consumer.sdk.j.b.c.fD();
                    b.M(context);
                }
            } else if (g(intent)) {
                p(context);
            } else if (f(intent)) {
                q(context);
            } else if ("com.freshchat.consumer.sdk.actions.NotificationClicked".equals(intent.getAction())) {
                c(context, intent);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
