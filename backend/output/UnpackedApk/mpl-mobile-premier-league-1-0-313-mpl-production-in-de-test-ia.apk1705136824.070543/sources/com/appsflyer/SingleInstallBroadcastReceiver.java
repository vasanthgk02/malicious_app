package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appsflyer.internal.ac;

public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getStringExtra("referrer");
            } catch (Throwable th) {
                AFLogger.valueOf("error in BroadcastReceiver ", th);
                str = null;
            }
            if (str == null || ac.AFInAppEventType(context).getString("referrer", null) == null) {
                String string = AppsFlyerProperties.getInstance().getString("referrer_timestamp");
                long currentTimeMillis = System.currentTimeMillis();
                if (string == null || currentTimeMillis - Long.valueOf(string).longValue() >= 2000) {
                    AFLogger.values((String) "SingleInstallBroadcastReceiver called");
                    ac.AFInAppEventParameterName().AFKeystoreWrapper(context, intent);
                    AppsFlyerProperties.getInstance().set((String) "referrer_timestamp", String.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            }
            ac.AFInAppEventParameterName().valueOf(context, str);
        }
    }
}
