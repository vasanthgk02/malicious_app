package org.spongycastle.math.ec.endo;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigInteger;

public class GLVTypeBParameters {
    public final BigInteger beta;

    public GLVTypeBParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger3, BigInteger bigInteger4, int i) {
        checkVector(bigIntegerArr, "v1");
        checkVector(bigIntegerArr2, "v2");
        this.beta = bigInteger;
        BigInteger bigInteger5 = bigIntegerArr[0];
        BigInteger bigInteger6 = bigIntegerArr[1];
        BigInteger bigInteger7 = bigIntegerArr2[0];
        BigInteger bigInteger8 = bigIntegerArr2[1];
    }

    public static void checkVector(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("'", str, "' must consist of exactly 2 (non-null) values"));
        }
    }
}
