package org.apache.commons.lang.time;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TimeZone;

public class DateUtils {
    public static final int MILLIS_IN_DAY = 86400000;
    public static final int MILLIS_IN_HOUR = 3600000;
    public static final int MILLIS_IN_MINUTE = 60000;
    public static final int MILLIS_IN_SECOND = 1000;
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
    public static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    public static class DateIterator implements Iterator {
        public final Calendar endFinal;
        public final Calendar spot;

        public DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        public Object next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return this.spot.clone();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static Date add(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(i, i2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static long getFragment(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return getFragment(instance, i, i2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, 6);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, 11);
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, 14);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, 12);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, 13);
    }

    public static long getMillisPerUnit(int i) {
        if (i == 5 || i == 6) {
            return 86400000;
        }
        switch (i) {
            case 11:
                return 3600000;
            case 12:
                return 60000;
            case 13:
                return 1000;
            case 14:
                return 1;
            default:
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The unit ");
                stringBuffer.append(i);
                stringBuffer.append(" cannot be represented is milleseconds");
                throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return isSameDay(instance, instance2);
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date != null && date2 != null) {
            return date.getTime() == date2.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(10) == calendar2.get(10) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator iterator(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return iterator(instance, i);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a2, code lost:
        if (r14 == 9) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a4, code lost:
        if (r14 == 1001) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ab, code lost:
        if (r6[r2][0] != 5) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ad, code lost:
        r3 = r13.get(5) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b2, code lost:
        if (r3 < 15) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b4, code lost:
        r3 = r3 - 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b7, code lost:
        if (r3 <= 7) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c0, code lost:
        if (r6[r2][0] != 11) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c2, code lost:
        r3 = r13.get(11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c6, code lost:
        if (r3 < 12) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c8, code lost:
        r3 = r3 - 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00cb, code lost:
        if (r3 <= 6) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cd, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00cf, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00d0, code lost:
        r6 = true;
        r12 = r4;
        r4 = r3;
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d5, code lost:
        r4 = 0;
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d7, code lost:
        if (r6 != false) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d9, code lost:
        r3 = r13.getActualMinimum(fields[r2][0]);
        r4 = r13.getActualMaximum(fields[r2][0]);
        r6 = r13.get(fields[r2][0]) - r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00fa, code lost:
        if (r6 <= ((r4 - r3) / 2)) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00fc, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00fe, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00ff, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0100, code lost:
        if (r4 == 0) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0102, code lost:
        r6 = fields;
        r13.set(r6[r2][0], r13.get(r6[r2][0]) - r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0114, code lost:
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void modify(java.util.Calendar r13, int r14, boolean r15) {
        /*
            r0 = 1
            int r1 = r13.get(r0)
            r2 = 280000000(0x10b07600, float:6.960157E-29)
            if (r1 > r2) goto L_0x0134
            r1 = 14
            if (r14 != r1) goto L_0x000f
            return
        L_0x000f:
            java.util.Date r2 = r13.getTime()
            long r3 = r2.getTime()
            int r1 = r13.get(r1)
            if (r15 == 0) goto L_0x0021
            r5 = 500(0x1f4, float:7.0E-43)
            if (r1 >= r5) goto L_0x0023
        L_0x0021:
            long r5 = (long) r1
            long r3 = r3 - r5
        L_0x0023:
            r1 = 13
            r5 = 0
            if (r14 != r1) goto L_0x002a
            r6 = 1
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            int r1 = r13.get(r1)
            r7 = 30
            if (r6 != 0) goto L_0x003d
            if (r15 == 0) goto L_0x0037
            if (r1 >= r7) goto L_0x003d
        L_0x0037:
            long r8 = (long) r1
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r10
            long r3 = r3 - r8
        L_0x003d:
            r1 = 12
            if (r14 != r1) goto L_0x0042
            r6 = 1
        L_0x0042:
            int r8 = r13.get(r1)
            if (r6 != 0) goto L_0x0053
            if (r15 == 0) goto L_0x004c
            if (r8 >= r7) goto L_0x0053
        L_0x004c:
            long r6 = (long) r8
            r8 = 60000(0xea60, double:2.9644E-319)
            long r6 = r6 * r8
            long r3 = r3 - r6
        L_0x0053:
            long r6 = r2.getTime()
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x0061
            r2.setTime(r3)
            r13.setTime(r2)
        L_0x0061:
            r2 = 0
            r3 = 0
        L_0x0063:
            int[][] r4 = fields
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0118
            r4 = 0
        L_0x0069:
            int[][] r6 = fields
            r7 = r6[r2]
            int r7 = r7.length
            r8 = 15
            r9 = 2
            r10 = 1001(0x3e9, float:1.403E-42)
            r11 = 5
            if (r4 >= r7) goto L_0x00a0
            r7 = r6[r2]
            r7 = r7[r4]
            if (r7 != r14) goto L_0x009d
            if (r15 == 0) goto L_0x009c
            if (r3 == 0) goto L_0x009c
            if (r14 != r10) goto L_0x0095
            int r14 = r13.get(r11)
            if (r14 != r0) goto L_0x008c
            r13.add(r11, r8)
            goto L_0x009c
        L_0x008c:
            r14 = -15
            r13.add(r11, r14)
            r13.add(r9, r0)
            goto L_0x009c
        L_0x0095:
            r14 = r6[r2]
            r14 = r14[r5]
            r13.add(r14, r0)
        L_0x009c:
            return
        L_0x009d:
            int r4 = r4 + 1
            goto L_0x0069
        L_0x00a0:
            r4 = 9
            if (r14 == r4) goto L_0x00ba
            if (r14 == r10) goto L_0x00a7
            goto L_0x00d5
        L_0x00a7:
            r4 = r6[r2]
            r4 = r4[r5]
            if (r4 != r11) goto L_0x00d5
            int r3 = r13.get(r11)
            int r3 = r3 - r0
            if (r3 < r8) goto L_0x00b6
            int r3 = r3 + -15
        L_0x00b6:
            r4 = 7
            if (r3 <= r4) goto L_0x00cf
            goto L_0x00cd
        L_0x00ba:
            r4 = r6[r2]
            r4 = r4[r5]
            r6 = 11
            if (r4 != r6) goto L_0x00d5
            int r3 = r13.get(r6)
            if (r3 < r1) goto L_0x00ca
            int r3 = r3 + -12
        L_0x00ca:
            r4 = 6
            if (r3 <= r4) goto L_0x00cf
        L_0x00cd:
            r4 = 1
            goto L_0x00d0
        L_0x00cf:
            r4 = 0
        L_0x00d0:
            r6 = 1
            r12 = r4
            r4 = r3
            r3 = r12
            goto L_0x00d7
        L_0x00d5:
            r4 = 0
            r6 = 0
        L_0x00d7:
            if (r6 != 0) goto L_0x0100
            int[][] r3 = fields
            r3 = r3[r2]
            r3 = r3[r5]
            int r3 = r13.getActualMinimum(r3)
            int[][] r4 = fields
            r4 = r4[r2]
            r4 = r4[r5]
            int r4 = r13.getActualMaximum(r4)
            int[][] r6 = fields
            r6 = r6[r2]
            r6 = r6[r5]
            int r6 = r13.get(r6)
            int r6 = r6 - r3
            int r4 = r4 - r3
            int r4 = r4 / r9
            if (r6 <= r4) goto L_0x00fe
            r3 = 1
            goto L_0x00ff
        L_0x00fe:
            r3 = 0
        L_0x00ff:
            r4 = r6
        L_0x0100:
            if (r4 == 0) goto L_0x0114
            int[][] r6 = fields
            r7 = r6[r2]
            r7 = r7[r5]
            r6 = r6[r2]
            r6 = r6[r5]
            int r6 = r13.get(r6)
            int r6 = r6 - r4
            r13.set(r7, r6)
        L_0x0114:
            int r2 = r2 + 1
            goto L_0x0063
        L_0x0118:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuffer r15 = new java.lang.StringBuffer
            r15.<init>()
            java.lang.String r0 = "The field "
            r15.append(r0)
            r15.append(r14)
            java.lang.String r14 = " is not supported"
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            r13.<init>(r14)
            throw r13
        L_0x0134:
            java.lang.ArithmeticException r13 = new java.lang.ArithmeticException
            java.lang.String r14 = "Calendar value too large for accurate calculations"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.time.DateUtils.modify(java.util.Calendar, int, boolean):void");
    }

    public static Date parseDate(String str, String[] strArr) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        SimpleDateFormat simpleDateFormat = null;
        ParsePosition parsePosition = new ParsePosition(0);
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                simpleDateFormat = new SimpleDateFormat(strArr[0]);
            } else {
                simpleDateFormat.applyPattern(strArr[i]);
            }
            parsePosition.setIndex(0);
            Date parse = simpleDateFormat.parse(str, parsePosition);
            if (parse != null && parsePosition.getIndex() == str.length()) {
                return parse;
            }
        }
        throw new ParseException(GeneratedOutlineSupport.outline49("Unable to parse the date: ", str), -1);
    }

    public static Date round(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, true);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date set(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setLenient(false);
            instance.setTime(date);
            instance.set(i, i2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Date truncate(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, false);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, 6);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, 11);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, 14);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, 12);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, 13);
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static long getFragment(Calendar calendar, int i, int i2) {
        long j;
        if (calendar != null) {
            long millisPerUnit = getMillisPerUnit(i2);
            long j2 = 0;
            if (i != 1) {
                if (i == 2) {
                    j = (((long) calendar.get(5)) * 86400000) / millisPerUnit;
                }
                if (i != 1 || i == 2 || i == 5 || i == 6) {
                    j2 += (((long) calendar.get(11)) * 3600000) / millisPerUnit;
                } else {
                    switch (i) {
                        case 11:
                            break;
                        case 12:
                            break;
                        case 13:
                            break;
                        case 14:
                            return j2;
                        default:
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("The fragment ");
                            stringBuffer.append(i);
                            stringBuffer.append(" is not supported");
                            throw new IllegalArgumentException(stringBuffer.toString());
                    }
                }
                j2 += (((long) calendar.get(12)) * 60000) / millisPerUnit;
                j2 += (((long) calendar.get(13)) * 1000) / millisPerUnit;
                return j2 + (((long) (calendar.get(14) * 1)) / millisPerUnit);
            }
            j = (((long) calendar.get(6)) * 86400000) / millisPerUnit;
            j2 = 0 + j;
            if (i != 1) {
            }
            j2 += (((long) calendar.get(11)) * 3600000) / millisPerUnit;
            j2 += (((long) calendar.get(12)) * 60000) / millisPerUnit;
            j2 += (((long) calendar.get(13)) * 1000) / millisPerUnit;
            return j2 + (((long) (calendar.get(14) * 1)) / millisPerUnit);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Iterator iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L_0x0091
            r0 = -1
            r1 = 2
            r2 = 5
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L_0x0042;
                case 2: goto L_0x0042;
                case 3: goto L_0x0042;
                case 4: goto L_0x0042;
                case 5: goto L_0x0026;
                case 6: goto L_0x0026;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "The range style "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " is not valid."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.<init>(r9)
            throw r8
        L_0x0026:
            java.util.Calendar r8 = truncate(r8, r1)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r1, r3)
            r5.add(r2, r0)
            r6 = 6
            if (r9 != r6) goto L_0x003d
            r6 = r5
            r5 = r8
        L_0x003b:
            r8 = 1
            goto L_0x0067
        L_0x003d:
            r6 = r5
            r1 = 1
            r5 = r8
            r8 = 7
            goto L_0x0067
        L_0x0042:
            java.util.Calendar r5 = truncate(r8, r2)
            java.util.Calendar r6 = truncate(r8, r2)
            if (r9 == r1) goto L_0x003b
            r1 = 3
            if (r9 == r1) goto L_0x0061
            r7 = 4
            if (r9 == r7) goto L_0x0055
            r8 = 7
            r1 = 1
            goto L_0x0067
        L_0x0055:
            int r9 = r8.get(r4)
            int r9 = r9 - r1
            int r8 = r8.get(r4)
            int r8 = r8 + r1
            r1 = r9
            goto L_0x0067
        L_0x0061:
            int r1 = r8.get(r4)
            int r8 = r1 + -1
        L_0x0067:
            if (r1 >= r3) goto L_0x006b
            int r1 = r1 + 7
        L_0x006b:
            if (r1 <= r4) goto L_0x006f
            int r1 = r1 + -7
        L_0x006f:
            if (r8 >= r3) goto L_0x0073
            int r8 = r8 + 7
        L_0x0073:
            if (r8 <= r4) goto L_0x0077
            int r8 = r8 + -7
        L_0x0077:
            int r9 = r5.get(r4)
            if (r9 == r1) goto L_0x0081
            r5.add(r2, r0)
            goto L_0x0077
        L_0x0081:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L_0x008b
            r6.add(r2, r3)
            goto L_0x0081
        L_0x008b:
            org.apache.commons.lang.time.DateUtils$DateIterator r8 = new org.apache.commons.lang.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L_0x0091:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The date must not be null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, true);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, false);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return round((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i).getTime();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not round ");
            stringBuffer.append(obj);
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i).getTime();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not truncate ");
            stringBuffer.append(obj);
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public static Iterator iterator(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not iterate based on ");
            stringBuffer.append(obj);
            throw new ClassCastException(stringBuffer.toString());
        }
    }
}
