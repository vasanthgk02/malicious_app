package androidx.datastore.preferences.protobuf;

public final class ExtensionSchemas {
    public static final ExtensionSchema<?> FULL_SCHEMA;
    public static final ExtensionSchema<?> LITE_SCHEMA = new ExtensionSchemaLite();

    static {
        ExtensionSchema<?> extensionSchema;
        try {
            extensionSchema = (ExtensionSchema) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            extensionSchema = null;
        }
        FULL_SCHEMA = extensionSchema;
    }
}
