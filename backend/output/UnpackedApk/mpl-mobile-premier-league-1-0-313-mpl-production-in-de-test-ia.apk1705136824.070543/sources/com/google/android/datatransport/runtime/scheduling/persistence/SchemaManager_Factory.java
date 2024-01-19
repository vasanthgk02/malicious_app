package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Provider;

public final class SchemaManager_Factory implements Object<SchemaManager> {
    public final Provider<Context> contextProvider;
    public final Provider<String> dbNameProvider;
    public final Provider<Integer> schemaVersionProvider;

    public SchemaManager_Factory(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.contextProvider = provider;
        this.dbNameProvider = provider2;
        this.schemaVersionProvider = provider3;
    }

    public Object get() {
        return new SchemaManager((Context) this.contextProvider.get(), (String) this.dbNameProvider.get(), ((Integer) this.schemaVersionProvider.get()).intValue());
    }
}
