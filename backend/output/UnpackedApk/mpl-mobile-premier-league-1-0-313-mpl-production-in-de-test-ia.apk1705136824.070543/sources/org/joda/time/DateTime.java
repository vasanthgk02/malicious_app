package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.base.BaseDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

public final class DateTime extends BaseDateTime implements ReadableInstant, Serializable {
    public static final long serialVersionUID = -5171125899451703815L;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        public static final long serialVersionUID = -6983323811635733510L;
        public DateTimeField iField;
        public DateTime iInstant;

        public Property(DateTime dateTime, DateTimeField dateTimeField) {
            this.iInstant = dateTime;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (DateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.iChronology);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public Chronology getChronology() {
            return this.iInstant.iChronology;
        }

        public DateTimeField getField() {
            return this.iField;
        }

        public long getMillis() {
            return this.iInstant.iMillis;
        }
    }

    public DateTime() {
        super(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance());
    }

    public static DateTime now() {
        return new DateTime();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @org.joda.convert.FromString
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.DateTime parse(java.lang.String r12) {
        /*
            org.joda.time.format.DateTimeFormatter r0 = org.joda.time.format.ISODateTimeFormat$Constants.dtp
            boolean r1 = r0.iOffsetParsed
            r2 = 1
            if (r1 != r2) goto L_0x0008
            goto L_0x001d
        L_0x0008:
            org.joda.time.format.DateTimeFormatter r1 = new org.joda.time.format.DateTimeFormatter
            org.joda.time.format.InternalPrinter r4 = r0.iPrinter
            org.joda.time.format.InternalParser r5 = r0.iParser
            java.util.Locale r6 = r0.iLocale
            r7 = 1
            org.joda.time.Chronology r8 = r0.iChrono
            r9 = 0
            java.lang.Integer r10 = r0.iPivotYear
            int r11 = r0.iDefaultYear
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r1
        L_0x001d:
            org.joda.time.format.InternalParser r1 = r0.iParser
            if (r1 == 0) goto L_0x007c
            r3 = 0
            org.joda.time.Chronology r3 = r0.selectChronology(r3)
            org.joda.time.format.DateTimeParserBucket r11 = new org.joda.time.format.DateTimeParserBucket
            r5 = 0
            java.util.Locale r8 = r0.iLocale
            java.lang.Integer r9 = r0.iPivotYear
            int r10 = r0.iDefaultYear
            r4 = r11
            r7 = r3
            r4.<init>(r5, r7, r8, r9, r10)
            r4 = 0
            int r1 = r1.parseInto(r11, r12, r4)
            if (r1 < 0) goto L_0x0071
            int r4 = r12.length()
            if (r1 < r4) goto L_0x0072
            long r1 = r11.computeMillis(r2, r12)
            boolean r12 = r0.iOffsetParsed
            if (r12 == 0) goto L_0x005b
            java.lang.Integer r12 = r11.iOffset
            if (r12 == 0) goto L_0x005b
            int r12 = r12.intValue()
            org.joda.time.DateTimeZone r12 = org.joda.time.DateTimeZone.forOffsetMillis(r12)
            org.joda.time.Chronology r3 = r3.withZone(r12)
            goto L_0x0063
        L_0x005b:
            org.joda.time.DateTimeZone r12 = r11.iZone
            if (r12 == 0) goto L_0x0063
            org.joda.time.Chronology r3 = r3.withZone(r12)
        L_0x0063:
            org.joda.time.DateTime r12 = new org.joda.time.DateTime
            r12.<init>(r1, r3)
            org.joda.time.DateTimeZone r0 = r0.iZone
            if (r0 == 0) goto L_0x0070
            org.joda.time.DateTime r12 = r12.withZone(r0)
        L_0x0070:
            return r12
        L_0x0071:
            int r1 = ~r1
        L_0x0072:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r12 = org.joda.time.format.FormatUtils.createErrorMessage(r12, r1)
            r0.<init>(r12)
            throw r0
        L_0x007c:
            java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Parsing not supported"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.DateTime.parse(java.lang.String):org.joda.time.DateTime");
    }

    public Property dayOfYear() {
        return new Property(this, this.iChronology.dayOfYear());
    }

    public DateTime plusDays(int i) {
        DateTime dateTime;
        if (i == 0) {
            return this;
        }
        long add = this.iChronology.days().add(this.iMillis, i);
        if (add == this.iMillis) {
            dateTime = this;
        } else {
            dateTime = new DateTime(add, this.iChronology);
        }
        return dateTime;
    }

    public DateTime withZone(DateTimeZone dateTimeZone) {
        Chronology chronology = DateTimeUtils.getChronology(this.iChronology.withZone(dateTimeZone));
        if (chronology == this.iChronology) {
            return this;
        }
        return new DateTime(this.iMillis, chronology);
    }

    public DateTime(long j) {
        super(j, ISOChronology.getInstance());
    }

    public DateTime(long j, Chronology chronology) {
        super(j, chronology);
    }
}
