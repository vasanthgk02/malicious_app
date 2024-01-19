package org.apache.pdfbox.contentstream.operator.text;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;

public class SetTextRenderingMode extends OperatorProcessor {
    public String getName() {
        return "Tr";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        this.context.getGraphicsState().getTextState().setRenderingMode(RenderingMode.fromInt(((COSNumber) list.get(0)).intValue()));
    }
}
