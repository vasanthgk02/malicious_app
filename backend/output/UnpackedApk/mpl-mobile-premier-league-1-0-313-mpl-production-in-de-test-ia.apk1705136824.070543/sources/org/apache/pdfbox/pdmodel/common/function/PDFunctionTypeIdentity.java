package org.apache.pdfbox.pdmodel.common.function;

import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;

public class PDFunctionTypeIdentity extends PDFunction {
    public PDFunctionTypeIdentity(COSBase cOSBase) {
        super(null);
    }

    public float[] eval(float[] fArr) throws IOException {
        return fArr;
    }

    public int getFunctionType() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "FunctionTypeIdentity";
    }
}
