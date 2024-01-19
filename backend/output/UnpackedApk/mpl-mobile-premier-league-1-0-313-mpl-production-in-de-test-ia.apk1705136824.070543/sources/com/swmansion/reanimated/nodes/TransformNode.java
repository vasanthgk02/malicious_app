package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.swmansion.reanimated.NodesManager;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class TransformNode extends Node {
    public List<TransformConfig> mTransforms;

    public static class AnimatedTransformConfig extends TransformConfig {
        public int nodeID;

        public AnimatedTransformConfig(AnonymousClass1 r1) {
            super(null);
        }

        public Object getValue(NodesManager nodesManager) {
            return nodesManager.getNodeValue(this.nodeID);
        }
    }

    public static class StaticTransformConfig extends TransformConfig {
        public Object value;

        public StaticTransformConfig(AnonymousClass1 r1) {
            super(null);
        }

        public Object getValue(NodesManager nodesManager) {
            return this.value;
        }
    }

    public static abstract class TransformConfig {
        public String propertyName;

        public TransformConfig() {
        }

        public abstract Object getValue(NodesManager nodesManager);

        public TransformConfig(AnonymousClass1 r1) {
        }
    }

    public TransformNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        Object obj;
        super(i, readableMap, nodesManager);
        ReadableArray array = readableMap.getArray("transform");
        ArrayList arrayList = new ArrayList(array.size());
        for (int i2 = 0; i2 < array.size(); i2++) {
            ReadableMap map = array.getMap(i2);
            String string = map.getString("property");
            if (map.hasKey("nodeID")) {
                AnimatedTransformConfig animatedTransformConfig = new AnimatedTransformConfig(null);
                animatedTransformConfig.propertyName = string;
                animatedTransformConfig.nodeID = map.getInt("nodeID");
                arrayList.add(animatedTransformConfig);
            } else {
                StaticTransformConfig staticTransformConfig = new StaticTransformConfig(null);
                staticTransformConfig.propertyName = string;
                if (map.getType(HSLCriteriaBuilder.VALUE) == ReadableType.String) {
                    obj = map.getString(HSLCriteriaBuilder.VALUE);
                } else {
                    obj = Double.valueOf(map.getDouble(HSLCriteriaBuilder.VALUE));
                }
                staticTransformConfig.value = obj;
                arrayList.add(staticTransformConfig);
            }
        }
        this.mTransforms = arrayList;
    }

    public Object evaluate() {
        ArrayList arrayList = new ArrayList(this.mTransforms.size());
        for (TransformConfig next : this.mTransforms) {
            arrayList.add(JavaOnlyMap.of(next.propertyName, next.getValue(this.mNodesManager)));
        }
        return JavaOnlyArray.from(arrayList);
    }
}
