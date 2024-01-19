package org.apache.pdfbox.contentstream.operator.state;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class SetLineWidth extends OperatorProcessor {
    public String getName() {
        return "w";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (list.size() >= 1) {
            this.context.getGraphicsState().setLineWidth(((COSNumber) list.get(0)).floatValue());
            return;
        }
        throw new MissingOperandException(operator, list);
    }
}
