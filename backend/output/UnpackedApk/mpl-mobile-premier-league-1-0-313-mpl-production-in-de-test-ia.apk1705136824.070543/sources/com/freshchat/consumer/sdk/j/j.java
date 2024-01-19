package com.freshchat.consumer.sdk.j;

import java.util.Locale;

public class j {
    public static String a(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (!a(lowerCase, 2, 3)) {
            if (z) {
                return "";
            }
            lowerCase = "und";
        }
        return lowerCase;
    }

    public static String a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String str = "";
        String replace = as.a(locale.getVariant()) ? locale.getVariant().replace('_', '-') : str;
        String a2 = a(language, false);
        String b2 = b(country, false);
        String au = au(replace);
        if (a2.isEmpty()) {
            a2 = "und";
        }
        if (!"no".equals(a2) || !"NO".equals(b2) || !"NY".equals(au)) {
            str = au;
        } else {
            a2 = "nn";
            b2 = "NO";
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append(a2);
        if (!b2.isEmpty()) {
            sb.append('-');
            sb.append(b2);
        }
        if (!str.isEmpty()) {
            sb.append('-');
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean a(String str, int i, int i2) {
        int length = str.length();
        if (length < i || length > i2) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    public static String au(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String replace = str.replace('-', '_');
        for (String aw : replace.split("_")) {
            if (!aw(aw)) {
                return "";
            }
        }
        return replace;
    }

    public static boolean av(String str) {
        if (str.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean aw(String str) {
        if (str.length() < 5 || str.length() > 8) {
            if (str.length() == 4) {
                char charAt = str.charAt(0);
                return charAt >= '0' && charAt <= '9' && ax(str);
            }
        } else if (ax(str)) {
            return true;
        }
    }

    public static boolean ax(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9'))) {
                return false;
            }
        }
        return true;
    }

    public static String b(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        return (a(upperCase, 2, 2) || av(upperCase)) ? upperCase : "";
    }
}
