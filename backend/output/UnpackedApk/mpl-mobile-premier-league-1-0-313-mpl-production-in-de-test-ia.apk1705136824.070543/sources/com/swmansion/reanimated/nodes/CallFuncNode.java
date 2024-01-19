package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.UpdateContext;

public class CallFuncNode extends Node {
    public final int[] mArgs;
    public final int[] mParams;
    public String mPreviousCallID;
    public final int mWhatNodeID;

    public CallFuncNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mWhatNodeID = readableMap.getInt("what");
        this.mParams = TextAppearanceConfig.processIntArray(readableMap.getArray(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY));
        this.mArgs = TextAppearanceConfig.processIntArray(readableMap.getArray("args"));
    }

    public Object evaluate() {
        Class cls = ParamNode.class;
        UpdateContext updateContext = this.mNodesManager.updateContext;
        this.mPreviousCallID = updateContext.callID;
        updateContext.callID = this.mNodesManager.updateContext.callID + '/' + String.valueOf(this.mNodeID);
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.mParams;
            if (i2 >= iArr.length) {
                break;
            }
            ParamNode paramNode = (ParamNode) this.mNodesManager.findNodeById(iArr[i2], cls);
            Integer valueOf = Integer.valueOf(this.mArgs[i2]);
            paramNode.mPrevCallID = this.mPreviousCallID;
            paramNode.mArgsStack.push(valueOf);
            i2++;
        }
        Object value = this.mNodesManager.findNodeById(this.mWhatNodeID, Node.class).value();
        while (true) {
            int[] iArr2 = this.mParams;
            if (i < iArr2.length) {
                ((ParamNode) this.mNodesManager.findNodeById(iArr2[i], cls)).mArgsStack.pop();
                i++;
            } else {
                this.mNodesManager.updateContext.callID = this.mPreviousCallID;
                return value;
            }
        }
    }
}
