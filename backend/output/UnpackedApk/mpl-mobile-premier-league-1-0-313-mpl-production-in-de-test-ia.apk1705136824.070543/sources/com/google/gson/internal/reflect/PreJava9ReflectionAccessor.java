package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

public final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
