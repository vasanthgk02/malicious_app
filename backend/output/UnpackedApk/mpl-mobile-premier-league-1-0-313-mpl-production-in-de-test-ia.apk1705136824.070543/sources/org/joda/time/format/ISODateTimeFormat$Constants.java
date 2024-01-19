package org.joda.time.format;

import org.joda.time.DateTimeFieldType;

public final class ISODateTimeFormat$Constants {
    public static final DateTimeFormatter bd = basicDate();
    public static final DateTimeFormatter bdt;
    public static final DateTimeFormatter bdtx;
    public static final DateTimeFormatter bod = basicOrdinalDate();
    public static final DateTimeFormatter bodt;
    public static final DateTimeFormatter bodtx;
    public static final DateTimeFormatter bt = basicTime();
    public static final DateTimeFormatter btt = basicTTime();
    public static final DateTimeFormatter bttx = basicTTimeNoMillis();
    public static final DateTimeFormatter btx = basicTimeNoMillis();
    public static final DateTimeFormatter bwd = basicWeekDate();
    public static final DateTimeFormatter bwdt;
    public static final DateTimeFormatter bwdtx;
    public static final DateTimeFormatter dh;
    public static final DateTimeFormatter dhm;
    public static final DateTimeFormatter dhms;
    public static final DateTimeFormatter dhmsf;
    public static final DateTimeFormatter dhmsl;
    public static final DateTimeFormatter dme = dayOfMonthElement();
    public static final DateTimeFormatter dotp = dateOptionalTimeParser();
    public static final DateTimeFormatter dp;
    public static final DateTimeFormatter dpe = dateElementParser();
    public static final DateTimeFormatter dt;
    public static final DateTimeFormatter dtp;
    public static final DateTimeFormatter dtx;
    public static final DateTimeFormatter dwe = dayOfWeekElement();
    public static final DateTimeFormatter dye = dayOfYearElement();
    public static final DateTimeFormatter fse = fractionElement();
    public static final DateTimeFormatter hde = hourElement();
    public static final DateTimeFormatter hm = hourMinute();
    public static final DateTimeFormatter hms = hourMinuteSecond();
    public static final DateTimeFormatter hmsf = hourMinuteSecondFraction();
    public static final DateTimeFormatter hmsl = hourMinuteSecondMillis();
    public static final DateTimeFormatter ldotp;
    public static final DateTimeFormatter ldp;
    public static final DateTimeFormatter lte = literalTElement();
    public static final DateTimeFormatter ltp;
    public static final DateTimeFormatter mhe = minuteElement();
    public static final DateTimeFormatter mye = monthElement();
    public static final DateTimeFormatter od = ordinalDate();
    public static final DateTimeFormatter odt;
    public static final DateTimeFormatter odtx;
    public static final DateTimeFormatter sme = secondElement();
    public static final DateTimeFormatter t = time();
    public static final DateTimeFormatter tp;
    public static final DateTimeFormatter tpe = timeElementParser();
    public static final DateTimeFormatter tt = tTime();
    public static final DateTimeFormatter ttx = tTimeNoMillis();
    public static final DateTimeFormatter tx = timeNoMillis();
    public static final DateTimeFormatter wdt;
    public static final DateTimeFormatter wdtx;
    public static final DateTimeFormatter we = weekyearElement();
    public static final DateTimeFormatter ww;
    public static final DateTimeFormatter wwd;
    public static final DateTimeFormatter wwe = weekElement();
    public static final DateTimeFormatter ye = yearElement();
    public static final DateTimeFormatter ym;
    public static final DateTimeFormatter ymd;
    public static final DateTimeFormatter ze = offsetElement();

    static {
        DateTimeFormatter dateTimeFormatter = ym;
        if (dateTimeFormatter == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder.append(yearElement());
            dateTimeFormatterBuilder.append(monthElement());
            dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
        }
        ym = dateTimeFormatter;
        DateTimeFormatter dateTimeFormatter2 = ymd;
        if (dateTimeFormatter2 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder2.append(yearElement());
            dateTimeFormatterBuilder2.append(monthElement());
            dateTimeFormatterBuilder2.append(dayOfMonthElement());
            dateTimeFormatter2 = dateTimeFormatterBuilder2.toFormatter();
        }
        ymd = dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3 = ww;
        if (dateTimeFormatter3 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder3 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder3.append(weekyearElement());
            dateTimeFormatterBuilder3.append(weekElement());
            dateTimeFormatter3 = dateTimeFormatterBuilder3.toFormatter();
        }
        ww = dateTimeFormatter3;
        DateTimeFormatter dateTimeFormatter4 = wwd;
        if (dateTimeFormatter4 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder4 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder4.append(weekyearElement());
            dateTimeFormatterBuilder4.append(weekElement());
            dateTimeFormatterBuilder4.append(dayOfWeekElement());
            dateTimeFormatter4 = dateTimeFormatterBuilder4.toFormatter();
        }
        wwd = dateTimeFormatter4;
        DateTimeFormatter dateTimeFormatter5 = dh;
        if (dateTimeFormatter5 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder5 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder5.append(ymd);
            dateTimeFormatterBuilder5.append(literalTElement());
            dateTimeFormatterBuilder5.append(hde);
            dateTimeFormatter5 = dateTimeFormatterBuilder5.toFormatter();
        }
        dh = dateTimeFormatter5;
        DateTimeFormatter dateTimeFormatter6 = dhm;
        if (dateTimeFormatter6 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder6 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder6.append(ymd);
            dateTimeFormatterBuilder6.append(literalTElement());
            dateTimeFormatterBuilder6.append(hourMinute());
            dateTimeFormatter6 = dateTimeFormatterBuilder6.toFormatter();
        }
        dhm = dateTimeFormatter6;
        DateTimeFormatter dateTimeFormatter7 = dhms;
        if (dateTimeFormatter7 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder7 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder7.append(ymd);
            dateTimeFormatterBuilder7.append(literalTElement());
            dateTimeFormatterBuilder7.append(hourMinuteSecond());
            dateTimeFormatter7 = dateTimeFormatterBuilder7.toFormatter();
        }
        dhms = dateTimeFormatter7;
        DateTimeFormatter dateTimeFormatter8 = dhmsl;
        if (dateTimeFormatter8 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder8 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder8.append(ymd);
            dateTimeFormatterBuilder8.append(literalTElement());
            dateTimeFormatterBuilder8.append(hourMinuteSecondMillis());
            dateTimeFormatter8 = dateTimeFormatterBuilder8.toFormatter();
        }
        dhmsl = dateTimeFormatter8;
        DateTimeFormatter dateTimeFormatter9 = dhmsf;
        if (dateTimeFormatter9 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder9 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder9.append(ymd);
            dateTimeFormatterBuilder9.append(literalTElement());
            dateTimeFormatterBuilder9.append(hourMinuteSecondFraction());
            dateTimeFormatter9 = dateTimeFormatterBuilder9.toFormatter();
        }
        dhmsf = dateTimeFormatter9;
        DateTimeFormatter dateTimeFormatter10 = dt;
        if (dateTimeFormatter10 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder10 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder10.append(ymd);
            dateTimeFormatterBuilder10.append(tTime());
            dateTimeFormatter10 = dateTimeFormatterBuilder10.toFormatter();
        }
        dt = dateTimeFormatter10;
        DateTimeFormatter dateTimeFormatter11 = dtx;
        if (dateTimeFormatter11 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder11 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder11.append(ymd);
            dateTimeFormatterBuilder11.append(tTimeNoMillis());
            dateTimeFormatter11 = dateTimeFormatterBuilder11.toFormatter();
        }
        dtx = dateTimeFormatter11;
        DateTimeFormatter dateTimeFormatter12 = wdt;
        if (dateTimeFormatter12 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder12 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder12.append(wwd);
            dateTimeFormatterBuilder12.append(tTime());
            dateTimeFormatter12 = dateTimeFormatterBuilder12.toFormatter();
        }
        wdt = dateTimeFormatter12;
        DateTimeFormatter dateTimeFormatter13 = wdtx;
        if (dateTimeFormatter13 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder13 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder13.append(wwd);
            dateTimeFormatterBuilder13.append(tTimeNoMillis());
            dateTimeFormatter13 = dateTimeFormatterBuilder13.toFormatter();
        }
        wdtx = dateTimeFormatter13;
        DateTimeFormatter dateTimeFormatter14 = odt;
        if (dateTimeFormatter14 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder14 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder14.append(ordinalDate());
            dateTimeFormatterBuilder14.append(tTime());
            dateTimeFormatter14 = dateTimeFormatterBuilder14.toFormatter();
        }
        odt = dateTimeFormatter14;
        DateTimeFormatter dateTimeFormatter15 = odtx;
        if (dateTimeFormatter15 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder15 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder15.append(ordinalDate());
            dateTimeFormatterBuilder15.append(tTimeNoMillis());
            dateTimeFormatter15 = dateTimeFormatterBuilder15.toFormatter();
        }
        odtx = dateTimeFormatter15;
        DateTimeFormatter dateTimeFormatter16 = bdt;
        if (dateTimeFormatter16 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder16 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder16.append(basicDate());
            dateTimeFormatterBuilder16.append(basicTTime());
            dateTimeFormatter16 = dateTimeFormatterBuilder16.toFormatter();
        }
        bdt = dateTimeFormatter16;
        DateTimeFormatter dateTimeFormatter17 = bdtx;
        if (dateTimeFormatter17 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder17 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder17.append(basicDate());
            dateTimeFormatterBuilder17.append(basicTTimeNoMillis());
            dateTimeFormatter17 = dateTimeFormatterBuilder17.toFormatter();
        }
        bdtx = dateTimeFormatter17;
        DateTimeFormatter dateTimeFormatter18 = bodt;
        if (dateTimeFormatter18 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder18 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder18.append(basicOrdinalDate());
            dateTimeFormatterBuilder18.append(basicTTime());
            dateTimeFormatter18 = dateTimeFormatterBuilder18.toFormatter();
        }
        bodt = dateTimeFormatter18;
        DateTimeFormatter dateTimeFormatter19 = bodtx;
        if (dateTimeFormatter19 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder19 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder19.append(basicOrdinalDate());
            dateTimeFormatterBuilder19.append(basicTTimeNoMillis());
            dateTimeFormatter19 = dateTimeFormatterBuilder19.toFormatter();
        }
        bodtx = dateTimeFormatter19;
        DateTimeFormatter dateTimeFormatter20 = bwdt;
        if (dateTimeFormatter20 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder20 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder20.append(basicWeekDate());
            dateTimeFormatterBuilder20.append(basicTTime());
            dateTimeFormatter20 = dateTimeFormatterBuilder20.toFormatter();
        }
        bwdt = dateTimeFormatter20;
        DateTimeFormatter dateTimeFormatter21 = bwdtx;
        if (dateTimeFormatter21 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder21 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder21.append(basicWeekDate());
            dateTimeFormatterBuilder21.append(basicTTimeNoMillis());
            dateTimeFormatter21 = dateTimeFormatterBuilder21.toFormatter();
        }
        bwdtx = dateTimeFormatter21;
        DateTimeFormatter dateTimeFormatter22 = dp;
        if (dateTimeFormatter22 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder22 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder22.appendLiteral('T');
            dateTimeFormatterBuilder22.append(offsetElement());
            DateTimeParser parser = dateTimeFormatterBuilder22.toParser();
            DateTimeFormatterBuilder dateTimeFormatterBuilder23 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder23.append(dateElementParser());
            dateTimeFormatterBuilder23.appendOptional(parser);
            dateTimeFormatter22 = dateTimeFormatterBuilder23.toFormatter();
        }
        dp = dateTimeFormatter22;
        DateTimeFormatter dateTimeFormatter23 = ldp;
        if (dateTimeFormatter23 == null) {
            dateTimeFormatter23 = dateElementParser().withZoneUTC();
        }
        ldp = dateTimeFormatter23;
        DateTimeFormatter dateTimeFormatter24 = tp;
        if (dateTimeFormatter24 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder24 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder24.appendOptional(literalTElement().getParser());
            dateTimeFormatterBuilder24.append(timeElementParser());
            dateTimeFormatterBuilder24.appendOptional(offsetElement().getParser());
            dateTimeFormatter24 = dateTimeFormatterBuilder24.toFormatter();
        }
        tp = dateTimeFormatter24;
        DateTimeFormatter dateTimeFormatter25 = ltp;
        if (dateTimeFormatter25 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder25 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder25.appendOptional(literalTElement().getParser());
            dateTimeFormatterBuilder25.append(timeElementParser());
            dateTimeFormatter25 = dateTimeFormatterBuilder25.toFormatter().withZoneUTC();
        }
        ltp = dateTimeFormatter25;
        DateTimeFormatter dateTimeFormatter26 = dtp;
        if (dateTimeFormatter26 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder26 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder26.appendLiteral('T');
            dateTimeFormatterBuilder26.append(timeElementParser());
            dateTimeFormatterBuilder26.appendOptional(offsetElement().getParser());
            DateTimeParser parser2 = dateTimeFormatterBuilder26.toParser();
            dateTimeFormatter26 = new DateTimeFormatterBuilder().append(null, new DateTimeParser[]{parser2, dateOptionalTimeParser().getParser()}).toFormatter();
        }
        dtp = dateTimeFormatter26;
        DateTimeFormatter dateTimeFormatter27 = ldotp;
        if (dateTimeFormatter27 == null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder27 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder27.appendLiteral('T');
            dateTimeFormatterBuilder27.append(timeElementParser());
            DateTimeParser parser3 = dateTimeFormatterBuilder27.toParser();
            DateTimeFormatterBuilder dateTimeFormatterBuilder28 = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder28.append(dateElementParser());
            dateTimeFormatterBuilder28.appendOptional(parser3);
            dateTimeFormatter27 = dateTimeFormatterBuilder28.toFormatter().withZoneUTC();
        }
        ldotp = dateTimeFormatter27;
    }

    public static DateTimeFormatter basicDate() {
        DateTimeFormatter dateTimeFormatter = bd;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder appendYear = new DateTimeFormatterBuilder().appendYear(4, 4);
        appendYear.appendFixedDecimal(DateTimeFieldType.MONTH_OF_YEAR_TYPE, 2);
        appendYear.appendFixedDecimal(DateTimeFieldType.DAY_OF_MONTH_TYPE, 2);
        return appendYear.toFormatter();
    }

    public static DateTimeFormatter basicOrdinalDate() {
        DateTimeFormatter dateTimeFormatter = bod;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder appendYear = new DateTimeFormatterBuilder().appendYear(4, 4);
        appendYear.appendFixedDecimal(DateTimeFieldType.DAY_OF_YEAR_TYPE, 3);
        return appendYear.toFormatter();
    }

    public static DateTimeFormatter basicTTime() {
        DateTimeFormatter dateTimeFormatter = btt;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(literalTElement());
        dateTimeFormatterBuilder.append(basicTime());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter basicTTimeNoMillis() {
        DateTimeFormatter dateTimeFormatter = bttx;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(literalTElement());
        dateTimeFormatterBuilder.append(basicTimeNoMillis());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter basicTime() {
        DateTimeFormatter dateTimeFormatter = bt;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.HOUR_OF_DAY_TYPE, 2);
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.MINUTE_OF_HOUR_TYPE, 2);
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.SECOND_OF_MINUTE_TYPE, 2);
        dateTimeFormatterBuilder.appendLiteral('.');
        dateTimeFormatterBuilder.appendFraction(DateTimeFieldType.SECOND_OF_DAY_TYPE, 3, 9);
        dateTimeFormatterBuilder.appendTimeZoneOffset("Z", false, 2, 2);
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter basicTimeNoMillis() {
        DateTimeFormatter dateTimeFormatter = btx;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.HOUR_OF_DAY_TYPE, 2);
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.MINUTE_OF_HOUR_TYPE, 2);
        dateTimeFormatterBuilder.appendFixedDecimal(DateTimeFieldType.SECOND_OF_MINUTE_TYPE, 2);
        dateTimeFormatterBuilder.appendTimeZoneOffset("Z", false, 2, 2);
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter basicWeekDate() {
        DateTimeFormatter dateTimeFormatter = bwd;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder appendWeekyear = new DateTimeFormatterBuilder().appendWeekyear(4, 4);
        appendWeekyear.appendLiteral('W');
        appendWeekyear.appendFixedDecimal(DateTimeFieldType.WEEK_OF_WEEKYEAR_TYPE, 2);
        appendWeekyear.appendFixedDecimal(DateTimeFieldType.DAY_OF_WEEK_TYPE, 1);
        return appendWeekyear.toFormatter();
    }

    public static DateTimeFormatter dateElementParser() {
        DateTimeFormatter dateTimeFormatter = dpe;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder2.append(yearElement());
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder3.append(monthElement());
        dateTimeFormatterBuilder3.appendOptional(dayOfMonthElement().getParser());
        dateTimeFormatterBuilder2.appendOptional(dateTimeFormatterBuilder3.toParser());
        DateTimeFormatterBuilder dateTimeFormatterBuilder4 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder4.append(weekyearElement());
        dateTimeFormatterBuilder4.append(weekElement());
        dateTimeFormatterBuilder4.appendOptional(dayOfWeekElement().getParser());
        DateTimeFormatterBuilder dateTimeFormatterBuilder5 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder5.append(yearElement());
        dateTimeFormatterBuilder5.append(dayOfYearElement());
        return dateTimeFormatterBuilder.append(null, new DateTimeParser[]{dateTimeFormatterBuilder2.toParser(), dateTimeFormatterBuilder4.toParser(), dateTimeFormatterBuilder5.toParser()}).toFormatter();
    }

    public static DateTimeFormatter dateOptionalTimeParser() {
        DateTimeFormatter dateTimeFormatter = dotp;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('T');
        dateTimeFormatterBuilder.appendOptional(timeElementParser().getParser());
        dateTimeFormatterBuilder.appendOptional(offsetElement().getParser());
        DateTimeParser parser = dateTimeFormatterBuilder.toParser();
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder2.append(dateElementParser());
        dateTimeFormatterBuilder2.appendOptional(parser);
        return dateTimeFormatterBuilder2.toFormatter();
    }

    public static DateTimeFormatter dayOfMonthElement() {
        DateTimeFormatter dateTimeFormatter = dme;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('-');
        return dateTimeFormatterBuilder.appendDecimal(DateTimeFieldType.DAY_OF_MONTH_TYPE, 2, 2).toFormatter();
    }

    public static DateTimeFormatter dayOfWeekElement() {
        DateTimeFormatter dateTimeFormatter = dwe;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('-');
        return dateTimeFormatterBuilder.appendDecimal(DateTimeFieldType.DAY_OF_WEEK_TYPE, 1, 1).toFormatter();
    }

    public static DateTimeFormatter dayOfYearElement() {
        DateTimeFormatter dateTimeFormatter = dye;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('-');
        return dateTimeFormatterBuilder.appendDecimal(DateTimeFieldType.DAY_OF_YEAR_TYPE, 3, 3).toFormatter();
    }

    public static DateTimeFormatter fractionElement() {
        DateTimeFormatter dateTimeFormatter = fse;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('.');
        dateTimeFormatterBuilder.appendFraction(DateTimeFieldType.SECOND_OF_DAY_TYPE, 3, 9);
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter hourElement() {
        DateTimeFormatter dateTimeFormatter = hde;
        return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendDecimal(DateTimeFieldType.HOUR_OF_DAY_TYPE, 2, 2).toFormatter() : dateTimeFormatter;
    }

    public static DateTimeFormatter hourMinute() {
        DateTimeFormatter dateTimeFormatter = hm;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(hourElement());
        dateTimeFormatterBuilder.append(minuteElement());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter hourMinuteSecond() {
        DateTimeFormatter dateTimeFormatter = hms;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(hourElement());
        dateTimeFormatterBuilder.append(minuteElement());
        dateTimeFormatterBuilder.append(secondElement());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter hourMinuteSecondFraction() {
        DateTimeFormatter dateTimeFormatter = hmsf;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(hourElement());
        dateTimeFormatterBuilder.append(minuteElement());
        dateTimeFormatterBuilder.append(secondElement());
        dateTimeFormatterBuilder.append(fractionElement());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter hourMinuteSecondMillis() {
        DateTimeFormatter dateTimeFormatter = hmsl;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(hourElement());
        dateTimeFormatterBuilder.append(minuteElement());
        dateTimeFormatterBuilder.append(secondElement());
        dateTimeFormatterBuilder.appendLiteral('.');
        dateTimeFormatterBuilder.appendFraction(DateTimeFieldType.SECOND_OF_DAY_TYPE, 3, 3);
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter literalTElement() {
        DateTimeFormatter dateTimeFormatter = lte;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('T');
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter minuteElement() {
        DateTimeFormatter dateTimeFormatter = mhe;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral(':');
        return dateTimeFormatterBuilder.appendDecimal(DateTimeFieldType.MINUTE_OF_HOUR_TYPE, 2, 2).toFormatter();
    }

    public static DateTimeFormatter monthElement() {
        DateTimeFormatter dateTimeFormatter = mye;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral('-');
        return dateTimeFormatterBuilder.appendDecimal(DateTimeFieldType.MONTH_OF_YEAR_TYPE, 2, 2).toFormatter();
    }

    public static DateTimeFormatter offsetElement() {
        DateTimeFormatter dateTimeFormatter = ze;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendTimeZoneOffset("Z", true, 2, 4);
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter ordinalDate() {
        DateTimeFormatter dateTimeFormatter = od;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(yearElement());
        dateTimeFormatterBuilder.append(dayOfYearElement());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter secondElement() {
        DateTimeFormatter dateTimeFormatter = sme;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.appendLiteral(':');
        return dateTimeFormatterBuilder.appendDecimal(DateTimeFieldType.SECOND_OF_MINUTE_TYPE, 2, 2).toFormatter();
    }

    public static DateTimeFormatter tTime() {
        DateTimeFormatter dateTimeFormatter = tt;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(literalTElement());
        dateTimeFormatterBuilder.append(time());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter tTimeNoMillis() {
        DateTimeFormatter dateTimeFormatter = ttx;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(literalTElement());
        dateTimeFormatterBuilder.append(timeNoMillis());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter time() {
        DateTimeFormatter dateTimeFormatter = t;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(hourMinuteSecondFraction());
        dateTimeFormatterBuilder.append(offsetElement());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter timeElementParser() {
        DateTimeFormatter dateTimeFormatter = tpe;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder2.appendLiteral('.');
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder3.appendLiteral(',');
        DateTimeParser parser = dateTimeFormatterBuilder.append(null, new DateTimeParser[]{dateTimeFormatterBuilder2.toParser(), dateTimeFormatterBuilder3.toParser()}).toParser();
        DateTimeFormatterBuilder dateTimeFormatterBuilder4 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder4.append(hourElement());
        DateTimeFormatterBuilder dateTimeFormatterBuilder5 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder5.append(minuteElement());
        DateTimeFormatterBuilder dateTimeFormatterBuilder6 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder6.append(secondElement());
        DateTimeFormatterBuilder dateTimeFormatterBuilder7 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder7.append(parser);
        dateTimeFormatterBuilder7.appendFraction(DateTimeFieldType.SECOND_OF_DAY_TYPE, 1, 9);
        dateTimeFormatterBuilder6.appendOptional(dateTimeFormatterBuilder7.toParser());
        DateTimeFormatterBuilder dateTimeFormatterBuilder8 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder8.append(parser);
        dateTimeFormatterBuilder8.appendFraction(DateTimeFieldType.MINUTE_OF_DAY_TYPE, 1, 9);
        DateTimeParser[] dateTimeParserArr = {dateTimeFormatterBuilder6.toParser(), dateTimeFormatterBuilder8.toParser(), null};
        DateTimeFormatterBuilder dateTimeFormatterBuilder9 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder9.append(parser);
        dateTimeFormatterBuilder9.appendFraction(DateTimeFieldType.HOUR_OF_DAY_TYPE, 1, 9);
        return dateTimeFormatterBuilder4.append(null, new DateTimeParser[]{dateTimeFormatterBuilder5.append(null, dateTimeParserArr).toParser(), dateTimeFormatterBuilder9.toParser(), null}).toFormatter();
    }

    public static DateTimeFormatter timeNoMillis() {
        DateTimeFormatter dateTimeFormatter = tx;
        if (dateTimeFormatter != null) {
            return dateTimeFormatter;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.append(hourMinuteSecond());
        dateTimeFormatterBuilder.append(offsetElement());
        return dateTimeFormatterBuilder.toFormatter();
    }

    public static DateTimeFormatter weekElement() {
        DateTimeFormatter dateTimeFormatter = wwe;
        return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendLiteral((String) "-W").appendDecimal(DateTimeFieldType.WEEK_OF_WEEKYEAR_TYPE, 2, 2).toFormatter() : dateTimeFormatter;
    }

    public static DateTimeFormatter weekyearElement() {
        DateTimeFormatter dateTimeFormatter = we;
        return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendWeekyear(4, 9).toFormatter() : dateTimeFormatter;
    }

    public static DateTimeFormatter yearElement() {
        DateTimeFormatter dateTimeFormatter = ye;
        return dateTimeFormatter == null ? new DateTimeFormatterBuilder().appendYear(4, 9).toFormatter() : dateTimeFormatter;
    }
}
