package com.google.crypto.tink.shaded.protobuf;

public final class ExtensionRegistryFactory {
    public static final Class<?> EXTENSION_REGISTRY_CLASS;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        EXTENSION_REGISTRY_CLASS = cls;
    }
}
