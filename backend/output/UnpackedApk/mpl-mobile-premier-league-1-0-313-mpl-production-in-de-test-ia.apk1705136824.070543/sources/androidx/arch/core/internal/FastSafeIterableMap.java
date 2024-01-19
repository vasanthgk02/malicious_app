package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap.Entry;
import java.util.HashMap;

public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    public HashMap<K, Entry<K, V>> mHashMap = new HashMap<>();

    public boolean contains(K k) {
        return this.mHashMap.containsKey(k);
    }

    public Entry<K, V> get(K k) {
        return this.mHashMap.get(k);
    }

    public V putIfAbsent(K k, V v) {
        Entry entry = this.mHashMap.get(k);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k, put(k, v));
        return null;
    }

    public V remove(K k) {
        V remove = super.remove(k);
        this.mHashMap.remove(k);
        return remove;
    }
}
