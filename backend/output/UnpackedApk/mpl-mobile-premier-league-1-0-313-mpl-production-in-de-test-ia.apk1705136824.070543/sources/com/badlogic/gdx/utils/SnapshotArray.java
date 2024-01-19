package com.badlogic.gdx.utils;

import java.util.Comparator;

public class SnapshotArray<T> extends Array<T> {
    public T[] recycled;
    public T[] snapshot;
    public int snapshots;

    public SnapshotArray(boolean z, int i, Class cls) {
        super(z, i, cls);
    }

    public T[] begin() {
        modified();
        T[] tArr = this.items;
        this.snapshot = tArr;
        this.snapshots++;
        return tArr;
    }

    public void clear() {
        modified();
        super.clear();
    }

    public void end() {
        int max = Math.max(0, this.snapshots - 1);
        this.snapshots = max;
        T[] tArr = this.snapshot;
        if (tArr != null) {
            if (tArr != this.items && max == 0) {
                this.recycled = tArr;
                int length = tArr.length;
                for (int i = 0; i < length; i++) {
                    this.recycled[i] = null;
                }
            }
            this.snapshot = null;
        }
    }

    public void insert(int i, T t) {
        modified();
        super.insert(i, t);
    }

    public final void modified() {
        T[] tArr = this.snapshot;
        if (tArr != null) {
            T[] tArr2 = this.items;
            if (tArr == tArr2) {
                T[] tArr3 = this.recycled;
                if (tArr3 != null) {
                    int length = tArr3.length;
                    int i = this.size;
                    if (length >= i) {
                        System.arraycopy(tArr2, 0, tArr3, 0, i);
                        this.items = this.recycled;
                        this.recycled = null;
                        return;
                    }
                }
                resize(this.items.length);
            }
        }
    }

    public T pop() {
        modified();
        return super.pop();
    }

    public boolean removeAll(Array<? extends T> array, boolean z) {
        modified();
        return super.removeAll(array, z);
    }

    public T removeIndex(int i) {
        modified();
        return super.removeIndex(i);
    }

    public void removeRange(int i, int i2) {
        modified();
        super.removeRange(i, i2);
    }

    public boolean removeValue(T t, boolean z) {
        modified();
        return super.removeValue(t, z);
    }

    public void set(int i, T t) {
        modified();
        super.set(i, t);
    }

    public void sort(Comparator<? super T> comparator) {
        modified();
        super.sort(comparator);
    }

    public void truncate(int i) {
        modified();
        super.truncate(i);
    }

    public SnapshotArray(Class cls) {
        super(true, 16, cls);
    }
}
