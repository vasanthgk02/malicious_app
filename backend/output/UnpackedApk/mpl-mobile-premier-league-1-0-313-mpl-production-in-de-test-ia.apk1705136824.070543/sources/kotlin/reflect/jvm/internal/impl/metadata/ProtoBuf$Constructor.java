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
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Constructor extends ExtendableMessage<ProtoBuf$Constructor> implements Object {
    public static Parser<ProtoBuf$Constructor> PARSER = new AbstractParser<ProtoBuf$Constructor>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Constructor(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Constructor defaultInstance;
    public int bitField0_;
    public int flags_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public final ByteString unknownFields;
    public List<ProtoBuf$ValueParameter> valueParameter_;
    public List<Integer> versionRequirement_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$Constructor, Builder> implements Object {
        public int bitField0_;
        public int flags_ = 6;
        public List<ProtoBuf$ValueParameter> valueParameter_ = Collections.emptyList();
        public List<Integer> versionRequirement_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$Constructor buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Constructor buildPartial() {
            ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor(this, null);
            int i = 1;
            if ((this.bitField0_ & 1) != 1) {
                i = 0;
            }
            protoBuf$Constructor.flags_ = this.flags_;
            if ((this.bitField0_ & 2) == 2) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -3;
            }
            protoBuf$Constructor.valueParameter_ = this.valueParameter_;
            if ((this.bitField0_ & 4) == 4) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -5;
            }
            protoBuf$Constructor.versionRequirement_ = this.versionRequirement_;
            protoBuf$Constructor.bitField0_ = i;
            return protoBuf$Constructor;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Constructor.defaultInstance;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < this.valueParameter_.size(); i++) {
                if (!this.valueParameter_.get(i).isInitialized()) {
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                return false;
            }
            return true;
        }

        public Builder mergeFrom(ProtoBuf$Constructor protoBuf$Constructor) {
            if (protoBuf$Constructor == ProtoBuf$Constructor.defaultInstance) {
                return this;
            }
            if ((protoBuf$Constructor.bitField0_ & 1) == 1) {
                int i = protoBuf$Constructor.flags_;
                this.bitField0_ = 1 | this.bitField0_;
                this.flags_ = i;
            }
            if (!protoBuf$Constructor.valueParameter_.isEmpty()) {
                if (this.valueParameter_.isEmpty()) {
                    this.valueParameter_ = protoBuf$Constructor.valueParameter_;
                    this.bitField0_ &= -3;
                } else {
                    if ((this.bitField0_ & 2) != 2) {
                        this.valueParameter_ = new ArrayList(this.valueParameter_);
                        this.bitField0_ |= 2;
                    }
                    this.valueParameter_.addAll(protoBuf$Constructor.valueParameter_);
                }
            }
            if (!protoBuf$Constructor.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Constructor.versionRequirement_;
                    this.bitField0_ &= -5;
                } else {
                    if ((this.bitField0_ & 4) != 4) {
                        this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                        this.bitField0_ |= 4;
                    }
                    this.versionRequirement_.addAll(protoBuf$Constructor.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$Constructor);
            this.unknownFields = this.unknownFields.concat(protoBuf$Constructor.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m916getDefaultInstanceForType() {
            return ProtoBuf$Constructor.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m915clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Constructor) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Constructor protoBuf$Constructor;
            ProtoBuf$Constructor protoBuf$Constructor2 = null;
            try {
                ProtoBuf$Constructor protoBuf$Constructor3 = (ProtoBuf$Constructor) ProtoBuf$Constructor.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Constructor3 != null) {
                    mergeFrom(protoBuf$Constructor3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Constructor = (ProtoBuf$Constructor) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Constructor2 = protoBuf$Constructor;
            }
            if (protoBuf$Constructor2 != null) {
                mergeFrom(protoBuf$Constructor2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor();
        defaultInstance = protoBuf$Constructor;
        protoBuf$Constructor.flags_ = 6;
        protoBuf$Constructor.valueParameter_ = Collections.emptyList();
        protoBuf$Constructor.versionRequirement_ = Collections.emptyList();
    }

    public ProtoBuf$Constructor(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
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
        for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i2));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            i3 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
        }
        int size = this.unknownFields.size() + extensionsSerializedSize() + (this.versionRequirement_.size() * 2) + computeInt32Size + i3;
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
        for (int i = 0; i < this.valueParameter_.size(); i++) {
            if (!this.valueParameter_.get(i).isInitialized()) {
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
        for (int i = 0; i < this.valueParameter_.size(); i++) {
            codedOutputStream.writeMessage(2, this.valueParameter_.get(i));
        }
        for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i2).intValue());
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Constructor() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$Constructor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.flags_ = 6;
        this.valueParameter_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
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
                        this.flags_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 18) {
                        if (!(z2 & true)) {
                            this.valueParameter_ = new ArrayList();
                            z2 |= true;
                        }
                        this.valueParameter_.add(codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite));
                    } else if (readTag == 248) {
                        if (!(z2 & true)) {
                            this.versionRequirement_ = new ArrayList();
                            z2 |= true;
                        }
                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                    } else if (readTag == 250) {
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
                    } else if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
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
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
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
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
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
