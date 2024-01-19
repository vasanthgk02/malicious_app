package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

public final class Optional<T> {
    public final T value;

    public Optional() {
        this.value = null;
    }

    public static <T> Optional<T> fromNullable(T t) {
        if (t == null) {
            return new Optional<>();
        }
        return new Optional(t);
    }

    public T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean isAvailable() {
        return this.value != null;
    }

    public Optional(T t) {
        if (t != null) {
            this.value = t;
            return;
        }
        throw new NullPointerException("value for optional is empty.");
    }
}
