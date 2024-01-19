package com.facebook.react.common;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class SingleThreadAsserter {
    public Thread mThread = null;

    public void assertNow() {
        Thread currentThread = Thread.currentThread();
        if (this.mThread == null) {
            this.mThread = currentThread;
        }
        ImageOriginUtils.assertCondition(this.mThread == currentThread);
    }
}
