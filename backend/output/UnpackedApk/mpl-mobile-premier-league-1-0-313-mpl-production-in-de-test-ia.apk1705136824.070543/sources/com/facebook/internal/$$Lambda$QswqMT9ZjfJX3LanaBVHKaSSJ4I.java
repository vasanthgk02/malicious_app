package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.-$$Lambda$QswqMT9ZjfJX3LanaBVHKaSSJ4I  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$QswqMT9ZjfJX3LanaBVHKaSSJ4I implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$QswqMT9ZjfJX3LanaBVHKaSSJ4I INSTANCE = new $$Lambda$QswqMT9ZjfJX3LanaBVHKaSSJ4I();

    private /* synthetic */ $$Lambda$QswqMT9ZjfJX3LanaBVHKaSSJ4I() {
    }

    public final boolean accept(File file, String str) {
        return Utility.m206refreshBestGuessNumberOfCPUCores$lambda4(file, str);
    }
}
