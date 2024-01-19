package org.joda.time.format;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.MutableDateTime.Property;
import org.joda.time.ReadablePartial;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDateTimeField;
import org.joda.time.format.DateTimeParserBucket.SavedField;
import org.joda.time.tz.DefaultNameProvider;
import org.joda.time.tz.NameProvider;

public class DateTimeFormatterBuilder {
    public ArrayList<Object> iElementPairs = new ArrayList<>();
    public Object iFormatter;

    public static class CharacterLiteral implements InternalPrinter, InternalParser {
        public final char iValue;

        public CharacterLiteral(char c2) {
            this.iValue = c2;
        }

        public int estimateParsedLength() {
            return 1;
        }

        public int estimatePrintedLength() {
            return 1;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            if (i >= charSequence.length()) {
                return ~i;
            }
            char charAt = charSequence.charAt(i);
            char c2 = this.iValue;
            if (charAt != c2) {
                char upperCase = Character.toUpperCase(charAt);
                char upperCase2 = Character.toUpperCase(c2);
                if (!(upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2))) {
                    return ~i;
                }
            }
            return i + 1;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }
    }

    public static class Composite implements InternalPrinter, InternalParser {
        public final int iParsedLengthEstimate;
        public final InternalParser[] iParsers;
        public final int iPrintedLengthEstimate;
        public final InternalPrinter[] iPrinters;

        public Composite(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = list.get(i);
                if (obj instanceof Composite) {
                    InternalPrinter[] internalPrinterArr = ((Composite) obj).iPrinters;
                    if (internalPrinterArr != null) {
                        for (InternalPrinter add : internalPrinterArr) {
                            arrayList.add(add);
                        }
                    }
                } else {
                    arrayList.add(obj);
                }
                Object obj2 = list.get(i + 1);
                if (obj2 instanceof Composite) {
                    InternalParser[] internalParserArr = ((Composite) obj2).iParsers;
                    if (internalParserArr != null) {
                        for (InternalParser add2 : internalParserArr) {
                            arrayList2.add(add2);
                        }
                    }
                } else {
                    arrayList2.add(obj2);
                }
            }
            if (arrayList.contains(null) || arrayList.isEmpty()) {
                this.iPrinters = null;
                this.iPrintedLengthEstimate = 0;
            } else {
                int size2 = arrayList.size();
                this.iPrinters = new InternalPrinter[size2];
                int i2 = 0;
                for (int i3 = 0; i3 < size2; i3++) {
                    InternalPrinter internalPrinter = (InternalPrinter) arrayList.get(i3);
                    i2 += internalPrinter.estimatePrintedLength();
                    this.iPrinters[i3] = internalPrinter;
                }
                this.iPrintedLengthEstimate = i2;
            }
            if (arrayList2.contains(null) || arrayList2.isEmpty()) {
                this.iParsers = null;
                this.iParsedLengthEstimate = 0;
                return;
            }
            int size3 = arrayList2.size();
            this.iParsers = new InternalParser[size3];
            int i4 = 0;
            for (int i5 = 0; i5 < size3; i5++) {
                InternalParser internalParser = (InternalParser) arrayList2.get(i5);
                i4 += internalParser.estimateParsedLength();
                this.iParsers[i5] = internalParser;
            }
            this.iParsedLengthEstimate = i4;
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        public int estimatePrintedLength() {
            return this.iPrintedLengthEstimate;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            InternalParser[] internalParserArr = this.iParsers;
            if (internalParserArr != null) {
                int length = internalParserArr.length;
                for (int i2 = 0; i2 < length && i >= 0; i2++) {
                    i = internalParserArr[i2].parseInto(dateTimeParserBucket, charSequence, i);
                }
                return i;
            }
            throw new UnsupportedOperationException();
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            InternalPrinter[] internalPrinterArr = this.iPrinters;
            if (internalPrinterArr != null) {
                Locale locale2 = locale == null ? Locale.getDefault() : locale;
                for (InternalPrinter printTo : internalPrinterArr) {
                    printTo.printTo(appendable, j, chronology, i, dateTimeZone, locale2);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }
    }

    public static class FixedNumber extends PaddedNumber {
        public FixedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z, i);
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int parseInto = super.parseInto(dateTimeParserBucket, charSequence, i);
            if (parseInto < 0) {
                return parseInto;
            }
            int i2 = this.iMaxParsedDigits + i;
            if (parseInto != i2) {
                if (this.iSigned) {
                    char charAt = charSequence.charAt(i);
                    if (charAt == '-' || charAt == '+') {
                        i2++;
                    }
                }
                if (parseInto > i2) {
                    return ~(i2 + 1);
                }
                if (parseInto < i2) {
                    parseInto = ~parseInto;
                }
            }
            return parseInto;
        }
    }

    public static class Fraction implements InternalPrinter, InternalParser {
        public final DateTimeFieldType iFieldType;
        public int iMaxDigits;
        public int iMinDigits;

        public Fraction(DateTimeFieldType dateTimeFieldType, int i, int i2) {
            this.iFieldType = dateTimeFieldType;
            i2 = i2 > 18 ? 18 : i2;
            this.iMinDigits = i;
            this.iMaxDigits = i2;
        }

        public int estimateParsedLength() {
            return this.iMaxDigits;
        }

        public int estimatePrintedLength() {
            return this.iMaxDigits;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            DateTimeField field = this.iFieldType.getField(dateTimeParserBucket.iChrono);
            int min = Math.min(this.iMaxDigits, charSequence.length() - i);
            long j = 0;
            long unitMillis = field.getDurationField().getUnitMillis() * 10;
            int i2 = 0;
            while (i2 < min) {
                char charAt = charSequence.charAt(i + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2++;
                unitMillis /= 10;
                j += ((long) (charAt - '0')) * unitMillis;
            }
            long j2 = j / 10;
            if (i2 == 0) {
                return ~i;
            }
            if (j2 > 2147483647L) {
                return ~i;
            }
            PreciseDateTimeField preciseDateTimeField = new PreciseDateTimeField(DateTimeFieldType.MILLIS_OF_SECOND_TYPE, MillisDurationField.INSTANCE, field.getDurationField());
            SavedField obtainSaveField = dateTimeParserBucket.obtainSaveField();
            obtainSaveField.iField = preciseDateTimeField;
            obtainSaveField.iValue = (int) j2;
            obtainSaveField.iText = null;
            obtainSaveField.iLocale = null;
            return i + i2;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            long j2;
            String str;
            DateTimeField field = this.iFieldType.getField(chronology);
            int i2 = this.iMinDigits;
            try {
                long remainder = field.remainder(j);
                if (remainder == 0) {
                    while (true) {
                        i2--;
                        if (i2 >= 0) {
                            appendable.append('0');
                        } else {
                            return;
                        }
                    }
                } else {
                    long unitMillis = field.getDurationField().getUnitMillis();
                    int i3 = this.iMaxDigits;
                    while (true) {
                        switch (i3) {
                            case 1:
                                j2 = 10;
                                break;
                            case 2:
                                j2 = 100;
                                break;
                            case 3:
                                j2 = 1000;
                                break;
                            case 4:
                                j2 = MqttAsyncClient.DISCONNECT_TIMEOUT;
                                break;
                            case 5:
                                j2 = 100000;
                                break;
                            case 6:
                                j2 = 1000000;
                                break;
                            case 7:
                                j2 = 10000000;
                                break;
                            case 8:
                                j2 = 100000000;
                                break;
                            case 9:
                                j2 = 1000000000;
                                break;
                            case 10:
                                j2 = 10000000000L;
                                break;
                            case 11:
                                j2 = 100000000000L;
                                break;
                            case 12:
                                j2 = 1000000000000L;
                                break;
                            case 13:
                                j2 = 10000000000000L;
                                break;
                            case 14:
                                j2 = 100000000000000L;
                                break;
                            case 15:
                                j2 = 1000000000000000L;
                                break;
                            case 16:
                                j2 = 10000000000000000L;
                                break;
                            case 17:
                                j2 = 100000000000000000L;
                                break;
                            case 18:
                                j2 = 1000000000000000000L;
                                break;
                            default:
                                j2 = 1;
                                break;
                        }
                        if ((unitMillis * j2) / j2 == unitMillis) {
                            long j3 = (remainder * j2) / unitMillis;
                            long[] jArr = {j3, (long) i3};
                            long j4 = jArr[0];
                            int i4 = (int) jArr[1];
                            if ((2147483647L & j4) == j4) {
                                str = Integer.toString((int) j4);
                            } else {
                                str = Long.toString(j4);
                            }
                            int length = str.length();
                            while (length < i4) {
                                appendable.append('0');
                                i2--;
                                i4--;
                            }
                            if (i2 < i4) {
                                while (i2 < i4 && length > 1) {
                                    int i5 = length - 1;
                                    if (str.charAt(i5) == '0') {
                                        i4--;
                                        length = i5;
                                    }
                                }
                                if (length < str.length()) {
                                    for (int i6 = 0; i6 < length; i6++) {
                                        appendable.append(str.charAt(i6));
                                    }
                                    return;
                                }
                            }
                            appendable.append(str);
                            return;
                        }
                        i3--;
                    }
                }
            } catch (RuntimeException unused) {
                while (true) {
                    i2--;
                    if (i2 >= 0) {
                        appendable.append(65533);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static class MatchingParser implements InternalParser {
        public final int iParsedLengthEstimate;
        public final InternalParser[] iParsers;

        public MatchingParser(InternalParser[] internalParserArr) {
            this.iParsers = internalParserArr;
            int length = internalParserArr.length;
            int i = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    InternalParser internalParser = internalParserArr[length];
                    if (internalParser != null) {
                        int estimateParsedLength = internalParser.estimateParsedLength();
                        if (estimateParsedLength > i) {
                            i = estimateParsedLength;
                        }
                    }
                } else {
                    this.iParsedLengthEstimate = i;
                    return;
                }
            }
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
            if (r6 > r12) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
            if (r6 != r12) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
            if (r4 == false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
            return ~r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005c, code lost:
            if (r3 == null) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005e, code lost:
            r10.restoreState(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
            return r6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r10, java.lang.CharSequence r11, int r12) {
            /*
                r9 = this;
                org.joda.time.format.InternalParser[] r0 = r9.iParsers
                int r1 = r0.length
                java.lang.Object r2 = r10.iSavedState
                if (r2 != 0) goto L_0x000e
                org.joda.time.format.DateTimeParserBucket$SavedState r2 = new org.joda.time.format.DateTimeParserBucket$SavedState
                r2.<init>()
                r10.iSavedState = r2
            L_0x000e:
                java.lang.Object r2 = r10.iSavedState
                r3 = 0
                r4 = 0
                r6 = r12
                r7 = r6
                r5 = 0
            L_0x0015:
                if (r5 >= r1) goto L_0x0053
                r8 = r0[r5]
                if (r8 != 0) goto L_0x0020
                if (r6 > r12) goto L_0x001e
                return r12
            L_0x001e:
                r4 = 1
                goto L_0x0053
            L_0x0020:
                int r8 = r8.parseInto(r10, r11, r12)
                if (r8 < r12) goto L_0x0047
                if (r8 <= r6) goto L_0x004d
                int r3 = r11.length()
                if (r8 >= r3) goto L_0x0046
                int r3 = r5 + 1
                if (r3 >= r1) goto L_0x0046
                r3 = r0[r3]
                if (r3 != 0) goto L_0x0037
                goto L_0x0046
            L_0x0037:
                java.lang.Object r3 = r10.iSavedState
                if (r3 != 0) goto L_0x0042
                org.joda.time.format.DateTimeParserBucket$SavedState r3 = new org.joda.time.format.DateTimeParserBucket$SavedState
                r3.<init>()
                r10.iSavedState = r3
            L_0x0042:
                java.lang.Object r3 = r10.iSavedState
                r6 = r8
                goto L_0x004d
            L_0x0046:
                return r8
            L_0x0047:
                if (r8 >= 0) goto L_0x004d
                int r8 = ~r8
                if (r8 <= r7) goto L_0x004d
                r7 = r8
            L_0x004d:
                r10.restoreState(r2)
                int r5 = r5 + 1
                goto L_0x0015
            L_0x0053:
                if (r6 > r12) goto L_0x005c
                if (r6 != r12) goto L_0x005a
                if (r4 == 0) goto L_0x005a
                goto L_0x005c
            L_0x005a:
                int r10 = ~r7
                return r10
            L_0x005c:
                if (r3 == 0) goto L_0x0061
                r10.restoreState(r3)
            L_0x0061:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.MatchingParser.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.CharSequence, int):int");
        }
    }

    public static abstract class NumberFormatter implements InternalPrinter, InternalParser {
        public final DateTimeFieldType iFieldType;
        public final int iMaxParsedDigits;
        public final boolean iSigned;

        public NumberFormatter(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.iFieldType = dateTimeFieldType;
            this.iMaxParsedDigits = i;
            this.iSigned = z;
        }

        public int estimateParsedLength() {
            return this.iMaxParsedDigits;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            int i3;
            boolean z;
            boolean z2;
            CharSequence charSequence2 = charSequence;
            int i4 = i;
            int min = Math.min(this.iMaxParsedDigits, charSequence.length() - i4);
            int i5 = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                if (i5 >= min) {
                    break;
                }
                int i6 = i4 + i5;
                char charAt = charSequence2.charAt(i6);
                if (i5 != 0 || ((charAt != '-' && charAt != '+') || !this.iSigned)) {
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i5++;
                } else {
                    z = true;
                    z2 = charAt == '-';
                    if (charAt != '+') {
                        z = false;
                    }
                    int i7 = i5 + 1;
                    if (i7 >= min) {
                        break;
                    }
                    char charAt2 = charSequence2.charAt(i6 + 1);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    min = Math.min(min + 1, charSequence.length() - i4);
                    i5 = i7;
                    boolean z5 = z2;
                    z4 = z;
                    z3 = z5;
                }
            }
            boolean z6 = z2;
            z4 = z;
            z3 = z6;
            if (i5 == 0) {
                return ~i4;
            }
            if (i5 < 9) {
                int i8 = (z3 || z4) ? i4 + 1 : i4;
                int i9 = i8 + 1;
                try {
                    int charAt3 = charSequence2.charAt(i8) - '0';
                    i2 = i4 + i5;
                    while (i9 < i2) {
                        int charAt4 = (charSequence2.charAt(i9) + ((charAt3 << 3) + (charAt3 << 1))) - 48;
                        i9++;
                        charAt3 = charAt4;
                    }
                    i3 = z3 ? -charAt3 : charAt3;
                } catch (StringIndexOutOfBoundsException unused) {
                    return ~i4;
                }
            } else if (z4) {
                int i10 = i4 + 1;
                i2 = i4 + i5;
                i3 = Integer.parseInt(charSequence2.subSequence(i10, i2).toString());
            } else {
                int i11 = i4 + i5;
                i3 = Integer.parseInt(charSequence2.subSequence(i4, i11).toString());
                i2 = i11;
            }
            dateTimeParserBucket.saveField(this.iFieldType, i3);
            return i2;
        }
    }

    public static class PaddedNumber extends NumberFormatter {
        public final int iMinPrintedDigits;

        public PaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z, int i2) {
            super(dateTimeFieldType, i, z);
            this.iMinPrintedDigits = i2;
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.appendPaddedInteger(appendable, this.iFieldType.getField(chronology).get(j), this.iMinPrintedDigits);
            } catch (RuntimeException unused) {
                int i2 = this.iMinPrintedDigits;
                while (true) {
                    i2--;
                    if (i2 >= 0) {
                        appendable.append(65533);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static class StringLiteral implements InternalPrinter, InternalParser {
        public final String iValue;

        public StringLiteral(String str) {
            this.iValue = str;
        }

        public int estimateParsedLength() {
            return this.iValue.length();
        }

        public int estimatePrintedLength() {
            return this.iValue.length();
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            return DateTimeFormatterBuilder.csStartsWithIgnoreCase(charSequence, i, this.iValue) ? this.iValue.length() + i : ~i;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }
    }

    public static class TextField implements InternalPrinter, InternalParser {
        public static Map<Locale, Map<DateTimeFieldType, Object[]>> cParseCache = new ConcurrentHashMap();
        public final DateTimeFieldType iFieldType;
        public final boolean iShort;

        public TextField(DateTimeFieldType dateTimeFieldType, boolean z) {
            this.iFieldType = dateTimeFieldType;
            this.iShort = z;
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            return this.iShort ? 6 : 20;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            Map map;
            int i3;
            DateTimeParserBucket dateTimeParserBucket2 = dateTimeParserBucket;
            int i4 = i;
            Locale locale = dateTimeParserBucket2.iLocale;
            Map map2 = cParseCache.get(locale);
            if (map2 == null) {
                map2 = new ConcurrentHashMap();
                cParseCache.put(locale, map2);
            }
            Object[] objArr = (Object[]) map2.get(this.iFieldType);
            int i5 = 1;
            if (objArr == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(32);
                MutableDateTime mutableDateTime = new MutableDateTime(0, DateTimeZone.UTC);
                DateTimeFieldType dateTimeFieldType = this.iFieldType;
                if (dateTimeFieldType != null) {
                    DateTimeField field = dateTimeFieldType.getField(mutableDateTime.iChronology);
                    if (field.isSupported()) {
                        Property property = new Property(mutableDateTime, field);
                        int minimumValue = property.getField().getMinimumValue();
                        int maximumValue = property.getField().getMaximumValue();
                        if (maximumValue - minimumValue > 32) {
                            return ~i4;
                        }
                        i2 = property.getField().getMaximumTextLength(locale);
                        while (minimumValue <= maximumValue) {
                            MutableDateTime mutableDateTime2 = property.iInstant;
                            long j = property.iField.set(mutableDateTime2.iMillis, minimumValue);
                            int i6 = mutableDateTime2.iRoundingMode;
                            if (i6 == i5) {
                                j = mutableDateTime2.iRoundingField.roundFloor(j);
                            } else if (i6 == 2) {
                                j = mutableDateTime2.iRoundingField.roundCeiling(j);
                            } else if (i6 == 3) {
                                j = mutableDateTime2.iRoundingField.roundHalfFloor(j);
                            } else if (i6 == 4) {
                                j = mutableDateTime2.iRoundingField.roundHalfCeiling(j);
                            } else if (i6 == 5) {
                                j = mutableDateTime2.iRoundingField.roundHalfEven(j);
                            }
                            mutableDateTime2.iMillis = mutableDateTime2.checkInstant(j);
                            concurrentHashMap.put(property.getAsShortText(locale), Boolean.TRUE);
                            concurrentHashMap.put(property.getAsShortText(locale).toLowerCase(locale), Boolean.TRUE);
                            concurrentHashMap.put(property.getAsShortText(locale).toUpperCase(locale), Boolean.TRUE);
                            concurrentHashMap.put(property.getAsText(locale), Boolean.TRUE);
                            concurrentHashMap.put(property.getAsText(locale).toLowerCase(locale), Boolean.TRUE);
                            concurrentHashMap.put(property.getAsText(locale).toUpperCase(locale), Boolean.TRUE);
                            minimumValue++;
                            i5 = 1;
                        }
                        if (!HyperVergeKycCapture.EN.equals(locale.getLanguage()) || this.iFieldType != DateTimeFieldType.ERA_TYPE) {
                            i3 = 2;
                        } else {
                            concurrentHashMap.put("BCE", Boolean.TRUE);
                            concurrentHashMap.put("bce", Boolean.TRUE);
                            concurrentHashMap.put("CE", Boolean.TRUE);
                            concurrentHashMap.put("ce", Boolean.TRUE);
                            i3 = 2;
                            i2 = 3;
                        }
                        Object[] objArr2 = new Object[i3];
                        objArr2[0] = concurrentHashMap;
                        objArr2[1] = Integer.valueOf(i2);
                        map2.put(this.iFieldType, objArr2);
                        map = concurrentHashMap;
                    } else {
                        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
                    }
                } else {
                    throw new IllegalArgumentException("The DateTimeFieldType must not be null");
                }
            } else {
                i2 = ((Integer) objArr[1]).intValue();
                map = (Map) objArr[0];
            }
            for (int min = Math.min(charSequence.length(), i4 + i2); min > i4; min--) {
                String charSequence2 = charSequence.subSequence(i4, min).toString();
                if (map.containsKey(charSequence2)) {
                    DateTimeFieldType dateTimeFieldType2 = this.iFieldType;
                    SavedField obtainSaveField = dateTimeParserBucket.obtainSaveField();
                    obtainSaveField.iField = dateTimeFieldType2.getField(dateTimeParserBucket2.iChrono);
                    obtainSaveField.iValue = 0;
                    obtainSaveField.iText = charSequence2;
                    obtainSaveField.iLocale = locale;
                    return min;
                }
            }
            return ~i4;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            String str;
            try {
                DateTimeField field = this.iFieldType.getField(chronology);
                if (this.iShort) {
                    str = field.getAsShortText(j, locale);
                } else {
                    str = field.getAsText(j, locale);
                }
                appendable.append(str);
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }
    }

    public enum TimeZoneId implements InternalPrinter, InternalParser {
        INSTANCE;
        
        public static final List<String> ALL_IDS = null;
        public static final List<String> BASE_GROUPED_IDS = null;
        public static final Map<String, List<String>> GROUPED_IDS = null;
        public static final int MAX_LENGTH = 0;
        public static final int MAX_PREFIX_LENGTH = 0;

        /* access modifiers changed from: public */
        static {
            BASE_GROUPED_IDS = new ArrayList();
            ArrayList arrayList = new ArrayList(DateTimeZone.getProvider().getAvailableIDs());
            ALL_IDS = arrayList;
            Collections.sort(arrayList);
            GROUPED_IDS = new HashMap();
            int i = 0;
            int i2 = 0;
            for (String next : ALL_IDS) {
                int indexOf = next.indexOf(47);
                if (indexOf >= 0) {
                    if (indexOf < next.length()) {
                        indexOf++;
                    }
                    i2 = Math.max(i2, indexOf);
                    String substring = next.substring(0, indexOf + 1);
                    String substring2 = next.substring(indexOf);
                    if (!GROUPED_IDS.containsKey(substring)) {
                        GROUPED_IDS.put(substring, new ArrayList());
                    }
                    GROUPED_IDS.get(substring).add(substring2);
                } else {
                    BASE_GROUPED_IDS.add(next);
                }
                i = Math.max(i, next.length());
            }
            MAX_LENGTH = i;
            MAX_PREFIX_LENGTH = i2;
        }

        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            String str;
            int i2;
            String str2;
            List<String> list = BASE_GROUPED_IDS;
            int length = charSequence.length();
            int min = Math.min(length, MAX_PREFIX_LENGTH + i);
            int i3 = i;
            while (true) {
                if (i3 >= min) {
                    str = "";
                    i2 = i;
                    break;
                } else if (charSequence.charAt(i3) == '/') {
                    int i4 = i3 + 1;
                    str = charSequence.subSequence(i, i4).toString();
                    i2 = str.length() + i;
                    if (i3 < length) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
                        outline73.append(charSequence.charAt(i4));
                        str2 = outline73.toString();
                    } else {
                        str2 = str;
                    }
                    list = GROUPED_IDS.get(str2);
                    if (list == null) {
                        return ~i;
                    }
                } else {
                    i3++;
                }
            }
            String str3 = null;
            for (int i5 = 0; i5 < list.size(); i5++) {
                String str4 = list.get(i5);
                if (DateTimeFormatterBuilder.csStartsWith(charSequence, i2, str4) && (str3 == null || str4.length() > str3.length())) {
                    str3 = str4;
                }
            }
            if (str3 == null) {
                return ~i;
            }
            DateTimeZone forID = DateTimeZone.forID(str + str3);
            dateTimeParserBucket.iSavedState = null;
            dateTimeParserBucket.iZone = forID;
            return str3.length() + i2;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(dateTimeZone != null ? dateTimeZone.iID : "");
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }
    }

    public static class TimeZoneName implements InternalPrinter, InternalParser {
        public final Map<String, DateTimeZone> iParseLookup;
        public final int iType;

        public TimeZoneName(int i, Map<String, DateTimeZone> map) {
            this.iType = i;
            this.iParseLookup = map;
        }

        public int estimateParsedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public int estimatePrintedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            Map<String, DateTimeZone> map = this.iParseLookup;
            if (map == null) {
                map = DateTimeUtils.cZoneNames.get();
                if (map == null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("UT", DateTimeZone.UTC);
                    linkedHashMap.put("UTC", DateTimeZone.UTC);
                    linkedHashMap.put("GMT", DateTimeZone.UTC);
                    DateTimeUtils.put(linkedHashMap, "EST", "America/New_York");
                    DateTimeUtils.put(linkedHashMap, "EDT", "America/New_York");
                    DateTimeUtils.put(linkedHashMap, "CST", "America/Chicago");
                    DateTimeUtils.put(linkedHashMap, "CDT", "America/Chicago");
                    DateTimeUtils.put(linkedHashMap, "MST", "America/Denver");
                    DateTimeUtils.put(linkedHashMap, "MDT", "America/Denver");
                    DateTimeUtils.put(linkedHashMap, "PST", "America/Los_Angeles");
                    DateTimeUtils.put(linkedHashMap, "PDT", "America/Los_Angeles");
                    map = Collections.unmodifiableMap(linkedHashMap);
                    if (!DateTimeUtils.cZoneNames.compareAndSet(null, map)) {
                        map = DateTimeUtils.cZoneNames.get();
                    }
                }
            }
            String str = null;
            for (String next : map.keySet()) {
                if (DateTimeFormatterBuilder.csStartsWith(charSequence, i, next) && (str == null || next.length() > str.length())) {
                    str = next;
                }
            }
            if (str == null) {
                return ~i;
            }
            dateTimeParserBucket.iSavedState = null;
            dateTimeParserBucket.iZone = map.get(str);
            return str.length() + i;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            String printOffset;
            long j2 = j - ((long) i);
            String str = "";
            if (dateTimeZone != null) {
                int i2 = this.iType;
                String str2 = null;
                boolean z = true;
                boolean z2 = false;
                if (i2 == 0) {
                    if (locale == null) {
                        locale = Locale.getDefault();
                    }
                    String nameKey = dateTimeZone.getNameKey(j2);
                    if (nameKey == null) {
                        printOffset = dateTimeZone.iID;
                    } else {
                        NameProvider nameProvider = DateTimeZone.getNameProvider();
                        if (nameProvider instanceof DefaultNameProvider) {
                            DefaultNameProvider defaultNameProvider = (DefaultNameProvider) nameProvider;
                            String str3 = dateTimeZone.iID;
                            if (dateTimeZone.getOffset(j2) == dateTimeZone.getStandardOffset(j2)) {
                                z2 = true;
                            }
                            String[] nameSet = defaultNameProvider.getNameSet(locale, str3, nameKey, z2);
                            if (nameSet != null) {
                                str2 = nameSet[1];
                            }
                        } else {
                            str2 = nameProvider.getName(locale, dateTimeZone.iID, nameKey);
                        }
                        if (str2 == null) {
                            printOffset = DateTimeZone.printOffset(dateTimeZone.getOffset(j2));
                        }
                        str = str2;
                    }
                } else if (i2 == 1) {
                    if (locale == null) {
                        locale = Locale.getDefault();
                    }
                    String nameKey2 = dateTimeZone.getNameKey(j2);
                    if (nameKey2 == null) {
                        printOffset = dateTimeZone.iID;
                    } else {
                        NameProvider nameProvider2 = DateTimeZone.getNameProvider();
                        if (nameProvider2 instanceof DefaultNameProvider) {
                            DefaultNameProvider defaultNameProvider2 = (DefaultNameProvider) nameProvider2;
                            String str4 = dateTimeZone.iID;
                            if (dateTimeZone.getOffset(j2) != dateTimeZone.getStandardOffset(j2)) {
                                z = false;
                            }
                            String[] nameSet2 = defaultNameProvider2.getNameSet(locale, str4, nameKey2, z);
                            if (nameSet2 != null) {
                                str2 = nameSet2[0];
                            }
                        } else {
                            str2 = nameProvider2.getShortName(locale, dateTimeZone.iID, nameKey2);
                        }
                        if (str2 == null) {
                            printOffset = DateTimeZone.printOffset(dateTimeZone.getOffset(j2));
                        }
                        str = str2;
                    }
                }
                str = printOffset;
            }
            appendable.append(str);
        }
    }

    public static class TimeZoneOffset implements InternalPrinter, InternalParser {
        public final int iMaxFields;
        public final int iMinFields;
        public final boolean iShowSeparators;
        public final String iZeroOffsetParseText;
        public final String iZeroOffsetPrintText;

        public TimeZoneOffset(String str, String str2, boolean z, int i, int i2) {
            this.iZeroOffsetPrintText = str;
            this.iZeroOffsetParseText = str2;
            this.iShowSeparators = z;
            if (i <= 0 || i2 < i) {
                throw new IllegalArgumentException();
            }
            if (i > 4) {
                i = 4;
                i2 = 4;
            }
            this.iMinFields = i;
            this.iMaxFields = i2;
        }

        public final int digitCount(CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            for (int min = Math.min(charSequence.length() - i, i2); min > 0; min--) {
                char charAt = charSequence.charAt(i + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            int i = this.iMinFields;
            int i2 = (i + 1) << 1;
            if (this.iShowSeparators) {
                i2 += i - 1;
            }
            String str = this.iZeroOffsetPrintText;
            return (str == null || str.length() <= i2) ? i2 : this.iZeroOffsetPrintText.length();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
            if (r6 <= '9') goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (r1 != '+') goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r12, java.lang.CharSequence r13, int r14) {
            /*
                r11 = this;
                int r0 = r13.length()
                int r0 = r0 - r14
                java.lang.String r1 = r11.iZeroOffsetParseText
                r2 = 43
                r3 = 45
                r4 = 0
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                if (r1 == 0) goto L_0x003a
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0027
                if (r0 <= 0) goto L_0x0023
                char r1 = r13.charAt(r14)
                if (r1 == r3) goto L_0x003a
                if (r1 != r2) goto L_0x0023
                goto L_0x003a
            L_0x0023:
                r12.setOffset(r5)
                return r14
            L_0x0027:
                java.lang.String r1 = r11.iZeroOffsetParseText
                boolean r1 = org.joda.time.format.DateTimeFormatterBuilder.csStartsWithIgnoreCase(r13, r14, r1)
                if (r1 == 0) goto L_0x003a
                r12.setOffset(r5)
                java.lang.String r12 = r11.iZeroOffsetParseText
                int r12 = r12.length()
                int r12 = r12 + r14
                return r12
            L_0x003a:
                r1 = 1
                if (r0 > r1) goto L_0x003f
                int r12 = ~r14
                return r12
            L_0x003f:
                char r5 = r13.charAt(r14)
                if (r5 != r3) goto L_0x0047
                r2 = 1
                goto L_0x004a
            L_0x0047:
                if (r5 != r2) goto L_0x0126
                r2 = 0
            L_0x004a:
                int r0 = r0 + -1
                int r14 = r14 + r1
                r3 = 2
                int r5 = r11.digitCount(r13, r14, r3)
                if (r5 >= r3) goto L_0x0056
                int r12 = ~r14
                return r12
            L_0x0056:
                int r5 = org.joda.time.format.FormatUtils.parseTwoDigits(r13, r14)
                r6 = 23
                if (r5 <= r6) goto L_0x0060
                int r12 = ~r14
                return r12
            L_0x0060:
                r6 = 3600000(0x36ee80, float:5.044674E-39)
                int r5 = r5 * r6
                int r0 = r0 + -2
                int r14 = r14 + r3
                if (r0 > 0) goto L_0x006c
                goto L_0x011b
            L_0x006c:
                char r6 = r13.charAt(r14)
                r7 = 58
                r8 = 48
                if (r6 != r7) goto L_0x007c
                int r0 = r0 + -1
                int r14 = r14 + 1
                r4 = 1
                goto L_0x0082
            L_0x007c:
                if (r6 < r8) goto L_0x011b
                r9 = 57
                if (r6 > r9) goto L_0x011b
            L_0x0082:
                int r6 = r11.digitCount(r13, r14, r3)
                if (r6 != 0) goto L_0x008c
                if (r4 != 0) goto L_0x008c
                goto L_0x011b
            L_0x008c:
                if (r6 >= r3) goto L_0x0090
                int r12 = ~r14
                return r12
            L_0x0090:
                int r6 = org.joda.time.format.FormatUtils.parseTwoDigits(r13, r14)
                r9 = 59
                if (r6 <= r9) goto L_0x009a
                int r12 = ~r14
                return r12
            L_0x009a:
                r10 = 60000(0xea60, float:8.4078E-41)
                int r6 = r6 * r10
                int r5 = r5 + r6
                int r0 = r0 + -2
                int r14 = r14 + 2
                if (r0 > 0) goto L_0x00a8
                goto L_0x011b
            L_0x00a8:
                if (r4 == 0) goto L_0x00b6
                char r6 = r13.charAt(r14)
                if (r6 == r7) goto L_0x00b2
                goto L_0x011b
            L_0x00b2:
                int r0 = r0 + -1
                int r14 = r14 + 1
            L_0x00b6:
                int r6 = r11.digitCount(r13, r14, r3)
                if (r6 != 0) goto L_0x00bf
                if (r4 != 0) goto L_0x00bf
                goto L_0x011b
            L_0x00bf:
                if (r6 >= r3) goto L_0x00c3
                int r12 = ~r14
                return r12
            L_0x00c3:
                int r6 = org.joda.time.format.FormatUtils.parseTwoDigits(r13, r14)
                if (r6 <= r9) goto L_0x00cb
                int r12 = ~r14
                return r12
            L_0x00cb:
                int r6 = r6 * 1000
                int r5 = r5 + r6
                int r0 = r0 + -2
                int r14 = r14 + 2
                if (r0 > 0) goto L_0x00d5
                goto L_0x011b
            L_0x00d5:
                if (r4 == 0) goto L_0x00ea
                char r0 = r13.charAt(r14)
                r6 = 46
                if (r0 == r6) goto L_0x00e8
                char r0 = r13.charAt(r14)
                r6 = 44
                if (r0 == r6) goto L_0x00e8
                goto L_0x011b
            L_0x00e8:
                int r14 = r14 + 1
            L_0x00ea:
                r0 = 3
                int r0 = r11.digitCount(r13, r14, r0)
                if (r0 != 0) goto L_0x00f4
                if (r4 != 0) goto L_0x00f4
                goto L_0x011b
            L_0x00f4:
                if (r0 >= r1) goto L_0x00f8
                int r12 = ~r14
                return r12
            L_0x00f8:
                int r4 = r14 + 1
                char r14 = r13.charAt(r14)
                int r14 = r14 - r8
                int r14 = r14 * 100
                int r5 = r5 + r14
                if (r0 <= r1) goto L_0x011a
                int r14 = r4 + 1
                char r1 = r13.charAt(r4)
                int r1 = r1 - r8
                int r1 = r1 * 10
                int r5 = r5 + r1
                if (r0 <= r3) goto L_0x011b
                int r0 = r14 + 1
                char r13 = r13.charAt(r14)
                int r13 = r13 - r8
                int r5 = r5 + r13
                r14 = r0
                goto L_0x011b
            L_0x011a:
                r14 = r4
            L_0x011b:
                if (r2 == 0) goto L_0x011e
                int r5 = -r5
            L_0x011e:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
                r12.setOffset(r13)
                return r14
            L_0x0126:
                int r12 = ~r14
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.TimeZoneOffset.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.CharSequence, int):int");
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            if (dateTimeZone != null) {
                if (i == 0) {
                    String str = this.iZeroOffsetPrintText;
                    if (str != null) {
                        appendable.append(str);
                        return;
                    }
                }
                if (i >= 0) {
                    appendable.append('+');
                } else {
                    appendable.append('-');
                    i = -i;
                }
                int i2 = i / 3600000;
                FormatUtils.appendPaddedInteger(appendable, i2, 2);
                if (this.iMaxFields != 1) {
                    int i3 = i - (i2 * 3600000);
                    if (i3 != 0 || this.iMinFields > 1) {
                        int i4 = i3 / 60000;
                        if (this.iShowSeparators) {
                            appendable.append(':');
                        }
                        FormatUtils.appendPaddedInteger(appendable, i4, 2);
                        if (this.iMaxFields != 2) {
                            int i5 = i3 - (i4 * 60000);
                            if (i5 != 0 || this.iMinFields > 2) {
                                int i6 = i5 / 1000;
                                if (this.iShowSeparators) {
                                    appendable.append(':');
                                }
                                FormatUtils.appendPaddedInteger(appendable, i6, 2);
                                if (this.iMaxFields != 3) {
                                    int i7 = i5 - (i6 * 1000);
                                    if (i7 != 0 || this.iMinFields > 3) {
                                        if (this.iShowSeparators) {
                                            appendable.append('.');
                                        }
                                        FormatUtils.appendPaddedInteger(appendable, i7, 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static class TwoDigitYear implements InternalPrinter, InternalParser {
        public final boolean iLenientParse;
        public final int iPivot;
        public final DateTimeFieldType iType;

        public TwoDigitYear(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.iType = dateTimeFieldType;
            this.iPivot = i;
            this.iLenientParse = z;
        }

        public int estimateParsedLength() {
            return this.iLenientParse ? 4 : 2;
        }

        public int estimatePrintedLength() {
            return 2;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            int i3;
            int i4;
            int length = charSequence.length() - i;
            int i5 = 0;
            if (this.iLenientParse) {
                int i6 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i6 < length) {
                    char charAt = charSequence.charAt(i + i6);
                    if (i6 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i6++;
                    } else {
                        z2 = charAt == '-';
                        if (z2) {
                            i6++;
                        } else {
                            i++;
                            length--;
                        }
                        z = true;
                    }
                }
                if (i6 == 0) {
                    return ~i;
                }
                if (z || i6 != 2) {
                    if (i6 >= 9) {
                        i4 = i6 + i;
                        i3 = Integer.parseInt(charSequence.subSequence(i, i4).toString());
                    } else {
                        int i7 = z2 ? i + 1 : i;
                        int i8 = i7 + 1;
                        try {
                            int charAt2 = charSequence.charAt(i7) - '0';
                            i4 = i6 + i;
                            while (i8 < i4) {
                                int charAt3 = (charSequence.charAt(i8) + ((charAt2 << 3) + (charAt2 << 1))) - 48;
                                i8++;
                                charAt2 = charAt3;
                            }
                            i3 = z2 ? -charAt2 : charAt2;
                        } catch (StringIndexOutOfBoundsException unused) {
                            return ~i;
                        }
                    }
                    dateTimeParserBucket.saveField(this.iType, i3);
                    return i4;
                }
            } else if (Math.min(2, length) < 2) {
                return ~i;
            }
            char charAt4 = charSequence.charAt(i);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i;
            }
            int i9 = charAt4 - '0';
            char charAt5 = charSequence.charAt(i + 1);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i;
            }
            int i10 = (((i9 << 3) + (i9 << 1)) + charAt5) - 48;
            int i11 = this.iPivot;
            Integer num = dateTimeParserBucket.iPivotYear;
            if (num != null) {
                i11 = num.intValue();
            }
            int i12 = i11 - 50;
            if (i12 >= 0) {
                i2 = i12 % 100;
            } else {
                i2 = ((i12 + 1) % 100) + 99;
            }
            if (i10 < i2) {
                i5 = 100;
            }
            dateTimeParserBucket.saveField(this.iType, ((i12 + i5) - i2) + i10);
            return i + 2;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            int i2;
            try {
                int i3 = this.iType.getField(chronology).get(j);
                if (i3 < 0) {
                    i3 = -i3;
                }
                i2 = i3 % 100;
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            if (i2 < 0) {
                appendable.append(65533);
                appendable.append(65533);
                return;
            }
            FormatUtils.appendPaddedInteger(appendable, i2, 2);
        }
    }

    public static class UnpaddedNumber extends NumberFormatter {
        public UnpaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z);
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.appendUnpaddedInteger(appendable, this.iFieldType.getField(chronology).get(j));
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }
    }

    public static boolean csStartsWith(CharSequence charSequence, int i, String str) {
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i + i2) != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean csStartsWithIgnoreCase(CharSequence charSequence, int i, String str) {
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i + i2);
            char charAt2 = str.charAt(i2);
            if (charAt != charAt2) {
                char upperCase = Character.toUpperCase(charAt);
                char upperCase2 = Character.toUpperCase(charAt2);
                if (!(upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            append0(dateTimeFormatter.iPrinter, dateTimeFormatter.iParser);
            return this;
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public final DateTimeFormatterBuilder append0(InternalPrinter internalPrinter, InternalParser internalParser) {
        this.iFormatter = null;
        this.iElementPairs.add(internalPrinter);
        this.iElementPairs.add(internalParser);
        return this;
    }

    public DateTimeFormatterBuilder appendDecimal(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        } else if (i <= 1) {
            UnpaddedNumber unpaddedNumber = new UnpaddedNumber(dateTimeFieldType, i2, false);
            this.iFormatter = null;
            this.iElementPairs.add(unpaddedNumber);
            this.iElementPairs.add(unpaddedNumber);
            return this;
        } else {
            PaddedNumber paddedNumber = new PaddedNumber(dateTimeFieldType, i2, false, i);
            this.iFormatter = null;
            this.iElementPairs.add(paddedNumber);
            this.iElementPairs.add(paddedNumber);
            return this;
        }
    }

    public DateTimeFormatterBuilder appendFixedDecimal(DateTimeFieldType dateTimeFieldType, int i) {
        if (i > 0) {
            FixedNumber fixedNumber = new FixedNumber(dateTimeFieldType, i, false);
            this.iFormatter = null;
            this.iElementPairs.add(fixedNumber);
            this.iElementPairs.add(fixedNumber);
            return this;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Illegal number of digits: ", i));
    }

    public DateTimeFormatterBuilder appendFraction(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        Fraction fraction = new Fraction(dateTimeFieldType, i, i2);
        this.iFormatter = null;
        this.iElementPairs.add(fraction);
        this.iElementPairs.add(fraction);
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c2) {
        CharacterLiteral characterLiteral = new CharacterLiteral(c2);
        this.iFormatter = null;
        this.iElementPairs.add(characterLiteral);
        this.iElementPairs.add(characterLiteral);
        return this;
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeParser dateTimeParser) {
        if (dateTimeParser != null) {
            append0(null, new MatchingParser(new InternalParser[]{DateTimeParserInternalParser.of(dateTimeParser), null}));
            return this;
        }
        throw new IllegalArgumentException("No parser supplied");
    }

    public DateTimeFormatterBuilder appendShortText(DateTimeFieldType dateTimeFieldType) {
        TextField textField = new TextField(dateTimeFieldType, true);
        this.iFormatter = null;
        this.iElementPairs.add(textField);
        this.iElementPairs.add(textField);
        return this;
    }

    public DateTimeFormatterBuilder appendSignedDecimal(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        } else if (i <= 1) {
            UnpaddedNumber unpaddedNumber = new UnpaddedNumber(dateTimeFieldType, i2, true);
            this.iFormatter = null;
            this.iElementPairs.add(unpaddedNumber);
            this.iElementPairs.add(unpaddedNumber);
            return this;
        } else {
            PaddedNumber paddedNumber = new PaddedNumber(dateTimeFieldType, i2, true, i);
            this.iFormatter = null;
            this.iElementPairs.add(paddedNumber);
            this.iElementPairs.add(paddedNumber);
            return this;
        }
    }

    public DateTimeFormatterBuilder appendText(DateTimeFieldType dateTimeFieldType) {
        TextField textField = new TextField(dateTimeFieldType, false);
        this.iFormatter = null;
        this.iElementPairs.add(textField);
        this.iElementPairs.add(textField);
        return this;
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, boolean z, int i, int i2) {
        TimeZoneOffset timeZoneOffset = new TimeZoneOffset(str, str, z, i, i2);
        this.iFormatter = null;
        this.iElementPairs.add(timeZoneOffset);
        this.iElementPairs.add(timeZoneOffset);
        return this;
    }

    public DateTimeFormatterBuilder appendWeekyear(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.WEEKYEAR_TYPE, i, i2);
    }

    public DateTimeFormatterBuilder appendYear(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.YEAR_TYPE, i, i2);
    }

    public final Object getFormatter() {
        Object obj = this.iFormatter;
        if (obj == null) {
            if (this.iElementPairs.size() == 2) {
                Object obj2 = this.iElementPairs.get(0);
                Object obj3 = this.iElementPairs.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new Composite(this.iElementPairs);
            }
            this.iFormatter = obj;
        }
        return obj;
    }

    public final boolean isParser(Object obj) {
        boolean z = false;
        if (!(obj instanceof InternalParser)) {
            return false;
        }
        if (!(obj instanceof Composite)) {
            return true;
        }
        if (((Composite) obj).iParsers != null) {
            z = true;
        }
        return z;
    }

    public DateTimeFormatter toFormatter() {
        Object formatter = getFormatter();
        boolean z = false;
        if ((formatter instanceof InternalPrinter) && (!(formatter instanceof Composite) || ((Composite) formatter).iPrinters != null)) {
            z = true;
        }
        InternalParser internalParser = null;
        InternalPrinter internalPrinter = z ? (InternalPrinter) formatter : null;
        if (isParser(formatter)) {
            internalParser = (InternalParser) formatter;
        }
        if (internalPrinter != null || internalParser != null) {
            return new DateTimeFormatter(internalPrinter, internalParser);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
    }

    public DateTimeParser toParser() {
        Object formatter = getFormatter();
        if (isParser(formatter)) {
            return InternalParserDateTimeParser.of((InternalParser) formatter);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public DateTimeFormatterBuilder append(DateTimeParser dateTimeParser) {
        if (dateTimeParser != null) {
            append0(null, DateTimeParserInternalParser.of(dateTimeParser));
            return this;
        }
        throw new IllegalArgumentException("No parser supplied");
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                StringLiteral stringLiteral = new StringLiteral(str);
                this.iFormatter = null;
                this.iElementPairs.add(stringLiteral);
                this.iElementPairs.add(stringLiteral);
                return this;
            }
            CharacterLiteral characterLiteral = new CharacterLiteral(str.charAt(0));
            this.iFormatter = null;
            this.iElementPairs.add(characterLiteral);
            this.iElementPairs.add(characterLiteral);
        }
        return this;
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, String str2, boolean z, int i, int i2) {
        TimeZoneOffset timeZoneOffset = new TimeZoneOffset(null, str2, z, i, i2);
        this.iFormatter = null;
        this.iElementPairs.add(timeZoneOffset);
        this.iElementPairs.add(timeZoneOffset);
        return this;
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter, DateTimeParser[] dateTimeParserArr) {
        int length = dateTimeParserArr.length;
        int i = 0;
        if (length != 1) {
            InternalParser[] internalParserArr = new InternalParser[length];
            while (i < length - 1) {
                InternalParser of = DateTimeParserInternalParser.of(dateTimeParserArr[i]);
                internalParserArr[i] = of;
                if (of != null) {
                    i++;
                } else {
                    throw new IllegalArgumentException("Incomplete parser array");
                }
            }
            internalParserArr[i] = DateTimeParserInternalParser.of(dateTimeParserArr[i]);
            append0(null, new MatchingParser(internalParserArr));
            return this;
        } else if (dateTimeParserArr[0] != null) {
            append0(null, DateTimeParserInternalParser.of(dateTimeParserArr[0]));
            return this;
        } else {
            throw new IllegalArgumentException("No parser supplied");
        }
    }
}
