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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Expression extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Expression> PARSER = new AbstractParser<ProtoBuf$Expression>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Expression(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Expression defaultInstance;
    public List<ProtoBuf$Expression> andArgument_;
    public int bitField0_;
    public ConstantValue constantValue_;
    public int flags_;
    public int isInstanceTypeId_;
    public ProtoBuf$Type isInstanceType_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public List<ProtoBuf$Expression> orArgument_;
    public final ByteString unknownFields;
    public int valueParameterReference_;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$Expression, Builder> implements Object {
        public List<ProtoBuf$Expression> andArgument_ = Collections.emptyList();
        public int bitField0_;
        public ConstantValue constantValue_ = ConstantValue.TRUE;
        public int flags_;
        public int isInstanceTypeId_;
        public ProtoBuf$Type isInstanceType_ = ProtoBuf$Type.defaultInstance;
        public List<ProtoBuf$Expression> orArgument_ = Collections.emptyList();
        public int valueParameterReference_;

        public MessageLite build() {
            ProtoBuf$Expression buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Expression buildPartial() {
            ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Expression.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Expression.valueParameterReference_ = this.valueParameterReference_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Expression.constantValue_ = this.constantValue_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Expression.isInstanceType_ = this.isInstanceType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Expression.isInstanceTypeId_ = this.isInstanceTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                this.bitField0_ &= -33;
            }
            protoBuf$Expression.andArgument_ = this.andArgument_;
            if ((this.bitField0_ & 64) == 64) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                this.bitField0_ &= -65;
            }
            protoBuf$Expression.orArgument_ = this.orArgument_;
            protoBuf$Expression.bitField0_ = i2;
            return protoBuf$Expression;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Expression.defaultInstance;
        }

        public final boolean isInitialized() {
            if (((this.bitField0_ & 8) == 8) && !this.isInstanceType_.isInitialized()) {
                return false;
            }
            for (int i = 0; i < this.andArgument_.size(); i++) {
                if (!this.andArgument_.get(i).isInitialized()) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
                if (!this.orArgument_.get(i2).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Builder mergeFrom(ProtoBuf$Expression protoBuf$Expression) {
            if (protoBuf$Expression == ProtoBuf$Expression.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$Expression.bitField0_ & 1) == 1) {
                int i = protoBuf$Expression.flags_;
                this.bitField0_ |= 1;
                this.flags_ = i;
            }
            if ((protoBuf$Expression.bitField0_ & 2) == 2) {
                int i2 = protoBuf$Expression.valueParameterReference_;
                this.bitField0_ = 2 | this.bitField0_;
                this.valueParameterReference_ = i2;
            }
            if ((protoBuf$Expression.bitField0_ & 4) == 4) {
                ConstantValue constantValue = protoBuf$Expression.constantValue_;
                if (constantValue != null) {
                    this.bitField0_ = 4 | this.bitField0_;
                    this.constantValue_ = constantValue;
                } else {
                    throw null;
                }
            }
            if ((protoBuf$Expression.bitField0_ & 8) == 8) {
                ProtoBuf$Type protoBuf$Type = protoBuf$Expression.isInstanceType_;
                if ((this.bitField0_ & 8) == 8) {
                    ProtoBuf$Type protoBuf$Type2 = this.isInstanceType_;
                    if (protoBuf$Type2 != ProtoBuf$Type.defaultInstance) {
                        this.isInstanceType_ = GeneratedOutlineSupport.outline90(protoBuf$Type2, protoBuf$Type);
                        this.bitField0_ |= 8;
                    }
                }
                this.isInstanceType_ = protoBuf$Type;
                this.bitField0_ |= 8;
            }
            if ((protoBuf$Expression.bitField0_ & 16) != 16) {
                z = false;
            }
            if (z) {
                int i3 = protoBuf$Expression.isInstanceTypeId_;
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = i3;
            }
            if (!protoBuf$Expression.andArgument_.isEmpty()) {
                if (this.andArgument_.isEmpty()) {
                    this.andArgument_ = protoBuf$Expression.andArgument_;
                    this.bitField0_ &= -33;
                } else {
                    if ((this.bitField0_ & 32) != 32) {
                        this.andArgument_ = new ArrayList(this.andArgument_);
                        this.bitField0_ |= 32;
                    }
                    this.andArgument_.addAll(protoBuf$Expression.andArgument_);
                }
            }
            if (!protoBuf$Expression.orArgument_.isEmpty()) {
                if (this.orArgument_.isEmpty()) {
                    this.orArgument_ = protoBuf$Expression.orArgument_;
                    this.bitField0_ &= -65;
                } else {
                    if ((this.bitField0_ & 64) != 64) {
                        this.orArgument_ = new ArrayList(this.orArgument_);
                        this.bitField0_ |= 64;
                    }
                    this.orArgument_.addAll(protoBuf$Expression.orArgument_);
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$Expression.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m924getDefaultInstanceForType() {
            return ProtoBuf$Expression.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m923clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Expression) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Expression protoBuf$Expression;
            ProtoBuf$Expression protoBuf$Expression2 = null;
            try {
                ProtoBuf$Expression protoBuf$Expression3 = (ProtoBuf$Expression) ProtoBuf$Expression.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Expression3 != null) {
                    mergeFrom(protoBuf$Expression3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Expression = (ProtoBuf$Expression) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Expression2 = protoBuf$Expression;
            }
            if (protoBuf$Expression2 != null) {
                mergeFrom(protoBuf$Expression2);
            }
            throw th;
        }
    }

    public enum ConstantValue implements EnumLite {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);
        
        public static EnumLiteMap<ConstantValue> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<ConstantValue>() {
                public EnumLite findValueByNumber(int i) {
                    return ConstantValue.valueOf(i);
                }
            };
        }

        /* access modifiers changed from: public */
        ConstantValue(int i, int i2) {
            this.value = i2;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ConstantValue valueOf(int i) {
            if (i == 0) {
                return TRUE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return NULL;
        }
    }

    static {
        ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression();
        defaultInstance = protoBuf$Expression;
        protoBuf$Expression.initFields();
    }

    public ProtoBuf$Expression(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        }
        for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
        }
        for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i3));
        }
        int size = this.unknownFields.size() + computeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public final void initFields() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = ConstantValue.TRUE;
        this.isInstanceType_ = ProtoBuf$Type.defaultInstance;
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
    }

    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!((this.bitField0_ & 8) == 8) || this.isInstanceType_.isInitialized()) {
            for (int i = 0; i < this.andArgument_.size(); i++) {
                if (!this.andArgument_.get(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
                if (!this.orArgument_.get(i2).isInitialized()) {
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
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
        }
        for (int i = 0; i < this.andArgument_.size(); i++) {
            codedOutputStream.writeMessage(6, this.andArgument_.get(i));
        }
        for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
            codedOutputStream.writeMessage(7, this.orArgument_.get(i2));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Expression() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$Expression(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
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
                        this.flags_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 16) {
                        this.bitField0_ |= 2;
                        this.valueParameterReference_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 24) {
                        int readRawVarint32 = codedInputStream.readRawVarint32();
                        ConstantValue valueOf = ConstantValue.valueOf(readRawVarint32);
                        if (valueOf == null) {
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readRawVarint32);
                        } else {
                            this.bitField0_ |= 4;
                            this.constantValue_ = valueOf;
                        }
                    } else if (readTag == 34) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Builder builder = null;
                        builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : builder;
                        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                        this.isInstanceType_ = protoBuf$Type;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Type);
                            this.isInstanceType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 8;
                    } else if (readTag == 40) {
                        this.bitField0_ |= 16;
                        this.isInstanceTypeId_ = codedInputStream.readRawVarint32();
                    } else if (readTag == 50) {
                        if (!(z2 & true)) {
                            this.andArgument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.andArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                    } else if (readTag == 58) {
                        if (!(z2 & true)) {
                            this.orArgument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.orArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
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
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                }
                if (z2 & true) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if (z2 & true) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
