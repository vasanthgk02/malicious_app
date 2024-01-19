package com.cardinalcommerce.dependencies.internal.minidev.json.d;

public abstract class j<T> {
    public final i s;

    public j(i iVar) {
        this.s = iVar;
    }

    public j<?> a(String str) {
        throw new RuntimeException("Invalid or non Implemented status" + " startArray in " + getClass() + " key=" + str);
    }

    public abstract Object a();

    public T a(Object obj) {
        return obj;
    }

    public abstract void a(Object obj, Object obj2);

    public void a(Object obj, String str, Object obj2) {
        throw new RuntimeException("Invalid or non Implemented status" + " setValue in " + getClass() + " key=" + str);
    }

    public j<?> b(String str) {
        throw new RuntimeException("Invalid or non Implemented status" + " startObject(String key) in " + getClass() + " key=" + str);
    }

    public Object b() {
        throw new RuntimeException("Invalid or non Implemented status" + " createObject() in " + getClass());
    }
}
