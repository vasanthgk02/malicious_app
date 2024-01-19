package com.badlogic.gdx.utils;

import java.util.Comparator;

public class DelayedRemovalArray<T> extends Array<T> {
    public int clear;
    public int iterating;
    public IntArray remove = new IntArray(0);

    public DelayedRemovalArray(int i) {
        super(true, i);
    }

    public void clear() {
        if (this.iterating > 0) {
            this.clear = this.size;
        } else {
            super.clear();
        }
    }

    public void end() {
        int i = this.iterating;
        if (i != 0) {
            int i2 = i - 1;
            this.iterating = i2;
            if (i2 == 0) {
                int i3 = this.clear;
                if (i3 <= 0 || i3 != this.size) {
                    int i4 = this.remove.size;
                    for (int i5 = 0; i5 < i4; i5++) {
                        int pop = this.remove.pop();
                        if (pop >= this.clear) {
                            removeIndex(pop);
                        }
                    }
                    for (int i6 = this.clear - 1; i6 >= 0; i6--) {
                        removeIndex(i6);
                    }
                } else {
                    this.remove.size = 0;
                    clear();
                }
                this.clear = 0;
                return;
            }
            return;
        }
        throw new IllegalStateException("begin must be called before end.");
    }

    public void insert(int i, T t) {
        if (this.iterating <= 0) {
            super.insert(i, t);
            return;
        }
        throw new IllegalStateException("Invalid between begin/end.");
    }

    public T pop() {
        if (this.iterating <= 0) {
            return super.pop();
        }
        throw new IllegalStateException("Invalid between begin/end.");
    }

    public final void remove(int i) {
        if (i >= this.clear) {
            int i2 = 0;
            int i3 = this.remove.size;
            while (i2 < i3) {
                int i4 = this.remove.get(i2);
                if (i != i4) {
                    if (i < i4) {
                        this.remove.insert(i2, i);
                        return;
                    }
                    i2++;
                } else {
                    return;
                }
            }
            this.remove.add(i);
        }
    }

    public T removeIndex(int i) {
        if (this.iterating <= 0) {
            return super.removeIndex(i);
        }
        remove(i);
        return get(i);
    }

    public void removeRange(int i, int i2) {
        if (this.iterating > 0) {
            while (i2 >= i) {
                remove(i2);
                i2--;
            }
            return;
        }
        super.removeRange(i, i2);
    }

    public boolean removeValue(T t, boolean z) {
        if (this.iterating <= 0) {
            return super.removeValue(t, z);
        }
        int indexOf = indexOf(t, z);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public void set(int i, T t) {
        if (this.iterating <= 0) {
            super.set(i, t);
            return;
        }
        throw new IllegalStateException("Invalid between begin/end.");
    }

    public void sort(Comparator<? super T> comparator) {
        if (this.iterating <= 0) {
            super.sort(comparator);
            return;
        }
        throw new IllegalStateException("Invalid between begin/end.");
    }

    public void truncate(int i) {
        if (this.iterating <= 0) {
            super.truncate(i);
            return;
        }
        throw new IllegalStateException("Invalid between begin/end.");
    }
}
