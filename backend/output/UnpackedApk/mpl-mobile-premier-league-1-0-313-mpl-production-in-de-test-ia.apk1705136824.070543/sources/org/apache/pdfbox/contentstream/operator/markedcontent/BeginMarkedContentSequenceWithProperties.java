package org.apache.pdfbox.contentstream.operator.markedcontent;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;

public class BeginMarkedContentSequenceWithProperties extends OperatorProcessor {
    public String getName() {
        return "BDC";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        COSName cOSName = null;
        COSDictionary cOSDictionary = null;
        for (COSBase next : list) {
            if (next instanceof COSName) {
                cOSName = (COSName) next;
            } else if (next instanceof COSDictionary) {
                cOSDictionary = (COSDictionary) next;
            }
        }
        PDFStreamEngine pDFStreamEngine = this.context;
        if (pDFStreamEngine instanceof PDFMarkedContentExtractor) {
            ((PDFMarkedContentExtractor) pDFStreamEngine).beginMarkedContentSequence(cOSName, cOSDictionary);
        }
    }
}
