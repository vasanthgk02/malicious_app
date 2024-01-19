package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.NodesManager.OnAnimationFrame;

public class ClockNode extends Node implements OnAnimationFrame {
    public boolean isRunning;

    public ClockNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
    }

    public Object evaluate() {
        return Double.valueOf(this.mNodesManager.currentFrameTimeMs);
    }

    public void onAnimationFrame() {
        if (this.isRunning) {
            markUpdated();
            NodesManager nodesManager = this.mNodesManager;
            nodesManager.mFrameCallbacks.add(this);
            nodesManager.startUpdatingOnAnimationFrame();
        }
    }
}
