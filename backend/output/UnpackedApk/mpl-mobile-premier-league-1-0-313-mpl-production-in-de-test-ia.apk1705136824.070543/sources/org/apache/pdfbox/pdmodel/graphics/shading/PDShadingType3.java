package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;

public class PDShadingType3 extends PDShadingType2 {
    public PDShadingType3(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public int getShadingType() {
        return 3;
    }
}
