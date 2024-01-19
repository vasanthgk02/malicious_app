package com.facebook.react.views.text;

import java.text.BreakIterator;

public enum TextTransform {
    NONE,
    UPPERCASE,
    LOWERCASE,
    CAPITALIZE,
    UNSET;

    public static String apply(String str, TextTransform textTransform) {
        if (str == null) {
            return null;
        }
        int ordinal = textTransform.ordinal();
        if (ordinal == 1) {
            str = str.toUpperCase();
        } else if (ordinal == 2) {
            str = str.toLowerCase();
        } else if (ordinal == 3) {
            str = capitalize(str);
        }
        return str;
    }

    public static String capitalize(String str) {
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(str);
        StringBuilder sb = new StringBuilder(str.length());
        int first = wordInstance.first();
        while (true) {
            int i = first;
            first = wordInstance.next();
            if (first == -1) {
                return sb.toString();
            }
            String substring = str.substring(i, first);
            if (Character.isLetterOrDigit(substring.charAt(0))) {
                sb.append(Character.toUpperCase(substring.charAt(0)));
                sb.append(substring.substring(1).toLowerCase());
            } else {
                sb.append(substring);
            }
        }
    }
}
