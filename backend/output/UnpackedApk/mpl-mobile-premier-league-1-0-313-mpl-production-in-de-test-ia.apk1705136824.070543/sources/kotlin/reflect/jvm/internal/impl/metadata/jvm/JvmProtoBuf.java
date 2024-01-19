package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType;

public final class JvmProtoBuf {
    public static final GeneratedExtension<ProtoBuf$Class, Integer> anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Class.defaultInstance, Integer.valueOf(0), null, null, 103, WireFormat$FieldType.INT32, Integer.class);
    public static final GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Property>> classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Class.defaultInstance, ProtoBuf$Property.defaultInstance, null, 102, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Property.class);
    public static final GeneratedExtension<ProtoBuf$Class, Integer> classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Class.defaultInstance, Integer.valueOf(0), null, null, 101, WireFormat$FieldType.INT32, Integer.class);
    public static final GeneratedExtension<ProtoBuf$Constructor, JvmMethodSignature> constructorSignature;
    public static final GeneratedExtension<ProtoBuf$Property, Integer> flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Property.defaultInstance, Integer.valueOf(0), null, null, 101, WireFormat$FieldType.INT32, Integer.class);
    public static final GeneratedExtension<ProtoBuf$Type, Boolean> isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Type.defaultInstance, Boolean.FALSE, null, null, 101, WireFormat$FieldType.BOOL, Boolean.class);
    public static final GeneratedExtension<ProtoBuf$Class, Integer> jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Class.defaultInstance, Integer.valueOf(0), null, null, 104, WireFormat$FieldType.INT32, Integer.class);
    public static final GeneratedExtension<ProtoBuf$Function, Integer> lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Function.defaultInstance, Integer.valueOf(0), null, null, 101, WireFormat$FieldType.INT32, Integer.class);
    public static final GeneratedExtension<ProtoBuf$Function, JvmMethodSignature> methodSignature;
    public static final GeneratedExtension<ProtoBuf$Package, List<ProtoBuf$Property>> packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Package.defaultInstance, ProtoBuf$Property.defaultInstance, null, 102, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Property.class);
    public static final GeneratedExtension<ProtoBuf$Package, Integer> packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Package.defaultInstance, Integer.valueOf(0), null, null, 101, WireFormat$FieldType.INT32, Integer.class);
    public static final GeneratedExtension<ProtoBuf$Property, JvmPropertySignature> propertySignature;
    public static final GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Type.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, 100, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);
    public static final GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$TypeParameter.defaultInstance, ProtoBuf$Annotation.defaultInstance, null, 100, WireFormat$FieldType.MESSAGE, false, ProtoBuf$Annotation.class);

    public static final class JvmFieldSignature extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<JvmFieldSignature> PARSER = new AbstractParser<JvmFieldSignature>() {
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(codedInputStream, extensionRegistryLite, null);
            }
        };
        public static final JvmFieldSignature defaultInstance;
        public int bitField0_;
        public int desc_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public int name_;
        public final ByteString unknownFields;

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements Object {
            public int bitField0_;
            public int desc_;
            public int name_;

            public MessageLite build() {
                JvmFieldSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException();
            }

            public JvmFieldSignature buildPartial() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmFieldSignature.name_ = this.name_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmFieldSignature.desc_ = this.desc_;
                jvmFieldSignature.bitField0_ = i2;
                return jvmFieldSignature;
            }

            public Object clone() throws CloneNotSupportedException {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public GeneratedMessageLite getDefaultInstanceForType() {
                return JvmFieldSignature.defaultInstance;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.defaultInstance) {
                    return this;
                }
                boolean z = true;
                if ((jvmFieldSignature.bitField0_ & 1) == 1) {
                    int i = jvmFieldSignature.name_;
                    this.bitField0_ |= 1;
                    this.name_ = i;
                }
                if ((jvmFieldSignature.bitField0_ & 2) != 2) {
                    z = false;
                }
                if (z) {
                    int i2 = jvmFieldSignature.desc_;
                    this.bitField0_ |= 2;
                    this.desc_ = i2;
                }
                this.unknownFields = this.unknownFields.concat(jvmFieldSignature.unknownFields);
                return this;
            }

            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public MessageLite m958getDefaultInstanceForType() {
                return JvmFieldSignature.defaultInstance;
            }

            /* renamed from: clone  reason: collision with other method in class */
            public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m957clone() {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                mergeFrom((JvmFieldSignature) generatedMessageLite);
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmFieldSignature jvmFieldSignature;
                JvmFieldSignature jvmFieldSignature2 = null;
                try {
                    JvmFieldSignature jvmFieldSignature3 = (JvmFieldSignature) JvmFieldSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (jvmFieldSignature3 != null) {
                        mergeFrom(jvmFieldSignature3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    jvmFieldSignature = (JvmFieldSignature) e2.unfinishedMessage;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    jvmFieldSignature2 = jvmFieldSignature;
                }
                if (jvmFieldSignature2 != null) {
                    mergeFrom(jvmFieldSignature2);
                }
                throw th;
            }
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature();
            defaultInstance = jvmFieldSignature;
            jvmFieldSignature.name_ = 0;
            jvmFieldSignature.desc_ = 0;
        }

        public JvmFieldSignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, AnonymousClass1 r2) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.unknownFields;
        }

        public MessageLite getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + i2;
            this.memoizedSerializedSize = size;
            return size;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder newBuilderForType() {
            return new Builder();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
            Builder builder = new Builder();
            builder.mergeFrom(this);
            return builder;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public JvmFieldSignature() {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public JvmFieldSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r7) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            boolean z = false;
            this.name_ = 0;
            this.desc_ = 0;
            Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.readRawVarint32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.desc_ = codedInputStream.readRawVarint32();
                        } else if (!codedInputStream.skipField(readTag, newInstance)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    e2.unfinishedMessage = this;
                    throw e2;
                } catch (IOException e3) {
                    InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e3.getMessage());
                    invalidProtocolBufferException.unfinishedMessage = this;
                    throw invalidProtocolBufferException;
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
        }
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<JvmMethodSignature> PARSER = new AbstractParser<JvmMethodSignature>() {
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(codedInputStream, extensionRegistryLite, null);
            }
        };
        public static final JvmMethodSignature defaultInstance;
        public int bitField0_;
        public int desc_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public int name_;
        public final ByteString unknownFields;

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements Object {
            public int bitField0_;
            public int desc_;
            public int name_;

            public MessageLite build() {
                JvmMethodSignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException();
            }

            public JvmMethodSignature buildPartial() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmMethodSignature.name_ = this.name_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmMethodSignature.desc_ = this.desc_;
                jvmMethodSignature.bitField0_ = i2;
                return jvmMethodSignature;
            }

            public Object clone() throws CloneNotSupportedException {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public GeneratedMessageLite getDefaultInstanceForType() {
                return JvmMethodSignature.defaultInstance;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.defaultInstance) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    int i = jvmMethodSignature.name_;
                    this.bitField0_ |= 1;
                    this.name_ = i;
                }
                if (jvmMethodSignature.hasDesc()) {
                    int i2 = jvmMethodSignature.desc_;
                    this.bitField0_ |= 2;
                    this.desc_ = i2;
                }
                this.unknownFields = this.unknownFields.concat(jvmMethodSignature.unknownFields);
                return this;
            }

            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public MessageLite m960getDefaultInstanceForType() {
                return JvmMethodSignature.defaultInstance;
            }

            /* renamed from: clone  reason: collision with other method in class */
            public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m959clone() {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                mergeFrom((JvmMethodSignature) generatedMessageLite);
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmMethodSignature jvmMethodSignature;
                JvmMethodSignature jvmMethodSignature2 = null;
                try {
                    JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) JvmMethodSignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (jvmMethodSignature3 != null) {
                        mergeFrom(jvmMethodSignature3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    jvmMethodSignature = (JvmMethodSignature) e2.unfinishedMessage;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    jvmMethodSignature2 = jvmMethodSignature;
                }
                if (jvmMethodSignature2 != null) {
                    mergeFrom(jvmMethodSignature2);
                }
                throw th;
            }
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature();
            defaultInstance = jvmMethodSignature;
            jvmMethodSignature.name_ = 0;
            jvmMethodSignature.desc_ = 0;
        }

        public JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, AnonymousClass1 r2) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.unknownFields;
        }

        public static Builder newBuilder(JvmMethodSignature jvmMethodSignature) {
            Builder builder = new Builder();
            builder.mergeFrom(jvmMethodSignature);
            return builder;
        }

        public MessageLite getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + i2;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder newBuilderForType() {
            return new Builder();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
            return newBuilder(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public JvmMethodSignature() {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public JvmMethodSignature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r7) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            boolean z = false;
            this.name_ = 0;
            this.desc_ = 0;
            Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.name_ = codedInputStream.readRawVarint32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.desc_ = codedInputStream.readRawVarint32();
                        } else if (!codedInputStream.skipField(readTag, newInstance)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    e2.unfinishedMessage = this;
                    throw e2;
                } catch (IOException e3) {
                    InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e3.getMessage());
                    invalidProtocolBufferException.unfinishedMessage = this;
                    throw invalidProtocolBufferException;
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    throw th;
                }
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
        }
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<JvmPropertySignature> PARSER = new AbstractParser<JvmPropertySignature>() {
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(codedInputStream, extensionRegistryLite, null);
            }
        };
        public static final JvmPropertySignature defaultInstance;
        public int bitField0_;
        public JvmFieldSignature field_;
        public JvmMethodSignature getter_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public JvmMethodSignature setter_;
        public JvmMethodSignature syntheticMethod_;
        public final ByteString unknownFields;

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements Object {
            public int bitField0_;
            public JvmFieldSignature field_ = JvmFieldSignature.defaultInstance;
            public JvmMethodSignature getter_;
            public JvmMethodSignature setter_;
            public JvmMethodSignature syntheticMethod_;

            public Builder() {
                JvmMethodSignature jvmMethodSignature = JvmMethodSignature.defaultInstance;
                this.syntheticMethod_ = jvmMethodSignature;
                this.getter_ = jvmMethodSignature;
                this.setter_ = jvmMethodSignature;
            }

            public MessageLite build() {
                JvmPropertySignature buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException();
            }

            public JvmPropertySignature buildPartial() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmPropertySignature.field_ = this.field_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmPropertySignature.syntheticMethod_ = this.syntheticMethod_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                jvmPropertySignature.getter_ = this.getter_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                jvmPropertySignature.setter_ = this.setter_;
                jvmPropertySignature.bitField0_ = i2;
                return jvmPropertySignature;
            }

            public Object clone() throws CloneNotSupportedException {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public GeneratedMessageLite getDefaultInstanceForType() {
                return JvmPropertySignature.defaultInstance;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.defaultInstance) {
                    return this;
                }
                boolean z = true;
                if ((jvmPropertySignature.bitField0_ & 1) == 1) {
                    JvmFieldSignature jvmFieldSignature = jvmPropertySignature.field_;
                    if ((this.bitField0_ & 1) == 1) {
                        JvmFieldSignature jvmFieldSignature2 = this.field_;
                        if (jvmFieldSignature2 != JvmFieldSignature.defaultInstance) {
                            Builder builder = new Builder();
                            builder.mergeFrom(jvmFieldSignature2);
                            builder.mergeFrom(jvmFieldSignature);
                            this.field_ = builder.buildPartial();
                            this.bitField0_ |= 1;
                        }
                    }
                    this.field_ = jvmFieldSignature;
                    this.bitField0_ |= 1;
                }
                if ((jvmPropertySignature.bitField0_ & 2) != 2) {
                    z = false;
                }
                if (z) {
                    JvmMethodSignature jvmMethodSignature = jvmPropertySignature.syntheticMethod_;
                    if ((this.bitField0_ & 2) == 2) {
                        JvmMethodSignature jvmMethodSignature2 = this.syntheticMethod_;
                        if (jvmMethodSignature2 != JvmMethodSignature.defaultInstance) {
                            Builder newBuilder = JvmMethodSignature.newBuilder(jvmMethodSignature2);
                            newBuilder.mergeFrom(jvmMethodSignature);
                            this.syntheticMethod_ = newBuilder.buildPartial();
                            this.bitField0_ |= 2;
                        }
                    }
                    this.syntheticMethod_ = jvmMethodSignature;
                    this.bitField0_ |= 2;
                }
                if (jvmPropertySignature.hasGetter()) {
                    JvmMethodSignature jvmMethodSignature3 = jvmPropertySignature.getter_;
                    if ((this.bitField0_ & 4) == 4) {
                        JvmMethodSignature jvmMethodSignature4 = this.getter_;
                        if (jvmMethodSignature4 != JvmMethodSignature.defaultInstance) {
                            Builder newBuilder2 = JvmMethodSignature.newBuilder(jvmMethodSignature4);
                            newBuilder2.mergeFrom(jvmMethodSignature3);
                            this.getter_ = newBuilder2.buildPartial();
                            this.bitField0_ |= 4;
                        }
                    }
                    this.getter_ = jvmMethodSignature3;
                    this.bitField0_ |= 4;
                }
                if (jvmPropertySignature.hasSetter()) {
                    JvmMethodSignature jvmMethodSignature5 = jvmPropertySignature.setter_;
                    if ((this.bitField0_ & 8) == 8) {
                        JvmMethodSignature jvmMethodSignature6 = this.setter_;
                        if (jvmMethodSignature6 != JvmMethodSignature.defaultInstance) {
                            Builder newBuilder3 = JvmMethodSignature.newBuilder(jvmMethodSignature6);
                            newBuilder3.mergeFrom(jvmMethodSignature5);
                            this.setter_ = newBuilder3.buildPartial();
                            this.bitField0_ |= 8;
                        }
                    }
                    this.setter_ = jvmMethodSignature5;
                    this.bitField0_ |= 8;
                }
                this.unknownFields = this.unknownFields.concat(jvmPropertySignature.unknownFields);
                return this;
            }

            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public MessageLite m962getDefaultInstanceForType() {
                return JvmPropertySignature.defaultInstance;
            }

            /* renamed from: clone  reason: collision with other method in class */
            public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m961clone() {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                mergeFrom((JvmPropertySignature) generatedMessageLite);
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                JvmPropertySignature jvmPropertySignature;
                JvmPropertySignature jvmPropertySignature2 = null;
                try {
                    JvmPropertySignature jvmPropertySignature3 = (JvmPropertySignature) JvmPropertySignature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (jvmPropertySignature3 != null) {
                        mergeFrom(jvmPropertySignature3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    jvmPropertySignature = (JvmPropertySignature) e2.unfinishedMessage;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    jvmPropertySignature2 = jvmPropertySignature;
                }
                if (jvmPropertySignature2 != null) {
                    mergeFrom(jvmPropertySignature2);
                }
                throw th;
            }
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature();
            defaultInstance = jvmPropertySignature;
            jvmPropertySignature.field_ = JvmFieldSignature.defaultInstance;
            JvmMethodSignature jvmMethodSignature = JvmMethodSignature.defaultInstance;
            jvmPropertySignature.syntheticMethod_ = jvmMethodSignature;
            jvmPropertySignature.getter_ = jvmMethodSignature;
            jvmPropertySignature.setter_ = jvmMethodSignature;
        }

        public JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, AnonymousClass1 r2) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.unknownFields;
        }

        public MessageLite getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeMessageSize(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeMessageSize(4, this.setter_);
            }
            int size = this.unknownFields.size() + i2;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder newBuilderForType() {
            return new Builder();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
            Builder builder = new Builder();
            builder.mergeFrom(this);
            return builder;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.setter_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public JvmPropertySignature() {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v1, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v2, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v3, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v4, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v5, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v6, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v7, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v8, types: [kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder] */
        /* JADX WARNING: type inference failed for: r5v9 */
        /* JADX WARNING: type inference failed for: r5v10 */
        /* JADX WARNING: type inference failed for: r5v11 */
        /* JADX WARNING: type inference failed for: r5v12 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder]
          uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder]
          mth insns count: 132
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
         */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r7, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r8, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.AnonymousClass1 r9) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
            /*
                r6 = this;
                r6.<init>()
                r9 = -1
                r6.memoizedIsInitialized = r9
                r6.memoizedSerializedSize = r9
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r9 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.defaultInstance
                r6.field_ = r9
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r9 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.defaultInstance
                r6.syntheticMethod_ = r9
                r6.getter_ = r9
                r6.setter_ = r9
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString$Output r9 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.newOutput()
                r0 = 1
                kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.newInstance(r9, r0)
                r2 = 0
            L_0x001e:
                if (r2 != 0) goto L_0x011a
                int r3 = r7.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r3 == 0) goto L_0x00f1
                r4 = 10
                r5 = 0
                if (r3 == r4) goto L_0x00c2
                r4 = 18
                if (r3 == r4) goto L_0x0096
                r4 = 26
                if (r3 == r4) goto L_0x006b
                r4 = 34
                if (r3 == r4) goto L_0x003f
                boolean r3 = r7.skipField(r3, r1)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r3 != 0) goto L_0x001e
                goto L_0x00f1
            L_0x003f:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r4 = 8
                r3 = r3 & r4
                if (r3 != r4) goto L_0x0050
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = r6.setter_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r3 == 0) goto L_0x004f
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder r5 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.newBuilder(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x0050
            L_0x004f:
                throw r5     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x0050:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = r7.readMessage(r3, r8)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.setter_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r5 == 0) goto L_0x0065
                r5.mergeFrom(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.setter_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x0065:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r3 = r3 | r4
                r6.bitField0_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x001e
            L_0x006b:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r4 = 4
                r3 = r3 & r4
                if (r3 != r4) goto L_0x007b
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = r6.getter_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r3 == 0) goto L_0x007a
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder r5 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.newBuilder(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x007b
            L_0x007a:
                throw r5     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x007b:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = r7.readMessage(r3, r8)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.getter_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r5 == 0) goto L_0x0090
                r5.mergeFrom(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.getter_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x0090:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r3 = r3 | r4
                r6.bitField0_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x001e
            L_0x0096:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r4 = 2
                r3 = r3 & r4
                if (r3 != r4) goto L_0x00a6
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = r6.syntheticMethod_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r3 == 0) goto L_0x00a5
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$Builder r5 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.newBuilder(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x00a6
            L_0x00a5:
                throw r5     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x00a6:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = r7.readMessage(r3, r8)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.syntheticMethod_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r5 == 0) goto L_0x00bb
                r5.mergeFrom(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.syntheticMethod_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x00bb:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r3 = r3 | r4
                r6.bitField0_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x001e
            L_0x00c2:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r3 = r3 & r0
                if (r3 != r0) goto L_0x00d5
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r3 = r6.field_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r3 == 0) goto L_0x00d4
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder r5 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$Builder     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r5.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r5.mergeFrom(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x00d5
            L_0x00d4:
                throw r5     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x00d5:
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature> r3 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = r7.readMessage(r3, r8)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.field_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                if (r5 == 0) goto L_0x00ea
                r5.mergeFrom(r3)     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r3 = r5.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r6.field_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
            L_0x00ea:
                int r3 = r6.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                r3 = r3 | r0
                r6.bitField0_ = r3     // Catch:{ InvalidProtocolBufferException -> 0x0103, IOException -> 0x00f6 }
                goto L_0x001e
            L_0x00f1:
                r2 = 1
                goto L_0x001e
            L_0x00f4:
                r7 = move-exception
                goto L_0x0107
            L_0x00f6:
                r7 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r8 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x00f4 }
                java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00f4 }
                r8.<init>(r7)     // Catch:{ all -> 0x00f4 }
                r8.unfinishedMessage = r6     // Catch:{ all -> 0x00f4 }
                throw r8     // Catch:{ all -> 0x00f4 }
            L_0x0103:
                r7 = move-exception
                r7.unfinishedMessage = r6     // Catch:{ all -> 0x00f4 }
                throw r7     // Catch:{ all -> 0x00f4 }
            L_0x0107:
                r1.flush()     // Catch:{ IOException -> 0x0113, all -> 0x010b }
                goto L_0x0113
            L_0x010b:
                r7 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r8 = r9.toByteString()
                r6.unknownFields = r8
                throw r7
            L_0x0113:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r8 = r9.toByteString()
                r6.unknownFields = r8
                throw r7
            L_0x011a:
                r1.flush()     // Catch:{ IOException -> 0x0126, all -> 0x011e }
                goto L_0x0126
            L_0x011e:
                r7 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r8 = r9.toByteString()
                r6.unknownFields = r8
                throw r7
            L_0x0126:
                kotlin.reflect.jvm.internal.impl.protobuf.ByteString r7 = r9.toByteString()
                r6.unknownFields = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.<init>(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$1):void");
        }
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<StringTableTypes> PARSER = new AbstractParser<StringTableTypes>() {
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new StringTableTypes(codedInputStream, extensionRegistryLite, null);
            }
        };
        public static final StringTableTypes defaultInstance;
        public int localNameMemoizedSerializedSize;
        public List<Integer> localName_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public List<Record> record_;
        public final ByteString unknownFields;

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<StringTableTypes, Builder> implements Object {
            public int bitField0_;
            public List<Integer> localName_ = Collections.emptyList();
            public List<Record> record_ = Collections.emptyList();

            public MessageLite build() {
                StringTableTypes buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException();
            }

            public StringTableTypes buildPartial() {
                StringTableTypes stringTableTypes = new StringTableTypes(this, null);
                if ((this.bitField0_ & 1) == 1) {
                    this.record_ = Collections.unmodifiableList(this.record_);
                    this.bitField0_ &= -2;
                }
                stringTableTypes.record_ = this.record_;
                if ((this.bitField0_ & 2) == 2) {
                    this.localName_ = Collections.unmodifiableList(this.localName_);
                    this.bitField0_ &= -3;
                }
                stringTableTypes.localName_ = this.localName_;
                return stringTableTypes;
            }

            public Object clone() throws CloneNotSupportedException {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public GeneratedMessageLite getDefaultInstanceForType() {
                return StringTableTypes.defaultInstance;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.defaultInstance) {
                    return this;
                }
                if (!stringTableTypes.record_.isEmpty()) {
                    if (this.record_.isEmpty()) {
                        this.record_ = stringTableTypes.record_;
                        this.bitField0_ &= -2;
                    } else {
                        if ((this.bitField0_ & 1) != 1) {
                            this.record_ = new ArrayList(this.record_);
                            this.bitField0_ |= 1;
                        }
                        this.record_.addAll(stringTableTypes.record_);
                    }
                }
                if (!stringTableTypes.localName_.isEmpty()) {
                    if (this.localName_.isEmpty()) {
                        this.localName_ = stringTableTypes.localName_;
                        this.bitField0_ &= -3;
                    } else {
                        if ((this.bitField0_ & 2) != 2) {
                            this.localName_ = new ArrayList(this.localName_);
                            this.bitField0_ |= 2;
                        }
                        this.localName_.addAll(stringTableTypes.localName_);
                    }
                }
                this.unknownFields = this.unknownFields.concat(stringTableTypes.unknownFields);
                return this;
            }

            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public MessageLite m964getDefaultInstanceForType() {
                return StringTableTypes.defaultInstance;
            }

            /* renamed from: clone  reason: collision with other method in class */
            public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m963clone() {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                mergeFrom((StringTableTypes) generatedMessageLite);
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                StringTableTypes stringTableTypes;
                StringTableTypes stringTableTypes2 = null;
                try {
                    StringTableTypes stringTableTypes3 = (StringTableTypes) StringTableTypes.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (stringTableTypes3 != null) {
                        mergeFrom(stringTableTypes3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    stringTableTypes = (StringTableTypes) e2.unfinishedMessage;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    stringTableTypes2 = stringTableTypes;
                }
                if (stringTableTypes2 != null) {
                    mergeFrom(stringTableTypes2);
                }
                throw th;
            }
        }

        public static final class Record extends GeneratedMessageLite implements MessageLiteOrBuilder {
            public static Parser<Record> PARSER = new AbstractParser<Record>() {
                public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Record(codedInputStream, extensionRegistryLite, null);
                }
            };
            public static final Record defaultInstance;
            public int bitField0_;
            public byte memoizedIsInitialized;
            public int memoizedSerializedSize;
            public Operation operation_;
            public int predefinedIndex_;
            public int range_;
            public int replaceCharMemoizedSerializedSize;
            public List<Integer> replaceChar_;
            public Object string_;
            public int substringIndexMemoizedSerializedSize;
            public List<Integer> substringIndex_;
            public final ByteString unknownFields;

            public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Record, Builder> implements Object {
                public int bitField0_;
                public Operation operation_ = Operation.NONE;
                public int predefinedIndex_;
                public int range_ = 1;
                public List<Integer> replaceChar_ = Collections.emptyList();
                public Object string_ = "";
                public List<Integer> substringIndex_ = Collections.emptyList();

                public MessageLite build() {
                    Record buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw new UninitializedMessageException();
                }

                public Record buildPartial() {
                    Record record = new Record(this, null);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    record.range_ = this.range_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    record.predefinedIndex_ = this.predefinedIndex_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    record.string_ = this.string_;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    record.operation_ = this.operation_;
                    if ((this.bitField0_ & 16) == 16) {
                        this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        this.bitField0_ &= -17;
                    }
                    record.substringIndex_ = this.substringIndex_;
                    if ((this.bitField0_ & 32) == 32) {
                        this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        this.bitField0_ &= -33;
                    }
                    record.replaceChar_ = this.replaceChar_;
                    record.bitField0_ = i2;
                    return record;
                }

                public Object clone() throws CloneNotSupportedException {
                    Builder builder = new Builder();
                    builder.mergeFrom(buildPartial());
                    return builder;
                }

                public GeneratedMessageLite getDefaultInstanceForType() {
                    return Record.defaultInstance;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeFrom(Record record) {
                    if (record == Record.defaultInstance) {
                        return this;
                    }
                    boolean z = true;
                    if ((record.bitField0_ & 1) == 1) {
                        int i = record.range_;
                        this.bitField0_ |= 1;
                        this.range_ = i;
                    }
                    if ((record.bitField0_ & 2) == 2) {
                        int i2 = record.predefinedIndex_;
                        this.bitField0_ = 2 | this.bitField0_;
                        this.predefinedIndex_ = i2;
                    }
                    if ((record.bitField0_ & 4) == 4) {
                        this.bitField0_ |= 4;
                        this.string_ = record.string_;
                    }
                    if ((record.bitField0_ & 8) != 8) {
                        z = false;
                    }
                    if (z) {
                        Operation operation = record.operation_;
                        if (operation != null) {
                            this.bitField0_ |= 8;
                            this.operation_ = operation;
                        } else {
                            throw null;
                        }
                    }
                    if (!record.substringIndex_.isEmpty()) {
                        if (this.substringIndex_.isEmpty()) {
                            this.substringIndex_ = record.substringIndex_;
                            this.bitField0_ &= -17;
                        } else {
                            if ((this.bitField0_ & 16) != 16) {
                                this.substringIndex_ = new ArrayList(this.substringIndex_);
                                this.bitField0_ |= 16;
                            }
                            this.substringIndex_.addAll(record.substringIndex_);
                        }
                    }
                    if (!record.replaceChar_.isEmpty()) {
                        if (this.replaceChar_.isEmpty()) {
                            this.replaceChar_ = record.replaceChar_;
                            this.bitField0_ &= -33;
                        } else {
                            if ((this.bitField0_ & 32) != 32) {
                                this.replaceChar_ = new ArrayList(this.replaceChar_);
                                this.bitField0_ |= 32;
                            }
                            this.replaceChar_.addAll(record.replaceChar_);
                        }
                    }
                    this.unknownFields = this.unknownFields.concat(record.unknownFields);
                    return this;
                }

                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public MessageLite m966getDefaultInstanceForType() {
                    return Record.defaultInstance;
                }

                /* renamed from: clone  reason: collision with other method in class */
                public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m965clone() {
                    Builder builder = new Builder();
                    builder.mergeFrom(buildPartial());
                    return builder;
                }

                public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                    mergeFrom((Record) generatedMessageLite);
                    return this;
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Record record;
                    Record record2 = null;
                    try {
                        Record record3 = (Record) Record.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (record3 != null) {
                            mergeFrom(record3);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        record = (Record) e2.unfinishedMessage;
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        record2 = record;
                    }
                    if (record2 != null) {
                        mergeFrom(record2);
                    }
                    throw th;
                }
            }

            public enum Operation implements EnumLite {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);
                
                public static EnumLiteMap<Operation> internalValueMap;
                public final int value;

                /* access modifiers changed from: public */
                static {
                    internalValueMap = new EnumLiteMap<Operation>() {
                        public EnumLite findValueByNumber(int i) {
                            return Operation.valueOf(i);
                        }
                    };
                }

                /* access modifiers changed from: public */
                Operation(int i, int i2) {
                    this.value = i2;
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int i) {
                    if (i == 0) {
                        return NONE;
                    }
                    if (i == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            static {
                Record record = new Record();
                defaultInstance = record;
                record.initFields();
            }

            public Record(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, AnonymousClass1 r2) {
                super(builder);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.unknownFields;
            }

            public MessageLite getDefaultInstanceForType() {
                return defaultInstance;
            }

            public int getSerializedSize() {
                ByteString byteString;
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.range_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    computeInt32Size += CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.substringIndex_.size(); i3++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(i3).intValue());
                }
                int i4 = computeInt32Size + i2;
                if (!this.substringIndex_.isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
                }
                this.substringIndexMemoizedSerializedSize = i2;
                int i5 = 0;
                for (int i6 = 0; i6 < this.replaceChar_.size(); i6++) {
                    i5 += CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(i6).intValue());
                }
                int i7 = i4 + i5;
                if (!this.replaceChar_.isEmpty()) {
                    i7 = i7 + 1 + CodedOutputStream.computeInt32SizeNoTag(i5);
                }
                this.replaceCharMemoizedSerializedSize = i5;
                if ((this.bitField0_ & 4) == 4) {
                    Object obj = this.string_;
                    if (obj instanceof String) {
                        byteString = ByteString.copyFromUtf8((String) obj);
                        this.string_ = byteString;
                    } else {
                        byteString = (ByteString) obj;
                    }
                    i7 += CodedOutputStream.computeBytesSizeNoTag(byteString) + CodedOutputStream.computeTagSize(6);
                }
                int size = this.unknownFields.size() + i7;
                this.memoizedSerializedSize = size;
                return size;
            }

            public final void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            public final boolean isInitialized() {
                byte b2 = this.memoizedIsInitialized;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder newBuilderForType() {
                return new Builder();
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
                Builder builder = new Builder();
                builder.mergeFrom(this);
                return builder;
            }

            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                ByteString byteString;
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeEnum(3, this.operation_.getNumber());
                }
                if (this.substringIndex_.size() > 0) {
                    codedOutputStream.writeRawVarint32(34);
                    codedOutputStream.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
                }
                for (int i = 0; i < this.substringIndex_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.substringIndex_.get(i).intValue());
                }
                if (this.replaceChar_.size() > 0) {
                    codedOutputStream.writeRawVarint32(42);
                    codedOutputStream.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.replaceChar_.size(); i2++) {
                    codedOutputStream.writeInt32NoTag(this.replaceChar_.get(i2).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    Object obj = this.string_;
                    if (obj instanceof String) {
                        byteString = ByteString.copyFromUtf8((String) obj);
                        this.string_ = byteString;
                    } else {
                        byteString = (ByteString) obj;
                    }
                    codedOutputStream.writeRawVarint32(50);
                    codedOutputStream.writeBytesNoTag(byteString);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public Record() {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public Record(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r12) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z = false;
                boolean z2 = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.range_ = codedInputStream.readRawVarint32();
                            } else if (readTag == 16) {
                                this.bitField0_ |= 2;
                                this.predefinedIndex_ = codedInputStream.readRawVarint32();
                            } else if (readTag == 24) {
                                int readRawVarint32 = codedInputStream.readRawVarint32();
                                Operation valueOf = Operation.valueOf(readRawVarint32);
                                if (valueOf == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readRawVarint32);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.operation_ = valueOf;
                                }
                            } else if (readTag == 32) {
                                if (!(z2 & true)) {
                                    this.substringIndex_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.substringIndex_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                            } else if (readTag == 34) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.substringIndex_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.substringIndex_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                                }
                                codedInputStream.currentLimit = pushLimit;
                                codedInputStream.recomputeBufferSizeAfterLimit();
                            } else if (readTag == 40) {
                                if (!(z2 & true)) {
                                    this.replaceChar_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.replaceChar_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                            } else if (readTag == 42) {
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.replaceChar_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.replaceChar_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                                }
                                codedInputStream.currentLimit = pushLimit2;
                                codedInputStream.recomputeBufferSizeAfterLimit();
                            } else if (readTag == 50) {
                                ByteString readBytes = codedInputStream.readBytes();
                                this.bitField0_ |= 4;
                                this.string_ = readBytes;
                            } else if (!codedInputStream.skipField(readTag, newInstance)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        e2.unfinishedMessage = this;
                        throw e2;
                    } catch (IOException e3) {
                        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e3.getMessage());
                        invalidProtocolBufferException.unfinishedMessage = this;
                        throw invalidProtocolBufferException;
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        }
                        if (z2 & true) {
                            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        }
                        try {
                            newInstance.flush();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = newOutput.toByteString();
                            throw th2;
                        }
                        this.unknownFields = newOutput.toByteString();
                        throw th;
                    }
                }
                if (z2 & true) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if (z2 & true) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                }
                try {
                    newInstance.flush();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = newOutput.toByteString();
                    throw th3;
                }
                this.unknownFields = newOutput.toByteString();
            }
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes();
            defaultInstance = stringTableTypes;
            stringTableTypes.record_ = Collections.emptyList();
            stringTableTypes.localName_ = Collections.emptyList();
        }

        public StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, AnonymousClass1 r2) {
            super(builder);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.unknownFields;
        }

        public MessageLite getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.record_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.record_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.localName_.size(); i5++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i5).intValue());
            }
            int i6 = i2 + i4;
            if (!this.localName_.isEmpty()) {
                i6 = i6 + 1 + CodedOutputStream.computeInt32SizeNoTag(i4);
            }
            this.localNameMemoizedSerializedSize = i4;
            int size = this.unknownFields.size() + i6;
            this.memoizedSerializedSize = size;
            return size;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder newBuilderForType() {
            return new Builder();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
            Builder builder = new Builder();
            builder.mergeFrom(this);
            return builder;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.record_.size(); i++) {
                codedOutputStream.writeMessage(1, this.record_.get(i));
            }
            if (this.localName_.size() > 0) {
                codedOutputStream.writeRawVarint32(42);
                codedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localName_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.localName_.get(i2).intValue());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public StringTableTypes() {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public StringTableTypes(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
            Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z2 || !true) {
                                this.record_ = new ArrayList();
                                z2 |= true;
                            }
                            this.record_.add(codedInputStream.readMessage(Record.PARSER, extensionRegistryLite));
                        } else if (readTag == 40) {
                            if (!(z2 & true)) {
                                this.localName_ = new ArrayList();
                                z2 |= true;
                            }
                            this.localName_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                        } else if (readTag == 42) {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                this.localName_ = new ArrayList();
                                z2 |= true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.localName_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                            }
                            codedInputStream.currentLimit = pushLimit;
                            codedInputStream.recomputeBufferSizeAfterLimit();
                        } else if (!codedInputStream.skipField(readTag, newInstance)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    e2.unfinishedMessage = this;
                    throw e2;
                } catch (IOException e3) {
                    InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e3.getMessage());
                    invalidProtocolBufferException.unfinishedMessage = this;
                    throw invalidProtocolBufferException;
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if (z2 & true) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
                    }
                    try {
                        newInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = newOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = newOutput.toByteString();
                    throw th;
                }
            }
            if (z2 && true) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if (z2 & true) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            try {
                newInstance.flush();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = newOutput.toByteString();
                throw th3;
            }
            this.unknownFields = newOutput.toByteString();
        }
    }

    static {
        ProtoBuf$Constructor protoBuf$Constructor = ProtoBuf$Constructor.defaultInstance;
        JvmMethodSignature jvmMethodSignature = JvmMethodSignature.defaultInstance;
        constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(protoBuf$Constructor, jvmMethodSignature, jvmMethodSignature, null, 100, WireFormat$FieldType.MESSAGE, JvmMethodSignature.class);
        ProtoBuf$Function protoBuf$Function = ProtoBuf$Function.defaultInstance;
        JvmMethodSignature jvmMethodSignature2 = JvmMethodSignature.defaultInstance;
        methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(protoBuf$Function, jvmMethodSignature2, jvmMethodSignature2, null, 100, WireFormat$FieldType.MESSAGE, JvmMethodSignature.class);
        ProtoBuf$Property protoBuf$Property = ProtoBuf$Property.defaultInstance;
        JvmPropertySignature jvmPropertySignature = JvmPropertySignature.defaultInstance;
        propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(protoBuf$Property, jvmPropertySignature, jvmPropertySignature, null, 100, WireFormat$FieldType.MESSAGE, JvmPropertySignature.class);
    }
}
