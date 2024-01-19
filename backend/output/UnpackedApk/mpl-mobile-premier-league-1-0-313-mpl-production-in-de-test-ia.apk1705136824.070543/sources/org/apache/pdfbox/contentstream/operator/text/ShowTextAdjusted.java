package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;

public class ShowTextAdjusted extends OperatorProcessor {
    public String getName() {
        return "TJ";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.showTextStrings((COSArray) list.get(0));
    }
}
