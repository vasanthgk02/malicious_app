package kotlin.reflect.jvm.internal.impl.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.paynimo.android.payment.UPIFragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: numbers.kt */
public final class NumberWithRadix {
    public final String number;
    public final int radix;

    public NumberWithRadix(String str, int i) {
        Intrinsics.checkNotNullParameter(str, UPIFragment.CONFIG_TYPE_NUMBER);
        this.number = str;
        this.radix = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumberWithRadix)) {
            return false;
        }
        NumberWithRadix numberWithRadix = (NumberWithRadix) obj;
        return Intrinsics.areEqual(this.number, numberWithRadix.number) && this.radix == numberWithRadix.radix;
    }

    public int hashCode() {
        return (this.number.hashCode() * 31) + this.radix;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NumberWithRadix(number=");
        outline73.append(this.number);
        outline73.append(", radix=");
        return GeneratedOutlineSupport.outline56(outline73, this.radix, ')');
    }
}
