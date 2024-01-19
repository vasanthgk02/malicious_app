package org.jboss.netty.util.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicFieldUpdaterUtil {
    public static final boolean AVAILABLE;

    public static final class Node {
        public volatile Node next;
    }

    static {
        boolean z;
        Class<Node> cls = Node.class;
        try {
            AtomicReferenceFieldUpdater<U, W> newUpdater = AtomicReferenceFieldUpdater.newUpdater(cls, cls, "next");
            Node node = new Node();
            newUpdater.set(node, node);
            if (node.next == node) {
                z = true;
                AVAILABLE = z;
                return;
            }
            throw new Exception();
        } catch (Throwable unused) {
            z = false;
        }
    }

    public static boolean isAvailable() {
        return AVAILABLE;
    }

    public static <T> AtomicIntegerFieldUpdater<T> newIntUpdater(Class<T> cls, String str) {
        if (AVAILABLE) {
            return AtomicIntegerFieldUpdater.newUpdater(cls, str);
        }
        return null;
    }

    public static <T, V> AtomicReferenceFieldUpdater<T, V> newRefUpdater(Class<T> cls, Class<V> cls2, String str) {
        if (AVAILABLE) {
            return AtomicReferenceFieldUpdater.newUpdater(cls, cls2, str);
        }
        return null;
    }
}
