package com.google.android.gms.common.data;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    public final void close() {
    }

    public abstract T get(int i);

    public int getCount() {
        return 0;
    }

    public Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }

    public void release() {
    }
}
