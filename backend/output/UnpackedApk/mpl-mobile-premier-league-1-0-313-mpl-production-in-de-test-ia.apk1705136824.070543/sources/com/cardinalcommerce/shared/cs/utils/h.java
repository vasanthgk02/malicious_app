package com.cardinalcommerce.shared.cs.utils;

import java.util.Arrays;

public abstract class h {
    public static boolean a(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }

    public static char[] a(String str) {
        return (str == null || str.isEmpty()) ? new char[0] : str.toCharArray();
    }

    public static String b(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        return new String(cArr);
    }

    public static char[] c(char[] cArr) {
        if (a(cArr)) {
            return new char[0];
        }
        Arrays.fill(cArr, '0');
        return cArr;
    }
}
