package com.cardinalcommerce.dependencies.internal.minidev.json.b;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAwareEx;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue;
import com.cardinalcommerce.dependencies.internal.minidev.json.d.i;
import com.cardinalcommerce.dependencies.internal.minidev.json.d.j;
import java.io.IOException;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public int f1918b;

    /* renamed from: f  reason: collision with root package name */
    public h f1919f;

    static {
        String property = System.getProperty("JSON_SMART_SIMPLE");
    }

    public a(int i) {
        this.f1918b = i;
    }

    public Object a(String str) {
        if (this.f1919f == null) {
            this.f1919f = new h(this.f1918b);
        }
        h hVar = this.f1919f;
        if (hVar != null) {
            j<JSONAwareEx> jVar = JSONValue.defaultReader.f1941a;
            i iVar = jVar.s;
            hVar.x = str;
            hVar.w = str.length();
            hVar.k = -1;
            try {
                hVar.d();
                Object c2 = hVar.c(jVar);
                if (hVar.q) {
                    if (!hVar.r) {
                        hVar.j();
                    }
                    if (hVar.f1924a != 26) {
                        throw new i(hVar.k - 1, 1, Character.valueOf(hVar.f1924a));
                    }
                }
                hVar.j = null;
                hVar.i = null;
                return c2;
            } catch (IOException e2) {
                throw new i(hVar.k, e2);
            }
        } else {
            throw null;
        }
    }
}
