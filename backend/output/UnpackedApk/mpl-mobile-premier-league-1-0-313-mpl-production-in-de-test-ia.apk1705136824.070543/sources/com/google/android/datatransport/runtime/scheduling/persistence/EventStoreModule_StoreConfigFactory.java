package com.google.android.datatransport.runtime.scheduling.persistence;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public final class EventStoreModule_StoreConfigFactory implements Object<EventStoreConfig> {

    public static final class InstanceHolder {
        public static final EventStoreModule_StoreConfigFactory INSTANCE = new EventStoreModule_StoreConfigFactory();
    }

    public Object get() {
        EventStoreConfig eventStoreConfig = EventStoreConfig.DEFAULT;
        ImageOriginUtils.checkNotNull(eventStoreConfig, "Cannot return null from a non-@Nullable @Provides method");
        return eventStoreConfig;
    }
}
