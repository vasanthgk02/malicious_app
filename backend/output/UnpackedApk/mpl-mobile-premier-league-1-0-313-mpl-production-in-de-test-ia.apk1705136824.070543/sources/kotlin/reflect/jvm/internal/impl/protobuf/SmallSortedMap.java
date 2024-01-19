package kotlin.reflect.jvm.internal.impl.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public List<Entry> entryList = Collections.emptyList();
    public boolean isImmutable;
    public volatile EntrySet lazyEntrySet;
    public final int maxArraySize;
    public Map<K, V> overflowEntries = Collections.emptyMap();

    public static class EmptySet {
        public static final Iterable<Object> ITERABLE = new Iterable<Object>() {
            public Iterator<Object> iterator() {
                return EmptySet.ITERATOR;
            }
        };
        public static final Iterator<Object> ITERATOR = new Iterator<Object>() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public class Entry implements Comparable<Entry>, java.util.Map.Entry<K, V> {
        public final K key;
        public V value;

        public Entry(SmallSortedMap smallSortedMap, java.util.Map.Entry<K, V> entry) {
            V value2 = entry.getValue();
            SmallSortedMap.this = smallSortedMap;
            this.key = (Comparable) entry.getKey();
            this.value = value2;
        }

        public int compareTo(Object obj) {
            return this.key.compareTo(((Entry) obj).key);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            if (r5 != false) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r5 != r4) goto L_0x0004
                return r0
            L_0x0004:
                boolean r1 = r5 instanceof java.util.Map.Entry
                r2 = 0
                if (r1 != 0) goto L_0x000a
                return r2
            L_0x000a:
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                K r1 = r4.key
                java.lang.Object r3 = r5.getKey()
                if (r1 != 0) goto L_0x001a
                if (r3 != 0) goto L_0x0018
                r1 = 1
                goto L_0x001e
            L_0x0018:
                r1 = 0
                goto L_0x001e
            L_0x001a:
                boolean r1 = r1.equals(r3)
            L_0x001e:
                if (r1 == 0) goto L_0x0035
                V r1 = r4.value
                java.lang.Object r5 = r5.getValue()
                if (r1 != 0) goto L_0x002e
                if (r5 != 0) goto L_0x002c
                r5 = 1
                goto L_0x0032
            L_0x002c:
                r5 = 0
                goto L_0x0032
            L_0x002e:
                boolean r5 = r1.equals(r5)
            L_0x0032:
                if (r5 == 0) goto L_0x0035
                goto L_0x0036
            L_0x0035:
                r0 = 0
            L_0x0036:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap.Entry.equals(java.lang.Object):boolean");
        }

        public Object getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            K k = this.key;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            SmallSortedMap.this.checkMutable();
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.key);
            String valueOf2 = String.valueOf(this.value);
            return GeneratedOutlineSupport.outline63(new StringBuilder(valueOf2.length() + valueOf.length() + 1), valueOf, InflateView.SETTER_EQUALS, valueOf2);
        }

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public class EntryIterator implements Iterator<java.util.Map.Entry<K, V>> {
        public Iterator<java.util.Map.Entry<K, V>> lazyOverflowIterator;
        public boolean nextCalledBeforeRemove;
        public int pos = -1;

        public EntryIterator(AnonymousClass1 r2) {
        }

        public final Iterator<java.util.Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator == null) {
                this.lazyOverflowIterator = SmallSortedMap.this.overflowEntries.entrySet().iterator();
            }
            return this.lazyOverflowIterator;
        }

        public boolean hasNext() {
            if (this.pos + 1 < SmallSortedMap.this.entryList.size() || getOverflowIterator().hasNext()) {
                return true;
            }
            return false;
        }

        public Object next() {
            this.nextCalledBeforeRemove = true;
            int i = this.pos + 1;
            this.pos = i;
            if (i < SmallSortedMap.this.entryList.size()) {
                return SmallSortedMap.this.entryList.get(this.pos);
            }
            return (java.util.Map.Entry) getOverflowIterator().next();
        }

        public void remove() {
            if (this.nextCalledBeforeRemove) {
                this.nextCalledBeforeRemove = false;
                SmallSortedMap.this.checkMutable();
                if (this.pos < SmallSortedMap.this.entryList.size()) {
                    SmallSortedMap smallSortedMap = SmallSortedMap.this;
                    int i = this.pos;
                    this.pos = i - 1;
                    smallSortedMap.removeArrayEntryAt(i);
                    return;
                }
                getOverflowIterator().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    public class EntrySet extends AbstractSet<java.util.Map.Entry<K, V>> {
        public EntrySet(AnonymousClass1 r2) {
        }

        public boolean add(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            SmallSortedMap.this.clear();
        }

        public boolean contains(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new EntryIterator(null);
        }

        public boolean remove(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return SmallSortedMap.this.size();
        }
    }

    public SmallSortedMap(int i, AnonymousClass1 r2) {
        this.maxArraySize = i;
    }

    public final int binarySearchInArray(K k) {
        int size = this.entryList.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.entryList.get(size).key);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.entryList.get(i2).key);
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final void checkMutable() {
        if (this.isImmutable) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        checkMutable();
        if (!this.entryList.isEmpty()) {
            this.entryList.clear();
        }
        if (!this.overflowEntries.isEmpty()) {
            this.overflowEntries.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return binarySearchInArray(comparable) >= 0 || this.overflowEntries.containsKey(comparable);
    }

    public Set<java.util.Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet == null) {
            this.lazyEntrySet = new EntrySet<>(null);
        }
        return this.lazyEntrySet;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return this.entryList.get(binarySearchInArray).value;
        }
        return this.overflowEntries.get(comparable);
    }

    public java.util.Map.Entry<K, V> getArrayEntryAt(int i) {
        return this.entryList.get(i);
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public Iterable<java.util.Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty()) {
            return EmptySet.ITERABLE;
        }
        return this.overflowEntries.entrySet();
    }

    public final SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() && !(this.overflowEntries instanceof TreeMap)) {
            this.overflowEntries = new TreeMap();
        }
        return (SortedMap) this.overflowEntries;
    }

    public void makeImmutable() {
        if (!this.isImmutable) {
            this.overflowEntries = this.overflowEntries.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.overflowEntries);
            this.isImmutable = true;
        }
    }

    public V put(K k, V v) {
        checkMutable();
        int binarySearchInArray = binarySearchInArray(k);
        if (binarySearchInArray >= 0) {
            Entry entry = this.entryList.get(binarySearchInArray);
            SmallSortedMap.this.checkMutable();
            V v2 = entry.value;
            entry.value = v;
            return v2;
        }
        checkMutable();
        if (this.entryList.isEmpty() && !(this.entryList instanceof ArrayList)) {
            this.entryList = new ArrayList(this.maxArraySize);
        }
        int i = -(binarySearchInArray + 1);
        if (i >= this.maxArraySize) {
            return getOverflowEntriesMutable().put(k, v);
        }
        int size = this.entryList.size();
        int i2 = this.maxArraySize;
        if (size == i2) {
            Entry remove = this.entryList.remove(i2 - 1);
            getOverflowEntriesMutable().put(remove.key, remove.value);
        }
        this.entryList.add(i, new Entry(k, v));
        return null;
    }

    public V remove(Object obj) {
        checkMutable();
        Comparable comparable = (Comparable) obj;
        int binarySearchInArray = binarySearchInArray(comparable);
        if (binarySearchInArray >= 0) {
            return removeArrayEntryAt(binarySearchInArray);
        }
        if (this.overflowEntries.isEmpty()) {
            return null;
        }
        return this.overflowEntries.remove(comparable);
    }

    public final V removeArrayEntryAt(int i) {
        checkMutable();
        V v = this.entryList.remove(i).value;
        if (!this.overflowEntries.isEmpty()) {
            Iterator it = getOverflowEntriesMutable().entrySet().iterator();
            this.entryList.add(new Entry(this, (java.util.Map.Entry) it.next()));
            it.remove();
        }
        return v;
    }

    public int size() {
        return this.overflowEntries.size() + this.entryList.size();
    }
}
