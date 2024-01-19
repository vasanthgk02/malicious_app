package org.apache.pdfbox.pdmodel.graphics.color;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

public abstract class PDDeviceColorSpace extends PDColorSpace {
    public COSBase getCOSObject() {
        return COSName.getPDFName(getName());
    }

    public String toString() {
        return getName();
    }
}
