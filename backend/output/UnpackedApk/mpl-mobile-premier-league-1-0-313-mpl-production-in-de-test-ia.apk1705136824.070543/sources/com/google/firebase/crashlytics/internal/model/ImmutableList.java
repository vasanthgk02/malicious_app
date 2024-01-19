package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E> implements List<E>, RandomAccess {
    public final List<E> immutableList;

    public ImmutableList(List<E> list) {
        this.immutableList = Collections.unmodifiableList(list);
    }

    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    public boolean add(E e2) {
        return this.immutableList.add(e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return this.immutableList.addAll(collection);
    }

    public void clear() {
        this.immutableList.clear();
    }

    public boolean contains(Object obj) {
        return this.immutableList.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.immutableList.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.immutableList.equals(obj);
    }

    public E get(int i) {
        return this.immutableList.get(i);
    }

    public int hashCode() {
        return this.immutableList.hashCode();
    }

    public int indexOf(Object obj) {
        return this.immutableList.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.immutableList.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.immutableList.lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return this.immutableList.listIterator();
    }

    public boolean remove(Object obj) {
        return this.immutableList.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.immutableList.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.immutableList.retainAll(collection);
    }

    public E set(int i, E e2) {
        return this.immutableList.set(i, e2);
    }

    public int size() {
        return this.immutableList.size();
    }

    public List<E> subList(int i, int i2) {
        return this.immutableList.subList(i, i2);
    }

    public Object[] toArray() {
        return this.immutableList.toArray();
    }

    public static <E> ImmutableList<E> from(List<E> list) {
        return new ImmutableList<>(list);
    }

    public void add(int i, E e2) {
        this.immutableList.add(i, e2);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        return this.immutableList.addAll(i, collection);
    }

    public ListIterator<E> listIterator(int i) {
        return this.immutableList.listIterator(i);
    }

    public E remove(int i) {
        return this.immutableList.remove(i);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.immutableList.toArray(tArr);
    }
}
