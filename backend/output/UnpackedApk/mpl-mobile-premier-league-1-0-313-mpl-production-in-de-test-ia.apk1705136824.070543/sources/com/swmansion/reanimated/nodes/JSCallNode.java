package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;

public class JSCallNode extends Node {
    public final int[] mInputIDs;

    public JSCallNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = TextAppearanceConfig.processIntArray(readableMap.getArray("input"));
    }

    public Object evaluate() {
        WritableArray createArray = Arguments.createArray();
        int i = 0;
        while (true) {
            int[] iArr = this.mInputIDs;
            if (i < iArr.length) {
                Node findNodeById = this.mNodesManager.findNodeById(iArr[i], Node.class);
                if (findNodeById.value() == null) {
                    createArray.pushNull();
                } else {
                    Object value = findNodeById.value();
                    if (value instanceof String) {
                        createArray.pushString((String) value);
                    } else {
                        createArray.pushDouble(findNodeById.doubleValue().doubleValue());
                    }
                }
                i++;
            } else {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", this.mNodeID);
                createMap.putArray("args", createArray);
                this.mNodesManager.mEventEmitter.emit("onReanimatedCall", createMap);
                return Node.ZERO;
            }
        }
    }
}
