package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.common.SingleThreadAsserter;

public class ShadowNodeRegistry {
    public final SparseBooleanArray mRootTags = new SparseBooleanArray();
    public final SparseArray<ReactShadowNode> mTagsToCSSNodes = new SparseArray<>();
    public final SingleThreadAsserter mThreadAsserter = new SingleThreadAsserter();

    public ReactShadowNode getNode(int i) {
        this.mThreadAsserter.assertNow();
        return this.mTagsToCSSNodes.get(i);
    }

    public boolean isRootNode(int i) {
        this.mThreadAsserter.assertNow();
        return this.mRootTags.get(i);
    }

    public void removeRootNode(int i) {
        this.mThreadAsserter.assertNow();
        if (i != -1) {
            if (this.mRootTags.get(i)) {
                this.mTagsToCSSNodes.remove(i);
                this.mRootTags.delete(i);
                return;
            }
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline42("View with tag ", i, " is not registered as a root view"));
        }
    }
}
