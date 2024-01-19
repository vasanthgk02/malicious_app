package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    public final Path tempPath = new Path();
    public final ShapeData tempShapeData = new ShapeData();

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    public Object getValue(Keyframe keyframe, float f2) {
        List<CubicCurveData> list;
        ShapeData shapeData = (ShapeData) keyframe.startValue;
        ShapeData shapeData2 = (ShapeData) keyframe.endValue;
        ShapeData shapeData3 = this.tempShapeData;
        if (shapeData3.initialPoint == null) {
            shapeData3.initialPoint = new PointF();
        }
        shapeData3.closed = shapeData.closed || shapeData2.closed;
        if (shapeData.curves.size() != shapeData2.curves.size()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Curves must have the same number of control points. Shape 1: ");
            outline73.append(shapeData.curves.size());
            outline73.append("\tShape 2: ");
            outline73.append(shapeData2.curves.size());
            Logger.warning(outline73.toString());
        }
        int min = Math.min(shapeData.curves.size(), shapeData2.curves.size());
        if (shapeData3.curves.size() < min) {
            for (int size = shapeData3.curves.size(); size < min; size++) {
                shapeData3.curves.add(new CubicCurveData());
            }
        } else if (shapeData3.curves.size() > min) {
            for (int size2 = shapeData3.curves.size() - 1; size2 >= min; size2--) {
                list.remove(shapeData3.curves.size() - 1);
            }
        }
        PointF pointF = shapeData.initialPoint;
        PointF pointF2 = shapeData2.initialPoint;
        float lerp = MiscUtils.lerp(pointF.x, pointF2.x, f2);
        float lerp2 = MiscUtils.lerp(pointF.y, pointF2.y, f2);
        if (shapeData3.initialPoint == null) {
            shapeData3.initialPoint = new PointF();
        }
        shapeData3.initialPoint.set(lerp, lerp2);
        for (int size3 = shapeData3.curves.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.curves.get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.curves.get(size3);
            PointF pointF3 = cubicCurveData.controlPoint1;
            PointF pointF4 = cubicCurveData.controlPoint2;
            PointF pointF5 = cubicCurveData.vertex;
            PointF pointF6 = cubicCurveData2.controlPoint1;
            PointF pointF7 = cubicCurveData2.controlPoint2;
            PointF pointF8 = cubicCurveData2.vertex;
            shapeData3.curves.get(size3).controlPoint1.set(MiscUtils.lerp(pointF3.x, pointF6.x, f2), MiscUtils.lerp(pointF3.y, pointF6.y, f2));
            shapeData3.curves.get(size3).controlPoint2.set(MiscUtils.lerp(pointF4.x, pointF7.x, f2), MiscUtils.lerp(pointF4.y, pointF7.y, f2));
            shapeData3.curves.get(size3).vertex.set(MiscUtils.lerp(pointF5.x, pointF8.x, f2), MiscUtils.lerp(pointF5.y, pointF8.y, f2));
        }
        ShapeData shapeData4 = this.tempShapeData;
        Path path = this.tempPath;
        path.reset();
        PointF pointF9 = shapeData4.initialPoint;
        path.moveTo(pointF9.x, pointF9.y);
        MiscUtils.pathFromDataCurrentPoint.set(pointF9.x, pointF9.y);
        for (int i = 0; i < shapeData4.curves.size(); i++) {
            CubicCurveData cubicCurveData3 = shapeData4.curves.get(i);
            PointF pointF10 = cubicCurveData3.controlPoint1;
            PointF pointF11 = cubicCurveData3.controlPoint2;
            PointF pointF12 = cubicCurveData3.vertex;
            if (!pointF10.equals(MiscUtils.pathFromDataCurrentPoint) || !pointF11.equals(pointF12)) {
                path.cubicTo(pointF10.x, pointF10.y, pointF11.x, pointF11.y, pointF12.x, pointF12.y);
            } else {
                path.lineTo(pointF12.x, pointF12.y);
            }
            MiscUtils.pathFromDataCurrentPoint.set(pointF12.x, pointF12.y);
        }
        if (shapeData4.closed) {
            path.close();
        }
        return this.tempPath;
    }
}
