package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;

public final class ImmutableBundle {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final Bundle bundle;

    public ImmutableBundle() {
        this.bundle = (Bundle) new Bundle().clone();
    }

    public boolean containsKey(String str) {
        return str != null && this.bundle.containsKey(str);
    }

    public ImmutableBundle(Bundle bundle2) {
        this.bundle = (Bundle) bundle2.clone();
    }
}
