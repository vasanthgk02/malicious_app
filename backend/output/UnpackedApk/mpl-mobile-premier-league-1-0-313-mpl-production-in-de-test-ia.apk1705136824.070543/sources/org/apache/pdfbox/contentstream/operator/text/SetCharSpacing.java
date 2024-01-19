package org.apache.pdfbox.contentstream.operator.text;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.contentstream.operator.OperatorProcessor;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class SetCharSpacing extends OperatorProcessor {
    public String getName() {
        return "Tc";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        if (list.size() != 0) {
            Object outline29 = GeneratedOutlineSupport.outline29(list, -1);
            if (outline29 instanceof COSNumber) {
                this.context.getGraphicsState().getTextState().setCharacterSpacing(((COSNumber) outline29).floatValue());
                return;
            }
            return;
        }
        throw new MissingOperandException(operator, list);
    }
}
