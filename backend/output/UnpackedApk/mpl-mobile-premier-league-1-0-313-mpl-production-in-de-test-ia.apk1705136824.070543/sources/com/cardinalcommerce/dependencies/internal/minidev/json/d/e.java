package com.cardinalcommerce.dependencies.internal.minidev.json.d;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAwareEx;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;

public class e<T> extends j<T> {
    public e(i iVar) {
        super(iVar);
    }

    public j<JSONAwareEx> a(String str) {
        return this.s.f1941a;
    }

    public Object a() {
        return new JSONArray();
    }

    public void a(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    public void a(Object obj, String str, Object obj2) {
        ((JSONObject) obj).put(str, obj2);
    }

    public j<JSONAwareEx> b(String str) {
        return this.s.f1941a;
    }

    public Object b() {
        return new JSONObject();
    }
}
