package io.hansel.visualizer.c.e;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5841a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Object, Integer> f5842b = new IdentityHashMap();

    /* renamed from: c  reason: collision with root package name */
    public int f5843c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Object> f5844d = new SparseArray<>();

    public Object a(int i) {
        synchronized (this.f5841a) {
            Object obj = this.f5844d.get(i);
            if (obj == null) {
                return null;
            }
            this.f5844d.remove(i);
            this.f5842b.remove(obj);
            d(obj);
            return obj;
        }
    }

    public boolean a(Object obj) {
        boolean containsKey;
        synchronized (this.f5841a) {
            try {
                containsKey = this.f5842b.containsKey(obj);
            }
        }
        return containsKey;
    }

    public Integer b(Object obj) {
        Integer num;
        synchronized (this.f5841a) {
            try {
                num = this.f5842b.get(obj);
            }
        }
        return num;
    }

    public void c(Object obj) {
        throw null;
    }

    public void d(Object obj) {
        throw null;
    }

    public int e(Object obj) {
        synchronized (this.f5841a) {
            Integer num = this.f5842b.get(obj);
            if (num != null) {
                int intValue = num.intValue();
                return intValue;
            }
            int i = this.f5843c;
            this.f5843c = i + 1;
            Integer valueOf = Integer.valueOf(i);
            this.f5842b.put(obj, valueOf);
            this.f5844d.put(valueOf.intValue(), obj);
            c(obj);
            return valueOf.intValue();
        }
    }
}
