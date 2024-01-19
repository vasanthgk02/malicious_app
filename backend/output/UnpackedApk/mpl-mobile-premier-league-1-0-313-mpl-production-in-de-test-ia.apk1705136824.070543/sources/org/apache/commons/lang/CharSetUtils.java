package org.apache.commons.lang;

public class CharSetUtils {
    public static int count(String str, String str2) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return 0;
        }
        return count(str, new String[]{str2});
    }

    public static String delete(String str, String str2) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return str;
        }
        return delete(str, new String[]{str2});
    }

    public static CharSet evaluateSet(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return new CharSet(strArr);
    }

    public static String keep(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0 || StringUtils.isEmpty(str2)) {
            return "";
        }
        return keep(str, new String[]{str2});
    }

    public static String modify(String str, String[] strArr, boolean z) {
        CharSet instance = CharSet.getInstance(strArr);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (instance.contains(charArray[i]) == z) {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static String squeeze(String str, String str2) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return str;
        }
        return squeeze(str, new String[]{str2});
    }

    public static String translate(String str, String str2, String str3) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length());
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = charArray.length;
        int length2 = str3.length() - 1;
        for (int i = 0; i < length; i++) {
            int indexOf = str2.indexOf(charArray[i]);
            if (indexOf != -1) {
                if (indexOf > length2) {
                    indexOf = length2;
                }
                stringBuffer.append(charArray2[indexOf]);
            } else {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    public static int count(String str, String[] strArr) {
        if (StringUtils.isEmpty(str) || ArrayUtils.isEmpty((Object[]) strArr)) {
            return 0;
        }
        CharSet instance = CharSet.getInstance(strArr);
        int i = 0;
        for (char contains : str.toCharArray()) {
            if (instance.contains(contains)) {
                i++;
            }
        }
        return i;
    }

    public static String delete(String str, String[] strArr) {
        return (StringUtils.isEmpty(str) || ArrayUtils.isEmpty((Object[]) strArr)) ? str : modify(str, strArr, false);
    }

    public static String keep(String str, String[] strArr) {
        if (str == null) {
            return null;
        }
        return (str.length() == 0 || ArrayUtils.isEmpty((Object[]) strArr)) ? "" : modify(str, strArr, true);
    }

    public static String squeeze(String str, String[] strArr) {
        if (StringUtils.isEmpty(str) || ArrayUtils.isEmpty((Object[]) strArr)) {
            return str;
        }
        CharSet instance = CharSet.getInstance(strArr);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c2 = ' ';
        for (int i = 0; i < length; i++) {
            char c3 = charArray[i];
            if (!instance.contains(c3) || c3 != c2 || i == 0) {
                stringBuffer.append(c3);
                c2 = c3;
            }
        }
        return stringBuffer.toString();
    }
}
