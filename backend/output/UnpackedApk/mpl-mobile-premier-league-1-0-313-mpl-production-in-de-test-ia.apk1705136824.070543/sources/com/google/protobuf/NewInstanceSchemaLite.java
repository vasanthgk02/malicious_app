package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;

public final class NewInstanceSchemaLite implements NewInstanceSchema {
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}
