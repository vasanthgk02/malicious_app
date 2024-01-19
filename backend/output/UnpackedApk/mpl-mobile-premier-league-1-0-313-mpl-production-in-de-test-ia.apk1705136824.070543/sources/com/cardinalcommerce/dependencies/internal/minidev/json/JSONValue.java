package com.cardinalcommerce.dependencies.internal.minidev.json;

import com.cardinalcommerce.dependencies.internal.minidev.json.c.e;
import com.cardinalcommerce.dependencies.internal.minidev.json.c.e.a;
import com.cardinalcommerce.dependencies.internal.minidev.json.c.f;
import com.cardinalcommerce.dependencies.internal.minidev.json.d.i;
import java.util.Iterator;

public class JSONValue {
    public static JSONStyle COMPRESSION = JSONStyle.NO_COMPRESS;
    public static final i defaultReader = new i();
    public static final e defaultWriter = new e();

    public static String escape(String str) {
        JSONStyle jSONStyle = COMPRESSION;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        jSONStyle.esc.escape(str, sb);
        return sb.toString();
    }

    public static void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) {
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        f fVar = defaultWriter.l.get(cls);
        if (fVar == null) {
            if (cls.isArray()) {
                fVar = e.j;
            } else {
                e eVar = defaultWriter;
                Class<?> cls2 = obj.getClass();
                Iterator it = eVar.m.iterator();
                while (true) {
                    if (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (aVar.f1934a.isAssignableFrom(cls2)) {
                            fVar = aVar.f1935b;
                            break;
                        }
                    } else {
                        fVar = null;
                        break;
                    }
                }
                if (fVar == null) {
                    fVar = e.h;
                }
            }
            defaultWriter.a(fVar, cls);
        }
        fVar.a(obj, appendable, jSONStyle);
    }

    public static void escape(String str, Appendable appendable, JSONStyle jSONStyle) {
        if (str != null) {
            jSONStyle.esc.escape(str, appendable);
        }
    }
}
