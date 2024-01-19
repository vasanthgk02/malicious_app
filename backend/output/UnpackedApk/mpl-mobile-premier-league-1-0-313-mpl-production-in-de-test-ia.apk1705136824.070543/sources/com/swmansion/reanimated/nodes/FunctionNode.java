package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;

public class FunctionNode extends Node {
    public final int mWhatNodeID;

    public FunctionNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mWhatNodeID = readableMap.getInt("what");
    }

    public Object evaluate() {
        return this.mNodesManager.findNodeById(this.mWhatNodeID, Node.class).value();
    }
}