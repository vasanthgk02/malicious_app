package com.cardinalcommerce.dependencies.internal.minidev.json.d;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAwareEx;
import java.util.LinkedHashMap;
import java.util.Map;

public class g extends j<JSONAwareEx> {
    public g(i iVar) {
        super(iVar);
    }

    public j<JSONAwareEx> a(String str) {
        return this.s.f1942b;
    }

    public Object a() {
        return new JSONArray();
    }

    public void a(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    public void a(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    public j<JSONAwareEx> b(String str) {
        return this.s.f1942b;
    }

    public Object b() {
        return new LinkedHashMap();
    }
}
