package io.hansel.ujmtracker;

import android.content.Context;
import io.hansel.core.HSLBuildConfig;

public class j {
    public static String a(Context context) {
        String g = k.g(context);
        if (g != null && g.length() != 0) {
            return g;
        }
        return HSLBuildConfig.getTrackerServerUrl(context) + "/" + "dil/push/message/";
    }
}
