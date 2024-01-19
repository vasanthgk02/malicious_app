package com.google.protobuf;

public final class ExtensionRegistryFactory {
    public static final Class<?> EXTENSION_REGISTRY_CLASS;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        EXTENSION_REGISTRY_CLASS = cls;
    }
}
