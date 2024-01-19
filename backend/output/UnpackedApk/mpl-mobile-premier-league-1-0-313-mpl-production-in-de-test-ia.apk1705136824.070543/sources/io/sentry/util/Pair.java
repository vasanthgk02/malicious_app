package io.sentry.util;

import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class Pair<A, B> {
    public final A first;
    public final B second;

    public Pair(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }
}
