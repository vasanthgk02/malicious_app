package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.w3c.dom.Element;

public class FDFAnnotationLine extends FDFAnnotation {
    public static final String SUBTYPE = "Line";

    public FDFAnnotationLine() {
        this.annot.setName(COSName.SUBTYPE, (String) "Line");
    }

    public FDFAnnotationLine(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationLine(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, (String) "Line");
    }
}
