package androidx.datastore.preferences.protobuf;

import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Protobuf {
    public static final Protobuf INSTANCE = new Protobuf();
    public final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    public final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Schema<T> schema;
        Schema<T> messageSetSchema;
        Internal.checkNotNull(cls, MiPushMessage.KEY_MESSAGE_TYPE);
        Schema<T> schema2 = (Schema) this.schemaCache.get(cls);
        if (schema2 != null) {
            return schema2;
        }
        ManifestSchemaFactory manifestSchemaFactory = (ManifestSchemaFactory) this.schemaFactory;
        if (manifestSchemaFactory != null) {
            Class<GeneratedMessageLite> cls2 = GeneratedMessageLite.class;
            SchemaUtil.requireGeneratedMessage(cls);
            MessageInfo messageInfoFor = manifestSchemaFactory.messageInfoFactory.messageInfoFor(cls);
            if (messageInfoFor.isMessageSetWireFormat()) {
                if (cls2.isAssignableFrom(cls)) {
                    messageSetSchema = new MessageSetSchema<>(SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, ExtensionSchemas.LITE_SCHEMA, messageInfoFor.getDefaultInstance());
                } else {
                    UnknownFieldSchema<?, ?> unknownFieldSchema = SchemaUtil.PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
                    ExtensionSchema<?> extensionSchema = ExtensionSchemas.FULL_SCHEMA;
                    if (extensionSchema != null) {
                        messageSetSchema = new MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageInfoFor.getDefaultInstance());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                schema = messageSetSchema;
            } else {
                boolean isAssignableFrom = cls2.isAssignableFrom(cls);
                boolean z = true;
                if (isAssignableFrom) {
                    if (messageInfoFor.getSyntax() != ProtoSyntax.PROTO2) {
                        z = false;
                    }
                    if (z) {
                        schema = MessageSchema.newSchema(messageInfoFor, NewInstanceSchemas.LITE_SCHEMA, ListFieldSchema.LITE_INSTANCE, SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, ExtensionSchemas.LITE_SCHEMA, MapFieldSchemas.LITE_SCHEMA);
                    } else {
                        schema = MessageSchema.newSchema(messageInfoFor, NewInstanceSchemas.LITE_SCHEMA, ListFieldSchema.LITE_INSTANCE, SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, null, MapFieldSchemas.LITE_SCHEMA);
                    }
                } else {
                    if (messageInfoFor.getSyntax() != ProtoSyntax.PROTO2) {
                        z = false;
                    }
                    if (z) {
                        NewInstanceSchema newInstanceSchema = NewInstanceSchemas.FULL_SCHEMA;
                        ListFieldSchema listFieldSchema = ListFieldSchema.FULL_INSTANCE;
                        UnknownFieldSchema<?, ?> unknownFieldSchema2 = SchemaUtil.PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
                        ExtensionSchema<?> extensionSchema2 = ExtensionSchemas.FULL_SCHEMA;
                        if (extensionSchema2 != null) {
                            schema = MessageSchema.newSchema(messageInfoFor, newInstanceSchema, listFieldSchema, unknownFieldSchema2, extensionSchema2, MapFieldSchemas.FULL_SCHEMA);
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        schema = MessageSchema.newSchema(messageInfoFor, NewInstanceSchemas.FULL_SCHEMA, ListFieldSchema.FULL_INSTANCE, SchemaUtil.PROTO3_UNKNOWN_FIELD_SET_SCHEMA, null, MapFieldSchemas.FULL_SCHEMA);
                    }
                }
            }
            Internal.checkNotNull(cls, MiPushMessage.KEY_MESSAGE_TYPE);
            Internal.checkNotNull(schema, "schema");
            Schema putIfAbsent = this.schemaCache.putIfAbsent(cls, schema);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return schema;
        }
        throw null;
    }

    public <T> Schema<T> schemaFor(T t) {
        return schemaFor(t.getClass());
    }
}
