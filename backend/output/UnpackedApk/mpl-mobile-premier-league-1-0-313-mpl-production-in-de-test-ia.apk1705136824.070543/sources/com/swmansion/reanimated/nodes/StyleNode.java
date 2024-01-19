package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;
import java.util.Map;
import java.util.Map.Entry;

public class StyleNode extends Node {
    public final Map<String, Integer> mMapping;

    public StyleNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mMapping = TextAppearanceConfig.processMapping(readableMap.getMap("style"));
    }

    public Object evaluate() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        for (Entry next : this.mMapping.entrySet()) {
            Node findNodeById = this.mNodesManager.findNodeById(((Integer) next.getValue()).intValue(), Node.class);
            if (findNodeById instanceof TransformNode) {
                javaOnlyMap.putArray((String) next.getKey(), (WritableArray) findNodeById.value());
            } else {
                Object value = findNodeById.value();
                if (value instanceof Double) {
                    javaOnlyMap.putDouble((String) next.getKey(), ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    javaOnlyMap.putString((String) next.getKey(), (String) value);
                } else {
                    throw new IllegalStateException("Wrong style form");
                }
            }
        }
        return javaOnlyMap;
    }
}
