package com.google.protobuf;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal.ProtobufList;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    public static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    public int memoizedSerializedSize = -1;
    public UnknownFieldSetLite unknownFields = UnknownFieldSetLite.DEFAULT_INSTANCE;

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends com.google.protobuf.AbstractMessageLite.Builder<MessageType, BuilderType> {
        public final MessageType defaultInstance;
        public MessageType instance;
        public boolean isBuilt = false;

        public Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (GeneratedMessageLite) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            MessageType messagetype = this.instance;
            if (messagetype != null) {
                Protobuf.INSTANCE.schemaFor(messagetype).makeImmutable(messagetype);
                this.isBuilt = true;
                return this.instance;
            }
            throw null;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder newBuilderForType = this.defaultInstance.newBuilderForType();
            newBuilderForType.mergeFrom(buildPartial());
            return newBuilderForType;
        }

        public final void copyOnWrite() {
            if (this.isBuilt) {
                MessageType messagetype = (GeneratedMessageLite) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                Protobuf.INSTANCE.schemaFor(messagetype).mergeFrom(messagetype, this.instance);
                this.instance = messagetype;
                this.isBuilt = false;
            }
        }

        public MessageLite getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            MessageType messagetype2 = this.instance;
            Protobuf.INSTANCE.schemaFor(messagetype2).mergeFrom(messagetype2, messagetype);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                Protobuf.INSTANCE.schemaFor(this.instance).mergeFrom(this.instance, bArr, i, i + i2, new ArrayDecoders$Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        public com.google.protobuf.AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            copyOnWrite();
            try {
                Schema schemaFor = Protobuf.INSTANCE.schemaFor(this.instance);
                MessageType messagetype = this.instance;
                CodedInputStreamReader codedInputStreamReader = codedInputStream.wrapper;
                if (codedInputStreamReader == null) {
                    codedInputStreamReader = new CodedInputStreamReader(codedInputStream);
                }
                schemaFor.mergeFrom(messagetype, codedInputStreamReader, extensionRegistryLite);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }
    }

    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        public final T defaultInstance;

        public DefaultInstanceBasedParser(T t) {
            this.defaultInstance = t;
        }

        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) this.defaultInstance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            try {
                Schema schemaFor = Protobuf.INSTANCE.schemaFor(generatedMessageLite);
                CodedInputStreamReader codedInputStreamReader = codedInputStream.wrapper;
                if (codedInputStreamReader == null) {
                    codedInputStreamReader = new CodedInputStreamReader(codedInputStream);
                }
                schemaFor.mergeFrom(generatedMessageLite, codedInputStreamReader, extensionRegistryLite);
                schemaFor.makeImmutable(generatedMessageLite);
                return generatedMessageLite;
            } catch (IOException e2) {
                if (e2.getCause() instanceof InvalidProtocolBufferException) {
                    throw ((InvalidProtocolBufferException) e2.getCause());
                }
                throw new InvalidProtocolBufferException(e2.getMessage());
            } catch (RuntimeException e3) {
                if (e3.getCause() instanceof InvalidProtocolBufferException) {
                    throw ((InvalidProtocolBufferException) e3.getCause());
                }
                throw e3;
            }
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements Object<MessageType, BuilderType> {
        public FieldSet<ExtensionDescriptor> extensions = FieldSet.DEFAULT_INSTANCE;

        public FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> fieldSet = this.extensions;
            if (fieldSet.isImmutable) {
                this.extensions = fieldSet.clone();
            }
            return this.extensions;
        }

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ com.google.protobuf.MessageLite.Builder newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public com.google.protobuf.MessageLite.Builder toBuilder() {
            Builder builder = (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
            builder.copyOnWrite();
            MessageType messagetype = builder.instance;
            Protobuf.INSTANCE.schemaFor(messagetype).mergeFrom(messagetype, this);
            return builder;
        }
    }

    public static final class ExtensionDescriptor implements FieldDescriptorLite<ExtensionDescriptor> {
        public final int number;

        public int compareTo(Object obj) {
            return 0 - ((ExtensionDescriptor) obj).number;
        }

        public WireFormat$JavaType getLiteJavaType() {
            throw null;
        }

        public WireFormat$FieldType getLiteType() {
            return null;
        }

        public int getNumber() {
            return 0;
        }

        public com.google.protobuf.MessageLite.Builder internalMergeFrom(com.google.protobuf.MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public boolean isPacked() {
            return false;
        }

        public boolean isRepeated() {
            return false;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        public final ExtensionDescriptor descriptor;
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        T t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = ((GeneratedMessageLite) UnsafeUtil.allocateInstance(cls)).getDefaultInstanceForType();
            if (t != null) {
                defaultInstanceMap.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <E> ProtobufList<E> mutableCopy(ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Protobuf.INSTANCE.schemaFor(this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Protobuf.INSTANCE.schemaFor(this).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = Protobuf.INSTANCE.schemaFor(this).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public com.google.protobuf.MessageLite.Builder toBuilder() {
        Builder builder = (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        builder.copyOnWrite();
        MessageType messagetype = builder.instance;
        Protobuf.INSTANCE.schemaFor(messagetype).mergeFrom(messagetype, this);
        return builder;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        TextAppearanceConfig.reflectivePrintWithIndent((MessageLite) this, sb, 0);
        return sb.toString();
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Schema schemaFor = Protobuf.INSTANCE.schemaFor(this);
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        if (codedOutputStreamWriter == null) {
            codedOutputStreamWriter = new CodedOutputStreamWriter(codedOutputStream);
        }
        schemaFor.writeTo(this, codedOutputStreamWriter);
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = Protobuf.INSTANCE.schemaFor(t).isInitialized(t);
        if (z) {
            t.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? t : null, null);
        }
        return isInitialized;
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }
}
