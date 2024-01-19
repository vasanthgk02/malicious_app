package com.swmansion.reanimated.nodes;

import android.graphics.PointF;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;

public class BezierNode extends Node {
    public final int mInputID;
    public final CubicBezierInterpolator mInterpolator;

    public static class CubicBezierInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public PointF f1835a = new PointF();

        /* renamed from: b  reason: collision with root package name */
        public PointF f1836b = new PointF();

        /* renamed from: c  reason: collision with root package name */
        public PointF f1837c = new PointF();
        public PointF end;
        public PointF start;

        public CubicBezierInterpolator(float f2, float f3, float f4, float f5) {
            PointF pointF = new PointF(f2, f3);
            PointF pointF2 = new PointF(f4, f5);
            this.start = pointF;
            this.end = pointF2;
        }
    }

    public BezierNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputID = TextAppearanceConfig.getInt(readableMap, "input", "Reanimated: Argument passed to bezier node is either of wrong type or is missing.");
        this.mInterpolator = new CubicBezierInterpolator((float) readableMap.getDouble("mX1"), (float) readableMap.getDouble("mY1"), (float) readableMap.getDouble("mX2"), (float) readableMap.getDouble("mY2"));
    }

    public Object evaluate() {
        CubicBezierInterpolator cubicBezierInterpolator = this.mInterpolator;
        float floatValue = ((Double) this.mNodesManager.getNodeValue(this.mInputID)).floatValue();
        float f2 = floatValue;
        for (int i = 1; i < 14; i++) {
            PointF pointF = cubicBezierInterpolator.f1837c;
            PointF pointF2 = cubicBezierInterpolator.start;
            float f3 = pointF2.x * 3.0f;
            pointF.x = f3;
            PointF pointF3 = cubicBezierInterpolator.f1836b;
            float f4 = ((cubicBezierInterpolator.end.x - pointF2.x) * 3.0f) - f3;
            pointF3.x = f4;
            PointF pointF4 = cubicBezierInterpolator.f1835a;
            float f5 = (1.0f - pointF.x) - f4;
            pointF4.x = f5;
            float f6 = (((((f5 * f2) + pointF3.x) * f2) + pointF.x) * f2) - floatValue;
            if (((double) Math.abs(f6)) < 0.001d) {
                break;
            }
            f2 -= f6 / (((((cubicBezierInterpolator.f1835a.x * 3.0f) * f2) + (cubicBezierInterpolator.f1836b.x * 2.0f)) * f2) + cubicBezierInterpolator.f1837c.x);
        }
        PointF pointF5 = cubicBezierInterpolator.f1837c;
        PointF pointF6 = cubicBezierInterpolator.start;
        float f7 = pointF6.y * 3.0f;
        pointF5.y = f7;
        PointF pointF7 = cubicBezierInterpolator.f1836b;
        float f8 = ((cubicBezierInterpolator.end.y - pointF6.y) * 3.0f) - f7;
        pointF7.y = f8;
        PointF pointF8 = cubicBezierInterpolator.f1835a;
        float f9 = (1.0f - pointF5.y) - f8;
        pointF8.y = f9;
        return Double.valueOf((double) (((((f9 * f2) + pointF7.y) * f2) + pointF5.y) * f2));
    }
}
