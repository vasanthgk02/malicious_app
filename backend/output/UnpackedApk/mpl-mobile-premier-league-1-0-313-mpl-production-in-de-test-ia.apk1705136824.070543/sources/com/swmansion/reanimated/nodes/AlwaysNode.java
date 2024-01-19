package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;

public class AlwaysNode extends Node implements FinalNode {
    public int mNodeToBeEvaluated;

    public AlwaysNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mNodeToBeEvaluated = TextAppearanceConfig.getInt(readableMap, "what", "Reanimated: Argument passed to always node is either of wrong type or is missing.");
    }

    public Object evaluate() {
        this.mNodesManager.findNodeById(this.mNodeToBeEvaluated, Node.class).value();
        return Node.ZERO;
    }

    public void update() {
        value();
    }
}
