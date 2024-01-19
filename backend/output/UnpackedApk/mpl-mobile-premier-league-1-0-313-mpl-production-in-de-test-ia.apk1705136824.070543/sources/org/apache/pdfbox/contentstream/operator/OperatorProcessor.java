package org.apache.pdfbox.contentstream.operator;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.cos.COSBase;

public abstract class OperatorProcessor {
    public PDFStreamEngine context;

    public final PDFStreamEngine getContext() {
        return this.context;
    }

    public abstract String getName();

    public abstract void process(Operator operator, List<COSBase> list) throws IOException;

    public void setContext(PDFStreamEngine pDFStreamEngine) {
        this.context = pDFStreamEngine;
    }
}
