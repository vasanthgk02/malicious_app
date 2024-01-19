package net.danlew.android.joda;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;
import org.joda.time.JodaTimePermission;

public class TimeZoneChangedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        intent.getStringExtra("time-zone");
        try {
            DateTimeZone forTimeZone = DateTimeZone.forTimeZone(TimeZone.getDefault());
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
            }
            if (forTimeZone != null) {
                DateTimeZone.cDefault.set(forTimeZone);
                return;
            }
            throw new IllegalArgumentException("The datetime zone must not be null");
        } catch (IllegalArgumentException unused) {
        }
    }
}
