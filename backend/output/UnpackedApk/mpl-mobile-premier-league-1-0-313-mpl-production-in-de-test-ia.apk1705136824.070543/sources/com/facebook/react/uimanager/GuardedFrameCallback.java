package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;

public abstract class GuardedFrameCallback extends FrameCallback {
    public final ReactContext mReactContext;

    public GuardedFrameCallback(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    public final void doFrame(long j) {
        try {
            doFrameGuarded(j);
        } catch (RuntimeException e2) {
            this.mReactContext.handleException(e2);
        }
    }

    public abstract void doFrameGuarded(long j);
}
