package org.joda.time.chrono;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology.Fields;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.RemainderDateTimeField;

public final class ISOChronology extends AssembledChronology {
    public static final ISOChronology INSTANCE_UTC = new ISOChronology(GregorianChronology.INSTANCE_UTC);
    public static final ConcurrentHashMap<DateTimeZone, ISOChronology> cCache = new ConcurrentHashMap<>();
    public static final long serialVersionUID = -6212696554273812441L;

    public static final class Stub implements Serializable {
        public static final long serialVersionUID = -6212696554273812441L;
        public transient DateTimeZone iZone;

        public Stub(DateTimeZone dateTimeZone) {
            this.iZone = dateTimeZone;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iZone = (DateTimeZone) objectInputStream.readObject();
        }

        private Object readResolve() {
            return ISOChronology.getInstance(this.iZone);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iZone);
        }
    }

    static {
        cCache.put(DateTimeZone.UTC, INSTANCE_UTC);
    }

    public ISOChronology(Chronology chronology) {
        super(chronology, null);
    }

    public static ISOChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    private Object writeReplace() {
        return new Stub(getZone());
    }

    public void assemble(Fields fields) {
        if (this.iBase.getZone() == DateTimeZone.UTC) {
            DividedDateTimeField dividedDateTimeField = new DividedDateTimeField(ISOYearOfEraDateTimeField.INSTANCE, DateTimeFieldType.CENTURY_OF_ERA_TYPE, 100);
            fields.centuryOfEra = dividedDateTimeField;
            fields.centuries = dividedDateTimeField.iDurationField;
            fields.yearOfCentury = new RemainderDateTimeField(dividedDateTimeField, DateTimeFieldType.YEAR_OF_CENTURY_TYPE);
            fields.weekyearOfCentury = new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra, fields.weekyears, DateTimeFieldType.WEEKYEAR_OF_CENTURY_TYPE);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ISOChronology) {
            return getZone().equals(((ISOChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return getZone().hashCode() + 800855;
    }

    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "ISOChronology";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ISOChronology");
        sb.append('[');
        return GeneratedOutlineSupport.outline59(sb, zone.iID, ']');
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(dateTimeZone);
    }

    public static ISOChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ISOChronology iSOChronology = cCache.get(dateTimeZone);
        if (iSOChronology != null) {
            return iSOChronology;
        }
        ISOChronology iSOChronology2 = new ISOChronology(ZonedChronology.getInstance(INSTANCE_UTC, dateTimeZone));
        ISOChronology putIfAbsent = cCache.putIfAbsent(dateTimeZone, iSOChronology2);
        return putIfAbsent != null ? putIfAbsent : iSOChronology2;
    }
}
