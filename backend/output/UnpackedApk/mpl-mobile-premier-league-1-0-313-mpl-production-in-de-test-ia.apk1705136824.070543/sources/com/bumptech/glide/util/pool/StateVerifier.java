package com.bumptech.glide.util.pool;

public abstract class StateVerifier {

    public static class DefaultStateVerifier extends StateVerifier {
        public volatile boolean isReleased;

        public DefaultStateVerifier() {
            super(null);
        }

        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public StateVerifier(AnonymousClass1 r1) {
    }

    public abstract void throwIfRecycled();
}
