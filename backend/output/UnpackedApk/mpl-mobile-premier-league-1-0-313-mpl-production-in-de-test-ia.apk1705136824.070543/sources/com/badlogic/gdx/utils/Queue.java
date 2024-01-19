package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;

public class Queue<T> implements Iterable<T> {
    public int head = 0;
    public transient QueueIterable iterable;
    public int size = 0;
    public int tail = 0;
    public T[] values = new Object[16];

    public static class QueueIterable<T> implements Iterable<T> {
        public final boolean allowRemove = true;
        public QueueIterator iterator1;
        public QueueIterator iterator2;
        public final Queue<T> queue;

        public QueueIterable(Queue<T> queue2) {
            this.queue = queue2;
        }

        public Iterator<T> iterator() {
            if (this.iterator1 == null) {
                this.iterator1 = new QueueIterator(this.queue, this.allowRemove);
                this.iterator2 = new QueueIterator(this.queue, this.allowRemove);
            }
            QueueIterator queueIterator = this.iterator1;
            if (!queueIterator.valid) {
                queueIterator.index = 0;
                queueIterator.valid = true;
                this.iterator2.valid = false;
                return queueIterator;
            }
            QueueIterator queueIterator2 = this.iterator2;
            queueIterator2.index = 0;
            queueIterator2.valid = true;
            queueIterator.valid = false;
            return queueIterator2;
        }
    }

    public static class QueueIterator<T> implements Iterator<T>, Iterable<T> {
        public final boolean allowRemove;
        public int index;
        public final Queue<T> queue;
        public boolean valid = true;

        public QueueIterator(Queue<T> queue2, boolean z) {
            this.queue = queue2;
            this.allowRemove = z;
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.index < this.queue.size;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator<T> iterator() {
            return this;
        }

        public T next() {
            int i = this.index;
            Queue<T> queue2 = this.queue;
            if (i >= queue2.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            } else if (this.valid) {
                this.index = i + 1;
                return queue2.get(i);
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            if (this.allowRemove) {
                int i = this.index - 1;
                this.index = i;
                Queue<T> queue2 = this.queue;
                if (queue2 == null) {
                    throw null;
                } else if (i < 0) {
                    throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("index can't be < 0: ", i));
                } else if (i < queue2.size) {
                    T[] tArr = queue2.values;
                    int i2 = queue2.head;
                    int i3 = queue2.tail;
                    int i4 = i + i2;
                    if (i2 < i3) {
                        T t = tArr[i4];
                        System.arraycopy(tArr, i4 + 1, tArr, i4, i3 - i4);
                        tArr[i3] = null;
                        queue2.tail--;
                    } else if (i4 >= tArr.length) {
                        int length = i4 - tArr.length;
                        T t2 = tArr[length];
                        System.arraycopy(tArr, length + 1, tArr, length, i3 - length);
                        queue2.tail--;
                    } else {
                        T t3 = tArr[i4];
                        System.arraycopy(tArr, i2, tArr, i2 + 1, i4 - i2);
                        tArr[i2] = null;
                        int i5 = queue2.head + 1;
                        queue2.head = i5;
                        if (i5 == tArr.length) {
                            queue2.head = 0;
                        }
                    }
                    queue2.size--;
                } else {
                    StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be >= size: ", i, " >= ");
                    outline74.append(queue2.size);
                    throw new IndexOutOfBoundsException(outline74.toString());
                }
            } else {
                throw new GdxRuntimeException((String) "Remove not allowed.");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r11 != r12) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r12 == 0) goto L_0x0040
            boolean r2 = r12 instanceof com.badlogic.gdx.utils.Queue
            if (r2 != 0) goto L_0x000c
            goto L_0x0040
        L_0x000c:
            com.badlogic.gdx.utils.Queue r12 = (com.badlogic.gdx.utils.Queue) r12
            int r2 = r11.size
            int r3 = r12.size
            if (r3 == r2) goto L_0x0015
            return r1
        L_0x0015:
            T[] r3 = r11.values
            int r4 = r3.length
            T[] r5 = r12.values
            int r6 = r5.length
            int r7 = r11.head
            int r12 = r12.head
            r8 = 0
        L_0x0020:
            if (r8 >= r2) goto L_0x003f
            r9 = r3[r7]
            r10 = r5[r12]
            if (r9 != 0) goto L_0x002b
            if (r10 != 0) goto L_0x0031
            goto L_0x0032
        L_0x002b:
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0032
        L_0x0031:
            return r1
        L_0x0032:
            int r7 = r7 + 1
            int r12 = r12 + 1
            if (r7 != r4) goto L_0x0039
            r7 = 0
        L_0x0039:
            if (r12 != r6) goto L_0x003c
            r12 = 0
        L_0x003c:
            int r8 = r8 + 1
            goto L_0x0020
        L_0x003f:
            return r0
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.Queue.equals(java.lang.Object):boolean");
    }

    public T get(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("index can't be < 0: ", i));
        } else if (i < this.size) {
            T[] tArr = this.values;
            int i2 = this.head + i;
            if (i2 >= tArr.length) {
                i2 -= tArr.length;
            }
            return tArr[i2];
        } else {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be >= size: ", i, " >= ");
            outline74.append(this.size);
            throw new IndexOutOfBoundsException(outline74.toString());
        }
    }

    public int hashCode() {
        int i = this.size;
        T[] tArr = this.values;
        int length = tArr.length;
        int i2 = this.head;
        int i3 = i + 1;
        for (int i4 = 0; i4 < i; i4++) {
            T t = tArr[i2];
            i3 *= 31;
            if (t != null) {
                i3 = t.hashCode() + i3;
            }
            i2++;
            if (i2 == length) {
                i2 = 0;
            }
        }
        return i3;
    }

    public Iterator<T> iterator() {
        if (this.iterable == null) {
            this.iterable = new QueueIterable(this);
        }
        return this.iterable.iterator();
    }

    public String toString() {
        if (this.size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        T[] tArr = this.values;
        int i = this.head;
        int i2 = this.tail;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append0('[');
        stringBuilder.append((Object) tArr[i]);
        while (true) {
            i = (i + 1) % tArr.length;
            if (i != i2) {
                stringBuilder.append0((String) ", ");
                stringBuilder.append((Object) tArr[i]);
            } else {
                stringBuilder.append0(']');
                return stringBuilder.toString();
            }
        }
    }
}
