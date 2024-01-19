package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;

public class CharUtils {
    public static final Character[] CHAR_ARRAY = new Character[128];
    public static final String CHAR_STRING = "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    public static final String[] CHAR_STRING_ARRAY = new String[128];
    public static final char CR = '\r';
    public static final char LF = '\n';

    static {
        for (int i = 127; i >= 0; i--) {
            CHAR_STRING_ARRAY[i] = CHAR_STRING.substring(i, i + 1);
            CHAR_ARRAY[i] = new Character((char) i);
        }
    }

    public static boolean isAscii(char c2) {
        return c2 < 128;
    }

    public static boolean isAsciiAlpha(char c2) {
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z');
    }

    public static boolean isAsciiAlphaLower(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c2) {
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || (c2 >= '0' && c2 <= '9');
    }

    public static boolean isAsciiControl(char c2) {
        return c2 < ' ' || c2 == 127;
    }

    public static boolean isAsciiNumeric(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isAsciiPrintable(char c2) {
        return c2 >= ' ' && c2 < 127;
    }

    public static char toChar(Character ch) {
        if (ch != null) {
            return ch.charValue();
        }
        throw new IllegalArgumentException("The Character must not be null");
    }

    public static Character toCharacterObject(char c2) {
        Character[] chArr = CHAR_ARRAY;
        if (c2 < chArr.length) {
            return chArr[c2];
        }
        return new Character(c2);
    }

    public static int toIntValue(char c2) {
        if (isAsciiNumeric(c2)) {
            return c2 - '0';
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The character ");
        stringBuffer.append(c2);
        stringBuffer.append(" is not in the range '0' - '9'");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static String toString(char c2) {
        if (c2 < 128) {
            return CHAR_STRING_ARRAY[c2];
        }
        return new String(new char[]{c2});
    }

    public static String unicodeEscaped(char c2) {
        if (c2 < 16) {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("\\u000");
            outline71.append(Integer.toHexString(c2));
            return outline71.toString();
        } else if (c2 < 256) {
            StringBuffer outline712 = GeneratedOutlineSupport.outline71("\\u00");
            outline712.append(Integer.toHexString(c2));
            return outline712.toString();
        } else if (c2 < 4096) {
            StringBuffer outline713 = GeneratedOutlineSupport.outline71("\\u0");
            outline713.append(Integer.toHexString(c2));
            return outline713.toString();
        } else {
            StringBuffer outline714 = GeneratedOutlineSupport.outline71("\\u");
            outline714.append(Integer.toHexString(c2));
            return outline714.toString();
        }
    }

    public static char toChar(Character ch, char c2) {
        return ch == null ? c2 : ch.charValue();
    }

    public static int toIntValue(char c2, int i) {
        return !isAsciiNumeric(c2) ? i : c2 - '0';
    }

    public static String toString(Character ch) {
        if (ch == null) {
            return null;
        }
        return toString(ch.charValue());
    }

    public static char toChar(String str) {
        if (!StringUtils.isEmpty(str)) {
            return str.charAt(0);
        }
        throw new IllegalArgumentException("The String must not be empty");
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return toCharacterObject(str.charAt(0));
    }

    public static int toIntValue(Character ch) {
        if (ch != null) {
            return toIntValue(ch.charValue());
        }
        throw new IllegalArgumentException("The character must not be null");
    }

    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }

    public static int toIntValue(Character ch, int i) {
        return ch == null ? i : toIntValue(ch.charValue(), i);
    }

    public static char toChar(String str, char c2) {
        if (StringUtils.isEmpty(str)) {
            return c2;
        }
        return str.charAt(0);
    }
}
