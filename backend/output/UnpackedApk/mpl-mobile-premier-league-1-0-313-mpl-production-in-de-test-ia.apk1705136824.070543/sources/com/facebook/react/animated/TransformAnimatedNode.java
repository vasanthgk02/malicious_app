package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class TransformAnimatedNode extends AnimatedNode {
    public final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    public final List<TransformConfig> mTransformConfigs;

    public class AnimatedTransformConfig extends TransformConfig {
        public int mNodeTag;

        public AnimatedTransformConfig(TransformAnimatedNode transformAnimatedNode, AnonymousClass1 r2) {
            super(transformAnimatedNode, null);
        }
    }

    public class StaticTransformConfig extends TransformConfig {
        public double mValue;

        public StaticTransformConfig(TransformAnimatedNode transformAnimatedNode, AnonymousClass1 r2) {
            super(transformAnimatedNode, null);
        }
    }

    public class TransformConfig {
        public String mProperty;

        public TransformConfig(TransformAnimatedNode transformAnimatedNode, AnonymousClass1 r2) {
        }
    }

    public TransformAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        ReadableArray array = readableMap.getArray("transforms");
        this.mTransformConfigs = new ArrayList(array.size());
        for (int i = 0; i < array.size(); i++) {
            ReadableMap map = array.getMap(i);
            String string = map.getString("property");
            if (map.getString("type").equals("animated")) {
                AnimatedTransformConfig animatedTransformConfig = new AnimatedTransformConfig(this, null);
                animatedTransformConfig.mProperty = string;
                animatedTransformConfig.mNodeTag = map.getInt("nodeTag");
                this.mTransformConfigs.add(animatedTransformConfig);
            } else {
                StaticTransformConfig staticTransformConfig = new StaticTransformConfig(this, null);
                staticTransformConfig.mProperty = string;
                staticTransformConfig.mValue = map.getDouble(HSLCriteriaBuilder.VALUE);
                this.mTransformConfigs.add(staticTransformConfig);
            }
        }
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
    }
}
