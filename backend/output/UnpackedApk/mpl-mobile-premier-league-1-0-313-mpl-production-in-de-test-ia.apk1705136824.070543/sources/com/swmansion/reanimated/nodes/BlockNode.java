package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;

public class BlockNode extends Node {
    public final int[] mBlock;

    public BlockNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mBlock = TextAppearanceConfig.processIntArray(readableMap.getArray("block"));
    }

    public Object evaluate() {
        Object obj = null;
        int i = 0;
        while (true) {
            int[] iArr = this.mBlock;
            if (i >= iArr.length) {
                return obj;
            }
            obj = this.mNodesManager.findNodeById(iArr[i], Node.class).value();
            i++;
        }
    }
}
