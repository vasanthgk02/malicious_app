package io.sentry.util;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1).toLowerCase(Locale.ROOT);
    }

    public static String getStringAfterDot(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            int i = lastIndexOf + 1;
            if (str.length() > i) {
                str = str.substring(i);
            }
        }
        return str;
    }

    public static String removeSurrounding(String str, String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }
}
