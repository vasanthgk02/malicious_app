package org.apache.pdfbox.contentstream.operator.state;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

public class SetGraphicsStateParameters extends OperatorProcessor {
    public String getName() {
        return "gs";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.getResources().getExtGState((COSName) list.get(0)).copyIntoGraphicsState(this.context.getGraphicsState());
    }
}
