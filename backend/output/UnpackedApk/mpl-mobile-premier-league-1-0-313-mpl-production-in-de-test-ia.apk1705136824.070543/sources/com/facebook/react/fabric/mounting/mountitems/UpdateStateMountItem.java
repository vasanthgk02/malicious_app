package com.facebook.react.fabric.mounting.mountitems;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.StateWrapper;
import org.apache.fontbox.cmap.CMapParser;

public class UpdateStateMountItem implements MountItem {
    public final int mReactTag;
    public final StateWrapper mStateWrapper;

    public UpdateStateMountItem(int i, StateWrapper stateWrapper) {
        this.mReactTag = i;
        this.mStateWrapper = stateWrapper;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline57(new StringBuilder("UpdateStateMountItem ["), this.mReactTag, CMapParser.MARK_END_OF_ARRAY);
    }
}
