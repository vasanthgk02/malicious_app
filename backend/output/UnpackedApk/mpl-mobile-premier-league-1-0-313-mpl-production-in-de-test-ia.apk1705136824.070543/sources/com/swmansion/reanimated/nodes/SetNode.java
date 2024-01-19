package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class SetNode extends Node {
    public int mValueNodeID;
    public int mWhatNodeID;

    public SetNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mWhatNodeID = TextAppearanceConfig.getInt(readableMap, "what", "Reanimated: First argument passed to set node is either of wrong type or is missing.");
        this.mValueNodeID = TextAppearanceConfig.getInt(readableMap, HSLCriteriaBuilder.VALUE, "Reanimated: Second argument passed to set node is either of wrong type or is missing.");
    }

    public Object evaluate() {
        Object nodeValue = this.mNodesManager.getNodeValue(this.mValueNodeID);
        ((ValueNode) this.mNodesManager.findNodeById(this.mWhatNodeID, ValueNode.class)).setValue(nodeValue);
        return nodeValue;
    }
}
