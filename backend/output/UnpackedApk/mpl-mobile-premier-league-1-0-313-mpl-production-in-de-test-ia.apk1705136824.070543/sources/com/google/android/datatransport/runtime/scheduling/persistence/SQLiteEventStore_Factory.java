package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

public final class SQLiteEventStore_Factory implements Object<SQLiteEventStore> {
    public final Provider<Clock> clockProvider;
    public final Provider<EventStoreConfig> configProvider;
    public final Provider<String> packageNameProvider;
    public final Provider<SchemaManager> schemaManagerProvider;
    public final Provider<Clock> wallClockProvider;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        this.wallClockProvider = provider;
        this.clockProvider = provider2;
        this.configProvider = provider3;
        this.schemaManagerProvider = provider4;
        this.packageNameProvider = provider5;
    }

    public Object get() {
        Object obj = this.configProvider.get();
        Object obj2 = this.schemaManagerProvider.get();
        SQLiteEventStore sQLiteEventStore = new SQLiteEventStore((Clock) this.wallClockProvider.get(), (Clock) this.clockProvider.get(), (EventStoreConfig) obj, (SchemaManager) obj2, DoubleCheck.lazy(this.packageNameProvider));
        return sQLiteEventStore;
    }
}
