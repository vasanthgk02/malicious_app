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

public final class ProtoBuf$Effect extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Effect> PARSER = new AbstractParser<ProtoBuf$Effect>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Effect(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Effect defaultInstance;
    public int bitField0_;
    public ProtoBuf$Expression conclusionOfConditionalEffect_;
    public List<ProtoBuf$Expression> effectConstructorArgument_;
    public EffectType effectType_;
    public InvocationKind kind_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public final ByteString unknownFields;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$Effect, Builder> implements Object {
        public int bitField0_;
        public ProtoBuf$Expression conclusionOfConditionalEffect_ = ProtoBuf$Expression.defaultInstance;
        public List<ProtoBuf$Expression> effectConstructorArgument_ = Collections.emptyList();
        public EffectType effectType_ = EffectType.RETURNS_CONSTANT;
        public InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

        public MessageLite build() {
            ProtoBuf$Effect buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Effect buildPartial() {
            ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(this, null);
            int i = this.bitField0_;
            int i2 = 1;
            if ((i & 1) != 1) {
                i2 = 0;
            }
            protoBuf$Effect.effectType_ = this.effectType_;
            if ((this.bitField0_ & 2) == 2) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                this.bitField0_ &= -3;
            }
            protoBuf$Effect.effectConstructorArgument_ = this.effectConstructorArgument_;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            protoBuf$Effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            protoBuf$Effect.kind_ = this.kind_;
            protoBuf$Effect.bitField0_ = i2;
            return protoBuf$Effect;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Effect.defaultInstance;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
                if (!this.effectConstructorArgument_.get(i).isInitialized()) {
                    return false;
                }
            }
            if (!((this.bitField0_ & 4) == 4) || this.conclusionOfConditionalEffect_.isInitialized()) {
                return true;
            }
            return false;
        }

        public Builder mergeFrom(ProtoBuf$Effect protoBuf$Effect) {
            if (protoBuf$Effect == ProtoBuf$Effect.defaultInstance) {
                return this;
            }
            boolean z = true;
            if ((protoBuf$Effect.bitField0_ & 1) == 1) {
                EffectType effectType = protoBuf$Effect.effectType_;
                if (effectType != null) {
                    this.bitField0_ |= 1;
                    this.effectType_ = effectType;
                } else {
                    throw null;
                }
            }
            if (!protoBuf$Effect.effectConstructorArgument_.isEmpty()) {
                if (this.effectConstructorArgument_.isEmpty()) {
                    this.effectConstructorArgument_ = protoBuf$Effect.effectConstructorArgument_;
                    this.bitField0_ &= -3;
                } else {
                    if ((this.bitField0_ & 2) != 2) {
                        this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                        this.bitField0_ |= 2;
                    }
                    this.effectConstructorArgument_.addAll(protoBuf$Effect.effectConstructorArgument_);
                }
            }
            if ((protoBuf$Effect.bitField0_ & 2) == 2) {
                ProtoBuf$Expression protoBuf$Expression = protoBuf$Effect.conclusionOfConditionalEffect_;
                if ((this.bitField0_ & 4) == 4) {
                    ProtoBuf$Expression protoBuf$Expression2 = this.conclusionOfConditionalEffect_;
                    if (protoBuf$Expression2 != ProtoBuf$Expression.defaultInstance) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.Builder builder = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.Builder();
                        builder.mergeFrom(protoBuf$Expression2);
                        builder.mergeFrom(protoBuf$Expression);
                        this.conclusionOfConditionalEffect_ = builder.buildPartial();
                        this.bitField0_ |= 4;
                    }
                }
                this.conclusionOfConditionalEffect_ = protoBuf$Expression;
                this.bitField0_ |= 4;
            }
            if ((protoBuf$Effect.bitField0_ & 4) != 4) {
                z = false;
            }
            if (z) {
                InvocationKind invocationKind = protoBuf$Effect.kind_;
                if (invocationKind != null) {
                    this.bitField0_ |= 8;
                    this.kind_ = invocationKind;
                } else {
                    throw null;
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$Effect.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m920getDefaultInstanceForType() {
            return ProtoBuf$Effect.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m919clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Effect) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Effect protoBuf$Effect;
            ProtoBuf$Effect protoBuf$Effect2 = null;
            try {
                ProtoBuf$Effect protoBuf$Effect3 = (ProtoBuf$Effect) ProtoBuf$Effect.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Effect3 != null) {
                    mergeFrom(protoBuf$Effect3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Effect = (ProtoBuf$Effect) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Effect2 = protoBuf$Effect;
            }
            if (protoBuf$Effect2 != null) {
                mergeFrom(protoBuf$Effect2);
            }
            throw th;
        }
    }

    public enum EffectType implements EnumLite {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);
        
        public static EnumLiteMap<EffectType> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<EffectType>() {
                public EnumLite findValueByNumber(int i) {
                    return EffectType.valueOf(i);
                }
            };
        }

        /* access modifiers changed from: public */
        EffectType(int i, int i2) {
            this.value = i2;
        }

        public final int getNumber() {
            return this.value;
        }

        public static EffectType valueOf(int i) {
            if (i == 0) {
                return RETURNS_CONSTANT;
            }
            if (i == 1) {
                return CALLS;
            }
            if (i != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }
    }

    public enum InvocationKind implements EnumLite {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);
        
        public static EnumLiteMap<InvocationKind> internalValueMap;
        public final int value;

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<InvocationKind>() {
                public EnumLite findValueByNumber(int i) {
                    return InvocationKind.valueOf(i);
                }
            };
        }

        /* access modifiers changed from: public */
        InvocationKind(int i, int i2) {
            this.value = i2;
        }

        public final int getNumber() {
            return this.value;
        }

        public static InvocationKind valueOf(int i) {
            if (i == 0) {
                return AT_MOST_ONCE;
            }
            if (i == 1) {
                return EXACTLY_ONCE;
            }
            if (i != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }
    }

    static {
        ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect();
        defaultInstance = protoBuf$Effect;
        protoBuf$Effect.effectType_ = EffectType.RETURNS_CONSTANT;
        protoBuf$Effect.effectConstructorArgument_ = Collections.emptyList();
        protoBuf$Effect.conclusionOfConditionalEffect_ = ProtoBuf$Expression.defaultInstance;
        protoBuf$Effect.kind_ = InvocationKind.AT_MOST_ONCE;
    }

    public ProtoBuf$Effect(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
        int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0 : 0;
        for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
            computeEnumSize += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i2));
        }
        if ((this.bitField0_ & 2) == 2) {
            computeEnumSize += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeEnumSize += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        }
        int size = this.unknownFields.size() + computeEnumSize;
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
        for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
            if (!this.effectConstructorArgument_.get(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        if (!((this.bitField0_ & 2) == 2) || this.conclusionOfConditionalEffect_.isInitialized()) {
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
            codedOutputStream.writeEnum(1, this.effectType_.getNumber());
        }
        for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(4, this.kind_.getNumber());
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Effect() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$Effect(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.effectType_ = EffectType.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = ProtoBuf$Expression.defaultInstance;
        this.kind_ = InvocationKind.AT_MOST_ONCE;
        Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                int readTag = codedInputStream.readTag();
                if (readTag != 0) {
                    if (readTag == 8) {
                        int readRawVarint32 = codedInputStream.readRawVarint32();
                        EffectType valueOf = EffectType.valueOf(readRawVarint32);
                        if (valueOf == null) {
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readRawVarint32);
                        } else {
                            this.bitField0_ |= 1;
                            this.effectType_ = valueOf;
                        }
                    } else if (readTag == 18) {
                        if (!(z2 & true)) {
                            this.effectConstructorArgument_ = new ArrayList();
                            z2 |= true;
                        }
                        this.effectConstructorArgument_.add(codedInputStream.readMessage(ProtoBuf$Expression.PARSER, extensionRegistryLite));
                    } else if (readTag == 26) {
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.Builder builder = null;
                        if ((this.bitField0_ & 2) == 2) {
                            ProtoBuf$Expression protoBuf$Expression = this.conclusionOfConditionalEffect_;
                            if (protoBuf$Expression != null) {
                                builder = new kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.Builder();
                                builder.mergeFrom(protoBuf$Expression);
                            } else {
                                throw null;
                            }
                        }
                        ProtoBuf$Expression protoBuf$Expression2 = (ProtoBuf$Expression) codedInputStream.readMessage(ProtoBuf$Expression.PARSER, extensionRegistryLite);
                        this.conclusionOfConditionalEffect_ = protoBuf$Expression2;
                        if (builder != null) {
                            builder.mergeFrom(protoBuf$Expression2);
                            this.conclusionOfConditionalEffect_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 2;
                    } else if (readTag == 32) {
                        int readRawVarint322 = codedInputStream.readRawVarint32();
                        InvocationKind valueOf2 = InvocationKind.valueOf(readRawVarint322);
                        if (valueOf2 == null) {
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readRawVarint322);
                        } else {
                            this.bitField0_ |= 4;
                            this.kind_ = valueOf2;
                        }
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
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
