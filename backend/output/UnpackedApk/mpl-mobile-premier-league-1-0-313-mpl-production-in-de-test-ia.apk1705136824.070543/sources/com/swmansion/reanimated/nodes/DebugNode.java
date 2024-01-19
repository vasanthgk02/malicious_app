package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class DebugNode extends Node {
    public final String mMessage;
    public final int mValueID;

    public DebugNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        try {
            this.mMessage = readableMap.getString("message");
            this.mValueID = TextAppearanceConfig.getInt(readableMap, HSLCriteriaBuilder.VALUE, "Reanimated: Second argument passed to debug node is either of wrong type or is missing.");
        } catch (NoSuchKeyException unused) {
            throw new JSApplicationCausedNativeException("Reanimated: First argument passed to debug node is either of wrong type or is missing.");
        }
    }

    public Object evaluate() {
        Object value = this.mNodesManager.findNodeById(this.mValueID, Node.class).value();
        String.format("%s %s", new Object[]{this.mMessage, value});
        return value;
    }
}
