package com.userexperior.a.a.b;

import java.math.BigDecimal;

public final class i extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f3693a;

    public i(String str) {
        this.f3693a = str;
    }

    public final double doubleValue() {
        return Double.parseDouble(this.f3693a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        String str = this.f3693a;
        String str2 = ((i) obj).f3693a;
        return str == str2 || str.equals(str2);
    }

    public final float floatValue() {
        return Float.parseFloat(this.f3693a);
    }

    public final int hashCode() {
        return this.f3693a.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return (int) java.lang.Long.parseLong(r2.f3693a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        return new java.math.BigDecimal(r2.f3693a).intValue();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int intValue() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f3693a     // Catch:{ NumberFormatException -> 0x0007 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0007 }
            return r0
        L_0x0007:
            java.lang.String r0 = r2.f3693a     // Catch:{ NumberFormatException -> 0x000f }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x000f }
            int r1 = (int) r0
            return r1
        L_0x000f:
            java.math.BigDecimal r0 = new java.math.BigDecimal
            java.lang.String r1 = r2.f3693a
            r0.<init>(r1)
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.i.intValue():int");
    }

    public final long longValue() {
        try {
            return Long.parseLong(this.f3693a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f3693a).longValue();
        }
    }

    public final String toString() {
        return this.f3693a;
    }
}
