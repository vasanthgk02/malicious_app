package com.google.firebase.encoders;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collections;
import java.util.Map;

public final class FieldDescriptor {
    public final String name;
    public final Map<Class<?>, Object> properties;

    public FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }

    public static FieldDescriptor of(String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (!this.name.equals(fieldDescriptor.name) || !this.properties.equals(fieldDescriptor.properties)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.properties.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FieldDescriptor{name=");
        outline73.append(this.name);
        outline73.append(", properties=");
        outline73.append(this.properties.values());
        outline73.append("}");
        return outline73.toString();
    }

    public FieldDescriptor(String str, Map map, AnonymousClass1 r3) {
        this.name = str;
        this.properties = map;
    }
}
