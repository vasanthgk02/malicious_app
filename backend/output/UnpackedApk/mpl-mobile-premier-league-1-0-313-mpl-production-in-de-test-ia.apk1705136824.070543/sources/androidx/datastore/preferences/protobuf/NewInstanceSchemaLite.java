package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite.MethodToInvoke;

public final class NewInstanceSchemaLite implements NewInstanceSchema {
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}
