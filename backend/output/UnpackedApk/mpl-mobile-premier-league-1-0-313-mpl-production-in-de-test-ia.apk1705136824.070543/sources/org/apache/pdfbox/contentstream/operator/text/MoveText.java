package org.apache.pdfbox.contentstream.operator.text;

import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.util.Matrix;

public class MoveText extends OperatorProcessor {
    public String getName() {
        return "Td";
    }

    public void process(Operator operator, List<COSBase> list) {
        Matrix matrix = new Matrix(1.0f, 0.0f, 0.0f, 1.0f, ((COSNumber) list.get(0)).floatValue(), ((COSNumber) list.get(1)).floatValue());
        this.context.getTextLineMatrix().concatenate(matrix);
        PDFStreamEngine pDFStreamEngine = this.context;
        pDFStreamEngine.setTextMatrix(pDFStreamEngine.getTextLineMatrix().clone());
    }
}
