package com.cardinalcommerce.dependencies.internal.minidev.json.c;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONStyle;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONValue;

public class a implements f<Object> {
    public <E> void a(E e2, Appendable appendable, JSONStyle jSONStyle) {
        if (jSONStyle != null) {
            appendable.append('[');
            boolean z = false;
            for (Object obj : (Object[]) e2) {
                if (z) {
                    appendable.append(',');
                } else {
                    z = true;
                }
                JSONValue.writeJSONString(obj, appendable, jSONStyle);
            }
            appendable.append(']');
            return;
        }
        throw null;
    }
}
