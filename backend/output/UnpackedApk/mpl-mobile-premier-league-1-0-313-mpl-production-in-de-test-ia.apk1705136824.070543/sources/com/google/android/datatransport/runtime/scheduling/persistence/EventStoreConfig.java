package com.google.android.datatransport.runtime.scheduling.persistence;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.imagepipeline.memory.DefaultByteArrayPoolParams;

public abstract class EventStoreConfig {
    public static final EventStoreConfig DEFAULT;

    static {
        Long valueOf = Long.valueOf(10485760);
        Integer valueOf2 = Integer.valueOf(200);
        Integer valueOf3 = Integer.valueOf(10000);
        Long valueOf4 = Long.valueOf(604800000);
        Integer valueOf5 = Integer.valueOf(DefaultByteArrayPoolParams.MAX_SIZE_SOFT_CAP);
        String str = valueOf == null ? " maxStorageSizeInBytes" : "";
        if (valueOf2 == null) {
            str = GeneratedOutlineSupport.outline50(str, " loadBatchSize");
        }
        if (valueOf3 == null) {
            str = GeneratedOutlineSupport.outline50(str, " criticalSectionEnterTimeoutMs");
        }
        if (valueOf4 == null) {
            str = GeneratedOutlineSupport.outline50(str, " eventCleanUpAge");
        }
        if (valueOf5 == null) {
            str = GeneratedOutlineSupport.outline50(str, " maxBlobByteSizePerRow");
        }
        if (str.isEmpty()) {
            AutoValue_EventStoreConfig autoValue_EventStoreConfig = new AutoValue_EventStoreConfig(valueOf.longValue(), valueOf2.intValue(), valueOf3.intValue(), valueOf4.longValue(), valueOf5.intValue(), null);
            DEFAULT = autoValue_EventStoreConfig;
            return;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
    }
}
