package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Annotation extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Annotation> PARSER = new AbstractParser<ProtoBuf$Annotation>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Annotation(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Annotation defaultInstance;
    public List<Argument> argument_;
    public int bitField0_;
    public int id_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public final ByteString unknownFields;

    public static final class Argument extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<Argument> PARSER = new AbstractParser<Argument>() {
            public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Argument(codedInputStream, extensionRegistryLite, null);
            }
        };
        public static final Argument defaultInstance;
        public int bitField0_;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public int nameId_;
        public final ByteString unknownFields;
        public Value value_;

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Argument, Builder> implements Object {
            public int bitField0_;
            public int nameId_;
            public Value value_ = Value.defaultInstance;

            public MessageLite build() {
                Argument buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException();
            }

            public Argument buildPartial() {
                Argument argument = new Argument(this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                argument.nameId_ = this.nameId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                argument.value_ = this.value_;
                argument.bitField0_ = i2;
                return argument;
            }

            public Object clone() throws CloneNotSupportedException {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public GeneratedMessageLite getDefaultInstanceForType() {
                return Argument.defaultInstance;
            }

            public final boolean isInitialized() {
                if (!((this.bitField0_ & 1) == 1)) {
                    return false;
                }
                return ((this.bitField0_ & 2) == 2) && this.value_.isInitialized();
            }

            public Builder mergeFrom(Argument argument) {
                if (argument == Argument.defaultInstance) {
                    return this;
                }
                boolean z = true;
                if ((argument.bitField0_ & 1) == 1) {
                    int i = argument.nameId_;
                    this.bitField0_ |= 1;
                    this.nameId_ = i;
                }
                if ((argument.bitField0_ & 2) != 2) {
                    z = false;
                }
                if (z) {
                    Value value = argument.value_;
                    if ((this.bitField0_ & 2) == 2) {
                        Value value2 = this.value_;
                        if (value2 != Value.defaultInstance) {
                            Builder builder = new Builder();
                            builder.mergeFrom(value2);
                            builder.mergeFrom(value);
                            this.value_ = builder.buildPartial();
                            this.bitField0_ |= 2;
                        }
                    }
                    this.value_ = value;
                    this.bitField0_ |= 2;
                }
                this.unknownFields = this.unknownFields.concat(argument.unknownFields);
                return this;
            }

            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public MessageLite m908getDefaultInstanceForType() {
                return Argument.defaultInstance;
            }

            /* renamed from: clone  reason: collision with other method in class */
            public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m907clone() {
                Builder builder = new Builder();
                builder.mergeFrom(buildPartial());
                return builder;
            }

            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                mergeFrom((Argument) generatedMessageLite);
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Argument argument;
                Argument argument2 = null;
                try {
                    Argument argument3 = (Argument) Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (argument3 != null) {
                        mergeFrom(argument3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    argument = (Argument) e2.unfinishedMessage;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    argument2 = argument;
                }
                if (argument2 != null) {
                    mergeFrom(argument2);
                }
                throw th;
            }
        }

        public static final class Value extends GeneratedMessageLite implements MessageLiteOrBuilder {
            public static Parser<Value> PARSER = new AbstractParser<Value>() {
                public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Value(codedInputStream, extensionRegistryLite, null);
                }
            };
            public static final Value defaultInstance;
            public ProtoBuf$Annotation annotation_;
            public int arrayDimensionCount_;
            public List<Value> arrayElement_;
            public int bitField0_;
            public int classId_;
            public double doubleValue_;
            public int enumValueId_;
            public int flags_;
            public float floatValue_;
            public long intValue_;
            public byte memoizedIsInitialized;
            public int memoizedSerializedSize;
            public int stringValue_;
            public Type type_;
            public final ByteString unknownFields;

            public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Value, Builder> implements Object {
                public ProtoBuf$Annotation annotation_ = ProtoBuf$Annotation.defaultInstance;
                public int arrayDimensionCount_;
                public List<Value> arrayElement_ = Collections.emptyList();
                public int bitField0_;
                public int classId_;
                public double doubleValue_;
                public int enumValueId_;
                public int flags_;
                public float floatValue_;
                public long intValue_;
                public int stringValue_;
                public Type type_ = Type.BYTE;

                public MessageLite build() {
                    Value buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw new UninitializedMessageException();
                }

                public Value buildPartial() {
                    Value value = new Value(this, null);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    value.type_ = this.type_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    value.intValue_ = this.intValue_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    value.floatValue_ = this.floatValue_;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    value.doubleValue_ = this.doubleValue_;
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    value.stringValue_ = this.stringValue_;
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    value.classId_ = this.classId_;
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    value.enumValueId_ = this.enumValueId_;
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    value.annotation_ = this.annotation_;
                    if ((this.bitField0_ & 256) == 256) {
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    }
                    value.arrayElement_ = this.arrayElement_;
                    if ((i & 512) == 512) {
                        i2 |= 256;
                    }
                    value.arrayDimensionCount_ = this.arrayDimensionCount_;
                    if ((i & 1024) == 1024) {
                        i2 |= 512;
                    }
                    value.flags_ = this.flags_;
                    value.bitField0_ = i2;
                    return value;
                }

                public Object clone() throws CloneNotSupportedException {
                    Builder builder = new Builder();
                    builder.mergeFrom(buildPartial());
                    return builder;
                }

                public GeneratedMessageLite getDefaultInstanceForType() {
                    return Value.defaultInstance;
                }

                public final boolean isInitialized() {
                    if (((this.bitField0_ & 128) == 128) && !this.annotation_.isInitialized()) {
                        return false;
                    }
                    for (int i = 0; i < this.arrayElement_.size(); i++) {
                        if (!this.arrayElement_.get(i).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }

                public Builder mergeFrom(Value value) {
                    if (value == Value.defaultInstance) {
                        return this;
                    }
                    boolean z = true;
                    if ((value.bitField0_ & 1) == 1) {
                        Type type = value.type_;
                        if (type != null) {
                            this.bitField0_ |= 1;
                            this.type_ = type;
                        } else {
                            throw null;
                        }
                    }
                    if ((value.bitField0_ & 2) == 2) {
                        long j = value.intValue_;
                        this.bitField0_ |= 2;
                        this.intValue_ = j;
                    }
                    if ((value.bitField0_ & 4) == 4) {
                        float f2 = value.floatValue_;
                        this.bitField0_ = 4 | this.bitField0_;
                        this.floatValue_ = f2;
                    }
                    if ((value.bitField0_ & 8) == 8) {
                        double d2 = value.doubleValue_;
                        this.bitField0_ |= 8;
                        this.doubleValue_ = d2;
                    }
                    if ((value.bitField0_ & 16) == 16) {
                        int i = value.stringValue_;
                        this.bitField0_ = 16 | this.bitField0_;
                        this.stringValue_ = i;
                    }
                    if ((value.bitField0_ & 32) == 32) {
                        int i2 = value.classId_;
                        this.bitField0_ = 32 | this.bitField0_;
                        this.classId_ = i2;
                    }
                    if ((value.bitField0_ & 64) == 64) {
                        int i3 = value.enumValueId_;
                        this.bitField0_ = 64 | this.bitField0_;
                        this.enumValueId_ = i3;
                    }
                    if ((value.bitField0_ & 128) == 128) {
                        ProtoBuf$Annotation protoBuf$Annotation = value.annotation_;
                        if ((this.bitField0_ & 128) == 128) {
                            ProtoBuf$Annotation protoBuf$Annotation2 = this.annotation_;
                            if (protoBuf$Annotation2 != ProtoBuf$Annotation.defaultInstance) {
                                Builder builder = new Builder();
                                builder.mergeFrom(protoBuf$Annotation2);
                                builder.mergeFrom(protoBuf$Annotation);
                                this.annotation_ = builder.buildPartial();
                                this.bitField0_ |= 128;
                            }
                        }
                        this.annotation_ = protoBuf$Annotation;
                        this.bitField0_ |= 128;
                    }
                    if (!value.arrayElement_.isEmpty()) {
                        if (this.arrayElement_.isEmpty()) {
                            this.arrayElement_ = value.arrayElement_;
                            this.bitField0_ &= -257;
                        } else {
                            if ((this.bitField0_ & 256) != 256) {
                                this.arrayElement_ = new ArrayList(this.arrayElement_);
                                this.bitField0_ |= 256;
                            }
                            this.arrayElement_.addAll(value.arrayElement_);
                        }
                    }
                    if ((value.bitField0_ & 256) == 256) {
                        int i4 = value.arrayDimensionCount_;
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = i4;
                    }
                    if ((value.bitField0_ & 512) != 512) {
                        z = false;
                    }
                    if (z) {
                        int i5 = value.flags_;
                        this.bitField0_ |= 1024;
                        this.flags_ = i5;
                    }
                    this.unknownFields = this.unknownFields.concat(value.unknownFields);
                    return this;
                }

                /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
                public MessageLite m910getDefaultInstanceForType() {
                    return Value.defaultInstance;
                }

                /* renamed from: clone  reason: collision with other method in class */
                public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m909clone() {
                    Builder builder = new Builder();
                    builder.mergeFrom(buildPartial());
                    return builder;
                }

                public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
                    mergeFrom((Value) generatedMessageLite);
                    return this;
                }

                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Value value;
                    Value value2 = null;
                    try {
                        Value value3 = (Value) Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (value3 != null) {
                            mergeFrom(value3);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        value = (Value) e2.unfinishedMessage;
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        value2 = value;
                    }
                    if (value2 != null) {
                        mergeFrom(value2);
                    }
                    throw th;
                }
            }

            public enum Type implements EnumLite {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);
                
                public static EnumLiteMap<Type> internalValueMap;
                public final int value;

                /* access modifiers changed from: public */
                static {
                    internalValueMap = new EnumLiteMap<Type>() {
                        public EnumLite findValueByNumber(int i) {
                            return Type.valueOf(i);
                        }
                    };
                }

                /* access modifiers changed from: public */
                Type(int i, int i2) {
                    this.value = i2;
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Type valueOf(int i) {
                    switch (i) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }
            }

            static {
                Value value = new Value();
                defaultInstance = value;
                value.initFields();
            }

            public Value(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
                int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    long j = this.intValue_;
                    computeEnumSize += CodedOutputStream.computeRawVarint64Size((j >> 63) ^ (j << 1)) + CodedOutputStream.computeTagSize(2);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeTagSize(3) + 4;
                }
                if ((this.bitField0_ & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeTagSize(4) + 8;
                }
                if ((this.bitField0_ & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(8, this.annotation_);
                }
                for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i2));
                }
                if ((this.bitField0_ & 512) == 512) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                }
                int size = this.unknownFields.size() + computeEnumSize;
                this.memoizedSerializedSize = size;
                return size;
            }

            public final void initFields() {
                this.type_ = Type.BYTE;
                this.intValue_ = 0;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = ProtoBuf$Annotation.defaultInstance;
                this.arrayElement_ = Collections.emptyList();
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            public final boolean isInitialized() {
                byte b2 = this.memoizedIsInitialized;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!((this.bitField0_ & 128) == 128) || this.annotation_.isInitialized()) {
                    for (int i = 0; i < this.arrayElement_.size(); i++) {
                        if (!this.arrayElement_.get(i).isInitialized()) {
                            this.memoizedIsInitialized = 0;
                            return false;
                        }
                    }
                    this.memoizedIsInitialized = 1;
                    return true;
                }
                this.memoizedIsInitialized = 0;
                return false;
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
                    codedOutputStream.writeEnum(1, this.type_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    long j = this.intValue_;
                    codedOutputStream.writeRawVarint32(16);
                    codedOutputStream.writeRawVarint64((j << 1) ^ (j >> 63));
                }
                if ((this.bitField0_ & 4) == 4) {
                    float f2 = this.floatValue_;
                    codedOutputStream.writeRawVarint32(29);
                    codedOutputStream.writeRawLittleEndian32(Float.floatToRawIntBits(f2));
                }
                if ((this.bitField0_ & 8) == 8) {
                    double d2 = this.doubleValue_;
                    codedOutputStream.writeRawVarint32(33);
                    codedOutputStream.writeRawLittleEndian64(Double.doubleToRawLongBits(d2));
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.annotation_);
                }
                for (int i = 0; i < this.arrayElement_.size(); i++) {
                    codedOutputStream.writeMessage(9, this.arrayElement_.get(i));
                }
                if ((this.bitField0_ & 512) == 512) {
                    codedOutputStream.writeInt32(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public Value() {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
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
                        switch (readTag) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                int readRawVarint32 = codedInputStream.readRawVarint32();
                                Type valueOf = Type.valueOf(readRawVarint32);
                                if (valueOf != null) {
                                    this.bitField0_ |= 1;
                                    this.type_ = valueOf;
                                    break;
                                } else {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readRawVarint32);
                                    break;
                                }
                            case 16:
                                this.bitField0_ |= 2;
                                long readRawVarint64 = codedInputStream.readRawVarint64();
                                this.intValue_ = (-(readRawVarint64 & 1)) ^ (readRawVarint64 >>> 1);
                                break;
                            case 29:
                                this.bitField0_ |= 4;
                                this.floatValue_ = Float.intBitsToFloat(codedInputStream.readRawLittleEndian32());
                                break;
                            case 33:
                                this.bitField0_ |= 8;
                                this.doubleValue_ = Double.longBitsToDouble(codedInputStream.readRawLittleEndian64());
                                break;
                            case 40:
                                this.bitField0_ |= 16;
                                this.stringValue_ = codedInputStream.readRawVarint32();
                                break;
                            case 48:
                                this.bitField0_ |= 32;
                                this.classId_ = codedInputStream.readRawVarint32();
                                break;
                            case 56:
                                this.bitField0_ |= 64;
                                this.enumValueId_ = codedInputStream.readRawVarint32();
                                break;
                            case 66:
                                Builder builder = null;
                                if ((this.bitField0_ & 128) == 128) {
                                    ProtoBuf$Annotation protoBuf$Annotation = this.annotation_;
                                    if (protoBuf$Annotation != null) {
                                        builder = new Builder();
                                        builder.mergeFrom(protoBuf$Annotation);
                                    } else {
                                        throw null;
                                    }
                                }
                                ProtoBuf$Annotation protoBuf$Annotation2 = (ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite);
                                this.annotation_ = protoBuf$Annotation2;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Annotation2);
                                    this.annotation_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 128;
                                break;
                            case 74:
                                if (!(z2 & true)) {
                                    this.arrayElement_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.arrayElement_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                break;
                            case 80:
                                this.bitField0_ |= 512;
                                this.flags_ = codedInputStream.readRawVarint32();
                                break;
                            case 88:
                                this.bitField0_ |= 256;
                                this.arrayDimensionCount_ = codedInputStream.readRawVarint32();
                                break;
                            default:
                                if (codedInputStream.skipField(readTag, newInstance)) {
                                    break;
                                }
                                z = true;
                                break;
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        e2.unfinishedMessage = this;
                        throw e2;
                    } catch (IOException e3) {
                        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(e3.getMessage());
                        invalidProtocolBufferException.unfinishedMessage = this;
                        throw invalidProtocolBufferException;
                    } catch (Throwable th) {
                        if (z2 & true) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
            Argument argument = new Argument();
            defaultInstance = argument;
            argument.nameId_ = 0;
            argument.value_ = Value.defaultInstance;
        }

        public Argument(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
                i2 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, this.value_);
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
            if (!((this.bitField0_ & 1) == 1)) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!((this.bitField0_ & 2) == 2)) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!this.value_.isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt32(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.value_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public Argument() {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            boolean z = false;
            this.nameId_ = 0;
            this.value_ = Value.defaultInstance;
            Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.nameId_ = codedInputStream.readRawVarint32();
                        } else if (readTag == 18) {
                            Builder builder = null;
                            if ((this.bitField0_ & 2) == 2) {
                                Value value = this.value_;
                                if (value != null) {
                                    builder = new Builder();
                                    builder.mergeFrom(value);
                                } else {
                                    throw null;
                                }
                            }
                            Value value2 = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                            this.value_ = value2;
                            if (builder != null) {
                                builder.mergeFrom(value2);
                                this.value_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
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

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$Annotation, Builder> implements Object {
        public List<Argument> argument_ = Collections.emptyList();
        public int bitField0_;
        public int id_;

        public MessageLite build() {
            ProtoBuf$Annotation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Annotation buildPartial() {
            ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(this, null);
            int i = 1;
            if ((this.bitField0_ & 1) != 1) {
                i = 0;
            }
            protoBuf$Annotation.id_ = this.id_;
            if ((this.bitField0_ & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            }
            protoBuf$Annotation.argument_ = this.argument_;
            protoBuf$Annotation.bitField0_ = i;
            return protoBuf$Annotation;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Annotation.defaultInstance;
        }

        public final boolean isInitialized() {
            if (!((this.bitField0_ & 1) == 1)) {
                return false;
            }
            for (int i = 0; i < this.argument_.size(); i++) {
                if (!this.argument_.get(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Builder mergeFrom(ProtoBuf$Annotation protoBuf$Annotation) {
            if (protoBuf$Annotation == ProtoBuf$Annotation.defaultInstance) {
                return this;
            }
            if ((protoBuf$Annotation.bitField0_ & 1) == 1) {
                int i = protoBuf$Annotation.id_;
                this.bitField0_ = 1 | this.bitField0_;
                this.id_ = i;
            }
            if (!protoBuf$Annotation.argument_.isEmpty()) {
                if (this.argument_.isEmpty()) {
                    this.argument_ = protoBuf$Annotation.argument_;
                    this.bitField0_ &= -3;
                } else {
                    if ((this.bitField0_ & 2) != 2) {
                        this.argument_ = new ArrayList(this.argument_);
                        this.bitField0_ |= 2;
                    }
                    this.argument_.addAll(protoBuf$Annotation.argument_);
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$Annotation.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m912getDefaultInstanceForType() {
            return ProtoBuf$Annotation.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m911clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Annotation) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Annotation protoBuf$Annotation;
            ProtoBuf$Annotation protoBuf$Annotation2 = null;
            try {
                ProtoBuf$Annotation protoBuf$Annotation3 = (ProtoBuf$Annotation) ProtoBuf$Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Annotation3 != null) {
                    mergeFrom(protoBuf$Annotation3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Annotation = (ProtoBuf$Annotation) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Annotation2 = protoBuf$Annotation;
            }
            if (protoBuf$Annotation2 != null) {
                mergeFrom(protoBuf$Annotation2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation();
        defaultInstance = protoBuf$Annotation;
        protoBuf$Annotation.id_ = 0;
        protoBuf$Annotation.argument_ = Collections.emptyList();
    }

    public ProtoBuf$Annotation(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
        }
        int size = this.unknownFields.size() + computeInt32Size;
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
        if (!((this.bitField0_ & 1) == 1)) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            if (!this.argument_.get(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
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
            codedOutputStream.writeInt32(1, this.id_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Annotation() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean z = false;
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
        Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z2 = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 8) {
                        this.bitField0_ |= 1;
                        this.id_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 18) {
                        if (!(z2 & true)) {
                            this.argument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
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
                    this.argument_ = Collections.unmodifiableList(this.argument_);
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
            this.argument_ = Collections.unmodifiableList(this.argument_);
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
