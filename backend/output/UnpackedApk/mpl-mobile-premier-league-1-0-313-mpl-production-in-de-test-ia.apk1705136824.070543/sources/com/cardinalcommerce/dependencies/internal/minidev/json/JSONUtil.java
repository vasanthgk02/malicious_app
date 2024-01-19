package com.cardinalcommerce.dependencies.internal.minidev.json;

import com.cardinalcommerce.dependencies.internal.minidev.asm.FieldFilter;

public class JSONUtil {
    public static final JsonSmartFieldFilter JSON_SMART_FIELD_FILTER = new JsonSmartFieldFilter();

    public static class JsonSmartFieldFilter implements FieldFilter {
    }
}
