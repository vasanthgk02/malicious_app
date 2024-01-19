package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class SetTextRise extends OperatorProcessor {
    public String getName() {
        return "Ts";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.getGraphicsState().getTextState().setRise(((COSNumber) list.get(0)).floatValue());
    }
}