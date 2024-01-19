package org.joda.time;

import java.io.Serializable;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public abstract class DurationFieldType implements Serializable {
    public static final DurationFieldType CENTURIES_TYPE = new StandardDurationFieldType("centuries", 2);
    public static final DurationFieldType DAYS_TYPE = new StandardDurationFieldType("days", 7);
    public static final DurationFieldType ERAS_TYPE = new StandardDurationFieldType("eras", 1);
    public static final DurationFieldType HALFDAYS_TYPE = new StandardDurationFieldType("halfdays", 8);
    public static final DurationFieldType HOURS_TYPE = new StandardDurationFieldType("hours", 9);
    public static final DurationFieldType MILLIS_TYPE = new StandardDurationFieldType("millis", MqttWireMessage.MESSAGE_TYPE_PINGREQ);
    public static final DurationFieldType MINUTES_TYPE = new StandardDurationFieldType("minutes", 10);
    public static final DurationFieldType MONTHS_TYPE = new StandardDurationFieldType("months", 5);
    public static final DurationFieldType SECONDS_TYPE = new StandardDurationFieldType("seconds", MqttWireMessage.MESSAGE_TYPE_UNSUBACK);
    public static final DurationFieldType WEEKS_TYPE = new StandardDurationFieldType("weeks", 6);
    public static final DurationFieldType WEEKYEARS_TYPE = new StandardDurationFieldType("weekyears", 3);
    public static final DurationFieldType YEARS_TYPE = new StandardDurationFieldType("years", 4);
    public static final long serialVersionUID = 8765135187319L;
    public final String iName;

    public static class StandardDurationFieldType extends DurationFieldType {
        public static final long serialVersionUID = 31156755687123L;
        public final byte iOrdinal;

        public StandardDurationFieldType(String str, byte b2) {
            super(str);
            this.iOrdinal = b2;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return DurationFieldType.ERAS_TYPE;
                case 2:
                    return DurationFieldType.CENTURIES_TYPE;
                case 3:
                    return DurationFieldType.WEEKYEARS_TYPE;
                case 4:
                    return DurationFieldType.YEARS_TYPE;
                case 5:
                    return DurationFieldType.MONTHS_TYPE;
                case 6:
                    return DurationFieldType.WEEKS_TYPE;
                case 7:
                    return DurationFieldType.DAYS_TYPE;
                case 8:
                    return DurationFieldType.HALFDAYS_TYPE;
                case 9:
                    return DurationFieldType.HOURS_TYPE;
                case 10:
                    return DurationFieldType.MINUTES_TYPE;
                case 11:
                    return DurationFieldType.SECONDS_TYPE;
                case 12:
                    return DurationFieldType.MILLIS_TYPE;
                default:
                    return this;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StandardDurationFieldType)) {
                return false;
            }
            if (this.iOrdinal != ((StandardDurationFieldType) obj).iOrdinal) {
                z = false;
            }
            return z;
        }

        public DurationField getField(Chronology chronology) {
            Chronology chronology2 = DateTimeUtils.getChronology(chronology);
            switch (this.iOrdinal) {
                case 1:
                    return chronology2.eras();
                case 2:
                    return chronology2.centuries();
                case 3:
                    return chronology2.weekyears();
                case 4:
                    return chronology2.years();
                case 5:
                    return chronology2.months();
                case 6:
                    return chronology2.weeks();
                case 7:
                    return chronology2.days();
                case 8:
                    return chronology2.halfdays();
                case 9:
                    return chronology2.hours();
                case 10:
                    return chronology2.minutes();
                case 11:
                    return chronology2.seconds();
                case 12:
                    return chronology2.millis();
                default:
                    throw new InternalError();
            }
        }

        public int hashCode() {
            return 1 << this.iOrdinal;
        }
    }

    public DurationFieldType(String str) {
        this.iName = str;
    }

    public abstract DurationField getField(Chronology chronology);

    public String toString() {
        return this.iName;
    }
}
