package in.juspay.hypersdk.core;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class JuspayCoreLib {
    public static Context applicationContext;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static boolean isAppDebuggable() {
        Context applicationContext2 = getApplicationContext();
        boolean z = false;
        if (applicationContext2 == null) {
            return false;
        }
        if ((applicationContext2.getApplicationInfo().flags & 2) != 0) {
            z = true;
        }
        return z;
    }

    public static void setApplicationContext(Context context) {
        applicationContext = context;
    }
}
