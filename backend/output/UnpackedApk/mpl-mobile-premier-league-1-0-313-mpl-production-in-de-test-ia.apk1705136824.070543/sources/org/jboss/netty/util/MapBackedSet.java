package org.jboss.netty.util;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public final class MapBackedSet<E> extends AbstractSet<E> implements Serializable {
    public static final long serialVersionUID = -6761513279741915432L;
    public final Map<E, Boolean> map;

    public MapBackedSet(Map<E, Boolean> map2) {
        this.map = map2;
    }

    public boolean add(E e2) {
        return this.map.put(e2, Boolean.TRUE) == null;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    public boolean remove(Object obj) {
        return this.map.remove(obj) != null;
    }

    public int size() {
        return this.map.size();
    }
}
