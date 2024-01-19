package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.UpdateContext;
import java.util.Stack;

public class ParamNode extends ValueNode {
    public final Stack<Integer> mArgsStack = new Stack<>();
    public String mPrevCallID;

    public ParamNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
    }

    public Object evaluate() {
        UpdateContext updateContext = this.mUpdateContext;
        String str = updateContext.callID;
        updateContext.callID = this.mPrevCallID;
        Object value = this.mNodesManager.findNodeById(this.mArgsStack.peek().intValue(), Node.class).value();
        this.mUpdateContext.callID = str;
        return value;
    }

    public boolean isRunning() {
        Node findNodeById = this.mNodesManager.findNodeById(this.mArgsStack.peek().intValue(), Node.class);
        if (findNodeById instanceof ParamNode) {
            return ((ParamNode) findNodeById).isRunning();
        }
        return ((ClockNode) findNodeById).isRunning;
    }

    public void setValue(Object obj) {
        Node findNodeById = this.mNodesManager.findNodeById(this.mArgsStack.peek().intValue(), Node.class);
        UpdateContext updateContext = this.mUpdateContext;
        String str = updateContext.callID;
        updateContext.callID = this.mPrevCallID;
        ((ValueNode) findNodeById).setValue(obj);
        this.mUpdateContext.callID = str;
    }

    public void start() {
        Node findNodeById = this.mNodesManager.findNodeById(this.mArgsStack.peek().intValue(), Node.class);
        if (findNodeById instanceof ParamNode) {
            ((ParamNode) findNodeById).start();
            return;
        }
        ClockNode clockNode = (ClockNode) findNodeById;
        if (!clockNode.isRunning) {
            clockNode.isRunning = true;
            NodesManager nodesManager = clockNode.mNodesManager;
            nodesManager.mFrameCallbacks.add(clockNode);
            nodesManager.startUpdatingOnAnimationFrame();
        }
    }

    public void stop() {
        Node findNodeById = this.mNodesManager.findNodeById(this.mArgsStack.peek().intValue(), Node.class);
        if (findNodeById instanceof ParamNode) {
            ((ParamNode) findNodeById).stop();
        } else {
            ((ClockNode) findNodeById).isRunning = false;
        }
    }
}
