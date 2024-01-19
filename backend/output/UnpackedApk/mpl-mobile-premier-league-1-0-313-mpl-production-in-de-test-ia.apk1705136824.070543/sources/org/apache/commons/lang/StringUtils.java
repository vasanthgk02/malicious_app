package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.fontbox.cmap.CMap;

public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final int PAD_LIMIT = 8192;

    public static String abbreviate(String str, int i) {
        return abbreviate(str, 0, i);
    }

    public static String capitalise(String str) {
        return capitalize(str);
    }

    public static String capitaliseAllWords(String str) {
        return WordUtils.capitalize(str);
    }

    public static String capitalize(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        stringBuffer.append(Character.toTitleCase(str.charAt(0)));
        stringBuffer.append(str.substring(1));
        return stringBuffer.toString();
    }

    public static String center(String str, int i) {
        return center(str, i, ' ');
    }

    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            return (charAt == 13 || charAt == 10) ? "" : str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == 10) {
            if (str.charAt(length - 1) == 13) {
                length--;
            }
        } else if (charAt2 != 13) {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chompLast(String str) {
        return chompLast(str, "\n");
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i = length - 1;
        String substring = str.substring(0, i);
        if (str.charAt(i) == 10) {
            int i2 = i - 1;
            if (substring.charAt(i2) == 13) {
                return substring.substring(0, i2);
            }
        }
        return substring;
    }

    public static String chopNewline(String str) {
        int length = str.length() - 1;
        if (length <= 0) {
            return "";
        }
        if (str.charAt(length) != 10) {
            length++;
        } else if (str.charAt(length - 1) == 13) {
            length--;
        }
        return str.substring(0, length);
    }

    public static String clean(String str) {
        return str == null ? "" : str.trim();
    }

    public static String concatenate(Object[] objArr) {
        return join(objArr, (String) null);
    }

    public static boolean contains(String str, char c2) {
        boolean z = false;
        if (isEmpty(str)) {
            return false;
        }
        if (str.indexOf(c2) >= 0) {
            z = true;
        }
        return z;
    }

    public static boolean containsAny(String str, char[] cArr) {
        if (!(str == null || str.length() == 0 || cArr == null || cArr.length == 0)) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                for (char c2 : cArr) {
                    if (c2 == charAt) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return contains(str.toUpperCase(), str2.toUpperCase());
    }

    public static boolean containsNone(String str, char[] cArr) {
        if (!(str == null || cArr == null)) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                for (char c2 : cArr) {
                    if (c2 == charAt) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsOnly(String str, char[] cArr) {
        boolean z = false;
        if (!(cArr == null || str == null)) {
            if (str.length() == 0) {
                return true;
            }
            if (cArr.length == 0) {
                return false;
            }
            if (indexOfAnyBut(str, cArr) == -1) {
                z = true;
            }
        }
        return z;
    }

    public static int countMatches(String str, String str2) {
        int i = 0;
        if (isEmpty(str) || isEmpty(str2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf == -1) {
                return i2;
            }
            i2++;
            i = indexOf + str2.length();
        }
    }

    public static String defaultIfEmpty(String str, String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String deleteSpaces(String str) {
        if (str == null) {
            return null;
        }
        return CharSetUtils.delete(str, (String) " \t\r\n\b");
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        if (i == length) {
            return str;
        }
        return new String(cArr, 0, i);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static boolean endsWith(String str, String str2) {
        return endsWith(str, str2, false);
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        return endsWith(str, str2, true);
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static String escape(String str) {
        return StringEscapeUtils.escapeJava(str);
    }

    public static String getChomp(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf == str.length() - str2.length()) {
            return str2;
        }
        return lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
    }

    public static String getCommonPrefix(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        if (indexOfDifference == -1) {
            if (strArr[0] == null) {
                return "";
            }
            return strArr[0];
        } else if (indexOfDifference == 0) {
            return "";
        } else {
            return strArr[0].substring(0, indexOfDifference);
        }
    }

    public static int getLevenshteinDistance(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            int i = length2;
            length2 = str.length();
            length = i;
        } else {
            String str3 = str2;
            str2 = str;
            str = str3;
        }
        int i2 = length + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 <= length; i3++) {
            iArr[i3] = i3;
        }
        int i4 = 1;
        while (i4 <= length2) {
            char charAt = str.charAt(i4 - 1);
            iArr2[0] = i4;
            for (int i5 = 1; i5 <= length; i5++) {
                int i6 = i5 - 1;
                iArr2[i5] = Math.min(Math.min(iArr2[i6] + 1, iArr[i5] + 1), iArr[i6] + (str2.charAt(i6) == charAt ? 0 : 1));
            }
            i4++;
            int[] iArr3 = iArr;
            iArr = iArr2;
            iArr2 = iArr3;
        }
        return iArr[length];
    }

    public static String getNestedString(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String getPrechomp(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return "";
        }
        return str.substring(0, str2.length() + indexOf);
    }

    public static int indexOf(String str, char c2) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.indexOf(c2);
    }

    public static int indexOfAny(String str, char[] cArr) {
        if (!isEmpty(str) && !ArrayUtils.isEmpty(cArr)) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                for (char c2 : cArr) {
                    if (c2 == charAt) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOfAnyBut(String str, char[] cArr) {
        if (!isEmpty(str) && !ArrayUtils.isEmpty(cArr)) {
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                int i2 = 0;
                while (i2 < cArr.length) {
                    if (cArr[i2] == charAt) {
                        i++;
                    } else {
                        i2++;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public static int indexOfDifference(String str, String str2) {
        if (str == str2) {
            return -1;
        }
        int i = 0;
        if (!(str == null || str2 == null)) {
            while (i < str.length() && i < str2.length() && str.charAt(i) == str2.charAt(i)) {
                i++;
            }
            if (i < str2.length() || i < str.length()) {
                return i;
            }
            return -1;
        }
        return i;
    }

    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAsciiPrintable(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!CharUtils.isAsciiPrintable(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String join(Object[] objArr) {
        return join(objArr, (String) null);
    }

    public static int lastIndexOf(String str, char c2) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.lastIndexOf(c2);
    }

    public static int lastIndexOfAny(String str, String[] strArr) {
        int i = -1;
        if (!(str == null || strArr == null)) {
            for (String str2 : strArr) {
                if (str2 != null) {
                    int lastIndexOf = str.lastIndexOf(str2);
                    if (lastIndexOf > i) {
                        i = lastIndexOf;
                    }
                }
            }
        }
        return i;
    }

    public static String left(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i);
    }

    public static String leftPad(String str, int i) {
        return leftPad(str, i, ' ');
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String mid(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0 || i > str.length()) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        int i3 = i2 + i;
        if (str.length() <= i3) {
            return str.substring(i);
        }
        return str.substring(i, i3);
    }

    public static int ordinalIndexOf(String str, String str2, int i) {
        int i2 = -1;
        if (str == null || str2 == null || i <= 0) {
            return i2;
        }
        int i3 = 0;
        if (str2.length() == 0) {
            return 0;
        }
        do {
            i2 = str.indexOf(str2, i2 + 1);
            if (i2 < 0) {
                return i2;
            }
            i3++;
        } while (i3 < i);
        return i2;
    }

    public static String overlay(String str, String str2, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i < 0) {
            i = 0;
        }
        if (i > length) {
            i = length;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > length) {
            i2 = length;
        }
        if (i > i2) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        StringBuffer stringBuffer = new StringBuffer(str2.length() + ((length + i) - i2) + 1);
        stringBuffer.append(str.substring(0, i));
        stringBuffer.append(str2);
        stringBuffer.append(str.substring(i2));
        return stringBuffer.toString();
    }

    public static String overlayString(String str, String str2, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(((str.length() + (str2.length() + i)) - i2) + 1);
        stringBuffer.append(str.substring(0, i));
        stringBuffer.append(str2);
        stringBuffer.append(str.substring(i2));
        return stringBuffer.toString();
    }

    public static String padding(int i, char c2) throws IndexOutOfBoundsException {
        if (i >= 0) {
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = c2;
            }
            return new String(cArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot pad a negative amount: ");
        stringBuffer.append(i);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    public static String prechomp(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(str2.length() + indexOf);
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static String removeEnd(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeStart(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) ? str : str.substring(str2.length());
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (!(i == 1 || length == 0)) {
            if (length == 1 && i <= 8192) {
                return padding(i, str.charAt(0));
            }
            int i2 = length * i;
            if (length == 1) {
                char charAt = str.charAt(0);
                char[] cArr = new char[i2];
                for (int i3 = i - 1; i3 >= 0; i3--) {
                    cArr[i3] = charAt;
                }
                str = new String(cArr);
            } else if (length != 2) {
                StringBuffer stringBuffer = new StringBuffer(i2);
                for (int i4 = 0; i4 < i; i4++) {
                    stringBuffer.append(str);
                }
                return stringBuffer.toString();
            } else {
                char charAt2 = str.charAt(0);
                char charAt3 = str.charAt(1);
                char[] cArr2 = new char[i2];
                for (int i5 = (i * 2) - 2; i5 >= 0; i5 = (i5 - 1) - 1) {
                    cArr2[i5] = charAt2;
                    cArr2[i5 + 1] = charAt3;
                }
                return new String(cArr2);
            }
        }
        return str;
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replaceChars(String str, char c2, char c3) {
        if (str == null) {
            return null;
        }
        return str.replace(c2, c3);
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c2) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c2);
        ArrayUtils.reverse((Object[]) split);
        return join((Object[]) split, c2);
    }

    public static String reverseDelimitedString(String str, String str2) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, str2);
        ArrayUtils.reverse((Object[]) split);
        if (str2 == null) {
            return join((Object[]) split, ' ');
        }
        return join((Object[]) split, str2);
    }

    public static String right(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(str.length() - i);
    }

    public static String rightPad(String str, int i) {
        return rightPad(str, i, ' ');
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    public static String[] splitByWholeSeparatorWorker(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, null, i, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            i2 = str.indexOf(str2, i3);
            if (i2 > -1) {
                if (i2 > i3) {
                    i4++;
                    if (i4 == i) {
                        arrayList.add(str.substring(i3));
                    } else {
                        arrayList.add(str.substring(i3, i2));
                    }
                } else if (z) {
                    i4++;
                    if (i4 == i) {
                        arrayList.add(str.substring(i3));
                        i2 = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i3 = i2 + length2;
            } else {
                arrayList.add(str.substring(i3));
            }
            i2 = length;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, null, -1, true);
    }

    public static String[] splitWorker(String str, char c2, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i < length) {
            if (str.charAt(i) == c2) {
                if (z2 || z) {
                    arrayList.add(str.substring(i2, i));
                    z2 = false;
                    z3 = true;
                }
                i2 = i + 1;
                i = i2;
            } else {
                i++;
                z2 = true;
                z3 = false;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i2, i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean startsWith(String str, String str2) {
        return startsWith(str, str2, false);
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        return startsWith(str, str2, true);
    }

    public static String strip(String str) {
        return strip(str, null);
    }

    public static String[] stripAll(String[] strArr) {
        return stripAll(strArr, null);
    }

    public static String stripEnd(String str, String str2) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                if (str2 == null) {
                    while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                        length--;
                    }
                } else if (str2.length() == 0) {
                    return str;
                } else {
                    while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                        length--;
                    }
                }
                str = str.substring(0, length);
            }
        }
        return str;
    }

    public static String stripStart(String str, String str2) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                int i = 0;
                if (str2 == null) {
                    while (i != length && Character.isWhitespace(str.charAt(i))) {
                        i++;
                    }
                } else if (str2.length() == 0) {
                    return str;
                } else {
                    while (i != length && str2.indexOf(str.charAt(i)) != -1) {
                        i++;
                    }
                }
                str = str.substring(i);
            }
        }
        return str;
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, null);
    }

    public static String stripToNull(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String strip = strip(str, null);
        if (strip.length() != 0) {
            str2 = strip;
        }
        return str2;
    }

    public static String substring(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            i += str.length();
        }
        if (i < 0) {
            i = 0;
        }
        if (i > str.length()) {
            return "";
        }
        return str.substring(i);
    }

    public static String substringAfter(String str, String str2) {
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return "";
        }
        return str.substring(str2.length() + indexOf);
    }

    public static String substringAfterLast(String str, String str2) {
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(str2)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(str2.length() + lastIndexOf);
    }

    public static String substringBefore(String str, String str2) {
        if (!isEmpty(str) && str2 != null) {
            if (str2.length() == 0) {
                return "";
            }
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return str;
            }
            str = str.substring(0, indexOf);
        }
        return str;
    }

    public static String substringBeforeLast(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2)) {
            int lastIndexOf = str.lastIndexOf(str2);
            if (lastIndexOf == -1) {
                return str;
            }
            str = str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String[] substringsBetween(String str, String str2, String str3) {
        if (str == null || isEmpty(str2) || isEmpty(str3)) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        int length2 = str3.length();
        int length3 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < length - length2) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf < 0) {
                break;
            }
            int i2 = indexOf + length3;
            int indexOf2 = str.indexOf(str3, i2);
            if (indexOf2 < 0) {
                break;
            }
            arrayList.add(str.substring(i2, indexOf2));
            i = indexOf2 + length2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String swapCase(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                charAt = Character.toLowerCase(charAt);
            } else if (Character.isTitleCase(charAt)) {
                charAt = Character.toLowerCase(charAt);
            } else if (Character.isLowerCase(charAt)) {
                charAt = Character.toUpperCase(charAt);
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String uncapitalise(String str) {
        return uncapitalize(str);
    }

    public static String uncapitalize(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        stringBuffer.append(Character.toLowerCase(str.charAt(0)));
        stringBuffer.append(str.substring(1));
        return stringBuffer.toString();
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String abbreviate(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else if (str.length() <= i2) {
            return str;
        } else {
            if (i > str.length()) {
                i = str.length();
            }
            int i3 = i2 - 3;
            if (str.length() - i < i3) {
                i = str.length() - i3;
            }
            if (i <= 4) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str.substring(0, i3));
                stringBuffer.append("...");
                return stringBuffer.toString();
            } else if (i2 < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            } else if (i + i3 < str.length()) {
                StringBuffer outline71 = GeneratedOutlineSupport.outline71("...");
                outline71.append(abbreviate(str.substring(i), i3));
                return outline71.toString();
            } else {
                StringBuffer outline712 = GeneratedOutlineSupport.outline71("...");
                outline712.append(str.substring(str.length() - i3));
                return outline712.toString();
            }
        }
    }

    public static String center(String str, int i, char c2) {
        if (str != null && i > 0) {
            int length = str.length();
            int i2 = i - length;
            if (i2 <= 0) {
                return str;
            }
            str = rightPad(leftPad(str, (i2 / 2) + length, c2), i, c2);
        }
        return str;
    }

    public static String chompLast(String str, String str2) {
        if (str.length() == 0) {
            return str;
        }
        if (str2.equals(str.substring(str.length() - str2.length()))) {
            str = str.substring(0, str.length() - str2.length());
        }
        return str;
    }

    public static boolean endsWith(String str, String str2, boolean z) {
        boolean z2 = false;
        if (str == null || str2 == null) {
            if (str == null && str2 == null) {
                z2 = true;
            }
            return z2;
        } else if (str2.length() > str.length()) {
            return false;
        } else {
            return str.regionMatches(z, str.length() - str2.length(), str2, 0, str2.length());
        }
    }

    public static String getNestedString(String str, String str2, String str3) {
        return substringBetween(str, str2, str3);
    }

    public static String join(Object[] objArr, char c2) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c2, 0, objArr.length);
    }

    public static String leftPad(String str, int i, char c2) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i, String.valueOf(c2));
        }
        return padding(length, c2).concat(str);
    }

    public static String replace(String str, String str2, String str3, int i) {
        if (!isEmpty(str) && !isEmpty(str2) && str3 != null && i != 0) {
            int i2 = 0;
            int indexOf = str.indexOf(str2, 0);
            if (indexOf == -1) {
                return str;
            }
            int length = str2.length();
            int length2 = str3.length() - length;
            if (length2 < 0) {
                length2 = 0;
            }
            int i3 = 64;
            if (i < 0) {
                i3 = 16;
            } else if (i <= 64) {
                i3 = i;
            }
            StringBuffer stringBuffer = new StringBuffer(str.length() + (length2 * i3));
            while (indexOf != -1) {
                stringBuffer.append(str.substring(i2, indexOf));
                stringBuffer.append(str3);
                i2 = indexOf + length;
                i--;
                if (i == 0) {
                    break;
                }
                indexOf = str.indexOf(str2, i2);
            }
            stringBuffer.append(str.substring(i2));
            str = stringBuffer.toString();
        }
        return str;
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuffer stringBuffer = new StringBuffer(length2);
        boolean z = false;
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                if (indexOf < length) {
                    stringBuffer.append(str3.charAt(indexOf));
                }
                z = true;
            } else {
                stringBuffer.append(charAt);
            }
        }
        return z ? stringBuffer.toString() : str;
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        if (str == null || str.length() == 0 || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i >= 0) {
            int length = strArr.length;
            int length2 = strArr2.length;
            if (length == length2) {
                boolean[] zArr = new boolean[length];
                int i2 = -1;
                int i3 = -1;
                for (int i4 = 0; i4 < length; i4++) {
                    if (!(zArr[i4] || strArr[i4] == null || strArr[i4].length() == 0 || strArr2[i4] == null)) {
                        int indexOf = str.indexOf(strArr[i4]);
                        if (indexOf == -1) {
                            zArr[i4] = true;
                        } else if (i2 == -1 || indexOf < i2) {
                            i3 = i4;
                            i2 = indexOf;
                        }
                    }
                }
                if (i2 == -1) {
                    return str;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < strArr.length; i6++) {
                    int length3 = strArr2[i6].length() - strArr[i6].length();
                    if (length3 > 0) {
                        i5 += length3 * 3;
                    }
                }
                StringBuffer stringBuffer = new StringBuffer(str.length() + Math.min(i5, str.length() / 5));
                int i7 = 0;
                while (i2 != -1) {
                    while (i7 < i2) {
                        stringBuffer.append(str.charAt(i7));
                        i7++;
                    }
                    stringBuffer.append(strArr2[i3]);
                    i7 = strArr[i3].length() + i2;
                    i2 = -1;
                    i3 = -1;
                    for (int i8 = 0; i8 < length; i8++) {
                        if (!(zArr[i8] || strArr[i8] == null || strArr[i8].length() == 0 || strArr2[i8] == null)) {
                            int indexOf2 = str.indexOf(strArr[i8], i7);
                            if (indexOf2 == -1) {
                                zArr[i8] = true;
                            } else if (i2 == -1 || indexOf2 < i2) {
                                i3 = i8;
                                i2 = indexOf2;
                            }
                        }
                    }
                }
                int length4 = str.length();
                while (i7 < length4) {
                    stringBuffer.append(str.charAt(i7));
                    i7++;
                }
                String stringBuffer2 = stringBuffer.toString();
                if (!z) {
                    return stringBuffer2;
                }
                return replaceEach(stringBuffer2, strArr, strArr2, z, i - 1);
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Search and Replace array lengths don't match: ");
            stringBuffer3.append(length);
            stringBuffer3.append(" vs ");
            stringBuffer3.append(length2);
            throw new IllegalArgumentException(stringBuffer3.toString());
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("TimeToLive of ");
        stringBuffer4.append(i);
        stringBuffer4.append(" is less than 0: ");
        stringBuffer4.append(str);
        throw new IllegalStateException(stringBuffer4.toString());
    }

    public static String rightPad(String str, int i, char c2) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i, String.valueOf(c2));
        }
        return str.concat(padding(length, c2));
    }

    public static String[] split(String str, char c2) {
        return splitWorker(str, c2, false);
    }

    public static String[] splitByCharacterType(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int type = Character.getType(charArray[0]);
        for (int i2 = 1; i2 < charArray.length; i2++) {
            int type2 = Character.getType(charArray[i2]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i3 = i2 - 1;
                    if (i3 != i) {
                        arrayList.add(new String(charArray, i, i3 - i));
                        i = i3;
                    }
                } else {
                    arrayList.add(new String(charArray, i, i2 - i));
                    i = i2;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c2) {
        return splitWorker(str, c2, true);
    }

    public static boolean startsWith(String str, String str2, boolean z) {
        boolean z2 = false;
        if (str == null || str2 == null) {
            if (str == null && str2 == null) {
                z2 = true;
            }
            return z2;
        } else if (str2.length() > str.length()) {
            return false;
        } else {
            return str.regionMatches(z, 0, str2, 0, str2.length());
        }
    }

    public static String strip(String str, String str2) {
        if (isEmpty(str)) {
            return str;
        }
        return stripEnd(stripStart(str, str2), str2);
    }

    public static String[] stripAll(String[] strArr, String str) {
        if (strArr != null) {
            int length = strArr.length;
            if (length != 0) {
                String[] strArr2 = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr2[i] = strip(strArr[i], str);
                }
                return strArr2;
            }
        }
        return strArr;
    }

    public static String substringBetween(String str, String str2, String str3) {
        if (!(str == null || str2 == null || str3 == null)) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                int indexOf2 = str.indexOf(str3, str2.length() + indexOf);
                if (indexOf2 != -1) {
                    return str.substring(str2.length() + indexOf, indexOf2);
                }
            }
        }
        return null;
    }

    public static boolean contains(String str, String str2) {
        return (str == null || str2 == null || str.indexOf(str2) < 0) ? false : true;
    }

    public static int indexOf(String str, char c2, int i) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.indexOf(c2, i);
    }

    public static String join(Object[] objArr, char c2, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(((objArr[i] == null ? 16 : objArr[i].toString().length()) + 1) * i3);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                stringBuffer.append(c2);
            }
            if (objArr[i4] != null) {
                stringBuffer.append(objArr[i4]);
            }
        }
        return stringBuffer.toString();
    }

    public static int lastIndexOf(String str, char c2, int i) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.lastIndexOf(c2, i);
    }

    public static String remove(String str, char c2) {
        if (isEmpty(str) || str.indexOf(c2) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] != c2) {
                charArray[i] = charArray[i2];
                i++;
            }
        }
        return new String(charArray, 0, i);
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static boolean containsOnly(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return containsOnly(str, str2.toCharArray());
    }

    public static int indexOfDifference(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            int length = strArr.length;
            int i = Integer.MAX_VALUE;
            boolean z = true;
            int i2 = 0;
            boolean z2 = false;
            for (int i3 = 0; i3 < length; i3++) {
                if (strArr[i3] == null) {
                    i = 0;
                    z2 = true;
                } else {
                    i = Math.min(strArr[i3].length(), i);
                    i2 = Math.max(strArr[i3].length(), i2);
                    z = false;
                }
            }
            if (!z && (i2 != 0 || z2)) {
                if (i == 0) {
                    return 0;
                }
                int i4 = -1;
                for (int i5 = 0; i5 < i; i5++) {
                    char charAt = strArr[0].charAt(i5);
                    int i6 = 1;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (strArr[i6].charAt(i5) != charAt) {
                            i4 = i5;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (i4 != -1) {
                        break;
                    }
                }
                return (i4 != -1 || i == i2) ? i4 : i;
            }
        }
        return -1;
    }

    public static String[] split(String str, String str2, int i) {
        return splitWorker(str, str2, i, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i) {
        return splitWorker(str, str2, i, true);
    }

    public static String substring(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i < 0) {
            i += str.length();
        }
        if (i2 > str.length()) {
            i2 = str.length();
        }
        if (i > i2) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return str.substring(i, i2);
    }

    public static String center(String str, int i, String str2) {
        if (str != null && i > 0) {
            if (isEmpty(str2)) {
                str2 = CMap.SPACE;
            }
            int length = str.length();
            int i2 = i - length;
            if (i2 <= 0) {
                return str;
            }
            str = rightPad(leftPad(str, (i2 / 2) + length, str2), i, str2);
        }
        return str;
    }

    public static boolean containsNone(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        return containsNone(str, str2.toCharArray());
    }

    public static int indexOf(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.indexOf(str2);
    }

    public static int lastIndexOf(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.lastIndexOf(str2);
    }

    public static String leftPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = CMap.SPACE;
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String rightPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = CMap.SPACE;
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return str.concat(new String(cArr));
    }

    public static boolean containsAny(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        return containsAny(str, str2.toCharArray());
    }

    public static int indexOf(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return -1;
        }
        if (str2.length() != 0 || i < str.length()) {
            return str.indexOf(str2, i);
        }
        return str.length();
    }

    public static int indexOfAny(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return -1;
        }
        return indexOfAny(str, str2.toCharArray());
    }

    public static int indexOfAnyBut(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2)) {
            for (int i = 0; i < str.length(); i++) {
                if (str2.indexOf(str.charAt(i)) < 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int lastIndexOf(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.lastIndexOf(str2, i);
    }

    public static String chomp(String str, String str2) {
        return (isEmpty(str) || str2 == null || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static int indexOfAny(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return -1;
        }
        int i = Integer.MAX_VALUE;
        for (String str2 : strArr) {
            if (str2 != null) {
                int indexOf = str.indexOf(str2);
                if (indexOf != -1 && indexOf < i) {
                    i = indexOf;
                }
            }
        }
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static String[] splitWorker(String str, String str2, int i, boolean z) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        boolean z6;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i2 = 0;
            z3 = false;
            z2 = false;
            i3 = 0;
            int i6 = 1;
            while (i2 < length) {
                if (Character.isWhitespace(str.charAt(i2))) {
                    if (z3 || z) {
                        int i7 = i6 + 1;
                        if (i6 == i) {
                            i2 = length;
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i3, i2));
                        i6 = i7;
                        z3 = false;
                    }
                    i3 = i2 + 1;
                    i2 = i3;
                } else {
                    i2++;
                    z3 = true;
                    z2 = false;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i5 = 0;
                z5 = false;
                z4 = false;
                i4 = 0;
                int i8 = 1;
                while (i5 < length) {
                    if (str.charAt(i5) == charAt) {
                        if (z5 || z) {
                            int i9 = i8 + 1;
                            if (i8 == i) {
                                i5 = length;
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            arrayList.add(str.substring(i4, i5));
                            i8 = i9;
                            z5 = false;
                        }
                        i4 = i5 + 1;
                        i5 = i4;
                    } else {
                        i5++;
                        z5 = true;
                        z4 = false;
                    }
                }
            } else {
                int i10 = 0;
                z5 = false;
                z4 = false;
                i4 = 0;
                int i11 = 1;
                while (i5 < length) {
                    if (str2.indexOf(str.charAt(i5)) >= 0) {
                        if (z5 || z) {
                            int i12 = i11 + 1;
                            if (i11 == i) {
                                i5 = length;
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            arrayList.add(str.substring(i4, i5));
                            i11 = i12;
                            z5 = false;
                        }
                        i4 = i5 + 1;
                        i10 = i4;
                    } else {
                        i10 = i5 + 1;
                        z5 = true;
                        z4 = false;
                    }
                }
            }
            i2 = i5;
            z3 = z5;
            z2 = z4;
            i3 = i4;
        }
        if (z3 || (z && z2)) {
            arrayList.add(str.substring(i3, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer((str.length() + (objArr[i] == null ? 16 : objArr[i].toString().length())) * i3);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                stringBuffer.append(str);
            }
            if (objArr[i4] != null) {
                stringBuffer.append(objArr[i4]);
            }
        }
        return stringBuffer.toString();
    }

    public static String join(Iterator it, char c2) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            stringBuffer.append(c2);
            Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    public static String join(Iterator it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    public static String join(Collection collection, char c2) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), c2);
    }

    public static String join(Collection collection, String str) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), str);
    }
}
