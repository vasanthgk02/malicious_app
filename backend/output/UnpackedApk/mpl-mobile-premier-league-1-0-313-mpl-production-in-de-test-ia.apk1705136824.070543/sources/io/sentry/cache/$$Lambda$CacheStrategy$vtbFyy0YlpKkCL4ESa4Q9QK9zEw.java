package io.sentry.cache;

import java.io.File;
import java.util.Comparator;

/* renamed from: io.sentry.cache.-$$Lambda$CacheStrategy$vtbFyy0YlpKkCL4ESa4Q9QK9zEw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CacheStrategy$vtbFyy0YlpKkCL4ESa4Q9QK9zEw implements Comparator {
    public static final /* synthetic */ $$Lambda$CacheStrategy$vtbFyy0YlpKkCL4ESa4Q9QK9zEw INSTANCE = new $$Lambda$CacheStrategy$vtbFyy0YlpKkCL4ESa4Q9QK9zEw();

    private /* synthetic */ $$Lambda$CacheStrategy$vtbFyy0YlpKkCL4ESa4Q9QK9zEw() {
    }

    public final int compare(Object obj, Object obj2) {
        return Long.compare(((File) obj).lastModified(), ((File) obj2).lastModified());
    }
}
