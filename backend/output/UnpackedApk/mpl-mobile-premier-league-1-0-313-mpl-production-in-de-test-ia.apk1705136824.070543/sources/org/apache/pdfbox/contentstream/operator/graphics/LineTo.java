package org.apache.pdfbox.contentstream.operator.graphics;

import android.graphics.PointF;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class LineTo extends GraphicsOperatorProcessor {
    public String getName() {
        return "l";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        PointF transformedPoint = this.context.transformedPoint(((COSNumber) list.get(0)).floatValue(), ((COSNumber) list.get(1)).floatValue());
        this.context.lineTo(transformedPoint.x, transformedPoint.y);
    }
}
