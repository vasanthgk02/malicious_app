package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.Map;

public class BindingValues {
    public final Map<String, Object> bindingValues;

    public BindingValues() {
        this.bindingValues = Collections.unmodifiableMap(Collections.EMPTY_MAP);
    }

    public <T> T get(String str) {
        try {
            return this.bindingValues.get(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public BindingValues(Map<String, Object> map) {
        this.bindingValues = Collections.unmodifiableMap(map);
    }
}
