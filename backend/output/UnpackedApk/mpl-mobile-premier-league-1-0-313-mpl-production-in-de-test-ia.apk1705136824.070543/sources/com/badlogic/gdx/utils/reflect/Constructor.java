package com.badlogic.gdx.utils.reflect;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.InvocationTargetException;

public final class Constructor {
    public final java.lang.reflect.Constructor constructor;

    public Constructor(java.lang.reflect.Constructor constructor2) {
        this.constructor = constructor2;
    }

    public Class getDeclaringClass() {
        return this.constructor.getDeclaringClass();
    }

    public Object newInstance(Object... objArr) throws ReflectionException {
        try {
            return this.constructor.newInstance(objArr);
        } catch (IllegalArgumentException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Illegal argument(s) supplied to constructor for class: ");
            outline73.append(getDeclaringClass().getName());
            throw new ReflectionException(outline73.toString(), e2);
        } catch (InstantiationException e3) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Could not instantiate instance of class: ");
            outline732.append(getDeclaringClass().getName());
            throw new ReflectionException(outline732.toString(), e3);
        } catch (IllegalAccessException e4) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Could not instantiate instance of class: ");
            outline733.append(getDeclaringClass().getName());
            throw new ReflectionException(outline733.toString(), e4);
        } catch (InvocationTargetException e5) {
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("Exception occurred in constructor for class: ");
            outline734.append(getDeclaringClass().getName());
            throw new ReflectionException(outline734.toString(), e5);
        }
    }
}
