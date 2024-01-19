package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;

public class SetFontAndSize extends OperatorProcessor {
    public String getName() {
        return "Tf";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (list.size() >= 2) {
            this.context.getGraphicsState().getTextState().setFontSize(((COSNumber) list.get(1)).floatValue());
            this.context.getGraphicsState().getTextState().setFont(this.context.getResources().getFont((COSName) list.get(0)));
            return;
        }
        throw new MissingOperandException(operator, list);
    }
}
