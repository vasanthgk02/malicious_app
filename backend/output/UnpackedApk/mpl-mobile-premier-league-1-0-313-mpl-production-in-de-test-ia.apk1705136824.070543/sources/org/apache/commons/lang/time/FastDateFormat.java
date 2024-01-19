package org.apache.commons.lang.time;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.fontbox.cmap.CMapParser;

public class FastDateFormat extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final Map cDateInstanceCache = new HashMap(7);
    public static final Map cDateTimeInstanceCache = new HashMap(7);
    public static String cDefaultPattern = null;
    public static final Map cInstanceCache = new HashMap(7);
    public static final Map cTimeInstanceCache = new HashMap(7);
    public static final Map cTimeZoneDisplayCache = new HashMap(7);
    public static final long serialVersionUID = 1;
    public final Locale mLocale;
    public final boolean mLocaleForced;
    public transient int mMaxLengthEstimate;
    public final String mPattern;
    public transient Rule[] mRules;
    public final TimeZone mTimeZone;
    public final boolean mTimeZoneForced;

    public static class CharacterLiteral implements Rule {
        public final char mValue;

        public CharacterLiteral(char c2) {
            this.mValue = c2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return 1;
        }
    }

    public interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i);
    }

    public static class PaddedNumberField implements NumberRule {
        public final int mField;
        public final int mSize;

        public PaddedNumberField(int i, int i2) {
            if (i2 >= 3) {
                this.mField = i;
                this.mSize = i2;
                return;
            }
            throw new IllegalArgumentException();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            int i2;
            if (i < 100) {
                int i3 = this.mSize;
                while (true) {
                    i3--;
                    if (i3 >= 2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                }
            } else {
                if (i < 1000) {
                    i2 = 3;
                } else {
                    Validate.isTrue(i > -1, (String) "Negative values should not be possible", (long) i);
                    i2 = Integer.toString(i).length();
                }
                int i4 = this.mSize;
                while (true) {
                    i4--;
                    if (i4 >= i2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append(Integer.toString(i));
                        return;
                    }
                }
            }
        }
    }

    public static class Pair {
        public final Object mObj1;
        public final Object mObj2;

        public Pair(Object obj, Object obj2) {
            this.mObj1 = obj;
            this.mObj2 = obj2;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) obj;
            Object obj2 = this.mObj1;
            if (obj2 != null ? obj2.equals(pair.mObj1) : pair.mObj1 == null) {
                Object obj3 = this.mObj2;
                Object obj4 = pair.mObj2;
                if (obj3 != null) {
                }
            }
            z = false;
            return z;
        }

        public int hashCode() {
            Object obj = this.mObj1;
            int i = 0;
            int hashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.mObj2;
            if (obj2 != null) {
                i = obj2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("[");
            outline71.append(this.mObj1);
            outline71.append(':');
            outline71.append(this.mObj2);
            outline71.append(']');
            return outline71.toString();
        }
    }

    public interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    public static class StringLiteral implements Rule {
        public final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }

        public int estimateLength() {
            return this.mValue.length();
        }
    }

    public static class TextField implements Rule {
        public final int mField;
        public final String[] mValues;

        public TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }

        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }
    }

    public static class TimeZoneDisplayKey {
        public final Locale mLocale;
        public final int mStyle;
        public final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.mTimeZone = timeZone;
            this.mStyle = z ? i | LinearLayoutManager.INVALID_OFFSET : i;
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            if (!this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) || this.mStyle != timeZoneDisplayKey.mStyle || !this.mLocale.equals(timeZoneDisplayKey.mLocale)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.mLocale.hashCode() + (this.mStyle * 31);
        }
    }

    public static class TimeZoneNameRule implements Rule {
        public final String mDaylight;
        public final Locale mLocale;
        public final String mStandard;
        public final int mStyle;
        public final TimeZone mTimeZone;
        public final boolean mTimeZoneForced;

        public TimeZoneNameRule(TimeZone timeZone, boolean z, Locale locale, int i) {
            this.mTimeZone = timeZone;
            this.mTimeZoneForced = z;
            this.mLocale = locale;
            this.mStyle = i;
            if (z) {
                this.mStandard = FastDateFormat.getTimeZoneDisplay(timeZone, false, i, locale);
                this.mDaylight = FastDateFormat.getTimeZoneDisplay(timeZone, true, i, locale);
                return;
            }
            this.mStandard = null;
            this.mDaylight = null;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            if (!this.mTimeZoneForced) {
                TimeZone timeZone = calendar.getTimeZone();
                if (!timeZone.useDaylightTime() || calendar.get(16) == 0) {
                    stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
                } else {
                    stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
                }
            } else if (!this.mTimeZone.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(this.mStandard);
            } else {
                stringBuffer.append(this.mDaylight);
            }
        }

        public int estimateLength() {
            if (this.mTimeZoneForced) {
                return Math.max(this.mStandard.length(), this.mDaylight.length());
            }
            return this.mStyle == 0 ? 4 : 40;
        }
    }

    public static class TimeZoneNumberRule implements Rule {
        public static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        public static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        public final boolean mColon;

        public TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(16) + calendar.get(15);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / 3600000;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.mColon) {
                stringBuffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            stringBuffer.append((char) ((i3 / 10) + 48));
            stringBuffer.append((char) ((i3 % 10) + 48));
        }

        public int estimateLength() {
            return 5;
        }
    }

    public static class TwelveHourField implements NumberRule {
        public final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    public static class TwentyFourHourField implements NumberRule {
        public final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    public static class TwoDigitMonthField implements NumberRule {
        public static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    public static class TwoDigitNumberField implements NumberRule {
        public final int mField;

        public TwoDigitNumberField(int i) {
            this.mField = i;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
                return;
            }
            stringBuffer.append(Integer.toString(i));
        }
    }

    public static class TwoDigitYearField implements NumberRule {
        public static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    public static class UnpaddedMonthField implements NumberRule {
        public static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public int estimateLength() {
            return 2;
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
                return;
            }
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    public static class UnpaddedNumberField implements NumberRule {
        public static final UnpaddedNumberField INSTANCE_YEAR = new UnpaddedNumberField(1);
        public final int mField;

        public UnpaddedNumberField(int i) {
            this.mField = i;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public int estimateLength() {
            return 4;
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            } else {
                stringBuffer.append(Integer.toString(i));
            }
        }
    }

    public FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        if (str != null) {
            this.mPattern = str;
            boolean z = true;
            this.mTimeZoneForced = timeZone != null;
            this.mTimeZone = timeZone == null ? TimeZone.getDefault() : timeZone;
            this.mLocaleForced = locale == null ? false : z;
            this.mLocale = locale == null ? Locale.getDefault() : locale;
            return;
        }
        throw new IllegalArgumentException("The pattern must not be null");
    }

    public static FastDateFormat getDateInstance(int i) {
        return getDateInstance(i, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2) {
        return getDateTimeInstance(i, i2, null, null);
    }

    public static synchronized String getDefaultPattern() {
        String str;
        synchronized (FastDateFormat.class) {
            if (cDefaultPattern == null) {
                cDefaultPattern = new SimpleDateFormat().toPattern();
            }
            str = cDefaultPattern;
        }
        return str;
    }

    public static FastDateFormat getInstance() {
        return getInstance(getDefaultPattern(), null, null);
    }

    public static FastDateFormat getTimeInstance(int i) {
        return getTimeInstance(i, null, null);
    }

    public static synchronized String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        String str;
        synchronized (FastDateFormat.class) {
            TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i, locale);
            str = (String) cTimeZoneDisplayCache.get(timeZoneDisplayKey);
            if (str == null) {
                str = timeZone.getDisplayName(z, i, locale);
                cTimeZoneDisplayCache.put(timeZoneDisplayKey, str);
            }
        }
        return str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        for (Rule appendTo : this.mRules) {
            appendTo.appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        FastDateFormat fastDateFormat = (FastDateFormat) obj;
        String str = this.mPattern;
        String str2 = fastDateFormat.mPattern;
        if (str == str2 || str.equals(str2)) {
            TimeZone timeZone = this.mTimeZone;
            TimeZone timeZone2 = fastDateFormat.mTimeZone;
            if (timeZone == timeZone2 || timeZone.equals(timeZone2)) {
                Locale locale = this.mLocale;
                Locale locale2 = fastDateFormat.mLocale;
                if ((locale == locale2 || locale.equals(locale2)) && this.mTimeZoneForced == fastDateFormat.mTimeZoneForced && this.mLocaleForced == fastDateFormat.mLocaleForced) {
                    return true;
                }
            }
        }
        return false;
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("Unknown class: ");
        outline71.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(outline71.toString());
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public boolean getTimeZoneOverridesCalendar() {
        return this.mTimeZoneForced;
    }

    public int hashCode() {
        return this.mLocale.hashCode() + this.mTimeZone.hashCode() + this.mPattern.hashCode() + 0 + (this.mTimeZoneForced ? 1 : 0) + (this.mLocaleForced ? 1 : 0);
    }

    public void init() {
        List parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i;
                return;
            }
        }
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        parsePosition.setIndex(0);
        parsePosition.setErrorIndex(0);
        return null;
    }

    public List parsePattern() {
        Object obj;
        Object textField;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            iArr[i] = i2;
            String parseToken = parseToken(this.mPattern, iArr);
            int i3 = iArr[i];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(i);
            if (charAt != 'y') {
                if (charAt != 'z') {
                    switch (charAt) {
                        case '\'':
                            String substring = parseToken.substring(1);
                            if (substring.length() != 1) {
                                obj = new StringLiteral(substring);
                                break;
                            } else {
                                obj = new CharacterLiteral(substring.charAt(0));
                                break;
                            }
                        case 'K':
                            obj = selectNumberRule(10, length2);
                            break;
                        case 'M':
                            if (length2 < 4) {
                                if (length2 != 3) {
                                    if (length2 != 2) {
                                        obj = UnpaddedMonthField.INSTANCE;
                                        break;
                                    } else {
                                        obj = TwoDigitMonthField.INSTANCE;
                                        break;
                                    }
                                } else {
                                    textField = new TextField(2, shortMonths);
                                }
                            } else {
                                textField = new TextField(2, months);
                            }
                            obj = textField;
                            break;
                        case 'S':
                            obj = selectNumberRule(14, length2);
                            break;
                        case 'W':
                            obj = selectNumberRule(4, length2);
                            break;
                        case 'Z':
                            if (length2 != 1) {
                                obj = TimeZoneNumberRule.INSTANCE_COLON;
                                break;
                            } else {
                                obj = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                break;
                            }
                        case 'a':
                            obj = new TextField(9, amPmStrings);
                            break;
                        case 'd':
                            obj = selectNumberRule(5, length2);
                            break;
                        case 'h':
                            obj = new TwelveHourField(selectNumberRule(10, length2));
                            break;
                        case 'k':
                            obj = new TwentyFourHourField(selectNumberRule(11, length2));
                            break;
                        case 'm':
                            obj = selectNumberRule(12, length2);
                            break;
                        case 's':
                            obj = selectNumberRule(13, length2);
                            break;
                        case 'w':
                            obj = selectNumberRule(3, length2);
                            break;
                        default:
                            switch (charAt) {
                                case 'D':
                                    obj = selectNumberRule(6, length2);
                                    break;
                                case 'E':
                                    new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                    break;
                                case 'F':
                                    obj = selectNumberRule(8, length2);
                                    break;
                                case 'G':
                                    obj = new TextField(0, eras);
                                    break;
                                case 'H':
                                    obj = selectNumberRule(11, length2);
                                    break;
                                default:
                                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline49("Illegal pattern component: ", parseToken));
                            }
                    }
                } else if (length2 >= 4) {
                    obj = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
                } else {
                    obj = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
                }
            } else if (length2 >= 4) {
                obj = selectNumberRule(1, length2);
            } else {
                obj = TwoDigitYearField.INSTANCE;
            }
            arrayList.add(obj);
            i2 = i3 + 1;
            i = 0;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            stringBuffer.append(charAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || str.charAt(i2) != charAt) {
                    break;
                }
                stringBuffer.append(charAt);
                i = i2;
            }
        } else {
            stringBuffer.append(ExtendedMessageFormat.QUOTE);
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
                        stringBuffer.append(charAt2);
                        i = i3;
                    }
                } else if (z || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    stringBuffer.append(charAt2);
                }
                i++;
            }
            i--;
        }
        iArr[0] = i;
        return stringBuffer.toString();
    }

    public NumberRule selectNumberRule(int i, int i2) {
        if (i2 == 1) {
            return new UnpaddedNumberField(i);
        }
        if (i2 != 2) {
            return new PaddedNumberField(i, i2);
        }
        return new TwoDigitNumberField(i);
    }

    public String toString() {
        StringBuffer outline71 = GeneratedOutlineSupport.outline71("FastDateFormat[");
        outline71.append(this.mPattern);
        outline71.append(CMapParser.MARK_END_OF_ARRAY);
        return outline71.toString();
    }

    public static FastDateFormat getDateInstance(int i, Locale locale) {
        return getDateInstance(i, null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, Locale locale) {
        return getDateTimeInstance(i, i2, null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return getInstance(str, null, null);
    }

    public static FastDateFormat getTimeInstance(int i, Locale locale) {
        return getTimeInstance(i, null, locale);
    }

    public static FastDateFormat getDateInstance(int i, TimeZone timeZone) {
        return getDateInstance(i, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone) {
        return getDateTimeInstance(i, i2, timeZone, null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return getInstance(str, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(int i, TimeZone timeZone) {
        return getTimeInstance(i, timeZone, null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized org.apache.commons.lang.time.FastDateFormat getDateInstance(int r3, java.util.TimeZone r4, java.util.Locale r5) {
        /*
            java.lang.Class<org.apache.commons.lang.time.FastDateFormat> r0 = org.apache.commons.lang.time.FastDateFormat.class
            monitor-enter(r0)
            java.lang.Integer r1 = new java.lang.Integer     // Catch:{ all -> 0x0052 }
            r1.<init>(r3)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0010
            org.apache.commons.lang.time.FastDateFormat$Pair r2 = new org.apache.commons.lang.time.FastDateFormat$Pair     // Catch:{ all -> 0x0052 }
            r2.<init>(r1, r4)     // Catch:{ all -> 0x0052 }
            r1 = r2
        L_0x0010:
            if (r5 != 0) goto L_0x0016
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0052 }
        L_0x0016:
            org.apache.commons.lang.time.FastDateFormat$Pair r2 = new org.apache.commons.lang.time.FastDateFormat$Pair     // Catch:{ all -> 0x0052 }
            r2.<init>(r1, r5)     // Catch:{ all -> 0x0052 }
            java.util.Map r1 = cDateInstanceCache     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0052 }
            org.apache.commons.lang.time.FastDateFormat r1 = (org.apache.commons.lang.time.FastDateFormat) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x0050
            java.text.DateFormat r3 = java.text.DateFormat.getDateInstance(r3, r5)     // Catch:{ ClassCastException -> 0x0039 }
            java.text.SimpleDateFormat r3 = (java.text.SimpleDateFormat) r3     // Catch:{ ClassCastException -> 0x0039 }
            java.lang.String r3 = r3.toPattern()     // Catch:{ ClassCastException -> 0x0039 }
            org.apache.commons.lang.time.FastDateFormat r1 = getInstance(r3, r4, r5)     // Catch:{ ClassCastException -> 0x0039 }
            java.util.Map r3 = cDateInstanceCache     // Catch:{ ClassCastException -> 0x0039 }
            r3.put(r2, r1)     // Catch:{ ClassCastException -> 0x0039 }
            goto L_0x0050
        L_0x0039:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0052 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ all -> 0x0052 }
            r4.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = "No date pattern for locale: "
            r4.append(r1)     // Catch:{ all -> 0x0052 }
            r4.append(r5)     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0052 }
            r3.<init>(r4)     // Catch:{ all -> 0x0052 }
            throw r3     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r0)
            return r1
        L_0x0052:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.time.FastDateFormat.getDateInstance(int, java.util.TimeZone, java.util.Locale):org.apache.commons.lang.time.FastDateFormat");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0043 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized org.apache.commons.lang.time.FastDateFormat getDateTimeInstance(int r4, int r5, java.util.TimeZone r6, java.util.Locale r7) {
        /*
            java.lang.Class<org.apache.commons.lang.time.FastDateFormat> r0 = org.apache.commons.lang.time.FastDateFormat.class
            monitor-enter(r0)
            org.apache.commons.lang.time.FastDateFormat$Pair r1 = new org.apache.commons.lang.time.FastDateFormat$Pair     // Catch:{ all -> 0x005c }
            java.lang.Integer r2 = new java.lang.Integer     // Catch:{ all -> 0x005c }
            r2.<init>(r4)     // Catch:{ all -> 0x005c }
            java.lang.Integer r3 = new java.lang.Integer     // Catch:{ all -> 0x005c }
            r3.<init>(r5)     // Catch:{ all -> 0x005c }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x001a
            org.apache.commons.lang.time.FastDateFormat$Pair r2 = new org.apache.commons.lang.time.FastDateFormat$Pair     // Catch:{ all -> 0x005c }
            r2.<init>(r1, r6)     // Catch:{ all -> 0x005c }
            r1 = r2
        L_0x001a:
            if (r7 != 0) goto L_0x0020
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ all -> 0x005c }
        L_0x0020:
            org.apache.commons.lang.time.FastDateFormat$Pair r2 = new org.apache.commons.lang.time.FastDateFormat$Pair     // Catch:{ all -> 0x005c }
            r2.<init>(r1, r7)     // Catch:{ all -> 0x005c }
            java.util.Map r1 = cDateTimeInstanceCache     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x005c }
            org.apache.commons.lang.time.FastDateFormat r1 = (org.apache.commons.lang.time.FastDateFormat) r1     // Catch:{ all -> 0x005c }
            if (r1 != 0) goto L_0x005a
            java.text.DateFormat r4 = java.text.DateFormat.getDateTimeInstance(r4, r5, r7)     // Catch:{ ClassCastException -> 0x0043 }
            java.text.SimpleDateFormat r4 = (java.text.SimpleDateFormat) r4     // Catch:{ ClassCastException -> 0x0043 }
            java.lang.String r4 = r4.toPattern()     // Catch:{ ClassCastException -> 0x0043 }
            org.apache.commons.lang.time.FastDateFormat r1 = getInstance(r4, r6, r7)     // Catch:{ ClassCastException -> 0x0043 }
            java.util.Map r4 = cDateTimeInstanceCache     // Catch:{ ClassCastException -> 0x0043 }
            r4.put(r2, r1)     // Catch:{ ClassCastException -> 0x0043 }
            goto L_0x005a
        L_0x0043:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005c }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x005c }
            r5.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r6 = "No date time pattern for locale: "
            r5.append(r6)     // Catch:{ all -> 0x005c }
            r5.append(r7)     // Catch:{ all -> 0x005c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x005c }
            r4.<init>(r5)     // Catch:{ all -> 0x005c }
            throw r4     // Catch:{ all -> 0x005c }
        L_0x005a:
            monitor-exit(r0)
            return r1
        L_0x005c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.time.FastDateFormat.getDateTimeInstance(int, int, java.util.TimeZone, java.util.Locale):org.apache.commons.lang.time.FastDateFormat");
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return getInstance(str, null, locale);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:(1:11)|12|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized org.apache.commons.lang.time.FastDateFormat getTimeInstance(int r3, java.util.TimeZone r4, java.util.Locale r5) {
        /*
            java.lang.Class<org.apache.commons.lang.time.FastDateFormat> r0 = org.apache.commons.lang.time.FastDateFormat.class
            monitor-enter(r0)
            java.lang.Integer r1 = new java.lang.Integer     // Catch:{ all -> 0x0055 }
            r1.<init>(r3)     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x0010
            org.apache.commons.lang.time.FastDateFormat$Pair r2 = new org.apache.commons.lang.time.FastDateFormat$Pair     // Catch:{ all -> 0x0055 }
            r2.<init>(r1, r4)     // Catch:{ all -> 0x0055 }
            r1 = r2
        L_0x0010:
            if (r5 == 0) goto L_0x0018
            org.apache.commons.lang.time.FastDateFormat$Pair r2 = new org.apache.commons.lang.time.FastDateFormat$Pair     // Catch:{ all -> 0x0055 }
            r2.<init>(r1, r5)     // Catch:{ all -> 0x0055 }
            r1 = r2
        L_0x0018:
            java.util.Map r2 = cTimeInstanceCache     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0055 }
            org.apache.commons.lang.time.FastDateFormat r2 = (org.apache.commons.lang.time.FastDateFormat) r2     // Catch:{ all -> 0x0055 }
            if (r2 != 0) goto L_0x0053
            if (r5 != 0) goto L_0x0028
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0055 }
        L_0x0028:
            java.text.DateFormat r3 = java.text.DateFormat.getTimeInstance(r3, r5)     // Catch:{ ClassCastException -> 0x003c }
            java.text.SimpleDateFormat r3 = (java.text.SimpleDateFormat) r3     // Catch:{ ClassCastException -> 0x003c }
            java.lang.String r3 = r3.toPattern()     // Catch:{ ClassCastException -> 0x003c }
            org.apache.commons.lang.time.FastDateFormat r2 = getInstance(r3, r4, r5)     // Catch:{ ClassCastException -> 0x003c }
            java.util.Map r3 = cTimeInstanceCache     // Catch:{ ClassCastException -> 0x003c }
            r3.put(r1, r2)     // Catch:{ ClassCastException -> 0x003c }
            goto L_0x0053
        L_0x003c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0055 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ all -> 0x0055 }
            r4.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "No date pattern for locale: "
            r4.append(r1)     // Catch:{ all -> 0x0055 }
            r4.append(r5)     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0055 }
            r3.<init>(r4)     // Catch:{ all -> 0x0055 }
            throw r3     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r0)
            return r2
        L_0x0055:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.time.FastDateFormat.getTimeInstance(int, java.util.TimeZone, java.util.Locale):org.apache.commons.lang.time.FastDateFormat");
    }

    public static synchronized FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            try {
                fastDateFormat = new FastDateFormat(str, timeZone, locale);
                FastDateFormat fastDateFormat2 = (FastDateFormat) cInstanceCache.get(fastDateFormat);
                if (fastDateFormat2 == null) {
                    fastDateFormat.init();
                    cInstanceCache.put(fastDateFormat, fastDateFormat);
                } else {
                    fastDateFormat = fastDateFormat2;
                }
            }
        }
        return fastDateFormat;
    }

    public String format(long j) {
        return format(new Date(j));
    }

    public String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        return format(new Date(j), stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        if (this.mTimeZoneForced) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return applyRules(calendar, stringBuffer);
    }
}
