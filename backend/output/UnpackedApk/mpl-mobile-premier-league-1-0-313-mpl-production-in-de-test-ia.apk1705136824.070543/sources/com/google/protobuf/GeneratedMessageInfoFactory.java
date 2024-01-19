package com.google.protobuf;

public class GeneratedMessageInfoFactory implements MessageInfoFactory {
    public static final GeneratedMessageInfoFactory instance = new GeneratedMessageInfoFactory();

    public boolean isSupported(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.protobuf.MessageInfo messageInfoFor(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.Class<com.google.protobuf.GeneratedMessageLite> r0 = com.google.protobuf.GeneratedMessageLite.class
            boolean r1 = r0.isAssignableFrom(r4)
            if (r1 == 0) goto L_0x002a
            java.lang.Class r0 = r4.asSubclass(r0)     // Catch:{ Exception -> 0x0019 }
            com.google.protobuf.GeneratedMessageLite r0 = com.google.protobuf.GeneratedMessageLite.getDefaultInstance(r0)     // Catch:{ Exception -> 0x0019 }
            com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ Exception -> 0x0019 }
            java.lang.Object r0 = r0.dynamicMethod(r1)     // Catch:{ Exception -> 0x0019 }
            com.google.protobuf.MessageInfo r0 = (com.google.protobuf.MessageInfo) r0     // Catch:{ Exception -> 0x0019 }
            return r0
        L_0x0019:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Unable to get message info for "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r4, r2)
            r1.<init>(r4, r0)
            throw r1
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported message type: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageInfoFactory.messageInfoFor(java.lang.Class):com.google.protobuf.MessageInfo");
    }
}
