package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;

public class ShowText extends OperatorProcessor {
    public String getName() {
        return "Tj";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (list.size() >= 1) {
            this.context.showTextString(((COSString) list.get(0)).getBytes());
        }
    }
}
