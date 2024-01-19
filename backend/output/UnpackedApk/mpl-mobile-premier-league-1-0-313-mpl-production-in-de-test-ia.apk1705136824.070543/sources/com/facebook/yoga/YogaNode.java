package com.facebook.yoga;

public abstract class YogaNode {
    public abstract YogaDirection getLayoutDirection();

    public abstract YogaNode removeChildAt(int i);

    public abstract void setPadding(YogaEdge yogaEdge, float f2);
}
