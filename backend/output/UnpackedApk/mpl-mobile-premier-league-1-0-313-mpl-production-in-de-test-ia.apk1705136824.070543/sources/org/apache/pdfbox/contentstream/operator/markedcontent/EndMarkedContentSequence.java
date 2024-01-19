package org.apache.pdfbox.contentstream.operator.markedcontent;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;

public class EndMarkedContentSequence extends OperatorProcessor {
    public String getName() {
        return "EMC";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        PDFStreamEngine pDFStreamEngine = this.context;
        if (pDFStreamEngine instanceof PDFMarkedContentExtractor) {
            ((PDFMarkedContentExtractor) pDFStreamEngine).endMarkedContentSequence();
        }
    }
}
