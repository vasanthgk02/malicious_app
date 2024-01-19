package com.facebook.drawee.components;

public abstract class DeferredReleaser {
    public static DeferredReleaser sInstance;

    public interface Releasable {
        void release();
    }

    public abstract void cancelDeferredRelease(Releasable releasable);
}
