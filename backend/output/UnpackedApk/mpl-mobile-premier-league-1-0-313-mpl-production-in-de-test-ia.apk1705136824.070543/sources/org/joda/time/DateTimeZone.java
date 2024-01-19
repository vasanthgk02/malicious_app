package org.joda.time;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.util.Constant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.convert.FromString;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.format.FormatUtils;
import org.joda.time.format.InternalParser;
import org.joda.time.tz.FixedDateTimeZone;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;

public abstract class DateTimeZone implements Serializable {
    public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;
    public static final AtomicReference<DateTimeZone> cDefault = new AtomicReference<>();
    public static final AtomicReference<NameProvider> cNameProvider = new AtomicReference<>();
    public static final AtomicReference<Provider> cProvider = new AtomicReference<>();
    public static final long serialVersionUID = 5546345482340108586L;
    public final String iID;

    public static final class LazyInit {
        public static final Map<String, String> CONVERSION_MAP;
        public static final DateTimeFormatter OFFSET_FORMATTER;

        static {
            HashMap outline88 = GeneratedOutlineSupport.outline88("GMT", "UTC", "WET", "WET");
            outline88.put("CET", "CET");
            outline88.put("MET", "CET");
            outline88.put("ECT", "CET");
            outline88.put("EET", "EET");
            outline88.put("MIT", "Pacific/Apia");
            outline88.put("HST", "Pacific/Honolulu");
            outline88.put("AST", "America/Anchorage");
            outline88.put("PST", "America/Los_Angeles");
            outline88.put("MST", "America/Denver");
            outline88.put("PNT", "America/Phoenix");
            outline88.put("CST", "America/Chicago");
            outline88.put("EST", "America/New_York");
            outline88.put("IET", "America/Indiana/Indianapolis");
            outline88.put("PRT", "America/Puerto_Rico");
            outline88.put("CNT", "America/St_Johns");
            outline88.put("AGT", "America/Argentina/Buenos_Aires");
            outline88.put("BET", "America/Sao_Paulo");
            outline88.put("ART", "Africa/Cairo");
            outline88.put("CAT", "Africa/Harare");
            outline88.put("EAT", "Africa/Addis_Ababa");
            outline88.put(Constant.TAG_CARD_SUBTYPE_NET, "Asia/Yerevan");
            outline88.put("PLT", "Asia/Karachi");
            outline88.put("IST", "Asia/Kolkata");
            outline88.put("BST", "Asia/Dhaka");
            outline88.put("VST", "Asia/Ho_Chi_Minh");
            outline88.put("CTT", "Asia/Shanghai");
            outline88.put("JST", "Asia/Tokyo");
            outline88.put("ACT", "Australia/Darwin");
            outline88.put("AET", "Australia/Sydney");
            outline88.put("SST", "Pacific/Guadalcanal");
            outline88.put("NST", "Pacific/Auckland");
            CONVERSION_MAP = Collections.unmodifiableMap(outline88);
            AnonymousClass1 r6 = new BaseChronology() {
                public static final long serialVersionUID = -3128740902654445468L;

                public DateTimeZone getZone() {
                    return null;
                }

                public String toString() {
                    return AnonymousClass1.class.getName();
                }

                public Chronology withUTC() {
                    return this;
                }

                public Chronology withZone(DateTimeZone dateTimeZone) {
                    return this;
                }
            };
            DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder.appendTimeZoneOffset(null, true, 2, 4);
            DateTimeFormatter formatter = dateTimeFormatterBuilder.toFormatter();
            if (formatter.iChrono != r6) {
                DateTimeFormatter dateTimeFormatter = new DateTimeFormatter(formatter.iPrinter, formatter.iParser, formatter.iLocale, formatter.iOffsetParsed, r6, formatter.iZone, formatter.iPivotYear, formatter.iDefaultYear);
                formatter = dateTimeFormatter;
            }
            OFFSET_FORMATTER = formatter;
        }
    }

    public static final class Stub implements Serializable {
        public static final long serialVersionUID = -6471952376487863581L;
        public transient String iID;

        public Stub(String str) {
            this.iID = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.iID = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return DateTimeZone.forID(this.iID);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.iID);
        }
    }

    public DateTimeZone(String str) {
        if (str != null) {
            this.iID = str;
            return;
        }
        throw new IllegalArgumentException("Id must not be null");
    }

    public static DateTimeZone fixedOffsetZone(String str, int i) {
        if (i == 0) {
            return UTC;
        }
        return new FixedDateTimeZone(str, null, i, i);
    }

    @FromString
    public static DateTimeZone forID(String str) {
        if (str == null) {
            return getDefault();
        }
        if (str.equals("UTC")) {
            return UTC;
        }
        DateTimeZone zone = getProvider().getZone(str);
        if (zone != null) {
            return zone;
        }
        if (str.startsWith(MqttTopic.SINGLE_LEVEL_WILDCARD) || str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            int parseOffset = parseOffset(str);
            if (((long) parseOffset) == 0) {
                return UTC;
            }
            return fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("The datetime zone id '", str, "' is not recognised"));
    }

    public static DateTimeZone forOffsetMillis(int i) {
        if (i >= -86399999 && i <= 86399999) {
            return fixedOffsetZone(printOffset(i), i);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Millis out of range: ", i));
    }

    public static DateTimeZone forTimeZone(TimeZone timeZone) {
        if (timeZone == null) {
            return getDefault();
        }
        String id = timeZone.getID();
        if (id == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        } else if (id.equals("UTC")) {
            return UTC;
        } else {
            DateTimeZone dateTimeZone = null;
            String str = LazyInit.CONVERSION_MAP.get(id);
            Provider provider = getProvider();
            if (str != null) {
                dateTimeZone = provider.getZone(str);
            }
            if (dateTimeZone == null) {
                dateTimeZone = provider.getZone(id);
            }
            if (dateTimeZone != null) {
                return dateTimeZone;
            }
            if (str != null || (!id.startsWith("GMT+") && !id.startsWith("GMT-"))) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("The datetime zone id '", id, "' is not recognised"));
            }
            String substring = id.substring(3);
            if (substring.length() > 2) {
                char charAt = substring.charAt(1);
                if (charAt > '9' && Character.isDigit(charAt)) {
                    StringBuilder sb = new StringBuilder(substring);
                    for (int i = 0; i < sb.length(); i++) {
                        int digit = Character.digit(sb.charAt(i), 10);
                        if (digit >= 0) {
                            sb.setCharAt(i, (char) (digit + 48));
                        }
                    }
                    substring = sb.toString();
                }
            }
            int parseOffset = parseOffset(substring);
            if (((long) parseOffset) == 0) {
                return UTC;
            }
            return fixedOffsetZone(printOffset(parseOffset), parseOffset);
        }
    }

    public static DateTimeZone getDefault() {
        DateTimeZone dateTimeZone = cDefault.get();
        if (dateTimeZone != null) {
            return dateTimeZone;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                dateTimeZone = forID(property);
            }
        } catch (RuntimeException unused) {
        }
        if (dateTimeZone == null) {
            try {
                dateTimeZone = forTimeZone(TimeZone.getDefault());
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (dateTimeZone == null) {
            dateTimeZone = UTC;
        }
        return !cDefault.compareAndSet(null, dateTimeZone) ? cDefault.get() : dateTimeZone;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.tz.Provider getDefaultProvider() {
        /*
            java.lang.Class<org.joda.time.tz.Provider> r0 = org.joda.time.tz.Provider.class
            java.lang.String r1 = "org.joda.time.DateTimeZone.Provider"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch:{ SecurityException -> 0x004f }
            if (r1 == 0) goto L_0x004f
            java.lang.Class<org.joda.time.DateTimeZone> r2 = org.joda.time.DateTimeZone.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x0048 }
            r3 = 0
            java.lang.Class r1 = java.lang.Class.forName(r1, r3, r2)     // Catch:{ Exception -> 0x0048 }
            boolean r2 = r0.isAssignableFrom(r1)     // Catch:{ Exception -> 0x0048 }
            if (r2 == 0) goto L_0x0031
            java.lang.Class r0 = r1.asSubclass(r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0048 }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r1)     // Catch:{ Exception -> 0x0048 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ Exception -> 0x0048 }
            org.joda.time.tz.Provider r0 = (org.joda.time.tz.Provider) r0     // Catch:{ Exception -> 0x0048 }
            validateProvider(r0)     // Catch:{ Exception -> 0x0048 }
            return r0
        L_0x0031:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0048 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048 }
            r2.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = "System property referred to class that does not implement "
            r2.append(r3)     // Catch:{ Exception -> 0x0048 }
            r2.append(r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0048 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0048 }
            throw r1     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ SecurityException -> 0x004f }
            r1.<init>(r0)     // Catch:{ SecurityException -> 0x004f }
            throw r1     // Catch:{ SecurityException -> 0x004f }
        L_0x004f:
            java.lang.String r0 = "org.joda.time.DateTimeZone.Folder"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x006c }
            if (r0 == 0) goto L_0x006c
            org.joda.time.tz.ZoneInfoProvider r1 = new org.joda.time.tz.ZoneInfoProvider     // Catch:{ Exception -> 0x0065 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0065 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0065 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0065 }
            validateProvider(r1)     // Catch:{ Exception -> 0x0065 }
            return r1
        L_0x0065:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ SecurityException -> 0x006c }
            r1.<init>(r0)     // Catch:{ SecurityException -> 0x006c }
            throw r1     // Catch:{ SecurityException -> 0x006c }
        L_0x006c:
            org.joda.time.tz.ZoneInfoProvider r0 = new org.joda.time.tz.ZoneInfoProvider     // Catch:{ Exception -> 0x0077 }
            java.lang.String r1 = "org/joda/time/tz/data"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0077 }
            validateProvider(r0)     // Catch:{ Exception -> 0x0077 }
            return r0
        L_0x0077:
            r0 = move-exception
            r0.printStackTrace()
            org.joda.time.tz.UTCProvider r0 = new org.joda.time.tz.UTCProvider
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.getDefaultProvider():org.joda.time.tz.Provider");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.tz.NameProvider getNameProvider() {
        /*
            java.util.concurrent.atomic.AtomicReference<org.joda.time.tz.NameProvider> r0 = cNameProvider
            java.lang.Object r0 = r0.get()
            org.joda.time.tz.NameProvider r0 = (org.joda.time.tz.NameProvider) r0
            if (r0 != 0) goto L_0x006f
            java.lang.Class<org.joda.time.tz.NameProvider> r0 = org.joda.time.tz.NameProvider.class
            r1 = 0
            java.lang.String r2 = "org.joda.time.DateTimeZone.NameProvider"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ SecurityException -> 0x0057 }
            if (r2 == 0) goto L_0x0057
            java.lang.Class<org.joda.time.DateTimeZone> r3 = org.joda.time.DateTimeZone.class
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ Exception -> 0x0050 }
            r4 = 0
            java.lang.Class r2 = java.lang.Class.forName(r2, r4, r3)     // Catch:{ Exception -> 0x0050 }
            boolean r3 = r0.isAssignableFrom(r2)     // Catch:{ Exception -> 0x0050 }
            if (r3 == 0) goto L_0x0039
            java.lang.Class r0 = r2.asSubclass(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0050 }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0050 }
            java.lang.Object r0 = r0.newInstance(r2)     // Catch:{ Exception -> 0x0050 }
            org.joda.time.tz.NameProvider r0 = (org.joda.time.tz.NameProvider) r0     // Catch:{ Exception -> 0x0050 }
            goto L_0x0058
        L_0x0039:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0050 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = "System property referred to class that does not implement "
            r3.append(r4)     // Catch:{ Exception -> 0x0050 }
            r3.append(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0050 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0050 }
            throw r2     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ SecurityException -> 0x0057 }
            r2.<init>(r0)     // Catch:{ SecurityException -> 0x0057 }
            throw r2     // Catch:{ SecurityException -> 0x0057 }
        L_0x0057:
            r0 = r1
        L_0x0058:
            if (r0 != 0) goto L_0x005f
            org.joda.time.tz.DefaultNameProvider r0 = new org.joda.time.tz.DefaultNameProvider
            r0.<init>()
        L_0x005f:
            java.util.concurrent.atomic.AtomicReference<org.joda.time.tz.NameProvider> r2 = cNameProvider
            boolean r1 = r2.compareAndSet(r1, r0)
            if (r1 != 0) goto L_0x006f
            java.util.concurrent.atomic.AtomicReference<org.joda.time.tz.NameProvider> r0 = cNameProvider
            java.lang.Object r0 = r0.get()
            org.joda.time.tz.NameProvider r0 = (org.joda.time.tz.NameProvider) r0
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTimeZone.getNameProvider():org.joda.time.tz.NameProvider");
    }

    public static Provider getProvider() {
        Provider provider = cProvider.get();
        if (provider != null) {
            return provider;
        }
        Provider defaultProvider = getDefaultProvider();
        return !cProvider.compareAndSet(null, defaultProvider) ? cProvider.get() : defaultProvider;
    }

    public static int parseOffset(String str) {
        DateTimeFormatter dateTimeFormatter = LazyInit.OFFSET_FORMATTER;
        InternalParser internalParser = dateTimeFormatter.iParser;
        if (internalParser != null) {
            DateTimeParserBucket dateTimeParserBucket = new DateTimeParserBucket(0, dateTimeFormatter.selectChronology(dateTimeFormatter.iChrono), dateTimeFormatter.iLocale, dateTimeFormatter.iPivotYear, dateTimeFormatter.iDefaultYear);
            int parseInto = internalParser.parseInto(dateTimeParserBucket, str, 0);
            if (parseInto < 0) {
                parseInto = ~parseInto;
            } else if (parseInto >= str.length()) {
                return -((int) dateTimeParserBucket.computeMillis(true, str));
            }
            throw new IllegalArgumentException(FormatUtils.createErrorMessage(str.toString(), parseInto));
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    public static String printOffset(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i = -i;
        }
        int i2 = i / 3600000;
        FormatUtils.appendPaddedInteger(stringBuffer, i2, 2);
        int i3 = i - (i2 * 3600000);
        int i4 = i3 / 60000;
        stringBuffer.append(':');
        try {
            FormatUtils.appendPaddedInteger((Appendable) stringBuffer, i4, 2);
        } catch (IOException unused) {
        }
        int i5 = i3 - (i4 * 60000);
        if (i5 == 0) {
            return stringBuffer.toString();
        }
        int i6 = i5 / 1000;
        stringBuffer.append(':');
        try {
            FormatUtils.appendPaddedInteger((Appendable) stringBuffer, i6, 2);
        } catch (IOException unused2) {
        }
        int i7 = i5 - (i6 * 1000);
        if (i7 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        try {
            FormatUtils.appendPaddedInteger((Appendable) stringBuffer, i7, 3);
        } catch (IOException unused3) {
        }
        return stringBuffer.toString();
    }

    public static Provider validateProvider(Provider provider) {
        Set<String> availableIDs = provider.getAvailableIDs();
        if (availableIDs == null || availableIDs.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        } else if (!availableIDs.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        } else if (UTC.equals(provider.getZone("UTC"))) {
            return provider;
        } else {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
    }

    public long convertLocalToUTC(long j, boolean z, long j2) {
        long j3;
        int offset = getOffset(j2);
        long j4 = j - ((long) offset);
        if (getOffset(j4) == offset) {
            return j4;
        }
        int offset2 = getOffset(j);
        long j5 = j - ((long) offset2);
        int offset3 = getOffset(j5);
        if (offset2 != offset3 && (z || offset2 < 0)) {
            long nextTransition = nextTransition(j5);
            long j6 = Long.MAX_VALUE;
            if (nextTransition == j5) {
                nextTransition = Long.MAX_VALUE;
            }
            long j7 = j - ((long) offset3);
            long nextTransition2 = nextTransition(j7);
            if (nextTransition2 != j7) {
                j6 = nextTransition2;
            }
            if (nextTransition != j6) {
                if (z) {
                    throw new IllegalInstantException(j, this.iID);
                }
                long j8 = (long) offset2;
                j3 = j - j8;
                if ((j ^ j3) < 0 || (j ^ j8) >= 0) {
                    return j3;
                }
                throw new ArithmeticException("Subtracting time zone offset caused overflow");
            }
        }
        offset2 = offset3;
        long j82 = (long) offset2;
        j3 = j - j82;
        if ((j ^ j3) < 0) {
        }
        return j3;
    }

    public long convertUTCToLocal(long j) {
        long offset = (long) getOffset(j);
        long j2 = j + offset;
        if ((j ^ j2) >= 0 || (j ^ offset) < 0) {
            return j2;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public abstract boolean equals(Object obj);

    public abstract String getNameKey(long j);

    public abstract int getOffset(long j);

    public int getOffsetFromLocal(long j) {
        int offset = getOffset(j);
        long j2 = j - ((long) offset);
        int offset2 = getOffset(j2);
        if (offset != offset2) {
            if (offset - offset2 < 0) {
                long nextTransition = nextTransition(j2);
                long j3 = Long.MAX_VALUE;
                if (nextTransition == j2) {
                    nextTransition = Long.MAX_VALUE;
                }
                long j4 = j - ((long) offset2);
                long nextTransition2 = nextTransition(j4);
                if (nextTransition2 != j4) {
                    j3 = nextTransition2;
                }
                if (nextTransition != j3) {
                    return offset;
                }
            }
        } else if (offset >= 0) {
            long previousTransition = previousTransition(j2);
            if (previousTransition < j2) {
                int offset3 = getOffset(previousTransition);
                if (j2 - previousTransition <= ((long) (offset3 - offset))) {
                    return offset3;
                }
            }
        }
        return offset2;
    }

    public abstract int getStandardOffset(long j);

    public int hashCode() {
        return this.iID.hashCode() + 57;
    }

    public abstract boolean isFixed();

    public abstract long nextTransition(long j);

    public abstract long previousTransition(long j);

    public String toString() {
        return this.iID;
    }

    public Object writeReplace() throws ObjectStreamException {
        return new Stub(this.iID);
    }
}
