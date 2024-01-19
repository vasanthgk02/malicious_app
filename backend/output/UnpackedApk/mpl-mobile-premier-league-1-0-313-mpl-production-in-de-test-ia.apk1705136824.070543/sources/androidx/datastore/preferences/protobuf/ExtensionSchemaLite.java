package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ExtensionRegistryLite.ObjectIntPair;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtensionDescriptor;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension;
import java.io.IOException;
import java.util.Map.Entry;

public final class ExtensionSchemaLite extends ExtensionSchema<ExtensionDescriptor> {
    public int extensionNumber(Entry<?, ?> entry) {
        if (((ExtensionDescriptor) entry.getKey()) != null) {
            return 0;
        }
        throw null;
    }

    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        return extensionRegistryLite.extensionsByNumber.get(new ObjectIntPair(messageLite, i));
    }

    public FieldSet<ExtensionDescriptor> getMutableExtensions(Object obj) {
        return ((ExtendableMessage) obj).ensureExtensionsAreMutable();
    }

    public <UT, UB> UB parseExtension(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<ExtensionDescriptor> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException {
        if (((GeneratedExtension) obj) != null) {
            throw null;
        }
        throw null;
    }

    public void serializeExtension(Writer writer, Entry<?, ?> entry) throws IOException {
        if (((ExtensionDescriptor) entry.getKey()) != null) {
            throw null;
        }
        throw null;
    }
}
