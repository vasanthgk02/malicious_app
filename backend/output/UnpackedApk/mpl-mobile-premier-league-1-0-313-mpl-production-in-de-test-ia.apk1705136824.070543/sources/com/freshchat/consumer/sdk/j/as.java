package com.freshchat.consumer.sdk.j;

import android.text.Html;
import android.text.Spanned;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl;
import java.util.Locale;

public class as {
    public static String a(String str, String str2, int i) {
        if (isEmpty(str) || i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(str2);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a(String[] strArr, String str) {
        if (k.c((Object[]) strArr)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        int length = strArr.length;
        for (int i = 1; i < length; i++) {
            String str2 = strArr[i];
            if (a(sb) && a(str2)) {
                sb.append(str);
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static boolean a(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static String aH(String str) {
        return str == null ? "" : str.trim();
    }

    public static String aJ(String str) {
        int i;
        if (str == null) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.startsWith("https://")) {
            i = 8;
        } else {
            if (lowerCase.startsWith("http://")) {
                i = 7;
            }
            return lowerCase;
        }
        lowerCase = lowerCase.substring(i);
        return lowerCase;
    }

    public static long b(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return (long) charSequence.length();
    }

    public static String b(String str, int i) {
        return str == null ? "" : str.length() > i ? str.substring(0, i - 1) : str;
    }

    public static boolean c(String str, boolean z) {
        if (isEmpty(str)) {
            return false;
        }
        if (z) {
            str = fromHtml(str).toString();
        }
        return ((TextDirectionHeuristicImpl) BidiFormatter.getInstance().mDefaultTextDirectionHeuristicCompat).isRtl(str, 0, str.length());
    }

    public static boolean f(String[] strArr) {
        return strArr != null && strArr.length > 0;
    }

    public static Spanned fromHtml(String str) {
        return Html.fromHtml(str);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null) {
            int length = charSequence.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(charSequence.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean m(String str, String str2) {
        if (isEmpty(str) && isEmpty(str2)) {
            return true;
        }
        if (!a(str) || !a(str2)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean o(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static boolean p(String str, String str2) {
        return !o(str, str2);
    }

    public static boolean q(String str, String str2) {
        return m(aJ(str), aJ(str2));
    }
}
