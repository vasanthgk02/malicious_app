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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

public final class ProtoBuf$Contract extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Contract> PARSER = new AbstractParser<ProtoBuf$Contract>() {
        public Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ProtoBuf$Contract(codedInputStream, extensionRegistryLite, null);
        }
    };
    public static final ProtoBuf$Contract defaultInstance;
    public List<ProtoBuf$Effect> effect_;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public final ByteString unknownFields;

    public static final class Builder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<ProtoBuf$Contract, Builder> implements Object {
        public int bitField0_;
        public List<ProtoBuf$Effect> effect_ = Collections.emptyList();

        public MessageLite build() {
            ProtoBuf$Contract buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public ProtoBuf$Contract buildPartial() {
            ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(this, null);
            if ((this.bitField0_ & 1) == 1) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
                this.bitField0_ &= -2;
            }
            protoBuf$Contract.effect_ = this.effect_;
            return protoBuf$Contract;
        }

        public Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public GeneratedMessageLite getDefaultInstanceForType() {
            return ProtoBuf$Contract.defaultInstance;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < this.effect_.size(); i++) {
                if (!this.effect_.get(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public Builder mergeFrom(ProtoBuf$Contract protoBuf$Contract) {
            if (protoBuf$Contract == ProtoBuf$Contract.defaultInstance) {
                return this;
            }
            if (!protoBuf$Contract.effect_.isEmpty()) {
                if (this.effect_.isEmpty()) {
                    this.effect_ = protoBuf$Contract.effect_;
                    this.bitField0_ &= -2;
                } else {
                    if ((this.bitField0_ & 1) != 1) {
                        this.effect_ = new ArrayList(this.effect_);
                        this.bitField0_ |= 1;
                    }
                    this.effect_.addAll(protoBuf$Contract.effect_);
                }
            }
            this.unknownFields = this.unknownFields.concat(protoBuf$Contract.unknownFields);
            return this;
        }

        /* renamed from: getDefaultInstanceForType  reason: collision with other method in class */
        public MessageLite m918getDefaultInstanceForType() {
            return ProtoBuf$Contract.defaultInstance;
        }

        /* renamed from: clone  reason: collision with other method in class */
        public kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder m917clone() {
            Builder builder = new Builder();
            builder.mergeFrom(buildPartial());
            return builder;
        }

        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
            mergeFrom((ProtoBuf$Contract) generatedMessageLite);
            return this;
        }

        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            ProtoBuf$Contract protoBuf$Contract;
            ProtoBuf$Contract protoBuf$Contract2 = null;
            try {
                ProtoBuf$Contract protoBuf$Contract3 = (ProtoBuf$Contract) ProtoBuf$Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (protoBuf$Contract3 != null) {
                    mergeFrom(protoBuf$Contract3);
                }
                return this;
            } catch (InvalidProtocolBufferException e2) {
                protoBuf$Contract = (ProtoBuf$Contract) e2.unfinishedMessage;
                throw e2;
            } catch (Throwable th) {
                th = th;
                protoBuf$Contract2 = protoBuf$Contract;
            }
            if (protoBuf$Contract2 != null) {
                mergeFrom(protoBuf$Contract2);
            }
            throw th;
        }
    }

    static {
        ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract();
        defaultInstance = protoBuf$Contract;
        protoBuf$Contract.effect_ = Collections.emptyList();
    }

    public ProtoBuf$Contract(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder builder, ProtoBuf$1 protoBuf$1) {
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
        for (int i3 = 0; i3 < this.effect_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.effect_.get(i3));
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
        for (int i = 0; i < this.effect_.size(); i++) {
            if (!this.effect_.get(i).isInitialized()) {
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
        for (int i = 0; i < this.effect_.size(); i++) {
            codedOutputStream.writeMessage(1, this.effect_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public ProtoBuf$Contract() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public ProtoBuf$Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, ProtoBuf$1 protoBuf$1) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.effect_ = Collections.emptyList();
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
                            this.effect_ = new ArrayList();
                            z2 |= true;
                        }
                        this.effect_.add(codedInputStream.readMessage(ProtoBuf$Effect.PARSER, extensionRegistryLite));
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
                    this.effect_ = Collections.unmodifiableList(this.effect_);
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
            this.effect_ = Collections.unmodifiableList(this.effect_);
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
