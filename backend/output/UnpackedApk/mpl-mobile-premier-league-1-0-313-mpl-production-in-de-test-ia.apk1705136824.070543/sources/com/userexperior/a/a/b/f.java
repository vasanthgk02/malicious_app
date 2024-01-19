package com.userexperior.a.a.b;

import com.userexperior.a.a.c.a;
import com.userexperior.a.a.i;
import com.userexperior.a.a.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Type, i<?>> f3656a;

    public f(Map<Type, i<?>> map) {
        this.f3656a = map;
    }

    private <T> o<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new o<T>() {
                public final T a() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    } catch (IllegalAccessException e4) {
                        throw new AssertionError(e4);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> o<T> a(a<T> aVar) {
        final Type type = aVar.f3726b;
        final Class<? super T> cls = aVar.f3725a;
        final i iVar = this.f3656a.get(type);
        if (iVar != null) {
            return new o<T>() {
                public final T a() {
                    return iVar.a();
                }
            };
        }
        final i iVar2 = this.f3656a.get(cls);
        if (iVar2 != null) {
            return new o<T>() {
                public final T a() {
                    return iVar2.a();
                }
            };
        }
        o<T> a2 = a(cls);
        if (a2 != null) {
            return a2;
        }
        o<T> r1 = Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new o<T>() {
            public final T a() {
                return new TreeSet();
            }
        } : EnumSet.class.isAssignableFrom(cls) ? new o<T>() {
            public final T a() {
                Type type = type;
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        return EnumSet.noneOf((Class) type2);
                    }
                    throw new m("Invalid EnumSet type: " + type.toString());
                }
                throw new m("Invalid EnumSet type: " + type.toString());
            }
        } : Set.class.isAssignableFrom(cls) ? new o<T>() {
            public final T a() {
                return new LinkedHashSet();
            }
        } : Queue.class.isAssignableFrom(cls) ? new o<T>() {
            public final T a() {
                return new ArrayDeque();
            }
        } : new o<T>() {
            public final T a() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(cls) ? ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new o<T>() {
            public final T a() {
                return new ConcurrentSkipListMap();
            }
        } : ConcurrentMap.class.isAssignableFrom(cls) ? new o<T>() {
            public final T a() {
                return new ConcurrentHashMap();
            }
        } : SortedMap.class.isAssignableFrom(cls) ? new o<T>() {
            public final T a() {
                return new TreeMap();
            }
        } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.a(((ParameterizedType) type).getActualTypeArguments()[0]).f3725a)) ? new o<T>() {
            public final T a() {
                return new j();
            }
        } : new o<T>() {
            public final T a() {
                return new LinkedHashMap();
            }
        } : null;
        return r1 != null ? r1 : new o<T>() {

            /* renamed from: d  reason: collision with root package name */
            public final t f3673d = t.a();

            public final T a() {
                try {
                    return this.f3673d.a(cls);
                } catch (Exception e2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e2);
                }
            }
        };
    }

    public final String toString() {
        return this.f3656a.toString();
    }
}
