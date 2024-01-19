package kotlin.reflect.jvm.internal.pcollections;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.NoSuchElementException;

public final class HashPMap<K, V> {
    public static final HashPMap<Object, Object> EMPTY = new HashPMap<>(IntTreePMap.EMPTY, 0);
    public final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
    public final int size;

    public HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i) {
        this.intMap = intTreePMap;
        this.size = i;
    }

    public HashPMap<K, V> plus(K k, V v) {
        ConsPStack consPStack = (ConsPStack) this.intMap.root.get((long) k.hashCode());
        if (consPStack == null) {
            consPStack = ConsPStack.EMPTY;
        }
        int i = consPStack.size;
        int i2 = 0;
        ConsPStack consPStack2 = consPStack;
        while (true) {
            if (consPStack2 == null || consPStack2.size <= 0) {
                i2 = -1;
            } else if (((MapEntry) consPStack2.first).key.equals(k)) {
                break;
            } else {
                consPStack2 = consPStack2.rest;
                i2++;
            }
        }
        i2 = -1;
        if (i2 != -1) {
            if (i2 < 0 || i2 > consPStack.size) {
                throw new IndexOutOfBoundsException();
            }
            try {
                consPStack = consPStack.minus(consPStack.subList(i2).first);
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Index: ", i2));
            }
        }
        MapEntry mapEntry = new MapEntry(k, v);
        if (consPStack != null) {
            ConsPStack consPStack3 = new ConsPStack(mapEntry, consPStack);
            IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap = this.intMap;
            IntTree<V> plus = intTreePMap.root.plus((long) k.hashCode(), consPStack3);
            if (plus != intTreePMap.root) {
                intTreePMap = new IntTreePMap<>(plus);
            }
            return new HashPMap<>(intTreePMap, (this.size - i) + consPStack3.size);
        }
        throw null;
    }
}
