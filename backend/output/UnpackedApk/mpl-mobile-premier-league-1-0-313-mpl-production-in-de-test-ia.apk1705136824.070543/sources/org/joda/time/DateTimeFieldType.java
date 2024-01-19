package org.joda.time;

import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import java.io.Serializable;
import org.apache.fontbox.ttf.GlyfDescript;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public abstract class DateTimeFieldType implements Serializable {
    public static final DateTimeFieldType CENTURY_OF_ERA_TYPE = new StandardDateTimeFieldType("centuryOfEra", 3, DurationFieldType.CENTURIES_TYPE, DurationFieldType.ERAS_TYPE);
    public static final DateTimeFieldType CLOCKHOUR_OF_DAY_TYPE = new StandardDateTimeFieldType("clockhourOfDay", GlyfDescript.X_DUAL, DurationFieldType.HOURS_TYPE, DurationFieldType.DAYS_TYPE);
    public static final DateTimeFieldType CLOCKHOUR_OF_HALFDAY_TYPE = new StandardDateTimeFieldType("clockhourOfHalfday", 15, DurationFieldType.HOURS_TYPE, DurationFieldType.HALFDAYS_TYPE);
    public static final DateTimeFieldType DAY_OF_MONTH_TYPE = new StandardDateTimeFieldType(AnonymousClass27.DAY_OF_MONTH, 8, DurationFieldType.DAYS_TYPE, DurationFieldType.MONTHS_TYPE);
    public static final DateTimeFieldType DAY_OF_WEEK_TYPE = new StandardDateTimeFieldType("dayOfWeek", MqttWireMessage.MESSAGE_TYPE_PINGREQ, DurationFieldType.DAYS_TYPE, DurationFieldType.WEEKS_TYPE);
    public static final DateTimeFieldType DAY_OF_YEAR_TYPE = new StandardDateTimeFieldType("dayOfYear", 6, DurationFieldType.DAYS_TYPE, DurationFieldType.YEARS_TYPE);
    public static final DateTimeFieldType ERA_TYPE = new StandardDateTimeFieldType("era", 1, DurationFieldType.ERAS_TYPE, null);
    public static final DateTimeFieldType HALFDAY_OF_DAY_TYPE = new StandardDateTimeFieldType("halfdayOfDay", 13, DurationFieldType.HALFDAYS_TYPE, DurationFieldType.DAYS_TYPE);
    public static final DateTimeFieldType HOUR_OF_DAY_TYPE = new StandardDateTimeFieldType(AnonymousClass27.HOUR_OF_DAY, 17, DurationFieldType.HOURS_TYPE, DurationFieldType.DAYS_TYPE);
    public static final DateTimeFieldType HOUR_OF_HALFDAY_TYPE = new StandardDateTimeFieldType("hourOfHalfday", MqttWireMessage.MESSAGE_TYPE_DISCONNECT, DurationFieldType.HOURS_TYPE, DurationFieldType.HALFDAYS_TYPE);
    public static final DateTimeFieldType MILLIS_OF_DAY_TYPE = new StandardDateTimeFieldType("millisOfDay", 22, DurationFieldType.MILLIS_TYPE, DurationFieldType.DAYS_TYPE);
    public static final DateTimeFieldType MILLIS_OF_SECOND_TYPE = new StandardDateTimeFieldType("millisOfSecond", 23, DurationFieldType.MILLIS_TYPE, DurationFieldType.SECONDS_TYPE);
    public static final DateTimeFieldType MINUTE_OF_DAY_TYPE = new StandardDateTimeFieldType("minuteOfDay", 18, DurationFieldType.MINUTES_TYPE, DurationFieldType.DAYS_TYPE);
    public static final DateTimeFieldType MINUTE_OF_HOUR_TYPE = new StandardDateTimeFieldType("minuteOfHour", 19, DurationFieldType.MINUTES_TYPE, DurationFieldType.HOURS_TYPE);
    public static final DateTimeFieldType MONTH_OF_YEAR_TYPE = new StandardDateTimeFieldType("monthOfYear", 7, DurationFieldType.MONTHS_TYPE, DurationFieldType.YEARS_TYPE);
    public static final DateTimeFieldType SECOND_OF_DAY_TYPE = new StandardDateTimeFieldType("secondOfDay", 20, DurationFieldType.SECONDS_TYPE, DurationFieldType.DAYS_TYPE);
    public static final DateTimeFieldType SECOND_OF_MINUTE_TYPE = new StandardDateTimeFieldType("secondOfMinute", 21, DurationFieldType.SECONDS_TYPE, DurationFieldType.MINUTES_TYPE);
    public static final DateTimeFieldType WEEKYEAR_OF_CENTURY_TYPE = new StandardDateTimeFieldType("weekyearOfCentury", 9, DurationFieldType.WEEKYEARS_TYPE, DurationFieldType.CENTURIES_TYPE);
    public static final DateTimeFieldType WEEKYEAR_TYPE = new StandardDateTimeFieldType("weekyear", 10, DurationFieldType.WEEKYEARS_TYPE, null);
    public static final DateTimeFieldType WEEK_OF_WEEKYEAR_TYPE = new StandardDateTimeFieldType("weekOfWeekyear", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, DurationFieldType.WEEKS_TYPE, DurationFieldType.WEEKYEARS_TYPE);
    public static final DateTimeFieldType YEAR_OF_CENTURY_TYPE = new StandardDateTimeFieldType("yearOfCentury", 4, DurationFieldType.YEARS_TYPE, DurationFieldType.CENTURIES_TYPE);
    public static final DateTimeFieldType YEAR_OF_ERA_TYPE = new StandardDateTimeFieldType("yearOfEra", 2, DurationFieldType.YEARS_TYPE, DurationFieldType.ERAS_TYPE);
    public static final DateTimeFieldType YEAR_TYPE = new StandardDateTimeFieldType(AnonymousClass27.YEAR, 5, DurationFieldType.YEARS_TYPE, null);
    public static final long serialVersionUID = -42615285973990L;
    public final String iName;

    public static class StandardDateTimeFieldType extends DateTimeFieldType {
        public static final long serialVersionUID = -9937958251642L;
        public final byte iOrdinal;
        public final transient DurationFieldType iUnitType;

        public StandardDateTimeFieldType(String str, byte b2, DurationFieldType durationFieldType, DurationFieldType durationFieldType2) {
            super(str);
            this.iOrdinal = b2;
            this.iUnitType = durationFieldType;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return DateTimeFieldType.ERA_TYPE;
                case 2:
                    return DateTimeFieldType.YEAR_OF_ERA_TYPE;
                case 3:
                    return DateTimeFieldType.CENTURY_OF_ERA_TYPE;
                case 4:
                    return DateTimeFieldType.YEAR_OF_CENTURY_TYPE;
                case 5:
                    return DateTimeFieldType.YEAR_TYPE;
                case 6:
                    return DateTimeFieldType.DAY_OF_YEAR_TYPE;
                case 7:
                    return DateTimeFieldType.MONTH_OF_YEAR_TYPE;
                case 8:
                    return DateTimeFieldType.DAY_OF_MONTH_TYPE;
                case 9:
                    return DateTimeFieldType.WEEKYEAR_OF_CENTURY_TYPE;
                case 10:
                    return DateTimeFieldType.WEEKYEAR_TYPE;
                case 11:
                    return DateTimeFieldType.WEEK_OF_WEEKYEAR_TYPE;
                case 12:
                    return DateTimeFieldType.DAY_OF_WEEK_TYPE;
                case 13:
                    return DateTimeFieldType.HALFDAY_OF_DAY_TYPE;
                case 14:
                    return DateTimeFieldType.HOUR_OF_HALFDAY_TYPE;
                case 15:
                    return DateTimeFieldType.CLOCKHOUR_OF_HALFDAY_TYPE;
                case 16:
                    return DateTimeFieldType.CLOCKHOUR_OF_DAY_TYPE;
                case 17:
                    return DateTimeFieldType.HOUR_OF_DAY_TYPE;
                case 18:
                    return DateTimeFieldType.MINUTE_OF_DAY_TYPE;
                case 19:
                    return DateTimeFieldType.MINUTE_OF_HOUR_TYPE;
                case 20:
                    return DateTimeFieldType.SECOND_OF_DAY_TYPE;
                case 21:
                    return DateTimeFieldType.SECOND_OF_MINUTE_TYPE;
                case 22:
                    return DateTimeFieldType.MILLIS_OF_DAY_TYPE;
                case 23:
                    return DateTimeFieldType.MILLIS_OF_SECOND_TYPE;
                default:
                    return this;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StandardDateTimeFieldType)) {
                return false;
            }
            if (this.iOrdinal != ((StandardDateTimeFieldType) obj).iOrdinal) {
                z = false;
            }
            return z;
        }

        public DateTimeField getField(Chronology chronology) {
            Chronology chronology2 = DateTimeUtils.getChronology(chronology);
            switch (this.iOrdinal) {
                case 1:
                    return chronology2.era();
                case 2:
                    return chronology2.yearOfEra();
                case 3:
                    return chronology2.centuryOfEra();
                case 4:
                    return chronology2.yearOfCentury();
                case 5:
                    return chronology2.year();
                case 6:
                    return chronology2.dayOfYear();
                case 7:
                    return chronology2.monthOfYear();
                case 8:
                    return chronology2.dayOfMonth();
                case 9:
                    return chronology2.weekyearOfCentury();
                case 10:
                    return chronology2.weekyear();
                case 11:
                    return chronology2.weekOfWeekyear();
                case 12:
                    return chronology2.dayOfWeek();
                case 13:
                    return chronology2.halfdayOfDay();
                case 14:
                    return chronology2.hourOfHalfday();
                case 15:
                    return chronology2.clockhourOfHalfday();
                case 16:
                    return chronology2.clockhourOfDay();
                case 17:
                    return chronology2.hourOfDay();
                case 18:
                    return chronology2.minuteOfDay();
                case 19:
                    return chronology2.minuteOfHour();
                case 20:
                    return chronology2.secondOfDay();
                case 21:
                    return chronology2.secondOfMinute();
                case 22:
                    return chronology2.millisOfDay();
                case 23:
                    return chronology2.millisOfSecond();
                default:
                    throw new InternalError();
            }
        }

        public int hashCode() {
            return 1 << this.iOrdinal;
        }
    }

    public DateTimeFieldType(String str) {
        this.iName = str;
    }

    public abstract DateTimeField getField(Chronology chronology);

    public String toString() {
        return this.iName;
    }
}
