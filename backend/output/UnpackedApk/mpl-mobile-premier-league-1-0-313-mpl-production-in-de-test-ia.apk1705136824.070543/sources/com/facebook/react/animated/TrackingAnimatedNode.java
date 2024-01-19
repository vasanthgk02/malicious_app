package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class TrackingAnimatedNode extends AnimatedNode {
    public final JavaOnlyMap mAnimationConfig;
    public final int mAnimationId;
    public final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    public final int mToValueNode;
    public final int mValueNode;

    public TrackingAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.mAnimationId = readableMap.getInt("animationId");
        this.mToValueNode = readableMap.getInt("toValue");
        this.mValueNode = readableMap.getInt(HSLCriteriaBuilder.VALUE);
        this.mAnimationConfig = JavaOnlyMap.deepClone(readableMap.getMap("animationConfig"));
    }

    public void update() {
        this.mAnimationConfig.putDouble("toValue", ((ValueAnimatedNode) this.mNativeAnimatedNodesManager.getNodeById(this.mToValueNode)).getValue());
        this.mNativeAnimatedNodesManager.startAnimatingNode(this.mAnimationId, this.mValueNode, this.mAnimationConfig, null);
    }
}
