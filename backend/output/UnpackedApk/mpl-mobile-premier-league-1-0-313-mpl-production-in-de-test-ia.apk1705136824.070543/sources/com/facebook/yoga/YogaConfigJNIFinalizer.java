package com.facebook.yoga;

public class YogaConfigJNIFinalizer extends YogaConfigJNIBase {
    public void finalize() throws Throwable {
        try {
            long j = this.mNativePointer;
            if (j != 0) {
                this.mNativePointer = 0;
                YogaNative.jni_YGConfigFreeJNI(j);
            }
        } finally {
            super.finalize();
        }
    }
}
