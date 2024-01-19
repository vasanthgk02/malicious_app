package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.w3c.dom.Element;

public class FDFAnnotationCircle extends FDFAnnotation {
    public static final String SUBTYPE = "Circle";

    public FDFAnnotationCircle() {
        this.annot.setName(COSName.SUBTYPE, (String) "Circle");
    }

    public FDFAnnotationCircle(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationCircle(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, (String) "Circle");
    }
}
