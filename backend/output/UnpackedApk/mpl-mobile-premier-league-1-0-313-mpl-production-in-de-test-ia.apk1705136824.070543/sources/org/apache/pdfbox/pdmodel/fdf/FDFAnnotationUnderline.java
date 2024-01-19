package org.apache.pdfbox.pdmodel.fdf;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.w3c.dom.Element;

public class FDFAnnotationUnderline extends FDFAnnotation {
    public static final String SUBTYPE = "Underline";

    public FDFAnnotationUnderline() {
        this.annot.setName(COSName.SUBTYPE, (String) "Underline");
    }

    public FDFAnnotationUnderline(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationUnderline(Element element) throws IOException {
        super(element);
        this.annot.setName(COSName.SUBTYPE, (String) "Underline");
    }
}
