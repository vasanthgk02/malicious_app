package org.apache.commons.net.ftp.parser;

import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.net.ftp.Configurable;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.fontbox.cmap.CMap;

public class FTPTimestampParserImpl implements Configurable, FTPTimestampParser {
    private SimpleDateFormat defaultDateFormat;
    private boolean lenientFutureDates = false;
    private SimpleDateFormat recentDateFormat;

    public FTPTimestampParserImpl() {
        setDefaultDateFormat(FTPTimestampParser.DEFAULT_SDF);
        setRecentDateFormat(FTPTimestampParser.DEFAULT_RECENT_SDF);
    }

    public Calendar parseTimestamp(String str) throws ParseException {
        return parseTimestamp(str, Calendar.getInstance());
    }

    public Calendar parseTimestamp(String str, Calendar calendar) throws ParseException {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.setTimeZone(getServerTimeZone());
        if (this.recentDateFormat != null) {
            Calendar calendar3 = (Calendar) calendar.clone();
            calendar3.setTimeZone(getServerTimeZone());
            if (this.lenientFutureDates) {
                calendar3.add(5, 1);
            }
            String num = Integer.toString(calendar3.get(1));
            String str2 = str + CMap.SPACE + num;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.recentDateFormat.toPattern() + " yyyy", this.recentDateFormat.getDateFormatSymbols());
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(this.recentDateFormat.getTimeZone());
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = simpleDateFormat.parse(str2, parsePosition);
            if (parse != null && parsePosition.getIndex() == str2.length()) {
                calendar2.setTime(parse);
                if (calendar2.after(calendar3)) {
                    calendar2.add(1, -1);
                }
                return calendar2;
            }
        }
        ParsePosition parsePosition2 = new ParsePosition(0);
        Date parse2 = this.defaultDateFormat.parse(str, parsePosition2);
        if (parse2 == null || parsePosition2.getIndex() != str.length()) {
            throw new ParseException("Timestamp '" + str + "' could not be parsed using a server time of " + calendar.getTime().toString(), parsePosition2.getErrorIndex());
        }
        calendar2.setTime(parse2);
        return calendar2;
    }

    public SimpleDateFormat getDefaultDateFormat() {
        return this.defaultDateFormat;
    }

    public String getDefaultDateFormatString() {
        return this.defaultDateFormat.toPattern();
    }

    private void setDefaultDateFormat(String str) {
        if (str != null) {
            this.defaultDateFormat = new SimpleDateFormat(str);
            this.defaultDateFormat.setLenient(false);
        }
    }

    public SimpleDateFormat getRecentDateFormat() {
        return this.recentDateFormat;
    }

    public String getRecentDateFormatString() {
        return this.recentDateFormat.toPattern();
    }

    private void setRecentDateFormat(String str) {
        if (str != null) {
            this.recentDateFormat = new SimpleDateFormat(str);
            this.recentDateFormat.setLenient(false);
        }
    }

    public String[] getShortMonths() {
        return this.defaultDateFormat.getDateFormatSymbols().getShortMonths();
    }

    public TimeZone getServerTimeZone() {
        return this.defaultDateFormat.getTimeZone();
    }

    private void setServerTimeZone(String str) {
        TimeZone timeZone = TimeZone.getDefault();
        if (str != null) {
            timeZone = TimeZone.getTimeZone(str);
        }
        this.defaultDateFormat.setTimeZone(timeZone);
        SimpleDateFormat simpleDateFormat = this.recentDateFormat;
        if (simpleDateFormat != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
    }

    public void configure(FTPClientConfig fTPClientConfig) {
        DateFormatSymbols dateFormatSymbols;
        String serverLanguageCode = fTPClientConfig.getServerLanguageCode();
        String shortMonthNames = fTPClientConfig.getShortMonthNames();
        if (shortMonthNames != null) {
            dateFormatSymbols = FTPClientConfig.getDateFormatSymbols(shortMonthNames);
        } else if (serverLanguageCode != null) {
            dateFormatSymbols = FTPClientConfig.lookupDateFormatSymbols(serverLanguageCode);
        } else {
            dateFormatSymbols = FTPClientConfig.lookupDateFormatSymbols(HyperVergeKycCapture.EN);
        }
        String recentDateFormatStr = fTPClientConfig.getRecentDateFormatStr();
        if (recentDateFormatStr == null) {
            this.recentDateFormat = null;
        } else {
            this.recentDateFormat = new SimpleDateFormat(recentDateFormatStr, dateFormatSymbols);
            this.recentDateFormat.setLenient(false);
        }
        String defaultDateFormatStr = fTPClientConfig.getDefaultDateFormatStr();
        if (defaultDateFormatStr != null) {
            this.defaultDateFormat = new SimpleDateFormat(defaultDateFormatStr, dateFormatSymbols);
            this.defaultDateFormat.setLenient(false);
            setServerTimeZone(fTPClientConfig.getServerTimeZoneId());
            this.lenientFutureDates = fTPClientConfig.isLenientFutureDates();
            return;
        }
        throw new IllegalArgumentException("defaultFormatString cannot be null");
    }

    /* access modifiers changed from: 0000 */
    public boolean isLenientFutureDates() {
        return this.lenientFutureDates;
    }

    /* access modifiers changed from: 0000 */
    public void setLenientFutureDates(boolean z) {
        this.lenientFutureDates = z;
    }
}
