package org.spongycastle.math.field;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class GF2Polynomial {
    public final int[] exponents;

    public GF2Polynomial(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.exponents = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GF2Polynomial)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.exponents, ((GF2Polynomial) obj).exponents);
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(this.exponents);
    }
}
