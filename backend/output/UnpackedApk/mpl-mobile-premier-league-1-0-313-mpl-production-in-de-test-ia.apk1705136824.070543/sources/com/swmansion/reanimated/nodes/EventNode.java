package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.reanimated.NodesManager;
import java.util.ArrayList;
import java.util.List;

public class EventNode extends Node implements RCTEventEmitter {
    public final List<EventMap> mMapping;

    public static class EventMap {
        public final int nodeID;
        public final String[] path;

        public EventMap(ReadableArray readableArray) {
            int size = readableArray.size() - 1;
            this.path = new String[size];
            for (int i = 0; i < size; i++) {
                this.path[i] = readableArray.getString(i);
            }
            this.nodeID = readableArray.getInt(size);
        }
    }

    public EventNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mMapping = processMapping(readableMap.getArray("argMapping"));
    }

    public static List<EventMap> processMapping(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new EventMap(readableArray.getArray(i)));
        }
        return arrayList;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.facebook.react.bridge.WritableMap, code=com.facebook.react.bridge.ReadableMap, for r9v0, types: [com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.WritableMap] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveEvent(int r7, java.lang.String r8, com.facebook.react.bridge.ReadableMap r9) {
        /*
            r6 = this;
            if (r9 == 0) goto L_0x0060
            r7 = 0
            r8 = 0
        L_0x0004:
            java.util.List<com.swmansion.reanimated.nodes.EventNode$EventMap> r0 = r6.mMapping
            int r0 = r0.size()
            if (r8 >= r0) goto L_0x005f
            java.util.List<com.swmansion.reanimated.nodes.EventNode$EventMap> r0 = r6.mMapping
            java.lang.Object r0 = r0.get(r8)
            com.swmansion.reanimated.nodes.EventNode$EventMap r0 = (com.swmansion.reanimated.nodes.EventNode.EventMap) r0
            r1 = 0
            if (r0 == 0) goto L_0x005e
            r2 = r9
            r3 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x0033
            java.lang.String[] r4 = r0.path
            int r5 = r4.length
            int r5 = r5 + -1
            if (r3 >= r5) goto L_0x0033
            r4 = r4[r3]
            boolean r5 = r2.hasKey(r4)
            if (r5 == 0) goto L_0x002f
            com.facebook.react.bridge.ReadableMap r2 = r2.getMap(r4)
            goto L_0x0030
        L_0x002f:
            r2 = r1
        L_0x0030:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x0033:
            if (r2 == 0) goto L_0x004a
            java.lang.String[] r3 = r0.path
            int r4 = r3.length
            int r4 = r4 + -1
            r3 = r3[r4]
            boolean r4 = r2.hasKey(r3)
            if (r4 == 0) goto L_0x004a
            double r1 = r2.getDouble(r3)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
        L_0x004a:
            if (r1 == 0) goto L_0x005b
            com.swmansion.reanimated.NodesManager r2 = r6.mNodesManager
            int r0 = r0.nodeID
            java.lang.Class<com.swmansion.reanimated.nodes.ValueNode> r3 = com.swmansion.reanimated.nodes.ValueNode.class
            com.swmansion.reanimated.nodes.Node r0 = r2.findNodeById(r0, r3)
            com.swmansion.reanimated.nodes.ValueNode r0 = (com.swmansion.reanimated.nodes.ValueNode) r0
            r0.setValue(r1)
        L_0x005b:
            int r8 = r8 + 1
            goto L_0x0004
        L_0x005e:
            throw r1
        L_0x005f:
            return
        L_0x0060:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Animated events must have event data."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.nodes.EventNode.receiveEvent(int, java.lang.String, com.facebook.react.bridge.WritableMap):void");
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by animated events");
    }

    public Double evaluate() {
        return Node.ZERO;
    }
}
