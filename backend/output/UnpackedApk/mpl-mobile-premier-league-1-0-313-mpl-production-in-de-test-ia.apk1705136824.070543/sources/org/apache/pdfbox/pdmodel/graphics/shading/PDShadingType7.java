package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;

public class PDShadingType7 extends PDShadingType6 {
    public PDShadingType7(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public int getShadingType() {
        return 7;
    }
}
