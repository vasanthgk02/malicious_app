package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import com.google.android.material.resources.TextAppearanceConfig;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.NodesManager.NativeUpdateOperation;
import java.util.Map;
import java.util.Map.Entry;

public class PropsNode extends Node implements FinalNode {
    public int mConnectedViewTag = -1;
    public final ReactStylesDiffMap mDiffMap;
    public final Map<String, Integer> mMapping;
    public final JavaOnlyMap mPropMap;
    public final UIImplementation mUIImplementation;

    public PropsNode(int i, ReadableMap readableMap, NodesManager nodesManager, UIImplementation uIImplementation) {
        super(i, readableMap, nodesManager);
        this.mMapping = TextAppearanceConfig.processMapping(readableMap.getMap("props"));
        this.mUIImplementation = uIImplementation;
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        this.mPropMap = javaOnlyMap;
        this.mDiffMap = new ReactStylesDiffMap(javaOnlyMap);
    }

    public static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof WritableArray) {
            writableMap.putArray(str, (WritableArray) obj);
        } else if (obj instanceof WritableMap) {
            writableMap.putMap(str, (WritableMap) obj);
        } else {
            throw new IllegalStateException("Unknown type of animated value");
        }
    }

    public Object evaluate() {
        boolean z;
        boolean z2;
        boolean z3;
        WritableMap writableMap;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (Entry next : this.mMapping.entrySet()) {
            Node findNodeById = this.mNodesManager.findNodeById(((Integer) next.getValue()).intValue(), Node.class);
            if (findNodeById instanceof StyleNode) {
                WritableMap writableMap2 = (WritableMap) findNodeById.value();
                ReadableMapKeySetIterator keySetIterator = writableMap2.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    if (this.mNodesManager.uiProps.contains(nextKey)) {
                        writableMap = this.mPropMap;
                        z = z6;
                        z2 = z5;
                        z3 = true;
                    } else if (this.mNodesManager.nativeProps.contains(nextKey)) {
                        z3 = z4;
                        z = z6;
                        z2 = true;
                        writableMap = createMap2;
                    } else {
                        z2 = z5;
                        z = true;
                        z3 = z4;
                        writableMap = createMap;
                    }
                    ReadableType type = writableMap2.getType(nextKey);
                    int ordinal = type.ordinal();
                    if (ordinal == 2) {
                        writableMap.putDouble(nextKey, writableMap2.getDouble(nextKey));
                    } else if (ordinal == 3) {
                        writableMap.putString(nextKey, writableMap2.getString(nextKey));
                    } else if (ordinal == 5) {
                        writableMap.putArray(nextKey, (WritableArray) writableMap2.getArray(nextKey));
                    } else {
                        throw new IllegalArgumentException("Unexpected type " + type);
                    }
                    z4 = z3;
                    z5 = z2;
                    z6 = z;
                }
                continue;
            } else {
                String str = (String) next.getKey();
                Object value = findNodeById.value();
                if (this.mNodesManager.uiProps.contains(str)) {
                    addProp(this.mPropMap, str, value);
                    z4 = true;
                } else {
                    addProp(createMap2, str, value);
                    z5 = true;
                }
            }
        }
        int i = this.mConnectedViewTag;
        if (i != -1) {
            if (z4) {
                UIImplementation uIImplementation = this.mUIImplementation;
                ReactStylesDiffMap reactStylesDiffMap = this.mDiffMap;
                if (uIImplementation != null) {
                    UiThreadUtil.assertOnUiThread();
                    uIImplementation.mOperationsQueue.mNativeViewHierarchyManager.updateProperties(i, reactStylesDiffMap);
                } else {
                    throw null;
                }
            }
            if (z5) {
                NodesManager nodesManager = this.mNodesManager;
                nodesManager.mOperationsInBatch.add(new NativeUpdateOperation(nodesManager, this.mConnectedViewTag, createMap2));
            }
            if (z6) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putInt("viewTag", this.mConnectedViewTag);
                createMap3.putMap("props", createMap);
                this.mNodesManager.mEventEmitter.emit("onReanimatedPropsChange", createMap3);
            }
        }
        return Node.ZERO;
    }

    public void update() {
        if (this.mConnectedViewTag != -1) {
            value();
        }
    }
}
