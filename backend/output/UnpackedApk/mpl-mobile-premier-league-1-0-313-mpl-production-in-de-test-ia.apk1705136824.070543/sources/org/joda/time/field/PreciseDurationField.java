package org.joda.time.field;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DurationFieldType;

public class PreciseDurationField extends BaseDurationField {
    public static final long serialVersionUID = -8346152187724495365L;
    public final long iUnitMillis;

    public PreciseDurationField(DurationFieldType durationFieldType, long j) {
        super(durationFieldType);
        this.iUnitMillis = j;
    }

    public long add(long j, int i) {
        return TypeUtilsKt.safeAdd(j, ((long) i) * this.iUnitMillis);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreciseDurationField)) {
            return false;
        }
        PreciseDurationField preciseDurationField = (PreciseDurationField) obj;
        if (!(this.iType == preciseDurationField.iType && this.iUnitMillis == preciseDurationField.iUnitMillis)) {
            z = false;
        }
        return z;
    }

    public final long getUnitMillis() {
        return this.iUnitMillis;
    }

    public int hashCode() {
        long j = this.iUnitMillis;
        return this.iType.hashCode() + ((int) (j ^ (j >>> 32)));
    }

    public final boolean isPrecise() {
        return true;
    }

    public long add(long j, long j2) {
        long j3 = this.iUnitMillis;
        if (j3 != 1) {
            if (j2 == 1) {
                j2 = j3;
            } else {
                long j4 = 0;
                if (!(j2 == 0 || j3 == 0)) {
                    j4 = j2 * j3;
                    if (j4 / j3 != j2 || ((j2 == Long.MIN_VALUE && j3 == -1) || (j3 == Long.MIN_VALUE && j2 == -1))) {
                        StringBuilder outline76 = GeneratedOutlineSupport.outline76("Multiplication overflows a long: ", j2, " * ");
                        outline76.append(j3);
                        throw new ArithmeticException(outline76.toString());
                    }
                }
                j2 = j4;
            }
        }
        return TypeUtilsKt.safeAdd(j, j2);
    }
}
