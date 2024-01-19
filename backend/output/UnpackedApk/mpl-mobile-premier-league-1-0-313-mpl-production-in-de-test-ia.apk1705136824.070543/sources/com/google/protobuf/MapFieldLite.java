package com.google.protobuf;

import com.google.protobuf.Internal.EnumLite;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    public static final MapFieldLite EMPTY_MAP_FIELD;
    public boolean isMutable = true;

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        EMPTY_MAP_FIELD = mapFieldLite;
        mapFieldLite.isMutable = false;
    }

    public MapFieldLite() {
    }

    public static int calculateHashCodeForObject(Object obj) {
        if (obj instanceof byte[]) {
            return Internal.hashCode((byte[]) obj);
        }
        if (!(obj instanceof EnumLite)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public void clear() {
        ensureMutable();
        super.clear();
    }

    public final void ensureMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    public Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005e
            java.util.Map r7 = (java.util.Map) r7
            if (r6 != r7) goto L_0x000c
        L_0x000a:
            r7 = 1
            goto L_0x005b
        L_0x000c:
            int r0 = r6.size()
            int r3 = r7.size()
            if (r0 == r3) goto L_0x0018
        L_0x0016:
            r7 = 0
            goto L_0x005b
        L_0x0018:
            java.util.Set r0 = r6.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0020:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x000a
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0037
            goto L_0x0016
        L_0x0037:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0054
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0054
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0058
        L_0x0054:
            boolean r3 = r4.equals(r3)
        L_0x0058:
            if (r3 != 0) goto L_0x0020
            goto L_0x0016
        L_0x005b:
            if (r7 == 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MapFieldLite.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += calculateHashCodeForObject(entry.getValue()) ^ calculateHashCodeForObject(entry.getKey());
        }
        return i;
    }

    public MapFieldLite<K, V> mutableCopy() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public V put(K k, V v) {
        ensureMutable();
        Internal.checkNotNull(k);
        if (v != null) {
            return super.put(k, v);
        }
        throw null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureMutable();
        for (Object next : map.keySet()) {
            Internal.checkNotNull(next);
            Internal.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public V remove(Object obj) {
        ensureMutable();
        return super.remove(obj);
    }

    public MapFieldLite(Map<K, V> map) {
        super(map);
    }
}
