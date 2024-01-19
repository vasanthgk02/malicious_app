package com.amazon.identity.auth.device.api;

public interface CancellableListener<T, U, V> extends Listener<T, V> {
    void onCancel(U u);

    void onError(V v);

    void onSuccess(T t);
}
