package com.badlogic.gdx.utils;

public abstract class FlushablePool<T> extends Pool<T> {
    public Array<T> obtained = new Array<>();

    public FlushablePool() {
    }

    public void flush() {
        super.freeAll(this.obtained);
        this.obtained.clear();
    }

    public void free(T t) {
        this.obtained.removeValue(t, true);
        super.free(t);
    }

    public void freeAll(Array<T> array) {
        this.obtained.removeAll(array, true);
        super.freeAll(array);
    }

    public T obtain() {
        T obtain = super.obtain();
        this.obtained.add(obtain);
        return obtain;
    }

    public FlushablePool(int i) {
        super(i);
    }

    public FlushablePool(int i, int i2) {
        super(i, i2);
    }
}
