package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;

public class EndText extends OperatorProcessor {
    public String getName() {
        return "ET";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.setTextMatrix(null);
        this.context.setTextLineMatrix(null);
        this.context.endText();
    }
}
