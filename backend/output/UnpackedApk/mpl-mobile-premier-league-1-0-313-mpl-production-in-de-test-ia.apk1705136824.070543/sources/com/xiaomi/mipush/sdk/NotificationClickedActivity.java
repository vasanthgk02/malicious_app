package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.inca.security.Proxy.iIiIiIiIii;
import com.xiaomi.channel.commonutils.logger.b;

public final class NotificationClickedActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f4330a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f191a;

    /* access modifiers changed from: 0000 */
    public void a(Intent intent) {
        if (intent != null) {
            try {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                    intent2.putExtra("is_clicked_activity_call", true);
                    b.b("clicked activity start service.");
                    startService(intent2);
                }
            } catch (Exception e2) {
                b.a((Throwable) e2);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1962364848, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, -1170205315, new Object[0]);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, -1448336979, new Object[0]);
    }
}
