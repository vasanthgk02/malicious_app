package com.userexperior.a.a.b.a.a;

import java.util.TimeZone;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f3571a = TimeZone.getTimeZone("UTC");

    public static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static int a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i4 = i;
            i3 = 0;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a6 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date a(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            r1 = r18
            r2 = r19
            java.lang.String r3 = "'"
            int r0 = r19.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r4 = r0 + 4
            int r0 = a(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r5 = 45
            boolean r6 = a(r1, r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r6 == 0) goto L_0x001a
            int r4 = r4 + 1
        L_0x001a:
            int r6 = r4 + 2
            int r4 = a(r1, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            boolean r7 = a(r1, r6, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r7 == 0) goto L_0x0028
            int r6 = r6 + 1
        L_0x0028:
            int r7 = r6 + 2
            int r6 = a(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r8 = 84
            boolean r8 = a(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r9 = 1
            if (r8 != 0) goto L_0x004b
            int r10 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r10 > r7) goto L_0x004b
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r4 = r4 - r9
            r5.<init>(r0, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.util.Date r0 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            return r0
        L_0x004b:
            r10 = 43
            r11 = 90
            r12 = 2
            if (r8 == 0) goto L_0x00c2
            int r7 = r7 + 1
            int r8 = r7 + 2
            int r7 = a(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r13 = 58
            boolean r14 = a(r1, r8, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r14 == 0) goto L_0x0064
            int r8 = r8 + 1
        L_0x0064:
            int r14 = r8 + 2
            int r8 = a(r1, r8, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            boolean r13 = a(r1, r14, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r13 == 0) goto L_0x0072
            int r14 = r14 + 1
        L_0x0072:
            int r13 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r13 <= r14) goto L_0x00bf
            char r13 = r1.charAt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r13 == r11) goto L_0x00bf
            if (r13 == r10) goto L_0x00bf
            if (r13 == r5) goto L_0x00bf
            int r5 = r14 + 2
            int r13 = a(r1, r14, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r14 = 59
            if (r13 <= r14) goto L_0x0092
            r14 = 63
            if (r13 >= r14) goto L_0x0092
            r13 = 59
        L_0x0092:
            r14 = 46
            boolean r14 = a(r1, r5, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r14 == 0) goto L_0x00bb
            int r5 = r5 + 1
            int r14 = r5 + 1
            int r14 = a(r1, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r15 = r5 + 3
            int r15 = java.lang.Math.min(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r16 = a(r1, r5, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r15 = r15 - r5
            if (r15 == r9) goto L_0x00b5
            if (r15 == r12) goto L_0x00b2
            goto L_0x00b7
        L_0x00b2:
            int r16 = r16 * 10
            goto L_0x00b7
        L_0x00b5:
            int r16 = r16 * 100
        L_0x00b7:
            r5 = r14
            r12 = r16
            goto L_0x00cd
        L_0x00bb:
            r16 = 0
            r12 = 0
            goto L_0x00cd
        L_0x00bf:
            r5 = r7
            r7 = r14
            goto L_0x00c4
        L_0x00c2:
            r5 = 0
            r8 = 0
        L_0x00c4:
            r16 = 0
            r13 = 0
            r12 = 0
            r17 = r7
            r7 = r5
            r5 = r17
        L_0x00cd:
            int r14 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r14 <= r5) goto L_0x01a6
            char r14 = r1.charAt(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r15 = 5
            if (r14 != r11) goto L_0x00df
            java.util.TimeZone r10 = f3571a     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r5 = r5 + r9
            goto L_0x0174
        L_0x00df:
            if (r14 == r10) goto L_0x00fd
            r9 = 45
            if (r14 != r9) goto L_0x00e6
            goto L_0x00fd
        L_0x00e6:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r5 = "Invalid time zone indicator '"
            r4.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r4.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r4.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
        L_0x00fd:
            java.lang.String r9 = r1.substring(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r10 = r9.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r10 < r15) goto L_0x0108
            goto L_0x0119
        L_0x0108:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r10.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r9 = "00"
            r10.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r9 = r10.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
        L_0x0119:
            int r10 = r9.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r5 = r5 + r10
            java.lang.String r10 = "+0000"
            boolean r10 = r10.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r10 != 0) goto L_0x0172
            java.lang.String r10 = "+00:00"
            boolean r10 = r10.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r10 == 0) goto L_0x012f
            goto L_0x0172
        L_0x012f:
            java.lang.String r10 = "GMT"
            java.lang.String r9 = r10.concat(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r11 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            boolean r14 = r11.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r14 != 0) goto L_0x0174
            java.lang.String r14 = ":"
            java.lang.String r15 = ""
            java.lang.String r11 = r11.replace(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            boolean r11 = r11.equals(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            if (r11 == 0) goto L_0x0152
            goto L_0x0174
        L_0x0152:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r4.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r4.append(r9)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r5 = " given, resolves to "
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r5 = r10.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r4.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r4 = r4.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
        L_0x0172:
            java.util.TimeZone r10 = f3571a     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
        L_0x0174:
            java.util.GregorianCalendar r9 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r9.<init>(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r10 = 0
            r9.setLenient(r10)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r10 = 1
            r9.set(r10, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            int r4 = r4 - r10
            r0 = 2
            r9.set(r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r0 = 5
            r9.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r0 = 11
            r9.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r0 = 12
            r9.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r0 = 13
            r9.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r0 = 14
            r9.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            r2.setIndex(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.util.Date r0 = r9.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            return r0
        L_0x01a6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            java.lang.String r4 = "No time zone indicator"
            r0.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01b2, NumberFormatException -> 0x01b0, IllegalArgumentException -> 0x01ae }
        L_0x01ae:
            r0 = move-exception
            goto L_0x01b3
        L_0x01b0:
            r0 = move-exception
            goto L_0x01b3
        L_0x01b2:
            r0 = move-exception
        L_0x01b3:
            if (r1 != 0) goto L_0x01b7
            r1 = 0
            goto L_0x01bd
        L_0x01b7:
            java.lang.String r4 = "\""
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline51(r4, r1, r3)
        L_0x01bd:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01c9
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x01e4
        L_0x01c9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x01e4:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed to parse date ["
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r19.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.a.a.a.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static boolean a(String str, int i, char c2) {
        return i < str.length() && str.charAt(i) == c2;
    }
}
