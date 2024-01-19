package com.google.android.gms.common.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class DataBufferIterator<T> implements Iterator<T> {
    public final DataBuffer zaa;
    public int zab = -1;

    public DataBufferIterator(DataBuffer dataBuffer) {
        Preconditions.checkNotNull(dataBuffer);
        this.zaa = dataBuffer;
    }

    public final boolean hasNext() {
        return this.zab < this.zaa.getCount() + -1;
    }

    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.zaa;
            int i = this.zab + 1;
            this.zab = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException(GeneratedOutlineSupport.outline41("Cannot advance the iterator beyond ", this.zab));
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
