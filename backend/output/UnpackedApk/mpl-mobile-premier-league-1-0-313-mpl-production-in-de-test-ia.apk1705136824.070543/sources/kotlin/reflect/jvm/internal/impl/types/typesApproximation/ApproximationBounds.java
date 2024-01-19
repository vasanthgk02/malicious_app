package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CapturedTypeApproximation.kt */
public final class ApproximationBounds<T> {
    public final T lower;
    public final T upper;

    public ApproximationBounds(T t, T t2) {
        this.lower = t;
        this.upper = t2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApproximationBounds)) {
            return false;
        }
        ApproximationBounds approximationBounds = (ApproximationBounds) obj;
        return Intrinsics.areEqual(this.lower, approximationBounds.lower) && Intrinsics.areEqual(this.upper, approximationBounds.upper);
    }

    public int hashCode() {
        T t = this.lower;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.upper;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ApproximationBounds(lower=");
        outline73.append(this.lower);
        outline73.append(", upper=");
        outline73.append(this.upper);
        outline73.append(')');
        return outline73.toString();
    }
}
