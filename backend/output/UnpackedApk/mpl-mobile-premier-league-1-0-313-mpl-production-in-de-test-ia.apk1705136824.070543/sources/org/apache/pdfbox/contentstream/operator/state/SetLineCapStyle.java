package org.apache.pdfbox.contentstream.operator.state;

import android.graphics.Paint.Cap;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class SetLineCapStyle extends OperatorProcessor {
    public String getName() {
        return "J";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        Cap cap;
        int intValue = ((COSNumber) list.get(0)).intValue();
        if (intValue == 0) {
            cap = Cap.BUTT;
        } else if (intValue == 1) {
            cap = Cap.ROUND;
        } else if (intValue != 2) {
            cap = null;
        } else {
            cap = Cap.SQUARE;
        }
        this.context.getGraphicsState().setLineCap(cap);
    }
}
