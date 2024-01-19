package com.userexperior.a.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.fontbox.cmap.CMap;

public enum d implements e {
    IDENTITY {
        public final String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public final String translateName(Field field) {
            return d.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public final String translateName(Field field) {
            return d.upperCaseFirstLetter(d.separateCamelCase(field.getName(), CMap.SPACE));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public final String translateName(Field field) {
            return d.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public final String translateName(Field field) {
            return d.separateCamelCase(field.getName(), Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase(Locale.ENGLISH);
        }
    };

    public static String modifyString(char c2, String str, int i) {
        if (i >= str.length()) {
            return String.valueOf(c2);
        }
        StringBuilder outline72 = GeneratedOutlineSupport.outline72(c2);
        outline72.append(str.substring(i));
        return outline72.toString();
    }

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            charAt = str.charAt(i);
            if (i < str.length() - 1 && !Character.isLetter(charAt)) {
                sb.append(charAt);
                i++;
            }
        }
        if (i == str.length()) {
            return sb.toString();
        }
        if (!Character.isUpperCase(charAt)) {
            sb.append(modifyString(Character.toUpperCase(charAt), str, i + 1));
            str = sb.toString();
        }
        return str;
    }
}
