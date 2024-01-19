package org.joda.time.field;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class BaseDurationField extends DurationField implements Serializable {
    public static final long serialVersionUID = -2554245107589433218L;
    public final DurationFieldType iType;

    public BaseDurationField(DurationFieldType durationFieldType) {
        if (durationFieldType != null) {
            this.iType = durationFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public int compareTo(Object obj) {
        int i = (getUnitMillis() > ((DurationField) obj).getUnitMillis() ? 1 : (getUnitMillis() == ((DurationField) obj).getUnitMillis() ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public final DurationFieldType getType() {
        return this.iType;
    }

    public final boolean isSupported() {
        return true;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("DurationField["), this.iType.iName, ']');
    }
}
