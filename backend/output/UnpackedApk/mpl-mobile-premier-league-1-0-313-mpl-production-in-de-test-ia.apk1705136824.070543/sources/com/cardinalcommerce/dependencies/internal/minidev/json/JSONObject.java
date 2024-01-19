package com.cardinalcommerce.dependencies.internal.minidev.json;

import com.cardinalcommerce.dependencies.internal.minidev.json.c.e;
import com.cardinalcommerce.dependencies.internal.minidev.json.c.e.AnonymousClass16;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONObject extends HashMap<String, Object> implements JSONAware, JSONAwareEx, JSONStreamAwareEx {
    public static final long serialVersionUID = -503443796854799292L;

    public JSONObject() {
    }

    public JSONObject(Map<String, ?> map) {
        super(map);
    }

    public static String escape(String str) {
        return JSONValue.escape(str);
    }

    public static String toJSONString(Map<String, ? extends Object> map, JSONStyle jSONStyle) {
        StringBuilder sb = new StringBuilder();
        try {
            writeJSON(map, sb, jSONStyle);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static void writeJSON(Map<String, ? extends Object> map, Appendable appendable, JSONStyle jSONStyle) {
        if (map == null) {
            appendable.append("null");
        } else {
            ((AnonymousClass16) e.g).a(map, appendable, jSONStyle);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeJSONKV(java.lang.String r1, java.lang.Object r2, java.lang.Appendable r3, com.cardinalcommerce.dependencies.internal.minidev.json.JSONStyle r4) {
        /*
            if (r1 != 0) goto L_0x0005
            java.lang.String r1 = "null"
            goto L_0x000d
        L_0x0005:
            com.cardinalcommerce.dependencies.internal.minidev.json.JStylerObj$MustProtect r0 = r4.mpKey
            boolean r0 = r0.mustBeProtect(r1)
            if (r0 != 0) goto L_0x0011
        L_0x000d:
            r3.append(r1)
            goto L_0x001c
        L_0x0011:
            r0 = 34
            r3.append(r0)
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue.escape(r1, r3, r4)
            r3.append(r0)
        L_0x001c:
            r1 = 58
            r3.append(r1)
            boolean r1 = r2 instanceof java.lang.String
            if (r1 == 0) goto L_0x002b
            java.lang.String r2 = (java.lang.String) r2
            r4.writeString(r3, r2)
            goto L_0x002e
        L_0x002b:
            com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue.writeJSONString(r2, r3, r4)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject.writeJSONKV(java.lang.String, java.lang.Object, java.lang.Appendable, com.cardinalcommerce.dependencies.internal.minidev.json.JSONStyle):void");
    }

    public String toJSONString() {
        return toJSONString(this, JSONValue.COMPRESSION);
    }

    public String toJSONString(JSONStyle jSONStyle) {
        return toJSONString(this, jSONStyle);
    }

    public String toString() {
        return toJSONString(this, JSONValue.COMPRESSION);
    }

    public void writeJSONString(Appendable appendable) {
        writeJSON(this, appendable, JSONValue.COMPRESSION);
    }

    public void writeJSONString(Appendable appendable, JSONStyle jSONStyle) {
        writeJSON(this, appendable, jSONStyle);
    }
}
