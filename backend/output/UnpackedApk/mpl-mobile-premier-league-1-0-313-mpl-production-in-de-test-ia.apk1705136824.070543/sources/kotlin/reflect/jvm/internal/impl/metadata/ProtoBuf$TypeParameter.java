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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$TypeParameter extends ExtendableMessage<ProtoBuf$TypeParameter> implements Object {
    public static Parser<ProtoBuf$TypeParameter> PARSER = new AbstractParser<ProtoBuf$TypeParameter>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeParameter(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$TypeParameter defaultInstance;
    public int bitField0_;
    public int id_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public int name_;
    public boolean reified_;
    public final ByteString unknownFields;
    public int upperBoundIdMemoizedSerializedSize;
    public List<Integer> upperBoundId_;
    public List<ProtoBuf$Type> upperBound_;
    public Variance variance_;

    public static final class Builder extends ExtendableBuilder<ProtoBuf$TypeParameter, Builder> implements Object {
        public int bitField0_;
        public int id_;
        public int name_;
        public boolean reified_;
        public List<Integer> upperBoundId_ = Collections.emptyList();
        public List<ProtoBuf$Type> upperBound_ = Collections.emptyList();
        public Variance variance_ = Variance.INV;

        public MessageLite build() {
            ProtoBuf$TypeParameter buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$TypeParameter buildPartial() {
            ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$TypeParameter.id_ = this.id_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$TypeParameter.name_ = this.name_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$TypeParameter.reified_ = this.reified_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$TypeParameter.variance_ = this.variance_;
            if ((this.bitField0_ & 16) == 16) {
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                this.bitField0_ &= -17;
            }
            protoBuf$TypeParameter.upperBound_ = this.upperBound_;
            if ((this.bitField0_ & 32) == 32) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                this.bitField0_ &= -33;
            }
            protoBuf$TypeParameter.upperBoundId_ = this.upperBoundId_;
            protoBuf$TypeParameter.bitField0_ = i2;
            return protoBuf$TypeParameter;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$TypeParameter.defaultInstance;
        }

        public final boolean isInitialized() {
            if (!((this.bitField0_ & 1) == 1)) {
                return false;
            }
            if (!((this.bitField0_ & 2) == 2)) {
                return false;
            }
            for (int i = 0; i < this.upperBound_.size(); i++) {
                if (!this.upperBound_.get(i).isInitialized()) {
                    return false;
                }
            }
            return extensionsAreInitialized();
        }

        public Builder mergeFrom(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
            if (protoBuf$TypeParameter == ProtoBuf$TypeParameter.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$TypeParameter.bitField0_ & 1) == 1) {
                int i = protoBuf$TypeParameter.id_;
                this.bitField0_ |= 1;
                this.id_ = i;
            }
            if ((protoBuf$TypeParameter.bitField0_ & 2) == 2) {
                int i2 = protoBuf$TypeParameter.name_;
                this.bitField0_ = 2 | this.bitField0_;
                this.name_ = i2;
            }
            if ((protoBuf$TypeParameter.bitField0_ & 4) == 4) {
                boolean z2 = protoBuf$TypeParameter.reified_;
                this.bitField0_ = 4 | this.bitField0_;
                this.reified_ = z2;
            }
            if ((protoBuf$TypeParameter.bitField0_ & 8) != 8) {
                z = false;
            }
            if (z) {
                Variance variance = protoBuf$TypeParameter.variance_;
                if (variance != null) {
                    this.bitField0_ |= 8;
                    this.variance_ = variance;
                } else {
                    throw null;
                }
            }
            if (!protoBuf$TypeParameter.upperBound_.isEmpty()) {
                if (this.upperBound_.isEmpty()) {
                    this.upperBound_ = protoBuf$TypeParameter.upperBound_;
                    this.bitField0_ &= -17;
                } else {
                    if ((this.bitField0_ & 16) != 16) {
                        this.upperBound_ = new ArrayList(this.upperBound_);
                        this.bitField0_ |= 16;
                    }
                    this.upperBound_.addAll(protoBuf$TypeParameter.upperBound_);
                }
            }
            if (!protoBuf$TypeParameter.upperBoundId_.isEmpty()) {
                if (this.upperBoundId_.isEmpty()) {
                    this.upperBoundId_ = protoBuf$TypeParameter.upperBoundId_;
                    this.bitField0_ &= -33;
                } else {
                    if ((this.bitField0_ & 32) != 32) {
                        this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                        this.bitField0_ |= 32;
                    }
                    this.upperBoundId_.addAll(protoBuf$TypeParameter.upperBoundId_);
                }
            }
            mergeExtensionFields(protoBuf$TypeParameter);
            this.unknownFields = this.unknownFields.concat(protoBuf$TypeParameter.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m946getDefaultInstanceForType() {
            return ProtoBuf$TypeParameter.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m945clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$TypeParameter) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$TypeParameter protoBuf$TypeParameter;
            ProtoBuf$TypeParameter protoBuf$TypeParameter2 = null;
            try {
                ProtoBuf$TypeParameter protoBuf$TypeParameter3 = (ProtoBuf$TypeParameter) ProtoBuf$TypeParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$TypeParameter3 != null) {
                    mergeFrom(protoBuf$TypeParameter3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$TypeParameter = (ProtoBuf$TypeParameter) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$TypeParameter2 = protoBuf$TypeParameter;
            }
            if (protoBuf$TypeParameter2 != null) {
                mergeFrom(protoBuf$TypeParameter2);
            }
            throw th;
        }
    }

    public enum Variance implements EnumLite {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);
        
        public static EnumLiteMap<Variance> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<Variance>() {
                public EnumLite findValueByNumber(int i) {
                    return Variance.valueOf(i);
                }
            };
        }

        /* access modifiers changed from: public */
        Variance(int i, int i2) {
            this.value = i2;
        }

        public final int getNumber() {
            return this.value;
        }

        public static Variance valueOf(int i) {
            if (i == 0) {
                return IN;
            }
            if (i == 1) {
                return OUT;
            }
            if (i != 2) {
                return null;
            }
            return INV;
        }
    }

    static {
        ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter();
        defaultInstance = protoBuf$TypeParameter;
        protoBuf$TypeParameter.initFields();
    }

    public ProtoBuf$TypeParameter(ExtendableBuilder extendableBuilder, ProtoBuf$1 protoBuf$1) {
        super(extendableBuilder);
        this.upperBoundIdMemoizedSerializedSize = -1;
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
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeTagSize(3) + 1;
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        }
        for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i2));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.upperBoundId_.size(); i4++) {
            i3 += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i4).intValue());
        }
        int i5 = computeInt32Size + i3;
        if (!this.upperBoundId_.isEmpty()) {
            i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(i3);
        }
        this.upperBoundIdMemoizedSerializedSize = i3;
        int size = this.unknownFields.size() + extensionsSerializedSize() + i5;
        this.memoizedSerializedSize = size;
        return size;
    }

    public final void initFields() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = Variance.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
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
        }
        for (int i = 0; i < this.upperBound_.size(); i++) {
            if (!this.upperBound_.get(i).isInitialized()) {
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
            codedOutputStream.writeInt32(1, this.id_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            boolean z = this.reified_;
            codedOutputStream.writeRawVarint32(24);
            codedOutputStream.writeRawByte(z ? 1 : 0);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeEnum(4, this.variance_.getNumber());
        }
        for (int i = 0; i < this.upperBound_.size(); i++) {
            codedOutputStream.writeMessage(5, this.upperBound_.get(i));
        }
        if (this.upperBoundId_.size() > 0) {
            codedOutputStream.writeRawVarint32(50);
            codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        }
        for (int i2 = 0; i2 < this.upperBoundId_.size(); i2++) {
            codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i2).intValue());
        }
        newExtensionWriter.writeUntil(1000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$TypeParameter() {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$TypeParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.upperBoundIdMemoizedSerializedSize = -1;
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
                        this.id_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 16) {
                        this.bitField0_ |= 2;
                        this.name_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 24) {
                        this.bitField0_ |= 4;
                        this.reified_ = codedInputStream.readBool();
                    } else if (readTag == 32) {
                        int readRawVarint32 = codedInputStream.readRawVarint32();
                        Variance valueOf = Variance.valueOf(readRawVarint32);
                        if (valueOf == null) {
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readRawVarint32);
                        } else {
                            this.bitField0_ |= 8;
                            this.variance_ = valueOf;
                        }
                    } else if (readTag == 42) {
                        if (!(z2 & true)) {
                            this.upperBound_ = new ArrayList();
                            z2 |= true;
                        }
                        this.upperBound_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                    } else if (readTag == 48) {
                        if (!(z2 & true)) {
                            this.upperBoundId_ = new ArrayList();
                            z2 |= true;
                        }
                        this.upperBoundId_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
                    } else if (readTag == 50) {
                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if (!(z2 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                            this.upperBoundId_ = new ArrayList();
                            z2 |= true;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.upperBoundId_.add(Integer.valueOf(codedInputStream.readRawVarint32()));
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
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if (z2 & true) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        }
        if (z2 & true) {
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
