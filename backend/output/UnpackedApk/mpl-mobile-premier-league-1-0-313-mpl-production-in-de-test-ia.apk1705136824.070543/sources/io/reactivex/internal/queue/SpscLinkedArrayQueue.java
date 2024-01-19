package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T> implements Object<T> {
    public static final Object HAS_NEXT = new Object();
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public AtomicReferenceArray<Object> consumerBuffer;
    public final AtomicLong consumerIndex = new AtomicLong();
    public final int consumerMask;
    public AtomicReferenceArray<Object> producerBuffer;
    public final AtomicLong producerIndex = new AtomicLong();
    public long producerLookAhead;
    public int producerLookAheadStep;
    public final int producerMask;

    public SpscLinkedArrayQueue(int i) {
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i) - 1));
        int i2 = numberOfLeadingZeros - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(numberOfLeadingZeros + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i2;
        this.producerLookAheadStep = Math.min(numberOfLeadingZeros / 4, MAX_LOOK_AHEAD_STEP);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i2;
        this.producerLookAhead = (long) (i2 - 1);
        this.producerIndex.lazySet(0);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
            long j = this.producerIndex.get();
            int i = this.producerMask;
            int i2 = ((int) j) & i;
            if (j < this.producerLookAhead) {
                atomicReferenceArray.lazySet(i2, t);
                this.producerIndex.lazySet(j + 1);
                return true;
            }
            long j2 = ((long) this.producerLookAheadStep) + j;
            if (atomicReferenceArray.get(((int) j2) & i) == null) {
                this.producerLookAhead = j2 - 1;
                atomicReferenceArray.lazySet(i2, t);
                this.producerIndex.lazySet(j + 1);
                return true;
            }
            long j3 = j + 1;
            if (atomicReferenceArray.get(((int) j3) & i) == null) {
                atomicReferenceArray.lazySet(i2, t);
                this.producerIndex.lazySet(j3);
                return true;
            }
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.producerBuffer = atomicReferenceArray2;
            this.producerLookAhead = (((long) i) + j) - 1;
            atomicReferenceArray2.lazySet(i2, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i2, HAS_NEXT);
            this.producerIndex.lazySet(j3);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long j = this.consumerIndex.get();
        int i = this.consumerMask;
        int i2 = ((int) j) & i;
        T t = atomicReferenceArray.get(i2);
        boolean z = t == HAS_NEXT;
        if (t != null && !z) {
            atomicReferenceArray.lazySet(i2, null);
            this.consumerIndex.lazySet(j + 1);
            return t;
        } else if (!z) {
            return null;
        } else {
            int i3 = i + 1;
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i3);
            atomicReferenceArray.lazySet(i3, null);
            this.consumerBuffer = atomicReferenceArray2;
            T t2 = atomicReferenceArray2.get(i2);
            if (t2 != null) {
                atomicReferenceArray2.lazySet(i2, null);
                this.consumerIndex.lazySet(j + 1);
            }
            return t2;
        }
    }
}
