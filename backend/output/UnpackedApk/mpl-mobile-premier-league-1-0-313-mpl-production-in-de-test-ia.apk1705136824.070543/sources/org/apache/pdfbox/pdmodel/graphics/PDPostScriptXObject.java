package org.apache.pdfbox.pdmodel.graphics;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDStream;

public class PDPostScriptXObject extends PDXObject {
    public PDPostScriptXObject(PDStream pDStream) {
        super(pDStream, COSName.PS);
    }
}
