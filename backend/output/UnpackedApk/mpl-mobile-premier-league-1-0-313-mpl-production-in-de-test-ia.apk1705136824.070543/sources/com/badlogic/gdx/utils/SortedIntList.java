package com.badlogic.gdx.utils;

public class SortedIntList<E> implements Iterable<Node<E>> {
    public Node<E> first;
    public transient Iterator iterator;
    public NodePool<E> nodePool = new NodePool<>();
    public int size = 0;

    public class Iterator implements java.util.Iterator<Node<E>> {
        public Node<E> position;
        public Node<E> previousPosition;

        public Iterator() {
        }

        public boolean hasNext() {
            return this.position != null;
        }

        public Object next() {
            Node<E> node = this.position;
            this.previousPosition = node;
            this.position = node.n;
            return node;
        }

        public void remove() {
            Node<E> node = this.previousPosition;
            if (node != null) {
                SortedIntList sortedIntList = SortedIntList.this;
                if (node == sortedIntList.first) {
                    sortedIntList.first = this.position;
                } else {
                    Node<E> node2 = node.p;
                    Node<E> node3 = this.position;
                    node2.n = node3;
                    if (node3 != null) {
                        node3.p = node2;
                    }
                }
                SortedIntList sortedIntList2 = SortedIntList.this;
                sortedIntList2.size--;
            }
        }
    }

    public static class Node<E> {
        public int index;
        public Node<E> n;
        public Node<E> p;
        public E value;
    }

    public static class NodePool<E> extends Pool<Node<E>> {
        public Object newObject() {
            return new Node();
        }

        public Node<E> obtain(Node<E> node, Node<E> node2, E e2, int i) {
            Node<E> node3 = (Node) super.obtain();
            node3.p = node;
            node3.n = node2;
            node3.value = e2;
            node3.index = i;
            return node3;
        }
    }

    public java.util.Iterator<Node<E>> iterator() {
        if (this.iterator == null) {
            this.iterator = new Iterator<>();
        }
        Iterator iterator2 = this.iterator;
        iterator2.position = SortedIntList.this.first;
        iterator2.previousPosition = null;
        return iterator2;
    }
}
