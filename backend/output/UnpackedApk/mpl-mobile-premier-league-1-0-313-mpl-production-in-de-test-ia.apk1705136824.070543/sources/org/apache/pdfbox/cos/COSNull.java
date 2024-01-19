package org.apache.pdfbox.cos;

import java.io.IOException;
import java.io.OutputStream;

public final class COSNull extends COSBase {
    public static final COSNull NULL = new COSNull();
    public static final byte[] NULL_BYTES = {110, 117, 108, 108};

    public static void writePDF(OutputStream outputStream) throws IOException {
        outputStream.write(NULL_BYTES);
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromNull(this);
    }

    public String toString() {
        return "COSNull{}";
    }
}
