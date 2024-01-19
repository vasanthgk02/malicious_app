package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;

public class ShowTextLine extends OperatorProcessor {
    public String getName() {
        return "'";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.processOperator((String) "T*", (List<COSBase>) null);
        this.context.processOperator((String) "Tj", list);
    }
}
