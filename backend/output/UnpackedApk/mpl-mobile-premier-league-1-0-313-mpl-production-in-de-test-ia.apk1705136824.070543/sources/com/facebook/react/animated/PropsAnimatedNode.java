package com.facebook.react.animated;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.animated.TransformAnimatedNode.AnimatedTransformConfig;
import com.facebook.react.animated.TransformAnimatedNode.StaticTransformConfig;
import com.facebook.react.animated.TransformAnimatedNode.TransformConfig;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PropsAnimatedNode extends AnimatedNode {
    public int mConnectedViewTag = -1;
    public final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    public final JavaOnlyMap mPropMap;
    public final Map<String, Integer> mPropNodeMapping;
    public final UIManager mUIManager;

    public PropsAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager, UIManager uIManager) {
        ReadableMap map = readableMap.getMap("props");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        this.mPropNodeMapping = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.mPropNodeMapping.put(nextKey, Integer.valueOf(map.getInt(nextKey)));
        }
        this.mPropMap = new JavaOnlyMap();
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.mUIManager = uIManager;
    }

    public final void updateView() {
        double d2;
        if (this.mConnectedViewTag != -1) {
            for (Entry next : this.mPropNodeMapping.entrySet()) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(((Integer) next.getValue()).intValue());
                if (nodeById == null) {
                    throw new IllegalArgumentException("Mapped property node does not exists");
                } else if (nodeById instanceof StyleAnimatedNode) {
                    StyleAnimatedNode styleAnimatedNode = (StyleAnimatedNode) nodeById;
                    JavaOnlyMap javaOnlyMap = this.mPropMap;
                    for (Entry next2 : styleAnimatedNode.mPropMapping.entrySet()) {
                        AnimatedNode nodeById2 = styleAnimatedNode.mNativeAnimatedNodesManager.getNodeById(((Integer) next2.getValue()).intValue());
                        if (nodeById2 == null) {
                            throw new IllegalArgumentException("Mapped style node does not exists");
                        } else if (nodeById2 instanceof TransformAnimatedNode) {
                            TransformAnimatedNode transformAnimatedNode = (TransformAnimatedNode) nodeById2;
                            ArrayList arrayList = new ArrayList(transformAnimatedNode.mTransformConfigs.size());
                            for (TransformConfig next3 : transformAnimatedNode.mTransformConfigs) {
                                if (next3 instanceof AnimatedTransformConfig) {
                                    AnimatedNode nodeById3 = transformAnimatedNode.mNativeAnimatedNodesManager.getNodeById(((AnimatedTransformConfig) next3).mNodeTag);
                                    if (nodeById3 == null) {
                                        throw new IllegalArgumentException("Mapped style node does not exists");
                                    } else if (nodeById3 instanceof ValueAnimatedNode) {
                                        d2 = ((ValueAnimatedNode) nodeById3).getValue();
                                    } else {
                                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unsupported type of node used as a transform child node ");
                                        outline73.append(nodeById3.getClass());
                                        throw new IllegalArgumentException(outline73.toString());
                                    }
                                } else {
                                    d2 = ((StaticTransformConfig) next3).mValue;
                                }
                                arrayList.add(JavaOnlyMap.of(next3.mProperty, Double.valueOf(d2)));
                            }
                            javaOnlyMap.putArray("transform", JavaOnlyArray.from(arrayList));
                        } else if (nodeById2 instanceof ValueAnimatedNode) {
                            javaOnlyMap.putDouble((String) next2.getKey(), ((ValueAnimatedNode) nodeById2).getValue());
                        } else {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Unsupported type of node used in property node ");
                            outline732.append(nodeById2.getClass());
                            throw new IllegalArgumentException(outline732.toString());
                        }
                    }
                    continue;
                } else if (nodeById instanceof ValueAnimatedNode) {
                    ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nodeById;
                    Object obj = valueAnimatedNode.mAnimatedObject;
                    if (obj instanceof String) {
                        this.mPropMap.putString((String) next.getKey(), (String) obj);
                    } else {
                        this.mPropMap.putDouble((String) next.getKey(), valueAnimatedNode.getValue());
                    }
                } else {
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("Unsupported type of node used in property node ");
                    outline733.append(nodeById.getClass());
                    throw new IllegalArgumentException(outline733.toString());
                }
            }
            this.mUIManager.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mPropMap);
        }
    }
}
