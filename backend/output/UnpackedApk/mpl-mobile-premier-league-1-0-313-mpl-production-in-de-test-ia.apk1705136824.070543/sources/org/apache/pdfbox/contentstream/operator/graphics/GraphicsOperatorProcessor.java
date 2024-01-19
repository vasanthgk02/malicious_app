package org.apache.pdfbox.contentstream.operator.graphics;

import org.apache.pdfbox.contentstream.PDFGraphicsStreamEngine;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;

public abstract class GraphicsOperatorProcessor extends OperatorProcessor {
    public PDFGraphicsStreamEngine context;

    public void setContext(PDFStreamEngine pDFStreamEngine) {
        super.setContext(pDFStreamEngine);
        this.context = (PDFGraphicsStreamEngine) pDFStreamEngine;
    }
}
