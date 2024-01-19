package org.apache.pdfbox.cos;

import java.io.IOException;
import java.io.OutputStream;

public final class COSBoolean extends COSBase {
    public static final COSBoolean FALSE = new COSBoolean(false);
    public static final byte[] FALSE_BYTES = {102, 97, 108, 115, 101};
    public static final COSBoolean TRUE = new COSBoolean(true);
    public static final byte[] TRUE_BYTES = {116, 114, 117, 101};
    public final boolean value;

    public COSBoolean(boolean z) {
        this.value = z;
    }

    public static COSBoolean getBoolean(boolean z) {
        return z ? TRUE : FALSE;
    }

    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromBoolean(this);
    }

    public boolean getValue() {
        return this.value;
    }

    public Boolean getValueAsObject() {
        return this.value ? Boolean.TRUE : Boolean.FALSE;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public void writePDF(OutputStream outputStream) throws IOException {
        if (this.value) {
            outputStream.write(TRUE_BYTES);
        } else {
            outputStream.write(FALSE_BYTES);
        }
    }

    public static COSBoolean getBoolean(Boolean bool) {
        return getBoolean(bool.booleanValue());
    }
}
