package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.w3c.dom.Element;

public class FDFAnnotationSquare extends FDFAnnotation {
    public static final String SUBTYPE = "Square";

    public FDFAnnotationSquare() {
        this.annot.setName(COSName.SUBTYPE, (String) "Square");
    }

    public FDFAnnotationSquare(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationSquare(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, (String) "Square");
    }
}
