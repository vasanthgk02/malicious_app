package io.antmedia.android.broadcaster.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;

public class Utils {
    public static final String APP_SHARED_PREFERENCES = "applicationDetails";
    public static final String DOES_ENCODER_WORKS = GeneratedOutlineSupport.outline36(Utils.class, new StringBuilder(), ".DOES_ENCODER_WORKS");
    public static final int ENCODER_NOT_TESTED = -1;
    public static final int ENCODER_NOT_WORKS = 0;
    public static final int ENCODER_WORKS = 1;
    public static SharedPreferences sharedPreference = null;

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        if (sharedPreference == null) {
            sharedPreference = context.getSharedPreferences(APP_SHARED_PREFERENCES, 0);
        }
        return sharedPreference;
    }

    public static String getDurationString(int i) {
        if (i < 0 || i > 2000000) {
            i = 0;
        }
        int i2 = i / SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT;
        int i3 = (i % SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT) / 60;
        int i4 = i % 60;
        if (i2 == 0) {
            return twoDigitString(i3) + " : " + twoDigitString(i4);
        }
        return twoDigitString(i2) + " : " + twoDigitString(i3) + " : " + twoDigitString(i4);
    }

    public static String twoDigitString(int i) {
        if (i == 0) {
            return "00";
        }
        if (i / 10 == 0) {
            return GeneratedOutlineSupport.outline41("0", i);
        }
        return String.valueOf(i);
    }
}
