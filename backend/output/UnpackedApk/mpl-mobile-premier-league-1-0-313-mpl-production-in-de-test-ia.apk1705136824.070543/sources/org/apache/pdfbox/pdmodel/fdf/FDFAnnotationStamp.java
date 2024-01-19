package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.w3c.dom.Element;

public class FDFAnnotationStamp extends FDFAnnotation {
    public static final String SUBTYPE = "Stamp";

    public FDFAnnotationStamp() {
        this.annot.setName(COSName.SUBTYPE, (String) "Stamp");
    }

    public FDFAnnotationStamp(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationStamp(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, (String) "Stamp");
    }
}
