package net.minidev.json.reader;

import java.io.IOException;
import net.minidev.asm.Accessor;
import net.minidev.asm.BeansAccess;
import net.minidev.asm.FieldFilter;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONUtil;

public class BeansWriterASM implements JsonWriterI<Object> {
    public <E> void writeJSONString(E e2, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        try {
            BeansAccess<P> beansAccess = BeansAccess.get(e2.getClass(), (FieldFilter) JSONUtil.JSON_SMART_FIELD_FILTER);
            appendable.append('{');
            boolean z = false;
            for (Accessor accessor : beansAccess.accs) {
                Object obj = beansAccess.get(e2, accessor.index);
                if (obj != null || !jSONStyle._ignore_null) {
                    if (z) {
                        appendable.append(',');
                    } else {
                        z = true;
                    }
                    JSONObject.writeJSONKV(accessor.fieldName, obj, appendable, jSONStyle);
                }
            }
            appendable.append('}');
        } catch (IOException e3) {
            throw e3;
        }
    }
}
