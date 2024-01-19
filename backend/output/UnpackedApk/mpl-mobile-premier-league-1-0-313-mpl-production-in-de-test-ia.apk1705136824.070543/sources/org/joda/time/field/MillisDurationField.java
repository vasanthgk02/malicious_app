package org.joda.time.field;

import java.io.Serializable;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class MillisDurationField extends DurationField implements Serializable {
    public static final DurationField INSTANCE = new MillisDurationField();
    public static final long serialVersionUID = 2656707858124633367L;

    private Object readResolve() {
        return INSTANCE;
    }

    public long add(long j, int i) {
        return TypeUtilsKt.safeAdd(j, (long) i);
    }

    public int compareTo(Object obj) {
        int i = (1 > ((DurationField) obj).getUnitMillis() ? 1 : (1 == ((DurationField) obj).getUnitMillis() ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MillisDurationField)) {
            return false;
        }
        if (((MillisDurationField) obj) != null) {
            return true;
        }
        throw null;
    }

    public DurationFieldType getType() {
        return DurationFieldType.MILLIS_TYPE;
    }

    public final long getUnitMillis() {
        return 1;
    }

    public int hashCode() {
        return (int) 1;
    }

    public final boolean isPrecise() {
        return true;
    }

    public boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[millis]";
    }

    public long add(long j, long j2) {
        return TypeUtilsKt.safeAdd(j, j2);
    }
}
