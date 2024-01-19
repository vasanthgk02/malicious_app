package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;

public final class MetadataBackendRegistry_Factory implements Object<MetadataBackendRegistry> {
    public final Provider<Context> applicationContextProvider;
    public final Provider<CreationContextFactory> creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        this.applicationContextProvider = provider;
        this.creationContextFactoryProvider = provider2;
    }

    public Object get() {
        return new MetadataBackendRegistry((Context) this.applicationContextProvider.get(), (CreationContextFactory) this.creationContextFactoryProvider.get());
    }
}
