package org.apache.pdfbox.contentstream.operator.graphics;

import android.graphics.PointF;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public class CurveToReplicateInitialPoint extends GraphicsOperatorProcessor {
    public String getName() {
        return "v";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        PointF currentPoint = this.context.getCurrentPoint();
        PointF transformedPoint = this.context.transformedPoint(((COSNumber) list.get(0)).floatValue(), ((COSNumber) list.get(1)).floatValue());
        PointF transformedPoint2 = this.context.transformedPoint(((COSNumber) list.get(2)).floatValue(), ((COSNumber) list.get(3)).floatValue());
        this.context.curveTo(currentPoint.x, currentPoint.y, transformedPoint.x, transformedPoint.y, transformedPoint2.x, transformedPoint2.y);
    }
}
