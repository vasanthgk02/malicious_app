package org.apache.commons.lang;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class NumberUtils {
    public static int compare(double d2, double d3) {
        if (d2 < d3) {
            return -1;
        }
        if (d2 > d3) {
            return 1;
        }
        int i = (Double.doubleToLongBits(d2) > Double.doubleToLongBits(d3) ? 1 : (Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3) ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public static BigDecimal createBigDecimal(String str) {
        return new BigDecimal(str);
    }

    public static BigInteger createBigInteger(String str) {
        return new BigInteger(str);
    }

    public static Double createDouble(String str) {
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        return Long.valueOf(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:102|(1:106)|107|108|(1:114)|115|116|(1:122)|123|125) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:96|97|98) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:(1:30)|31|(1:36)(1:35)|37|(5:39|(3:41|(2:43|(2:45|(1:47)))|(2:63|64)(3:57|58|59))|65|66|(1:72))|73|74|(1:80)|(3:81|82|83)) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x014c, code lost:
        return createBigInteger(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bc, code lost:
        if (r1 == 'l') goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0147, code lost:
        return createLong(r13);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x0170 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0103 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0119 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:96:0x0143 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Number createNumber(java.lang.String r13) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            if (r13 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r13.length()
            if (r1 == 0) goto L_0x018f
            java.lang.String r1 = "--"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x0013
            return r0
        L_0x0013:
            java.lang.String r1 = "0x"
            boolean r1 = r13.startsWith(r1)
            if (r1 != 0) goto L_0x018a
            java.lang.String r1 = "-0x"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x018a
        L_0x0025:
            int r1 = r13.length()
            r2 = 1
            int r1 = r1 - r2
            char r1 = r13.charAt(r1)
            r3 = 46
            int r3 = r13.indexOf(r3)
            r4 = 101(0x65, float:1.42E-43)
            int r4 = r13.indexOf(r4)
            r5 = 69
            int r5 = r13.indexOf(r5)
            int r5 = r5 + r4
            int r5 = r5 + r2
            java.lang.String r4 = " is not a valid number."
            r6 = -1
            r7 = 0
            if (r3 <= r6) goto L_0x0069
            if (r5 <= r6) goto L_0x005e
            if (r5 < r3) goto L_0x0054
            int r8 = r3 + 1
            java.lang.String r8 = r13.substring(r8, r5)
            goto L_0x0064
        L_0x0054:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = com.android.tools.r8.GeneratedOutlineSupport.outline49(r13, r4)
            r0.<init>(r13)
            throw r0
        L_0x005e:
            int r8 = r3 + 1
            java.lang.String r8 = r13.substring(r8)
        L_0x0064:
            java.lang.String r3 = r13.substring(r7, r3)
            goto L_0x0072
        L_0x0069:
            if (r5 <= r6) goto L_0x0070
            java.lang.String r3 = r13.substring(r7, r5)
            goto L_0x0071
        L_0x0070:
            r3 = r13
        L_0x0071:
            r8 = r0
        L_0x0072:
            boolean r9 = java.lang.Character.isDigit(r1)
            r10 = 0
            r11 = 0
            if (r9 != 0) goto L_0x0128
            if (r5 <= r6) goto L_0x008e
            int r6 = r13.length()
            int r6 = r6 - r2
            if (r5 >= r6) goto L_0x008e
            int r5 = r5 + r2
            int r0 = r13.length()
            int r0 = r0 - r2
            java.lang.String r0 = r13.substring(r5, r0)
        L_0x008e:
            int r5 = r13.length()
            int r5 = r5 - r2
            java.lang.String r5 = r13.substring(r7, r5)
            boolean r3 = isAllZeros(r3)
            if (r3 == 0) goto L_0x00a5
            boolean r3 = isAllZeros(r0)
            if (r3 == 0) goto L_0x00a5
            r3 = 1
            goto L_0x00a6
        L_0x00a5:
            r3 = 0
        L_0x00a6:
            r6 = 68
            if (r1 == r6) goto L_0x0103
            r6 = 70
            if (r1 == r6) goto L_0x00ee
            r6 = 76
            if (r1 == r6) goto L_0x00be
            r6 = 100
            if (r1 == r6) goto L_0x0103
            r6 = 102(0x66, float:1.43E-43)
            if (r1 == r6) goto L_0x00ee
            r3 = 108(0x6c, float:1.51E-43)
            if (r1 != r3) goto L_0x011e
        L_0x00be:
            if (r8 != 0) goto L_0x00e4
            if (r0 != 0) goto L_0x00e4
            char r0 = r5.charAt(r7)
            r1 = 45
            if (r0 != r1) goto L_0x00d4
            java.lang.String r0 = r5.substring(r2)
            boolean r0 = isDigits(r0)
            if (r0 != 0) goto L_0x00da
        L_0x00d4:
            boolean r0 = isDigits(r5)
            if (r0 == 0) goto L_0x00e4
        L_0x00da:
            java.lang.Long r13 = createLong(r5)     // Catch:{ NumberFormatException -> 0x00df }
            return r13
        L_0x00df:
            java.math.BigInteger r13 = createBigInteger(r5)
            return r13
        L_0x00e4:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = com.android.tools.r8.GeneratedOutlineSupport.outline49(r13, r4)
            r0.<init>(r13)
            throw r0
        L_0x00ee:
            java.lang.Float r0 = createFloat(r5)     // Catch:{ NumberFormatException -> 0x0103 }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x0103 }
            if (r1 != 0) goto L_0x0103
            float r1 = r0.floatValue()     // Catch:{ NumberFormatException -> 0x0103 }
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x0102
            if (r3 == 0) goto L_0x0103
        L_0x0102:
            return r0
        L_0x0103:
            java.lang.Double r0 = createDouble(r5)     // Catch:{ NumberFormatException -> 0x0119 }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x0119 }
            if (r1 != 0) goto L_0x0119
            float r1 = r0.floatValue()     // Catch:{ NumberFormatException -> 0x0119 }
            double r1 = (double) r1
            int r6 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x0118
            if (r3 == 0) goto L_0x0119
        L_0x0118:
            return r0
        L_0x0119:
            java.math.BigDecimal r13 = createBigDecimal(r5)     // Catch:{ NumberFormatException -> 0x011e }
            return r13
        L_0x011e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = com.android.tools.r8.GeneratedOutlineSupport.outline49(r13, r4)
            r0.<init>(r13)
            throw r0
        L_0x0128:
            if (r5 <= r6) goto L_0x013a
            int r1 = r13.length()
            int r1 = r1 - r2
            if (r5 >= r1) goto L_0x013a
            int r5 = r5 + r2
            int r0 = r13.length()
            java.lang.String r0 = r13.substring(r5, r0)
        L_0x013a:
            if (r8 != 0) goto L_0x014d
            if (r0 != 0) goto L_0x014d
            java.lang.Integer r13 = createInteger(r13)     // Catch:{ NumberFormatException -> 0x0143 }
            return r13
        L_0x0143:
            java.lang.Long r13 = createLong(r13)     // Catch:{ NumberFormatException -> 0x0148 }
            return r13
        L_0x0148:
            java.math.BigInteger r13 = createBigInteger(r13)
            return r13
        L_0x014d:
            boolean r1 = isAllZeros(r3)
            if (r1 == 0) goto L_0x015a
            boolean r0 = isAllZeros(r0)
            if (r0 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r2 = 0
        L_0x015b:
            java.lang.Float r0 = createFloat(r13)     // Catch:{ NumberFormatException -> 0x0170 }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x0170 }
            if (r1 != 0) goto L_0x0170
            float r1 = r0.floatValue()     // Catch:{ NumberFormatException -> 0x0170 }
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x016f
            if (r2 == 0) goto L_0x0170
        L_0x016f:
            return r0
        L_0x0170:
            java.lang.Double r0 = createDouble(r13)     // Catch:{ NumberFormatException -> 0x0185 }
            boolean r1 = r0.isInfinite()     // Catch:{ NumberFormatException -> 0x0185 }
            if (r1 != 0) goto L_0x0185
            double r3 = r0.doubleValue()     // Catch:{ NumberFormatException -> 0x0185 }
            int r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0184
            if (r2 == 0) goto L_0x0185
        L_0x0184:
            return r0
        L_0x0185:
            java.math.BigDecimal r13 = createBigDecimal(r13)
            return r13
        L_0x018a:
            java.lang.Integer r13 = createInteger(r13)
            return r13
        L_0x018f:
            java.lang.NumberFormatException r13 = new java.lang.NumberFormatException
            java.lang.String r0 = "\"\" is not a valid number."
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    public static boolean isAllZeros(String str) {
        boolean z = true;
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() <= 0) {
            z = false;
        }
        return z;
    }

    public static boolean isDigits(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        boolean z = false;
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z2 = true;
        int i = charArray[0] == '-' ? 1 : 0;
        int i2 = i + 1;
        if (length > i2 && charArray[i] == '0' && charArray[i2] == 'x') {
            int i3 = i + 2;
            if (i3 == length) {
                return false;
            }
            while (i3 < charArray.length) {
                if ((charArray[i3] < '0' || charArray[i3] > '9') && ((charArray[i3] < 'a' || charArray[i3] > 'f') && (charArray[i3] < 'A' || charArray[i3] > 'F'))) {
                    return false;
                }
                i3++;
            }
            return true;
        }
        int i4 = length - 1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i < i4 || (i < i4 + 1 && z3 && !z4)) {
                if (charArray[i] >= '0' && charArray[i] <= '9') {
                    z3 = false;
                    z4 = true;
                } else if (charArray[i] == '.') {
                    if (z6 || z5) {
                        return false;
                    }
                    z6 = true;
                } else if (charArray[i] != 'e' && charArray[i] != 'E') {
                    if (charArray[i] != '+') {
                        if (charArray[i] != '-') {
                            return false;
                        }
                    }
                    if (!z3) {
                        return false;
                    }
                    z3 = false;
                    z4 = false;
                } else if (z5 || !z4) {
                    return false;
                } else {
                    z3 = true;
                    z5 = true;
                }
                i++;
                z2 = true;
            }
        }
        if (i >= charArray.length) {
            if (!z3 && z4) {
                z = true;
            }
            return z;
        } else if (charArray[i] >= '0' && charArray[i] <= '9') {
            return z2;
        } else {
            if (!(charArray[i] == 'e' || charArray[i] == 'E')) {
                if (!z3 && (charArray[i] == 'd' || charArray[i] == 'D' || charArray[i] == 'f' || charArray[i] == 'F')) {
                    return z4;
                }
                if (charArray[i] != 'l' && charArray[i] != 'L') {
                    return false;
                }
                if (z4 && !z5) {
                    z = true;
                }
            }
            return z;
        }
    }

    public static int maximum(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long maximum(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static int minimum(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long minimum(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static int stringToInt(String str) {
        return stringToInt(str, 0);
    }

    public static int stringToInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static int compare(float f2, float f3) {
        if (f2 < f3) {
            return -1;
        }
        if (f2 > f3) {
            return 1;
        }
        int floatToIntBits = Float.floatToIntBits(f2);
        int floatToIntBits2 = Float.floatToIntBits(f3);
        if (floatToIntBits == floatToIntBits2) {
            return 0;
        }
        return floatToIntBits < floatToIntBits2 ? -1 : 1;
    }
}
