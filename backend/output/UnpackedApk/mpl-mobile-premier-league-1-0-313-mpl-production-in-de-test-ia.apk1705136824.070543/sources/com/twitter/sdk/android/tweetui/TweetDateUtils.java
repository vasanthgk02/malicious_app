package com.twitter.sdk.android.tweetui;

import android.content.res.Resources;
import androidx.collection.SparseArrayCompat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class TweetDateUtils {
    public static final SimpleDateFormat DATE_TIME_RFC822 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
    public static final DateFormatter RELATIVE_DATE_FORMAT = new DateFormatter();

    public static class DateFormatter {
        public Locale currentLocale;
        public final SparseArrayCompat<SimpleDateFormat> dateFormatArray = new SparseArrayCompat<>();

        public synchronized String formatLongDateString(Resources resources, Date date) {
            return getDateFormat(resources, R$string.tw__relative_date_format_long).format(date);
        }

        public final synchronized DateFormat getDateFormat(Resources resources, int i) {
            SimpleDateFormat simpleDateFormat;
            if (this.currentLocale == null || this.currentLocale != resources.getConfiguration().locale) {
                this.currentLocale = resources.getConfiguration().locale;
                this.dateFormatArray.clear();
            }
            simpleDateFormat = (SimpleDateFormat) this.dateFormatArray.get(i, null);
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(resources.getString(i), Locale.getDefault());
                this.dateFormatArray.put(i, simpleDateFormat);
            }
            return simpleDateFormat;
        }
    }

    public static long apiTimeToLong(String str) {
        long j = -1;
        if (str == null) {
            return -1;
        }
        try {
            j = DATE_TIME_RFC822.parse(str).getTime();
        } catch (ParseException unused) {
        }
        return j;
    }
}
