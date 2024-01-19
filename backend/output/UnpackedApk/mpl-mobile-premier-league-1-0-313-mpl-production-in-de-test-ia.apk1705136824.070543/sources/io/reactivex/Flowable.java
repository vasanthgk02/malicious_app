package io.reactivex;

public abstract class Flowable<T> {
    public static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
}
