package org.joda.time.format;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class DateTimeFormat {
    public static final ConcurrentHashMap<String, DateTimeFormatter> cPatternCache = new ConcurrentHashMap<>();

    static {
        new AtomicReferenceArray(25);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.format.DateTimeFormatter forPattern(java.lang.String r15) {
        /*
            int r0 = r15.length()
            if (r0 == 0) goto L_0x0225
            java.util.concurrent.ConcurrentHashMap<java.lang.String, org.joda.time.format.DateTimeFormatter> r0 = cPatternCache
            java.lang.Object r0 = r0.get(r15)
            org.joda.time.format.DateTimeFormatter r0 = (org.joda.time.format.DateTimeFormatter) r0
            if (r0 != 0) goto L_0x0224
            org.joda.time.format.DateTimeFormatterBuilder r0 = new org.joda.time.format.DateTimeFormatterBuilder
            r0.<init>()
            int r7 = r15.length()
            r8 = 1
            int[] r9 = new int[r8]
            r10 = 0
            r1 = 0
        L_0x001e:
            if (r1 >= r7) goto L_0x020b
            r9[r10] = r1
            java.lang.String r1 = parseToken(r15, r9)
            r11 = r9[r10]
            int r2 = r1.length()
            if (r2 != 0) goto L_0x0030
            goto L_0x020b
        L_0x0030:
            char r3 = r1.charAt(r10)
            r4 = 39
            if (r3 == r4) goto L_0x01ed
            r4 = 75
            r5 = 2
            r6 = 0
            if (r3 == r4) goto L_0x01e7
            r4 = 77
            r12 = 3
            r13 = 4
            if (r3 == r4) goto L_0x01d1
            r4 = 83
            if (r3 == r4) goto L_0x01cb
            r4 = 97
            if (r3 == r4) goto L_0x01c5
            r4 = 104(0x68, float:1.46E-43)
            if (r3 == r4) goto L_0x01bf
            r4 = 107(0x6b, float:1.5E-43)
            if (r3 == r4) goto L_0x01b9
            r4 = 109(0x6d, float:1.53E-43)
            if (r3 == r4) goto L_0x01b3
            r4 = 115(0x73, float:1.61E-43)
            if (r3 == r4) goto L_0x01ad
            r4 = 71
            if (r3 == r4) goto L_0x01a7
            r4 = 72
            if (r3 == r4) goto L_0x01a1
            r4 = 89
            if (r3 == r4) goto L_0x0104
            r14 = 90
            if (r3 == r14) goto L_0x00e1
            r14 = 100
            if (r3 == r14) goto L_0x00da
            r14 = 101(0x65, float:1.42E-43)
            if (r3 == r14) goto L_0x00d3
            switch(r3) {
                case 67: goto L_0x009d;
                case 68: goto L_0x0096;
                case 69: goto L_0x0086;
                default: goto L_0x0077;
            }
        L_0x0077:
            switch(r3) {
                case 119: goto L_0x00cc;
                case 120: goto L_0x0104;
                case 121: goto L_0x0104;
                case 122: goto L_0x00a4;
                default: goto L_0x007a;
            }
        L_0x007a:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Illegal pattern component: "
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r0, r1)
            r15.<init>(r0)
            throw r15
        L_0x0086:
            if (r2 < r13) goto L_0x008f
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.DAY_OF_WEEK_TYPE
            r0.appendText(r1)
            goto L_0x0207
        L_0x008f:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.DAY_OF_WEEK_TYPE
            r0.appendShortText(r1)
            goto L_0x0207
        L_0x0096:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.DAY_OF_YEAR_TYPE
            r0.appendDecimal(r1, r2, r12)
            goto L_0x0207
        L_0x009d:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.CENTURY_OF_ERA_TYPE
            r0.appendSignedDecimal(r1, r2, r2)
            goto L_0x0207
        L_0x00a4:
            if (r2 < r13) goto L_0x00b9
            org.joda.time.format.DateTimeFormatterBuilder$TimeZoneName r1 = new org.joda.time.format.DateTimeFormatterBuilder$TimeZoneName
            r1.<init>(r10, r6)
            r0.iFormatter = r6
            java.util.ArrayList<java.lang.Object> r2 = r0.iElementPairs
            r2.add(r1)
            java.util.ArrayList<java.lang.Object> r1 = r0.iElementPairs
            r1.add(r6)
            goto L_0x0207
        L_0x00b9:
            org.joda.time.format.DateTimeFormatterBuilder$TimeZoneName r1 = new org.joda.time.format.DateTimeFormatterBuilder$TimeZoneName
            r1.<init>(r8, r6)
            r0.iFormatter = r6
            java.util.ArrayList<java.lang.Object> r2 = r0.iElementPairs
            r2.add(r1)
            java.util.ArrayList<java.lang.Object> r2 = r0.iElementPairs
            r2.add(r1)
            goto L_0x0207
        L_0x00cc:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.WEEK_OF_WEEKYEAR_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x00d3:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.DAY_OF_WEEK_TYPE
            r0.appendDecimal(r1, r2, r8)
            goto L_0x0207
        L_0x00da:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.DAY_OF_MONTH_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x00e1:
            if (r2 != r8) goto L_0x00ef
            r2 = 0
            r4 = 0
            r5 = 2
            r6 = 2
            java.lang.String r3 = "Z"
            r1 = r0
            r1.appendTimeZoneOffset(r2, r3, r4, r5, r6)
            goto L_0x0207
        L_0x00ef:
            if (r2 != r5) goto L_0x00fd
            r2 = 0
            r4 = 1
            r5 = 2
            r6 = 2
            java.lang.String r3 = "Z"
            r1 = r0
            r1.appendTimeZoneOffset(r2, r3, r4, r5, r6)
            goto L_0x0207
        L_0x00fd:
            org.joda.time.format.DateTimeFormatterBuilder$TimeZoneId r1 = org.joda.time.format.DateTimeFormatterBuilder.TimeZoneId.INSTANCE
            r0.append0(r1, r1)
            goto L_0x0207
        L_0x0104:
            r1 = 120(0x78, float:1.68E-43)
            if (r2 != r5) goto L_0x016b
            int r2 = r11 + 1
            if (r2 >= r7) goto L_0x0120
            r2 = r9[r10]
            int r2 = r2 + r8
            r9[r10] = r2
            java.lang.String r2 = parseToken(r15, r9)
            boolean r2 = isNumericToken(r2)
            r2 = r2 ^ r8
            r4 = r9[r10]
            int r4 = r4 - r8
            r9[r10] = r4
            goto L_0x0121
        L_0x0120:
            r2 = 1
        L_0x0121:
            if (r3 == r1) goto L_0x0143
            org.joda.time.DateTime r1 = new org.joda.time.DateTime
            r1.<init>()
            int r1 = r1.getYear()
            int r1 = r1 + -30
            org.joda.time.format.DateTimeFormatterBuilder$TwoDigitYear r3 = new org.joda.time.format.DateTimeFormatterBuilder$TwoDigitYear
            org.joda.time.DateTimeFieldType r4 = org.joda.time.DateTimeFieldType.YEAR_TYPE
            r3.<init>(r4, r1, r2)
            r0.iFormatter = r6
            java.util.ArrayList<java.lang.Object> r1 = r0.iElementPairs
            r1.add(r3)
            java.util.ArrayList<java.lang.Object> r1 = r0.iElementPairs
            r1.add(r3)
            goto L_0x0207
        L_0x0143:
            org.joda.time.DateTime r1 = new org.joda.time.DateTime
            r1.<init>()
            org.joda.time.Chronology r3 = r1.iChronology
            org.joda.time.DateTimeField r3 = r3.weekyear()
            long r4 = r1.iMillis
            int r1 = r3.get(r4)
            int r1 = r1 + -30
            org.joda.time.format.DateTimeFormatterBuilder$TwoDigitYear r3 = new org.joda.time.format.DateTimeFormatterBuilder$TwoDigitYear
            org.joda.time.DateTimeFieldType r4 = org.joda.time.DateTimeFieldType.WEEKYEAR_TYPE
            r3.<init>(r4, r1, r2)
            r0.iFormatter = r6
            java.util.ArrayList<java.lang.Object> r1 = r0.iElementPairs
            r1.add(r3)
            java.util.ArrayList<java.lang.Object> r1 = r0.iElementPairs
            r1.add(r3)
            goto L_0x0207
        L_0x016b:
            r5 = 9
            int r6 = r11 + 1
            if (r6 >= r7) goto L_0x0186
            r6 = r9[r10]
            int r6 = r6 + r8
            r9[r10] = r6
            java.lang.String r6 = parseToken(r15, r9)
            boolean r6 = isNumericToken(r6)
            if (r6 == 0) goto L_0x0181
            r5 = r2
        L_0x0181:
            r6 = r9[r10]
            int r6 = r6 - r8
            r9[r10] = r6
        L_0x0186:
            if (r3 == r4) goto L_0x019a
            if (r3 == r1) goto L_0x0195
            r1 = 121(0x79, float:1.7E-43)
            if (r3 == r1) goto L_0x0190
            goto L_0x0207
        L_0x0190:
            r0.appendYear(r2, r5)
            goto L_0x0207
        L_0x0195:
            r0.appendWeekyear(r2, r5)
            goto L_0x0207
        L_0x019a:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.YEAR_OF_ERA_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01a1:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.HOUR_OF_DAY_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01a7:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.ERA_TYPE
            r0.appendText(r1)
            goto L_0x0207
        L_0x01ad:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.SECOND_OF_MINUTE_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01b3:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.MINUTE_OF_HOUR_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01b9:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.CLOCKHOUR_OF_DAY_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01bf:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.CLOCKHOUR_OF_HALFDAY_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01c5:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.HALFDAY_OF_DAY_TYPE
            r0.appendText(r1)
            goto L_0x0207
        L_0x01cb:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.SECOND_OF_DAY_TYPE
            r0.appendFraction(r1, r2, r2)
            goto L_0x0207
        L_0x01d1:
            if (r2 < r12) goto L_0x01e1
            if (r2 < r13) goto L_0x01db
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.MONTH_OF_YEAR_TYPE
            r0.appendText(r1)
            goto L_0x0207
        L_0x01db:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.MONTH_OF_YEAR_TYPE
            r0.appendShortText(r1)
            goto L_0x0207
        L_0x01e1:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.MONTH_OF_YEAR_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01e7:
            org.joda.time.DateTimeFieldType r1 = org.joda.time.DateTimeFieldType.HOUR_OF_HALFDAY_TYPE
            r0.appendDecimal(r1, r2, r5)
            goto L_0x0207
        L_0x01ed:
            java.lang.String r1 = r1.substring(r8)
            int r2 = r1.length()
            if (r2 != r8) goto L_0x01ff
            char r1 = r1.charAt(r10)
            r0.appendLiteral(r1)
            goto L_0x0207
        L_0x01ff:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r0.appendLiteral(r2)
        L_0x0207:
            int r1 = r11 + 1
            goto L_0x001e
        L_0x020b:
            org.joda.time.format.DateTimeFormatter r0 = r0.toFormatter()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, org.joda.time.format.DateTimeFormatter> r1 = cPatternCache
            int r1 = r1.size()
            r2 = 500(0x1f4, float:7.0E-43)
            if (r1 >= r2) goto L_0x0224
            java.util.concurrent.ConcurrentHashMap<java.lang.String, org.joda.time.format.DateTimeFormatter> r1 = cPatternCache
            java.lang.Object r15 = r1.putIfAbsent(r15, r0)
            org.joda.time.format.DateTimeFormatter r15 = (org.joda.time.format.DateTimeFormatter) r15
            if (r15 == 0) goto L_0x0224
            r0 = r15
        L_0x0224:
            return r0
        L_0x0225:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid pattern specification"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormat.forPattern(java.lang.String):org.joda.time.format.DateTimeFormatter");
    }

    public static boolean isNumericToken(String str) {
        int length = str.length();
        if (length > 0) {
            switch (str.charAt(0)) {
                case 'C':
                case 'D':
                case 'F':
                case 'H':
                case 'K':
                case 'S':
                case 'W':
                case 'Y':
                case 'c':
                case 'd':
                case 'e':
                case 'h':
                case 'k':
                case 'm':
                case 's':
                case 'w':
                case 'x':
                case 'y':
                    break;
                case 'M':
                    if (length <= 2) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public static String parseToken(String str, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                sb.append(charAt);
                i = i2;
            }
        } else {
            sb.append(ExtendedMessageFormat.QUOTE);
            boolean z = false;
            while (true) {
                if (i >= length) {
                    break;
                }
                char charAt2 = str.charAt(i);
                if (charAt2 == '\'') {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(charAt2);
                        i = i3;
                    }
                } else if (z || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb.append(charAt2);
                }
                i++;
            }
            i--;
        }
        iArr[0] = i;
        return sb.toString();
    }
}
