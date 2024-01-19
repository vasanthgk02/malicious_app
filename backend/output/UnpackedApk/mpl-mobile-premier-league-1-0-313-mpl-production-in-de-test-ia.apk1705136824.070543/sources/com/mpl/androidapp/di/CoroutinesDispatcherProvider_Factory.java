package com.mpl.androidapp.di;

import dagger.internal.Factory;

public final class CoroutinesDispatcherProvider_Factory implements Factory<CoroutinesDispatcherProvider> {

    public static final class InstanceHolder {
        public static final CoroutinesDispatcherProvider_Factory INSTANCE = new CoroutinesDispatcherProvider_Factory();
    }

    public static CoroutinesDispatcherProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutinesDispatcherProvider newInstance() {
        return new CoroutinesDispatcherProvider();
    }

    public CoroutinesDispatcherProvider get() {
        return newInstance();
    }
}
