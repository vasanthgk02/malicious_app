package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

public abstract class ClockOpNode extends Node {
    public int clockID;

    public static class ClockStartNode extends ClockOpNode {
        public ClockStartNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        public Double eval(Node node) {
            if (node instanceof ParamNode) {
                ((ParamNode) node).start();
            } else {
                ClockNode clockNode = (ClockNode) node;
                if (!clockNode.isRunning) {
                    clockNode.isRunning = true;
                    NodesManager nodesManager = clockNode.mNodesManager;
                    nodesManager.mFrameCallbacks.add(clockNode);
                    nodesManager.startUpdatingOnAnimationFrame();
                }
            }
            return Node.ZERO;
        }

        public /* bridge */ /* synthetic */ Object evaluate() {
            return ClockOpNode.super.evaluate();
        }
    }

    public static class ClockStopNode extends ClockOpNode {
        public ClockStopNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        public Double eval(Node node) {
            if (node instanceof ParamNode) {
                ((ParamNode) node).stop();
            } else {
                ((ClockNode) node).isRunning = false;
            }
            return Node.ZERO;
        }

        public /* bridge */ /* synthetic */ Object evaluate() {
            return ClockOpNode.super.evaluate();
        }
    }

    public static class ClockTestNode extends ClockOpNode {
        public ClockTestNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        public Double eval(Node node) {
            double d2 = 1.0d;
            if (node instanceof ParamNode) {
                if (!((ParamNode) node).isRunning()) {
                    d2 = 0.0d;
                }
                return Double.valueOf(d2);
            }
            if (!((ClockNode) node).isRunning) {
                d2 = 0.0d;
            }
            return Double.valueOf(d2);
        }

        public /* bridge */ /* synthetic */ Object evaluate() {
            return ClockOpNode.super.evaluate();
        }
    }

    public ClockOpNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.clockID = TextAppearanceConfig.getInt(readableMap, Values.CLOCK, "Reanimated: Argument passed to clock node is either of wrong type or is missing.");
    }

    public abstract Double eval(Node node);

    public Double evaluate() {
        return eval(this.mNodesManager.findNodeById(this.clockID, Node.class));
    }
}
