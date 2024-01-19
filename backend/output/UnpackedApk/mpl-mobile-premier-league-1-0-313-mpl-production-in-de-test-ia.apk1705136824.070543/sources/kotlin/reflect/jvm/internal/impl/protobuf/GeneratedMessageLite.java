package kotlin.reflect.jvm.internal.impl.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyField.LazyIterator;
import kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap.EntrySet;

public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder<BuilderType> {
        public ByteString unknownFields = ByteString.EMPTY;

        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements Object<MessageType> {
        public FieldSet<ExtensionDescriptor> extensions = FieldSet.DEFAULT_INSTANCE;
        public boolean extensionsIsMutable;

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.clone();
                this.extensionsIsMutable = true;
            }
            FieldSet<ExtensionDescriptor> fieldSet = this.extensions;
            FieldSet<ExtensionDescriptor> fieldSet2 = messagetype.extensions;
            if (fieldSet != null) {
                for (int i = 0; i < fieldSet2.fields.getNumArrayEntries(); i++) {
                    fieldSet.mergeFromField(fieldSet2.fields.getArrayEntryAt(i));
                }
                for (Entry mergeFromField : fieldSet2.fields.getOverflowEntries()) {
                    fieldSet.mergeFromField(mergeFromField);
                }
                return;
            }
            throw null;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements Object<MessageType> {
        public final FieldSet<ExtensionDescriptor> extensions;

        public class ExtensionWriter {
            public final Iterator<Entry<ExtensionDescriptor, Object>> iter;
            public final boolean messageSetWireFormat;
            public Entry<ExtensionDescriptor, Object> next;

            public ExtensionWriter(boolean z, AnonymousClass1 r3) {
                Iterator<Entry<ExtensionDescriptor, Object>> it;
                FieldSet<ExtensionDescriptor> fieldSet = ExtendableMessage.this.extensions;
                if (fieldSet.hasLazyField) {
                    it = new LazyIterator<>(((EntrySet) fieldSet.fields.entrySet()).iterator());
                } else {
                    it = ((EntrySet) fieldSet.fields.entrySet()).iterator();
                }
                this.iter = it;
                if (it.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().number < i) {
                        ExtensionDescriptor key = this.next.getKey();
                        if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat$JavaType.MESSAGE || key.isRepeated) {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        } else {
                            int i2 = key.number;
                            codedOutputStream.writeTag(1, 3);
                            codedOutputStream.writeRawVarint32(16);
                            codedOutputStream.writeRawVarint32(i2);
                            codedOutputStream.writeMessage(3, (MessageLite) this.next.getValue());
                            codedOutputStream.writeTag(1, 4);
                        }
                        if (this.iter.hasNext()) {
                            this.next = this.iter.next();
                        } else {
                            this.next = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public ExtendableMessage() {
            this.extensions = new FieldSet<>();
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            FieldSet<ExtensionDescriptor> fieldSet = this.extensions;
            int i = 0;
            for (int i2 = 0; i2 < fieldSet.fields.getNumArrayEntries(); i2++) {
                Entry arrayEntryAt = fieldSet.fields.getArrayEntryAt(i2);
                i += FieldSet.computeFieldSize((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
            }
            for (Entry entry : fieldSet.fields.getOverflowEntries()) {
                i += FieldSet.computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
            }
            return i;
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type field = this.extensions.getField(generatedExtension.descriptor);
            if (field == null) {
                return generatedExtension.defaultValue;
            }
            ExtensionDescriptor extensionDescriptor = generatedExtension.descriptor;
            if (!extensionDescriptor.isRepeated) {
                field = generatedExtension.singularFromFieldSetType(field);
            } else if (extensionDescriptor.getLiteJavaType() == WireFormat$JavaType.ENUM) {
                Type arrayList = new ArrayList();
                for (Object singularFromFieldSetType : (List) field) {
                    arrayList.add(generatedExtension.singularFromFieldSetType(singularFromFieldSetType));
                }
                field = arrayList;
            }
            return field;
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            FieldSet<ExtensionDescriptor> fieldSet = this.extensions;
            ExtensionDescriptor extensionDescriptor = generatedExtension.descriptor;
            if (fieldSet == null) {
                throw null;
            } else if (!extensionDescriptor.isRepeated()) {
                return fieldSet.fields.get(extensionDescriptor) != null;
            } else {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
        }

        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter<>(false, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r9, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r10, int r11) throws java.io.IOException {
            /*
                r7 = this;
                kotlin.reflect.jvm.internal.impl.protobuf.FieldSet<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r7.extensions
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r1 = r7.getDefaultInstanceForType()
                r2 = r11 & 7
                int r3 = r11 >>> 3
                java.util.Map<kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite$ObjectIntPair, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<?, ?>> r4 = r10.extensionsByNumber
                kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite$ObjectIntPair r5 = new kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite$ObjectIntPair
                r5.<init>(r1, r3)
                java.lang.Object r1 = r4.get(r5)
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r1 = (kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension) r1
                r3 = 1
                r4 = 0
                if (r1 != 0) goto L_0x001c
                goto L_0x0043
            L_0x001c:
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r5 = r5.type
                int r5 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.getWireFormatForFieldType(r5, r4)
                if (r2 != r5) goto L_0x0028
                r2 = 0
                goto L_0x0044
            L_0x0028:
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r1.descriptor
                boolean r6 = r5.isRepeated
                if (r6 == 0) goto L_0x0043
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r5 = r5.type
                boolean r5 = r5.isPackable()
                if (r5 == 0) goto L_0x0043
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r5 = r5.type
                int r5 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.getWireFormatForFieldType(r5, r3)
                if (r2 != r5) goto L_0x0043
                r2 = 0
                r5 = 1
                goto L_0x0045
            L_0x0043:
                r2 = 1
            L_0x0044:
                r5 = 0
            L_0x0045:
                if (r2 == 0) goto L_0x004d
                boolean r3 = r8.skipField(r11, r9)
                goto L_0x0152
            L_0x004d:
                if (r5 == 0) goto L_0x009a
                int r9 = r8.readRawVarint32()
                int r9 = r8.pushLimit(r9)
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r10 = r10.type
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r11 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType.ENUM
                if (r10 != r11) goto L_0x007f
            L_0x005f:
                int r10 = r8.getBytesUntilLimit()
                if (r10 <= 0) goto L_0x0093
                int r10 = r8.readRawVarint32()
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r11 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap<?> r11 = r11.enumTypeMap
                kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite r10 = r11.findValueByNumber(r10)
                if (r10 != 0) goto L_0x0075
                goto L_0x0152
            L_0x0075:
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r11 = r1.descriptor
                java.lang.Object r10 = r1.singularToFieldSetType(r10)
                r0.addRepeatedField(r11, r10)
                goto L_0x005f
            L_0x007f:
                int r10 = r8.getBytesUntilLimit()
                if (r10 <= 0) goto L_0x0093
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r10 = r10.type
                java.lang.Object r10 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.readPrimitiveField(r8, r10, r4)
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r11 = r1.descriptor
                r0.addRepeatedField(r11, r10)
                goto L_0x007f
            L_0x0093:
                r8.currentLimit = r9
                r8.recomputeBufferSizeAfterLimit()
                goto L_0x0152
            L_0x009a:
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r2 = r2.getLiteJavaType()
                int r2 = r2.ordinal()
                r5 = 7
                if (r2 == r5) goto L_0x0127
                r9 = 8
                if (r2 == r9) goto L_0x00b5
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r9 = r9.type
                java.lang.Object r8 = kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.readPrimitiveField(r8, r9, r4)
                goto L_0x013d
            L_0x00b5:
                r9 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r11 = r1.descriptor
                boolean r2 = r11.isRepeated
                if (r2 != 0) goto L_0x00c8
                java.lang.Object r11 = r0.getField(r11)
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r11 = (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) r11
                if (r11 == 0) goto L_0x00c8
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder r9 = r11.toBuilder()
            L_0x00c8:
                if (r9 != 0) goto L_0x00d0
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r9 = r1.messageDefaultInstance
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder r9 = r9.newBuilderForType()
            L_0x00d0:
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r11 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r2 = r11.type
                kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r5 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType.GROUP
                if (r2 != r5) goto L_0x00f9
                int r11 = r11.number
                int r2 = r8.recursionDepth
                int r4 = r8.recursionLimit
                if (r2 >= r4) goto L_0x00f4
                int r2 = r2 + r3
                r8.recursionDepth = r2
                r9.mergeFrom(r8, r10)
                int r10 = r11 << 3
                r10 = r10 | 4
                r8.checkLastTagWas(r10)
                int r10 = r8.recursionDepth
                int r10 = r10 + -1
                r8.recursionDepth = r10
                goto L_0x011d
            L_0x00f4:
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r8 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.recursionLimitExceeded()
                throw r8
            L_0x00f9:
                int r11 = r8.readRawVarint32()
                int r2 = r8.recursionDepth
                int r5 = r8.recursionLimit
                if (r2 >= r5) goto L_0x0122
                int r11 = r8.pushLimit(r11)
                int r2 = r8.recursionDepth
                int r2 = r2 + r3
                r8.recursionDepth = r2
                r9.mergeFrom(r8, r10)
                r8.checkLastTagWas(r4)
                int r10 = r8.recursionDepth
                int r10 = r10 + -1
                r8.recursionDepth = r10
                r8.currentLimit = r11
                r8.recomputeBufferSizeAfterLimit()
            L_0x011d:
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8 = r9.build()
                goto L_0x013d
            L_0x0122:
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r8 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.recursionLimitExceeded()
                throw r8
            L_0x0127:
                int r8 = r8.readRawVarint32()
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r1.descriptor
                kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap<?> r10 = r10.enumTypeMap
                kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite r10 = r10.findValueByNumber(r8)
                if (r10 != 0) goto L_0x013c
                r9.writeRawVarint32(r11)
                r9.writeRawVarint32(r8)
                goto L_0x0152
            L_0x013c:
                r8 = r10
            L_0x013d:
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r1.descriptor
                boolean r10 = r9.isRepeated
                if (r10 == 0) goto L_0x014b
                java.lang.Object r8 = r1.singularToFieldSetType(r8)
                r0.addRepeatedField(r9, r8)
                goto L_0x0152
            L_0x014b:
                java.lang.Object r8 = r1.singularToFieldSetType(r8)
                r0.setField(r9, r8)
            L_0x0152:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, int):boolean");
        }

        public final void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.containingTypeDefaultInstance != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            extendableBuilder.extensions.makeImmutable();
            extendableBuilder.extensionsIsMutable = false;
            this.extensions = extendableBuilder.extensions;
        }
    }

    public static final class ExtensionDescriptor implements FieldDescriptorLite<ExtensionDescriptor> {
        public final EnumLiteMap<?> enumTypeMap;
        public final boolean isPacked;
        public final boolean isRepeated;
        public final int number;
        public final WireFormat$FieldType type;

        public ExtensionDescriptor(EnumLiteMap<?> enumLiteMap, int i, WireFormat$FieldType wireFormat$FieldType, boolean z, boolean z2) {
            this.enumTypeMap = enumLiteMap;
            this.number = i;
            this.type = wireFormat$FieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        public int compareTo(Object obj) {
            return this.number - ((ExtensionDescriptor) obj).number;
        }

        public WireFormat$JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public WireFormat$FieldType getLiteType() {
            return this.type;
        }

        public int getNumber() {
            return this.number;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder internalMergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public boolean isPacked() {
            return this.isPacked;
        }

        public boolean isRepeated() {
            return this.isRepeated;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        public final ContainingType containingTypeDefaultInstance;
        public final Type defaultValue;
        public final ExtensionDescriptor descriptor;
        public final Method enumValueOf;
        public final MessageLite messageDefaultInstance;

        public GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.type == WireFormat$FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
                if (EnumLite.class.isAssignableFrom(cls)) {
                    try {
                        this.enumValueOf = cls.getMethod("valueOf", new Class[]{Integer.TYPE});
                    } catch (NoSuchMethodException e2) {
                        String name = cls.getName();
                        StringBuilder sb = new StringBuilder(name.length() + 45 + 7);
                        GeneratedOutlineSupport.outline103(sb, "Generated message class \"", name, "\" missing method \"", "valueOf");
                        sb.append("\".");
                        throw new RuntimeException(sb.toString(), e2);
                    }
                } else {
                    this.enumValueOf = null;
                }
            }
        }

        public Object singularFromFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() != WireFormat$JavaType.ENUM) {
                return obj;
            }
            try {
                return this.enumValueOf.invoke(null, new Object[]{(Integer) obj});
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

        public Object singularToFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == WireFormat$JavaType.ENUM ? Integer.valueOf(((EnumLite) obj).getNumber()) : obj;
        }
    }

    public GeneratedMessageLite() {
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, EnumLiteMap<?> enumLiteMap, int i, WireFormat$FieldType wireFormat$FieldType, boolean z, Class cls) {
        List emptyList = Collections.emptyList();
        ExtensionDescriptor extensionDescriptor = new ExtensionDescriptor(null, i, wireFormat$FieldType, true, z);
        GeneratedExtension generatedExtension = new GeneratedExtension(containingtype, emptyList, messageLite, extensionDescriptor, cls);
        return generatedExtension;
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, EnumLiteMap<?> enumLiteMap, int i, WireFormat$FieldType wireFormat$FieldType, Class cls) {
        ExtensionDescriptor extensionDescriptor = new ExtensionDescriptor(null, i, wireFormat$FieldType, false, false);
        GeneratedExtension generatedExtension = new GeneratedExtension(containingtype, type, messageLite, extensionDescriptor, cls);
        return generatedExtension;
    }

    public GeneratedMessageLite(Builder builder) {
    }
}
