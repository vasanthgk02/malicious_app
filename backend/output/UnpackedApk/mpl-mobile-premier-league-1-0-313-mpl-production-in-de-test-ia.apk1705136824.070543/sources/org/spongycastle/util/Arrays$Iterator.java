package org.spongycastle.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Arrays$Iterator<T> implements Iterator<T> {
    public final T[] dataArray;
    public int position = 0;

    public Arrays$Iterator(T[] tArr) {
        this.dataArray = tArr;
    }

    public boolean hasNext() {
        return this.position < this.dataArray.length;
    }

    public T next() {
        int i = this.position;
        T[] tArr = this.dataArray;
        if (i != tArr.length) {
            this.position = i + 1;
            return tArr[i];
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Out of elements: ");
        outline73.append(this.position);
        throw new NoSuchElementException(outline73.toString());
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove element from an Array.");
    }
}
