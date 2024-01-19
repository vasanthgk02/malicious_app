package androidx.datastore.preferences.protobuf;

public final class MapFieldSchemas {
    public static final MapFieldSchema FULL_SCHEMA;
    public static final MapFieldSchema LITE_SCHEMA = new MapFieldSchemaLite();

    static {
        MapFieldSchema mapFieldSchema;
        try {
            mapFieldSchema = (MapFieldSchema) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            mapFieldSchema = null;
        }
        FULL_SCHEMA = mapFieldSchema;
    }
}
