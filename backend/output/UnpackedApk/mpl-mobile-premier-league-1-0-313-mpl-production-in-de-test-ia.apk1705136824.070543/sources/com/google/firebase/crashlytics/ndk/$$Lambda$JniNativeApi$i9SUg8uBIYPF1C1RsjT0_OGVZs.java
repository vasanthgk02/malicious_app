package com.google.firebase.crashlytics.ndk;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.ndk.-$$Lambda$JniNativeApi$i9SUg8uBIYPF1C1RsjT-0_OGVZs  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$JniNativeApi$i9SUg8uBIYPF1C1RsjT0_OGVZs implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$JniNativeApi$i9SUg8uBIYPF1C1RsjT0_OGVZs INSTANCE = new $$Lambda$JniNativeApi$i9SUg8uBIYPF1C1RsjT0_OGVZs();

    private /* synthetic */ $$Lambda$JniNativeApi$i9SUg8uBIYPF1C1RsjT0_OGVZs() {
    }

    public final boolean accept(File file, String str) {
        return str.toLowerCase().endsWith(".apk");
    }
}
