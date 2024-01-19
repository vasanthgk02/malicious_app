package org.apache.pdfbox.contentstream.operator.graphics;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public final class AppendRectangleToPath extends GraphicsOperatorProcessor {
    public String getName() {
        return "re";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        float floatValue = ((COSNumber) list.get(0)).floatValue();
        float floatValue2 = ((COSNumber) list.get(1)).floatValue();
        float floatValue3 = ((COSNumber) list.get(2)).floatValue() + floatValue;
        float floatValue4 = ((COSNumber) list.get(3)).floatValue() + floatValue2;
        this.context.appendRectangle(this.context.transformedPoint(floatValue, floatValue2), this.context.transformedPoint(floatValue3, floatValue2), this.context.transformedPoint(floatValue3, floatValue4), this.context.transformedPoint(floatValue, floatValue4));
    }
}
