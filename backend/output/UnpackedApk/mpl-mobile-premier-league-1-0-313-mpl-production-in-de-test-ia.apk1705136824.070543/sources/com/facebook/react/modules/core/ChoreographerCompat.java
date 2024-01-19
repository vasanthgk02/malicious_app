package com.facebook.react.modules.core;

import android.view.Choreographer;

public class ChoreographerCompat {
    public static ChoreographerCompat sInstance;
    public Choreographer mChoreographer = Choreographer.getInstance();

    public static abstract class FrameCallback {
        public android.view.Choreographer.FrameCallback mFrameCallback;

        public abstract void doFrame(long j);
    }

    public void postFrameCallback(FrameCallback frameCallback) {
        if (frameCallback.mFrameCallback == null) {
            frameCallback.mFrameCallback = new android.view.Choreographer.FrameCallback() {
                public void doFrame(long j) {
                    FrameCallback.this.doFrame(j);
                }
            };
        }
        this.mChoreographer.postFrameCallback(frameCallback.mFrameCallback);
    }
}
