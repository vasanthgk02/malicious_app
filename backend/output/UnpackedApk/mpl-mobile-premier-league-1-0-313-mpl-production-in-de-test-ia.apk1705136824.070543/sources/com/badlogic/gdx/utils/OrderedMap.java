package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.ObjectMap.Keys;
import com.badlogic.gdx.utils.ObjectMap.Values;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedMap<K, V> extends ObjectMap<K, V> {
    public final Array<K> keys;

    public static class OrderedMapEntries<K, V> extends Entries<K, V> {
        public Array<K> keys;

        public OrderedMapEntries(OrderedMap<K, V> orderedMap) {
            super(orderedMap);
            this.keys = orderedMap.keys;
        }

        public void remove() {
            if (this.currentIndex >= 0) {
                this.map.remove(this.entry.key);
                this.nextIndex--;
                this.currentIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before remove.");
        }

        public void reset() {
            this.currentIndex = -1;
            boolean z = false;
            this.nextIndex = 0;
            if (this.map.size > 0) {
                z = true;
            }
            this.hasNext = z;
        }

        public Entry next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                int i = this.nextIndex;
                this.currentIndex = i;
                this.entry.key = this.keys.get(i);
                Entry<K, V> entry = this.entry;
                entry.value = this.map.get(entry.key);
                boolean z = true;
                int i2 = this.nextIndex + 1;
                this.nextIndex = i2;
                if (i2 >= this.map.size) {
                    z = false;
                }
                this.hasNext = z;
                return this.entry;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public static class OrderedMapKeys<K> extends Keys<K> {
        public Array<K> keys;

        public OrderedMapKeys(OrderedMap<K, ?> orderedMap) {
            super(orderedMap);
            this.keys = orderedMap.keys;
        }

        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                K k = this.keys.get(this.nextIndex);
                int i = this.nextIndex;
                this.currentIndex = i;
                boolean z = true;
                int i2 = i + 1;
                this.nextIndex = i2;
                if (i2 >= this.map.size) {
                    z = false;
                }
                this.hasNext = z;
                return k;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            int i = this.currentIndex;
            if (i >= 0) {
                ((OrderedMap) this.map).removeIndex(i);
                this.nextIndex = this.currentIndex;
                this.currentIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before remove.");
        }

        public void reset() {
            this.currentIndex = -1;
            boolean z = false;
            this.nextIndex = 0;
            if (this.map.size > 0) {
                z = true;
            }
            this.hasNext = z;
        }
    }

    public static class OrderedMapValues<V> extends Values<V> {
        public Array keys;

        public OrderedMapValues(OrderedMap<?, V> orderedMap) {
            super(orderedMap);
            this.keys = orderedMap.keys;
        }

        public V next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                V v = this.map.get(this.keys.get(this.nextIndex));
                int i = this.nextIndex;
                this.currentIndex = i;
                boolean z = true;
                int i2 = i + 1;
                this.nextIndex = i2;
                if (i2 >= this.map.size) {
                    z = false;
                }
                this.hasNext = z;
                return v;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            int i = this.currentIndex;
            if (i >= 0) {
                ((OrderedMap) this.map).removeIndex(i);
                this.nextIndex = this.currentIndex;
                this.currentIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before remove.");
        }

        public void reset() {
            this.currentIndex = -1;
            boolean z = false;
            this.nextIndex = 0;
            if (this.map.size > 0) {
                z = true;
            }
            this.hasNext = z;
        }
    }

    public OrderedMap() {
        this.keys = new Array<>();
    }

    public void clear() {
        this.keys.clear();
        super.clear();
    }

    public Entries<K, V> entries() {
        if (this.entries1 == null) {
            this.entries1 = new OrderedMapEntries(this);
            this.entries2 = new OrderedMapEntries(this);
        }
        Entries entries = this.entries1;
        if (!entries.valid) {
            entries.reset();
            Entries<K, V> entries2 = this.entries1;
            entries2.valid = true;
            this.entries2.valid = false;
            return entries2;
        }
        this.entries2.reset();
        Entries<K, V> entries3 = this.entries2;
        entries3.valid = true;
        this.entries1.valid = false;
        return entries3;
    }

    public Entries<K, V> iterator() {
        return entries();
    }

    public Keys<K> keys() {
        if (this.keys1 == null) {
            this.keys1 = new OrderedMapKeys(this);
            this.keys2 = new OrderedMapKeys(this);
        }
        Keys keys2 = this.keys1;
        if (!keys2.valid) {
            keys2.reset();
            Keys<K> keys3 = this.keys1;
            keys3.valid = true;
            this.keys2.valid = false;
            return keys3;
        }
        this.keys2.reset();
        Keys<K> keys4 = this.keys2;
        keys4.valid = true;
        this.keys1.valid = false;
        return keys4;
    }

    public V put(K k, V v) {
        int locateKey = locateKey(k);
        if (locateKey >= 0) {
            V[] vArr = this.valueTable;
            V v2 = vArr[locateKey];
            vArr[locateKey] = v;
            return v2;
        }
        int i = -(locateKey + 1);
        this.keyTable[i] = k;
        this.valueTable[i] = v;
        this.keys.add(k);
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.threshold) {
            resize(this.keyTable.length << 1);
        }
        return null;
    }

    public V remove(K k) {
        this.keys.removeValue(k, false);
        return super.remove(k);
    }

    public V removeIndex(int i) {
        return super.remove(this.keys.removeIndex(i));
    }

    public String toString(String str, boolean z) {
        if (this.size == 0) {
            return z ? "{}" : "";
        }
        StringBuilder sb = new StringBuilder(32);
        if (z) {
            sb.append('{');
        }
        Array<K> array = this.keys;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = array.get(i2);
            if (i2 > 0) {
                sb.append(str);
            }
            Object obj2 = "(this)";
            sb.append(obj == this ? obj2 : obj);
            sb.append('=');
            Object obj3 = get(obj);
            if (obj3 != this) {
                obj2 = obj3;
            }
            sb.append(obj2);
        }
        if (z) {
            sb.append('}');
        }
        return sb.toString();
    }

    public Values<V> values() {
        if (this.values1 == null) {
            this.values1 = new OrderedMapValues(this);
            this.values2 = new OrderedMapValues(this);
        }
        Values values = this.values1;
        if (!values.valid) {
            values.reset();
            Values<V> values2 = this.values1;
            values2.valid = true;
            this.values2.valid = false;
            return values2;
        }
        this.values2.reset();
        Values<V> values3 = this.values2;
        values3.valid = true;
        this.values1.valid = false;
        return values3;
    }

    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator m303iterator() {
        return entries();
    }

    public OrderedMap(int i) {
        super(i, 0.8f);
        this.keys = new Array<>(true, i);
    }
}
