package org.apache.fontbox.cff;

public class CIDKeyedType2CharString extends Type2CharString {
    public final int cid;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CIDKeyedType2CharString(org.apache.fontbox.type1.Type1CharStringReader r11, java.lang.String r12, int r13, int r14, java.util.List<java.lang.Object> r15, int r16, int r17) {
        /*
            r10 = this;
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r2 = 0
            r0[r2] = r1
            java.lang.String r1 = "%04x"
            java.lang.String r5 = java.lang.String.format(r1, r0)
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r0 = r10
            r1 = r13
            r0.cid = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.fontbox.cff.CIDKeyedType2CharString.<init>(org.apache.fontbox.type1.Type1CharStringReader, java.lang.String, int, int, java.util.List, int, int):void");
    }

    public int getCID() {
        return this.cid;
    }
}
