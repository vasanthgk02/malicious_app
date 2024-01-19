package com.badlogic.gdx.utils.reflect;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class Field {
    public final java.lang.reflect.Field field;

    public Field(java.lang.reflect.Field field2) {
        this.field = field2;
    }

    public Object get(Object obj) throws ReflectionException {
        try {
            return this.field.get(obj);
        } catch (IllegalArgumentException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Object is not an instance of ");
            outline73.append(this.field.getDeclaringClass());
            throw new ReflectionException(outline73.toString(), e2);
        } catch (IllegalAccessException e3) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Illegal access to field: ");
            outline732.append(getName());
            throw new ReflectionException(outline732.toString(), e3);
        }
    }

    public String getName() {
        return this.field.getName();
    }

    public Class getType() {
        return this.field.getType();
    }

    public void set(Object obj, Object obj2) throws ReflectionException {
        try {
            this.field.set(obj, obj2);
        } catch (IllegalArgumentException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Argument not valid for field: ");
            outline73.append(getName());
            throw new ReflectionException(outline73.toString(), e2);
        } catch (IllegalAccessException e3) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Illegal access to field: ");
            outline732.append(getName());
            throw new ReflectionException(outline732.toString(), e3);
        }
    }
}
