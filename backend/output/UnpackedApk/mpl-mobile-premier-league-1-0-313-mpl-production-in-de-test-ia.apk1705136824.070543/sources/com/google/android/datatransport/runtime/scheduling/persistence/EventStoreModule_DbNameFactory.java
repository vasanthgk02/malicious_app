package com.google.android.datatransport.runtime.scheduling.persistence;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public final class EventStoreModule_DbNameFactory implements Object<String> {

    public static final class InstanceHolder {
        public static final EventStoreModule_DbNameFactory INSTANCE = new EventStoreModule_DbNameFactory();
    }

    public Object get() {
        ImageOriginUtils.checkNotNull("com.google.android.datatransport.events", "Cannot return null from a non-@Nullable @Provides method");
        return "com.google.android.datatransport.events";
    }
}
