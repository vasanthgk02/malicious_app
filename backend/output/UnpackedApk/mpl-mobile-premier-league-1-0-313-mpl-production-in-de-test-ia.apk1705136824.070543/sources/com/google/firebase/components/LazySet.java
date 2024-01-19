package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LazySet<T> implements Provider<Set<T>> {
    public volatile Set<T> actualSet = null;
    public volatile Set<Provider<T>> providers = Collections.newSetFromMap(new ConcurrentHashMap());

    public LazySet(Collection<Provider<T>> collection) {
        this.providers.addAll(collection);
    }

    public Object get() {
        if (this.actualSet == null) {
            synchronized (this) {
                if (this.actualSet == null) {
                    this.actualSet = Collections.newSetFromMap(new ConcurrentHashMap());
                    synchronized (this) {
                        for (Provider<T> provider : this.providers) {
                            this.actualSet.add(provider.get());
                        }
                        this.providers = null;
                    }
                }
            }
        }
        return Collections.unmodifiableSet(this.actualSet);
    }
}
