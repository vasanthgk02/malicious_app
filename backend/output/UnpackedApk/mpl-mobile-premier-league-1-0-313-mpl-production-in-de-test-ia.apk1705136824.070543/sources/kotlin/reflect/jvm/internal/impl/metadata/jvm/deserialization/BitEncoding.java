package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import org.apache.pdfbox.pdfparser.BaseParser;

public class BitEncoding {
    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        BaseParser.TRUE.equals(str);
    }

    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v4
      assigns: []
      uses: []
      mth insns count: 110
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decodeBytes(java.lang.String[] r13) {
        /*
            int r0 = r13.length
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0070
            r0 = r13[r2]
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0070
            r0 = r13[r2]
            char r0 = r0.charAt(r2)
            if (r0 != 0) goto L_0x0067
            java.lang.String[] r13 = dropMarker(r13)
            java.lang.String r0 = "strings"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            int r0 = r13.length
            r3 = 0
            r4 = 0
        L_0x0022:
            if (r3 >= r0) goto L_0x002e
            r5 = r13[r3]
            int r5 = r5.length()
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L_0x0022
        L_0x002e:
            byte[] r0 = new byte[r4]
            int r3 = r13.length
            r5 = 0
            r6 = 0
        L_0x0033:
            if (r5 >= r3) goto L_0x0053
            r7 = r13[r5]
            int r5 = r5 + 1
            int r8 = r7.length()
            int r8 = r8 - r1
            if (r8 < 0) goto L_0x0033
            r9 = 0
        L_0x0041:
            int r10 = r9 + 1
            int r11 = r6 + 1
            char r12 = r7.charAt(r9)
            byte r12 = (byte) r12
            r0[r6] = r12
            if (r9 != r8) goto L_0x0050
            r6 = r11
            goto L_0x0033
        L_0x0050:
            r9 = r10
            r6 = r11
            goto L_0x0041
        L_0x0053:
            if (r6 != r4) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            boolean r13 = kotlin._Assertions.ENABLED
            if (r13 == 0) goto L_0x0066
            if (r1 == 0) goto L_0x005e
            goto L_0x0066
        L_0x005e:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r0 = "Should have reached the end"
            r13.<init>(r0)
            throw r13
        L_0x0066:
            return r0
        L_0x0067:
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L_0x0070
            java.lang.String[] r13 = dropMarker(r13)
        L_0x0070:
            int r0 = r13.length
            r3 = 0
            r4 = 0
        L_0x0073:
            if (r3 >= r0) goto L_0x007f
            r5 = r13[r3]
            int r5 = r5.length()
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L_0x0073
        L_0x007f:
            byte[] r0 = new byte[r4]
            int r3 = r13.length
            r5 = 0
            r6 = 0
        L_0x0084:
            if (r5 >= r3) goto L_0x009f
            r7 = r13[r5]
            int r8 = r7.length()
            r9 = 0
        L_0x008d:
            if (r9 >= r8) goto L_0x009c
            int r10 = r6 + 1
            char r11 = r7.charAt(r9)
            byte r11 = (byte) r11
            r0[r6] = r11
            int r9 = r9 + 1
            r6 = r10
            goto L_0x008d
        L_0x009c:
            int r5 = r5 + 1
            goto L_0x0084
        L_0x009f:
            r13 = 0
        L_0x00a0:
            if (r13 >= r4) goto L_0x00ae
            byte r3 = r0[r13]
            int r3 = r3 + 127
            r3 = r3 & 127(0x7f, float:1.78E-43)
            byte r3 = (byte) r3
            r0[r13] = r3
            int r13 = r13 + 1
            goto L_0x00a0
        L_0x00ae:
            int r4 = r4 * 7
            int r4 = r4 / 8
            byte[] r13 = new byte[r4]
            r3 = 0
            r5 = 0
            r6 = 0
        L_0x00b7:
            if (r3 >= r4) goto L_0x00d9
            byte r7 = r0[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 >>> r6
            int r5 = r5 + r1
            byte r8 = r0[r5]
            int r9 = r6 + 1
            int r10 = r1 << r9
            int r10 = r10 - r1
            r8 = r8 & r10
            int r10 = 7 - r6
            int r8 = r8 << r10
            int r7 = r7 + r8
            byte r7 = (byte) r7
            r13[r3] = r7
            r7 = 6
            if (r6 != r7) goto L_0x00d5
            int r5 = r5 + 1
            r6 = 0
            goto L_0x00d6
        L_0x00d5:
            r6 = r9
        L_0x00d6:
            int r3 = r3 + 1
            goto L_0x00b7
        L_0x00d9:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding.decodeBytes(java.lang.String[]):byte[]");
    }

    public static String[] dropMarker(String[] strArr) {
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }
}
