package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

public class ShapeData {
    public boolean closed;
    public final List<CubicCurveData> curves;
    public PointF initialPoint;

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.initialPoint = pointF;
        this.closed = z;
        this.curves = new ArrayList(list);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ShapeData{numCurves=");
        outline73.append(this.curves.size());
        outline73.append("closed=");
        return GeneratedOutlineSupport.outline65(outline73, this.closed, '}');
    }

    public ShapeData() {
        this.curves = new ArrayList();
    }
}
