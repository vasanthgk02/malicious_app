package org.apache.pdfbox.contentstream.operator;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.pdfbox.cos.COSDictionary;

public final class Operator {
    public static final ConcurrentMap<String, Operator> operators = new ConcurrentHashMap();
    public byte[] imageData;
    public COSDictionary imageParameters;
    public final String theOperator;

    public Operator(String str) {
        this.theOperator = str;
        if (str.startsWith("/")) {
            throw new RuntimeException(GeneratedOutlineSupport.outline52("Operators are not allowed to start with / '", str, "'"));
        }
    }

    public static Operator getOperator(String str) {
        if (str.equals("ID") || str.equals("BI")) {
            return new Operator(str);
        }
        Operator operator = (Operator) operators.get(str);
        if (operator != null) {
            return operator;
        }
        Operator putIfAbsent = operators.putIfAbsent(str, new Operator(str));
        if (putIfAbsent == null) {
            return (Operator) operators.get(str);
        }
        return putIfAbsent;
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public COSDictionary getImageParameters() {
        return this.imageParameters;
    }

    public String getName() {
        return this.theOperator;
    }

    public void setImageData(byte[] bArr) {
        this.imageData = bArr;
    }

    public void setImageParameters(COSDictionary cOSDictionary) {
        this.imageParameters = cOSDictionary;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("PDFOperator{"), this.theOperator, "}");
    }
}
