package com.facebook.imagepipeline.common;

import co.hyperverge.hypersnapsdk.c.k;
import java.util.regex.Pattern;

public class BytesRange {
    public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;
    public static Pattern sHeaderParsingRegEx;
    public final int from;
    public final int to;

    public BytesRange(int i, int i2) {
        this.from = i;
        this.to = i2;
    }

    public static BytesRange from(int i) {
        k.checkArgument(i >= 0);
        return new BytesRange(i, Integer.MAX_VALUE);
    }

    public static BytesRange fromContentRangeHeader(String str) throws IllegalArgumentException {
        if (str == null) {
            return null;
        }
        if (sHeaderParsingRegEx == null) {
            sHeaderParsingRegEx = Pattern.compile("[-/ ]");
        }
        try {
            String[] split = sHeaderParsingRegEx.split(str);
            k.checkArgument(split.length == 4);
            k.checkArgument(split[0].equals("bytes"));
            int parseInt = Integer.parseInt(split[1]);
            int parseInt2 = Integer.parseInt(split[2]);
            int parseInt3 = Integer.parseInt(split[3]);
            k.checkArgument(parseInt2 > parseInt);
            k.checkArgument(parseInt3 > parseInt2);
            if (parseInt2 < parseInt3 - 1) {
                return new BytesRange(parseInt, parseInt2);
            }
            return new BytesRange(parseInt, Integer.MAX_VALUE);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(String.format(null, "Invalid Content-Range header value: \"%s\"", new Object[]{str}), e2);
        }
    }

    public static BytesRange toMax(int i) {
        k.checkArgument(i > 0);
        return new BytesRange(0, i);
    }

    public static String valueOrEmpty(int i) {
        return i == Integer.MAX_VALUE ? "" : Integer.toString(i);
    }

    public boolean contains(BytesRange bytesRange) {
        boolean z = false;
        if (bytesRange == null) {
            return false;
        }
        if (this.from <= bytesRange.from && this.to >= bytesRange.to) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BytesRange)) {
            return false;
        }
        BytesRange bytesRange = (BytesRange) obj;
        if (!(this.from == bytesRange.from && this.to == bytesRange.to)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return k.hashCode(this.from, this.to);
    }

    public String toHttpRangeHeaderValue() {
        return String.format(null, "bytes=%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.to)});
    }

    public String toString() {
        return String.format(null, "%s-%s", new Object[]{valueOrEmpty(this.from), valueOrEmpty(this.to)});
    }
}
