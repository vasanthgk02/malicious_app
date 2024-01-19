package org.apache.pdfbox.cos;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;

public final class COSInteger extends COSNumber {
    public static final int HIGH = 256;
    public static final int LOW = -100;
    public static final COSInteger ONE = get(1);
    public static final COSInteger[] STATIC = new COSInteger[357];
    public static final COSInteger THREE = get(3);
    public static final COSInteger TWO = get(2);
    public static final COSInteger ZERO = get(0);
    public final long value;

    public COSInteger(long j) {
        this.value = j;
    }

    public static COSInteger get(long j) {
        if (-100 > j || j > 256) {
            return new COSInteger(j);
        }
        int i = ((int) j) + 100;
        COSInteger[] cOSIntegerArr = STATIC;
        if (cOSIntegerArr[i] == null) {
            cOSIntegerArr[i] = new COSInteger(j);
        }
        return STATIC[i];
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromInt(this);
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof COSInteger) && ((COSInteger) obj).intValue() == intValue();
    }

    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >> 32));
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline58(GeneratedOutlineSupport.outline73("COSInt{"), this.value, "}");
    }

    public void writePDF(OutputStream outputStream) throws IOException {
        outputStream.write(String.valueOf(this.value).getBytes("ISO-8859-1"));
    }
}
