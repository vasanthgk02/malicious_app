package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker.Listener;

public class NoOpCloseableReferenceLeakTracker implements CloseableReferenceLeakTracker {
    public boolean isSet() {
        return false;
    }

    public void setListener(Listener listener) {
    }

    public void trackCloseableReferenceLeak(SharedReference<Object> sharedReference, Throwable th) {
    }
}
