package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;

public class CondNode extends Node {
    public final int mCondID;
    public final int mElseBlockID;
    public final int mIfBlockID;

    public CondNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mCondID = TextAppearanceConfig.getInt(readableMap, "cond", "Reanimated: First argument passed to cond node is either of wrong type or is missing.");
        this.mIfBlockID = TextAppearanceConfig.getInt(readableMap, "ifBlock", "Reanimated: Second argument passed to cond node is either of wrong type or is missing.");
        this.mElseBlockID = readableMap.hasKey("elseBlock") ? TextAppearanceConfig.getInt(readableMap, "elseBlock", "Reanimated: Second argument passed to cond node is either of wrong type or is missing.") : -1;
    }

    public Object evaluate() {
        Object nodeValue = this.mNodesManager.getNodeValue(this.mCondID);
        if (!(nodeValue instanceof Number) || ((Number) nodeValue).doubleValue() == 0.0d) {
            int i = this.mElseBlockID;
            return i != -1 ? this.mNodesManager.getNodeValue(i) : Node.ZERO;
        }
        int i2 = this.mIfBlockID;
        return i2 != -1 ? this.mNodesManager.getNodeValue(i2) : Node.ZERO;
    }
}
