package org.apache.pdfbox.contentstream.operator;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;

public class DrawObject extends OperatorProcessor {
    public String getName() {
        return "Do";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        PDXObject xObject = this.context.getResources().getXObject((COSName) list.get(0));
        PDFStreamEngine pDFStreamEngine = this.context;
        if (pDFStreamEngine instanceof PDFMarkedContentExtractor) {
            ((PDFMarkedContentExtractor) pDFStreamEngine).xobject(xObject);
        }
        if (xObject instanceof PDFormXObject) {
            this.context.showForm((PDFormXObject) xObject);
        }
    }
}
