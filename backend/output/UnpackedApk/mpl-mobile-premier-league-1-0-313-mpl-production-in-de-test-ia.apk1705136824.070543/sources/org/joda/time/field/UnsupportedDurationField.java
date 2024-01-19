package org.joda.time.field;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.HashMap;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class UnsupportedDurationField extends DurationField implements Serializable {
    public static HashMap<DurationFieldType, UnsupportedDurationField> cCache = null;
    public static final long serialVersionUID = -6390301302770925357L;
    public final DurationFieldType iType;

    public UnsupportedDurationField(DurationFieldType durationFieldType) {
        this.iType = durationFieldType;
    }

    public static synchronized UnsupportedDurationField getInstance(DurationFieldType durationFieldType) {
        UnsupportedDurationField unsupportedDurationField;
        synchronized (UnsupportedDurationField.class) {
            try {
                if (cCache == null) {
                    cCache = new HashMap<>(7);
                    unsupportedDurationField = null;
                } else {
                    unsupportedDurationField = cCache.get(durationFieldType);
                }
                if (unsupportedDurationField == null) {
                    unsupportedDurationField = new UnsupportedDurationField(durationFieldType);
                    cCache.put(durationFieldType, unsupportedDurationField);
                }
            }
        }
        return unsupportedDurationField;
    }

    private Object readResolve() {
        return getInstance(this.iType);
    }

    public long add(long j, int i) {
        throw unsupported();
    }

    public int compareTo(Object obj) {
        DurationField durationField = (DurationField) obj;
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnsupportedDurationField)) {
            return false;
        }
        String str = ((UnsupportedDurationField) obj).iType.iName;
        if (str != null) {
            return str.equals(this.iType.iName);
        }
        if (this.iType.iName != null) {
            z = false;
        }
        return z;
    }

    public final DurationFieldType getType() {
        return this.iType;
    }

    public long getUnitMillis() {
        return 0;
    }

    public int hashCode() {
        return this.iType.iName.hashCode();
    }

    public boolean isPrecise() {
        return true;
    }

    public boolean isSupported() {
        return false;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("UnsupportedDurationField["), this.iType.iName, ']');
    }

    public final UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException(this.iType + " field is unsupported");
    }

    public long add(long j, long j2) {
        throw unsupported();
    }
}
