package org.apache.pdfbox.cos;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

public class COSFloat extends COSNumber {
    public BigDecimal value;
    public String valueAsString;

    public COSFloat(float f2) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(f2));
        this.value = bigDecimal;
        this.valueAsString = removeNullDigits(bigDecimal.toPlainString());
    }

    public static String removeNullDigits(String str) {
        if (str.indexOf(46) > -1 && !str.endsWith(".0")) {
            while (str.endsWith("0") && !str.endsWith(".0")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromFloat(this);
    }

    public double doubleValue() {
        return this.value.doubleValue();
    }

    public boolean equals(Object obj) {
        return (obj instanceof COSFloat) && Float.floatToIntBits(((COSFloat) obj).value.floatValue()) == Float.floatToIntBits(this.value.floatValue());
    }

    public float floatValue() {
        return this.value.floatValue();
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public int intValue() {
        return this.value.intValue();
    }

    public long longValue() {
        return this.value.longValue();
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("COSFloat{"), this.valueAsString, "}");
    }

    public void writePDF(OutputStream outputStream) throws IOException {
        outputStream.write(this.valueAsString.getBytes("ISO-8859-1"));
    }

    public COSFloat(String str) throws IOException {
        try {
            this.valueAsString = str;
            this.value = new BigDecimal(this.valueAsString);
        } catch (NumberFormatException e2) {
            throw new IOException(GeneratedOutlineSupport.outline52("Error expected floating point number actual='", str, "'"), e2);
        }
    }
}
