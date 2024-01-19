package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public static final int MAX_CACHE_ENTRIES = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    public static final long PARAMS_CHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5);

    private int getMaxCacheSize() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 1048576;
        }
        if (min < 33554432) {
            return PDChoice.FLAG_MULTI_SELECT;
        }
        return 4194304;
    }

    public MemoryCacheParams get() {
        int maxCacheSize = getMaxCacheSize();
        MemoryCacheParams memoryCacheParams = new MemoryCacheParams(maxCacheSize, Integer.MAX_VALUE, maxCacheSize, Integer.MAX_VALUE, maxCacheSize / 8, PARAMS_CHECK_INTERVAL_MS);
        return memoryCacheParams;
    }
}
