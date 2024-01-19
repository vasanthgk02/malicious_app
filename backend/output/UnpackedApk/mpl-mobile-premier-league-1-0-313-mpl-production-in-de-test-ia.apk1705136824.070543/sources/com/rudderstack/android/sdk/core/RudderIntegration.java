package com.rudderstack.android.sdk.core;

public abstract class RudderIntegration<T> {

    public interface Factory {
        RudderIntegration<?> create(Object obj, RudderClient rudderClient, RudderConfig rudderConfig);

        String key();
    }

    public abstract void dump(RudderMessage rudderMessage);

    public void flush() {
    }

    public T getUnderlyingInstance() {
        return null;
    }

    public abstract void reset();
}
