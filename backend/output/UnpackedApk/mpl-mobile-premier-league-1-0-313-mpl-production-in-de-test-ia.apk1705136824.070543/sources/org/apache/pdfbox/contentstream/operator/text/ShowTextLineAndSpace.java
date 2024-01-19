package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;

public class ShowTextLineAndSpace extends OperatorProcessor {
    public String getName() {
        return "\"";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.processOperator((String) "Tw", list.subList(0, 1));
        this.context.processOperator((String) "Tc", list.subList(1, 2));
        this.context.processOperator((String) "'", list.subList(2, 3));
    }
}
