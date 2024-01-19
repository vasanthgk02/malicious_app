package com.badlogic.gdx.utils;

public class Pools {
    public static final ObjectMap<Class, Pool> typePools = new ObjectMap<>();

    public static void free(Object obj) {
        if (obj != null) {
            Pool pool = (Pool) typePools.get(obj.getClass());
            if (pool != null) {
                pool.free(obj);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("object cannot be null.");
    }

    public static void freeAll(Array array, boolean z) {
        if (array != null) {
            int i = array.size;
            Pool pool = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = array.get(i2);
                if (obj != null) {
                    if (pool == null) {
                        pool = (Pool) typePools.get(obj.getClass());
                        if (pool == null) {
                        }
                    }
                    pool.free(obj);
                    if (!z) {
                        pool = null;
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("objects cannot be null.");
    }

    public static <T> Pool<T> get(Class<T> cls) {
        Pool<T> pool = (Pool) typePools.get(cls);
        if (pool != null) {
            return pool;
        }
        ReflectionPool reflectionPool = new ReflectionPool(cls, 4, 100);
        typePools.put(cls, reflectionPool);
        return reflectionPool;
    }

    public static <T> T obtain(Class<T> cls) {
        return get(cls).obtain();
    }
}
