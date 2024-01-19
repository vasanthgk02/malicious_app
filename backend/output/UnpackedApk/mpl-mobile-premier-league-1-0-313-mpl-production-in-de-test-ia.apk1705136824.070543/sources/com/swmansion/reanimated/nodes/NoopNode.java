package com.swmansion.reanimated.nodes;

import com.swmansion.reanimated.NodesManager;

public class NoopNode extends ValueNode {
    public NoopNode(NodesManager nodesManager) {
        super(-2, null, nodesManager);
    }

    public void addChild(Node node) {
    }

    public void markUpdated() {
    }

    public void removeChild(Node node) {
    }

    public void setValue(Object obj) {
    }
}
