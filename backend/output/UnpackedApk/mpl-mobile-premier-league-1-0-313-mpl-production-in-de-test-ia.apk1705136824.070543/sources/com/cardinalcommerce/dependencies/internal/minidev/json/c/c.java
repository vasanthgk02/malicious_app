package com.cardinalcommerce.dependencies.internal.minidev.json.c;

import com.cardinalcommerce.dependencies.internal.minidev.asm.Accessor;
import com.cardinalcommerce.dependencies.internal.minidev.asm.BeansAccess;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONStyle;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONUtil;
import java.io.IOException;

public class c implements f<Object> {
    public <E> void a(E e2, Appendable appendable, JSONStyle jSONStyle) {
        try {
            BeansAccess beansAccess = BeansAccess.get(e2.getClass(), JSONUtil.JSON_SMART_FIELD_FILTER);
            appendable.append('{');
            boolean z = false;
            for (Accessor accessor : beansAccess.getAccessors()) {
                Object obj = beansAccess.get(e2, accessor.getIndex());
                if (obj != null || !jSONStyle._ignore_null) {
                    if (z) {
                        appendable.append(',');
                    } else {
                        z = true;
                    }
                    JSONObject.writeJSONKV(accessor.getName(), obj, appendable, jSONStyle);
                }
            }
            appendable.append('}');
        } catch (IOException e3) {
            throw e3;
        }
    }
}
