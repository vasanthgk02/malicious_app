package org.apache.pdfbox.contentstream.operator.state;

import android.graphics.Paint.Join;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class SetLineJoinStyle extends OperatorProcessor {
    public String getName() {
        return "j";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        Join join;
        int intValue = ((COSNumber) list.get(0)).intValue();
        if (intValue == 0) {
            join = Join.MITER;
        } else if (intValue == 1) {
            join = Join.ROUND;
        } else if (intValue != 2) {
            join = null;
        } else {
            join = Join.BEVEL;
        }
        this.context.getGraphicsState().setLineJoin(join);
    }
}
