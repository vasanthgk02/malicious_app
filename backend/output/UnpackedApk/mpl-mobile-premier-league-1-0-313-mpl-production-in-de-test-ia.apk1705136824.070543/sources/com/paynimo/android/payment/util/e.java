package com.paynimo.android.payment.util;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static int[][] f1440a = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 0, 6, 7, 8, 9, 5}, new int[]{2, 3, 4, 0, 1, 7, 8, 9, 5, 6}, new int[]{3, 4, 0, 1, 2, 8, 9, 5, 6, 7}, new int[]{4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, new int[]{5, 9, 8, 7, 6, 0, 4, 3, 2, 1}, new int[]{6, 5, 9, 8, 7, 1, 0, 4, 3, 2}, new int[]{7, 6, 5, 9, 8, 2, 1, 0, 4, 3}, new int[]{8, 7, 6, 5, 9, 3, 2, 1, 0, 4}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}};

    /* renamed from: b  reason: collision with root package name */
    public static int[][] f1441b = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 5, 7, 6, 2, 8, 3, 0, 9, 4}, new int[]{5, 8, 0, 3, 7, 9, 6, 1, 4, 2}, new int[]{8, 9, 1, 6, 0, 4, 3, 5, 2, 7}, new int[]{9, 4, 5, 3, 1, 2, 6, 8, 7, 0}, new int[]{4, 2, 8, 6, 5, 7, 3, 9, 0, 1}, new int[]{2, 7, 9, 3, 8, 0, 6, 4, 1, 5}, new int[]{7, 0, 4, 6, 9, 1, 3, 2, 5, 8}};

    public static int[] a(String str) {
        int[] iArr = new int[str.length()];
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 1;
            iArr[i] = Integer.parseInt(str.substring(i, i2));
            i = i2;
        }
        return a(iArr);
    }

    public static boolean validateVerhoeff(String str) {
        int[] a2 = a(str);
        int i = 0;
        for (int i2 = 0; i2 < a2.length; i2++) {
            i = f1440a[i][f1441b[i2 % 8][a2[i2]]];
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static int[] a(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        while (i < iArr.length) {
            int i2 = i + 1;
            iArr2[i] = iArr[iArr.length - i2];
            i = i2;
        }
        return iArr2;
    }
}
