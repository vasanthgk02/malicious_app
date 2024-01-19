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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$TypeAlias extends ExtendableMessage<ProtoBuf$TypeAlias> implements Object {
    public static Parser<ProtoBuf$TypeAlias> PARSER = new AbstractParser<ProtoBuf$TypeAlias>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeAlias(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$TypeAlias defaultInstance;
    public List<ProtoBuf$Annotation> annotation_;
    public int bitField0_;
    public int expandedTypeId_;
    public ProtoBuf$Type expandedType_;
    public int flags_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int name_;
    public List<ProtoBuf$TypeParameter> typeParameter_;
    public int underlyingTypeId_;
    public ProtoBuf$Type underlyingType_;
    public final ByteString unknownFields;
    public List<Integer> versionRequirement_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$TypeAlias, Builder> implements Object {
        public List<ProtoBuf$Annotation> annotation_;
        public int bitField0_;
        public int expandedTypeId_;
        public ProtoBuf$Type expandedType_;
        public int flags_ = 6;
        public int name_;
        public List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        public int underlyingTypeId_;
        public ProtoBuf$Type underlyingType_;
        public List<Integer> versionRequirement_;

        public Builder() {
            ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.defaultInstance;
            this.underlyingType_ = protoBuf$Type;
            this.expandedType_ = protoBuf$Type;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public MessageLite build() {
            ProtoBuf$TypeAlias buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$TypeAlias buildPartial() {
            ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$TypeAlias.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$TypeAlias.name_ = this.name_;
            if ((this.bitField0_ & 4) == 4) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            }
            protoBuf$TypeAlias.typeParameter_ = this.typeParameter_;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            protoBuf$TypeAlias.underlyingType_ = this.underlyingType_;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            protoBuf$TypeAlias.underlyingTypeId_ = this.underlyingTypeId_;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            protoBuf$TypeAlias.expandedType_ = this.expandedType_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$TypeAlias.expandedTypeId_ = this.expandedTypeId_;
            if ((this.bitField0_ & 128) == 128) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            }
            protoBuf$TypeAlias.annotation_ = this.annotation_;
            if ((this.bitField0_ & 256) == 256) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            }
            protoBuf$TypeAlias.versionRequirement_ = this.versionRequirement_;
            protoBuf$TypeAlias.bitField0_ = i2;
            return protoBuf$TypeAlias;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$TypeAlias.defaultInstance;
        }

        public final boolean isInitialized() {
            if (!((this.bitField0_ & 2) == 2)) {
                return false;
            }
            for (int i = 0; i < this.typeParameter_.size(); i++) {
                if (!this.typeParameter_.get(i).isInitialized()) {
                    return false;
                }
            }
            if (((this.bitField0_ & 8) == 8) && !this.underlyingType_.isInitialized()) {
                return false;
            }
            if (((this.bitField0_ & 32) == 32) && !this.expandedType_.isInitialized()) {
                return false;
            }
            for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
                if (!this.annotation_.get(i2).isInitialized()) {
                    return false;
                }
            }
            return extensionsAreInitialized();
        }

        public Builder mergeFrom(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
            if (protoBuf$TypeAlias == ProtoBuf$TypeAlias.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$TypeAlias.bitField0_ & 1) == 1) {
                int i = protoBuf$TypeAlias.flags_;
                this.bitField0_ |= 1;
                this.flags_ = i;
            }
            if ((protoBuf$TypeAlias.bitField0_ & 2) == 2) {
                int i2 = protoBuf$TypeAlias.name_;
                this.bitField0_ = 2 | this.bitField0_;
                this.name_ = i2;
            }
            if (!protoBuf$TypeAlias.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$TypeAlias.typeParameter_;
                    this.bitField0_ &= -5;
                } else {
                    if ((this.bitField0_ & 4) != 4) {
                        this.typeParameter_ = new ArrayList(this.typeParameter_);
                        this.bitField0_ |= 4;
                    }
                    this.typeParameter_.addAll(protoBuf$TypeAlias.typeParameter_);
                }
            }
            if (protoBuf$TypeAlias.hasUnderlyingType()) {
                ProtoBuf$Type protoBuf$Type = protoBuf$TypeAlias.underlyingType_;
                if ((this.bitField0_ & 8) == 8) {
                    ProtoBuf$Type protoBuf$Type2 = this.underlyingType_;
                    if (protoBuf$Type2 != ProtoBuf$Type.defaultInstance) {
                        this.underlyingType_ = GeneratedOutlineSupport.outline90(protoBuf$Type2, protoBuf$Type);
                        this.bitField0_ |= 8;
                    }
                }
                this.underlyingType_ = protoBuf$Type;
                this.bitField0_ |= 8;
            }
            if ((protoBuf$TypeAlias.bitField0_ & 8) == 8) {
                int i3 = protoBuf$TypeAlias.underlyingTypeId_;
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = i3;
            }
            if (protoBuf$TypeAlias.hasExpandedType()) {
                ProtoBuf$Type protoBuf$Type3 = protoBuf$TypeAlias.expandedType_;
                if ((this.bitField0_ & 32) == 32) {
                    ProtoBuf$Type protoBuf$Type4 = this.expandedType_;
                    if (protoBuf$Type4 != ProtoBuf$Type.defaultInstance) {
                        this.expandedType_ = GeneratedOutlineSupport.outline90(protoBuf$Type4, protoBuf$Type3);
                        this.bitField0_ |= 32;
                    }
                }
                this.expandedType_ = protoBuf$Type3;
                this.bitField0_ |= 32;
            }
            if ((protoBuf$TypeAlias.bitField0_ & 32) != 32) {
                z = false;
            }
            if (z) {
                int i4 = protoBuf$TypeAlias.expandedTypeId_;
                this.bitField0_ |= 64;
                this.expandedTypeId_ = i4;
            }
            if (!protoBuf$TypeAlias.annotation_.isEmpty()) {
                if (this.annotation_.isEmpty()) {
                    this.annotation_ = protoBuf$TypeAlias.annotation_;
                    this.bitField0_ &= -129;
                } else {
                    if ((this.bitField0_ & 128) != 128) {
                        this.annotation_ = new ArrayList(this.annotation_);
                        this.bitField0_ |= 128;
                    }
                    this.annotation_.addAll(protoBuf$TypeAlias.annotation_);
                }
            }
            if (!protoBuf$TypeAlias.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$TypeAlias.versionRequirement_;
                    this.bitField0_ &= -257;
                } else {
                    if ((this.bitField0_ & 256) != 256) {
                        this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                        this.bitField0_ |= 256;
                    }
                    this.versionRequirement_.addAll(protoBuf$TypeAlias.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$TypeAlias);
            this.unknownFields = this.unknownFields.concat(protoBuf$TypeAlias.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m944getDefaultInstanceForType() {
            return ProtoBuf$TypeAlias.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m943clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$TypeAlias) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$TypeAlias protoBuf$TypeAlias;
            ProtoBuf$TypeAlias protoBuf$TypeAlias2 = null;
            try {
                ProtoBuf$TypeAlias protoBuf$TypeAlias3 = (ProtoBuf$TypeAlias) ProtoBuf$TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$TypeAlias3 != null) {
                    mergeFrom(protoBuf$TypeAlias3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$TypeAlias = (ProtoBuf$TypeAlias) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$TypeAlias2 = protoBuf$TypeAlias;
            }
            if (protoBuf$TypeAlias2 != null) {
                mergeFrom(protoBuf$TypeAlias2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias();
        defaultInstance = protoBuf$TypeAlias;
        protoBuf$TypeAlias.initFields();
    }

    public ProtoBuf$TypeAlias(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
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
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        }
        for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i3));
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
            i4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i5).intValue());
        }
        int size = this.unknownFields.size() + extensionsSerializedSize() + (this.versionRequirement_.size() * 2) + computeInt32Size + i4;
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasExpandedType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasUnderlyingType() {
        return (this.bitField0_ & 4) == 4;
    }

    public final void initFields() {
        this.flags_ = 6;
        this.name_ = 0;
        this.typeParameter_ = Collections.emptyList();
        ProtoBuf$Type protoBuf$Type = ProtoBuf$Type.defaultInstance;
        this.underlyingType_ = protoBuf$Type;
        this.underlyingTypeId_ = 0;
        this.expandedType_ = protoBuf$Type;
        this.expandedTypeId_ = 0;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
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
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            if (!this.typeParameter_.get(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (hasUnderlyingType() && !this.underlyingType_.isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        } else if (!hasExpandedType() || this.expandedType_.isInitialized()) {
            for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
                if (!this.annotation_.get(i2).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        } else {
            this.memoizedIsInitialized = 0;
            return false;
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
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(3, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.expandedTypeId_);
        }
        for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
            codedOutputStream.writeMessage(8, this.annotation_.get(i2));
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$TypeAlias() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
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
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Builder builder = null;
                switch (readTag) {
                    case 0:
                        z = true;
                        break;
                    case 8:
                        this.bitField0_ |= 1;
                        this.flags_ = codedInputStream.readRawVarint32();
                        break;
                    case 16:
                        this.bitField0_ |= 2;
                        this.name_ = codedInputStream.readRawVarint32();
                        break;
                    case 26:
                        if (!(z2 & true)) {
                            this.typeParameter_ = new ArrayList();
                            z2 |= true;
                        }
                        this.typeParameter_.add(codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                        break;
                    case 34:
                        builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                        this.underlyingType_ = protoBuf$Type;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type);
                            this.underlyingType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 4;
                        break;
                    case 40:
                        this.bitField0_ |= 8;
                        this.underlyingTypeId_ = codedInputStream.readRawVarint32();
                        break;
                    case 50:
                        builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                        this.expandedType_ = protoBuf$Type2;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type2);
                            this.expandedType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 16;
                        break;
                    case 56:
                        this.bitField0_ |= 32;
                        this.expandedTypeId_ = codedInputStream.readRawVarint32();
                        break;
                    case 66:
                        if (!(z2 & true)) {
                            this.annotation_ = new ArrayList();
                            z2 |= true;
                        }
                        this.annotation_.add(codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                        break;
                    case 248:
                        if (!(z2 & true)) {
                            this.versionRequirement_ = new ArrayList();
                            z2 |= true;
                        }
                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                        break;
                    case 250:
                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                            this.versionRequirement_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                        }
                        codedInputStream.currentLimit = pushLimit;
                        codedInputStream.recomputeBufferSizeAfterLimit();
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
                if (z2 & true) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if (z2 & true) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if (z2 & true) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
        if (z2 & true) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (z2 & true) {
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        }
        if (z2 & true) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
