package com.facebook.internal;

import com.facebook.internal.FileLruCache.BufferFile;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.-$$Lambda$unX9NeGxjJ5DVb3-vL7tbz4CiEM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$unX9NeGxjJ5DVb3vL7tbz4CiEM implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$unX9NeGxjJ5DVb3vL7tbz4CiEM INSTANCE = new $$Lambda$unX9NeGxjJ5DVb3vL7tbz4CiEM();

    private /* synthetic */ $$Lambda$unX9NeGxjJ5DVb3vL7tbz4CiEM() {
    }

    public final boolean accept(File file, String str) {
        return BufferFile.m201filterExcludeNonBufferFiles$lambda1(file, str);
    }
}
