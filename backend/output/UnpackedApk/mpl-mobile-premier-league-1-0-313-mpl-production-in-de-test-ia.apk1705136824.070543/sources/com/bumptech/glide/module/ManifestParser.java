package com.bumptech.glide.module;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.InvocationTargetException;

@Deprecated
public final class ManifestParser {
    public static GlideModule parseModule(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof GlideModule) {
                    return (GlideModule) newInstance;
                }
                throw new RuntimeException(GeneratedOutlineSupport.outline48("Expected instanceof GlideModule, but found: ", newInstance));
            } catch (InstantiationException e2) {
                throwInstantiateGlideModuleException(cls, e2);
                throw null;
            } catch (IllegalAccessException e3) {
                throwInstantiateGlideModuleException(cls, e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                throwInstantiateGlideModuleException(cls, e4);
                throw null;
            } catch (InvocationTargetException e5) {
                throwInstantiateGlideModuleException(cls, e5);
                throw null;
            }
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    public static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
