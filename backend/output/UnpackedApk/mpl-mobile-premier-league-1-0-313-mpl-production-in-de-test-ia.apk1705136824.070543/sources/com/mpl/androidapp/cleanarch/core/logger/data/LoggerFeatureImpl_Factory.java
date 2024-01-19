package com.mpl.androidapp.cleanarch.core.logger.data;

import dagger.internal.Factory;

public final class LoggerFeatureImpl_Factory implements Factory<LoggerFeatureImpl> {

    public static final class InstanceHolder {
        public static final LoggerFeatureImpl_Factory INSTANCE = new LoggerFeatureImpl_Factory();
    }

    public static LoggerFeatureImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LoggerFeatureImpl newInstance() {
        return new LoggerFeatureImpl();
    }

    public LoggerFeatureImpl get() {
        return newInstance();
    }
}
