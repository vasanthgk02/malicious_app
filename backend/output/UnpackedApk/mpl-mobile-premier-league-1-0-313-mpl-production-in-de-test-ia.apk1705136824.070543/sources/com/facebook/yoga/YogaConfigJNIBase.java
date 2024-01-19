package com.facebook.yoga;

public abstract class YogaConfigJNIBase {
    public long mNativePointer;

    public YogaConfigJNIBase() {
        long jni_YGConfigNewJNI = YogaNative.jni_YGConfigNewJNI();
        if (jni_YGConfigNewJNI != 0) {
            this.mNativePointer = jni_YGConfigNewJNI;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }
}
