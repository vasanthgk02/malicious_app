package org.spongycastle.math.ec;

import java.math.BigInteger;

public interface ECConstants {
    public static final BigInteger ONE = BigInteger.valueOf(1);
    public static final BigInteger TWO = BigInteger.valueOf(2);
    public static final BigInteger ZERO = BigInteger.valueOf(0);

    static {
        BigInteger.valueOf(3);
        BigInteger.valueOf(4);
        BigInteger.valueOf(8);
    }
}
