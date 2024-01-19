package com.amazon.identity.auth.device.api;

public interface Listener<T, U> {
    void onError(U u);

    void onSuccess(T t);
}
