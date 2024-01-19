package org.apache.pdfbox.cos;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public abstract class COSNumber extends COSBase {
    @Deprecated
    public static final COSInteger ONE = COSInteger.ONE;
    @Deprecated
    public static final COSInteger ZERO = COSInteger.ZERO;

    public static COSNumber get(String str) throws IOException {
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if ('0' <= charAt && charAt <= '9') {
                return COSInteger.get((long) (charAt - '0'));
            }
            if (charAt == '-' || charAt == '.') {
                return COSInteger.ZERO;
            }
            throw new IOException(GeneratedOutlineSupport.outline50("Not a number: ", str));
        } else if (str.indexOf(46) != -1 || str.toLowerCase().indexOf(101) != -1) {
            return new COSFloat(str);
        } else {
            try {
                if (str.charAt(0) == '+') {
                    return COSInteger.get(Long.parseLong(str.substring(1)));
                }
                return COSInteger.get(Long.parseLong(str));
            } catch (NumberFormatException e2) {
                throw new IOException(GeneratedOutlineSupport.outline50("Value is not an integer: ", str), e2);
            }
        }
    }

    public abstract double doubleValue();

    public abstract float floatValue();

    public abstract int intValue();

    public abstract long longValue();
}
