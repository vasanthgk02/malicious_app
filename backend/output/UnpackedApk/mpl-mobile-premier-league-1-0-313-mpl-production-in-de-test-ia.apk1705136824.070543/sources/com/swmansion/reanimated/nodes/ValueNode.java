package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.swmansion.reanimated.NodesManager;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class ValueNode extends Node {
    public Object mValue;

    public ValueNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        if (readableMap == null || !readableMap.hasKey(HSLCriteriaBuilder.VALUE)) {
            this.mValue = null;
            return;
        }
        ReadableType type = readableMap.getType(HSLCriteriaBuilder.VALUE);
        if (type == ReadableType.String) {
            this.mValue = readableMap.getString(HSLCriteriaBuilder.VALUE);
        } else if (type == ReadableType.Number) {
            this.mValue = Double.valueOf(readableMap.getDouble(HSLCriteriaBuilder.VALUE));
        } else if (type == ReadableType.Null) {
            this.mValue = null;
        } else {
            throw new IllegalStateException("Not supported value type. Must be boolean, number or string");
        }
    }

    public Object evaluate() {
        return this.mValue;
    }

    public void setValue(Object obj) {
        this.mValue = obj;
        forceUpdateMemoizedValue(obj);
    }
}
