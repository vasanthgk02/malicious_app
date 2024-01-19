package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance = UNINITIALIZED;
    public volatile Provider<T> provider;

    public Lazy(Provider<T> provider2) {
        this.provider = provider2;
    }

    public T get() {
        T t = this.instance;
        if (t == UNINITIALIZED) {
            synchronized (this) {
                try {
                    t = this.instance;
                    if (t == UNINITIALIZED) {
                        t = this.provider.get();
                        this.instance = t;
                        this.provider = null;
                    }
                }
            }
        }
        return t;
    }
}
