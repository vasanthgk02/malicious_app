package com.facebook.react.animated;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

public abstract class AnimationDriver {
    public ValueAnimatedNode mAnimatedValue;
    public Callback mEndCallback;
    public boolean mHasFinished = false;
    public int mId;

    public void resetConfig(ReadableMap readableMap) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Animation config for ");
        outline73.append(getClass().getSimpleName());
        outline73.append(" cannot be reset");
        throw new JSApplicationCausedNativeException(outline73.toString());
    }

    public abstract void runAnimationStep(long j);
}
