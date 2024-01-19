package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.base.BaseDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

public class MutableDateTime extends BaseDateTime implements ReadableInstant, Cloneable, Serializable {
    public static final long serialVersionUID = 2852608688135209575L;
    public DateTimeField iRoundingField;
    public int iRoundingMode;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        public static final long serialVersionUID = -4481126543819298617L;
        public DateTimeField iField;
        public MutableDateTime iInstant;

        public Property(MutableDateTime mutableDateTime, DateTimeField dateTimeField) {
            this.iInstant = mutableDateTime;
            this.iField = dateTimeField;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (MutableDateTime) objectInputStream.readObject();
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

    public MutableDateTime() {
        super(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableDateTime(long j, DateTimeZone dateTimeZone) {
        super(j, ISOChronology.getInstance(dateTimeZone));
    }
}
