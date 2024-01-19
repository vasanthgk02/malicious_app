package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.ISOChronology;

public class DateTimeFormatter {
    public final Chronology iChrono;
    public final int iDefaultYear;
    public final Locale iLocale;
    public final boolean iOffsetParsed;
    public final InternalParser iParser;
    public final Integer iPivotYear;
    public final InternalPrinter iPrinter;
    public final DateTimeZone iZone;

    public DateTimeFormatter(InternalPrinter internalPrinter, InternalParser internalParser) {
        this.iPrinter = internalPrinter;
        this.iParser = internalParser;
        this.iLocale = null;
        this.iOffsetParsed = false;
        this.iChrono = null;
        this.iZone = null;
        this.iPivotYear = null;
        this.iDefaultYear = 2000;
    }

    public DateTimeParser getParser() {
        return InternalParserDateTimeParser.of(this.iParser);
    }

    public String print(ReadableInstant readableInstant) {
        InternalPrinter internalPrinter = this.iPrinter;
        if (internalPrinter != null) {
            StringBuilder sb = new StringBuilder(internalPrinter.estimatePrintedLength());
            try {
                printTo(sb, readableInstant);
            } catch (IOException unused) {
            }
            return sb.toString();
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    public void printTo(Appendable appendable, ReadableInstant readableInstant) throws IOException {
        Chronology chronology;
        DateTimeZone dateTimeZone;
        int i;
        long j;
        long instantMillis = DateTimeUtils.getInstantMillis(readableInstant);
        if (readableInstant == null) {
            chronology = ISOChronology.getInstance();
        } else {
            chronology = readableInstant.getChronology();
            if (chronology == null) {
                chronology = ISOChronology.getInstance();
            }
        }
        InternalPrinter internalPrinter = this.iPrinter;
        if (internalPrinter != null) {
            Chronology selectChronology = selectChronology(chronology);
            DateTimeZone zone = selectChronology.getZone();
            int offset = zone.getOffset(instantMillis);
            long j2 = (long) offset;
            long j3 = instantMillis + j2;
            if ((instantMillis ^ j3) >= 0 || (j2 ^ instantMillis) < 0) {
                long j4 = j3;
                dateTimeZone = zone;
                i = offset;
                j = j4;
            } else {
                j = instantMillis;
                dateTimeZone = DateTimeZone.UTC;
                i = 0;
            }
            internalPrinter.printTo(appendable, j, selectChronology.withUTC(), i, dateTimeZone, this.iLocale);
            return;
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    public final Chronology selectChronology(Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        Chronology chronology3 = this.iChrono;
        if (chronology3 != null) {
            chronology2 = chronology3;
        }
        DateTimeZone dateTimeZone = this.iZone;
        return dateTimeZone != null ? chronology2.withZone(dateTimeZone) : chronology2;
    }

    public DateTimeFormatter withZoneUTC() {
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        if (this.iZone == dateTimeZone) {
            return this;
        }
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, false, this.iChrono, dateTimeZone, this.iPivotYear, this.iDefaultYear);
        return dateTimeFormatter;
    }

    public DateTimeFormatter(InternalPrinter internalPrinter, InternalParser internalParser, Locale locale, boolean z, Chronology chronology, DateTimeZone dateTimeZone, Integer num, int i) {
        this.iPrinter = internalPrinter;
        this.iParser = internalParser;
        this.iLocale = locale;
        this.iOffsetParsed = z;
        this.iChrono = chronology;
        this.iZone = dateTimeZone;
        this.iPivotYear = num;
        this.iDefaultYear = i;
    }
}
