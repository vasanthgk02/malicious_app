package io.sentry.cache;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: io.sentry.cache.-$$Lambda$EnvelopeCache$7-eIJ0Vkpi1WSS08a1w-qss3p1M  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$EnvelopeCache$7eIJ0Vkpi1WSS08a1wqss3p1M implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$EnvelopeCache$7eIJ0Vkpi1WSS08a1wqss3p1M INSTANCE = new $$Lambda$EnvelopeCache$7eIJ0Vkpi1WSS08a1wqss3p1M();

    private /* synthetic */ $$Lambda$EnvelopeCache$7eIJ0Vkpi1WSS08a1wqss3p1M() {
    }

    public final boolean accept(File file, String str) {
        return str.endsWith(EnvelopeCache.SUFFIX_ENVELOPE_FILE);
    }
}
