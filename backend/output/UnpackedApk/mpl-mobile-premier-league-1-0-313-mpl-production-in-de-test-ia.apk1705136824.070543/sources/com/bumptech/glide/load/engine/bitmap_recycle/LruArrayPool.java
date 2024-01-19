package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {
    public final Map<Class<?>, ArrayAdapterInterface<?>> adapters = new HashMap();
    public int currentSize;
    public final GroupedLinkedMap<Key, Object> groupedMap = new GroupedLinkedMap<>();
    public final KeyPool keyPool = new KeyPool();
    public final int maxSize;
    public final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    public static final class Key implements Poolable {
        public Class<?> arrayClass;
        public final KeyPool pool;
        public int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.size == key.size && this.arrayClass == key.arrayClass) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = this.size * 31;
            Class<?> cls = this.arrayClass;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Key{size=");
            outline73.append(this.size);
            outline73.append("array=");
            outline73.append(this.arrayClass);
            outline73.append('}');
            return outline73.toString();
        }
    }

    public static final class KeyPool extends BaseKeyPool<Key> {
        public Poolable create() {
            return new Key(this);
        }

        public Key get(int i, Class<?> cls) {
            Key key = (Key) get();
            key.size = i;
            key.arrayClass = cls;
            return key;
        }
    }

    public LruArrayPool(int i) {
        this.maxSize = i;
    }

    public synchronized void clearMemory() {
        evictToSize(0);
    }

    public final void decrementArrayOfSize(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
        Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            sizesForAdapter.remove(Integer.valueOf(i));
        } else {
            sizesForAdapter.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void evictToSize(int i) {
        while (this.currentSize > i) {
            Object removeLast = this.groupedMap.removeLast();
            k.checkNotNull(removeLast, (String) "Argument must not be null");
            ArrayAdapterInterface<?> adapterFromType = getAdapterFromType(removeLast.getClass());
            this.currentSize -= adapterFromType.getElementSizeInBytes() * adapterFromType.getArrayLength(removeLast);
            decrementArrayOfSize(adapterFromType.getArrayLength(removeLast), removeLast.getClass());
            if (Log.isLoggable(adapterFromType.getTag(), 2)) {
                adapterFromType.getTag();
                adapterFromType.getArrayLength(removeLast);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T get(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.getSizesForAdapter(r7)     // Catch:{ all -> 0x004d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch:{ all -> 0x004d }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x004d }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002c
            int r3 = r5.currentSize     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x0020
            int r4 = r5.maxSize     // Catch:{ all -> 0x004d }
            int r4 = r4 / r3
            r3 = 2
            if (r4 < r3) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r3 = 0
            goto L_0x0021
        L_0x0020:
            r3 = 1
        L_0x0021:
            if (r3 != 0) goto L_0x002d
            int r3 = r0.intValue()     // Catch:{ all -> 0x004d }
            int r4 = r6 * 8
            if (r3 > r4) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            if (r1 == 0) goto L_0x003a
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$KeyPool r6 = r5.keyPool     // Catch:{ all -> 0x004d }
            int r0 = r0.intValue()     // Catch:{ all -> 0x004d }
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$Key r6 = r6.get(r0, r7)     // Catch:{ all -> 0x004d }
            goto L_0x0047
        L_0x003a:
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$KeyPool r0 = r5.keyPool     // Catch:{ all -> 0x004d }
            com.bumptech.glide.load.engine.bitmap_recycle.Poolable r0 = r0.get()     // Catch:{ all -> 0x004d }
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$Key r0 = (com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.Key) r0     // Catch:{ all -> 0x004d }
            r0.size = r6     // Catch:{ all -> 0x004d }
            r0.arrayClass = r7     // Catch:{ all -> 0x004d }
            r6 = r0
        L_0x0047:
            java.lang.Object r6 = r5.getForKey(r6, r7)     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            return r6
        L_0x004d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool.get(int, java.lang.Class):java.lang.Object");
    }

    public final <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = this.adapters.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter<>();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter<>();
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("No array pool found for: ");
                outline73.append(cls.getSimpleName());
                throw new IllegalArgumentException(outline73.toString());
            }
            this.adapters.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    public synchronized <T> T getExact(int i, Class<T> cls) {
        Key key;
        key = (Key) this.keyPool.get();
        key.size = i;
        key.arrayClass = cls;
        return getForKey(key, cls);
    }

    public final <T> T getForKey(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T t = this.groupedMap.get(key);
        if (t != null) {
            this.currentSize -= adapterFromType.getElementSizeInBytes() * adapterFromType.getArrayLength(t);
            decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(adapterFromType.getTag(), 2)) {
            adapterFromType.getTag();
        }
        return adapterFromType.newArray(key.size);
    }

    public final NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        ArrayAdapterInterface<?> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        int i = 1;
        if (elementSizeInBytes <= this.maxSize / 2) {
            Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t);
            NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
            Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(key.size));
            Integer valueOf = Integer.valueOf(key.size);
            if (num != null) {
                i = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, Integer.valueOf(i));
            this.currentSize += elementSizeInBytes;
            evictToSize(this.maxSize);
        }
    }

    public synchronized void trimMemory(int i) {
        if (i >= 40) {
            synchronized (this) {
                evictToSize(0);
            }
        } else if (i >= 20 || i == 15) {
            evictToSize(this.maxSize / 2);
        }
    }
}
