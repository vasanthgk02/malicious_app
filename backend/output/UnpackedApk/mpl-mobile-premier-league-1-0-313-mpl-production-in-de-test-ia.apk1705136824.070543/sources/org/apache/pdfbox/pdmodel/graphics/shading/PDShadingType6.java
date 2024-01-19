package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;

public class PDShadingType6 extends PDShadingType4 {
    public PDShadingType6(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public int getShadingType() {
        return 6;
    }
}
