package kotlin.reflect.jvm.internal.impl.metadata;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$ValueParameter extends ExtendableMessage<ProtoBuf$ValueParameter> implements Object {
    public static Parser<ProtoBuf$ValueParameter> PARSER = new AbstractParser<ProtoBuf$ValueParameter>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$ValueParameter(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$ValueParameter defaultInstance;
    public int bitField0_;
    public int flags_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int name_;
    public int typeId_;
    public ProtoBuf$Type type_;
    public final ByteString unknownFields;
    public int varargElementTypeId_;
    public ProtoBuf$Type varargElementType_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$ValueParameter, Builder> implements Object {
        public int bitField0_;
        public int flags_;
        public int name_;
        public int typeId_;
        public ProtoBuf$Type type_;
        public int varargElementTypeId_;
        public ProtoBuf$Type varargElementType_;

        public Builder() {
            ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.defaultInstance;
            this.type_ = protoBuf$Type;
            this.varargElementType_ = protoBuf$Type;
        }

        public MessageLite build() {
            ProtoBuf$ValueParameter buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$ValueParameter buildPartial() {
            ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$ValueParameter.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$ValueParameter.name_ = this.name_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$ValueParameter.type_ = this.type_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$ValueParameter.typeId_ = this.typeId_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$ValueParameter.varargElementType_ = this.varargElementType_;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            protoBuf$ValueParameter.varargElementTypeId_ = this.varargElementTypeId_;
            protoBuf$ValueParameter.bitField0_ = i2;
            return protoBuf$ValueParameter;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$ValueParameter.defaultInstance;
        }

        public final boolean isInitialized() {
            if (!((this.bitField0_ & 2) == 2)) {
                return false;
            }
            if (((this.bitField0_ & 4) == 4) && !this.type_.isInitialized()) {
                return false;
            }
            return (!((this.bitField0_ & 16) == 16) || this.varargElementType_.isInitialized()) && extensionsAreInitialized();
        }

        public Builder mergeFrom(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if (protoBuf$ValueParameter == ProtoBuf$ValueParameter.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$ValueParameter.bitField0_ & 1) == 1) {
                int i = protoBuf$ValueParameter.flags_;
                this.bitField0_ |= 1;
                this.flags_ = i;
            }
            if ((protoBuf$ValueParameter.bitField0_ & 2) == 2) {
                int i2 = protoBuf$ValueParameter.name_;
                this.bitField0_ = 2 | this.bitField0_;
                this.name_ = i2;
            }
            if (protoBuf$ValueParameter.hasType()) {
                ProtoBuf$Type protoBuf$Type = protoBuf$ValueParameter.type_;
                if ((this.bitField0_ & 4) == 4) {
                    ProtoBuf$Type protoBuf$Type2 = this.type_;
                    if (protoBuf$Type2 != ProtoBuf$Type.defaultInstance) {
                        this.type_ = GeneratedOutlineSupport.outline90(protoBuf$Type2, protoBuf$Type);
                        this.bitField0_ |= 4;
                    }
                }
                this.type_ = protoBuf$Type;
                this.bitField0_ |= 4;
            }
            if ((protoBuf$ValueParameter.bitField0_ & 8) == 8) {
                int i3 = protoBuf$ValueParameter.typeId_;
                this.bitField0_ = 8 | this.bitField0_;
                this.typeId_ = i3;
            }
            if (protoBuf$ValueParameter.hasVarargElementType()) {
                ProtoBuf$Type protoBuf$Type3 = protoBuf$ValueParameter.varargElementType_;
                if ((this.bitField0_ & 16) == 16) {
                    ProtoBuf$Type protoBuf$Type4 = this.varargElementType_;
                    if (protoBuf$Type4 != ProtoBuf$Type.defaultInstance) {
                        this.varargElementType_ = GeneratedOutlineSupport.outline90(protoBuf$Type4, protoBuf$Type3);
                        this.bitField0_ |= 16;
                    }
                }
                this.varargElementType_ = protoBuf$Type3;
                this.bitField0_ |= 16;
            }
            if ((protoBuf$ValueParameter.bitField0_ & 32) != 32) {
                z = false;
            }
            if (z) {
                int i4 = protoBuf$ValueParameter.varargElementTypeId_;
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = i4;
            }
            mergeExtensionFields(protoBuf$ValueParameter);
            this.unknownFields = this.unknownFields.concat(protoBuf$ValueParameter.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m951getDefaultInstanceForType() {
            return ProtoBuf$ValueParameter.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m950clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$ValueParameter) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$ValueParameter protoBuf$ValueParameter;
            ProtoBuf$ValueParameter protoBuf$ValueParameter2 = null;
            try {
                ProtoBuf$ValueParameter protoBuf$ValueParameter3 = (ProtoBuf$ValueParameter) ProtoBuf$ValueParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$ValueParameter3 != null) {
                    mergeFrom(protoBuf$ValueParameter3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$ValueParameter = (ProtoBuf$ValueParameter) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$ValueParameter2 = protoBuf$ValueParameter;
            }
            if (protoBuf$ValueParameter2 != null) {
                mergeFrom(protoBuf$ValueParameter2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter();
        defaultInstance = protoBuf$ValueParameter;
        protoBuf$ValueParameter.flags_ = 0;
        protoBuf$ValueParameter.name_ = 0;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.defaultInstance;
        protoBuf$ValueParameter.type_ = protoBuf$Type;
        protoBuf$ValueParameter.typeId_ = 0;
        protoBuf$ValueParameter.varargElementType_ = protoBuf$Type;
        protoBuf$ValueParameter.varargElementTypeId_ = 0;
    }

    public ProtoBuf$ValueParameter(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
        super(extendableBuilder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.unknownFields;
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
            i2 = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            i2 += CodedOutputStream.computeMessageSize(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            i2 += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            i2 += CodedOutputStream.computeInt32Size(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            i2 += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        }
        int size = this.unknownFields.size() + extensionsSerializedSize() + i2;
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasVarargElementType() {
        return (this.bitField0_ & 16) == 16;
    }

    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!((this.bitField0_ & 2) == 2)) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasType() && !this.type_.isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (hasVarargElementType() && !this.varargElementType_.isInitialized()) {
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

    public kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder toBuilder() {
        Builder builder = new Builder();
        builder.mergeFrom(this);
        return builder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        ExtensionWriter newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(6, this.varargElementTypeId_);
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$ValueParameter() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$ValueParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean z = false;
        this.flags_ = 0;
        this.name_ = 0;
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.defaultInstance;
        this.type_ = protoBuf$Type;
        this.typeId_ = 0;
        this.varargElementType_ = protoBuf$Type;
        this.varargElementTypeId_ = 0;
        Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 8) {
                        this.bitField0_ |= 1;
                        this.flags_ = codedInputStream.readRawVarint32();
                    } else if (readTag != 16) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Builder builder = null;
                        if (readTag == 26) {
                            builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : builder;
                            ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.type_ = protoBuf$Type2;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type2);
                                this.type_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                        } else if (readTag == 34) {
                            builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : builder;
                            ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.varargElementType_ = protoBuf$Type3;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type3);
                                this.varargElementType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                        } else if (readTag == 40) {
                            this.bitField0_ |= 8;
                            this.typeId_ = codedInputStream.readRawVarint32();
                        } else if (readTag == 48) {
                            this.bitField0_ |= 32;
                            this.varargElementTypeId_ = codedInputStream.readRawVarint32();
                        } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                        }
                    } else {
                        this.bitField0_ |= 2;
                        this.name_ = codedInputStream.readRawVarint32();
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
                this.extensions.makeImmutable();
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
        this.extensions.makeImmutable();
    }
}
