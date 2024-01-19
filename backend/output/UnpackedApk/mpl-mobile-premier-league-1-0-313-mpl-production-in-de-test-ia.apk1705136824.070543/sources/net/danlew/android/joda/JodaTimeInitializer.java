package net.danlew.android.joda;

import android.content.Context;
import android.content.IntentFilter;
import androidx.startup.Initializer;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.joda.time.DateTimeZone;
import org.joda.time.JodaTimePermission;

public class JodaTimeInitializer implements Initializer<Object> {
    public Object create(Context context) {
        try {
            ResourceZoneInfoProvider resourceZoneInfoProvider = new ResourceZoneInfoProvider(context);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
            }
            DateTimeZone.validateProvider(resourceZoneInfoProvider);
            DateTimeZone.cProvider.set(resourceZoneInfoProvider);
            context.getApplicationContext().registerReceiver(new TimeZoneChangedReceiver(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
            return new Object();
        } catch (IOException e2) {
            throw new RuntimeException("Could not read ZoneInfoMap. You are probably using Proguard wrong.", e2);
        }
    }

    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
