package net.minidev.json.reader;

import java.io.IOException;
import net.minidev.json.JSONStyle;
import net.minidev.json.JSONValue;

public class ArrayWriter implements JsonWriterI<Object> {
    public <E> void writeJSONString(E e2, Appendable appendable, JSONStyle jSONStyle) throws IOException {
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
