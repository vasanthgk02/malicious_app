package org.joda.time.chrono;

import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.joda.time.DateTimeUtils;

public class GJLocaleSymbols {
    public static ConcurrentMap<Locale, GJLocaleSymbols> cCache = new ConcurrentHashMap();
    public final String[] iDaysOfWeek;
    public final String[] iEras;
    public final String[] iHalfday;
    public final int iMaxDayOfWeekLength;
    public final int iMaxEraLength;
    public final int iMaxHalfdayLength;
    public final int iMaxMonthLength;
    public final String[] iMonths;
    public final TreeMap<String, Integer> iParseDaysOfWeek;
    public final TreeMap<String, Integer> iParseEras;
    public final TreeMap<String, Integer> iParseMonths;
    public final String[] iShortDaysOfWeek;
    public final String[] iShortMonths;

    public GJLocaleSymbols(Locale locale) {
        DateFormatSymbols dateFormatSymbols = DateTimeUtils.getDateFormatSymbols(locale);
        this.iEras = dateFormatSymbols.getEras();
        this.iDaysOfWeek = realignDaysOfWeek(dateFormatSymbols.getWeekdays());
        this.iShortDaysOfWeek = realignDaysOfWeek(dateFormatSymbols.getShortWeekdays());
        String[] months = dateFormatSymbols.getMonths();
        String[] strArr = new String[13];
        for (int i = 1; i < 13; i++) {
            strArr[i] = months[i - 1];
        }
        this.iMonths = strArr;
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] strArr2 = new String[13];
        for (int i2 = 1; i2 < 13; i2++) {
            strArr2[i2] = shortMonths[i2 - 1];
        }
        this.iShortMonths = strArr2;
        this.iHalfday = dateFormatSymbols.getAmPmStrings();
        Integer[] numArr = new Integer[13];
        for (int i3 = 0; i3 < 13; i3++) {
            numArr[i3] = Integer.valueOf(i3);
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        this.iParseEras = treeMap;
        addSymbols(treeMap, this.iEras, numArr);
        if (HyperVergeKycCapture.EN.equals(locale.getLanguage())) {
            this.iParseEras.put("BCE", numArr[0]);
            this.iParseEras.put("CE", numArr[1]);
        }
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        this.iParseDaysOfWeek = treeMap2;
        addSymbols(treeMap2, this.iDaysOfWeek, numArr);
        addSymbols(this.iParseDaysOfWeek, this.iShortDaysOfWeek, numArr);
        TreeMap<String, Integer> treeMap3 = this.iParseDaysOfWeek;
        for (int i4 = 1; i4 <= 7; i4++) {
            treeMap3.put(String.valueOf(i4).intern(), numArr[i4]);
        }
        TreeMap<String, Integer> treeMap4 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        this.iParseMonths = treeMap4;
        addSymbols(treeMap4, this.iMonths, numArr);
        addSymbols(this.iParseMonths, this.iShortMonths, numArr);
        TreeMap<String, Integer> treeMap5 = this.iParseMonths;
        for (int i5 = 1; i5 <= 12; i5++) {
            treeMap5.put(String.valueOf(i5).intern(), numArr[i5]);
        }
        this.iMaxEraLength = maxLength(this.iEras);
        this.iMaxDayOfWeekLength = maxLength(this.iDaysOfWeek);
        maxLength(this.iShortDaysOfWeek);
        this.iMaxMonthLength = maxLength(this.iMonths);
        maxLength(this.iShortMonths);
        this.iMaxHalfdayLength = maxLength(this.iHalfday);
    }

    public static void addSymbols(TreeMap<String, Integer> treeMap, String[] strArr, Integer[] numArr) {
        int length = strArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                String str = strArr[length];
                if (str != null) {
                    treeMap.put(str, numArr[length]);
                }
            } else {
                return;
            }
        }
    }

    public static GJLocaleSymbols forLocale(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        GJLocaleSymbols gJLocaleSymbols = (GJLocaleSymbols) cCache.get(locale);
        if (gJLocaleSymbols != null) {
            return gJLocaleSymbols;
        }
        GJLocaleSymbols gJLocaleSymbols2 = new GJLocaleSymbols(locale);
        GJLocaleSymbols putIfAbsent = cCache.putIfAbsent(locale, gJLocaleSymbols2);
        return putIfAbsent != null ? putIfAbsent : gJLocaleSymbols2;
    }

    public static int maxLength(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            String str = strArr[length];
            if (str != null) {
                int length2 = str.length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }
    }

    public static String[] realignDaysOfWeek(String[] strArr) {
        String[] strArr2 = new String[8];
        int i = 1;
        while (i < 8) {
            strArr2[i] = strArr[i < 7 ? i + 1 : 1];
            i++;
        }
        return strArr2;
    }
}
