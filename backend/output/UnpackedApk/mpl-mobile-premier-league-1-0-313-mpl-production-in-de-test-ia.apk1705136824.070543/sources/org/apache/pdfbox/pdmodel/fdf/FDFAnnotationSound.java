package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.w3c.dom.Element;

public class FDFAnnotationSound extends FDFAnnotation {
    public static final String SUBTYPE = "Sound";

    public FDFAnnotationSound() {
        this.annot.setName(COSName.SUBTYPE, (String) "Sound");
    }

    public FDFAnnotationSound(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationSound(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, (String) "Sound");
    }
}
