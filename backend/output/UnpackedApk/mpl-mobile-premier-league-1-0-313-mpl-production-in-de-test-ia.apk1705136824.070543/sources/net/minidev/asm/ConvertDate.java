package net.minidev.asm;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.e.h;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import sfs2x.client.requests.CreateRoomRequest;

public class ConvertDate {
    public static TreeMap<String, Integer> daysTable = new TreeMap<>(new StringCmpNS());
    public static TreeMap<String, Integer> monthsTable = new TreeMap<>(new StringCmpNS());
    public static TreeMap<String, TimeZone> timeZoneMapping = new TreeMap<>();
    public static HashSet<String> voidData = new HashSet<>();

    public static class StringCmpNS implements Comparator<String> {
        public int compare(Object obj, Object obj2) {
            return ((String) obj).compareToIgnoreCase((String) obj2);
        }
    }

    static {
        voidData.add("MEZ");
        voidData.add("Uhr");
        voidData.add(h.f3998a);
        voidData.add(CreateRoomRequest.KEY_PERMISSIONS);
        voidData.add("PM");
        voidData.add("AM");
        voidData.add("o'clock");
        for (String str : TimeZone.getAvailableIDs()) {
            timeZoneMapping.put(str, TimeZone.getTimeZone(str));
        }
        for (Locale locale : DateFormatSymbols.getAvailableLocales()) {
            if (!"ja".equals(locale.getLanguage()) && !"ko".equals(locale.getLanguage()) && !"zh".equals(locale.getLanguage())) {
                DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
                String[] months = instance.getMonths();
                for (int i = 0; i < months.length; i++) {
                    if (months[i].length() != 0) {
                        fillMap(monthsTable, months[i], Integer.valueOf(i));
                    }
                }
                String[] shortMonths = instance.getShortMonths();
                for (int i2 = 0; i2 < shortMonths.length; i2++) {
                    String str2 = shortMonths[i2];
                    if (str2.length() != 0 && !Character.isDigit(str2.charAt(str2.length() - 1))) {
                        fillMap(monthsTable, shortMonths[i2], Integer.valueOf(i2));
                        fillMap(monthsTable, shortMonths[i2].replace(".", ""), Integer.valueOf(i2));
                    }
                }
                String[] weekdays = instance.getWeekdays();
                for (int i3 = 0; i3 < weekdays.length; i3++) {
                    String str3 = weekdays[i3];
                    if (str3.length() != 0) {
                        fillMap(daysTable, str3, Integer.valueOf(i3));
                        fillMap(daysTable, str3.replace(".", ""), Integer.valueOf(i3));
                    }
                }
                String[] shortWeekdays = instance.getShortWeekdays();
                for (int i4 = 0; i4 < shortWeekdays.length; i4++) {
                    String str4 = shortWeekdays[i4];
                    if (str4.length() != 0) {
                        fillMap(daysTable, str4, Integer.valueOf(i4));
                        fillMap(daysTable, str4.replace(".", ""), Integer.valueOf(i4));
                    }
                }
            }
        }
    }

    public static Date addHour(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        if (str == null) {
            if (!stringTokenizer.hasMoreTokens()) {
                return calendar.getTime();
            }
            str = stringTokenizer.nextToken();
        }
        return addHour2(stringTokenizer, calendar, str);
    }

    public static Date addHour2(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        calendar.set(11, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String trySkip = trySkip(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (trySkip == null) {
            return calendar.getTime();
        }
        calendar.set(12, Integer.parseInt(trySkip));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String trySkip2 = trySkip(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (trySkip2 == null) {
            return calendar.getTime();
        }
        calendar.set(13, Integer.parseInt(trySkip2));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String trySkip3 = trySkip(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (trySkip3 == null) {
            return calendar.getTime();
        }
        String trySkip4 = trySkip(stringTokenizer, trySkip3, calendar);
        if (trySkip4.length() == 4 && Character.isDigit(trySkip4.charAt(0))) {
            calendar.set(1, getYear(trySkip4));
        }
        return calendar.getTime();
    }

    public static Date convertToDate(Object obj) {
        Date date;
        Date date2 = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            StringTokenizer stringTokenizer = new StringTokenizer((String) obj, " -/:,.+");
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() != 4 || !Character.isDigit(nextToken.charAt(0))) {
                if (daysTable.containsKey(nextToken)) {
                    if (!stringTokenizer.hasMoreTokens()) {
                        return null;
                    }
                    nextToken = stringTokenizer.nextToken();
                }
                if (monthsTable.containsKey(nextToken)) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
                    Integer num = monthsTable.get(nextToken);
                    if (num != null) {
                        gregorianCalendar.set(2, num.intValue());
                        if (stringTokenizer.hasMoreTokens()) {
                            gregorianCalendar.set(5, Integer.parseInt(stringTokenizer.nextToken()));
                            if (stringTokenizer.hasMoreTokens()) {
                                String nextToken2 = stringTokenizer.nextToken();
                                if (Character.isLetter(nextToken2.charAt(0))) {
                                    if (stringTokenizer.hasMoreTokens()) {
                                        nextToken2 = stringTokenizer.nextToken();
                                    }
                                }
                                if (nextToken2.length() == 4) {
                                    gregorianCalendar.set(1, getYear(nextToken2));
                                } else if (nextToken2.length() == 2) {
                                    date2 = addHour2(stringTokenizer, gregorianCalendar, nextToken2);
                                }
                                date2 = addHour(stringTokenizer, gregorianCalendar, null);
                            }
                        }
                        return date2;
                    }
                    throw new NullPointerException(GeneratedOutlineSupport.outline51("can not parse ", nextToken, " as month"));
                }
                if (Character.isDigit(nextToken.charAt(0))) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
                    gregorianCalendar2.set(5, Integer.parseInt(nextToken));
                    if (stringTokenizer.hasMoreTokens()) {
                        gregorianCalendar2.set(2, parseMonth(stringTokenizer.nextToken()).intValue());
                        if (stringTokenizer.hasMoreTokens()) {
                            gregorianCalendar2.set(1, getYear(stringTokenizer.nextToken()));
                            date2 = addHour(stringTokenizer, gregorianCalendar2, null);
                        }
                    }
                }
                return date2;
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
            gregorianCalendar3.setTimeInMillis(0);
            gregorianCalendar3.set(1, Integer.parseInt(nextToken));
            if (!stringTokenizer.hasMoreTokens()) {
                date = gregorianCalendar3.getTime();
            } else {
                gregorianCalendar3.set(2, parseMonth(stringTokenizer.nextToken()).intValue());
                if (!stringTokenizer.hasMoreTokens()) {
                    date = gregorianCalendar3.getTime();
                } else {
                    String nextToken3 = stringTokenizer.nextToken();
                    if (!Character.isDigit(nextToken3.charAt(0))) {
                        date = gregorianCalendar3.getTime();
                    } else if (nextToken3.length() == 5 && nextToken3.charAt(2) == 'T') {
                        gregorianCalendar3.set(5, Integer.parseInt(nextToken3.substring(0, 2)));
                        date = addHour(stringTokenizer, gregorianCalendar3, nextToken3.substring(3));
                    } else {
                        gregorianCalendar3.set(5, Integer.parseInt(nextToken3));
                        date = addHour(stringTokenizer, gregorianCalendar3, null);
                    }
                }
            }
            return date;
        }
        throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to int");
    }

    public static void fillMap(TreeMap<String, Integer> treeMap, String str, Integer num) {
        treeMap.put(str, num);
        treeMap.put(str.replace("é", "e").replace("û", "u"), num);
    }

    public static int getYear(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt < 100) {
            return parseInt > 23 ? parseInt + 2000 : parseInt + 1900;
        }
        return parseInt;
    }

    public static Integer parseMonth(String str) {
        if (Character.isDigit(str.charAt(0))) {
            return Integer.valueOf(Integer.parseInt(str) - 1);
        }
        Integer num = monthsTable.get(str);
        if (num != null) {
            return Integer.valueOf(num.intValue());
        }
        throw new NullPointerException(GeneratedOutlineSupport.outline51("can not parse ", str, " as month"));
    }

    public static String trySkip(StringTokenizer stringTokenizer, String str, Calendar calendar) {
        while (true) {
            TimeZone timeZone = timeZoneMapping.get(str);
            if (timeZone != null) {
                calendar.setTimeZone(timeZone);
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                str = stringTokenizer.nextToken();
            } else if (!voidData.contains(str)) {
                return str;
            } else {
                if (str.equalsIgnoreCase(CreateRoomRequest.KEY_PERMISSIONS)) {
                    calendar.add(9, 1);
                }
                if (str.equalsIgnoreCase("am")) {
                    calendar.add(9, 0);
                }
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                str = stringTokenizer.nextToken();
            }
        }
    }
}
