package org.greenrobot.eventbus.android;

import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;

public class AndroidLogger implements Logger {
    public final String tag;

    public AndroidLogger(String str) {
        this.tag = str;
    }

    public void log(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(mapLevel(level), this.tag, str);
        }
    }

    public final int mapLevel(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        }
        if (intValue < 900) {
            return 4;
        }
        return intValue < 1000 ? 5 : 6;
    }

    public void log(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int mapLevel = mapLevel(level);
            String str2 = this.tag;
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "\n");
            outline78.append(Log.getStackTraceString(th));
            Log.println(mapLevel, str2, outline78.toString());
        }
    }
}
