package com.google.crypto.tink.shaded.protobuf;

public final class NewInstanceSchemas {
    public static final NewInstanceSchema FULL_SCHEMA;
    public static final NewInstanceSchema LITE_SCHEMA = new NewInstanceSchemaLite();

    static {
        NewInstanceSchema newInstanceSchema;
        try {
            newInstanceSchema = (NewInstanceSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            newInstanceSchema = null;
        }
        FULL_SCHEMA = newInstanceSchema;
    }
}
