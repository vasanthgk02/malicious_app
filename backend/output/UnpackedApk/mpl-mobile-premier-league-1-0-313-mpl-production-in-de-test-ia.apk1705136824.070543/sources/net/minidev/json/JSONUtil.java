package net.minidev.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minidev.asm.FieldFilter;
import net.minidev.json.annotate.JsonIgnore;

public class JSONUtil {
    public static final JsonSmartFieldFilter JSON_SMART_FIELD_FILTER = new JsonSmartFieldFilter();

    public static class JsonSmartFieldFilter implements FieldFilter {
        public boolean canUse(Field field, Method method) {
            JsonIgnore jsonIgnore = (JsonIgnore) method.getAnnotation(JsonIgnore.class);
            return jsonIgnore == null || !jsonIgnore.value();
        }
    }
}
