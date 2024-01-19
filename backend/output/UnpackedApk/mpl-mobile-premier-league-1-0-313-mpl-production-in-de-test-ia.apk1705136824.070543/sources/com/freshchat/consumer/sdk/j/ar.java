package com.freshchat.consumer.sdk.j;

import java.util.LinkedList;

public class ar<E> extends LinkedList<E> {
    public int maxSize;

    public boolean add(E e2) {
        boolean add = super.add(e2);
        if (size() > getMaxSize()) {
            removeFirst();
        }
        return add;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void v(int i) {
        this.maxSize = i;
    }
}
