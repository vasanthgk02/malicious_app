package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

public abstract class AbstractComponentContainer implements ComponentContainer {
    public <T> T get(Class<T> cls) {
        Provider<T> provider = getProvider(cls);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public <T> Set<T> setOf(Class<T> cls) {
        return (Set) setOfProvider(cls).get();
    }
}
