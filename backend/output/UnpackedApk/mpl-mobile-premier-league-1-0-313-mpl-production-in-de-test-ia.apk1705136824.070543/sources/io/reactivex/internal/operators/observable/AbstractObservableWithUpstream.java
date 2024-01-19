package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;

public abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> {
    public final Observable<T> source;

    public AbstractObservableWithUpstream(Observable<T> observable) {
        this.source = observable;
    }
}
