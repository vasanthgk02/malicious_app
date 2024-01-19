package org.apache.pdfbox.contentstream.operator.graphics;

import android.graphics.PointF;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFGraphicsStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSNumber;

public final class CurveToReplicateFinalPoint extends GraphicsOperatorProcessor {
    public String getName() {
        return "y";
    }

    public void process(Operator operator, List<COSBase> list) throws IOException {
        PointF transformedPoint = this.context.transformedPoint(((COSNumber) list.get(0)).floatValue(), ((COSNumber) list.get(1)).floatValue());
        PointF transformedPoint2 = this.context.transformedPoint(((COSNumber) list.get(2)).floatValue(), ((COSNumber) list.get(3)).floatValue());
        PDFGraphicsStreamEngine pDFGraphicsStreamEngine = this.context;
        float f2 = transformedPoint.x;
        float f3 = transformedPoint.y;
        float f4 = transformedPoint2.x;
        float f5 = transformedPoint2.y;
        pDFGraphicsStreamEngine.curveTo(f2, f3, f4, f5, f4, f5);
    }
}
