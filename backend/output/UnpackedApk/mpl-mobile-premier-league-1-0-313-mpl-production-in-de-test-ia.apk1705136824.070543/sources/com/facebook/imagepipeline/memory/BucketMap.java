package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.LinkedList;

public class BucketMap<T> {
    public LinkedEntry<T> mHead;
    public final SparseArray<LinkedEntry<T>> mMap = new SparseArray<>();
    public LinkedEntry<T> mTail;

    public static class LinkedEntry<I> {
        public int key;
        public LinkedEntry<I> next;
        public LinkedEntry<I> prev;
        public LinkedList<I> value;

        public String toString() {
            return GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("LinkedEntry(key: "), this.key, ")");
        }

        public LinkedEntry(LinkedEntry<I> linkedEntry, int i, LinkedList<I> linkedList, LinkedEntry<I> linkedEntry2) {
            this.prev = linkedEntry;
            this.key = i;
            this.value = linkedList;
            this.next = linkedEntry2;
        }
    }

    private void maybePrune(LinkedEntry<T> linkedEntry) {
        if (linkedEntry != null && linkedEntry.value.isEmpty()) {
            prune(linkedEntry);
            this.mMap.remove(linkedEntry.key);
        }
    }

    private void moveToFront(LinkedEntry<T> linkedEntry) {
        if (this.mHead != linkedEntry) {
            prune(linkedEntry);
            LinkedEntry<T> linkedEntry2 = this.mHead;
            if (linkedEntry2 == null) {
                this.mHead = linkedEntry;
                this.mTail = linkedEntry;
                return;
            }
            linkedEntry.next = linkedEntry2;
            linkedEntry2.prev = linkedEntry;
            this.mHead = linkedEntry;
        }
    }

    private synchronized void prune(LinkedEntry<T> linkedEntry) {
        LinkedEntry<I> linkedEntry2 = linkedEntry.prev;
        LinkedEntry<I> linkedEntry3 = linkedEntry.next;
        if (linkedEntry2 != null) {
            linkedEntry2.next = linkedEntry3;
        }
        if (linkedEntry3 != null) {
            linkedEntry3.prev = linkedEntry2;
        }
        linkedEntry.prev = null;
        linkedEntry.next = null;
        if (linkedEntry == this.mHead) {
            this.mHead = linkedEntry3;
        }
        if (linkedEntry == this.mTail) {
            this.mTail = linkedEntry2;
        }
    }

    public synchronized T acquire(int i) {
        try {
            LinkedEntry linkedEntry = this.mMap.get(i);
            if (linkedEntry == null) {
                return null;
            }
            T pollFirst = linkedEntry.value.pollFirst();
            moveToFront(linkedEntry);
            return pollFirst;
        }
    }

    public synchronized void release(int i, T t) {
        LinkedEntry linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(null, i, new LinkedList(), null);
            this.mMap.put(i, linkedEntry);
        }
        linkedEntry.value.addLast(t);
        moveToFront(linkedEntry);
    }

    public synchronized T removeFromEnd() {
        try {
            LinkedEntry<T> linkedEntry = this.mTail;
            if (linkedEntry == null) {
                return null;
            }
            T pollLast = linkedEntry.value.pollLast();
            maybePrune(linkedEntry);
            return pollLast;
        }
    }

    public synchronized int valueCount() {
        int i;
        i = 0;
        try {
            for (LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
                if (linkedEntry.value != null) {
                    i += linkedEntry.value.size();
                }
            }
        }
        return i;
    }
}
