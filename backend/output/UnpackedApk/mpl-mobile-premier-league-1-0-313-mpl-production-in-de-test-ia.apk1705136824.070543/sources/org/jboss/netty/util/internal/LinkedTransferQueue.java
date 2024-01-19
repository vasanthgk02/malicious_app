package org.jboss.netty.util.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import org.apache.fontbox.ttf.HeaderTable;

public class LinkedTransferQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ASYNC = 1;
    public static final int CHAINED_SPINS = 64;
    public static final int FRONT_SPINS = 128;
    public static final boolean MP;
    public static final int NOW = 0;
    public static final int SWEEP_THRESHOLD = 32;
    public static final int SYNC = 2;
    public static final int TIMED = 3;
    public static final AtomicReferenceFieldUpdater<LinkedTransferQueue, Node> headUpdater;
    public static final long serialVersionUID = -3223113410248163686L;
    public static final AtomicIntegerFieldUpdater<LinkedTransferQueue> sweepVotesUpdater = AtomicFieldUpdaterUtil.newIntUpdater(LinkedTransferQueue.class, "sweepVotes");
    public static final AtomicReferenceFieldUpdater<LinkedTransferQueue, Node> tailUpdater;
    public volatile transient Node head;
    public volatile transient int sweepVotes;
    public volatile transient Node tail;

    public final class Itr implements Iterator<E> {
        public Node lastPred;
        public Node lastRet;
        public E nextItem;
        public Node nextNode;

        public Itr() {
            advance(null);
        }

        private void advance(Node node) {
            this.lastPred = this.lastRet;
            this.lastRet = node;
            Node succ = node == null ? LinkedTransferQueue.this.head : LinkedTransferQueue.this.succ(node);
            while (succ != null) {
                Object obj = succ.item;
                if (succ.isData) {
                    if (!(obj == null || obj == succ)) {
                        this.nextItem = LinkedTransferQueue.cast(obj);
                        this.nextNode = succ;
                        return;
                    }
                } else if (obj == null) {
                    break;
                }
                succ = LinkedTransferQueue.this.succ(succ);
            }
            this.nextNode = null;
        }

        public final boolean hasNext() {
            return this.nextNode != null;
        }

        public final E next() {
            Node node = this.nextNode;
            if (node != null) {
                E e2 = this.nextItem;
                advance(node);
                return e2;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            Node node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            } else if (node.tryMatchData()) {
                LinkedTransferQueue.this.unsplice(this.lastPred, node);
            }
        }
    }

    public static final class Node {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final AtomicReferenceFieldUpdater<Node, Object> itemUpdater;
        public static final AtomicReferenceFieldUpdater<Node, Node> nextUpdater;
        public static final long serialVersionUID = -3375979862319811754L;
        public final boolean isData;
        public volatile Object item;
        public volatile Node next;
        public volatile Thread waiter;

        static {
            Class<Node> cls = Node.class;
            Class<LinkedTransferQueue> cls2 = LinkedTransferQueue.class;
            nextUpdater = AtomicFieldUpdaterUtil.newRefUpdater(cls, cls, "next");
            itemUpdater = AtomicFieldUpdaterUtil.newRefUpdater(cls, Object.class, "item");
        }

        public Node(Object obj, boolean z) {
            this.item = obj;
            this.isData = z;
        }

        public final boolean cannotPrecede(boolean z) {
            boolean z2 = this.isData;
            if (z2 != z) {
                Object obj = this.item;
                if (obj != this) {
                    if ((obj != null) == z2) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean casItem(Object obj, Object obj2) {
            if (AtomicFieldUpdaterUtil.isAvailable()) {
                return itemUpdater.compareAndSet(this, obj, obj2);
            }
            synchronized (this) {
                if (this.item != obj) {
                    return false;
                }
                this.item = obj2;
                return true;
            }
        }

        public final boolean casNext(Node node, Node node2) {
            if (AtomicFieldUpdaterUtil.isAvailable()) {
                return nextUpdater.compareAndSet(this, node, node2);
            }
            synchronized (this) {
                if (this.next != node) {
                    return false;
                }
                this.next = node2;
                return true;
            }
        }

        public final void forgetContents() {
            this.item = this;
            this.waiter = null;
        }

        public final void forgetNext() {
            this.next = this;
        }

        public final boolean isMatched() {
            Object obj = this.item;
            if (obj != this) {
                if ((obj == null) != this.isData) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isUnmatchedRequest() {
            return !this.isData && this.item == null;
        }

        public final boolean tryMatchData() {
            Object obj = this.item;
            if (obj == null || obj == this || !casItem(obj, null)) {
                return false;
            }
            LockSupport.unpark(this.waiter);
            return true;
        }
    }

    static {
        Class<Node> cls = Node.class;
        Class<LinkedTransferQueue> cls2 = LinkedTransferQueue.class;
        boolean z = true;
        if (Runtime.getRuntime().availableProcessors() <= 1) {
            z = false;
        }
        MP = z;
        headUpdater = AtomicFieldUpdaterUtil.newRefUpdater(LinkedTransferQueue.class, cls, HeaderTable.TAG);
        tailUpdater = AtomicFieldUpdaterUtil.newRefUpdater(LinkedTransferQueue.class, cls, "tail");
    }

    public LinkedTransferQueue() {
    }

    private E awaitMatch(Node node, Node node2, E e2, boolean z, long j) {
        long nanoTime = z ? System.nanoTime() : 0;
        Thread currentThread = Thread.currentThread();
        ThreadLocalRandom threadLocalRandom = null;
        int i = -1;
        while (true) {
            E e3 = node.item;
            if (e3 != e2) {
                node.forgetContents();
                return cast(e3);
            } else if ((currentThread.isInterrupted() || (z && j <= 0)) && node.casItem(e2, node)) {
                unsplice(node2, node);
                return e2;
            } else if (i < 0) {
                i = spinsFor(node2, node.isData);
                if (i > 0) {
                    threadLocalRandom = ThreadLocalRandom.current();
                }
            } else if (i > 0) {
                i--;
                if (threadLocalRandom.nextInt(64) == 0) {
                    Thread.yield();
                }
            } else if (node.waiter == null) {
                node.waiter = currentThread;
            } else if (z) {
                long nanoTime2 = System.nanoTime();
                j -= nanoTime2 - nanoTime;
                if (j > 0) {
                    LockSupport.parkNanos(j);
                }
                nanoTime = nanoTime2;
            } else {
                LockSupport.park();
            }
        }
    }

    private boolean casHead(Node node, Node node2) {
        if (AtomicFieldUpdaterUtil.isAvailable()) {
            return headUpdater.compareAndSet(this, node, node2);
        }
        synchronized (this) {
            if (this.head != node) {
                return false;
            }
            this.head = node2;
            return true;
        }
    }

    private boolean casSweepVotes(int i, int i2) {
        if (AtomicFieldUpdaterUtil.isAvailable()) {
            return sweepVotesUpdater.compareAndSet(this, i, i2);
        }
        synchronized (this) {
            if (this.sweepVotes != i) {
                return false;
            }
            this.sweepVotes = i2;
            return true;
        }
    }

    private boolean casTail(Node node, Node node2) {
        if (AtomicFieldUpdaterUtil.isAvailable()) {
            return tailUpdater.compareAndSet(this, node, node2);
        }
        synchronized (this) {
            if (this.tail != node) {
                return false;
            }
            this.tail = node2;
            return true;
        }
    }

    public static <E> E cast(Object obj) {
        return obj;
    }

    private int countOfMode(boolean z) {
        int i;
        Node node = this.head;
        loop0:
        while (true) {
            i = 0;
            while (node != null) {
                if (!node.isMatched()) {
                    if (node.isData == z) {
                        i++;
                        if (i == Integer.MAX_VALUE) {
                            break loop0;
                        }
                    } else {
                        return 0;
                    }
                }
                Node node2 = node.next;
                if (node2 != node) {
                    node = node2;
                } else {
                    node = this.head;
                }
            }
            break loop0;
        }
        return i;
    }

    private boolean findAndRemove(Object obj) {
        if (obj != null) {
            Node node = this.head;
            loop0:
            while (true) {
                Node node2 = null;
                while (node != null) {
                    Object obj2 = node.item;
                    if (!node.isData) {
                        if (obj2 == null) {
                            break loop0;
                        }
                    } else if (obj2 != null && obj2 != node && obj.equals(obj2) && node.tryMatchData()) {
                        unsplice(node2, node);
                        return true;
                    }
                    Node node3 = node.next;
                    if (node3 == node) {
                        node = this.head;
                    } else {
                        Node node4 = node3;
                        node2 = node;
                        node = node4;
                    }
                }
                break loop0;
            }
        }
        return false;
    }

    private E firstDataItem() {
        Node node = this.head;
        while (node != null) {
            Object obj = node.item;
            if (node.isData) {
                if (!(obj == null || obj == node)) {
                    return cast(obj);
                }
            } else if (obj == null) {
                return null;
            }
            node = succ(node);
        }
        return null;
    }

    private Node firstOfMode(boolean z) {
        Node node = this.head;
        while (node != null) {
            if (!node.isMatched()) {
                if (node.isData != z) {
                    node = null;
                }
                return node;
            }
            node = succ(node);
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                offer(readObject);
            } else {
                return;
            }
        }
    }

    public static int spinsFor(Node node, boolean z) {
        if (MP && node != null) {
            if (node.isData != z) {
                return 192;
            }
            if (node.isMatched()) {
                return 128;
            }
            if (node.waiter == null) {
                return 64;
            }
        }
        return 0;
    }

    private void sweep() {
        Node node = this.head;
        while (node != null) {
            Node node2 = node.next;
            if (node2 == null) {
                return;
            }
            if (node == node2) {
                node = this.head;
            } else if (!node2.isMatched()) {
                node = node2;
            } else {
                Node node3 = node2.next;
                if (node3 != null) {
                    node.casNext(node2, node3);
                } else {
                    return;
                }
            }
        }
    }

    private Node tryAppend(Node node, boolean z) {
        Node node2 = this.tail;
        Node node3 = node2;
        while (true) {
            Node node4 = null;
            if (node2 == null) {
                node2 = this.head;
                if (node2 == null) {
                    if (casHead(null, node)) {
                        return node;
                    }
                }
            }
            if (node2.cannotPrecede(z)) {
                return null;
            }
            Node node5 = node2.next;
            if (node5 != null) {
                if (node2 != node3) {
                    Node node6 = this.tail;
                    if (node3 != node6) {
                        node3 = node6;
                        node4 = node3;
                        node2 = node4;
                    }
                }
                if (node2 != node5) {
                    node4 = node5;
                }
                node2 = node4;
            } else if (!node2.casNext(null, node)) {
                node2 = node2.next;
            } else {
                if (node2 != node3) {
                    do {
                        if (this.tail == node3 && casTail(node3, node)) {
                            break;
                        }
                        node3 = this.tail;
                        if (node3 == null) {
                            break;
                        }
                        Node node7 = node3.next;
                        if (node7 == null) {
                            break;
                        }
                        node = node7.next;
                        if (node == null) {
                            break;
                        }
                    } while (node != node3);
                }
                return node2;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeObject(null);
    }

    private E xfer(E e2, boolean z, int i, long j) {
        boolean z2;
        E e3 = e2;
        boolean z3 = z;
        int i2 = i;
        Node node = null;
        if (!z3 || e3 != null) {
            while (true) {
                Node node2 = this.head;
                while (true) {
                    Node node3 = node2;
                    while (true) {
                        z2 = false;
                        if (node2 == null) {
                            break;
                        }
                        boolean z4 = node2.isData;
                        Object obj = node2.item;
                        if (obj != node2) {
                            if ((obj != null) == z4) {
                                if (z4 == z3) {
                                    break;
                                } else if (node2.casItem(obj, e2)) {
                                    Node node4 = node2;
                                    while (true) {
                                        if (node4 == node3) {
                                            break;
                                        }
                                        Node node5 = node4.next;
                                        if (this.head == node3) {
                                            if (node5 != null) {
                                                node4 = node5;
                                            }
                                            if (casHead(node3, node4)) {
                                                node3.forgetNext();
                                                break;
                                            }
                                        }
                                        node3 = this.head;
                                        if (node3 == null) {
                                            break;
                                        }
                                        node4 = node3.next;
                                        if (node4 != null) {
                                            if (!node4.isMatched()) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    LockSupport.unpark(node2.waiter);
                                    return cast(obj);
                                }
                            }
                        }
                        Node node6 = node2.next;
                        if (node2 == node6) {
                            break;
                        }
                        node2 = node6;
                    }
                    node2 = this.head;
                }
                if (i2 == 0) {
                    break;
                }
                if (node == null) {
                    node = new Node(e2, z);
                }
                Node tryAppend = tryAppend(node, z);
                if (tryAppend != null) {
                    if (i2 != 1) {
                        if (i2 == 3) {
                            z2 = true;
                        }
                        return awaitMatch(node, tryAppend, e2, z2, j);
                    }
                }
            }
            return e3;
        }
        throw null;
    }

    public boolean add(E e2) {
        xfer(e2, true, 1, 0);
        return true;
    }

    public int drainTo(Collection<? super E> collection) {
        if (collection == null) {
            throw null;
        } else if (collection != this) {
            int i = 0;
            while (true) {
                Object poll = poll();
                if (poll == null) {
                    return i;
                }
                collection.add(poll);
                i++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getWaitingConsumerCount() {
        return countOfMode(false);
    }

    public boolean hasWaitingConsumer() {
        return firstOfMode(false) != null;
    }

    public boolean isEmpty() {
        Node node = this.head;
        while (node != null) {
            if (!node.isMatched()) {
                return !node.isData;
            }
            node = succ(node);
        }
        return true;
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    public boolean offer(E e2, long j, TimeUnit timeUnit) {
        xfer(e2, true, 1, 0);
        return true;
    }

    public E peek() {
        return firstDataItem();
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        E xfer = xfer(null, false, 3, timeUnit.toNanos(j));
        if (xfer != null || !Thread.interrupted()) {
            return xfer;
        }
        throw new InterruptedException();
    }

    public void put(E e2) {
        xfer(e2, true, 1, 0);
    }

    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    public boolean remove(Object obj) {
        return findAndRemove(obj);
    }

    public int size() {
        return countOfMode(true);
    }

    public final Node succ(Node node) {
        Node node2 = node.next;
        return node == node2 ? this.head : node2;
    }

    public E take() throws InterruptedException {
        E xfer = xfer(null, false, 2, 0);
        if (xfer != null) {
            return xfer;
        }
        Thread.interrupted();
        throw new InterruptedException();
    }

    public void transfer(E e2) throws InterruptedException {
        if (xfer(e2, true, 2, 0) != null) {
            Thread.interrupted();
            throw new InterruptedException();
        }
    }

    public boolean tryTransfer(E e2) {
        return xfer(e2, true, 0, 0) == null;
    }

    public final void unsplice(Node node, Node node2) {
        node2.forgetContents();
        if (node != null && node != node2 && node.next == node2) {
            Node node3 = node2.next;
            if (node3 == null || (node3 != node2 && node.casNext(node2, node3) && node.isMatched())) {
                while (true) {
                    Node node4 = this.head;
                    if (node4 == node || node4 == node2 || node4 == null) {
                        break;
                    } else if (node4.isMatched()) {
                        Node node5 = node4.next;
                        if (node5 != null) {
                            if (node5 != node4 && casHead(node4, node5)) {
                                node4.forgetNext();
                            }
                        } else {
                            return;
                        }
                    } else if (node.next != node && node2.next != node2) {
                        while (true) {
                            int i = this.sweepVotes;
                            if (i < 32) {
                                if (casSweepVotes(i, i + 1)) {
                                    break;
                                }
                            } else if (casSweepVotes(i, 0)) {
                                sweep();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public LinkedTransferQueue(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    public boolean offer(E e2) {
        xfer(e2, true, 1, 0);
        return true;
    }

    public boolean tryTransfer(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        if (xfer(e2, true, 3, timeUnit.toNanos(j)) == null) {
            return true;
        }
        if (!Thread.interrupted()) {
            return false;
        }
        throw new InterruptedException();
    }

    public E poll() {
        return xfer(null, false, 0, 0);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw null;
        } else if (collection != this) {
            int i2 = 0;
            while (i2 < i) {
                Object poll = poll();
                if (poll == null) {
                    break;
                }
                collection.add(poll);
                i2++;
            }
            return i2;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
