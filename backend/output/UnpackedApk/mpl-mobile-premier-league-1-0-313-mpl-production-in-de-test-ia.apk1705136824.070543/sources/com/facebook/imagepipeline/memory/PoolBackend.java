package com.facebook.imagepipeline.memory;

public interface PoolBackend<T> {
    T get(int i);

    int getSize(T t);

    T pop();

    void put(T t);
}
