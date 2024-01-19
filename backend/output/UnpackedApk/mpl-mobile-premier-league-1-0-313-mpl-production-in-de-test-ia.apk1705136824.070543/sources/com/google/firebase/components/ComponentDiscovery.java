package com.google.firebase.components;

import android.app.Service;
import java.lang.reflect.InvocationTargetException;

public final class ComponentDiscovery<T> {

    public static class MetadataRegistrarNameRetriever {
        public final Class<? extends Service> discoveryService;

        public MetadataRegistrarNameRetriever(Class cls, AnonymousClass1 r2) {
            this.discoveryService = cls;
        }
    }

    public static ComponentRegistrar lambda$discoverLazy$0(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", new Object[]{str, "com.google.firebase.components.ComponentRegistrar"}));
        } catch (ClassNotFoundException unused) {
            String.format("Class %s is not an found.", new Object[]{str});
            return null;
        } catch (IllegalAccessException e2) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e2);
        } catch (InstantiationException e3) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e3);
        } catch (NoSuchMethodException e4) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e4);
        } catch (InvocationTargetException e5) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e5);
        }
    }
}
