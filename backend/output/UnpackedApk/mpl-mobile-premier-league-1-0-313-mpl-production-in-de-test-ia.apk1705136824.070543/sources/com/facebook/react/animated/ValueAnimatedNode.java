package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class ValueAnimatedNode extends AnimatedNode {
    public Object mAnimatedObject = null;
    public double mOffset = 0.0d;
    public double mValue = Double.NaN;
    public AnimatedNodeValueListener mValueListener;

    public ValueAnimatedNode() {
    }

    public double getValue() {
        if (Double.isNaN(this.mOffset + this.mValue)) {
            update();
        }
        return this.mOffset + this.mValue;
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.mValue = readableMap.getDouble(HSLCriteriaBuilder.VALUE);
        this.mOffset = readableMap.getDouble("offset");
    }
}
