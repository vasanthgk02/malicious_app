package com.google.android.datatransport.runtime.scheduling.persistence;

public final class EventStoreModule_SchemaVersionFactory implements Object<Integer> {

    public static final class InstanceHolder {
        public static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();
    }

    public Object get() {
        return Integer.valueOf(SchemaManager.SCHEMA_VERSION);
    }
}
