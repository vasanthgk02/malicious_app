package org.apache.pdfbox.contentstream.operator.state;

import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class SetLineDashPattern extends OperatorProcessor {
    public String getName() {
        return "d";
    }

    public void process(Operator operator, List<COSBase> list) {
        int intValue = ((COSNumber) list.get(1)).intValue();
        this.context.setLineDashPattern((COSArray) list.get(0), intValue);
    }
}
