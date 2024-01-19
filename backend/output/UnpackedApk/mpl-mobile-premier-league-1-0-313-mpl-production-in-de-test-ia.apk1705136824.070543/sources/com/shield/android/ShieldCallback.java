package com.shield.android;

public interface ShieldCallback<T> {
    void onFailure(ShieldException shieldException);

    void onSuccess(T t);
}
