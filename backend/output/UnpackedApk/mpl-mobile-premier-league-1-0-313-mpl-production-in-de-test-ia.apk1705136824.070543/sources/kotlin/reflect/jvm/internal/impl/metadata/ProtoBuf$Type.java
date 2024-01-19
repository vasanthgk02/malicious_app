package kotlin.reflect.jvm.internal.impl.metadata;

import com.android.tools.r8.GeneratedOutlineSupport;
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
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Type extends ExtendableMessage<ProtoBuf$Type> implements Object {
    public static Parser<ProtoBuf$Type> PARSER = new AbstractParser<ProtoBuf$Type>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Type(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Type defaultInstance;
    public int abbreviatedTypeId_;
    public ProtoBuf$Type abbreviatedType_;
    public List<Argument> argument_;
    public int bitField0_;
    public int className_;
    public int flags_;
    public int flexibleTypeCapabilitiesId_;
    public int flexibleUpperBoundId_;
    public ProtoBuf$Type flexibleUpperBound_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public boolean nullable_;
    public int outerTypeId_;
    public ProtoBuf$Type outerType_;
    public int typeAliasName_;
    public int typeParameterName_;
    public int typeParameter_;
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
        public Projection projection_;
        public int typeId_;
        public ProtoBuf$Type type_;
        public final ByteString unknownFields;

        public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Argument, Builder> implements Object {
            public int bitField0_;
            public Projection projection_ = Projection.INV;
            public int typeId_;
            public ProtoBuf$Type type_ = ProtoBuf$Type.defaultInstance;

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
                argument.projection_ = this.projection_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                argument.type_ = this.type_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                argument.typeId_ = this.typeId_;
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
                return !((this.bitField0_ & 2) == 2) || this.type_.isInitialized();
            }

            public Builder mergeFrom(Argument argument) {
                if (argument == Argument.defaultInstance) {
                    return this;
                }
                boolean z = true;
                if ((argument.bitField0_ & 1) == 1) {
                    Projection projection = argument.projection_;
                    if (projection != null) {
                        this.bitField0_ |= 1;
                        this.projection_ = projection;
                    } else {
                        throw null;
                    }
                }
                if (argument.hasType()) {
                    ProtoBuf$Type protoBuf$Type = argument.type_;
                    if ((this.bitField0_ & 2) == 2) {
                        ProtoBuf$Type protoBuf$Type2 = this.type_;
                        if (protoBuf$Type2 != ProtoBuf$Type.defaultInstance) {
                            this.type_ = GeneratedOutlineSupport.outline90(protoBuf$Type2, protoBuf$Type);
                            this.bitField0_ |= 2;
                        }
                    }
                    this.type_ = protoBuf$Type;
                    this.bitField0_ |= 2;
                }
                if ((argument.bitField0_ & 4) != 4) {
                    z = false;
                }
                if (z) {
                    int i = argument.typeId_;
                    this.bitField0_ |= 4;
                    this.typeId_ = i;
                }
                this.unknownFields = this.unknownFields.concat(argument.unknownFields);
                return this;
            }

            /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
            public MessageLite m940getDefaultInstanceForType() {
                return Argument.defaultInstance;
            }

            /* renamed from: clone  reason: collision with other method in class */
            public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m939clone() {
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

        public enum Projection implements EnumLite {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);
            
            public static EnumLiteMap<Projection> internalValueMap;
            public final int value;

            /* access modifiers changed from: public */
            static {
                internalValueMap = new EnumLiteMap<Projection>() {
                    public EnumLite findValueByNumber(int i) {
                        return Projection.valueOf(i);
                    }
                };
            }

            /* access modifiers changed from: public */
            Projection(int i, int i2) {
                this.value = i2;
            }

            public final int getNumber() {
                return this.value;
            }

            public static Projection valueOf(int i) {
                if (i == 0) {
                    return IN;
                }
                if (i == 1) {
                    return OUT;
                }
                if (i == 2) {
                    return INV;
                }
                if (i != 3) {
                    return null;
                }
                return STAR;
            }
        }

        static {
            Argument argument = new Argument();
            defaultInstance = argument;
            argument.projection_ = Projection.INV;
            argument.type_ = ProtoBuf$Type.defaultInstance;
            argument.typeId_ = 0;
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
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeMessageSize(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeInt32Size(3, this.typeId_);
            }
            int size = this.unknownFields.size() + i2;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasType() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!hasType() || this.type_.isInitialized()) {
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
                codedOutputStream.writeEnum(1, this.projection_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.typeId_);
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
            this.projection_ = Projection.INV;
            this.type_ = ProtoBuf$Type.defaultInstance;
            boolean z = false;
            this.typeId_ = 0;
            Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            int readRawVarint32 = codedInputStream.readRawVarint32();
                            Projection valueOf = Projection.valueOf(readRawVarint32);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readRawVarint32);
                            } else {
                                this.bitField0_ |= 1;
                                this.projection_ = valueOf;
                            }
                        } else if (readTag == 18) {
                            Builder builder = null;
                            builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : builder;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.type_ = protoBuf$Type;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type);
                                this.type_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (readTag == 24) {
                            this.bitField0_ |= 4;
                            this.typeId_ = codedInputStream.readRawVarint32();
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

    public static final class Builder extends ExtendableBuilder<ProtoBuf$Type, Builder> implements Object {
        public int abbreviatedTypeId_;
        public ProtoBuf$Type abbreviatedType_;
        public List<Argument> argument_ = Collections.emptyList();
        public int bitField0_;
        public int className_;
        public int flags_;
        public int flexibleTypeCapabilitiesId_;
        public int flexibleUpperBoundId_;
        public ProtoBuf$Type flexibleUpperBound_;
        public boolean nullable_;
        public int outerTypeId_;
        public ProtoBuf$Type outerType_;
        public int typeAliasName_;
        public int typeParameterName_;
        public int typeParameter_;

        public Builder() {
            ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.defaultInstance;
            this.flexibleUpperBound_ = protoBuf$Type;
            this.outerType_ = protoBuf$Type;
            this.abbreviatedType_ = protoBuf$Type;
        }

        public MessageLite build() {
            ProtoBuf$Type buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Type buildPartial() {
            ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) == 1) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -2;
            }
            protoBuf$Type.argument_ = this.argument_;
            if ((i & 2) != 2) {
                i2 = 0;
            }
            protoBuf$Type.nullable_ = this.nullable_;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            protoBuf$Type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            protoBuf$Type.flexibleUpperBound_ = this.flexibleUpperBound_;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            protoBuf$Type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            protoBuf$Type.className_ = this.className_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Type.typeParameter_ = this.typeParameter_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Type.typeParameterName_ = this.typeParameterName_;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            protoBuf$Type.typeAliasName_ = this.typeAliasName_;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            protoBuf$Type.outerType_ = this.outerType_;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            protoBuf$Type.outerTypeId_ = this.outerTypeId_;
            if ((i & 2048) == 2048) {
                i2 |= 1024;
            }
            protoBuf$Type.abbreviatedType_ = this.abbreviatedType_;
            if ((i & 4096) == 4096) {
                i2 |= 2048;
            }
            protoBuf$Type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
            if ((i & 8192) == 8192) {
                i2 |= 4096;
            }
            protoBuf$Type.flags_ = this.flags_;
            protoBuf$Type.bitField0_ = i2;
            return protoBuf$Type;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Type.defaultInstance;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < this.argument_.size(); i++) {
                if (!this.argument_.get(i).isInitialized()) {
                    return false;
                }
            }
            if (((this.bitField0_ & 8) == 8) && !this.flexibleUpperBound_.isInitialized()) {
                return false;
            }
            if (((this.bitField0_ & 512) == 512) && !this.outerType_.isInitialized()) {
                return false;
            }
            if ((!((this.bitField0_ & 2048) == 2048) || this.abbreviatedType_.isInitialized()) && extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeFrom(ProtoBuf$Type protoBuf$Type) {
            if (protoBuf$Type == ProtoBuf$Type.defaultInstance) {
                return this;
            }
            boolean z = true;
            if (!protoBuf$Type.argument_.isEmpty()) {
                if (this.argument_.isEmpty()) {
                    this.argument_ = protoBuf$Type.argument_;
                    this.bitField0_ &= -2;
                } else {
                    if ((this.bitField0_ & 1) != 1) {
                        this.argument_ = new ArrayList(this.argument_);
                        this.bitField0_ |= 1;
                    }
                    this.argument_.addAll(protoBuf$Type.argument_);
                }
            }
            if ((protoBuf$Type.bitField0_ & 1) == 1) {
                boolean z2 = protoBuf$Type.nullable_;
                this.bitField0_ |= 2;
                this.nullable_ = z2;
            }
            if ((protoBuf$Type.bitField0_ & 2) == 2) {
                int i = protoBuf$Type.flexibleTypeCapabilitiesId_;
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = i;
            }
            if (protoBuf$Type.hasFlexibleUpperBound()) {
                ProtoBuf$Type protoBuf$Type2 = protoBuf$Type.flexibleUpperBound_;
                if ((this.bitField0_ & 8) == 8) {
                    ProtoBuf$Type protoBuf$Type3 = this.flexibleUpperBound_;
                    if (protoBuf$Type3 != ProtoBuf$Type.defaultInstance) {
                        this.flexibleUpperBound_ = GeneratedOutlineSupport.outline90(protoBuf$Type3, protoBuf$Type2);
                        this.bitField0_ |= 8;
                    }
                }
                this.flexibleUpperBound_ = protoBuf$Type2;
                this.bitField0_ |= 8;
            }
            if ((protoBuf$Type.bitField0_ & 8) == 8) {
                int i2 = protoBuf$Type.flexibleUpperBoundId_;
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = i2;
            }
            if (protoBuf$Type.hasClassName()) {
                int i3 = protoBuf$Type.className_;
                this.bitField0_ |= 32;
                this.className_ = i3;
            }
            if ((protoBuf$Type.bitField0_ & 32) == 32) {
                int i4 = protoBuf$Type.typeParameter_;
                this.bitField0_ |= 64;
                this.typeParameter_ = i4;
            }
            if ((protoBuf$Type.bitField0_ & 64) == 64) {
                int i5 = protoBuf$Type.typeParameterName_;
                this.bitField0_ |= 128;
                this.typeParameterName_ = i5;
            }
            if (protoBuf$Type.hasTypeAliasName()) {
                int i6 = protoBuf$Type.typeAliasName_;
                this.bitField0_ |= 256;
                this.typeAliasName_ = i6;
            }
            if (protoBuf$Type.hasOuterType()) {
                ProtoBuf$Type protoBuf$Type4 = protoBuf$Type.outerType_;
                if ((this.bitField0_ & 512) == 512) {
                    ProtoBuf$Type protoBuf$Type5 = this.outerType_;
                    if (protoBuf$Type5 != ProtoBuf$Type.defaultInstance) {
                        this.outerType_ = GeneratedOutlineSupport.outline90(protoBuf$Type5, protoBuf$Type4);
                        this.bitField0_ |= 512;
                    }
                }
                this.outerType_ = protoBuf$Type4;
                this.bitField0_ |= 512;
            }
            if ((protoBuf$Type.bitField0_ & 512) == 512) {
                int i7 = protoBuf$Type.outerTypeId_;
                this.bitField0_ |= 1024;
                this.outerTypeId_ = i7;
            }
            if (protoBuf$Type.hasAbbreviatedType()) {
                ProtoBuf$Type protoBuf$Type6 = protoBuf$Type.abbreviatedType_;
                if ((this.bitField0_ & 2048) == 2048) {
                    ProtoBuf$Type protoBuf$Type7 = this.abbreviatedType_;
                    if (protoBuf$Type7 != ProtoBuf$Type.defaultInstance) {
                        this.abbreviatedType_ = GeneratedOutlineSupport.outline90(protoBuf$Type7, protoBuf$Type6);
                        this.bitField0_ |= 2048;
                    }
                }
                this.abbreviatedType_ = protoBuf$Type6;
                this.bitField0_ |= 2048;
            }
            if ((protoBuf$Type.bitField0_ & 2048) == 2048) {
                int i8 = protoBuf$Type.abbreviatedTypeId_;
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = i8;
            }
            if ((protoBuf$Type.bitField0_ & 4096) != 4096) {
                z = false;
            }
            if (z) {
                int i9 = protoBuf$Type.flags_;
                this.bitField0_ |= 8192;
                this.flags_ = i9;
            }
            mergeExtensionFields(protoBuf$Type);
            this.unknownFields = this.unknownFields.concat(protoBuf$Type.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m942getDefaultInstanceForType() {
            return ProtoBuf$Type.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m941clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Type protoBuf$Type;
            ProtoBuf$Type protoBuf$Type2 = null;
            try {
                ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) ProtoBuf$Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Type3 != null) {
                    mergeFrom(protoBuf$Type3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Type = (ProtoBuf$Type) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Type2 = protoBuf$Type;
            }
            if (protoBuf$Type2 != null) {
                mergeFrom(protoBuf$Type2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type();
        defaultInstance = protoBuf$Type;
        protoBuf$Type.initFields();
    }

    public ProtoBuf$Type(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Type protoBuf$Type) {
        Builder builder = new Builder();
        builder.mergeFrom(protoBuf$Type);
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
        int computeInt32Size = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
        }
        if ((this.bitField0_ & 1) == 1) {
            computeInt32Size += CodedOutputStream.computeTagSize(3) + 1;
        }
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            computeInt32Size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            computeInt32Size += CodedOutputStream.computeMessageSize(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            computeInt32Size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            computeInt32Size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            computeInt32Size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            computeInt32Size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
        }
        int size = this.unknownFields.size() + extensionsSerializedSize() + computeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasAbbreviatedType() {
        return (this.bitField0_ & 1024) == 1024;
    }

    public boolean hasClassName() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasFlexibleUpperBound() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasOuterType() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasTypeAliasName() {
        return (this.bitField0_ & 128) == 128;
    }

    public final void initFields() {
        this.argument_ = Collections.emptyList();
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        ProtoBuf$Type protoBuf$Type = defaultInstance;
        this.flexibleUpperBound_ = protoBuf$Type;
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = protoBuf$Type;
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = protoBuf$Type;
        this.abbreviatedTypeId_ = 0;
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
        for (int i = 0; i < this.argument_.size(); i++) {
            if (!this.argument_.get(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (hasFlexibleUpperBound() && !this.flexibleUpperBound_.isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasOuterType() && !this.outerType_.isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasAbbreviatedType() && !this.abbreviatedType_.isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!extensionsAreInitialized()) {
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

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        ExtensionWriter newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 4096) == 4096) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i));
        }
        if ((this.bitField0_ & 1) == 1) {
            boolean z = this.nullable_;
            codedOutputStream.writeRawVarint32(24);
            codedOutputStream.writeRawByte(z ? 1 : 0);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeInt32(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            codedOutputStream.writeMessage(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public ProtoBuf$Type() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
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
                Builder builder = null;
                switch (readTag) {
                    case 0:
                        z = true;
                        break;
                    case 8:
                        this.bitField0_ |= 4096;
                        this.flags_ = codedInputStream.readRawVarint32();
                        break;
                    case 18:
                        if (!z2 || !true) {
                            this.argument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                        break;
                    case 24:
                        this.bitField0_ |= 1;
                        this.nullable_ = codedInputStream.readBool();
                        break;
                    case 32:
                        this.bitField0_ |= 2;
                        this.flexibleTypeCapabilitiesId_ = codedInputStream.readRawVarint32();
                        break;
                    case 42:
                        builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                        this.flexibleUpperBound_ = protoBuf$Type;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type);
                            this.flexibleUpperBound_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 4;
                        break;
                    case 48:
                        this.bitField0_ |= 16;
                        this.className_ = codedInputStream.readRawVarint32();
                        break;
                    case 56:
                        this.bitField0_ |= 32;
                        this.typeParameter_ = codedInputStream.readRawVarint32();
                        break;
                    case 64:
                        this.bitField0_ |= 8;
                        this.flexibleUpperBoundId_ = codedInputStream.readRawVarint32();
                        break;
                    case 72:
                        this.bitField0_ |= 64;
                        this.typeParameterName_ = codedInputStream.readRawVarint32();
                        break;
                    case 82:
                        builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                        this.outerType_ = protoBuf$Type2;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type2);
                            this.outerType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 256;
                        break;
                    case 88:
                        this.bitField0_ |= 512;
                        this.outerTypeId_ = codedInputStream.readRawVarint32();
                        break;
                    case 96:
                        this.bitField0_ |= 128;
                        this.typeAliasName_ = codedInputStream.readRawVarint32();
                        break;
                    case 106:
                        builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                        this.abbreviatedType_ = protoBuf$Type3;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type3);
                            this.abbreviatedType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 1024;
                        break;
                    case 112:
                        this.bitField0_ |= 2048;
                        this.abbreviatedTypeId_ = codedInputStream.readRawVarint32();
                        break;
                    default:
                        if (parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
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
                if (z2 && true) {
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
                this.extensions.makeImmutable();
                throw th;
            }
        }
        if (z2 && true) {
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
        this.extensions.makeImmutable();
    }
}
